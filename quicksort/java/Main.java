import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Random rand = new Random();

    public static void main(String[] args) {
        String input = args(args);
        int len = len(input);

        int[] randArr = new int[len];
        for (int i = 0; i < len; i++) {
            randArr[i] = rand.nextInt(100);
        }

        print(randArr);
    }

    private static String args(String[] args) {
        String input;
        if (args.length == 0) {
            System.out.print("Enter length of random int[]: ");
            System.out.flush();
            input = new Scanner(System.in).nextLine();
            System.out.println();
        } else {
            input = args[0];
        }
        return input;
    }

    private static int len(String input) {
        int len;
        try {
            len = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, length set to 100");
            len = 100;
        }
        return len;
    }

    private static void print(int[] sorted) {
        System.out.println("Unsorted: \n" + Arrays.toString(sorted) + "\n");
        Quicksort.sort(sorted);
        System.out.println("Sorted: \n" + Arrays.toString(sorted));
    }
}
