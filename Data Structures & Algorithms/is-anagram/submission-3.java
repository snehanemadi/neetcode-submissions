class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] set = new int[26];
        for(int i=0;i<s.length();i++){
            set[s.charAt(i) - 'a']++;
            set[t.charAt(i) - 'a']--;
        }
        for(int val : set){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
}
