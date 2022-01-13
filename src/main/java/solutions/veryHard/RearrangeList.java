package solutions.veryHard;

/*
Lets create a two new LinkedList. One list will contain the element lesser than k and other will contain element
greater than k.
At the end combine these two lists.
 */
public class RearrangeList {
    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList headOfList1 = null;
        LinkedList tailOfList1 = null;
        LinkedList headOfList2 = null;
        LinkedList tailOfList2 = null;
        LinkedList headOfList3 = null;
        LinkedList tailOfList3 = null;
        LinkedList currentPointer = head;
        while (currentPointer != null) {
            LinkedList nextOfCP = currentPointer.next;
            if (currentPointer.value < k) {
                if (headOfList1 == null) {
                    headOfList1 = currentPointer;
                    tailOfList1 = currentPointer;
                } else {
                    tailOfList1.next = currentPointer;
                    tailOfList1 = tailOfList1.next;
                }
                tailOfList1.next = null;
            } else if (currentPointer.value > k) {
                if (headOfList2 == null) {
                    headOfList2 = currentPointer;
                    tailOfList2 = currentPointer;
                } else {
                    tailOfList2.next = currentPointer;
                    tailOfList2 = tailOfList2.next;
                }
                tailOfList2.next = null;
            } else {
                if (headOfList3 == null) {
                    headOfList3 = currentPointer;
                    tailOfList3 = currentPointer;
                } else {
                    tailOfList3.next = currentPointer;
                    tailOfList3 = tailOfList3.next;
                }
                tailOfList3.next = null;
            }
            currentPointer = nextOfCP;
        }
        return mergeThreeList(headOfList1, headOfList2, headOfList3);
    }

    /**
     * Merge three lists.
     * List1 contains value lesser than k.
     * List2 contains value greater than k.
     * List3 contains value equal to k.
     */
    private static LinkedList mergeThreeList(LinkedList list1, LinkedList list2, LinkedList list3) {
        if (list1 == null) {
            return mergeTwoList(list2, list3);
        } else if (list2 == null) {
            return mergeTwoList(list1, list3);
        } else if (list3 == null) {
            return mergeTwoList(list1, list2);
        } else {
            // None of the three lists are null.
            if (list3.value < list1.value) {
                return mergeTwoList(mergeTwoList(list1, list3), list2);
            } else if(list2.value < list3.value){
                return mergeTwoList(list1, mergeTwoList(list2, list3));
            }  else {
                return mergeTwoList(list1, mergeTwoList(list3, list2));
            }
        }
    }

    private static LinkedList mergeTwoList(LinkedList list1, LinkedList list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if(list1.value > list2.value) {
            LinkedList temp = list1;
            list1 = list2;
            list2 = temp;
        }
        // Now merge both list.
        LinkedList tailOfList1 = list1;
        LinkedList tailOfList2 = list1;
        while (tailOfList1.next != null) {
            tailOfList1 = tailOfList1.next;
        }
        while (tailOfList2.next != null) {
            tailOfList2 = tailOfList2.next;
        }
        if (tailOfList1.value < list2.value) {
            tailOfList1.next = list2;
            return list1;
        } else {
            tailOfList2.next = list1;
            return list2;
        }
    }
}