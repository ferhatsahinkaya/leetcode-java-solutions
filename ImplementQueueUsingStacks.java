class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        move(s2, s1);
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        move(s1, s2);
        s2.pop();
    }

    // Get the front element.
    public int peek() {
        move(s1, s2);
        return s2.peek();
    }
    
    private void move(Stack<Integer> start, Stack<Integer> end) {
        while(!start.empty()) {
            end.push(start.pop());
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}