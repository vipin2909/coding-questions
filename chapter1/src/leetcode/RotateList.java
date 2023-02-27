package leetcode;

// https://leetcode.com/problems/rotate-list/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class RotateList {

    // approach -> first find n-k nodes and append the last k nodes
    // pointing to first n-k node list

    // ex. 1->2->3->4->5->6->null
    // k = 2
    // 1->2->3->4->null 5->6->null;
    // result 5->6->1->2->3->4->null;

    public void printList(ListNode head) {
        ListNode current = head;
        while(current!=null) {
            System.out.print(current.val+" -> ");
            current = current.next;
        }
        System.out.println("null");
    }


    public ListNode rotateRight(ListNode head, int k) {

        if(k == 0 || head == null) return head;
        ListNode current = head;
        int totalNodes = 0;

        // counting total number of nodes
        while(current != null) {
            current = current.next;
            totalNodes += 1;
        }

        // case to check if k is multiple of totalNodes
        k %= totalNodes;
        if(k == 0) return head;
        current = head;
        ListNode dummyNode = new ListNode(0);
        ListNode tempNode = dummyNode;
        int count = 0;
        while(count < totalNodes - k) {
            tempNode.next = current;
            tempNode = tempNode.next;
            current = current.next;
            count += 1;
        }

        tempNode.next = null;

        ListNode cu = current;
        ListNode ans = cu;
        while(ans.next != null) {
            ans = ans.next;

        }

        ans.next = dummyNode.next;
        return cu;
    }


    public ListNode createListUsingKeys(int[] arr) {
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        for(int i = 0; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        printList(dummyNode);
        return dummyNode.next;
    }


    public static void main(String[] args) {
        RotateList obj  = new RotateList();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head = obj.createListUsingKeys(arr);
        ListNode result = obj.rotateRight(head, 2);
        obj.printList(result);
    }
}
