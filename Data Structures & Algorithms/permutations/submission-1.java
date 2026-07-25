class Solution {
    // when to use recursion -> when you have sub problems
    // 1,2,3 -> 2, 3 -> 3 -> all together at the end is the result
    // its back tracking when you go from 3 -> 2,3 -> 1,2,3
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums.length == 1){
            List<Integer> singleNum = new ArrayList<>();
            singleNum.add(nums[0]);
            res.add(singleNum);
            return res;
        }

        for(int i=0; i < nums.length; i++){
            int n = nums[i];
            int[] remainingNums = new int[nums.length - 1];
            int idx = 0;
            // put all other elemets in remainingNums
            for(int j = 0; j < nums.length; j++){
                if(j != i){
                    remainingNums[idx++] = nums[j];
                }
            }

            List<List<Integer>> perms = permute(remainingNums);

            for(List<Integer> perm : perms){
                perm.add(n);
                res.add(new ArrayList<>(perm));
            }
        }
        return res;
    }
}
