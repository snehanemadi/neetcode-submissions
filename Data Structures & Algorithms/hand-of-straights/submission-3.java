class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for(int n : hand){
            count.put(n, 1+count.getOrDefault(n , 0));
        }

        PriorityQueue<Integer> minH = new PriorityQueue<>(count.keySet());

        while(!minH.isEmpty()){
            int first = minH.peek();

            for(int i= first;i < first + groupSize ; i++){ // increase by 1
                if(!count.containsKey(i)){
                    return false; // doesnt exsist 
                }
                count.put(i, count.get(i)-1); // used
                if(count.get(i) == 0){
                    if(minH.peek() != i){
                        return false; // some middle number became 0 // next sequence is not possible
                    }
                    minH.poll();
                }
            }
        }
        return true;
    }
}
