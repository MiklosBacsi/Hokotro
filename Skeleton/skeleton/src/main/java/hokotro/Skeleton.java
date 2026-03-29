package hokotro;
import java.util.Scanner;

public class Skeleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                String input = scanner.next();
                System.out.println("Invalid choice, try again.");
            }
        } while (testCase != 0);
        scanner.close();
    }

    private static void initialize(){}

    private static void testCase1(){
        initialize();
    }

    private static void testCase2(){
        initialize();
    }

    private static void testCase3(){
        initialize();
    }

    private static void testCase4(){
        initialize();
    }

    private static void testCase5(){
        initialize();
    }
}