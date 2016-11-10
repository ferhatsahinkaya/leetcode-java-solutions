/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        RandomListNode runner = head;
        while(runner != null) {
            RandomListNode runnerNext = runner.next;
            RandomListNode newNode = new RandomListNode(runner.label);
            runner.next = newNode;
            newNode.next = runnerNext;
            runner = runnerNext;
        }
        
        runner = head;
        while(runner != null) {
            RandomListNode random = runner.random;
            if(random != null) {
                runner.next.random = random.next;
            }
            runner = runner.next.next;
        }
        RandomListNode copyHead = null;
        RandomListNode copyTail = null;
        runner = head;
        while(runner != null) {
            RandomListNode runnerNext = runner.next.next;
            if(copyHead == null) {
                copyHead = runner.next;
            } else {
                copyTail.next = runner.next;
            }
            copyTail = runner.next;
            
            runner.next = runnerNext;
            runner = runnerNext;
        }
        return copyHead;
    }
}