import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Blockchain<Block> implements Serializable {
    private static final long serialVersionUID = 6838415275258317827L;

    private final int INITIAL_CAPACITY = 10;
    private Block[] blocks;
    private int size = 0;
    private int capacity = 0;


    public Blockchain() {
        capacity = INITIAL_CAPACITY;
        blocks = (Block[]) new Object[capacity];
    }

    public boolean add(Block block) {
        if (size == capacity) {
            reallocate();
        }
        blocks[size++] = block;
        return true;
    }

    private void reallocate() {
        capacity = capacity + (capacity >> 1);
        Block[] newBlocks = (Block[]) new Object[capacity];
        System.arraycopy(blocks, 0,
                newBlocks, 0, size);
    }

    public Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;


        return false;
    }

    public Iterator<Block> iterator() {
        return new BlockchainIterator();
    }

    private class BlockchainIterator implements Iterator {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex >= 0 && currentIndex < size;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return blocks[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
