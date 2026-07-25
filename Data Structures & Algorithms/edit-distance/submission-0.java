class Solution {
    //w1 ="abc" w2=""
    //it will take length of w1

    //w1 ="" w2="abc" //last row
    //it will take len of w2

    //insert - i, j+1
    //delete - i + 1, j
    //replace - i +1, j+1
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for(int j = 0 ;j <=word2.length();j++){ //last row
            dp[word1.length()][j] = word2.length() - j;
        }

        for(int i = 0 ; i <= word1.length() ;i++){ //last col
            dp[i][word2.length()] = word1.length() - i;
        }

        for(int i = word1.length() -1 ; i >=0 ;i--){
            for(int j = word2.length() - 1;j >=0 ; j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    //adding 1 coz we are having atleat 1 op
                    dp[i][j] = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
                }
            }
        }
        return dp[0][0];
    }
}
