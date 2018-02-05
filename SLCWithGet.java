public class SLCWithGet<E extends Comparable<? super E>> extends LinkedCollection<E>
        implements CollectionWithGet<E> {

    public SLCWithGet() {
        super();
    }

    @Override
    public boolean add(E element) {
        if (super.size() > 0) {
            Entry previous = head;
            Entry current = head;

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
        }
        return super.add(element);
    }

    @Override
    public E get(E comparable) {
        if (comparable == null || head == null) {
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
}
