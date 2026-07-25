class Solution {
    //c^amount -> amount height of the tree

    //DFS -> dfs(i, amount) -> if amount > reqamount stop
    // different comnination this DFS can be called -> amount * # of coins
    // cache same combination 

    // O (c * n) - with DP

    //order doesnt really matter

    // to make sure it doesnt repeat dont choose 1 again for 2nd one -> m^n
    // i -> dont choose anything less than where i points to

    // O(m * n) -> memo
    // but can reduce to O(n) memo also

    //amount 5, 4, 3, 2, 1
    //coin 1, 2, 5
    // 2 spots right
    // 1spot down


    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = coins.length - 1; i >= 0; i--) {
            int[] nextDP = new int[amount + 1];
            nextDP[0] = 1;

            for (int a = 1; a <= amount; a++) {
                nextDP[a] = dp[a];
                if (a - coins[i] >= 0) {
                    nextDP[a] += nextDP[a - coins[i]];
                }
            }
            dp = nextDP;
        }
        return dp[amount];
    }
}
