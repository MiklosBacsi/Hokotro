package hokotro.roadnetwork;

import java.util.List;
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
        Map<Crossing, Double> distance = new HashMap<>();
        Map<Crossing, Road> previous = new HashMap<>();
        Set<Crossing> visited = new HashSet<>();
        PriorityQueue<double[], Crossing> priorityQueue =
            new PriorityQueue<>(Comparator.comparingDouble(pair -> pair[0]));

        for (Crossing node : crossings) {
            distance.put(node, Double.MAX_VALUE);
            previous.put(node, null);
        }
        distance.put(start, 0.0);
        priorityQueue.add(new double[]{0.0}, start); // (távolság, csomópont)

        while (!priorityQueue.isEmpty()) {
            Map.Entry<double[], Crossing> entry = priorityQueue.poll();
            double currentDistance = entry.getKey()[0];
            Crossing current = entry.getValue();

            if (current.equals(end)) break;
            if (visited.contains(current)) continue;
            visited.add(current);

            for (Road neighborRoad : current.getRoads()) {
                Crossing neighbor = neighborRoad.otherEnd(current);
                if (visited.contains(neighbor)) continue;

                double newDistance = distance.get(current) + neighborRoad.getWeight();
                if (newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    previous.put(neighbor, neighborRoad);
                    priorityQueue.add(new double[]{newDistance}, neighbor);
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

        return path;
    }
}
