public class BellmanFord {
    static class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void BellmanFordAlgo(int graph[][], int V, int E, int src) {
        int dist[] = new int[V];
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

        for (int i = 1; i <= V - 1; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph[j][0];
                int v = graph[j][1];
                int weight = graph[j][2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        for (int i = 0; i < E; ++i) {
            int u = graph[i][0];
            int v = graph[i][1];
            int weight = graph[i][2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        printDistances(dist, V);
    }

    static void printDistances(int dist[], int V) {
        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;  // Number of vertices
        int E = 8;  // Number of edges
        int graph[][] = new int[][] {
                {0, 1, -1}, {0, 2, 4}, {1, 2, 3}, {1, 3, 2}, {1, 4, 2},
                {3, 2, 5}, {3, 1, 1}, {4, 3, -3}
        };

        BellmanFordAlgo(graph, V, E, 0);
    }
}
