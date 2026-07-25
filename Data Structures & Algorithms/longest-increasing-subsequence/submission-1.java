class Solution {
    //2^n - be in sub sequence or dont be in sub sequence

    //DFS with cache and DP are n^2 and n
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for(int i = nums.length-1;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] < nums[j]){
                     dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
