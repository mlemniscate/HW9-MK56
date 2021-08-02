package ir.maktab.java_second;

import java.util.Objects;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    boolean isEmpty() {
        return Objects.isNull(head);
    }

    void add(T data) {
        Node<T> node = new Node<>(data);
        if(head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }

     T delete() {
        int counter = 0;
        Node<T> previousNode = head;
        if (previousNode.equals(tail)) {
            tail = null;
            head = null;
            return previousNode.data;
        } else {
            while (!previousNode.next.equals(tail)) {
                previousNode = previousNode.next;
            }
        }
        tail = previousNode;
        return previousNode.next.data;
    }


}
