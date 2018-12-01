package com.ddlab.rnd.core1;

import java.util.Arrays;

public class MyArrayList {
    private int size;
    private int defaultCapacity = 10;
    private Object[] elements;

    public MyArrayList() {
        elements = new Object[defaultCapacity];
    }

    public void add(Object x) {
        if( elements.length == size )
            ensureCapacity();
        elements[size++] = x;
    }

    public void ensureCapacity() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity+(oldCapacity >> 1);
        elements = Arrays.copyOf(elements,newCapacity);
    }

    public void deleteFirst() {
        elements = Arrays.copyOfRange(elements, 1, elements.length);
        size--;
        System.out.println("\n Size :::"+size+"array size :::"+elements.length);
    }

    public void display() {
        for( Object x : elements)
            System.out.print(x+"\t");
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        for( int i = 0 ; i < 10 ; i++ ) {
            list.add("S"+i);
        }
//        list.display();
//        System.out.println("\n");
        list.deleteFirst();
        System.out.println("\n-------11111111---------");
        list.display();
        System.out.println("\n--------2222222----------");
        list.add("S11");
        list.deleteFirst();
        list.display();
    }
}
