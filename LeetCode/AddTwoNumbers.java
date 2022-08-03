class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode digit1 = l1;
        ListNode digit2 = l2;
        ListNode result = new ListNode();
        ListNode resultDigit = result;
        boolean firstDigit = true;
        do {
            int num1 = 0, num2 = 0;
            if(digit1 != null) {
                num1 = digit1.val;
                digit1 = digit1.next;
            }
            if(digit2 != null) {
                num2 = digit2.val;
                digit2 = digit2.next;
            }
            int total = carry + num1 + num2;
            if(firstDigit) {
                firstDigit = false;
                result.val = total % 10;
            } else {
                resultDigit.next = new ListNode(total % 10);
                resultDigit = resultDigit.next;
            }
            carry = total / 10;
        } while(digit1 != null || digit2 != null || carry > 0);
        return result;
    }
}