import java.util.ArrayList;
import java.util.List;

public class DfsMethod {
    public static char numToChar(int num) {
        return switch (num) {
            case 0 -> 'A';
            case 1 -> 'B';
            case 2 -> 'C';
            case 3 -> 'D';
            default -> '?';
        };
    }

    public static void dfs(Graph g, int u, int v, List<Integer> path, List<List<Integer>> allPaths) {
        path.add(u);
        if (u == v) {
            allPaths.add(new ArrayList<>(path));
        } else {
            for (int neighbor : g.getE().get(u)) {
                dfs(g, neighbor, v, path, allPaths);
            }
        }
        path.removeLast();
    }
}
