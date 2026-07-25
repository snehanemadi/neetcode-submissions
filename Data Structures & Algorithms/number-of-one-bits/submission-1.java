class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
        // the above one is logically removing each bit at a time and counting it

        // int count = 0;
        // while(n != 0){
        //     count += n % 2;
        //     n = n >> 1;
        // }
        // return count;
        // this will check all the bits even 0's but TC : O(32)
    }
}
