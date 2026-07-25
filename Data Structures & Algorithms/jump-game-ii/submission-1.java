class Solution {
    //n - greedy - like BFS
    //DP is n^2
    // 2, 3, 1, 1, 4 
    // from 0 pos i can go to [3, or 1] 
    // now from this what all pos i can reach outside [3, 1]
    //
    public int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int res = 0;
    
        while(r < nums.length - 1){
            int maxJump = 0;
            for(int i = l; i <=r ;i++){
                maxJump = Math.max(maxJump, i + nums[i]);
            }
            l = r + 1;
            r = maxJump;
            res++;
        }
        return res;
    }
}
