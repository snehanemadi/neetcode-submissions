class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        maxArea = 0
        visit = set()
        ROWS = len(grid)
        COLS = len(grid[0])

        def dfs(r, c):
            if r < 0 or r >= ROWS or c <0 or c >=COLS or (r,c) in visit or grid[r][c]==0:
                return 0
            
            visit.add((r,c))
            return (1 + dfs(r + 1, c) +
                        dfs(r - 1, c) +
                        dfs(r, c + 1) +
                        dfs(r, c - 1))

        for i in range(ROWS):
            for j in range(COLS):
                maxArea =  max(maxArea, dfs(i,j))
        return maxArea