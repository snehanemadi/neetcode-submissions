class Solution {

    //O(m*n). and mem O(m*n) -> visit set
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        Set<String> visit = new HashSet<>();

        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                area = Math.max(area, dfs(grid, i, j, visit));
            }
        }
        return area;
    }

    public int dfs(int[][] grid, int r, int c, Set<String> visit){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || 
         grid[r][c] == 0 || visit.contains(r + "," + c)){
            return 0;
         }
         visit.add(r + ","+ c);
         return 1 + dfs(grid, r+1, c, visit)
         + dfs(grid, r, c+1, visit)
         + dfs(grid, r, c-1, visit)
         + dfs(grid, r-1, c, visit);
    }
}
