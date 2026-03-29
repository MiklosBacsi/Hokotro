/* 
 * A hókotró egyik fejtípusa, feltöri a sávon a jeget
 */

public class IceBreaker extends Head {
    /**
     *Felülíja az ősosztály metódusát, feltöri a sávon a jeget
     * @param lane A sáv, amin a takarítást meg kell valósítsa
     */
    @Override
    public void ApplyEffect(Lane lane){
        System.out.println("icebreaker.ApplyEffect()");
        System.out.println("return icebreaker.ApplyEffect()");
    }
}