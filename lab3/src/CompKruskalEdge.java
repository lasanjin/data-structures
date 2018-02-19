import java.util.*;

public class CompKruskalEdge {

    private CompKruskalEdge() {

    }

    public static <E extends Edge> List<E>[] getKruskalGraph(int nEdge, Comparator comparator, List<E>[] graph) {
        PriorityQueue pq = new PriorityQueue(nEdge, comparator);
        List<E>[] mst = new List[nEdge];

        for (List l : graph) {
            pq.addAll(l);
        }

        while (!pq.isEmpty()) {
            E edge = (E) pq.poll();

            if (mst[edge.from] != mst[edge.to]) {

                int sizeTo = mst[edge.to].size();
                int sizeFrom = mst[edge.from].size();

                if (sizeTo < sizeFrom) {
                    mergeLists(mst, edge.to, edge.from);
                    mst[edge.from].add(edge);
                } else {
                    mergeLists(mst, edge.from, edge.to);
                    mst[edge.to].add(edge);
                }
            }
        }

        return mst;
    }

    private static <E extends Edge> void mergeLists(List<E>[] mst, int small, int large) {
        List<E> temp = mst[small];

        if (temp.size() < 1) {
            mst[small] = mst[large];
            return;
        }

        int count = 0;

        for (int i = 0; i < mst.length; i++) {
            if (mst[i] == temp) {
                mst[i] = mst[large];
                mst[large].add(temp.get(count++));
            }
        }
    }
}