class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumSquareDigits(n);

        while(slow != fast){
            fast = sumSquareDigits(fast);
            fast = sumSquareDigits(fast);
            slow = sumSquareDigits(slow);
        }

        if(fast == 1){
            return true;
        }
        return false;

    }

    private int sumSquareDigits(int n){
        int output =0;
        while (n != 0){
            output += (n%10) * (n%10);
            n /= 10;
        }
        return output;
    }
}
