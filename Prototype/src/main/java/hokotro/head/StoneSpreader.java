package hokotro.head;

import hokotro.roadnetwork.Lane;

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
        System.out.println("stoneSpreader.ApplyEffect()");
        System.out.println("return stoneSpreader.ApplyEffect()");
    }
}
