package hokotro.system;

import hokotro.player.Cleaner;
import hokotro.system.ItemType;
import hokotro.vehicle.SnowPlower;

/**
 * osztály a vásárlás megvalósítására
  */
public class Economy {

    /* private HashMap<ItemType,Integer> prices; */

    /**
     * kifizeti a hókotró munkáját
     * @param snowPlower A hókotró, aminek ki kell fizetni a munkát
      */
    public void payForWork(SnowPlower snowPlower){
        System.out.println("payForWork()");
        System.out.println("return payForWork()");
    }

    /**
     * megvalósítja a különböző fejek és erőforrások vásárlását
     * @param snowPlower a hókotró, ami vásárol
     * @param item amit vásárol
     * @param count amennyit vásárol
     * @return true, ha volt rá fedezete a takarítónak, egyébként false
     */
    public boolean processPurchase(SnowPlower snowPlower, ItemType item, int count){
        System.out.println("processPurchase()");
        System.out.println("return processPurchase()");
        return true;
    }

    /**
     * az új hókotró vásárlását valósítja meg
     * @param c a takarító, aki vásárol
     * @return a hókotró referenciája, ha nem volt rá fedezett akkor null
     */
    public SnowPlower buyNewSnowPlow(Cleaner c){
        System.out.println("buyNewSnowPlow()");
        System.out.println("return buyNewSnowPlow()");
        return null;
    }
}
