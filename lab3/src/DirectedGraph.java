
import java.util.*;

public class DirectedGraph<E extends Edge> {
    private int numV;
    private List<E>[] edges;


    public DirectedGraph(int nNode) {
        numV = nNode + 1;
        edges = new List[numV];
        fillList();
    }

    private void fillList() {
        for (int i = 0; i < numV; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    public void addEdge(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (e.from < 0 && e.from <= numV) {
            throw new IndexOutOfBoundsException();
        }
        
        // TODO ska göra en koll till?

        edges[e.from].add(e);

    }

    public Iterator<E> shortestPath(int from, int to) {
        return (new CompDijkstraPath(edges, to, from)).getPath().iterator();

    }

    public Iterator<E> minimumSpanningTree() {
        return CompKruskalEdge.getKruskalGraph(numV, new CompareEdge(), edges).iterator();
    }

    private static class CompareEdge implements Comparator {

        //TODO Fråga hur noga vi ska vara med chipsen.

        @Override
        public int compare(Object o1, Object o2) {
            double w1 = ((Edge) o1).getWeight();
            double w2 = ((Edge) o2).getWeight();

            return Double.compare(w1, w2);
        }
    }
}