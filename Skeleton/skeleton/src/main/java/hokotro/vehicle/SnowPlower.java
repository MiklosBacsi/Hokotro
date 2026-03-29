package hokotro.vehicle;

import hokotro.Skeleton;
import hokotro.head.Head;

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
}
