public class Mergesort {

    private Mergesort() {
    }

    public static void mergesort(int[] unsorted) {
        int length = unsorted.length;
        if (unsorted == null || length < 1) {
            return;
        }
        mergesort(unsorted, new int[length], 0, length - 1);
    }

    private static void mergesort(int[] unsorted, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergesort(unsorted, temp, leftStart, middle);
        mergesort(unsorted, temp, middle + 1, rightEnd);
        mergeArrays(unsorted, temp, leftStart, rightEnd);
    }

    private static void mergeArrays(int[] unsorted, int[] temp, int leftStart, int rightEnd) {
        int left = leftStart;
        int leftEnd = (leftStart + rightEnd) / 2;
        int right = leftEnd + 1;
        int index = leftStart;
        int size = rightEnd - leftStart + 1;

        while (left <= leftEnd && right <= rightEnd) {
            if (unsorted[left] < unsorted[right]) {
                temp[index] = unsorted[left];
                left++;
            } else {
                temp[index] = unsorted[right];
                right++;
            }
            index++;
        }

        System.arraycopy(unsorted, left, temp, index, leftEnd - left + 1);
        System.arraycopy(unsorted, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, unsorted, leftStart, size);
    }
}
