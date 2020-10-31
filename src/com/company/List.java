package com.company;

public interface List<E> {

    public int size();

    public boolean add(E item);

    public void add(int pos, E item);

    public E get(int pos);

    public E remove (int pos);

}
