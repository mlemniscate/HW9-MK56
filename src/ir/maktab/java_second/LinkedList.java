package ir.maktab.java_second;

import java.util.Objects;

public class LinkedList<T> {
    Node<T> head;
    Node<T> tail;

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

    /*T delete(int index) {
        int counter = 0;
        Node<T> previousNode = head;
        Node<T> deleteNode = head.next;
        Node<T> nextNode = deleteNode.next;
        while(counter < index) {
            if(deleteNode == tail);
        }
    }*/
}
