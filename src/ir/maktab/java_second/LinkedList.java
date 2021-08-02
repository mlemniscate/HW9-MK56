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

    boolean contain(T data) {
        Node<T> node = head;
        do {
            if(node.data.equals(data)) return true;
            else node = node.next;
        } while (!Objects.isNull(node));
        return false;
    }
}
