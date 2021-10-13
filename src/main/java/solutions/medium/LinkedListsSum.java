package solutions.medium;

public class LinkedListsSum {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        if(linkedListOne == null) {
            return linkedListTwo;
        }
        if (linkedListTwo == null) {
            return linkedListOne;
        }
        LinkedList prev = null;
        LinkedList head = null;
        int carry = 0;
        while(linkedListOne != null && linkedListTwo != null) {
            LinkedList node = new LinkedList(0);
            int sum = linkedListOne.value + linkedListTwo.value + carry;
            if( sum > 9) {
                int v = sum - 10;
                carry = 1;
                node.value = v;
            } else {
                node.value = sum;
                carry = 0;
            }
            if(head == null) {
                head = node;
                prev = node;
            } else {
                prev.next = node;
                prev = node;
            }
            linkedListOne = linkedListOne.next;
            linkedListTwo = linkedListTwo.next;
        }
        while(linkedListOne != null) {
            LinkedList node = new LinkedList(0);
            int sum = linkedListOne.value + carry;
            if(sum > 9) {
                int v = sum - 10;
                carry = 1;
                node.value = v;
            } else {
                node.value = sum;
                carry = 0;
            }
            prev.next = node;
            prev = node;
            linkedListOne = linkedListOne.next;
        }
        while(linkedListTwo != null) {
            LinkedList node = new LinkedList(0);
            int sum = linkedListTwo.value + carry;
            if(sum > 9) {
                int v = sum - 10;
                carry = 1;
                node.value = v;
            } else {
                node.value = sum;
                carry = 0;
            }
            prev.next = node;
            prev = node;
            linkedListTwo = linkedListTwo.next;
        }
        if(carry == 1) {
            prev.next = new LinkedList(1);
        }
        return head;
    }
}
