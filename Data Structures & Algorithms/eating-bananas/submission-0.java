class Solution {
    //len(p) <= h else -1

    // k = 1 .. max(p) 
    // max(p)* len(p)

    // above there is iteration from 1 .. max(p)
    // can use binary search - > log(max(p))*len(p)


    // public int minEatingSpeed(int[] piles, int h) {
    //     int max = 0;
    //     for(int i = 0;i < piles.length;i++){
    //         if(piles[i] > max){
    //             max = piles[i];
    //         }
    //     }
    //     int hrAtMax = piles.length/h;
    //     int rate = max/hrAtMax;

    //     return rate;
    // }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while(l <= r){
            int k = (l + r)/2;

            int totalTime = 0;
            for(int p : piles){
                totalTime += Math.ceil((double) p / k);
            }
            if(totalTime <= h){
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }
}

