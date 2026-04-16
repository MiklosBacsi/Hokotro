package hokotro.roadnetwork;

import java.util.List;

import hokotro.IListable;
import hokotro.Prototype;
import hokotro.vehicle.Vehicle;
import hokotro.vehicle.VehicleState;

/**
 * Kezeli az összecsúszásokat és utóhatásaikat.
 */
public class Lane implements IListable {
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

    @Override
    public String toString() {
        try {
            return "line: " + Prototype.getId(this) +
                    " | start: " + Prototype.getId(crossings.getFirst()) +
                    " | end: " + Prototype.getId(crossings.getLast()) +
                    " | road: " + Prototype.getId(road);
        } catch (Exception e) {
            Prototype.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void list(boolean verbose) {
        StringBuilder line;

        try {
            // Standard output
            line = new StringBuilder(this.toString());

            // Add verbose output
            if (verbose) {
                StringBuilder vehiclesStr = new StringBuilder();
                vehiclesStr.append("[");
                for (Vehicle vehicle: vehicles) {
                    vehiclesStr.append(vehicle).append(",");
                }
                vehiclesStr.append("]");

                line.append(" | lane-no: ")  // TODO: lane number
                    .append(" | passable: ").append(isPassable)
                    .append(" | snow: ") // condition.getTopSnowHeight()
                    .append(" | ice: ") // condition.getIceHeight()
                    .append(" | salted: ") // condition.isSalted()
                    .append(" | rocky: ") // condition.isRocky()
                    .append(" | rock: ") // condition.getRockHeight()
                    .append(" | drive-count: ") // condition.getDriveCount()
                    .append(" | vehicles: ").append(vehiclesStr.toString())
                ;
            }
        } catch (Exception e) {
            Prototype.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }

        Prototype.logOK(line.toString());
    }
}
