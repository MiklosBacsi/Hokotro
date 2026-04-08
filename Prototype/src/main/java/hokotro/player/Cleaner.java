package hokotro.player;

import hokotro.Prototype;

import hokotro.system.ItemType;
import hokotro.vehicle.SnowPlower;

/**
 * A hókotrókat vezető játékos, tárolja a pénzt és a hókotróit
 */
public class Cleaner extends Player {
    private Set<SnowPlower> snowplows;
    private int money;

    /**
     * beállítja a takarító pénzmennyiségét
     * @param amount Az érték, amire be lesz állítva
     */
    public void decreaseMoney(int amount) {
        Prototype.increaseIndentation("decreaseMoney()");
        Prototype.print("Money decreased");
        Prototype.decreaseIndentation("decreaseMoney()");
    }

    /**
     * visszaadja a jelenlegi pénz mennyiségét
     * @return money Az aktuális pénzmennyisége a takarítónak
     */
    public int getMoney(){
        Prototype.increaseIndentation("Cleaner.getMoney()");
        int money = Prototype.readNumber("Money: ", 0, 100000);
        Prototype.decreaseIndentation("Cleaner.getMoney()");
        return money;
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

}
