import java.util.Arrays;
import java.util.Iterator;

public class Heapsort {
    private int capacity = 10;
    private int size = 0;

    private int[] items;

    public Heapsort() {
        items = new int[capacity];
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        return items[0];
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int item = items[0];
        items[0] = items[size-- - 1];
        heapDown();
        return item;
    }

    public void add(int item) {
        ensureCapacity();
        items[size++] = item;
        heapUp();
    }

    public int size() {
        return size;
    }

    private void heapUp() {
        int index = size - 1;

        while (hasParent(index) && getParent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int smallerChildIndex = hasRightChild(index) && rightChild(index) < leftChild(index) ?
                    getRightChildIndex(index) : getLeftChildIndex(index);

            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int getParent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexTwo];
        items[indexTwo] = items[indexOne];
        items[indexOne] = temp;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity << 2);
            capacity = capacity << 2;
        }
    }

    public Iterator iterator() {
        return new heapIterator();
    }

    private class heapIterator implements Iterator {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return size >= 0 && currentIndex < size;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                return null;
            }
            return items[currentIndex++];
        }
    }
}