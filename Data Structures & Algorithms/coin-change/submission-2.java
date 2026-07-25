class Solution {
    //can't be geedy
    //DFS - backtracking -> len n


    //O(amount * len(coins))
    //O(amount)

    // min # of coins to get 0 , 1, 2 ..
    // DP[3] = 1 + DP[2] -> 1 is coin 3
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1); // fill with max value

        dp[0] = 0;

        for(int i = 1; i <= amount ; i++){
            for(int j = 0 ;j < coins.length ; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); 
                    // subtracting every coin with the amount
                    //and that amount d[p] will have previously calculated required coins for that 
                    //amount
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
