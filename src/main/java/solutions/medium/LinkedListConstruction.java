package solutions.medium;

public class LinkedListConstruction {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            head = node;
            if(head.next == null) {
                tail = node;
            }
        }

        public void setTail(Node node) {
            tail = node;
            if(tail.prev == null) {
                head = node;
            }
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            if(node == head) {
                head = nodeToInsert;
                nodeToInsert.prev = null;
            } else {
                Node prevNode = node.prev;
                prevNode.next = nodeToInsert;
                nodeToInsert.prev = prevNode;
            }
            node.prev = nodeToInsert;
            nodeToInsert.next = node;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if(node == tail) {
                tail = nodeToInsert;
            } else {
                Node nextNode = node.next;
                nodeToInsert.next = nextNode;
                nextNode.prev = nodeToInsert;
            }
            nodeToInsert.prev = node;
            node.next = nodeToInsert;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            int startPosition = 1;
            Node pointer = head;
            while(pointer != null) {
                if(startPosition == position) {
                    insertAfter(pointer, nodeToInsert);
                    return;
                }
                pointer = pointer.next;
            }
        }

        public void removeNodesWithValue(int value) {
            Node pointer = head;
            while(pointer != null) {
                if(pointer.value == value) {
                    Node nodeToBeDeleted = pointer;
                    pointer = pointer.next;
                    remove(nodeToBeDeleted);
                    continue;
                }
                pointer = pointer.next;
            }
        }

        public void remove(Node node) {
            Node pointer = head;
            while(pointer != null) {
                if(node.value == pointer.value) {
                    // this is node to be deleted.
                    if(pointer == head) {
                        Node nextNode = node.next;
                        head = nextNode;
                        if(nextNode != null) {
                            nextNode.prev = null;
                        }
                        node.next = null;
                    } else {
                        Node prevNode = node.prev;
                        Node nextNode = node.next;
                        prevNode.next = nextNode;
                        if(nextNode != null) {
                            nextNode.prev = prevNode;
                        }
                    }
                    return;
                }
                pointer = pointer.next;
            }
        }

        public boolean containsNodeWithValue(int value) {
            Node pointer = head;
            while(pointer != null) {
                if(pointer.value == value) {
                    return true;
                }
                pointer = pointer.next;
            }
            return false;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
