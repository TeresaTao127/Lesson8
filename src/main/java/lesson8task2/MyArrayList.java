package lesson8task2;

import java.util.Arrays;
import java.util.List;


public class MyArrayList implements OwnList {
    static final int default_capacity = 10;
    Integer[] elements;
    int size;

    public static void main(String[] args) {
        OwnList arrayList = new MyArrayList();
        List<Integer> numbers = List.of(3, -100, 6, 8, 128, 210);

        for (Integer number : numbers) {
            arrayList.add(number);
        }
        System.out.println("size of the MyArrayList: " + arrayList.size());
        System.out.println("the list is empty: " + arrayList.isEmpty());

        System.out.println("elements of the MyArrayList: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i) + "");
        }
        System.out.println("___________________________");

        arrayList.add(99);
        System.out.println("add an item 99 to the end of the list: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i) + "");
        }
        System.out.println("___________________________");

        arrayList.add(2, 27);
        System.out.println("element of the MyArrayList after adding: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i) + "");
        }
        System.out.println("___________________________");

        System.out.println("an item of the specified index 4: "+ arrayList.get(4));
        arrayList.remove(4);
        System.out.println("element of the MyArrayList after removing: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i) + "");
        }
        System.out.println("___________________________");
    }

    public MyArrayList() {
        this.elements = new Integer[default_capacity];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(Integer element) {
        ensureCapacity();
        elements[size++] = element;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        return elements[index];
    }

    @Override
    public void add(int index, Integer element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        ensureCapacity();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        Integer removeElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return removeElement;
    }
}
