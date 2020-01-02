public class Quicksort {
    private static int swaps = 0;

    private Quicksort() {
    }

    public static void sort(int[] unsorted) {
        if (unsorted != null && unsorted.length > 1) {
            sort(unsorted, 0, unsorted.length - 1);
        }
    }

    private static void sort(int[] unsorted, int low, int high) {
        int pivot = findPivot(unsorted, low, high);

        if (pivot != -1 && low < high) {
            swap(unsorted, pivot, high);
            int middle = partition(unsorted, low, high);
            swap(unsorted, middle, high);

            sort(unsorted, low, middle - 1);
            sort(unsorted, middle + 1, high);
        }
    }

    private static int findPivot(int[] arr, int low, int high) {
        for (int i = low + 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                return (low + high) / 2;
            }
        }
        return -1;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        while (low < high) {
            while (low < high && arr[low] < pivot) {
                low++;
            }
            while (high > low && arr[high] >= pivot) {
                high--;
            }
            if (low < high) {
                swap(arr, low, high);
            }
        }
        return low;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        swaps++;
    }
}