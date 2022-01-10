package solutions.veryHard;

public class ZipLinkedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList zipLinkedList(LinkedList linkedList) {
        int linkedListLength = getLinkedListLength(linkedList);
        if(linkedListLength < 3) {
            return linkedList;
        }
        int halfPlusOne = linkedListLength / 2 + 1;
        LinkedList temp = linkedList;
        LinkedList prevTemp = null;
        int i = 0;
        while (i < halfPlusOne) {
            prevTemp = temp;
            temp = temp.next;
            i++;
        }
        // temp will be new head and prevTemp will point to null as part of first linkedList.
        prevTemp.next = null;
        LinkedList head2 = temp;
        head2 = reverseList(head2);
        // Now we have two linked list. The first head is linkedList and second linkedlist is head2.
        temp = linkedList;
        while (head2 != null) {
            LinkedList nextOf1stList = temp.next;
            LinkedList nextOf2ndList = head2.next;
            temp.next = head2;
            head2.next = nextOf1stList;
            head2 = nextOf2ndList;
            temp = nextOf1stList;
        }
        return linkedList;
    }

    private int getLinkedListLength(LinkedList head) {
        LinkedList temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private LinkedList reverseList(LinkedList node) {
        LinkedList temp = node;
        LinkedList nextTemp = node.next;
        if(nextTemp == null) {
            return node;
        }
        temp.next = null;
        while (nextTemp != null) {
            LinkedList nextOfNextTemp = nextTemp.next;
            nextTemp.next = temp;
            temp = nextTemp;
            nextTemp = nextOfNextTemp;
        }
        return temp;
    }
}
