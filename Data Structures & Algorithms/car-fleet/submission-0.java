class Solution {
    //n logn
    // stack - n space
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] pairs = new double[n][2];

        for(int i = 0; i< n ;i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, (a,b) -> Double.compare(b[0], a[0]));

        int fleetCount = 0;
        double[] timeToReach = new double[n];

        for(int i=0; i<n; i++){
            timeToReach[i] = (target - pairs[i][0]) / pairs[i][1];
            if(i >= 1 && timeToReach[i] <= timeToReach[i-1]){
                timeToReach[i] = timeToReach[i-1];
            } else {
                fleetCount++;
            }
        }
        return fleetCount;
    }

    // public int carFleet(int target, int[] position, int[] speed) {
    //     int n = position.length;
    //     double[][] pairs = new double[n][2];

    //     for(int i = 0; i< n ;i++){
    //         pairs[i][0] = position[i];
    //         pairs[i][1] = speed[i];
    //     }
    //     Arrays.sort(pairs, (a,b) -> Double.compare(b[0], a[0]));

    //     int[] stack = new int[n];

    //     for(double[] pair : pairs){
    //         stack.add((target - pair[0]) / pair[1]);
    //         //as we traverse in reverse order ifisenough no need of while
    //         if(stack.length >= 2 && stack[stack.length - 1] <= stack[stack.length - 2]){
    //             stack.remove()
    //         }
    //         return stack.length;
    //     }
    // }
}
