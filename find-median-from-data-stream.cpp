class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //smaller half
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || (maxHeap.peek()>=num)){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }
        //rebalance if necessary - maxHeap will always be 1 bigger if not equal
        if(minHeap.size()+1<maxHeap.size()){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size()>maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return ((double)(minHeap.peek()+maxHeap.peek()))/2.0;
        }
        else return (double) maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */