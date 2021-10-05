package com.devrajs.algoexpert.easy.easy;

public class RemoveDuplicates {
    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList currNode = linkedList;
        while (currNode != null && currNode.next != null) {
            while (currNode.next != null && currNode.value == currNode.next.value) {
                currNode.next = currNode.next.next;
            }
            currNode = currNode.next;
        }
        return linkedList;
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
