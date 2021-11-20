// Linked List Random Node 

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
    ListNode[] arr;
    int count;
    public Solution(ListNode head) {
        count = 1;
        ListNode current = head;
        while(current.next != null) {
            current = current.next;
            count++;
        }
        //System.out.println(count);
        arr = new ListNode[count];
        int index = 0;
        while(head != null) {
            
            arr[index++] = head;
            head = head.next;
            
        }
        // for(int i = 0 ; i < arr.length ;i++) {
        //     System.out.print(arr[i].val);
        // }
    }
    
    public int getRandom() {
        int pick = (int)(Math.random() * arr.length);
        return arr[pick].val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

 //Validate Stack Sequence

 class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null && popped == null) {
            return true;
        }
        
        Stack<Integer> stack = new Stack();
        int j = 0;
        for(int i : pushed) {
            stack.push(i);
            while(!stack.isEmpty() && j < pushed.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == pushed.length;
    }
}