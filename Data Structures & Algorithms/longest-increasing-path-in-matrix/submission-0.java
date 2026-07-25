class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int maxLen = 0;
        int[][] memo = new int[row][col];
        int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        for(int i =0 ;i < row;i++){
            for(int j=0;j<col;j++){
                maxLen = Math.max(maxLen, dfs(matrix, i, j, memo, dir));
            }
        }

        return maxLen;
    }

    public int dfs(int[][] matrix, int r, int c, int[][] memo, int[][] dirs){
        if(memo[r][c] != 0){
            return memo[r][c];
        }
        int res = 1;
        for(int[] dir : dirs){
            int x = dir[0]+r;
            int y = dir[1]+c;

            if(x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length
            && matrix[x][y] > matrix[r][c]){
                res = Math.max(res, 1 + dfs(matrix, x, y, memo, dirs));
            }
        }
        memo[r][c] = res;
        return res;

    }
}
