class Solution {
    //when you cant go bac and check keep on pointer
    // 2 pointer tech
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 0;
        int maxProfit = 0;
        while(right < prices.length){
            if(prices[left] < prices[right]){
                maxProfit = Math.max(maxProfit, prices[right]- prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}

