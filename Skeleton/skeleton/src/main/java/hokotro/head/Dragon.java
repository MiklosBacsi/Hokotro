/**
 * A hókotró egyik fejtípusa, elolvasztja az összes havat és jeget a sávról
  */
public class Dragon extends Head {
    /**
     *Felülíja az ősosztály metódusát, eltünteti a sávról a havat és jeget
     * @param lane A sáv, amin a takarítást meg kell valósítsa
     */
    @Override
    public void ApplyEffect(Lane lane){
        System.out.println("dragon.ApplyEffect()");
        System.out.println("return dragon.ApplyEffect()");
    }
}
