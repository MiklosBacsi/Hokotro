package hokotro.roadnetwork;

import hokotro.util.ILogable;
import hokotro.Prototype;
import hokotro.util.Logger;
import hokotro.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Egy csomópont, tárolja az éppen ott tartózkodó járművek és a  hozzá befutó utakat
 */
public class Crossing implements ILogable {
    private Set<Road> roads;
    private Set<Vehicle> vehicles;

    /**
     * megvizsgálja, hogy van-e járható sávja egy adott útnak adott irányba
     * @param road az út, amit vizsgál
     * @return true, ha van járható sávja az adott útnak adott irányba
      */
    public boolean isPassable(Road road){
        System.out.println("isPassable()");
        System.out.println("return isPassable()");
        return true;
    }

    /**
     * visszaadja, hogy egy másik csomópont felé melyik út megy
     * @param crossing a másik csomópont, amit vizsgál
     * @return road, az út, ami összeköti a paraméterként kapott csomóponttal, ha nem szomszédosak, az értéke null
      */
    public Road roadToCrossing(Crossing crossing){
        System.out.println("roadToCrossing()");
        System.out.println("return roadToCrossing()");
        return null;
    }

    /**
     * eltárolja a paraméterként kapott járművet
     * @param vehicle A jármű amit el kell tárolni
     */
    public void addVehicle(Vehicle vehicle){
        System.out.println("addVehicle()");
        System.out.println("return addVehicle()");
    }

    /**
     * eltávolítja a paraméterként kapott járművet
     * @param vehicle A jármű amit el kell távolítani a listából
      */
    public void removeVehicle(Vehicle vehicle){
        System.out.println("removeVehicle()");
        System.out.println("return removeVehicle()");
    }

    public List<Road> getRoads() {
//        Prototype.increaseIndentation("Crossing.getRoads()");
//
//        Prototype.decreaseIndentation("Crossing.getRoads()");

        return new ArrayList<>();
    }

    @Override
    public String toString() {
        try {
            return "crossing: " + Prototype.getId(this) +
                " | roads: " + Logger.buildStringFromCollection(roads, '{', '}', ";") +
                " | vehicles: " + Logger.buildStringFromCollection(vehicles, '{', '}', ";")
            ;
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void log(boolean verbose) {
        Logger.logOK(this.toString());
        // TODO: Finish the
    }
}
