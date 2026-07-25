class Solution {
    // brute force is n^n

    //2^n -> sub sequence problems [1, 3, 5]

    //popping 1st will not give us proper sub array
    //instaed popping 1st - > pop last
    // pop 5 last -> 1*3*5(pop 3) then (pop 1) 1*1*5
    //n^3, n^2

    //there are n^2 -> sub arrays
    public int maxCoins(int[] nums) {
        int[][] cache = new int[nums.length + 2][nums.length + 2];
        int[] newnums = new int[nums.length + 2];
        newnums[0] = newnums[nums.length + 1] = 1;
        for(int i=0; i < nums.length;i++){
            newnums[i+1] = nums[i];
        }

        for(int offset = 2; offset < newnums.length; offset++){
            for(int left = 0; left < newnums.length - offset; left++){
                int right = left + offset;
                for(int pivot = left + 1; pivot < right ; pivot++){
                    int coins = newnums[left] * newnums[pivot] * newnums[right];

                    coins += cache[left][pivot] + cache[pivot][right];

                    cache[left][right] = Math.max(coins, cache[left][right]);
                }
            }
        }
        return cache[0][newnums.length - 1];
    }
}
