import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Heapsort hs = new Heapsort();

        hs.add(2);
        hs.add(6);
        hs.add(7);
        hs.add(12);
        hs.add(1);
        hs.add(11);
        hs.add(9);

        int size = hs.size();
/*        for (int i = 0; i < size; i++) {
            System.out.println(hs.poll());
        }

*/
        Iterator i = hs.iterator();

        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
