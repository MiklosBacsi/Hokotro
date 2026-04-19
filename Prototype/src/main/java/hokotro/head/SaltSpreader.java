package hokotro.head;

import hokotro.Prototype;
import hokotro.roadnetwork.Lane;
import hokotro.roadnetwork.SurfaceCondition;
import hokotro.system.ItemType;
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
        if (lane.getRoad().getLength() <= snowPlower.getSalt()) {
            snowPlower.decreaseSalt(lane.getRoad().getLength());
            lane.getSurfaceCondition().setSalted(true);
        }
    }
    @Override
    public ItemType getType() {
        return ItemType.HEAD_SALTSPREADER;
    }

    @Override
    public String toString() {
        try {
            return "salt-spreader";
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
            }
            Logger.logOK("salt-spreader: " + Prototype.getId(this));
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
