package hokotro.vehicle;

import hokotro.Prototype;
import hokotro.head.Head;
import hokotro.player.Cleaner;
import hokotro.util.Logger;

import java.util.Set;

/**
 * Jelzi a sávnak, hogy ráment és takarítja, vásárolni képes.
 */
public class SnowPlower extends Vehicle{
    private Set<Head> heads;
    private Head currentHead;
    private int salt;
    private int kerosene;
    private int stone;
    private Cleaner owner;

    /**
     * Fejcserét valósítja meg.
     * @param newHead
     */
    public void changeHead(Head newHead){
//        Prototype.increaseIndentation("SnowPlower.changeHead()");
//        Prototype.print("The SnowPlower's head changed!");
//        Prototype.decreaseIndentation("SnowPlower.changeHead()");
    }
    /**
     * Visszaadja a jelenlegi fejet.
     * @return a jelenlegi fej
     */
    public Head getHead() {
        return currentHead;
    }

    /**
     * Növeli a kerosin mennyiségét.
     * @param amount az növekedés mértéke
     */
    public void increaseKerosene(int amount){
//        Prototype.increaseIndentation("SnowPlower.increaseKerosine()");
//        Prototype.print("Kerosine amount increased!");
//        Prototype.decreaseIndentation("SnowPlower.increaseKerosine()");
    }
    /**
     * Növeli a só mennyiségét.
     * @param amount az növekedés mértéke
     */
    public void increaseSalt(int amount){
//        Prototype.increaseIndentation("SnowPlower.increaseSalt()");
//        Prototype.print("Salt amount increased by " + amount);
//        Prototype.decreaseIndentation("SnowPlower.increaseSalt()");
    }
    /**
     * Növeli a kő mennyiségét.
     * @param amount az növekedés mértéke
     */
    public void increaseStone(int amount){}
    /**
     * Hozzáad egy fejet a SnowPlowerhez.
     * @param head a hozzáadni kívánt fej
     */
    public void addHead(Head head){
//        Prototype.increaseIndentation("SnowPlower.addHead()");
//        Prototype.print("new Head added!");
//        Prototype.decreaseIndentation("SnowPlower.addHead()");
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
    /**
     * Csökkenti a kerosin mennyiségét.
     * @param amount a csökkenés mértéke
     */
    public void decreaseKerosene(int amount){}
    /**
     * Csökkenti a só mennyiségét.
     * @param amount a csökkenés mértéke
     */
    public void decreaseSalt(int amount){}
    /**
     * Csökkenti a kő mennyiségét.
     * @param amount a csökkenés mértéke
     */
    public void decreaseStone(int amount){}
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
