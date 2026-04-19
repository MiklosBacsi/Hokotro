package hokotro.roadnetwork;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Birtokolja a csomópontokat, utakat, alagutakat.
*Felelősség: Autók útvonaltervezése, a havazás mértékének továbbítása az utaknak.
 */
public class RoadNetwork {
    private Set<Road> roads;
    private Set<Crossing> crossings;

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
    public List<Road> planPath(Crossing start, Crossing end) {
        /* Map<Crossing, Double> distance = new HashMap<>();
        Map<Crossing, Road> previous = new HashMap<>();
        Set<Crossing> visited = new HashSet<>();
        List<Map.Entry<Double, Crossing>> queue = new ArrayList<>();

        for (Crossing node : crossings) {
            distance.put(node, Double.MAX_VALUE);
            previous.put(node, null);
        }
        distance.put(start, 0.0);
        queue.add(Map.entry(0.0, start));

        while (!queue.isEmpty()) {
            queue.sort(Comparator.comparingDouble(Map.Entry::getKey));
            Map.Entry<Double, Crossing> entry = queue.remove(0);
            Crossing current = entry.getValue();

            if (current.equals(end)) break;
            if (visited.contains(current)) continue;
            visited.add(current);

            for (Road neighborRoad : current.getRoads()) {
                boolean passable = false;
                for (Lane lane : neighborRoad.getLanes(current)) {
                    if (!lane.getIsPassable()) continue;
                    SurfaceCondition condition = lane.getSurfaceCondition();
                    if (condition != null && condition.getIceThickness() > 0) continue;
                    passable = true;
                    break;
                }
                if (!passable) continue;

                Crossing neighbor = neighborRoad.otherEnd(current);
                if (visited.contains(neighbor)) continue;

                double newDistance = distance.get(current) + neighborRoad.getLength();
                if (newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    previous.put(neighbor, neighborRoad);
                    queue.add(Map.entry(newDistance, neighbor));
                }
            }
        }

        List<Road> path = new LinkedList<>();
        Crossing current = end;
        while (previous.get(current) != null) {
            Road road = previous.get(current);
            path.add(0, road);
            current = road.otherEnd(current);
        }

        return path; */
        return new LinkedList<>();
    }
}
