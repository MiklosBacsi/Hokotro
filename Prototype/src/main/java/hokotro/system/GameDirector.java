package hokotro.system;

import hokotro.player.Player;
import hokotro.roadnetwork.RoadNetwork;
import hokotro.vehicle.Car;

import java.util.Set;

/**
 * a fő vezérlő osztály, az inicializálást végzi
 */
public class GameDirector {
    private RoadNetwork roadNetwork;
    private Timer timer;
    private Set<Player> players;
    private Set<Car> cars;

    /**
     * inicalizálja a játékteret
      */
    public void initializeGame(){
        System.out.println("initializeGame()");
        System.out.println("return initializeGame()");
    }

    /**
     * létrehoz új autókat
     */
    public void createCar(){
        System.out.println("createCar()");
        System.out.println("return createAuto()");
    }
}
