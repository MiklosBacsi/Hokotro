import java.util.List;

public class Lane {
    private Road road;
    private List<Crossing> crossings;
    private List<Vehicle> vehicles;
    private boolean isPassable;
    private SurfaceCondition condition;

    public void handleTraffic(){}
    public void addVehicle(Vehicle vehicle){}
    public void removeVehicle(Vehicle vehicle){}
    public SurfaceCondition getSurfaceCondition(){return condition;}
    public int getRoadLength(){return 0;}
}
