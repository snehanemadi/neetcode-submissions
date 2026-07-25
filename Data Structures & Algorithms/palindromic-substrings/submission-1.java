class Solution {
    // O(n^2)
    public int countSubstrings(String s) {
        int res =0;
        for(int i = 0 ;i < s.length() ; i++){
            int l = i;
            int r = i;
            while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                res += 1;
                l--;
                r++;
            }

            int le = i;
            int ri = i+1;
            while(le >=0 && ri < s.length() && s.charAt(le) == s.charAt(ri)){
                res += 1;
                le--;
                ri++;
            }

        }   
        return res; 
    }
}
