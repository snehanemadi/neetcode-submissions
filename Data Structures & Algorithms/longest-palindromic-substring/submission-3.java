class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int len = 0;
        for(int i = 0;i<s.length();i++){
            int l = i;
            int r = i;

            while( l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > len){
                    res = s.substring(l, r + 1);
                    len = r - l + 1;
                }
                l--;
                r++;
            }

            int le = i;
            int ri = i+1;

            while( le >=0 && ri < s.length() && s.charAt(le) == s.charAt(ri)){
                if(ri - le + 1 > len){
                    res = s.substring(le, ri + 1);
                    len = ri - le + 1;
                }
                le--;
                ri++;
            }

        }
        return res;
    }
}
