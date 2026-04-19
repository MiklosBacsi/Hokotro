package hokotro.head;

import hokotro.Prototype;
import hokotro.roadnetwork.Lane;
import hokotro.roadnetwork.SurfaceCondition;
import hokotro.util.Logger;

/**
 * A hókotró egyik fejtípusa, feltöri a sávon a jeget
 */
public class IceBreaker extends Head {
    /**
     *Felülíja az ősosztály metódusát, feltöri a sávon a jeget
     * @param lane A sáv, amin a takarítást meg kell valósítsa
     */
    @Override
    public void applyEffect(Lane lane){
        SurfaceCondition surfaceCondition = lane.getSurfaceCondition();
        surfaceCondition.addSnowThickness(surfaceCondition.getIceThickness());
        surfaceCondition.setIceThickness(0);
    }
    @Override    
    public ItemType getType() {
        return ItemType.HEAD_ICEBREAKER;
    }
    @Override
    public String toString() {
        try {
            return "ice-breaker";
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
            Logger.logOK("ice-breaker: " + Prototype.getId(this));
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}