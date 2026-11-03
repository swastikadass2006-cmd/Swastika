import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    freshCount++;
                }else if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }           
            }
        }
        if(freshCount ==0) return 0;
        int minutes=0;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty() && freshCount>0){
            int size=queue.size();
            for(int k=0;k<size;k++){
                int[] cell=queue.poll();
                int row=cell[0];
                int col=cell[1];
                for(int[] dir:directions){
                    int newRow=row + dir[0];
                    int newCol = col + dir[1];
                    if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]==1){
                        grid[newRow][newCol]=2;
                        freshCount--;
                        queue.offer(new int[]{newRow,newCol});
                    }
                }
            }
            minutes++;
        }
        return freshCount==0?minutes:-1;
    }
}