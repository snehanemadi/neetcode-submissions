class Solution {
    //brute force -> n^2

    //O(n)

    //use max prod of 1st 2 then use for 3rd one 
    // edge case -> 0 reset max and min to 1
    // 
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curMin = 1;
        int curMax = 1; // neutral value
        int flag = 0;

        for(int n : nums){
            int temp = n * curMax;
            curMax = Math.max(n, Math.max(n * curMax, n * curMin));
            curMin = Math.min(n, Math.min(temp, n * curMin));
            res = Math.max(res, curMax);
        }
        return res;
    }
}
