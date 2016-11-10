public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev = null;
        Node next = null;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private final Map<Integer, Node> map = new HashMap<>();
    private Node head = null;
    private Node tail = null;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        
        moveToHead(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        int val = get(key);
        if(val != -1) {
            map.get(key).value = value;
            return;
        }
        
        if(this.capacity == 0) {
            if(tail == null) return;
            removeTail();
            this.capacity++;
        }
        Node node = new Node(key, value);
        addHead(node);
        map.put(key, node);
        this.capacity--;
    }
    
    private void removeTail() {
        if(tail == null) return;
        map.remove(tail.key);
        
        if(tail == head) {
            head = tail = null;
        } else {
            Node tailPrev = tail.prev;
            tail.prev = null;
            tail = tailPrev;
            tail.next = null;
        }
    }
    
    private void moveToHead(Node node) {
        if(head == node) return;
        Node prev = node.prev;
        prev.next = node.next;
        if(node.next != null) {
            node.next.prev = prev;
        } else {
            tail = tail.prev;
        }
        addHead(node);
    }
    
    private void addHead(Node node) {
        node.prev = null;
        node.next = head;
        
        if(tail == null) {
            tail = node;
        } else {
            head.prev = node;
        }
        head = node;
    }
}