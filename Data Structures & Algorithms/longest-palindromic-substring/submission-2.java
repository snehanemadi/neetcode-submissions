class Solution {

    // brute force -> O(n^3) -> O(n) -check pali and for evry substring -n^2

    //start at the middle and expand outwards -> O(n^2)
    public String longestPalindrome(String s) {
        String longestPali = "";
        int llen = 0;
        for(int i=0;i < s.length();i++){
            int l = i;
            int r = i;
            while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > llen){
                    longestPali = s.substring(l, r+1);
                    llen = r - l +1;
                }
                l--;
                r++;
            }

            int le = i;
            int ri = i+1;
            while(le >= 0 && ri < s.length() && s.charAt(le) == s.charAt(ri)){
                if(ri - le + 1 > llen){
                    longestPali = s.substring(le, ri + 1);
                    llen = ri - le + 1;
                }
                le--;
                ri++;
            }
        }
        return longestPali;
        
    }
}
