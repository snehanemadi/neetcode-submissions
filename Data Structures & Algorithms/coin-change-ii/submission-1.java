class Solution {
    //amount^n
    //pointer to make sure we dont use coin again - dup handling

    //DFS can be called m*n coz dfs has 2 params(i, a)
    //O(m*n) with memo

    //DP 
    //m*n memo-> m

    //amount[amount - coin]th -> pos look right
    //when we look down we only look 1 pos down so memo - m
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i = coins.length - 1; i >=0 ;i--){
            int[] nextdp = new int[amount+1];
            nextdp[0] = 1;

            for(int a = 1; a <= amount ;a++){
                nextdp[a] = dp[a];// without coin
                if(a - coins[i] >= 0){
                    nextdp[a] += nextdp[a-coins[i]];// with coin
                }
            }
            dp = nextdp;
        }
        return dp[amount];
    }
}
