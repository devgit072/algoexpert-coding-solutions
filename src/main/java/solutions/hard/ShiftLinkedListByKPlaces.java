package solutions.hard;

public class ShiftLinkedListByKPlaces {
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        if (head.next == null || k == 0) {
            return head;
        }

        int lengthOfList = getLengthOfLinkedList(head);
        k = k % lengthOfList;
        if (k == 0) {
            return head;
        }


        // The solution for this question lies in the fact that we have to find four nodes:
        // The original head, the original tail, the new head and new tail.
        // In both cases, k>0 or k<0, the location for those 4 nodes will solve the question.
        LinkedList originalHead = head;
        LinkedList originalTail = head;
        while (originalTail.next != null) {
            originalTail = originalTail.next;
        }
        LinkedList newTail = head;
        LinkedList newHead = head.next;
        int i = 1;

        int stepsToTravel = lengthOfList - k;
        if (k < 0) {
            stepsToTravel = Math.abs(k);
        }
        while (i < stepsToTravel) {
            newTail = newTail.next;
            newHead = newTail.next;
            i++;
        }
        originalTail.next = originalHead;
        head = newHead;
        newTail.next = null;
        return head;
    }

    static int getLengthOfLinkedList(LinkedList temp) {
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(0);
        list.next = new LinkedList(1);
        list.next.next = new LinkedList(2);
        list.next.next.next = new LinkedList(3);
        list.next.next.next.next = new LinkedList(4);
        list.next.next.next.next.next = new LinkedList(5);
        LinkedList res = shiftLinkedList(list, 5);
        while (res != null) {
            System.out.print(res.value + "   ");
            res = res.next;
        }
    }
}
