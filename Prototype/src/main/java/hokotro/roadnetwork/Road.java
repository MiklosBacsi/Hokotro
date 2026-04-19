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
  protected List<Lane> lanes1; // index 0 a legbelső sáv
  protected List<Lane> lanes2;
  private int length;
  private RoadNetwork roadNetwork;

     /**
     * Visszaadja a csomópontokat, amiket összeköt.
     * @return a csomópontok, amiket összeköt
     */


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
        for (Lane lane : lanes1) {
            lane.letItSnow(amount);
        }
        for (Lane lane : lanes2) {
            lane.letItSnow(amount);
        }
    }

    /**
     * Visszaadja a jobbra lévő sávot.
     * @param lane a sáv, amelyhez képest a jobbra lévő sávot keressük
     * @return a jobbra lévő sáv, vagy null, ha nincs ilyen
     */
    public Lane getRightLane(Lane lane){
        if (lanes1.contains(lane)) {
            int index = lanes1.indexOf(lane);
            if (index < lanes1.size() - 1) {
                return lanes1.get(index + 1);
            }
        } else if (lanes2.contains(lane)) {
            int index = lanes2.indexOf(lane);
            if (index < lanes2.size() - 1) {
                return lanes2.get(index + 1);
            }
        }
        return null;
    }

    public Lane getLeftLane(Lane lane) {
        if (lanes1.contains(lane)) {
            int index = lanes1.indexOf(lane);
            if (index > 0) {
                return lanes1.get(index - 1);
            }
        } else if (lanes2.contains(lane)) {
            int index = lanes2.indexOf(lane);
            if (index > 0) {
                return lanes2.get(index - 1);
            }
        }
        return null;
    }

    /**
     * Visszaadja a balra lévő sávot.
     * @param lane a sáv, amelyhez képest a balra lévő sávot keressük
     * @return a balra lévő sáv, vagy null, ha nincs ilyen
     */
    public Lane getPassableNeighbour(Lane lane){
        if (getRightLane(lane) != null && getRightLane(lane).getIsPassable()) {
            return getRightLane(lane);
        } else if (getLeftLane(lane) != null && getLeftLane(lane).getIsPassable()) {
            return getLeftLane(lane);
        }
        return null;
    }

    /**
     * Visszaadja az első járható sávot a megadott útból, vagy null-t ha nincs ilyen.
     * @param crossing a csomópont, ahova vezet az ut
     * @return az első járható sáv a megadott csomópontból kifelé, vagy null, ha nincs ilyen
     */
    public Lane getPassableLane(Crossing crossing) {
        if (lanes1 != null && !lanes1.isEmpty()) {
            Lane lane = lanes1.get(0);
            if (lane.getCrossings().get(1) == crossing) {
                for (Lane l : lanes1) {
                    if (l.getIsPassable()) {
                        return l;
                    }
                }
            }
        }
        if (lanes2 != null && !lanes2.isEmpty()) {
            Lane lane = lanes2.get(0);
            if (lane.getCrossings().get(1) == crossing) {
                for (Lane l : lanes2) {
                    if (l.getIsPassable()) {
                        return l;
                    }
                }
            }
        }
        return null;
    }

    public RoadNetwork getRoadNetwork() {
        return roadNetwork;
    }

    /**
     * Visszaadja a savok listajat
     * @param crossing a csomópont, ahova vezet az ut
     * @return a savok listaja
     */
    public List<Lane> getLanes(Crossing crossing) {
        if (lanes1 != null && !lanes1.isEmpty()) {
            Lane lane = lanes1.get(0);
            if (lane.getCrossings().get(1) == crossing) {
                return lanes1;
            }
        }
        if (lanes2 != null && !lanes2.isEmpty()) {
            Lane lane = lanes2.get(0);
            if (lane.getCrossings().get(1) == crossing) {
                return lanes2;
            }
        }
        return null;
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
