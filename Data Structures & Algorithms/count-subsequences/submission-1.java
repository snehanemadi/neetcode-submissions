class Solution {
    // O(len(n) * len(m)) both mem an TC
    // even though it matches lets see if we find in next 
    //We can either use this character (cache[i + 1][j + 1])
    //Or skip it and look for t[j] in the rest of s (cache[i + 1][j])
    //b) If s[i] doesn't match t[j]: 

    //cache[i][j] = cache[i + 1][j] when characters don't match is a way 
    //of saying "skip this character and look at the rest of the string"

    //s="a", t = "" -> 1
    //s="", t ="a" -> 0
    //s="", t ="" -> 1
    public int numDistinct(String s, String t) {
        int[][] cache = new int[s.length() + 1][t.length() + 1];

        for(int i = 0; i <= s.length() ;i++){  // last col
            cache[i][t.length()] = 1;
        }

        for(int j = t.length() - 1; j >=0 ;j--){ // last row
            cache[s.length()][j] = 0;
        }

        for(int i = s.length()-1 ; i >= 0 ; i--){
            for(int j = t.length()-1; j >= 0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    cache[i][j] = cache[i+1][j+1] + cache[i+1][j];
                } else {
                    cache[i][j] = cache[i+1][j];
                }
            }
        }
        return cache[0][0];
    }
}
