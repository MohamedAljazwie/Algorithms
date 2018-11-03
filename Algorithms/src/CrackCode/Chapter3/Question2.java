/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackCode.Chapter3;

import LinkedList.LinkedList;
import Stack.Stack;
import java.util.Random;

/**
 *
 * @author MohamedSayed
 */
public class Question2 {
 public static void main(String[] args) {
        StackMin stackMin=new StackMin();
        
        Random r = new Random(212);
        for (int i = 0; i < 10; i++) {
            stackMin.push(r.nextInt(50));
        }
         for (int i = 10; i >0; i--) {
             
           System.out.println("Min Befor Pop "+stackMin.min());
              System.out.println(" Pop ==> "+stackMin.pop());
        
          System.out.println("Min After  Pop  "+stackMin.min());
         }
    }
}

class StackMin<T> extends Stack<T> {

    T minValue;

    @Override
    public int push(T value) {
        LinkedList.Node node = new LinkedList.Node< T>(value, null);
        if (isEmpty()) {
            minValue = value;

        } else {
            Integer min = Math.min((Integer) minValue, (Integer) value);
            minValue = (T) min;
        }
        node.setMin(minValue);
        list.add(node);
        top++;
        return top;
    }

    @Override
    public T pop() {
        LinkedList.Node node= (LinkedList.Node) super.pop(); //To change body of generated methods, choose Tools | Templates.
        return (T) node.value;
    }
    public T min()
    {
       LinkedList.Node node= (LinkedList.Node) super.get();
          return (T) node.min;
    }
   
}
