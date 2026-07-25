class Solution {
    //DFS - O(m*n)

    //union find
    //547 on leetcode
    private int[] parent;
    private int[] rank; 
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }

        int result = n;
        for(int i=0;i<edges.length;i++){
            if(union(edges[i][0], edges[i][1]) == 1){
                result--;
            }
        }
        return result;
    }

    public int find(int node){ // par[0,0,2,3,4] // rank[2,1,1,1,1] -> size
        int result = node;
        while(parent[result] != result){ // for 2 -- par[2] -> 2 and res = 2
            // but for 1 -- par[1]=0 and res = 1
            parent[result] = parent[parent[result]]; // do nothing
            result = parent[result]; // res = 0
        }
        return result; // 0
    }

    public int union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 == p2) {
            return 0; //already attached to parent no op done
        }

        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return 1;
    }
}
