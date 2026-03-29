import java.util.List;
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
        System.out.println("Lane.addVehicle() called");
        System.out.println("Lane.addVehicle() returned");
    }
    /**
     * A sávról lelépő járművet eltávolítja a vehicles listából.
     * @param vehicle a eltávolítandó jármű
     */
    public void removeVehicle(Vehicle vehicle){
        System.out.println("Lane.removeVehicle() called");
        System.out.println("Lane.removeVehicle() returned");
    }
    /**
     * Visszaadja a sáv állapotát.
     * @return a sáv állapota
     */
    public SurfaceCondition getSurfaceCondition(){
        System.out.println("Lane.getSurfaceCondition() called");
        System.out.println("Lane.getSurfaceCondition() returned");
        return null;}
    /**
     * Visszaadja a sávhoz tartozó út hosszát.
     * @return a sávhoz tartozó út hossza
     */
    public int getRoadLength(){
        System.out.println("Lane.getRoadLength() called");
        System.out.println("Lane.getRoadLength() returned");
        return 0;}
}
