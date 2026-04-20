package hokotro.vehicle;

import hokotro.util.ILogable;
import hokotro.roadnetwork.Crossing;
import hokotro.roadnetwork.Lane;
/** A járművek absztrakt osztálya.
 */
public abstract class Vehicle implements ILogable {
    /** A jármű sávja. */
    protected Lane lane;
    /** A jármű csomópontja. */
    protected Crossing crossing;
    /** A jármű azonosítója. */
    protected int id;
    /** A jármű állapota, amely meghatározza a  viselkedését*/
    protected VehicleState state;
    /** Megadja, hogy mennyit tett meg már a sávból. Ha csomópontba ér, nullázódik. */
    protected int lanePosition;
    /**
     * A konstruktor létrehozza a járművet egy adott csomóponton, és hozzáadja a csomóponthoz.
     * @param crossing
     */
    public Vehicle(Crossing crossing) {
        this.crossing = crossing;
        crossing.addVehicle(this);
    }
    /**
     * Beállítja az autó éppen aktuális sávját, és nullázza az aktuális crossingot.
     *
     * @param lane az aktuális sáv
     */
    public void setLane(Lane lane){
//        Prototype.increaseIndentation("Vehicle.setLane()");
//
//        Prototype.print("Vehicle lane set!");
//
//        Prototype.decreaseIndentation("Vehicle.setLane()");
    }
    /**
     * Beállítja az autó éppen aktuális állapotát.
     *
     * @param state az aktuális állapot
     */
    public  void setState(VehicleState state) {
//        Prototype.increaseIndentation("Vehicle.setState()");
//
//        Prototype.print("Vehicle state set to " + state.toString());
//
//        Prototype.decreaseIndentation("Vehicle.setState()");
    }
    /**
     * Visszaadja az autó éppen aktuális sávját.
     * @return az aktuális sáv
     */
    public Lane getLane() {
        return lane;
    }

    public VehicleState getState() {
        return state;
    }   

    public abstract void crash();
    public abstract void stuck();

     /**
     * Beállítja az autó éppen aktuális útvonalát.
     *
     * @param currentPath az aktuális útvonal
     */

    /**
     * A mozgás megvalósítása.
     *
     * @param lane a sáv, amelyben a mozgás történik
     */
    public abstract void move(Lane lane);

    /**
     * Beállítja az autó éppen aktuális csomópontját, és nullázza az aktuális sávot.
     *
     * @param crossing az aktuális csomópont
     */
    public void setCrossing(Crossing crossing){
        System.out.println("Vehicle.setCrossing() called");
        System.out.println("Vehicle.setCrossing() returned");
    }
    /**
     * Visszaadja az autó éppen aktuális csomópontját.
     * @return az aktuális csomópont
     */
    public Crossing getCrossing() {
        return crossing;
    }

    public void increaseLanePosition(int amount) {
        lanePosition += amount;
    }

    public int getLanePosition() {
        return lanePosition;
    }
}
