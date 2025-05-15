class MedianFinder {
    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;
    double med;
    public MedianFinder() {
        leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
        rightHeap = new PriorityQueue<>();
        med=1.0;
    }
    
    public void addNum(int num) {
        if (leftHeap.size() > rightHeap.size()) {
            if (num < med) {
                rightHeap.offer(leftHeap.poll());
                leftHeap.offer(num);
            }
            else{
                rightHeap.offer(num);
            }
            med = (leftHeap.peek() + rightHeap.peek()) / 2.0;
        }
        else if (leftHeap.size() == rightHeap.size()) {
            if (num < med) {
                leftHeap.offer(num);
                med = (double) leftHeap.peek();
            }
            else{
                rightHeap.offer(num);
                med = (double) rightHeap.peek();
            }
        }
        else {
            if (num > med) {
                leftHeap.offer(rightHeap.poll());
                rightHeap.offer(num);
            }
            else{
               leftHeap.offer(num); 
            }
            med = (leftHeap.peek() + rightHeap.peek()) / 2.0;
        }
    }
    
    public double findMedian() {
        return med;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */