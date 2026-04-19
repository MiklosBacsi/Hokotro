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

    public void increaseKerosene(int amount){
//        Prototype.increaseIndentation("SnowPlower.increaseKerosine()");
//        Prototype.print("Kerosine amount increased!");
//        Prototype.decreaseIndentation("SnowPlower.increaseKerosine()");
    }
    public void increaseSalt(int amount){
//        Prototype.increaseIndentation("SnowPlower.increaseSalt()");
//        Prototype.print("Salt amount increased by " + amount);
//        Prototype.decreaseIndentation("SnowPlower.increaseSalt()");
    }

    public void increaseStone(int amount){}

    public void addHead(Head head){
//        Prototype.increaseIndentation("SnowPlower.addHead()");
//        Prototype.print("new Head added!");
//        Prototype.decreaseIndentation("SnowPlower.addHead()");
    }

    public int getKerosene() {
        return kerosene;
    }

    public int getSalt() {
        return salt;
    }

    public int getStone() {
        return stone;
    }

    public void decreaseKerosene(int amount){}

    public void decreaseSalt(int amount){}

    public void decreaseStone(int amount){}

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
