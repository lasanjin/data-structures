
import java.util.*;

public class DirectedGraph<E extends Edge> {

	private int numV;
	private List<E>[] edges;


	public DirectedGraph(int noOfNodes) {
		edges = new List[noOfNodes];
		numV = noOfNodes;

	}

	public void addEdge(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		if (e.from < 0 || e.from <= numV) {
			throw new IndexOutOfBoundsException();
		}
		if (edges[e.from].contains(e)) {
			return;
		}

		edges[e.from].add(e);

	}


	public Iterator<E> shortestPath(int from, int to) {
		return null;
	}
		
	public Iterator<E> minimumSpanningTree() {
		return null;
	}

}
  
