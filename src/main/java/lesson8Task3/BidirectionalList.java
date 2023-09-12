package lesson8Task3;


import jdk.jshell.spi.SPIResolutionException;

public class BidirectionalList<T> {
    public static void main(String[] args) {
        BidirectionalList<String> myList = new BidirectionalList<>();
        myList.add("name");
        myList.add("gender");
        myList.add("nationality");
        myList.add("education");

        System.out.println("List size: " + myList.size);
        System.out.println("My list is: " + myList);

        myList.add(1, "age");
        System.out.println("List size after adding: " + myList.size);
        System.out.println("My list after adding is: " + myList);

        myList.remove(3);
        System.out.println("List size after removing: " + myList.size);
        System.out.println("My list after removing is: " + myList);
    }
    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public BidirectionalList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node current = getNodeAtIndex(index);
            Node previous = current.prev;
            newNode.prev = previous;
            newNode.next = current;
            previous.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        Node removeNode;
        if (size == 1) {
            removeNode = head;
            head = null;
            tail = null;
        } else if (index == 0) {
            removeNode = head;
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            removeNode = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            Node current = getNodeAtIndex(index);
            Node previous = current.prev;
            Node next = current.next;
            previous.next = next;
            next.prev = previous;
            removeNode = current;
        }
        size--;
        return removeNode.data;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.data).append(",");
            current = current.next;
        }
        return result.toString();
    }

    private Node getNodeAtIndex(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
