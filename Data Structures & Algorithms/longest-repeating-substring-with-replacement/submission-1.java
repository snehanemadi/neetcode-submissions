class Solution {
    // if we check every substring - n^2 substring
    // O(26*n)
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];

        int res = 0;
        int max = 0;
        int l = 0;

        for(int r = 0; r < s.length() ; r++){
            arr[s.charAt(r) - 'A']++;
            max = Math.max(max, arr[s.charAt(r) - 'A']);

            //
            if(r - l + 1 - max > k) { // windowLen - count(max occuring element)
                arr[s.charAt(l) - 'A']--;
                l++; // moving L to L++
            } // when we reach invalid one move left pointer to right - this is invalid case
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

}


