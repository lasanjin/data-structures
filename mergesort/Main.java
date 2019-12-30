import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 7, 1, 9, 21, 7, 3, 1, 6, 33, 2, 457, 1, 46, 1, 14, 25, 36, 47, 74, 52, 11, 2, 0, 1};
        System.out.println(arr.length);
        Mergesort.mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
