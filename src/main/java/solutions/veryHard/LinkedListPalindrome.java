package solutions.veryHard;

public class LinkedListPalindrome {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public boolean linkedListPalindrome(LinkedList head) {
        /*
            First of all detach the linked list from the middle.
            Then reverse the second half of the linked list.
            Now compare the first and second linked list.
         */
        if (head.next == null) {
            return true;
        } else if(head.next.next == null) {
            return head.value == head.next.value;
        }
        LinkedList slowPointer = head;
        LinkedList fastPointer = head;
        while (fastPointer.next != null) {
            if (fastPointer.next.next == null) {
                break;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        // slowpointer will be the last element of the linked list.
        LinkedList headOfSecondHalf = slowPointer.next;
        slowPointer.next = null;
        // Now reverse this second half linked list.
        headOfSecondHalf = reverseList(headOfSecondHalf);
        // Now compare the two linked list.
        LinkedList temp1 = head;
        LinkedList temp2 = headOfSecondHalf;
        while (temp1 != null && temp2 != null) {
            if(temp1.value != temp2.value) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    LinkedList reverseList(LinkedList node) {
        if (node.next == null) {
            return node;
        }
        LinkedList temp = node.next;
        LinkedList prevTemp = node;
        prevTemp.next = null;
        while (temp != null) {
            LinkedList temp3 = temp.next;
            temp.next = prevTemp;
            prevTemp = temp;
            temp = temp3;
        }
        return prevTemp;
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(3);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        System.out.println(new LinkedListPalindrome().linkedListPalindrome(head));
    }
}
