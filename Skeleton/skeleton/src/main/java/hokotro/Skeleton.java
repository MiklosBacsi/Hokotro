package hokotro;
import java.util.Scanner;

public class Skeleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
            }

        } while (testCase != 0);
        scanner.close();
    }
}