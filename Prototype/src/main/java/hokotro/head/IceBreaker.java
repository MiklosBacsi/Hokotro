package hokotro.head;

import hokotro.Prototype;
import hokotro.roadnetwork.Lane;
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
        System.out.println("icebreaker.ApplyEffect()");
        System.out.println("return icebreaker.ApplyEffect()");
    }

    @Override
    public String toString() {
        try {
            return "ice-breaker: " + Prototype.getId(this);
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