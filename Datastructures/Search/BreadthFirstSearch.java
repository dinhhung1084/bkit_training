package Datastructures.Search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    private final int V;
    private final LinkedList<Integer>[] adj;

    public BreadthFirstSearch(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public boolean bfs(int target) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            if (node == target) {
                return true;
            }

            for (int next : adj[node]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int numberOfVertices = 1024;
        BreadthFirstSearch g = new BreadthFirstSearch(numberOfVertices);

        for (int i = 0; i < numberOfVertices - 1; i++) {
            g.addEdge(i, i + 1);
        }

        int target = 734;
        long startTime = System.currentTimeMillis();
        boolean found = g.bfs(target);
        long endTime = System.currentTimeMillis();
        if (found) {
            System.out.println("Số " + target + " đã được tìm thấy trong đồ thị. \nTrong " + (endTime - startTime) );
        } else {
            System.out.println("Số " + target + " không có trong đồ thị.");
        }
    }
}


