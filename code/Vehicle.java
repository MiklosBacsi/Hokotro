public abstract class Vehicle {/* 
    private Lane lane;
    private Crossing crossing;
    private int id;
    private VehicleState state;
    private int lanePosition;
*/
    public void setLane(Lane lane){
        System.out.println("Vehicle.setLane() called");
        System.out.println("Vehicle.setLane() returned");
    }
    public void move(Lane lane){
        System.out.println("Vehicle.move() called");
        System.out.println("Vehicle.move() returned");
    }
    public void setCrossing(Crossing crossing){
        System.out.println("Vehicle.setCrossing() called");
        System.out.println("Vehicle.setCrossing() returned");
    }
}
