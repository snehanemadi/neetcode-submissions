class Solution {
    // not DP coz we are not counting subsets , we are creating subsets
    // O(n * 2^n) -> how long each subset gonna be n so to generate subsets
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(0, subset, nums, res);
        return res;
    }

    public void backtrack (int start, List<Integer> subset, int[] nums, List<List<Integer>> res){
        res.add(new ArrayList<>(subset));
        for(int i = start; i < nums.length ;i++){
            if(i > start && nums[i] == nums[i-1]){
                continue; // skip duplicates
            }
            subset.add(nums[i]);
            backtrack(i + 1, subset, nums, res);
            subset.remove(subset.size() - 1);
        }        
    }
    
}
