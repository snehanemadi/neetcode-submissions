class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), 0, target, candidates, res);
        return res;
    }

    public void backtrack(List<Integer> cur, int pos, int target, int[] candidates, 
        List<List<Integer>> res){
            if(target == 0){
                res.add(new ArrayList<>(cur));
                return;
            }
            if(target < 0){
                return;
            }

            int prev = -1;
            for(int i = pos ; i < candidates.length ;i++){
                if(candidates[i] == prev){
                    continue;
                }
                cur.add(candidates[i]);
                backtrack(cur, i + 1, target - candidates[i], candidates, res);
                cur.remove(cur.size()-1);
                prev = candidates[i];

            }
    }
}
