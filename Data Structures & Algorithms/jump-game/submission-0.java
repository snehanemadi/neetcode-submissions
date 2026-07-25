// public boolean canJump(int[] nums) {
//         int len  = nums.length;
//         int i=0;
//         while(i < len){
//             int j = 0;
//             if(i == len-1){
//                 return true;
//             }
//             i += nums[i];
//         }
//         return false;
//     }

class Solution {
    public boolean canJump(int[] nums) {
        int goal  = nums.length -1 ;
        for(int i=nums.length - 2; i >= 0 ;i--){
            if(i + nums[i] >= goal){
                goal = i;
            }
        }
        return goal == 0;
    }
}
