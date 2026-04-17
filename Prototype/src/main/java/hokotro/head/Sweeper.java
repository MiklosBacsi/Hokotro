package hokotro.head;

import hokotro.Prototype;
import hokotro.roadnetwork.Lane;
import hokotro.util.Logger;

/**
 * A havat és feltört jeget átteszi a jobb oldali sávba.
 */
public class Sweeper extends Head {
    /**
     * A havat és feltört jeget átteszi a jobb oldali sávba.
     *
     * @param lane a sáv, amelyben a hatás érvényesül
     */
    @Override
    public void applyEffect(Lane lane){
        System.out.println("Sweeper.applyEffect() called");
        System.out.println("Sweeper.applyEffect() returned");
    }

    @Override
    public String toString() {
        try {
            return "sweeper: " + Prototype.getId(this);
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void log(boolean verbose) {
        Logger.logOK(this.toString());
    }
}
