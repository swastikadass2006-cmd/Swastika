class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
         Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        // Step 2: Dijkstra with PriorityQueue (min-heap by distance)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        
        Map<Integer, Integer> dist = new HashMap<>();
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];
            
            if (dist.containsKey(node)) continue;
            
            dist.put(node, d);
            
            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                if (!dist.containsKey(nextNode)) {
                    pq.offer(new int[]{d + weight, nextNode});
                }
            }
        }
        
        // Step 3: Check all nodes reachable, return max distance or -1
        if (dist.size() < n) return -1;
        
        int maxDist = 0;
        for (int val : dist.values()) {
            maxDist = Math.max(maxDist, val);
        }
        
        return maxDist;
    }
}