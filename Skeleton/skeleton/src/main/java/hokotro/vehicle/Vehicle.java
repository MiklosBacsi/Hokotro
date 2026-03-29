package hokotro.vehicle;

import hokotro.Skeleton;
import hokotro.roadnetwork.Crossing;
import hokotro.roadnetwork.Lane;

public abstract class Vehicle {
    /*
    private Lane lane;
    private Crossing crossing;
    private int id;
    private VehicleState state;
    private int lanePosition;
    */
    
    /**
     * Beállítja az autó éppen aktuális sávját, és nullázza az aktuális crossingot.
     *
     * @param lane az aktuális sáv
     */
    public void setLane(Lane lane){
        Skeleton.increaseIndentation("Vehicle.setLane()");

        Skeleton.print("Vehicle lane set!");

        Skeleton.decreaseIndentation("Vehicle.setLane()");
    }

    public  void setState(VehicleState state) {
        Skeleton.increaseIndentation("Vehicle.setState()");

        Skeleton.print("Vehicle state set to " + state.toString());

        Skeleton.decreaseIndentation("Vehicle.setState()");
    }

    /**
     * A mozgás megvalósítása.
     *
     * @param lane a sáv, amelyben a mozgás történik
     */
    public void move(Lane lane){
        System.out.println("Vehicle.move() called");
        System.out.println("Vehicle.move() returned");
    }

    /**
     * Beállítja az autó éppen aktuális csomópontját, és nullázza az aktuális sávot.
     *
     * @param crossing az aktuális csomópont
     */
    public void setCrossing(Crossing crossing){
        System.out.println("Vehicle.setCrossing() called");
        System.out.println("Vehicle.setCrossing() returned");
    }
}
