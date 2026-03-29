package hokotro.vehicle;

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
      System.out.println("SnowPlower.changeHead() called");
      System.out.println("SnowPlower.changeHead() returned");
    }
}
