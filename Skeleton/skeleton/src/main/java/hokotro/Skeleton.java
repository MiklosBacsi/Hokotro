package hokotro;
import java.util.HashMap;
import java.util.List;
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
import hokotro.system.ItemType;
import hokotro.vehicle.Bus;
import hokotro.vehicle.Car;
import hokotro.vehicle.SnowPlower;
import hokotro.system.Timer;
import hokotro.head.*;

public class Skeleton {

    private static int indentationCounter;

    public static Scanner scanner;

    private static Map<String, Object> objects = new HashMap<>();

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        initialize();

        int testCase = -1;
        System.out.println("Starting the Hokotro Skeleton…");
        do {
            System.out.println("\nAvailable test-cases:");
            System.out.println("0. Exit program");
            System.out.println("1. Enter a Lane");
            System.out.println("2. Choosing the lane in a crossing");
            System.out.println("3. Purchasing an item");
            System.out.println("4. Buying a new snowplower");
            System.out.println("5. Changing the snowplower’s head");
            System.out.print("Choose test-case (1-5):  ");

            
            if (scanner.hasNextInt()){
                testCase = scanner.nextInt();

                switch (testCase) {
                    case 1 -> testCase1();
                    case 2 -> testCase2();
                    case 3 -> testCase3();
                    case 4 -> testCase4();
                    case 5 -> testCase5();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice, try again.");
                }
            } else {
                String junk = scanner.next();
                System.out.println("Invalid choice, try again.");
            }
        } while (testCase != 0);
        scanner.close();
    }

    private static void initialize() {
        objects.clear();
        indentationCounter = 0;

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
        
        Sweeper sh = new Sweeper();
        objects.put("sh", sh);


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
    }

    private static void testCase1(){
        System.out.println("\n*** Starting testcase 1 ***");

        initialize();

        Car c1 = (Car) objects.get("c1");
        Lane l1 = (Lane) objects.get("l1");

        l1.addVehicle(c1);
    }

    private static void testCase2(){
        System.out.println("\n*** Starting testcase 2 ***");

        initialize();

        BusDriver bd = (BusDriver) objects.get("bd");
        Bus b = (Bus) objects.get("b");
        Crossing cr1 = (Crossing) objects.get("cr1");
        Road r1 = (Road) objects.get("r1");
        Lane l1 = (Lane) objects.get("l1");

        List<Road> roads = cr1.getRoads();

        Skeleton.readBool("Would you like to choose road 1 instead of road 2?");
        r1.getLanes(cr1);
        Skeleton.readBool("Would you like to choose lane 1 instead of lane 2?");
        l1.addVehicle(b);
    }

    private static void testCase3(){
        System.out.println("\n*** Starting testcase 3 ***");

        initialize();

        Economy e = (Economy) objects.get("e");
        Cleaner c = (Cleaner) objects.get("c");

        SnowPlower s = (SnowPlower) objects.get("s");

        int option = readNumber("1: SALT\n" +
                        "2: KEROSINE\n" +
                        "3: HEAD_SWEEPER\n" +
                        "4: HEAD_BLOWER\n" +
                        "5: HEAD_ICEBREAKER\n" +
                        "6: HEAD_SALTSPREADER\n" +
                        "7: HEAD_DRAGON\n",
                        1, 7);
        
        int amount = 1;
        
        if (option<=2) {
            amount = readNumber("", 1, 100000);
        }
        
        switch (option) {
            case 1:
                e.processPurchase(s, ItemType.SALT, amount,c);
                break;
            case 2:
                e.processPurchase(s, ItemType.KEROSINE, amount,c);
                break;
            
            case 3:
                e.processPurchase(s, ItemType.HEAD_SWEEPER, amount,c);
                break;
            case 4:
                e.processPurchase(s, ItemType.HEAD_BLOWER, amount,c);
                break;
            
            case 5:
                e.processPurchase(s, ItemType.HEAD_ICEBREAKER, amount,c);
                break;

            case 6:
                e.processPurchase(s, ItemType.HEAD_SALTSPREADER, amount,c);
                break;
            
            case 7:
                e.processPurchase(s, ItemType.HEAD_DRAGON, amount,c);
                break;

            default:
                break;
        }
        
    }

    private static void testCase4(){
        System.out.println("\n*** Starting testcase 4 ***");

        initialize();

        Cleaner c = (Cleaner) objects.get("c");
        Economy e = (Economy) objects.get("e");

        e.buyNewSnowPlower(c);
    }

    private static void testCase5(){
        System.out.println("\n*** Starting testcase 5 ***");

        initialize();

        SnowPlower sp = (SnowPlower) objects.get("s");
        IceBreaker ib = new IceBreaker();

        sp.changeHead(ib);
    }

    public static void increaseIndentation(String funcName) {
        indentationCounter++;
        Skeleton.print(funcName + " called");
    }

    public static void decreaseIndentation(String funcName) {
        Skeleton.print(funcName + " returned");
        indentationCounter--;
    }

    public static void print(String printable) {
        for (int i = 1; i < indentationCounter; i++) {
            System.out.print("\t");
        }
        System.out.println(printable);
    }

    public static boolean readBool(String question) {
        boolean isValid = false;
        boolean choice = false;

        do {
            System.out.print(question + " (y/n):  ");
            String choiceStr = scanner.next();

            if (choiceStr.equals("y")) { choice = true; isValid = true; }
            else if (choiceStr.equals("n")) { choice = false; isValid = true; }
        } while (!isValid);

        return choice;
    }

    public static int readNumber(String question,int min,int max) {
        boolean isValid = false;
        int choice = 0;

        do {
            System.out.print(question + "(" + min+"-"+max+")  ");
            choice = scanner.nextInt();

            if (choice >= min && choice <= max) {
                isValid = true;
            }
        } while (!isValid);

        return choice;
    }
}