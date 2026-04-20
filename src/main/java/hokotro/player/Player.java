package hokotro.player;

import hokotro.roadnetwork.Lane;
import hokotro.util.ILogable;
import hokotro.vehicle.Vehicle;

/**
 * Absztrakt ősosztály minden játékostípushoz.
 */
public abstract class Player implements ILogable {
    
    private int id;

    /**
     * Visszaadja a játékos azonosítóját.
     * @return a játékos azonosítója
     */
    public int getId(){ 
        System.out.println("Player.getId() called");
        System.out.println("Player.getId() returned");
        return 0;
    }

    /**
     * A mozgás későbbi megvalósítására.
     * @param vehicle a mozgó jármű
     * @param lane a sáv, amelyben a mozgás történik
     */
    public void move(Vehicle vehicle, Lane lane){
        if (vehicle == null || lane == null) {
            throw new IllegalArgumentException("Player.move() called with null vehicle or lane");
        }
        if (vehicle.getCrossing() == null) {
            throw new IllegalArgumentException("Player.move() called with vehicle not on crossing");
        }
//        if (vehicle.getCrossing().getLanes().contains(lane)) {
//            vehicle.move(lane);
//        } else {
//            throw new IllegalArgumentException("Player.move() called with lane not on vehicle's crossing");
//        }
    }
}
