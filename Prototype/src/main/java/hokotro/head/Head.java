package hokotro.head;

import hokotro.roadnetwork.Lane;
import hokotro.util.ILogable;
import hokotro.vehicle.SnowPlower;

public abstract class Head implements ILogable {
    protected SnowPlower snowPlower;

    /**
     * absztrakt osztály, a takarítás megvalósítása
     * @param lane A sáv, amin a takarítást meg kell valósítsa
      */
    public void applyEffect(Lane lane){}
}
