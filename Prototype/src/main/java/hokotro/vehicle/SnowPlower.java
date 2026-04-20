package hokotro.vehicle;

import hokotro.Prototype;
import hokotro.head.Head;
import hokotro.player.Cleaner;
import hokotro.system.ItemType;
import hokotro.util.Logger;

import java.util.Set;
import hokotro.roadnetwork.Crossing;
import hokotro.roadnetwork.Lane;
import hokotro.roadnetwork.Road;

/**
 * Jelzi a sávnak, hogy ráment és takarítja, vásárolni képes.
 */
public class SnowPlower extends Vehicle{
    private Set<Head> heads;
    private Head currentHead;
    private ItemType currentHeadType;
    private int salt;
    private int kerosene;
    private int stone;
    private Cleaner owner;


    public SnowPlower(Cleaner owner, Crossing crossing) {
        super(crossing);
        this.owner = owner;
    }

    /**
     * Fejcserét valósítja meg.
     * @param newHead
     */
    public void changeHead(Head newHead){
        currentHead = newHead;
        currentHeadType = newHead.getType();
    }


    public ItemType getCurrentHeadType() {
        return currentHeadType;
    }

    /**
     * Növeli a kerosin mennyiségét.
     * @param amount az növekedés mértéke
     */
    public void increaseKerosene(int amount){
        kerosene += amount;
    }
    /**
     * Növeli a só mennyiségét.
     * @param amount az növekedés mértéke
     */
    public void increaseSalt(int amount){
        salt += amount;
    }
    /**
     * Növeli a kő mennyiségét.
     * @param amount az növekedés mértéke
     */
    public void increaseStone(int amount){
        stone += amount;
    }
    /**
     * Hozzáad egy fejet a SnowPlowerhez.
     * @param head a hozzáadni kívánt fej
     */
    public void addHead(Head head){
        heads.add(head);
    }
    /**
     * Visszaadja a kerosin mennyiségét.
     * @return a kerosin mennyisége
     */
    public int getKerosene() {
        return kerosene;
    }
    /**
     * Visszaadja a só mennyiségét.
     * @return a só mennyisége
     */
    public int getSalt() {
        return salt;
    }
    /**
     * Visszaadja a kő mennyiségét.
     * @return a kő mennyisége
     */
    public int getStone() {
        return stone;
    }

    public Head getHead() {
        return currentHead;
    }

    /**
     * Csökkenti a kerosin mennyiségét.
     * @param amount a csökkenés mértéke
     */
    public void decreaseKerosene(int amount){
        kerosene -= amount;
    }
    /**
     * Csökkenti a só mennyiségét.
     * @param amount a csökkenés mértéke
     */
    public void decreaseSalt(int amount){
        salt -= amount;
    }
    /**
     * Csökkenti a kő mennyiségét.
     * @param amount a csökkenés mértéke
     */
    public void decreaseStone(int amount){
        stone -= amount;
    }
    /**
     * Beállítja a SnowPlower tulajdonosát.
     * @param owner a beállítani kívánt tulajdonos
     */    
    public void setOwner(Cleaner owner) {
        this.owner = owner;
    }
    /**
     * Visszaadja a SnowPlower tulajdonosát.
     * @return a SnowPlower tulajdonosa
     */
    public Cleaner getOwner() {
        return owner;
    }

    private void moveInLane(){
        lanePosition++;
        if (lanePosition >= lane.getRoadLength()) {
            lane.removeVehicle(this);
            lane.getCrossings().get(1).addVehicle(this);
            lane.clean(currentHead);
            crossing = lane.getCrossings().get(1);
            lane = null;
            return;
        }
        lane.handleTraffic();
    }

    @Override
    public void move(Lane nextLane){
        if (crossing != null){
            lane = nextLane;
            crossing.removeVehicle(this);
            crossing = null;
            lane.addVehicle(this);
            lanePosition = 0;
            lane.handleTraffic(); 
        } else {
            moveInLane();
        }
    }

    @Override
    public void crash() {}

    @Override
    public void stuck() {}





    @Override
    public String toString() {
        try {
            return "snowplower: " + Prototype.getId(this) +
                " | head: " + Prototype.getId(currentHead)
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
                    " | salt: " + salt +
                    " | kerosene: " + kerosene +
                    " | stone: " + stone +
                    " | owner: " + owner +
                    " | heads: " + Logger.buildStringFromCollection(heads, '{', '}', ";")
                );
            }
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
