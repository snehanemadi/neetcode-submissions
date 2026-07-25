class Solution {
    // n^2 logn
    // number if edges -> n
    // logn from prims algo - min heap

    //prim's algo - minimum spanning tree
    // n-1 edges for n nodes -> without creating a cycle
    // minimize the total cost of the edges
    // start at any node - start DFS or BFS - ont add same node twice
    // visit 
    // heap - keep track of the frontier 
    // (node, weitgh to connect) -> min heap

    // add nodes again to frontier to get the smallest weighted graph 
    // n^2 logn -> add nodes n^2 times
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int i=0; i < N ; i++){ //
            int x1 = points[i][0];
            int y1 = points[i][1];

            for(int j = i + 1; j < N; j++){ // point to every other point
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1 - x2) + Math.abs(y1-y2);

                //un directed edges they go both ways
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }

        int res = 0;
        Set<Integer> visit = new HashSet<>();
        //cost, node
        PriorityQueue<int[]> minH = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minH.offer(new int[]{0,0});

        while(visit.size() < N){
            int[] curr = minH.poll();
            int cost = curr[0];
            int i = curr[1];

            if(visit.contains(i)){
                continue;
            }

            res = res + cost;
            visit.add(i);
            for(int[] nei : adj.getOrDefault(i, Collections.emptyList())){
                int neiCost = nei[0];
                int neiNode = nei[1];

                if(!visit.contains(neiNode)){
                    minH.offer(new int[]{neiCost, neiNode});
                }
            }
        }
        return res;
    }
}
