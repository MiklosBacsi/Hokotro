package hokotro.head;

import hokotro.roadnetwork.Lane;

public abstract class Head {
    /* private SnowPlower snowPlower; */

    /**
     * absztrakt osztály, a takarítás megvalósítása
     * @param lane A sáv, amin a takarítást meg kell valósítsa
      */
    public void ApplyEffect(Lane lane){}
}
