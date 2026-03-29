package hokotro;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import hokotro.player.BusDriver;
import hokotro.player.Cleaner;
import hokotro.roadnetwork.Crossing;
import hokotro.roadnetwork.Lane;
import hokotro.roadnetwork.Road;
import hokotro.roadnetwork.RoadNetwork;
import hokotro.roadnetwork.SurfaceCondition;
import hokotro.system.Economy;
import hokotro.system.GameDirector;
import hokotro.vehicle.Bus;
import hokotro.vehicle.Car;
import hokotro.vehicle.SnowPlower;
import hokotro.system.Timer;
import hokotro.head.*;

public class Skeleton {
    private static Map<String, Object> objects = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initialize();

        int testCase = -1;
        System.out.println("Starting the Hokotro Skeleton…");
        do {
            System.out.println("Available test-cases:");
            System.out.println("1. Enter a Lane");
            System.out.println("2. Choosing the lane in a crossing");
            System.out.println("3. Purchasing an item");
            System.out.println("4. Buying a new snowplower");
            System.out.println("5. Changing the snowplower’s head");
            System.out.print("Choose test-case (1-5):");

            
            if (scanner.hasNextInt()){
                testCase = scanner.nextInt();

                switch (testCase) {
                    case 1 -> testCase1();
                    case 2 -> testCase2();
                    case 3 -> testCase3();
                    case 4 -> testCase4();
                    case 5 -> testCase5();
                    case 0 -> System.out.println("Exiting...");
                }
            } else {
                String junk = scanner.next();
                System.out.println("Invalid choice, try again.");
            }
        } while (testCase != 0);
        scanner.close();
    }

    private static void initialize() {
        System.out.println("--- Initializing Object Graph ---");

        // 1: create GameDirector
        GameDirector gd = new GameDirector();
        objects.put("gd", gd);

        // 1.1: create RoadNetwork
        RoadNetwork rn = new RoadNetwork();
        objects.put("rn", rn);

        // 1.1.1 & 1.1.2: Crossings
        objects.put("cr1", new Crossing());
        objects.put("cr2", new Crossing());

        // 1.1.3: Road 1 and its hierarchy
        Road r1 = new Road();
        objects.put("r1", r1);
        
        Lane l1 = new Lane();
        objects.put("l1", l1);
        objects.put("sc1", new SurfaceCondition()); // 1.1.3.1.1
        
        Lane l2 = new Lane();
        objects.put("l2", l2);
        objects.put("sc2", new SurfaceCondition()); // 1.1.3.2.1

        // 1.1.4: Road 2 and its hierarchy
        Road r2 = new Road();
        objects.put("r2", r2);
        
        Lane l3 = new Lane();
        objects.put("l3", l3);
        objects.put("sc3", new SurfaceCondition()); // 1.1.4.1.1

        // 1.2: Cleaner and SnowPlower hierarchy
        Cleaner c = new Cleaner();
        objects.put("c", c);
        
        SnowPlower s = new SnowPlower();
        objects.put("s", s);
        
        Sweeper h = new Sweeper();
        objects.put("h", h);

        // 1.3: BusDriver and Bus
        BusDriver bd = new BusDriver();
        objects.put("bd", bd);
        objects.put("b", new Bus());

        // 1.4 & 1.5: Cars
        objects.put("c1", new Car());
        objects.put("c2", new Car());

        // 1.6: Timer
        objects.put("t", new Timer());

        // 1.7: Economy
        objects.put("e", new Economy());

        System.out.println("Initialization complete. " + objects.size() + " objects created.");
    }

    private static void testCase1(){
    }

    private static void testCase2(){
    }

    private static void testCase3(){
    }

    private static void testCase4(){
    }

    private static void testCase5(){
    }
}