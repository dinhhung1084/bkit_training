package Datastructures.Search;


import java.util.LinkedList;

public class DepthFirstSearch {
    private final int V;
    private final LinkedList<Integer>[] adj;

    public DepthFirstSearch(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }


    public boolean dfs(int target) {
        boolean[] visited = new boolean[V];
        return dfsUtil(0, target, visited);
    }

    private boolean dfsUtil(int node, int target, boolean[] visited) {
        if (node == target) {
            return true;
        }

        visited[node] = true;

        for (int next : adj[node]) {
            if (!visited[next]) {
                if (dfsUtil(next, target, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int numberOfVertices = 1000; // Số đỉnh
        DepthFirstSearch g = new DepthFirstSearch(numberOfVertices);

        for (int i = 0; i < numberOfVertices - 1; i++) {
            g.addEdge(i, i + 1);
        }

        int target = 734;
        long startTime = System.currentTimeMillis();
        boolean found = g.dfs(target);
        long endTime = System.currentTimeMillis();
        if (found) {
            System.out.println("Số " + target + " đã được tìm thấy trong đồ thị. \nTrong " + (endTime - startTime) );
        } else {
            System.out.println("Số " + target + " không có trong đồ thị.");
        }
    }
}

