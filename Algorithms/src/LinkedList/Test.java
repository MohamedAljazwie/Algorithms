/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author M.Aljazwiee
 */
public class Test {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
//        System.out.println("Your Started Time  is  "  + new Date());
//        for (int i = 0; i < 100000; i++) {
//            list.add(i);
//         }
//         System.out.println("Your End  Time  is  "  +  new Date());
//          System.out.println("Your Started Remove  Time  is  "  +  new Date());
//               list.remove(3000);
//             System.out.println("Your End  Remove  Time  is  "  +  new Date());

        list.addFirst(11);
        list.print();
        list.addLast(13);
        list.print();
        list.add(154, 1);
        list.print();
        list.add(14, 1);
        list.print();
         list.addFirst(11);
        list.print();
        list.addLast(13455);
        list.print();
        list.add(154, 1);
        list.print();
        list.add(14, 1);
        list.print();
        System.err.println(list.isValueFound(1545));
        
        
         list.addFirst(11);
        list.print();
        list.addLast(1763);
        list.print();
        list.add(154, 1);
        list.print();
        list.add(14, 1);
        list.print();
         list.addFirst(11);
        list.print();
        list.addLast(13765);
        list.print();
        list.add(154, 1);
        list.print();
        list.add(14, 1);
         list.add(14, 16);
        list.print();
        System.out.println("LinkedList First Node is " + list.getFirst().value);
        System.out.println("LinkedList Last Node is " + list.getLast().value);
        System.out.println("LinkedList Index Node is " + list.get(2).value);
        list.remove();
        list.print();
        list.removLast();
        list.print();
        list.remove(1);
        list.print();
        //  java.util.LinkedList list1 = new java.util.LinkedList();
    }
}

class test2 {

    public static void main(String[] args) {
        java.util.LinkedList list = new java.util.LinkedList();
        System.out.println("Your LinkedList Started Time  is  " + new Date());
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        System.out.println("Your LinkedList End  Time  is  " + new Date());
        System.out.println("Your LinkedList Started Remove  Time  is  " + new Date());
        list.remove(300000);
        System.out.println("Your LinkedList End  Remove  Time  is  " + new Date());

        System.out.println("Your LinkedList Started Get  Time  is  " + new Date());
        System.out.println("Your Value is  " + list.get(295596));
        System.out.println("Your LinkedList Started Get  Time  is  " + new Date());
    }
}
