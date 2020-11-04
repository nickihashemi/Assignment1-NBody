package com.company;

/**
 * Creates a List Interface
 * @param <E>
 */
public interface List<E> {

    // Size of the List
    public int size();


    // Adds to the end of the List
    public boolean add(E item);


    // Adds to the List at a position
    public void add(int pos, E item);


    // Gets a value at an index in the List
    public E get(int pos);


    // Removes a value at an index in the List
    public E remove (int pos);

}
