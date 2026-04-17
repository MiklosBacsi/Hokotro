package hokotro.head;

import hokotro.Prototype;
import hokotro.roadnetwork.Lane;
import hokotro.util.Logger;

/**
 * Felsózza az adott sávot.
 */
public class SaltSpreader extends Head {
    static int consume;
    /**
     * Felsózza az adott sávot.
     *
     * @param lane a sáv, amelyben a hatás érvényesül
     */
    @Override
    public void applyEffect(Lane lane){
        System.out.println("SaltSpreader.applyEffect() called");
        System.out.println("SaltSpreader.applyEffect() returned");
    }

    @Override
    public String toString() {
        try {
            return "salt-spreader: " + Prototype.getId(this);
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void log(boolean verbose) {
        try {
            Logger.logOK(this.toString());
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
