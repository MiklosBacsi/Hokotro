package hokotro.roadnetwork;

import hokotro.Prototype;
import hokotro.util.ILogable;
import hokotro.util.Logger;

/**
 * Az út egy típusa, amely nem továbbítja a sávjai felé a havazást.
    * Ez a típusú út nem továbbítja a havazást a sávjai felé, így azok nem lesznek járhatatlanok.
 */
public class Tunnel extends Road {
    /**
     * Üresen hagyva felüldefiniálja az őse metódusát.
     *
     * @param amount a lehulló hó mennyisége
     */
    @Override
    public void letItSnow(int amount){
        // Nem továbbítja a havazást a sávjai felé, így azok nem lesznek járhatatlanok.
    }

    @Override
    public String toString() {
        try {
            return "tunnel: " + Prototype.getId(this) +
                " | lanes1: " + lanes1.size() +
                " | lanes2: " + lanes2.size()
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
                    "tunnel: " + Prototype.getId(this) +
                    " | lanes1: " + Logger.buildStringFromCollection(lanes1, '[', ']', ";") +
                    " | lanes2: " + Logger.buildStringFromCollection(lanes2, '[', ']', ";")
                );
            }
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
