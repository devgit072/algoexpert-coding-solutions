package solutions.hard;

public class ReverseLinkedList {
    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList temp1 = head;
        LinkedList temp2 = head.next;
        temp1.next = null;
        LinkedList headTemp = head;
        while (temp2 != null) {
            LinkedList temp3 = temp2.next;
            temp2.next = temp1;
            headTemp = temp2;
            temp1 = temp2;
            temp2 = temp3;
        }
        return headTemp;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
