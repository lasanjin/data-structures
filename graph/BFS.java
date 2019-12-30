import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private BFS() {
    }

    public static int[] breadthFirstSearch(Graph graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[graph.getNumV()];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        boolean[] visited = new boolean[graph.getNumV()];
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.remove();
            Iterator<Edge> i = graph.edgeIterator(current);

            while (i.hasNext()) {
                Edge edge = i.next();
                int neighbor = edge.getDestination();

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    parent[neighbor] = current;
                }
            }
        }
        return parent;
    }
}
