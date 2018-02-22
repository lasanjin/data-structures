
import java.util.*;

public class DirectedGraph<E extends Edge> {
    private int nEdge;
    private List<E>[] edges;

    public DirectedGraph(int noOfNodes) {
        nEdge = noOfNodes + 1;// Finns ingen nod 0. Detta löser problemet.
        edges = new List[nEdge];
        fillList();
    }

    private void fillList() {
        for (int i = 0; i < nEdge; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    public void addEdge(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (e.from < 0 && e.from <= nEdge) {
            throw new IndexOutOfBoundsException();
        }

        // TODO Ska göra en koll till?

        edges[e.from].add(e);
    }

    public Iterator<E> shortestPath(int from, int to) {
        return (new BuildDijkstraPath(edges, to, from)).getDijkstraPath().iterator();

    }

    public Iterator<E> minimumSpanningTree() {
        return BuildKruskalGraph.getKruskalGraph(nEdge, edges).iterator();
    }
}