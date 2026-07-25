class Solution {
    //can't reuse 

    //brute - dfs on every 

    // every pos has LIP from that pos so if that m[][] != 0 then reuse
    //n*m, n*m
    //coz after doing dfs on it next time its just O(1) so dfs on every element only once
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] memo = new int[row][col];
        int[][] dirs = {{0,1}, {1, 0}, {-1,0}, {0,-1}};

        int maxDist = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                maxDist = Math.max(maxDist, dfs(matrix,i,j, memo, dirs));
            }
        }
        return maxDist;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] memo, int[][] dirs){
        if(memo[r][c] != 0){
            return memo[r][c];
        }

        int res = 1; // basically default value 1 to the memo every pos
        for(int[] dir : dirs){
            int x = r +dir[0];
            int y = c + dir[1];
            if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
            && matrix[x][y] > matrix[r][c]){
                res = Math.max(res, 1 + dfs(matrix, x, y, memo, dirs));
            }
        }
        //all reachable element is done
        memo[r][c] = res;
        return res;
    }
}
