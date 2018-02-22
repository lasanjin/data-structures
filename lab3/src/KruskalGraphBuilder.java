import java.util.*;

public class KruskalGraphBuilder {

    private KruskalGraphBuilder() {
    }

    public static <E extends Edge> List<E> getKruskalGraph(int nEdge, List<E>[] graph) {
        PriorityQueue pq = fillPriorityQueue(new PriorityQueue(nEdge, new CompareEdge()), graph);// Fyll PQ med edges
        List<E>[] mst = fillList(new List[nEdge]);// Tom Kruskal graf

        int cc = nEdge;// Antal edges

        while (!pq.isEmpty() && cc > 1) {
            E edge = (E) pq.poll();// Hämta från pq.

            if (mst[edge.from] != mst[edge.to]) {// Om from && to refererar till samma lista

                mst[edge.from].add(edge); // Lägger till ny edge i någon av listorna, spelar ingen roll vilken.

                int sizeTo = mst[edge.to].size();
                int sizeFrom = mst[edge.from].size();

                if (sizeTo < sizeFrom) {
                    mergeLists(mst, edge.to, edge.from);
                } else {
                    mergeLists(mst, edge.from, edge.to);
                }

                cc--;
            }
        }
        return mst[1];
    }

    private static <E extends Edge> void mergeLists(List<E>[] mst, int small, int large) {
        List<E> temp = mst[small]; // "Spara" mindre mängden.

        if (temp.size() < 1) {// Gör detta om mindre mängden är tom.
            mst[small] = mst[large];
            return;
        }

        for (int i = 0; i < mst.length; i++) {// Peka om index som pekar på mindre mängden.
            if (mst[i] == temp) {
                mst[i] = mst[large];
            }
        }

        mst[large].addAll(temp);// Lägg till mindre mängd till större.
    }

    private static <E extends Edge> List<E>[] fillList(List<E>[] mst) {
        for (int i = 0; i < mst.length; i++) {
            mst[i] = new ArrayList<>();
        }
        return mst;
    }

    private static <E extends Edge> PriorityQueue fillPriorityQueue(PriorityQueue pq, List<E>[] graph) {
        for (List l : graph) {
            pq.addAll(l);
        }
        return pq;
    }

    private static class CompareEdge implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            double w1 = ((Edge) o1).getWeight();
            double w2 = ((Edge) o2).getWeight();

            return Double.compare(w1, w2);
        }
    }
}