class Solution {

    // 2^n brute force - each element has 2 choice can be part of sub array or not

    // O(n * sum(num)) - storage - if we do DFS then that would be time complexity & mem
    // but we can improve mem to - > O(sum(nums))

    //for t in subarray
    // from backwards, amount of sums can be created from last element
    //  [1, 5, 11, 5] 
    //set = [0, 5, 11, 16, 10, 21, 1, 5, 12, 17, 22]
    public boolean canPartition(int[] nums) {
        if(Arrays.stream(nums).sum() % 2 != 0){
            return false; // sum odd cant be 2 equal subsets
        }

        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        int target = Arrays.stream(nums).sum()/2;

        for(int i = nums.length -1 ;i >= 0 ;i--){
            Set<Integer> newDp = new HashSet<>();
            for(int n : dp){
                if(n + nums[i] == target){
                    return true;
                }
                newDp.add(n + nums[i]);
                newDp.add(n);
            }
            dp = newDp;
        }
        return false;
    }
}
