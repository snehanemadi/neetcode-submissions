class Solution {
    //2^n

    //(index, total)
    //n     * sum(n)
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return backtrack(0, 0, nums, target, dp);
    }

    public int backtrack(int i, int total, int[] nums, int target, Map<String, Integer>dp){
        if( i == nums.length){
            return total == target ? 1 : 0;
        }

            String key = i + "," + total;

            if(dp.containsKey(key)){
                return dp.get(key);
            }

            int ways = backtrack(i + 1, total + nums[i], nums, target, dp)
            + backtrack(i + 1, total - nums[i], nums, target, dp);

            dp.put(key, ways);

            return ways;
    }
}
