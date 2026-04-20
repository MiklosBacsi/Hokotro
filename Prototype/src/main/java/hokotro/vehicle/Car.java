package hokotro.vehicle;

import hokotro.Prototype;
import hokotro.roadnetwork.Crossing;
import hokotro.roadnetwork.Lane;
import hokotro.roadnetwork.Road;
import hokotro.util.Logger;
import hokotro.vehicle.*;

import java.util.List;

/**
 * A játék által irányított jármű, 2 csomópon között közlekedik a legrövidebb úton
 * ha eléri a célállomást, megszűnik
 */
public class Car extends Vehicle {
    
    private List<Road> currentPath;
    private Crossing origin;
    private Crossing destination;
    
    public Car(Crossing _origin, Crossing destination) {
        super(_origin);
        origin = _origin;
        this.destination = destination;
        this.state = VehicleState.NORMAL;
    }


    /**
     * Ellenőrzi, hogy az autó át tud-e sorolni egy szomszédos sávba, 
     * ha a magas hó  miatt elakadt
     * ha lehetséges át is sorol és beállítja az új sávját értékül
     */
    public void checkLaneChange(){
        Lane passableNeighbour = lane.getRoad().getPassableNeighbour(lane);
        if (passableNeighbour == null){
            state = VehicleState.STUCK;	
        } else {
            passableNeighbour.addVehicle(this);
            lane.removeVehicle(this);
            lane = passableNeighbour;
        }
    }

    /**
     * Amennyiben beér egy kereszteződésbe és a legrövidebb út nem járható, a hívásával kér új legrövidebb útvonalat a célállomásáig
     */
    public void replanPath(){
        currentPath = lane.getRoad().getRoadNetwork().planPath(crossing, destination);
    }

    /**
     * Kereszteződésbe érve ellenőrizni, hogy a jármű végállomásba érkezett-e be
     */
    public void checkArrival(){
        if (crossing == destination){
            Crossing tmp = origin;
            origin = destination;
            destination = tmp;
            replanPath();
        }
    }

    /**
     * beállítja a legrövidebb útvonalat
     * @param path Az utakból álló legrövideb útvonal a célállomásig
     */
    public void setCurrentPath(List<Road> path){
        System.out.println("setCurrentPath()");
        System.out.println("return setCurrentPath()");
    }

    private void moveInLane(){
        lanePosition++;
        if (lanePosition >= lane.getRoadLength()) {
            lane.removeVehicle(this);
            lane.getCrossings().get(1).addVehicle(this);
            crossing = lane.getCrossings().get(1);
            lane = null;
            checkArrival();
            return;
        }
        lane.handleTraffic();
    }

    @Override
    public void move(Lane lane) {
        if (crossing != null){
            for (Road road : currentPath) {
                Crossing origin = road.getCrossings().get(0);
                Crossing destination = road.getCrossings().get(1);
                if (origin == crossing) {
                    Lane nextLane = road.getPassableLane(destination);
                    if (nextLane != null) {
                        nextLane.addVehicle(this);
                        crossing.removeVehicle(this);
                        lane = nextLane;
                        crossing = null;
                        lanePosition = 0;
                        lane.handleTraffic();
                    } else {
                        replanPath();
                    }
                    break;
                }
            }
        } else {
            switch (state) {
                case NORMAL:
                    moveInLane();
                    break;
                case STUCK:
                    checkLaneChange();
                    break;
                case CRASHED:
                    if (lane.getIsPassable()) {
                        state = VehicleState.NORMAL;
                    }
                    break;
                case SLIDE:
                    moveInLane();
                    break;
                default:
                    break;
            }
        }
    }




    @Override
    public String toString() {
        try {
            return "car: " + Prototype.getId(this) +
                " | state: " + state
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
                    this +
                    " | origin: " + origin +
                    " | destination: " + destination +
                    " | current-path: " + Logger.buildStringFromCollection(currentPath, '[', ']', ";")
                );
            }
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
