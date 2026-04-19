package hokotro.head;

import hokotro.Prototype;
import hokotro.roadnetwork.Lane;
import hokotro.roadnetwork.SurfaceCondition;
import hokotro.util.Logger;

/**
 * A hókotró egyik fejtípusa, elolvasztja az összes havat és jeget a sávról
 */
public class Dragon extends Head {
    static int consume;
    /**
     *Felülíja az ősosztály metódusát, eltünteti a sávról a havat és jeget
     * @param lane A sáv, amin a takarítást meg kell valósítsa
     */
    @Override
    public void applyEffect(Lane lane){
        if (lane.getRoad().getLength() <= snowPlower.getKerosene()) {
            snowPlower.decreaseKerosene(lane.getRoad().getLength());
            SurfaceCondition surfaceCondition = lane.getSurfaceCondition();
            surfaceCondition.setSnowThickness(0);
            surfaceCondition.setIceThickness(0);
        }
    }
    @Override    
    public ItemType getType() {
        return ItemType.HEAD_DRAGON;
    }
    @Override
    public String toString() {
        try {
            return "dragon";
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
            Logger.logOK("dragon: " + Prototype.getId(this));
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
