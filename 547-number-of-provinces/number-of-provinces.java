class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;               // New unvisited node → new province
                dfs(isConnected, visited, i);
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int u) {
        for (int v = 0; v < isConnected[u].length; v++) {
            if (isConnected[u][v] == 1 && !visited[v]) {
                visited[v] = true;
                dfs(isConnected, visited, v);
            }
        }
    }
}