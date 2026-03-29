/**
 * Adott időközönként jelzést ad a rendszernek.
 */
public class Timer {
    /**
     * 4 eventet lő a következő sorrendben:
     * Só olvadás.
     * Hóesés.
     * Buszok várakozása újraindulásnál.
     * Járművek move metódusának eventje.
     */
    private void tick(){
        System.out.println("Timer.tick() called");
        System.out.println("Timer.tick() returned");
    }
}
