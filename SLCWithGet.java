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

        //Om listan är tom så lägg till head.
        if (super.isEmpty()) {
            super.head = new Entry(element, null);
            size++;
            return true;
        }

        Entry current = head;
        Entry previous;

        //Om element är mindre än head så sätt element som head.
        if (element.compareTo(current.element) < 1) {
            head = new Entry(element, current);
            return true;
        }
        current = current.next;
        previous = head;

        //Om element är större än head så jämför vidare.
        while (current != null) {

            if (element.compareTo(current.element) < 1) {
                previous.next = new Entry(element, current);
                return true;
            }
            previous = current;
            current = current.next;
        }

        //Om element är "störst" så lägg till element sist.
        previous.next = new Entry(element, null);
        return true;
    }

    /**
     * @param comparable <E>element
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