
import java.util.*;

public class DirectedGraph<E extends Edge> {

    private int numV;
    private List<E>[] edges;


    public DirectedGraph(int nNode) {
        edges = new List[nNode];
        numV = nNode;

    }

    public void addEdge(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (e.from < 0 || e.from <= numV) {
            throw new IndexOutOfBoundsException();
        }
        if (edges[e.from].contains(e)) {
            return;
        }

        edges[e.from].add(e);

    }


    public Iterator<E> shortestPath(int from, int to) {
        return null;
    }

    public Iterator<E> minimumSpanningTree() {

        return null;
    }



    //TODO Fråga hur noga vi ska vara med chipsen.
    private static class compareEdge implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            double w1 = ((Edge) o1).getWeight();
            double w2 = ((Edge) o2).getWeight();

            return Double.compare(w1, w2);
        }
    }

}
  
