
import java.util.*;

public class DirectedGraph<E extends Edge> {

    private int numV;
    private List<E>[] edges;


    public DirectedGraph(int nNode) {
        numV = nNode + 1;
        edges = new List[numV];

        for (int i = 0; i < numV; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    public void addEdge(E e) {

		System.out.println("Adding new Edge         ->      " + e);


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
        return null;
    }

    public Iterator<E> minimumSpanningTree() {


		System.out.println("	___---	 Building MST	 ---___");

		int count = 0;
		double totalW = 0;

		List<E> daList = CompKruskalEdge.getKruskalGraph(numV, new CompareEdge(), edges);
		Iterator<E> iterator = daList.iterator();

		while (iterator.hasNext()) {
			E current = iterator.next();
			//System.out.println(current);
			count++;
			totalW += current.getWeight();
		}

		System.out.println("Antal:" + count);
		System.out.println("Total vikt:" + totalW);

        return daList.iterator();
    }

    public List<E>[] getDaList() {
        return null;//CompKruskalEdge.getKruskalGraph(numV, new CompareEdge(), edges);
    }


    //TODO Fråga hur noga vi ska vara med chipsen.
    private static class CompareEdge implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            double w1 = ((Edge) o1).getWeight();
            double w2 = ((Edge) o2).getWeight();

            return Double.compare(w1, w2);
        }
    }

    public List<E>[] getEdges() {
        return edges;
    }
}
  
