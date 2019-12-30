import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] test = {2, 13, 6, 3, 9, 1, 7, 5, 5, 10, 2, 13, 6, 3, 9, 1, 7, 5, 5, 10, 2, 13, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 6, 3, 9, 1, 7, 5, 5, 10, 2, 13, 6, 3, 9, 1, 7, 5, 5, 10, 2, 13, 6, 3, 9, 1, 7, 5, 5, 10};
        System.out.println("length: " + test.length);
        Quicksort.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
