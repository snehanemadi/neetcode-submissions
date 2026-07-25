class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public int lastStoneWeight(int[] stones) {
        for(int num : stones){
            minHeap.offer(-num);
        }

        while(minHeap.size() > 1){
            int first = minHeap.poll();
            int second = minHeap.poll();
            if(second > first){
                minHeap.offer(first - second);
            }
        }
        minHeap.offer(0);
        return Math.abs(minHeap.peek());
        
    }
}
