class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            int num = nums[i];

            if(prevMap.containsKey(diff)){
                return new int[] {prevMap.get(diff) , i};
            }

            prevMap.put(num, i);
        }
        return new int[]{};
    }
}
