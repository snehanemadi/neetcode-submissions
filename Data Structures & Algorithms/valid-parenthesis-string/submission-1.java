class Solution {
    //leftMin: Tracks the minimum possible number of unmatched open parentheses 
    //if * is treated as a closing parenthesis or an empty string.
    //leftMax: Tracks the maximum possible number of unmatched open parentheses 
    //if * is treated as an open parenthesis. 
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                leftMin++;
                leftMax++;
            } else if(c == ')'){
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if(leftMax < 0){
                return false; // too less open para
            }
            if(leftMin < 0){
                leftMin = 0; //adjest , consider it as right para
            }
        }
        return leftMin == 0;
    }
}
