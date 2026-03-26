import java.util.List;
import java.util.Set;
/**
 * Csomópontokat köt össze, sávokból áll
 * Továbbítja a havazás mértékét a sávoknak. Visszaadja a szomszédos sávot és a járhatóságot.
 */
public class Road {
  /* private List<Lane> lanes1;
  private List<Lane> lanes2; 
  private int length; */

  /**
   * Továbbítja a havazást a sávoknak.
   * @param amount a lehulló hó mennyisége
   */
  public void letItSnow(int amount){
    System.out.println("Road.letItSnow() called");
    System.out.println("Road.letItSnow() returned");
  }
  /**
   * Visszaadja a jobbra lévő sávot.
   * @param lane a sáv, amelyhez képest a jobbra lévő sávot keressük
   * @return a jobbra lévő sáv, vagy null, ha nincs ilyen
   */
  public Lane getRightLane(Lane lane){
    System.out.println("Road.getRightLane() called");
    System.out.println("Road.getRightLane() returned");
    return null;}
  /**
   * Visszaadja a balra lévő sávot.
   * @param lane a sáv, amelyhez képest a balra lévő sávot keressük
   * @return a balra lévő sáv, vagy null, ha nincs ilyen
   */
  public Lane getPassableNeighbour(Lane lane){
    System.out.println("Road.getPassableNeighbour() called");
    System.out.println("Road.getPassableNeighbour() returned");
    return null;}
    /**
     * Visszaadja az első járható sávot a megadott útból, vagy null-t ha nincs ilyen.
     * @param r a csomópontból kifelé vezető út
     * @return az első járható sáv a megadott csomópontból kifelé, vagy null, ha nincs ilyen
     */
  public Lane getPassableLane(Road r){
    System.out.println("Road.getPassableLane() called");
    System.out.println("Road.getPassableLane() returned");
    return null;}
}
