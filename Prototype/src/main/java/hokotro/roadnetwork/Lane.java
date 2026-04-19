package hokotro.roadnetwork;

import java.util.List;

import hokotro.util.ILogable;
import hokotro.Prototype;
import hokotro.util.Logger;
import hokotro.vehicle.Vehicle;

/**
 * Kezeli az összecsúszásokat és utóhatásaikat.
 */
public class Lane implements ILogable {
    private Road road;
    private List<Crossing> crossings;
    private List<Vehicle> vehicles;
    private boolean isPassable;
    private SurfaceCondition condition;

    /**
     * a sávra érkező járműveket kezeli, lépteti a már rajta lévőket.
     */
    public void handleTraffic(){
        System.out.println("Lane.handleTraffic() called");
        System.out.println("Lane.handleTraffic() returned");
    }

    /**
     * Hozzáad egy járművet a vehicle listához.
     * @param vehicle a hozzáadandó jármű
     */
    public void addVehicle(Vehicle vehicle){
//        Prototype.increaseIndentation("Lane.addVehicle()");
//
//        if (Prototype.readBool("Is the vehicle stuck?")) {
//            vehicle.setState(VehicleState.STUCK);
//        }
//
//        else if (Prototype.readBool("Is the lane icy?")) {
//            vehicle.setState(VehicleState.SLIDE);
//        }

        vehicle.setLane(this);

//        Prototype.decreaseIndentation("Lane.addVehicle()");
    }

    /**
     * A sávról lelépő járművet eltávolítja a vehicles listából.
     * @param vehicle a eltávolítandó jármű
     */
    public void removeVehicle(Vehicle vehicle){
//        Prototype.increaseIndentation("Lane.removeVehicle()");
//
//        // xd
//
//        Prototype.decreaseIndentation("Lane.removeVehicle()");
    }

    /**
     * Visszaadja a sáv állapotát.
     * @return a sáv állapota
     */
    public SurfaceCondition getSurfaceCondition(){
//        Prototype.increaseIndentation("Lane.getSurfaceCondition()");
//
//        // xd
//
//        Prototype.decreaseIndentation("Lane.getSurfaceCondition()");

        return null;
    }

    /**
     * Visszaadja a sávhoz tartozó út hosszát.
     * @return a sávhoz tartozó út hossza
     */
    public int getRoadLength(){
        System.out.println("Lane.getRoadLength() called");
        System.out.println("Lane.getRoadLength() returned");
        return 0;
    }

    public Road getRoad(){
        return road;
    }

    public void addSnow(int amount) {
        // TODO: Implement
    }

    public void addSalt(int amount) {
        // TODO: Implement
    }

    public void addRock(int amount) {
        // TODO: Implement
    }

    public void reduceSnow(int amount) {
        // TODO: Implement
    }

    public void reduceIce(int amount) {
        // TODO: Implement
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
