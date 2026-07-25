class Solution {
    // 1 way consider all paths and take maximum of all paths
    // return minimum of those max's
    // thats going to be exponential 

    //Djikstra's algo - n^2 logn
    // algo-> queue - here we use priority q - minH
    //(height,r, c) to heap
    // pop min from heap

    // djikstra's coz -> add max height to reach to that pos in heap
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        boolean[][] visit = new boolean[N][N]; // 2D array to track visited cells
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visit[0][0] = true; // Mark the starting point as visited

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int t = curr[0], r = curr[1], c = curr[2];
            if (r == N - 1 && c == N - 1) {
                return t; // Reached the bottom-right corner
            }
            for (int[] dir : directions) {
                int neiR = r + dir[0], neiC = c + dir[1];
                if (neiR >= 0 && neiC >= 0 && neiR < N && neiC < N && !visit[neiR][neiC]) {
                    visit[neiR][neiC] = true; // Mark the cell as visited
                    minHeap.offer(new int[]{Math.max(t, grid[neiR][neiC]), neiR, neiC});
                }
            }
        }
        return -1; // No valid path found
    }
}
