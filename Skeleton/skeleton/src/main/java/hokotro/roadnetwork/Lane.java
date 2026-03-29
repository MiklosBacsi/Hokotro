package hokotro.roadnetwork;

import hokotro.Skeleton;
import hokotro.vehicle.Vehicle;
import hokotro.vehicle.VehicleState;

/**
 * Kezeli az összecsúszásokat és utóhatásaikat.
 */
public class Lane {
    /* private Road road;
    private List<Crossing> crossings;
    private List<Vehicle> vehicles;
    private boolean isPassable;
    //private SurfaceCondition condition; */

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
        Skeleton.increaseIndentation("Lane.addVehicle()");

        if (Skeleton.readBool("Is the vehicle stuck?")) {
            vehicle.setState(VehicleState.STUCK);
        }

        else if (Skeleton.readBool("Is the lane icy?")) {
            vehicle.setState(VehicleState.SLIDE);
        }

        vehicle.setLane(this);

        Skeleton.decreaseIndentation("Lane.addVehicle()");
    }

    /**
     * A sávról lelépő járművet eltávolítja a vehicles listából.
     * @param vehicle a eltávolítandó jármű
     */
    public void removeVehicle(Vehicle vehicle){
        Skeleton.increaseIndentation("Lane.removeVehicle()");

        // xd

        Skeleton.decreaseIndentation("Lane.removeVehicle()");
    }

    /**
     * Visszaadja a sáv állapotát.
     * @return a sáv állapota
     */
    public SurfaceCondition getSurfaceCondition(){
        Skeleton.increaseIndentation("Lane.getSurfaceCondition()");

        // xd

        Skeleton.decreaseIndentation("Lane.getSurfaceCondition()");

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
}
