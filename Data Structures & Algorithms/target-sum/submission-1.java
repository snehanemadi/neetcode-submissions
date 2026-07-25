class Solution {
    //order matters
    //permutation

    //brute
    //+ / - -> 2^n
    // n-> height

    // trick is in param -> caching
    // (index, total)
    //( n    *  sum(num))
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return backtrack(0, 0, nums, target, dp);
    }

    private int backtrack(int i, int total, int[] nums, int target, Map<String, Integer> dp){
        if(i == nums.length){
            return total == target ? 1 : 0;
        }

            String key = i + "," + total;

            if(dp.containsKey(key)){ // exists in the cache
                return dp.get(key);
            }

            int ways = backtrack(i + 1, total + nums[i], nums, target, dp) + 
            backtrack(i+1, total - nums[i], nums, target, dp);
            dp.put(key, ways);
            return ways;
    }
}
