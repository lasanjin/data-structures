import java.util.Iterator;

public class SLCWithGet<E extends Comparable<? super E>> extends LinkedCollection<E>
        implements CollectionWithGet<E> {

    public SLCWithGet() {
        super();
    }

    private int size;

    @Override
    public boolean add(E element) {
        if (size > 0) {
            size++;
            Entry previous = head;
            Entry current = head;

            if (element.compareTo(head.element) < 1) {
                head = new Entry(element, head);
                return true;
            }
            current = current.next;

            while (current != null) {

                if (element.compareTo(current.element) < 1) {
                    Entry newEntry = new Entry(element, current);
                    previous.next = newEntry;
                    return true;
                }
                previous = current;
                current = current.next;
            }

            previous.next = new Entry(element, null);
            return true;
        }
        super.head = new Entry(element, null);
        size++;
        return true;
    }

    @Override
    public E get(E comparable) {
        if (comparable == null) {
            return null;
        }

        Entry current = head;

        while (current != null) {
            if (comparable.compareTo(current.element) == 0) {
                return current.element;
            }
            current = current.next;
        }
        System.out.println("END get while");
        return null;
    }
}
