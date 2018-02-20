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
        List<E> currentNodeEdges; // lista som innehåller current Nodes edges

        // Lägger till första Path i PQ
        pq.add(new DijkstraPath(from, 0, new ArrayList<>()));


        while (!pq.isEmpty()) {

            DijkstraPath current = pq.poll();

            if (current.to == to) { // färdiga
                return current.path;
            }

            if (visited[current.to]) { // är den besökt? ja, polla ny och börja om.
                continue;
            }

            // nod är nu besökt
            visited[current.to] = true;

            currentNodeEdges = edges[current.to];

            for (E edge : currentNodeEdges) {
                if (!visited[edge.to]) { // om nod besökt behöver inget göras

                    ArrayList<E> newPath = new ArrayList<>(current.path);
                    newPath.add(edge);

                    pq.add(new DijkstraPath(edge.to, current.cost + edge.getWeight(), newPath));

                }
            }
        }

        // detta borde aldrig kunna ske.
        // todo kanske göra något annat om vi hamnar här? fråga på labtillfälle
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

        @Override
        public int compareTo(Object o) {
            return Double.compare(cost, ((DijkstraPath) o).cost);
        }
    }

}