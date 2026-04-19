package hokotro.player;

import hokotro.Prototype;

import hokotro.system.ItemType;
import hokotro.util.Logger;
import hokotro.vehicle.SnowPlower;

import java.util.Set;

/**
 * A hókotrókat vezető játékos, tárolja a pénzt és a hókotróit
 */
public class Cleaner extends Player {
    private Set<SnowPlower> snowplows;
    private int money;

    /**
     * csökkenti a takarító pénzmennyiségét
     * @param amount Az érték, amivel csökkentve lesz
     */
    public void decreaseMoney(int amount) {
//        Prototype.increaseIndentation("decreaseMoney()");
//        Prototype.print("Money decreased");
//        Prototype.decreaseIndentation("decreaseMoney()");
    }

    public void increaseMoney(int amount) {
//        Prototype.increaseIndentation("increaseMoney()");
//        Prototype.print("Money incereased");
//        Prototype.decreaseIndentation("increaseMoney()");
    }

    /**
     * visszaadja a jelenlegi pénz mennyiségét
     * @return money Az aktuális pénzmennyisége a takarítónak
     */
    public int getMoney(){
//        Prototype.increaseIndentation("Cleaner.getMoney()");
//        int money = Prototype.readNumber("Money: ", 0, 100000);
//        Prototype.decreaseIndentation("Cleaner.getMoney()");
        return money;
    }

    /**
     * visszaadja a takarító hókotróit tartalmazó listát
     * @return a takarító hókotróit tartalmazó lista
     */
    public Set<SnowPlower> getSnowplows(){
        return snowplows;
    }

    /**
     * egy vásárlást válósít meg
     * @param snowPlower Az adott hókotrója, aminek vásárolni akar
     * @param item Amit vásárolni akar
     * @param count Amekkora mennyiségben vásárolni akarja
     */
    public void purchase(SnowPlower snowPlower, ItemType item, int count){
        System.out.println("purchase()");
        System.out.println("return purchase()");
    }

    @Override
    public String toString() {
        try {
            return "cleaner: " + Prototype.getId(this) +
                " | money: " + money +
                " | snowplowers: " + snowplows.size()
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
                    "cleaner: " + Prototype.getId(this) +
                    " | money: " + money +
                    " | snowplowers: " + Logger.buildStringFromCollection(snowplows, '{', '}', ";")
                );
            }
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
