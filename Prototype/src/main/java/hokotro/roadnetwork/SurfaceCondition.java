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


    public int getSnowThickness(){
        return snowThickness;
    }
    public void setSnowThickness(int snowThickness) {
        this.snowThickness = snowThickness;
    }
    public int getDriveCount() {
        return driveCount;
    }

    public void setDriveCount(int driveCount) {
        this.driveCount = driveCount;
    }

    public int getIceThickness(){
        return iceThickness;
    }
    public void setIceThickness(int iceThickness) {
        this.iceThickness = iceThickness;
    }
    public int getRockHeight(){
        return rockHeight;
    }
    public void setRockHeight(int rockHeight) {
        this.rockHeight = rockHeight;
    }
    public boolean getIsSalted(){
        return isSalted;
    }
    public void setSalted(boolean salted) {
        isSalted = salted;
    }
    public boolean getIsRocky() {
        return isRocky;
    }

    public void setRocky(boolean rocky) {
        isRocky = rocky;
    }


    @Override
    public String toString() {
        try {
            return "condition: " + Prototype.getId(this) +
                " | snow: " + snowThickness +
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
    }
}
