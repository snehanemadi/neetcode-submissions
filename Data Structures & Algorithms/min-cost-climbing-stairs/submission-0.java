class Solution {
    //its not greedy coz the possiblility of start points are already given either 0 or 1
    //and steps can be taken are 1 or 2
    // in greedy possiblities are not given

    //right to left coz , 1,2,3,4 -> 2 has dep of 3 or 4 so 1st solve 4, 3

    //every index has value to reach the top index
    //depends on just 2 next values so 2 vars are enough no need of storage O(1)
    public int minCostClimbingStairs(int[] cost) {
        for(int i=cost.length-3;i>=0;i--){
            cost[i] +=Math.min(cost[i+1], cost[i+2]);
        }
        return Math.min(cost[0],cost[1]);
    }
}
