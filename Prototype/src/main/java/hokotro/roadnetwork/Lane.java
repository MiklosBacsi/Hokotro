package hokotro.roadnetwork;

import java.util.ArrayList;
import java.util.List;

import hokotro.util.ILogable;
import hokotro.Prototype;
import hokotro.head.Head;
import hokotro.util.Logger;
import hokotro.vehicle.Vehicle;
import hokotro.vehicle.VehicleState;

/**
 * Kezeli az összecsúszásokat és utóhatásaikat.
 */
public class Lane implements ILogable, ICleanable {
    private Road road;
    private List<Crossing> crossings; // index 0 a origin, index 1 a end
    private List<Vehicle> vehicles;
    private boolean isPassable;
    private SurfaceCondition condition;

    /**
     * a sávra érkező járműveket kezeli, lépteti a már rajta lévőket.
     */
    public void handleTraffic(){
        if (condition.getSnowThickness() > 40) {
            for (Vehicle vehicle : vehicles) {
                vehicle.stuck();
            }
        }

        if (condition.getIceThickness() > condition.getRockHeight()) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getState() != VehicleState.CANTSLIDE) {
                    vehicle.setState(VehicleState.SLIDE);
                }
            }
        } else {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getState() != VehicleState.CANTSLIDE) {
                    vehicle.setState(VehicleState.NORMAL);
                }
            }
        }

        int slidingCounter = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getState() == VehicleState.SLIDE) {
                slidingCounter++;
            }
        }

        if (slidingCounter > 1) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getState() == VehicleState.SLIDE) {
                    vehicle.crash(road.getLength() - vehicle.getLanePosition());
                }
            }
        }
    }

    public void clean(Head head){
        head.applyEffect(this);
    }

    /**
     * Hozzáad egy járművet a vehicle listához.
     * @param vehicle a hozzáadandó jármű
     */
    public void addVehicle(Vehicle vehicle){
        condition.increaseDriveCount();
        vehicles.add(vehicle);
    }

    /**
     * A sávról lelépő járművet eltávolítja a vehicles listából.
     * @param vehicle a eltávolítandó jármű
     */
    public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
    }

    /**
     * Visszaadja a sáv állapotát.
     * @return a sáv állapota
     */
    public SurfaceCondition getSurfaceCondition(){
        return condition;
    }

    /**
     * Visszaadja a sávhoz tartozó út hosszát.
     * @return a sávhoz tartozó út hossza
     */
    public int getRoadLength(){
        return road.getLength();
    }

    public Road getRoad(){
        return road;
    }

    public List<Crossing> getCrossings() {
        return crossings;
    }

    public boolean getIsPassable() {
        return isPassable;
    }

    public void addSnow(int amount) {
        // TODO: Implement
    }

    public void addSalt(int amount) {
        // TODO: Implement
    }

    public void addRock() {
        // TODO: Implement
    }

    public void reduceSnow(int amount) {
        // TODO: Implement
    }

    public void reduceIce(int amount) {
        // TODO: Implement
    }

    public void letItSnow(int amount) {
        condition.addSnowThickness(amount);
    }

    @Override
    public String toString() {
        try {
            return "lane: " + Prototype.getId(this) +
                " | start: " + Prototype.getId(crossings.getFirst()) +
                " | end: " + Prototype.getId(crossings.getLast()) +
                " | road: " + Prototype.getId(road)
            ;
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void log(boolean verbose) {
        try {
            if (!verbose) {
                Logger.logOK(this.toString());
            } else {
                Logger.logOK(
                    this +
                    " | passable: " + isPassable +
                    " | " + condition +
                    " | vehicles: " + Logger.buildStringFromCollection(vehicles, '[', ']', ";")
                );
            }
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
