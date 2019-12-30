import java.util.HashSet;
import java.util.Iterator;

public class Graph {
    private HashSet<Edge>[] edges;
    private int numV;
    private boolean directed;

    public Graph(boolean directed, int numV) {
        this.numV = numV;
        this.directed = directed;
        this.edges = new HashSet[numV];
        initGraph();
    }

    private void initGraph() {
        for (int i = 0; i < numV; i++) {
            edges[i] = new HashSet();
        }
    }

    public boolean isDirected() {
        return directed;
    }

    public boolean isEdge(int source, int destination) {
        return edges[source].contains(new Edge(source, destination));
    }

    public Iterator<Edge> edgeIterator(int source) {
        return edges[source].iterator();
    }

    public void insert(Edge edge) {
        if (edge == null) {
            throw new IllegalStateException();
        }

        if (edge.getSource() < 0
                || edge.getSource() >= edges.length) {
            throw new IndexOutOfBoundsException();
        }

        edges[edge.getSource()].add(edge);

        if (!directed) {
            edges[edge.getDestination()].add(
                    new Edge(edge.getDestination()
                            , edge.getSource()
                            , edge.getWeight()));
        }
    }

    public Edge getEdge(Edge edge) {
        return null;
    }

    public int getNumV() {
        return numV;
    }
}
