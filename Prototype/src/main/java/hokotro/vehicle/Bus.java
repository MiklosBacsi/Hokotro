package hokotro.vehicle;

/*
 * A buszvezetők által irányított jármű, célja, hogy minél többször megforduljon a 2 csomópontja között
 */

import hokotro.Prototype;
import hokotro.player.BusDriver;
import hokotro.roadnetwork.Crossing;
import hokotro.util.Logger;

public class Bus extends Vehicle {
    
    private int waitTicks;
    private Crossing origin;
    private Crossing destination;
    private BusDriver owner; 


    public Bus(Crossing origin, Crossing destination, BusDriver owner) {
        super(origin);
        this.origin = origin;
        this.destination = destination;
        this.owner = owner;
        this.state = VehicleState.NORMAL;
    }
    /* 
     * Mozgatja a busszal a járművet a megadott sávon
     */
    @Override
    public void move(Lane lane) {
        if(crossing!=null){
            checkArrival();
            if(lane!=null){
                lane.addVehicle(this);
                this.lane = lane;
                crossing.removeVehicle(this);
                crossing=null;
                lanePosition = 0;
                lane.handleTraffic();
            }
            break;

        }else {
            switch (state) {
                case NORMAL:
                    moveInLane();
                    break;
                case WAITING:
                    waitTicks--;
                    if (waitTicks <= 0){
                        resumeRoute();
                    }
                    break;
                default:
                    break;
            }
            
        }
    }
    /** 
     * Mozgatja a busszal a járművet a megadott sávon
     */
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

    /** 
     * Normál állapotba teszi magát, ha járt a várakozási ideje
     */
    public void resumeRoute(){
        state=VehicleState.NORMAL;
        lane.handleTraffic();
    }
    /**
     * Visszaadja, hogy mennyi ideig kell várakoznia ütközés esetén
     * @return a várakozás mértéke
     */
    public int getWaitTicks() {
        return waitTicks;
    }

    /**
     * Kereszteződésbe érve ellenőrizni, hogy a jármű végállomásba érkezett-e be
     */
    public void checkArrival(){
        if (crossing == destination){
            owner.addPoints(1);
            Crossing tmp = origin;
            origin = destination;
            destination = tmp;
        }
        
    }

    /**
     * beállítja, hogy mennyi ideig kell várakoznia ütközés esetén
     * @param t A várakozás mértéke 
     */
    public void setWaitTicks(int t){
        waitTicks = t;
    }

    @Override
    public String toString() {
        try {
            return "bus: " + Prototype.getId(this) +
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
                    " | owner: " + owner +
                    " | origin: " + origin +
                    " | destination: " + destination +
                    " | wait-ticks: " + waitTicks
                );
            }
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
