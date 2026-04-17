package hokotro.roadnetwork;

import hokotro.Prototype;
import hokotro.util.ILogable;
import hokotro.util.Logger;

/**
 * Sózott sáv esetén az időzítő hatására olvasztja a havat, ellenőrzi, hogy a hónak jéggé kell-e alakulnia
 * A sávok állapotát tárolja.
 */
public class SurfaceCondition implements ILogable {
    private int snowThickness;
    private int driveCount;
    private int iceThickness;
    private int rockHeight;
    private boolean isSalted;
    private boolean isRocky;

    /**
     * Havat szór az útra, növelve a hóvastagságot.
     * @param amount a lehullott hó mennyisége, amely a hóvastagságot növeli
     */
    public void letItSnow(int amount){
        System.out.println("SurfaceCondition.letItSnow() called");
        System.out.println("SurfaceCondition.letItSnow() returned");
    }

    /**
     * Olvasztja a sózott utat.
     */
    public void meltSnow(){
        System.out.println("SurfaceCondition.meltSnow() called");
        System.out.println("SurfaceCondition.meltSnow() returned");
    }

    /**
     * A havat jéggé tömöríti.
     */
    public void compressSnow(){
        System.out.println("SurfaceCondition.compressSnow() called");
        System.out.println("SurfaceCondition.compressSnow() returned");
    }

    // TODO: implement
    public int getTopSnowHeight() {
        return 0;
    }

    @Override
    public String toString() {
        try {
            return "condition: " + Prototype.getId(this) +
                " | snow: " + getTopSnowHeight() +
                " | ice: " + iceThickness +
                " | salted: " + isSalted +
                " | rocky: " + isRocky +
                " | rock: " + rockHeight +
                " | drive-count: " + driveCount
            ;
        } catch (Exception e) {
            Logger.logERROR(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void log(boolean verbose) {
        Logger.logOK(this.toString());
        // TODO: Finish the
    }
}
