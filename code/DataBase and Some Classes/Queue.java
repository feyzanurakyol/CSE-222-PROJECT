package com.Akif;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue<E> extends AbstractCollection<E> implements java.util.Queue<E> {
    private LinkedList<E> data;
    public Queue(){
        data = new LinkedList<> ();
    }
    @Override
    public int size () {
        return data.size ();
    }

    @Override
    public boolean isEmpty () {
        return data.size ()==0;
    }
    public boolean offer(E item){
        try {
            data.addLast (item);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public E remove(){
        if (data.size () == 0){
            throw new NoSuchElementException ();
        }
        return data.removeFirst ();
    }
    public E poll(){
        if (data.size () == 0){
            return null;
        }
        return data.removeFirst ();
    }
    public E peek(){
        if (data.size () == 0)
            return null;
        return data.getFirst ();
    }
    public E element(){
        if (data.size () == 0)
            throw new NoSuchElementException ();
        return data.getFirst ();
    }
    @Override
    public Iterator<E> iterator () {
        return data.iterator ();
    }

}
