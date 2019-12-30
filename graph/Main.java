import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(true, 10);

        graph.insert(new Edge(0, 1));
        graph.insert(new Edge(0, 3));
        graph.insert(new Edge(3, 2));
        graph.insert(new Edge(2, 9));
        graph.insert(new Edge(2, 8));
        graph.insert(new Edge(2, 1));
        graph.insert(new Edge(1, 4));
        graph.insert(new Edge(1, 6));
        graph.insert(new Edge(1, 7));
        graph.insert(new Edge(4, 7));
        graph.insert(new Edge(7, 6));
        graph.insert(new Edge(6, 4));
        graph.insert(new Edge(4, 5));

        System.out.println();

        for (int i = 0; i < graph.getNumV(); i++) {
            Iterator itr = graph.edgeIterator(i);
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
        }

        int[] bfs = BFS.breadthFirstSearch(graph, 0);
        for (int i = 0; i < bfs.length; i++) {
            System.out.println(i + " : " + bfs[i]);
        }

        System.out.println();

        DFS DFS = new DFS(graph);
        int[] dfs = DFS.getDFS();
        for (int i = 0; i < dfs.length; i++) {
            System.out.println(i + " : " + dfs[i]);
        }

        System.out.println();

        int[] discOrder = DFS.getDiscOrder();
        for (int i = 0; i < discOrder.length; i++) {
            System.out.println(i + " : " + discOrder[i]);
        }

        System.out.println();

        int[] finOrder = DFS.getFinOrder();
        for (int i = 0; i < finOrder.length; i++) {
            System.out.println(i + " : " + finOrder [i]);
        }
    }
}
