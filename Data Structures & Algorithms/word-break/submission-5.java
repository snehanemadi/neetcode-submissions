class Solution {
    // O(n * m * n)  - last n is basically each string match deom word to s
    // word dict to string
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] =  true;

        for(int i = s.length()-1;i>=0;i--){
            for(String w : wordDict){
                if(i + w.length() <= s.length() 
                && s.substring(i, i+w.length()).equals(w)){
                    dp[i] = dp[i + w.length()];
                }
                if(dp[i]){ // if we found then break, dont have to look into every single word
                    break;
                }
            }
        }
        return dp[0];
    }
}
