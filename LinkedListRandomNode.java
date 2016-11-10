/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode head;
    private int length;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.length = 0;
        this.head = head;
        
        while(head != null) {
            head = head.next;
            this.length++;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(length);
        
        ListNode runner = head;
        while(index > 0) {
            runner = runner.next;
            index--;
        }
        return runner.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */