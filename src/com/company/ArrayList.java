package com.company;

import java.util.Arrays;

/**
 * Creates the ArrayList from Scratch
 * @param <E>
 */
public class ArrayList<E> implements List<E> {
    int size;
    E[] arr;

    // Constructor
    public ArrayList() {
        this.size = 0;
        this.arr = (E[]) new Object[10];
    }

    @Override
    public int size() {
        return this.size;
    }

    // Grows the array
    private void grow_array () {
        E [] new_arr = (E[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++)
            new_arr[i] = arr[i];
        arr = new_arr;
    }


    // Adds a value at the end of the List
    @Override
    public boolean add(E item) {
        if (size == arr.length)
            grow_array();
        arr[size++] = item;
        return true;
    }


    // Add a value at an index
    @Override
    public void add(int pos, E item) {
        for (int i = size; i > pos; i--)
            arr[i] = arr[i-1];
        arr[pos] = item;
        ++size;
    }


    // Gets at an index
    @Override
    public E get(int pos) {
        try {
            if (pos < 0 || pos >= size)
                throw new Exception("Invalid position");
        } catch (Exception e) {
            System.out.println("Error out of bounds");
            return null;
        }

        return arr[pos];
    }


    // Removes at an index
    @Override
    public E remove(int pos) {
        try {
            if (pos < 0 || pos >= size)
                throw new Exception("Invalid position");
        } catch (Exception e) {
            System.out.println("Error out of bounds");
            return null;
        }

        E obj = arr[pos];
        for (int i=pos; i<size; i++) {
            arr[i] = arr[i+1];
            //--size;
        }

        size--;
        return obj;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "size=" + size +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }


    /**
     * For my own reference:
     * @param args
     */
    /*

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hopper");
//        for (int i=0; i<list.size; i++) {
//            System.out.println(list.get(i));
//        }

        list.add(0, "Hello");
        list.add("dog");
        list.add("bobby");
        list.add(4, "bobo");
        list.remove(3);

        for (int i=0; i<list.size-1; i++) {
            System.out.print(list.get(i) + " --> ");
//            if (i<list.size-1) {
//                System.out.print(list.get(i) + " --> ");
//                i++;
//            }
        }
        System.out.print(list.get(list.size-1) + " --> NULL" + '\n');

        list.remove(1);
        System.out.println("// Removed index 1");

        for (int i=0; i<list.size-1; i++) {
            System.out.print(list.get(i) + " --> ");
//            if (i<list.size-1) {
//                System.out.print(list.get(i) + " --> ");
//                i++;
//            }
        }
        System.out.print(list.get(list.size-1) + " --> NULL" + '\n');

        System.out.println("Get index 1: " + list.get(1));

        for (int i=0; i<list.size-1; i++) {
            System.out.print(list.get(i) + " --> ");

        }
        System.out.print(list.get(list.size-1) + " --> NULL" + '\n');

    }

     */

}
