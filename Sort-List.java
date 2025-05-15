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
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        return quickSort(head);
    }
    private ListNode quickSort(ListNode head){
        return quickSort(head , null);
    }
    private ListNode quickSort(ListNode head , ListNode stop){
        if(head == null || head.next == null || head == stop || head.next == stop) return head;
        ListNode prev = head;
        ListNode lowHead = head;
        ListNode tail = head.next;
        boolean isSorted = true;
        while(tail != stop){
            isSorted = isSorted && prev.val <= tail.val;
            if(tail.val < head.val){
                prev.next = tail.next;
                tail.next = lowHead;
                lowHead = tail;    
            }
            else{
                prev = prev.next;
            }
            tail = prev.next;
        }
        if(isSorted) return head;
        ListNode result = quickSort(lowHead , head);
        head.next = quickSort(head.next , stop);
        return result;
    }
}