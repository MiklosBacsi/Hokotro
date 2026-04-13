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
            System.out.println(command);
        }

        System.out.println("Hello world!");

        for (int i=0; i<138; i++) {
            System.out.println("narancsos bukta");
        }
    }

    public static void increaseIndentation(String s) {
    }

    public static void print(String s) {
    }

    public static void decreaseIndentation(String s) {
    }

    public static boolean readBool(String s) {
        return true;
    }

    public static int readNumber(String s, int i, int i1) {
        return 0;
    }
}