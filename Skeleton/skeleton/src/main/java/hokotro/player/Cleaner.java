package hokotro.player;

import hokotro.system.ItemType;
import hokotro.vehicle.SnowPlower;

/**
 * A hókotrókat vezető játékos, tárolja a pénzt és a hókotróit
 */
public class Cleaner extends Player {
    /* private Set<SnowPlower> snowplows;
    private int money; */

    /**
     * beállítja a takarító pénzmennyiségét
     * @param amount Az érték, amire be lesz állítva
     */
    public void setMoney(int amount) {
        System.out.println("setMoney()");
        System.out.println("return setMoney()");
    }

    /**
     * visszaadja a jelenlegi pénz mennyiségét
     * @return money Az aktuális pénzmennyisége a takarítónak
     */
    public int getMoney(){
        System.out.println("getMoney()");
        System.out.println("return getMoney()");
        return 0;
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
