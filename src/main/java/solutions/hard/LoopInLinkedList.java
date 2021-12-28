package solutions.hard;

public class LoopInLinkedList {
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static LinkedList findLoop(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;

        LinkedList meetPoint = null;
        while (slow != null || fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meetPoint = slow;
                break;
            }
        }
        LinkedList start = head;
        LinkedList another = meetPoint;
        while (true) {
            if (start == another) {
                return start;
            }
            start = start.next;
            another = another.next;
        }
    }
}
