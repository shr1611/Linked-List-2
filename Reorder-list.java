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

// Time: O(n)
// Space: O(1)
class Solution {
    public void reorderList(ListNode head) {
      if(head == null || head.next == null || head.next.next == null){
        return;
      }
      ListNode p1 = head;
      ListNode p2 = head.next;
      while(!(p2 == null || p2.next == null)){
        p1 = p1.next;// slow pointer
        p2 = p2.next.next;// fast pointer
      }
      // split at p1
      ListNode tempHead = p1.next;
      p1.next = null;
      p1 = head;
      p2 = reverseList(tempHead);
      
      while(p1 != null && p2 != null){
        
        ListNode temp1 = p1.next;
        ListNode temp2 = p2.next;
        
        p1.next = p2;
       
        p2.next = temp1;
        p1 = temp1;
        p2 = temp2;
        
      }
      
    }
  public ListNode reverseList(ListNode head){
    ListNode prev = null;
      ListNode curr = head;
      ListNode next;
      
      while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        
      }
      
      return prev;
  }
}
