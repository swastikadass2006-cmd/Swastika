class Solution {
    public int minCostConnectPoints(int[][] points) {
       int n = points.length;
        if (n <= 1) return 0;
        
        List<int[]> edges = new ArrayList<>();
        
        // Build ALL possible edges
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + 
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{dist, i, j});
            }
        }
        
        // Sort edges by weight (ascending)
        Collections.sort(edges, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Union-Find data structure
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        int totalCost = 0;
        int edgesCount = 0;
        
        for (int[] edge : edges) {
            int dist = edge[0];
            int u = edge[1];
            int v = edge[2];
            
            int rootU = find(parent, u);
            int rootV = find(parent, v);
            
            if (rootU != rootV) {
                parent[rootU] = rootV;
                totalCost += dist;
                edgesCount++;
                
                if (edgesCount == n - 1) break;
            }
        }
        
        return totalCost;
    }
    
    private int find(int[] parent, int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];  // Path compression
            i = parent[i];
        }
        return i;
    }
} 