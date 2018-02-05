public class SLCWithGet<E extends Comparable<? super E>>
        extends LinkedCollection<E>
        implements CollectionWithGet<E> {

    private int size;

    public SLCWithGet() {
        super();
    }

    @Override
    public boolean add(E element) {
        //Om listan �r tom s� l�gg till head.
        if (super.isEmpty()) {
            super.head = new Entry(element, null);
            size++;
            return true;
        }

        Entry current = head;
        Entry previous;

        //Om element �r mindre �n head s� s�tt element som head.
        if (element.compareTo(current.element) < 1) {
            head = new Entry(element, current);
            return true;
        }
        current = current.next;
        previous = head;

        //Om element �r st�rre �n head s� j�mf�r vidare.
        while (current != null) {

            if (element.compareTo(current.element) < 1) {
                previous.next = new Entry(element, current);
                return true;
            }
            previous = current;
            current = current.next;
        }

        //Om element �r "st�rst" s� l�gg till element sist.
        previous.next = new Entry(element, null);
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

        return null;
    }

    public int getSize() {
        return size;
    }
}
