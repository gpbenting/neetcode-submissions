/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                queue.offer(listNode.val);
                listNode = listNode.next;
            }
        }

        ListNode result = null;
        if (!queue.isEmpty()) {
            result = new ListNode(queue.poll(), null);
        }

        ListNode currentNode = result;
        while (!queue.isEmpty()) {
            ListNode nextNode = new ListNode(queue.poll(), null);
            currentNode.next = nextNode;
            currentNode = nextNode;
        }
        
        return result;
    }
}
