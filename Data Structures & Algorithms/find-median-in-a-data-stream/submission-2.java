class MedianFinder {
    private Queue<Integer> smallH; // maxheap
    private Queue<Integer> largeH; // minheap

    public MedianFinder() {
        smallH = new PriorityQueue<>((a,b) -> b - a);
        largeH = new PriorityQueue<>((a,b) -> a - b);
    }
    
    public void addNum(int num) {
        smallH.add(num);
        if(smallH.size() - largeH.size() > 1 || 
        !largeH.isEmpty() && smallH.peek() > largeH.peek()){
            largeH.add(smallH.poll());
        }
        if(largeH.size() - smallH.size() > 1){
            smallH.add(largeH.poll());
        }
    }
    
    public double findMedian() {
        if(smallH.size() == largeH.size()){
            return (double) (largeH.peek() + smallH.peek())/2;
        }
        else if(smallH.size() > largeH.size()){
            return (double) smallH.peek();
        } else {
            return (double) largeH.peek();
        }
    }
}
