package hokotro.system;

import hokotro.head.Blower;
import hokotro.head.Dragon;
import hokotro.head.Head;
import hokotro.head.IceBreaker;
import hokotro.head.SaltSpreader;
import hokotro.head.Sweeper;
import hokotro.player.Cleaner;
import hokotro.vehicle.SnowPlower;

import java.util.HashMap;

/**
 * osztály a vásárlás megvalósítására
  */
public class Economy {

    private HashMap<ItemType,Integer> prices;

    /**
     * kifizeti a hókotró munkáját
     * @param snowPlower A hókotró, aminek ki kell fizetni a munkát
      */
    public void payForWork(SnowPlower snowPlower){
        ItemType headType = snowPlower.getCurrentHeadType();
        switch (headType) {
            case HEAD_SWEEPER:
                snowPlower.getOwner().increaseMoney(snowPlower.getLane().getRoad().getLength());
                break;
            case HEAD_BLOWER:
                snowPlower.getOwner().increaseMoney(2*snowPlower.getLane().getRoad().getLength());
                break;
            case HEAD_ICEBREAKER:
                snowPlower.getOwner().increaseMoney(snowPlower.getLane().getRoad().getLength());
                break;
            case HEAD_SALTSPREADER:
                snowPlower.getOwner().increaseMoney(5*snowPlower.getLane().getRoad().getLength());
                break;
            case HEAD_DRAGON:
                snowPlower.getOwner().increaseMoney(10*snowPlower.getLane().getRoad().getLength());
                break;
            case HEAD_STONESPREADER:
                snowPlower.getOwner().increaseMoney(4*snowPlower.getLane().getRoad().getLength());
                break;
            default:
        }
    }

    /**
     * megvalósítja a különböző fejek és erőforrások vásárlását
     * @param snowPlower a hókotró, ami vásárol
     * @param item amit vásárol
     * @param count amennyit vásárol
     * @return true, ha volt rá fedezete a takarítónak, egyébként false
     */
    public boolean processPurchase(SnowPlower snowPlower, ItemType item, int count){
        Cleaner cleaner = snowPlower.getOwner();
        int money = cleaner.getMoney();
        int price = prices.get(item)*count;
        if (money>=price) {
            cleaner.decreaseMoney(price);
            switch (item) {
                case HEAD_SWEEPER:
                    snowPlower.addHead(new Sweeper());
                    break;
                case HEAD_BLOWER:
                    snowPlower.addHead(new Blower());
                    break;
                case HEAD_ICEBREAKER:
                    snowPlower.addHead(new IceBreaker());
                    break;
                case HEAD_SALTSPREADER:
                    snowPlower.addHead(new SaltSpreader());
                    break;
                case HEAD_DRAGON:
                    snowPlower.addHead(new Dragon());
                    break;
                case HEAD_STONESPREADER:
                    snowPlower.addHead(new Blower());
                    break;
                case KEROSENE:
                    snowPlower.increaseKerosene(count);
                    break;
                case SALT:
                    snowPlower.increaseSalt(count);
                    break;
                case STONE:
                    snowPlower.increaseStone(count);
                    break;
                default:
            }
            return true;
        }
        return false;
    }

    /**
     * az új hókotró vásárlását valósítja meg
     * @param cleaner a takarító, aki vásárol
     * @return a hókotró referenciája, ha nem volt rá fedezett akkor null
     */
    public SnowPlower buyNewSnowPlower(Cleaner cleaner){
        int money = cleaner.getMoney();
        int price = prices.get(ItemType.NEW_SNOWPLOWER);
        if (money >= price) {
            cleaner.decreaseMoney(price);
            return new SnowPlower(cleaner, null);
        }
        return null;
    }

    public HashMap<ItemType, Integer> getPrices() {
        return prices;
    }
}
