package hokotro.roadnetwork;

import java.util.List;
import java.util.Set;

/**
 * Birtokolja a csomópontokat, utakat, alagutakat.
*Felelősség: Autók útvonaltervezése, a havazás mértékének továbbítása az utaknak.
 */
public class RoadNetwork {
    /* private Set<Road> roads;
    private Set<Crossing> crossings; */

    /**
     * Továbbítja a havazást az utaknak.
     * @param amount a lehulló hó mennyisége
     */
    public void letItSnow(int amount){
        System.out.println("RoadNetwork.letItSnow() called");
        System.out.println("RoadNetwork.letItSnow() returned");
    }

    /**
     *  Kiszámolja az autóknak a két csomópont közötti legrövidebb utat.
     * @param start a kiindulási csomópont
     * @param end a cél csomópont
     * @return a két csomópont közötti legrövidebb út listája
     */
    public List<Road> planPath(Crossing start, Crossing end){
        System.out.println("RoadNetwork.planPath() called");
        System.out.println("RoadNetwork.planPath() returned");
        return null;
    }
}
