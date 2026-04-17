package hokotro.head;

import hokotro.Prototype;
import hokotro.roadnetwork.Lane;
import hokotro.util.Logger;

/**
 * A hókotró egyik fejtípusa, letakarítja a sávról az összes havat és feltört jeget
 */
public class Blower extends Head {
    /**
     *Felülíja az ősosztály metódusát, eltünteti a sávról a havat és feltört jeget
     * @param lane A sáv, amin a takarítást meg kell valósítsa
     */
    @Override
    public void applyEffect(Lane lane){
        System.out.println("blower.ApplyEffect()");
        System.out.println("return blower.ApplyEffect()");
    }

    @Override
    public String toString() {
        try {
            return "blower: " + Prototype.getId(this);
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