import javax.naming.OperationNotSupportedException;
import java.util.concurrent.ConcurrentSkipListSet;

public class SLCWithGet<E extends Comparable<? super E>>
        extends LinkedCollection<E>
        implements CollectionWithGet<E> {

    private int size;

    public SLCWithGet() {
        super();
    }

    /**
     * @param element the object to add into the list
     * @return true if <E> element is added, otherwise false.
     */
    @Override
    public boolean add(E element) {
        if (element == null) {
            return false;
        }

        size++; //Vi gör detta 1 gång.

        //Om listan är tom så lägg till head.
        if (isEmpty()) {
            head = new Entry(element, null);
            return true;
        }

        if (element.compareTo(head.element) < 1) {//Om element < head, så head = element.
            head = new Entry(element, head);
            return true;
        }

        Entry previous = head;
        Entry current = head.next;

        //Jämför vidare. Om element < current, så previous = element.
        while (current != null) {
            if (element.compareTo(current.element) < 1) {
                previous.next = new Entry(element, current);
                return true;
            }

            previous = current;
            current = current.next;
        }

        //"Störst" element sist.
        previous.next = new Entry(element, null);
        return true;
    }

    /**
     * @param comparable <E> element
     * @return <E> comparable if element is in list, otherwise null;
     */
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

        return null;
    }

    /**
     * @return size of list.
     */
    @Override
    public int size() {
        return size;
    }
}