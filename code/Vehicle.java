public abstract class Vehicle {
    private Lane lane;
    private Crossing crossing;
    private int id;
    private VehicleState state;
    private int lanePosition;

    public void setLane(Lane lane){}
    public void move(Lane lane){}
    public void setCrossing(Crossing crossing){}
}
