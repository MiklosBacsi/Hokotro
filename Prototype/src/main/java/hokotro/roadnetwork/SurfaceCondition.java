package hokotro.roadnetwork;

/**
 * Sózott sáv esetén az időzítő hatására olvasztja a havat, ellenőrzi, hogy a hónak jéggé kell-e alakulnia
 * A sávok állapotát tárolja.
 */
public class SurfaceCondition {
    private int snowThickness;
    private int driveCount;
    private int iceThickness;
    private boolean isSalted;

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
}
