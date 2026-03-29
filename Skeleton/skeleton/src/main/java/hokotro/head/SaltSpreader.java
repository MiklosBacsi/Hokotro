package hokotro.head;

import hokotro.roadnetwork.Lane;

/**
 * Felsózza az adott sávot.
 */
public class SaltSpreader extends Head {
    /**
     * Felsózza az adott sávot.
     *
     * @param lane a sáv, amelyben a hatás érvényesül
     */
    void applyEffect(Lane lane){
        System.out.println("SaltSpreader.applyEffect() called");
        System.out.println("SaltSpreader.applyEffect() returned");
    }
}
