class Main {
    public static void main(String[] args) {
        
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode list = new ListNode();
        head = head.next;
        while(head.val != 0) {
            list.val += head.val;
            head = head.next;
        }
        int sum = 0;
        ListNode lastNode = list;
        head = head.next;
        while(head != null) {
            if(head.val == 0) {
                lastNode.next = new ListNode(sum);
                lastNode = lastNode.next;
                sum = 0;
            } else
                sum += head.val;
            head = head.next;
        }
        return list;
    }
}