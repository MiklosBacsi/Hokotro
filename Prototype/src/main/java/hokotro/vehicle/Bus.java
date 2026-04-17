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

    /* 
     * Várakozó állapotba teszi magát, amíg le nem jár a várakozási ideje
     */
    public void waitToClear(){
        System.out.println("waitToClear()");
        System.out.println("return waitToClear()");
    }

    /* 
     * Normál állapotba teszi magát, ha járt a várakozási ideje
     */
    public void resumeRoute(){
        System.out.println("resumeRoute()");
        System.out.println("return resumeRoute()");
    }

    /*
     * Kereszteződésbe érve ellenőrizni, hogy a jármű végállomásba érkezett-e be
     */
    public void checkArrival(){
        System.out.println("checkArrival()");
        System.out.println("return checkArrival()");
    }

    /**
     * beállítja, hogy mennyi ideig kell várakoznia ütközés esetén
     * @param t A várakozás mértéke 
     */
    public void setWaitTicks(int t){
        System.out.println("setWaitTicks()");
        System.out.println("return setWaitTicks()");
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
