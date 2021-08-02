package ir.maktab.java_second;

public class MainApp {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(linkedList.isEmpty());
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(7);
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.delete());
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.delete());
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.delete());
        System.out.println(linkedList.isEmpty());
    }
}
