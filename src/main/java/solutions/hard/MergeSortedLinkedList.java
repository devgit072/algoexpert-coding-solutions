package solutions.hard;

public class MergeSortedLinkedList {
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList temp1;
        LinkedList temp2;
        boolean headOneIsBigger = true;
        if(headOne.value <= headTwo.value) {
            temp1 = headOne;
            temp2 = headTwo;
        } else {
            headOneIsBigger = false;
            temp1 = headTwo;
            temp2 = headOne;
        }

        while (temp1 != null && temp2 != null) {
            if(temp1.value == temp2.value || (temp1.next != null && temp1.value < temp2.value && temp1.next.value >= temp2.value) || (temp1.next == null && temp1.value <= temp2.value)) {
                LinkedList temp2Node = temp2;
                temp2 = temp2.next;
                temp2Node.next = temp1.next;
                temp1.next = temp2Node;
                temp1 = temp1.next;
            } else {
                temp1 = temp1.next;
            }
        }
        if(headOneIsBigger) {
            return headOne;
        } else {
            return headTwo;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(2);
        list.next = new LinkedList(6);
        list.next.next = new LinkedList(7);
        list.next.next.next = new LinkedList(8);

        LinkedList list2 = new LinkedList(1);
        list2.next = new LinkedList(3);
        list2.next.next = new LinkedList(4);
        list2.next.next.next = new LinkedList(5);
        list2.next.next.next.next = new LinkedList(9);
        list2.next.next.next.next.next = new LinkedList(10);

        LinkedList result = mergeLinkedLists(list, list2);
        while (result != null) {
            System.out.print("  " + result.value);
            result = result.next;
        }
    }
}
