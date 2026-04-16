package hokotro.vehicle;

import hokotro.Prototype;
import hokotro.head.Head;
import hokotro.player.Cleaner;

import java.util.Set;

/**
 * Jelzi a sávnak, hogy ráment és takarítja, vásárolni képes.
 */
public class SnowPlower extends Vehicle{
    private Set<Head> heads;
    private Head currentHead;
    private int salt;
    private int kerosin;
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

    public void increaseKerosine(int amount){
//        Prototype.increaseIndentation("SnowPlower.increaseKerosine()");
//        Prototype.print("Kerosine amount increased!");
//        Prototype.decreaseIndentation("SnowPlower.increaseKerosine()");
    }
    public void increaseSalt(int amount){
//        Prototype.increaseIndentation("SnowPlower.increaseSalt()");
//        Prototype.print("Salt amount increased by " + amount);
//        Prototype.decreaseIndentation("SnowPlower.increaseSalt()");
    }

    public void addHead(Head head){
//        Prototype.increaseIndentation("SnowPlower.addHead()");
//        Prototype.print("new Head added!");
//        Prototype.decreaseIndentation("SnowPlower.addHead()");
    }

    @Override
    public String toString() {
        return Prototype.getId(this);   // TODO: Finish the simple
    }

    @Override
    public void list(boolean verbose) {
        Prototype.logOK(this.toString());
        // TODO: Finish the
    }
}
