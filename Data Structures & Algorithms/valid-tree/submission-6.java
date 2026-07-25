class Solution {

    Map<Integer, List<Integer>> adj = new HashMap<>();

    public boolean validTree(int n, int[][] edges) {
        //keep previous visited pointer and check if its the prev or not
        // if its not prev dont visit like this we can check for cycles

        Set<Integer> visit = new HashSet<>();

        if(n == 0) return false;

        if(n==1) {
            return edges.length == 0;
        }

        for(int[] edge : edges){
            int n1 = edge[0];
            int n2 = edge[1];
            adj.putIfAbsent(n1, new ArrayList<>());
            adj.putIfAbsent(n2, new ArrayList<>());
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }

    
        if(!dfs(edges[0][0],-1, visit)){
            return false;
        }

        return visit.size() == n; //handles disconnected graph
    }

    public boolean dfs(int node, int prev, Set<Integer> visit){
        if(visit.contains(node)){
            return false;
        }
        visit.add(node);

        for(int n : adj.get(node)){
            if(n == prev){
                continue;
            }
            // for any node there is circle break
            if(!dfs(n, node, visit)){
                return false;
            }
        }
        return true;
    }
}
