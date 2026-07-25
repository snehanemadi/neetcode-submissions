class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;
        int time = 0;

        for(int i=0; i<m; i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0, -1}};

        while(fresh > 0 && !q.isEmpty()){
            int length = q.size();
            for(int i = 0 ; i < length ; i++){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for(int[] dir : dirs){
                    int x = dir[0] + r;
                    int y = dir[1] + c;

                    if(x >=0 && y >=0 && x < m && y < n && grid[x][y] == 1){
                        grid[x][y] = 2;
                        q.offer(new int[]{x, y});
                        fresh--;
                    }
                }
            }  
            time++;
        }
        return fresh == 0 ?  time : -1;
    }
}
