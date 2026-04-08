package hokotro.system;

import hokotro.Prototype;
import hokotro.head.Blower;
import hokotro.head.Dragon;
import hokotro.head.Head;
import hokotro.head.IceBreaker;
import hokotro.head.SaltSpreader;
import hokotro.head.Sweeper;
import hokotro.player.Cleaner;
import hokotro.vehicle.SnowPlower;

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
    public boolean processPurchase(SnowPlower snowPlower, ItemType item, int count,Cleaner cleaner){
        Prototype.increaseIndentation("Economy.processPurchase()");

        int money = cleaner.getMoney();
        if (money>=5*count) {
            cleaner.decreaseMoney(5*count);
            switch (item) {
                case ItemType.SALT:
                    snowPlower.increaseSalt(count);
                break;
                case ItemType.KEROSINE:
                    snowPlower.increaseKerosine(count);
                break;
                default:
                    Head head = null;
                    switch (item) {
                        case HEAD_SWEEPER:
                            head = new Sweeper();
                            break;

                        case HEAD_BLOWER:
                            head = new Blower();
                            break;

                        case HEAD_ICEBREAKER:
                            head = new IceBreaker();
                            break;

                        case HEAD_SALTSPREADER:
                            head = new SaltSpreader();
                            break;

                        case HEAD_DRAGON:
                            head = new Dragon();
                            break;
                        default:
                            break;
                    }
                    snowPlower.addHead(head);
                    break;
            }
            Prototype.decreaseIndentation("Economy.processPurchase()");
            return true;
        }else{
            Prototype.print("Not enough money");
            Prototype.decreaseIndentation("Economy.processPurchase()");
            return false;
        }


    }

    /**
     * az új hókotró vásárlását valósítja meg
     * @param c a takarító, aki vásárol
     * @return a hókotró referenciája, ha nem volt rá fedezett akkor null
     */
    public SnowPlower buyNewSnowPlower(Cleaner cleaner){
        Prototype.increaseIndentation("Economy.buyNewSnowPlower()");

        int money = cleaner.getMoney();
        if (money>=100) {
            int headNumber = Prototype.readNumber("1. Sweeper\n2. IceBreaker\n", 1, 2);
            cleaner.decreaseMoney(100);
            if (headNumber == 1) {
                SnowPlower sp = new SnowPlower();
                sp.addHead(new Sweeper());
                Prototype.decreaseIndentation("Economy.buyNewSnowPlower()");
                return sp;
            } else {
                SnowPlower sp = new SnowPlower();
                sp.addHead(new IceBreaker());
                Prototype.decreaseIndentation("Economy.buyNewSnowPlower()");
                return sp;
            }
        }

        Prototype.print("Not enough money");
        Prototype.decreaseIndentation("Economy.buyNewSnowPlower()");
        return null;
    }
}
