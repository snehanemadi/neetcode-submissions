class Solution {
    // O(n * m * n)  - last n is basically each string match deom word to s
    // word dict to string
    public boolean wordBreak(String s, List<String> wordDict) {
        //base case is going to be the len of s -> top down

        // go from last index to 1st -> bottom up
        // when we reach 0 and dp [0 + len(w)] == true we are done
    
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true; // empty is always considered as valid
        // when last word match it will be validated with this true

        for(int i = s.length() - 1 ;i >=0; i--){
            for(String w : wordDict){
                if((i+w.length()) <= s.length() && 
                s.substring(i, i+w.length()).equals(w)){
                    dp[i] = dp[i + w.length()];
                }
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[0];
    }
}
