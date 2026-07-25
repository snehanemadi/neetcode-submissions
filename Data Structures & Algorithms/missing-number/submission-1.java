class Solution {
    public int missingNumber(int[] nums) {

        //[0,1,3] ^ [0,1,2,3] = 2
        // but extra mem

        int res = nums.length; // add th last value
        for(int i=0;i<nums.length;i++){ // here we are adding till last but one
            res += (i - nums[i]);
        }
        return res;

    }
}
