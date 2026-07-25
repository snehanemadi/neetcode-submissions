class Solution {
    //another A will come after n slots
    // have to pick characters which are more in the beginning only
    // A,A,A,B,B,C,C,C,C
    // in this case C 1st then B are the prioriry order
    //use Heap

    //n, n
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        for(char task : tasks){
            counts.put(task, counts.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.addAll(counts.values());

        int time = 0;
        //
        Deque<int []> q = new ArrayDeque<>(); 
        // count, IdleTime(time at which task is going to be available -> n + curTime) 
        //check each time if any of the task at queue is available then add back to heap

        while(!maxHeap.isEmpty() || !q.isEmpty()){
            if(!q.isEmpty() && time >= q.peek()[1]){
                maxHeap.offer(q.poll()[0]);
            }
            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll() - 1;
                if(count > 0){
                    q.offer(new int[]{count, time + n + 1});
                }
            }
            time++;
        }
        return time;
    }
}
