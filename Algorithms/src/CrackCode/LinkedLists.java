/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackCode;

/**
 *
 * @author MohamedSayed
 */
import LinkedList.LinkedList;
import java.util.Random;

public class LinkedLists {

    public static <T> LinkedList<T> removeDublicateValues(LinkedList<T> linkedList) {
        if (linkedList == null) {
            return null;
        }

        LinkedList<T> newLinkedList = new LinkedList<>();
        newLinkedList.add((T) linkedList.getFirst().value);
        int length = linkedList.size();

        for (int i = 1; i < length - 1; i++) {
            if (newLinkedList.isValueFound((T) linkedList.get(i).value)) {
                continue;
            }
            newLinkedList.add((T) linkedList.get(i).value);
        }
        return newLinkedList;
    }

    public static <T> LinkedList<T> removeDublicateValues2(LinkedList<T> linkedList) {
        return linkedList.removeDublicateValues();

    }

    public static <T> boolean deleteMidle(LinkedList<T> linkedList) {
        return linkedList.deleteMiddleNode();
    }

    public static LinkedList<Integer> sumLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        return LinkedList.sumLists(list1, list2);
    }
public static <T> LinkedList<T> reorderList(LinkedList<T> reorderList)
{
    return  reorderList.reorderList();
}
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Random r = new Random(212);
        for (int i = 0; i < 25; i++) {
            list.add(r.nextInt(212));
        }
        System.out.println(list);
        
         System.out.println(list.reorderList1());
        
        
        
        System.out.println(list.reverse());
        
        list=new LinkedList();
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(3);
        list.add(6);
        list.add(5);
        list.add(2);
        
        System.out.println(list.isPalindrome());
        System.out.println(list.removeDublicateValues());
        System.out.println(list.deleteMiddleNode());
        System.out.println(list);

//        LinkedList list1=new LinkedList();
//        list1.add(7);
//        list1.add(1);
//        list1.add(6);
//        
//        LinkedList list2=new LinkedList();
//        list2.add(5);
//        list2.add(9);
//        list2.add(2);
//        
//        System.out.println(sumLists(list1, list2));
        
        
    }
}
