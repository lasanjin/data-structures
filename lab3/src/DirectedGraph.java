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

    public void addEdge(E edge) {
        if (edge == null) {
            throw new NullPointerException();
        }
        if (edge.from < 0 && edge.from <= nEdge) {
            throw new IndexOutOfBoundsException();
        }

        edges[edge.from].add(edge);
    }

    public Iterator<E> shortestPath(int from, int to) {
        return (new DijkstraPathBuilder(edges, to, from)).getDijkstraPath().iterator();
    }

    public Iterator<E> minimumSpanningTree() {
        return KruskalGraphBuilder.getKruskalGraph(nEdge, edges).iterator();
    }
}