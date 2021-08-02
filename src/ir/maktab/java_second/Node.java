package ir.maktab.java_second;

public class Node<T> {
    T data;
    Node<T> next;


    public Node(T data) {
        this.data = data;
        next = null;
    }
}
