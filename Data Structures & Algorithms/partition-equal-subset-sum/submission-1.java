class Solution {
    //2^n - brute force

    //backtracking DFS with mem
    //n*sum(nums) - TC
    //n - mem

    //DP 
    //
    public boolean canPartition(int[] nums) {

        if(Arrays.stream(nums).sum() % 2 != 0){
            return false;
        }

        Set<Integer> dp = new HashSet<>(); // size - sum(nums)
        dp.add(0);

        int target = Arrays.stream(nums).sum()/2;

        for(int i = nums.length-1;i >=0;i--){
            Set<Integer> newdp = new HashSet<>();
            for(int t : dp){
                if(t + nums[i] == target){
                    return true;
                }
                newdp.add(t + nums[i]);
                newdp.add(t);
            }
            dp = newdp;
        }
        return false;
    }

}
