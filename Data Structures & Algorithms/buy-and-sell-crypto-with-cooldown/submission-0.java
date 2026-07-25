class Solution {
    //n

    //buy / sell / cooldown
    // only 2 choices -> 2^n
    //O(n) with mem
    // (index, boolean buy or sell) -> 2*n

    //if Buy -> i + 1 -> buy or sell
    //if Sell -> i+ 2 -> next buy
    public int maxProfit(int[] prices) {
        Map<String, Integer> dp = new HashMap<>();
        return dfs(0, true, prices, dp);
    }

    public int dfs(int i, boolean buying, int[] prices, Map<String,Integer> dp){
        if(i >= prices.length) {
            return 0;
        }
        String key = i + "," + buying;

        if(dp.containsKey(key)){
            return dp.get(key);
        }

        int cooldown = dfs(i+1, buying, prices, dp);
        if(buying) {
            int buy = dfs(i+1, !buying, prices, dp) - prices[i];
            dp.put(key, Math.max(buy, cooldown));
        } else {
            int sell = dfs(i+2, !buying, prices, dp) + prices[i];
            dp.put(key, Math.max(sell, cooldown));
        }
        return dp.get(key);
    }
}
