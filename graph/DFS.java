import java.util.Iterator;

public class DFS {
    private Graph graph;
    private int[] parent;
    private boolean[] visited;

    private int[] discOrder;
    private int[] finOrder;
    private int discIndex;
    private int finIndex;

    public DFS(Graph graph) {
        this.graph = graph;
        int n = graph.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

        discOrder = new int[n];
        finOrder = new int[n];
    }

    public int[] getDFS() {
        int n = graph.getNumV();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(i);
            }
        }
        return parent;
    }

    private void DFS(int current) {
        visited[current] = true;

        Iterator<Edge> i = graph.edgeIterator(current);

        discOrder[discIndex++] = current;

        while (i.hasNext()) {
            int neighbor = i.next().getDestination();

            if (!visited[neighbor]) {
                parent[neighbor] = current;
                DFS(neighbor);
            }
        }
        finOrder[finIndex++] = current;
    }

    public int[] getDiscOrder() {
        return discOrder;
    }

    public int[] getFinOrder() {
        return finOrder;
    }
}
