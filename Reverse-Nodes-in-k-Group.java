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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        int i = 0;
        ListNode pivot = head;
        while(i++<k){
            head = head.next;
        }
        var t = rever(pivot,head);i =0;
        ListNode a = null ;
        while(head!=null&& i++<k){
            head = head.next;
            if(i==k) {
                i = 0;
                a = pivot.next;
                pivot.next = rever(pivot.next,head);
                pivot = a;
            }
        }
        return t;
    }
    private ListNode rever(ListNode head, ListNode tail){
        ListNode pre = tail;
        while(head!=tail){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head= temp;
        }
        return pre;
    }
}