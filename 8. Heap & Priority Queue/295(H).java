//295. Find Median from Data Stream (Hard)

class MedianFinder {
    PriorityQueue<Integer> minHeap; 
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() > num){
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        //rebalance the heaps 
        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        } else if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }

    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }
        else{
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


/*
follow up question: how to make the method thread safe:
introduce synchronized to ensure mutual exclusion
- public synchronized void addNum()
- public synchronized double findMedian()
--> this is safe & simple but limits concurrency. findMedian will block addNum

for higher concurrency:
- use a ReentrantReadWriteLock: multiple readers (median queries) allowed but writes (addNum) are exclusive
- use concurrent heap structures or implement a lock-free structure

*/

import java.util.concurrent.locks.ReentrantReadWriteLock;

class MedianFinder {
    private final PriorityQueue<Integer> minHeap; 
    private final PriorityQueue<Integer> maxHeap;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        lock.writeLock().lock();
        try {
            if(maxHeap.isEmpty() || maxHeap.peek() > num){
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            if(maxHeap.size() > minHeap.size() + 1){
                minHeap.add(maxHeap.poll());
            } else if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public double findMedian() {
        lock.readLock().lock();
        try {
            if(minHeap.size() == maxHeap.size()){
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        } finally {
            lock.readLock().unlock();
        }
    }
}