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
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
		    public int compare(ListNode head1,ListNode head2){
		        return head1.val-head2.val;
		    }
		});
        for(ListNode list:lists){
            if(list!=null)
            pq.add(list);
        }
        ListNode result=new ListNode(-1);
        ListNode temp1=result;
        while(!pq.isEmpty()){
            ListNode temp=pq.poll();
            temp1.next=new ListNode(temp.val);
            temp1=temp1.next;
            if(temp.next!=null){
                pq.add(temp.next);
            }
        }
        return result.next;
    }
}