package hokotro.roadnetwork;

import hokotro.util.ILogable;
import hokotro.Prototype;
import hokotro.util.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Csomópontokat köt össze, sávokból áll
 * Továbbítja a havazás mértékét a sávoknak. Visszaadja a szomszédos sávot és a járhatóságot.
 */
public class Road implements ILogable {
  protected List<Lane> lanes1;
  protected List<Lane> lanes2;
  private int length;


    public List<Crossing> getCrossings() {
        if (lanes1 != null && !lanes1.isEmpty()) {
            return lanes1.get(0).getRoad().getCrossings();
        } else if (lanes2 != null && !lanes2.isEmpty()) {
            return lanes2.get(0).getRoad().getCrossings();
        }
        return null;
    }

    public int getLength() {
        return length;
    }

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
        return null;
    }

    public RoadNetwork getRoadNetwork() {
        System.out.println("Road.getRoadNetwork() called");
        System.out.println("Road.getRoadNetwork() returned");
        return null;
    }

    public List<Lane> getLanes(Crossing crossing) {
//        Prototype.increaseIndentation("Road.getLanes()");

        // xd

//        Prototype.decreaseIndentation("Road.getLanes()");

        return new ArrayList<>();
    }

    @Override
    public String toString() {
        try {
            return "road: " + Prototype.getId(this) +
                " | lanes1: " + lanes1.size() +
                " | lanes2: " + lanes2.size()
            ;
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
            } else {
                Logger.logOK(
                    "road: " + Prototype.getId(this) +
                    " | lanes1: " + Logger.buildStringFromCollection(lanes1, '[', ']', ";") +
                    " | lanes2: " + Logger.buildStringFromCollection(lanes2, '[', ']', ";")
                );
            }
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
