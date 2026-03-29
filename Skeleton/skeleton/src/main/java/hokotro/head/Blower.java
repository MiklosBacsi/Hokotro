package hokotro.head;

import hokotro.roadnetwork.Lane;

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
}