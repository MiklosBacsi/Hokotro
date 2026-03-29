/**
 * interfész a takarítás megvalósítására
 */
public interface ICleanable {

    /**
     * kötelezően megvalósítandó függvény, ami a paraméterként kapott fej metódusát hívja
     * @param head a fej, ami megadja, hogy milyen takarítást kell végezni
     */
    public void clean(Head head);
}
