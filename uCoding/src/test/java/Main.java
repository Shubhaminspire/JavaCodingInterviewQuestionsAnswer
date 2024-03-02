import java.util.*;

class Edge implements Comparable<Edge>{
    int src, dest, weight;
    Edge(int s, int d, int w){
        src = s;
        dest = d;
        weight = w;
    }
    public int compareTo(Edge e){
        return this.weight - e.weight;
    }
}

class Main{
    static int n, m;
    static int[] parent, rank;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        Edge[] edges = new Edge[m];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges[i] = new Edge(a, b, c);
        }

        Arrays.sort(edges); // Sort edges by weight

        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        int maxReward = 0;
        for(int i=0; i<m; i++){
            Edge e = edges[i];
            int u = e.src;
            int v = e.dest;
            int w = e.weight;

            int pu = findParent(u);
            int pv = findParent(v);
            if(pu != pv){ // Edge doesn't create cycle
                maxReward += Math.max(0, w); // Add reward for removing edge
                union(pu, pv); // Merge sets
            }
        }

        // Check if graph is connected
        int p = findParent(1);
        for(int i=2; i<=n; i++){
            if(findParent(i) != p){
                System.out.println("Graph is not connected!");
                return;
            }
        }

        System.out.println("Max Reward: " + maxReward);
    }

    // Find parent of node u
    static int findParent(int u){
        if(parent[u] != u){
            parent[u] = findParent(parent[u]); // Path compression
        }
        return parent[u];
    }

    // Merge sets containing u and v
    static void union(int u, int v){
        if(rank[u] > rank[v]){
            parent[v] = u;
        } else if(rank[v] > rank[u]){
            parent[u] = v;
        } else {
            parent[u] = v;
            rank[v]++;
        }
    }
}
