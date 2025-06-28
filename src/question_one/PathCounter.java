import java.util.*;

public class PathCounter {

    public static int[] countPathsToEachNode(Graph G) {
        int V = G.getV();
        int[] inDegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : G.getE().get(u)) {
                inDegree[v]++;
            }
        }


        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);
            for (int v : G.getE().get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        int[] p = new int[V];
        Arrays.fill(p, 1);

        for (int u : topo) {
            for (int v : G.getE().get(u)) {
                p[v] += p[u];
            }
        }

        return p;
    }
}
