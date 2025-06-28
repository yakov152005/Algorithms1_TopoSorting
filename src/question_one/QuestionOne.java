import java.util.*;


public class QuestionOne {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        Graph G = new Graph(4);
        int A = 0, B = 1, C = 2, D = 3;

        G.addEdge(A, B);
        G.addEdge(B, C);
        G.addEdge(B, D);
        G.addEdge(C, D);

        sectionA(G, D, sb);
        sectionB(G, sb);

        System.out.println(sb);

    }



    public static void sectionA(Graph G, int D, StringBuilder sb){
        sb.append("--------- Section A ---------").append('\n');

        List<List<Integer>> allPaths = new ArrayList<>();
        for (int u = 0; u < G.getV(); u++) {
            List<Integer> path = new ArrayList<>();
            DfsMethod.dfs(G, u, D, path, allPaths);
        }

        sb.append("All paths ending at D:").append('\n');
        for (List<Integer> path : allPaths) {
            for (int i = 0; i < path.size(); i++) {
                sb.append(DfsMethod.numToChar(path.get(i)));
                if (i < path.size() - 1)
                    sb.append(" → ");
            }
            sb.append('\n');
        }
    }

    public static void sectionB(Graph G, StringBuilder sb){
        sb.append('\n').append("--------- Section B ---------").append('\n');

        int[] pathsTo = PathCounter.countPathsToEachNode(G);

        char[] names = {'A', 'B', 'C', 'D'};
        for (int i = 0; i < pathsTo.length; i++) {
            sb.append("Number of paths ending at ")
                    .append(names[i])
                    .append(": ")
                    .append(pathsTo[i])
                    .append('\n');
        }

        sb.append("Topo sort = O(V + E)").append('\n')
                .append("Beyond all Edge = O(E)").append('\n')
                .append("Beyond all Vertex = O(V)").append('\n')
                .append("Total = O(V + E)").append('\n');
    }


}
