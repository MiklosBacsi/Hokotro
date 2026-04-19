package hokotro.head;

import hokotro.roadnetwork.Lane;
import hokotro.system.ItemType;
import hokotro.util.ILogable;
import hokotro.vehicle.SnowPlower;

public abstract class Head implements ILogable {
    protected SnowPlower snowPlower;

    /**
     * absztrakt osztály, a takarítás megvalósítása
     * @param lane A sáv, amin a takarítást meg kell valósítsa
      */
    public abstract void applyEffect(Lane lane);

    public abstract ItemType getType();
}
