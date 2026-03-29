package hokotro.vehicle;

import hokotro.Skeleton;
import hokotro.head.Head;
import hokotro.system.ItemType;

import java.util.Set;

/**
 * Jelzi a sávnak, hogy ráment és takarítja, vásárolni képes.
 */
public class SnowPlower extends Vehicle{
  //private Set<Head> heads;
  //private Head currentHead;
  //private int salt;
  //private int kerosin;
  //private Cleaner owner;

  /**
   * Fejcserét valósítja meg.
   * @param newHead
   */  
  public void changeHead(Head newHead){
      Skeleton.increaseIndentation("SnowPlower.changeHead()");
      Skeleton.print("The SnowPlower's head changed!");
      Skeleton.decreaseIndentation("SnowPlower.changeHead()");
    }

    public void increaseKerosine(int amount){
      Skeleton.increaseIndentation("SnowPlower.increaseKerosine()");
      Skeleton.print("Kerosine amount increased!");
      Skeleton.decreaseIndentation("SnowPlower.increaseKerosine()");
    }
    public void increaseSalt(int amount){
      Skeleton.increaseIndentation("SnowPlower.increaseSalt()");
      Skeleton.print("Salt amount increased by" + amount);
      Skeleton.decreaseIndentation("SnowPlower.increaseSalt()");
    }

    public void addHead(Head head){
      Skeleton.increaseIndentation("SnowPlower.addHead()");
      Skeleton.print("new Head added!");
      Skeleton.decreaseIndentation("SnowPlower.addHead()");
    }
}
