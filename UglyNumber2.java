public class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue2 = new PriorityQueue<>();
        queue2.add(2L);
        PriorityQueue<Long> queue3 = new PriorityQueue<>();
        queue3.add(3L);
        PriorityQueue<Long> queue5 = new PriorityQueue<>();
        queue5.add(5L);
        
        int value = 1;
        for(int i=1; i<n; i++) {
            long nextValue = Math.min(queue2.peek(), Math.min(queue3.peek(), queue5.peek()));
            if(queue2.peek() == nextValue) {
                while((queue2.peek() != null) && (queue2.peek() == nextValue)) queue2.poll();
                queue2.add(nextValue * 2);
                queue2.add(nextValue * 3);
                queue2.add(nextValue * 5);
            } 
            if(queue3.peek() == nextValue) {
                while((queue3.peek() != null) && (queue3.peek() == nextValue)) queue3.poll();
                queue3.add(nextValue * 3);
                queue3.add(nextValue * 5);
            } 
            if(queue5.peek() == nextValue) {
                while((queue5.peek() != null) && (queue5.peek() == nextValue)) queue5.poll();
                queue5.add(nextValue * 5);
            }
            value = (int) nextValue;
        }
        return value;
    }
}