package hokotro;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Prototype {

    private static int indentationCounter;

    public static Scanner scanner;

    private static Map<String, Object> objects = new HashMap<>();

    public static void main(String[] args) {

        Scanner scannerIn = new Scanner(System.in);
        while (scannerIn.hasNextLine()) {
            String command = scannerIn.nextLine();

            if (!command.isBlank()) {
                executeCommand(command);
            }
        }

        System.out.println("Hello world!");

        for (int i=0; i<138; i++) {
            System.out.println("narancsos bukta");
        }

        logExit();
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
    }
}