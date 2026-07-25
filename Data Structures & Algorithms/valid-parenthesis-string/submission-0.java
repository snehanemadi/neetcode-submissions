class Solution {
    // 3 diff decision -> 3^n 
    // with DP -> n^3
    //  cache i, leftopenN -> caching with 2 diff n^2
    //  but to caclculate on that will take n so n^3 overall

    //at any point closeN cannot be greater than openN
    // 3 calls when we get a *

    //greedy
    //n
    // keep track of max leftOpenN and min leftOpenN
    // depending on how we choose wild card

    //we should never let leftmin to be negative

    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }
}
