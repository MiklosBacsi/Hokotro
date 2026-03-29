package hokotro.head;

import hokotro.roadnetwork.Lane;

/**
 * A havat és feltört jeget átteszi a jobb oldali sávba.
 */
public class Sweeper extends Head {
    /**
     * A havat és feltört jeget átteszi a jobb oldali sávba.
     *
     * @param l a sáv, amelyben a hatás érvényesül
     */
    void applyEffect(Lane l){
        System.out.println("Sweeper.applyEffect() called");
        System.out.println("Sweeper.applyEffect() returned");
    }
}
