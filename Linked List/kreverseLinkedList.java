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
    // temporary head & tail
    ListNode th = null;
    ListNode tt = null;
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        int len = length(head);
        // original head
        ListNode oh = null;
        ListNode ot = null;
        ListNode curr = head;
        while(curr != null && len >= k){
            int temp = k;
            while(temp-- > 0){
                ListNode forw = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forw;
            }
            len -= k;
            if(oh == null){
                oh = th;
                ot = tt;
            }
            else{
                ot.next = th;
                ot = tt;
            }
            th = null;
            tt = null;
        }
        ot.next = curr;
        return oh;
        
    }
    
    public int length(ListNode node){
        int len = 0;
        while(node != null){
            node = node.next;
            len++;
        }
        return len;
    }
    
    public void addFirst(ListNode node){
        if(th == null){
            th = node;
            tt = node;
        }
        else{
            node.next = th;
            th = node;
        }
    }
}
