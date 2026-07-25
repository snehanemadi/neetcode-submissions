class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] dirs = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        while(fresh > 0 && !q.isEmpty()){
            int len = q.size();

            for(int i =0;i<len;i++){

                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                for(int[] dir: dirs){
                    int r = dir[0] + x;
                    int c = dir[1] + y;

                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.offer(new int[] {r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh == 0){
            return time;
        }
        return -1;
    }
}
