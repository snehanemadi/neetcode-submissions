class Solution {

//passes only in case of all chars
    // public boolean isPalindrome(String s) {
    //     int l = 0;
    //     int r = s.length()-1;
    //     while(l < r && s.charAt(l) == s.charAt(r)){
    //         l++;
    //         r--;
    //     } if( l == r){
    //         return true;
    //     }else {
    //             return false;
    //     }
    // } 


    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            //when its not char/digit
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if(Character.toLowerCase(s.charAt(l)) != 
            Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    } 
}


