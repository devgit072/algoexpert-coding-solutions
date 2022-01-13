package solutions.veryHard;

import java.util.HashMap;
import java.util.Map;

/**
 * In order to develop constant time insertion, access and deletion in the LRU cache, we will have to use the
 * combination of two data structure: Hashmap and DoublyLinkedList; The doubly linked list stores the items in the
 * sequential manner as they are accessed. The most recently item will be the first element in the doubly linked list.
 * The last item in the list will be the least recently item and will be the candidate for the deletion.
 * The use of doubly linked list helps us to move the node fast.
 */
public class LRU {
    static class DoublyLinkedList {
        String key;
        int value;
        DoublyLinkedList next;
        DoublyLinkedList prev;

        DoublyLinkedList(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCache {
        int maxSize;
        Map<String, DoublyLinkedList> map;
        DoublyLinkedList head;
        DoublyLinkedList tail;

        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
            map = new HashMap<>();
            head = null;
            tail = null;
        }

        public void insertKeyValuePair(String key, int value) {
            if (map.containsKey(key)) {
                DoublyLinkedList node = map.get(key);
                node.value = value;
                map.put(key, node);
                moveNodeAtBeginning(node);
                return;
            }
            if (map.size() == maxSize) {
                DoublyLinkedList deletedNode = deleteTheLastNodeFromList();
                map.remove(deletedNode.key);
            }
            DoublyLinkedList node = insertNodeAtBeginning(key, value);
            map.put(key, node);
        }

        DoublyLinkedList insertNodeAtBeginning(String key, int value) {
            DoublyLinkedList node = new DoublyLinkedList(key, value);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                DoublyLinkedList next = head.next;
                node.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
            }
            return node;
        }

        void moveNodeAtBeginning(DoublyLinkedList node) {
            if (node.key.equals(head.key)) {
                return;
            }
            if (node.key.equals(tail.key)) {
                tail = node.prev;
                node.prev.next = null;
            } else {
                DoublyLinkedList nextOfNode = node.next;
                DoublyLinkedList prevOfNode = node.prev;
                prevOfNode.next = nextOfNode;
                nextOfNode.prev = prevOfNode;
            }
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }

        DoublyLinkedList deleteTheLastNodeFromList() {
            DoublyLinkedList nodeToBeDeleted = tail;
            if (tail.prev == null) {
                head = null;
                tail = null;
            } else {
                DoublyLinkedList prevOfTail = tail.prev;
                prevOfTail.next = null;
                tail = prevOfTail;
            }
            return nodeToBeDeleted;
        }

        public LRUResult getValueFromKey(String key) {
            if (!map.containsKey(key)) {
                return new LRUResult(false, 0);
            }
            DoublyLinkedList node = map.get(key);
            moveNodeAtBeginning(node);
            return new LRUResult(true, node.value);
        }

        public String getMostRecentKey() {
            return head.key;
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.insertKeyValuePair("b", 2);
        cache.insertKeyValuePair("a", 1);
        cache.insertKeyValuePair("c", 3);
        System.out.println(cache.getMostRecentKey());
        System.out.println(cache.getValueFromKey("a").value);
        System.out.println(cache.getMostRecentKey());
        cache.insertKeyValuePair("d", 4);
        System.out.println(cache.getMostRecentKey());
        System.out.println(cache.getValueFromKey("b").value);
        cache.insertKeyValuePair("a", 5);
        System.out.println(cache.getValueFromKey("a").value);
    }
}
