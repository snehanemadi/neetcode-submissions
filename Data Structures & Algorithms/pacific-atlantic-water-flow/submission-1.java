class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        Set<Integer> atl = new HashSet<>();
        Set<Integer> pac = new HashSet<>();

        for(int i=0; i < row ; i++){
            dfs(i, 0, pac, heights[i][0], row, col, heights);
            dfs(i, col-1, atl, heights[i][col-1], row, col, heights);
        }

        for(int i=0; i < col ; i++){
            dfs(0, i, pac, heights[0][i], row, col, heights);
            dfs(row-1, i, atl, heights[row-1][i], row, col, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int coord = i * col + j;
                if(pac.contains(coord) && atl.contains(coord)){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, Set<Integer> visit, int prevH, int row, int col, 
        int[][] heights){
            int coord = r * col + c;
        if(r < 0 || c < 0 || r == row || c == col || heights[r][c] < prevH ||
        visit.contains(coord)) {
            return;
        }

        visit.add(coord);
        dfs(r + 1, c, visit, heights[r][c], row, col, heights);
        dfs(r - 1, c, visit, heights[r][c], row, col, heights);
        dfs(r , c + 1, visit, heights[r][c], row, col, heights);
        dfs(r , c - 1, visit, heights[r][c], row, col, heights);
    }
}
