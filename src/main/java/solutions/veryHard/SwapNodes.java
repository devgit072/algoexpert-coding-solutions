package solutions.veryHard;

public class SwapNodes {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList nodeSwap(LinkedList head) {
        if(head == null || head.next == null) {
            return head;
        }
        LinkedList thirdNode;
        LinkedList prevNode = null;
        LinkedList firstNode = head;
        LinkedList secondNode = head.next;
        while (true) {
            thirdNode = secondNode.next;
            firstNode.next = thirdNode;
            secondNode.next = firstNode;
            if(prevNode != null) {
                prevNode.next = secondNode;
            } else {
                head = secondNode;
            }
            prevNode = firstNode;
            firstNode = thirdNode;
            if(firstNode == null || firstNode.next == null) {
                break;
            }
            secondNode = thirdNode.next;
        }
        return head;
    }
}
