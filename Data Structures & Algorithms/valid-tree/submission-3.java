class Solution {
    // check for valid BST - prob
    // check cycle in graph - prob
    // look at adjecency list forming


    //check connected - input = num of visited node from a ndoe
    // check cycle
    // have a prev visted node value
    // start value we will give as -1 as default value

    //O(E+V) - TC and mem

    public Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public boolean validTree(int n, int[][] edges) {

        if(n == 0){
            return false;
        }
        if(n == 1){
            return edges.length == 0;
        }

        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            adjacencyList.putIfAbsent(node1, new ArrayList<>());
            adjacencyList.putIfAbsent(node2, new ArrayList<>());

            adjacencyList.get(node1).add(node2);
            adjacencyList.get(node2).add(node1);
        } // for every node add the connected node as vice versa

        Set<Integer> visited = new HashSet<>();

        if(!dfs(edges[0][0], -1, visited)){
            return false;
        }
        return visited.size() == n;
        
    }

    public boolean dfs(int node, int prev, Set<Integer> visited){
        if(visited.contains(node)){
            return false;
        }

        visited.add(node);
        for(int neigh : adjacencyList.get(node)){
            if(neigh == prev){
                continue;
            }
            if(!dfs(neigh, node, visited)){
                return false;
            }
        }
        return true;
    }
}
