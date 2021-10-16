package solutions.medium;

public class RemoveKthNodeInList {
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList pointer1;
        LinkedList pointer2 = head;
        int i = 1;
        while (i < k) {
            pointer2 = pointer2.next;
            i++;
        }
        // now i = k
        pointer1 = head;
        LinkedList prevPointer = null;
        while (pointer2.next != null) {
            pointer2 = pointer2.next;
            prevPointer = pointer1;
            pointer1 = pointer1.next;
        }
        // now pointer1 will be pointing to kth node from the end.
        if (prevPointer == null) {
            head.value = pointer1.next.value;
            head.next = pointer1.next.next;
        } else {
            prevPointer.next = pointer1.next;
        }
    }

}
