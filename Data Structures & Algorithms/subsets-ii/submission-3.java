class Solution {
    //why cant i use a set ?
    //1, 2, 2, 3
    // move pointer to 3 from 1st 2
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, new ArrayList<>(), nums, res);
        return res;
    }

    private void backtrack(int i, List<Integer> subset, int[] nums, 
        List<List<Integer>> res){
            if(i == nums.length){
                res.add(new ArrayList<>(subset));
                return;
            }

            //with nums[i]
            subset.add(nums[i]);
            backtrack(i + 1, subset, nums, res);
            subset.remove(subset.size()-1);
            //without nums[i]

            while( i + 1 < nums.length && nums[i] == nums[i+1]){
                i += 1;
            }
            // we dont want to stop here, even if it give [] we need to add that [] to meet b ase case

            backtrack(i+1, subset, nums, res);

    }
}
