package hokotro;

import hokotro.roadnetwork.Lane;
import hokotro.util.ILogable;
import hokotro.util.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class Prototype {

    private static final Set<String> VALID_OBJECT_TYPES = Set.of(
        "vehicle",
        "snowplower",
        "lane",
        "crossing",
        "road",
        "cleaner"
        // TODO: add all the object types
    );

    // To support bi-directionality: ID -> Object AND Object -> ID
    private static final Map<String, Object> idToObject = new HashMap<>();
    private static final Map<Object, String> objectToId = new HashMap<>();

    public static void main(String[] args) {

        Scanner scannerIn = new Scanner(System.in);
        while (scannerIn.hasNextLine()) {
            String command = scannerIn.nextLine();

            if (!command.isBlank() && !command.startsWith("#")) {
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

    private static void executeCommand(String command) {
        // Split the command into tokens (handles multiple spaces, trims automatically)
        String[] tokens = command.trim().split("\\s+");

        if (tokens.length == 0) {
            Logger.logERROR("Cannot parse the following command: " + command);
            return;
        }

        String cmd = tokens[0];

        switch (cmd) {
            case "random"   -> handleRandom(tokens);
            case "create"   -> handleCreate(tokens);
            case "tick"     -> handleTick(tokens);
            case "buy"      -> handleBuy(tokens);
            case "equip"    -> handleEquip(tokens);
            case "list"     -> handleList(tokens);
            case "connect"  -> handleConnect(tokens);
            case "set"      -> handleSet(tokens);
            case "add"      -> handleAdd(tokens);
            case "reduce"   -> handleReduce(tokens);
            case "choose"   -> handleChoose(tokens);
            case "get"      -> handleGet(tokens);

            default -> Logger.logERROR("Unknown command: " + cmd);
        }
    }

    private static void handleRandom(String[] args) {
        // TODO: implement
    }

    private static void handleCreate(String[] args) {
        // TODO: implement
    }

    private static void handleTick(String[] args) {
        // TODO: implement
    }

    private static void handleBuy(String[] args) {
        // TODO: implement
    }

    private static void handleEquip(String[] args) {
        // TODO: implement
    }

    private static void handleList(String[] args) {
        // Default values
        boolean verbose = false;
        String type = null;
        List<String> ids = new ArrayList<>();

        for (int i = 1; i < args.length; i++) {
            String argument = args[i];

            // Check for the verbose flag (can appear anywhere)
            if (argument.equals("--verbose")) {
                verbose = true;
                continue;
            }

            // If we haven't found the type yet AND this argument is a known object type
            if (type == null && VALID_OBJECT_TYPES.contains(argument)) {
                type = argument;
            } else {
                // Everything else is an ID
                ids.add(argument);
            }
        }

        // -------------------------------------------------
        // Decide which case we are in and call the right method
        // (replace the comments with your actual calls)
        // -------------------------------------------------

        // List ALL objects
        if (type == null && ids.isEmpty()) {
            for (Object object: objectToId.keySet()) {
                if (object instanceof ILogable logable) {
                    logable.log(verbose);
                }
            }
        }

        // List <type>
        else if (type != null && ids.isEmpty()) {
            // List all objects of that specific type
            // yourListObjectsByType(type, verbose);

        } else {
            // list [type] <id1> <id2> <id3> ...
            // List specific objects (type is optional)
        }
    }

    private static void handleConnect(String[] args) {
        // TODO: implement
    }

    private static void handleSet(String[] args) {
        // TODO: implement
    }

    private static void handleAdd(String[] args) {
        // TODO: implement
    }

    private static void handleReduce(String[] args) {
        // TODO: implement
    }

    private static void handleChoose(String[] args) {
        // TODO: implement
    }

    private static void handleGet(String[] args) {
        // TODO: implement
    }

    private static void logExit() {
        System.out.println("Prototype has exited successfully");
    }
}