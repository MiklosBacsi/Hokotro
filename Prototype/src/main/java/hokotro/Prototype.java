package hokotro;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prototype {

    private static int indentationCounter;

    public static Scanner scanner;

    // To support bi-directionality: ID -> Object AND Object -> ID
    private static final Map<String, Object> idToObject = new HashMap<>();
    private static final Map<Object, String> objectToId = new HashMap<>();

    public static void main(String[] args) {

        Scanner scannerIn = new Scanner(System.in);
        while (scannerIn.hasNextLine()) {
            String command = scannerIn.nextLine();

            if (!command.isBlank()) {
                executeCommand(command);
            }
        }

        logExit();
    }

    // Add Object to both HashMaps
    public static void add(String key, Object value) {
        if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        // Enforce uniqueness of values (for true bidirectionality)
        if (objectToId.containsKey(value)) {
            throw new IllegalArgumentException("Duplicate value not allowed: " + value);
        }

        idToObject.put(key, value);
        objectToId.put(value, key);
    }

    // Get Object from ID
    public static Object getObject(String key) {
        return idToObject.get(key);
    }

    // Get ID from Object
    public static String getId(Object value) {
        return objectToId.get(value);
    }

    // Remove by ID
    public static void remove(String key) {
        Object value = idToObject.remove(key);
        if (value != null) {
            objectToId.remove(value);
        }
    }

    // Remove by Object
    public static void remove(Object value) {
        String key = objectToId.remove(value);
        if (key != null) {
            idToObject.remove(key);
        }
    }

    public static void logOK(String log) {
        System.out.println("OK " + log);
    }

    public static void logERROR(String message) {
        System.out.println("ERROR " + message);
    }

    private static void logExit() {
        System.out.println("Prototype has exited successfully");
    }

    private static void executeCommand(String command) {
        // TODO
        System.out.println(command);

        // TODO: list: object.log()
    }
}