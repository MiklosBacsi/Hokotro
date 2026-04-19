package hokotro.head;

import hokotro.Prototype;
import hokotro.roadnetwork.Lane;
import hokotro.system.ItemType;
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
        Lane rightLane = lane.getRoad().getRightLane(lane);
        if (rightLane != null) {
            rightLane.addSnow(lane.getSurfaceCondition().getSnowThickness());
            rightLane.addRock();
            rightLane.getSurfaceCondition().setRocky(true);
        }
        lane.getSurfaceCondition().setSnowThickness(0);
        lane.getSurfaceCondition().setRockHeight(0);
        lane.getSurfaceCondition().setRocky(false);
    }
    
    @Override
    public ItemType getType() {
        return ItemType.HEAD_SWEEPER;
    }

    @Override
    public String toString() {
        try {
            return "sweeper";
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
            Logger.logOK("sweeper: " + Prototype.getId(this));
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
