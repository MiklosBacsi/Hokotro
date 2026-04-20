package hokotro.head;

import hokotro.Prototype;
import hokotro.roadnetwork.Lane;
import hokotro.roadnetwork.SurfaceCondition;
import hokotro.system.ItemType;
import hokotro.util.Logger;

/**
 * A hókotró egyik fejtípusa, elolvasztja az összes havat és jeget a sávról
 */
public class StoneSpreader extends Head {
    static int consume;
    /**
     *Felülíja az ősosztály metódusát, eltünteti a sávról a havat és jeget
     * @param lane A sáv, amin a takarítást meg kell valósítsa
     */
    @Override
    public void applyEffect(Lane lane){
        if (lane.getRoad().getLength() <= snowPlower.getStone()) {
            snowPlower.decreaseStone(lane.getRoad().getLength());
            lane.getSurfaceCondition().setRocky(true);
            lane.addRock();
        }
    }

    @Override    
    public ItemType getType() {
        return ItemType.HEAD_STONESPREADER;
    }

    @Override
    public String toString() {
        try {
            return "stone-spreader";
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
            Logger.logOK("stone-spreader: " + Prototype.getId(this));
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
