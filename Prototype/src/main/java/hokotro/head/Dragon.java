package hokotro.head;

import hokotro.Prototype;
import hokotro.roadnetwork.Lane;
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
        System.out.println("dragon.ApplyEffect()");
        System.out.println("return dragon.ApplyEffect()");
    }

    @Override
    public String toString() {
        try {
            return "dragon: " + Prototype.getId(this);
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
