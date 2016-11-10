class MyStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> queue = q2.isEmpty() ? q1 : q2;
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> queue = q2.isEmpty() ? q1 : q2;
        Queue<Integer> otherQueue = q2.isEmpty() ? q2 : q1;
        while(queue.size() > 1) {
            otherQueue.add(queue.remove());
        }
        queue.remove();
    }

    // Get the top element.
    public int top() {
        Queue<Integer> queue = q2.isEmpty() ? q1 : q2;
        Queue<Integer> otherQueue = q2.isEmpty() ? q2 : q1;
        int last = 0;
        do {
            last = queue.peek();
            otherQueue.add(queue.remove());
        } while(!queue.isEmpty());
        
        return last;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}