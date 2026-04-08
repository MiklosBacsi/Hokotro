package hokotro.head;

import hokotro.roadnetwork.Lane;

/**
 * Felsózza az adott sávot.
 */
public class SaltSpreader extends Head {
    static int consume;
    /**
     * Felsózza az adott sávot.
     *
     * @param lane a sáv, amelyben a hatás érvényesül
     */
    @Override
    public void applyEffect(Lane lane){
        System.out.println("SaltSpreader.applyEffect() called");
        System.out.println("SaltSpreader.applyEffect() returned");
    }
}
