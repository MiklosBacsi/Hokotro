package hokotro.player;

import hokotro.Prototype;
import hokotro.player.Player;
import hokotro.util.Logger;
import hokotro.vehicle.Bus;

/**
 * A buszokat irányító játékos, tárolja a pontokat
 */
public class BusDriver extends Player {
    private int points;
    private Bus ownBus;

    /**
     * Növeli a buszvezető pontjait
     * @param amount A mennyiség, amennyivel növeli
     */
    public void addPoints(int amount){
        System.out.println("addPoints()");
        System.out.println("return addPoints()");
    }

    @Override
    public String toString() {
        try {
            return "bus-driver: " + Prototype.getId(this) +
                " | points: " + points
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
                Logger.logOK(this + " | " + ownBus);
            }
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
