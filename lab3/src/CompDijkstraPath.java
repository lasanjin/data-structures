import java.util.*;

public class CompDijkstraPath<E extends Edge> {

    private List<E>[] edges;
    private int to, from;

    private boolean[] visited;
    private PriorityQueue<DijkstraPath> pq;

    public CompDijkstraPath(List<E>[] edges, int to, int from) {
        this.edges = edges;
        this.to = to;
        this.from = from;
        visited = new boolean[edges.length];
        pq = new PriorityQueue<>();
    }

    public ArrayList<E> getPath() {

        pq.add(new DijkstraPath(from, 0, new ArrayList<>()));

        List<E> currentNodeEdges;

        while (!pq.isEmpty()) {

            DijkstraPath current = pq.poll();

            if (current.to == to) {
                return current.path;
            }

            if (visited[current.to]) {
                continue;
            }

            // nod är nu besökt
            visited[current.to] = true;

            // List of edges from current node
            currentNodeEdges = edges[current.to];

            for (E edge : currentNodeEdges) {
                if (!visited[edge.to]) {

                    ArrayList<E> newPath = new ArrayList<>(current.path);
                    newPath.add(edge);

                    pq.add(new DijkstraPath(edge.to, current.cost + edge.getWeight(), newPath));

                }
            }
        }

        return null;

    }

    private class DijkstraPath implements Comparable {

        private int to;
        private double cost;
        private ArrayList<E> path;

        public DijkstraPath(int to, double cost, ArrayList<E> path) {
            this.to = to;
            this.cost = cost;
            this.path = path;
        }

        public ArrayList<E> getPath() {


            // TODO returnera ny path?
            return null;
        }

        @Override
        public int compareTo(Object o) {
            return Double.compare(cost, ((DijkstraPath) o).cost);
        }
    }

}


