/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author MohamedSayed
 */
public class Stack<T> {
    int size;
    T top;
    T [] elements;
    public Stack(int size)
    {
        this.size=size;
//         Array.newInstance(elements.getClass().getComponentType(), size);
        elements=(T[])new Object[size];
    }
}
