/**
 * Az út egy típusa, amely nem továbbítja a sávjai felé a havazást.
    * Ez a típusú út nem továbbítja a havazást a sávjai felé, így azok nem lesznek járhatatlanok.
 */
public class Tunnel extends Road{
    /**
     * Üresen hagyva felüldefiniálja az őse metódusát.
     *
     * @param amount a lehulló hó mennyisége
     */
    public void letItSnow(int amount){
            System.out.println("Tunnel.letItSnow() called");
            System.out.println("Tunnel.letItSnow() returned");
    }
}
