/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import LinkedList.LinkedList;

/**
 *
 * @author M_Aljazwiee
 * @param <T>
 */
public class Stack <T>{

    protected LinkedList list;
    transient protected int size = 0;
    transient protected int top = 0;

    public Stack() {
        list = new LinkedList();
    }

    public Stack(int size) {
        list = new LinkedList();
        this.size = size;
    }

    public boolean isEmpty() {
        return size() ==0;
    }

    public int push(T value) {
        if (isEmpty()) {
            list.add(value);
            top++;

        } else {
            //  checkElementIndex(top);
            list.add(value);
            top++;

        }
        return top;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("index " + index + " , Size " + size());
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size();
    }

    public T pop() {
        //checkElementIndex(top);
        top--;
        return (T) list.removLast().getValue();
    }

    public T get() {
        return (T) list.getLast().getValue();
    }

    public void print() {
        list.print();
    }

    public int size() {
        return top;
    }

    @Override
    public String toString() {

        return list.toString();
    }

}
