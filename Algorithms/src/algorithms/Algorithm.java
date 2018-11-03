/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import Stack.*;
import Tree.Search;
import Tree.Tree;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;
import jdk.nashorn.internal.ir.BinaryNode;

/**
 *
 * @author M.Aljazwiee
 */
public class Algorithm {

    /**
     * @param args the command line arguments
     */
    int cal(int[]a)
    {
        getMiniimumSUM(a);
        int sum=0;
        for(int i=0;i<a.length;i++)
            sum+=a[i];
        return sum;
    }
    private void getMiniimumSUM(int[] A)
    {
        if(isunique(A))
            return;
        for(int i=0;i<A.length;i++)
        {
            for(int j=i+1;j<A.length;j++)
            {
                if(A[j]==A[i])
                    A[j]++;
                else
                    break;
            }
        }
        getMiniimumSUM(A);
        for(int i=0;i<A.length;i++)
        System.out.print(A[i]+" ");
    }
    boolean isunique(int[]A)
    {
        Arrays.sort(A);
          for(int i=0;i<A.length;i++)
        {
            for(int j=i+1;j<A.length;j++)
            {
                  if(A[j]==A[i])
                return false;
            
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
 
//        Stack stack=new Stack();
//        stack.push("sdsd");
//        stack.push(223);
//        stack.push(2543);
//        stack.push('d');
//           stack.push(2543);
//        stack.push(565);
//        System.err.println(stack);
//        stack.pop();
//        stack.pop();
//           System.err.println(stack);
//             stack.pop();
//        stack.pop();
//           System.err.println(stack);
//             stack.pop();
//        stack.pop();
//           System.err.println(stack);
//           String s="13 +20 *((5+2)*3)-2 ";
//        LinkedList list;
//      
//       InfixPostfixExpresstion expresstion=new InfixPostfixExpresstion();
//         System.out.println( expresstion.convertToPostFix(s));
//          
//         System.out.println("algorithms is  "+s.toCharArray());
//
//        Tree<Integer> tree = new Tree<>();
//        tree.insert(15);
//        tree.insert(10);
//        tree.insert(7);
//        tree.insert(12);
//        tree.insert(20);
//
//        tree.insert(19);
//        tree.insert(25);
//        tree.insert(11);
//        tree.insert(6);
//        tree.insert(13);
//
//        System.out.println("Least Value is " + tree.least());
//        System.out.println("Higth Value is " + tree.higth());
//        System.out.println(" Value is " + tree.search(16));
//        tree.display();
//
//        System.out.println("\n Size  " + tree.getSize());
//        System.out.println("First Value is " + tree.first());
//        System.out.println("Last Value is " + tree.last());
//
//        char d = 'm';
//        char s = 'd';
        //   System.out.println("Your Count "+res(s, d46
        //int a[]={-1, 5, 6, 18, 19, 25, 46, 78, 102, 114};
        int a[]={2,2,4,5,3,4,2};
               System.out.println(new Algorithm().cal(a));
       // System.out.println("The index is "+  Search.search( a,19));
    }

    public static int res(char s, char d) {
        int k = 0;
        while (k < 10) {
            if (s != d) {
                return s - d;
            }
            k++;
        }
        return 0;
    }
}
