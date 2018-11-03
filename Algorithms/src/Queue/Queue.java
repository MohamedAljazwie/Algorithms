/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import LinkedList.LinkedList;

/**
 *
 * @author MohamedSayed
 */
public class Queue<T> {
    LinkedList<T> queue=new LinkedList<>();
   public void inqueue( T value)
   {
       queue.addLast(value);
   }
   public T deQueue()
   {
       return  (T) queue.removeFirst().value;
   }
}
