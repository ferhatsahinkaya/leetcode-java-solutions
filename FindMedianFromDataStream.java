public class MedianFinder {
    private final PriorityQueue<Integer> highNumbers = new PriorityQueue<Integer>();
    private final PriorityQueue<Integer> lowNumbers = new PriorityQueue<Integer>(1, Collections.reverseOrder());
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(lowNumbers.isEmpty()) {
            lowNumbers.add(num);
        } else {
            if(lowNumbers.size() == highNumbers.size()) {
                if(highNumbers.peek() >= num) {
                    lowNumbers.add(num);
                } else {
                    lowNumbers.add(highNumbers.poll());
                    highNumbers.add(num);
                }
            } else {
                if(lowNumbers.peek() <= num) {
                    highNumbers.add(num);
                } else {
                    highNumbers.add(lowNumbers.poll());
                    lowNumbers.add(num);
                }
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return (highNumbers.size() == lowNumbers.size()) 
                ? (highNumbers.peek() + lowNumbers.peek()) / 2.0
                : lowNumbers.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();