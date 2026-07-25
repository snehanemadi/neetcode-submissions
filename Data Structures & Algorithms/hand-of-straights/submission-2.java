class Solution {
    // brute force - complex no way to eliminate the repeated work

    // we can always have a min value - greedy to get min value
    //count number of each val
    // refine next min -> so use minH -> log n

    // over all -> logn * n
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for(int n: hand){
            count.put(n, 1+count.getOrDefault(n, 0));
        }

        PriorityQueue<Integer> minH = new PriorityQueue<>(count.keySet());
        while(!minH.isEmpty()){
            int first = minH.peek();
            for(int i = first; i < first + groupSize; i++){ // consicutive grp from smallest card
                if(!count.containsKey(i)){
                    return false;
                }
                count.put(i, count.get(i)-1);
                if(count.get(i) == 0){
                    if(i != minH.peek()){
                        return false;
                    }
                    minH.poll();
                }
            }
        }
        return true;
    }
}
