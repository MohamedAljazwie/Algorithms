/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import LinkedList.LinkedList;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author M.Aljazwiee
 */
public class Sort {

    private static int iCounter = 0;
    private static int jCounter = 0;
    private static int totalIterate = 0;

    public static <T> T[] selectionSort(T[] list) {
        iCounter = 0;
        jCounter = 0;
        totalIterate = 0;
        T minimum;
        for (int i = 0; i < list.length; i++) {
            minimum = list[i];
            for (int j = i + 1; j < list.length; j++) {
                if (comareTo(minimum, list[j]) > 0) {
                    minimum = list[j];
                    list[j] = list[i];
                    list[i] = minimum;
                }
                jCounter++;
                totalIterate++;
            }
            iCounter++;
            totalIterate++;
        }
        return list;
    }

    public static <T> T[] bubbleSort(T[] list) {
        iCounter = 0;
        jCounter = 0;
        totalIterate = 0;
        T minimum;
        for (int i = 0; i < list.length; i++) {
            boolean isSorted = true;
            iCounter++;
            totalIterate++;
            for (int j = list.length - 1; j > i; j--) {
                if (comareTo(list[j], list[j - 1]) < 0) {
                    minimum = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = minimum;
                    isSorted = false;
                }
                jCounter++;
                totalIterate++;
            }
            if (isSorted) {
                break;
            }
        }
        return list;
    }

    public static <T> T[] insertionSort(T[] list) {
        T[] sortList = (T[]) Array.newInstance(list.getClass().getComponentType(), list.length);
        sortList[0] = list[0];
        return insertionSort(sortList, list, 0, 1);
    }

    private static <T> T[] insertionSort(T[] sortList, T[] unSortList, int indexSortList, int indexUnSortList) {
        if (indexUnSortList == sortList.length) {
            return sortList;
        }
        T temp = unSortList[indexUnSortList];
        for (int j = 0; j <= indexSortList; j++) {
            if (comareTo(temp, sortList[j]) <= 0) {
                int i = j;
                int z = j;
                T[] newList = (T[]) Array.newInstance(sortList.getClass().getComponentType(), indexSortList - j + 1);
                for (int k = 0; k <= indexSortList - j; k++) {
                    newList[k] = sortList[z];
                    z++;
                }
                sortList[i] = temp;
                i++;
                for (int k = 0; k <= indexSortList - j; k++) {
                    sortList[i] = newList[k];
                    i++;
                }
                indexSortList++;
                break;
            } else if (j == indexSortList) {
                sortList[indexSortList + 1] = temp;
                indexSortList++;
                break;
            }
        }
        int newindexSortList = indexSortList;
        int newindexUnSortList = indexUnSortList + 1;
        return insertionSort(sortList, unSortList, newindexSortList, newindexUnSortList);
    }

    public static <T> T[] mergSort(T[] list) {
        if (list.length == 1) {
            return list;
        }
        int listLength = list.length / 2;
        T[] list1 = (T[]) Array.newInstance(list.getClass().getComponentType(), listLength);
        T[] list2 = (T[]) Array.newInstance(list.getClass().getComponentType(), list.length - listLength);
        int i = 0;
        for (; i < listLength; i++) {
            list1[i] = list[i];
        }
        for (int j = listLength; j < list.length; j++) {
            list2[j - i] = list[j];
        }
        list1 = mergSort(list1);
        list2 = mergSort(list2);
        return mergSortOrder(list1, list2);

    }

    private static <T> T[] mergSortOrder(T[] list1, T[] list2) {
        T[] list3 = (T[]) Array.newInstance(list1.getClass().getComponentType(), list1.length + list2.length);
        int indexList3 = 0;
        int indexList1 = 0;
        int indexList2 = 0;
        while (indexList3 < list3.length) {
            if (indexList1 == list1.length) {
                while (indexList2 < list2.length) {
                    list3[indexList3] = list2[indexList2];
                    indexList2++;
                    indexList3++;
                }
                break;
            } else if (indexList2 == list2.length) {
                while (indexList1 < list1.length) {
                    list3[indexList3] = list1[indexList1];
                    indexList1++;
                    indexList3++;
                }
                break;
            } else {
                int comp = comareTo(list1[indexList1], list2[indexList2]);
                switch (comp) {
                    case 1: {
                        list3[indexList3] = list2[indexList2];
                        indexList2++;
                        indexList3++;
                    }
                    break;
                    case -1: {
                        list3[indexList3] = list1[indexList1];
                        indexList1++;
                        indexList3++;
                    }
                    break;
                    case 0: {
                        list3[indexList3] = list1[indexList1];
                        indexList1++;
                        indexList3++;
                        list3[indexList3] = list2[indexList2];
                        indexList2++;
                        indexList3++;
                    }
                    break;
                }
            }
        }
        return list3;
    }
public static <T>T[] quickSort(T[]list)
{
    iCounter=0;
    jCounter=0;
    if(list.length==0)
        return list;
    
    return quickSort(list, 0, list.length-1);
}
private static <T>T[]quickSort(T[]list,int low,int higth)
{
    if(low>=higth)
        return list;
    int i=low,j=higth;
    T pivot=list[i];
    while(true)
    {
        iCounter++;
        totalIterate++;
        if(i==j)
            break;
        int compare=comareTo(list[i],list[j]);
        switch(compare)
        {  case 0:
                j--;
                totalIterate++;
                break;
                case -1:
                {
                    if(pivot==list[i])
                      j--;
                    else
                        i++;
                    totalIterate++;
                  
                }
                break;
                case 1:
                {
                    T temp=list[i];
                    list[i]=list[j];
                    list[j]=temp;
                   if(pivot==list[i])
                       j--;
                   
                    else
                       i++;
                    totalIterate++;
                }
                break;
        }
    }
    
    quickSort(list, low, i-1);

    quickSort(list, j+1, higth);
    
    return list;
}

    private static <T> int comareTo(T value1, T value2) {
        return Adapter.adapter.compare(value1, value2);
    }

    private static <T> T[] insertionSort1(T[] list) {
        int indexUnsorted = 1;
        while (indexUnsorted < list.length) {
            T hold = list[indexUnsorted];
            int i = indexUnsorted - 1;
            while (i >= 0 && comareTo(hold, list[i]) < 0) {
                list[i + 1] = list[i];
                i--;
            }
            list[i + 1] = hold;
            indexUnsorted++;
        }
        return list;
    }

    static final class Adapter implements Comparator<Object> {

        @SuppressWarnings("unchecked")
        @Override
        public int compare(Object first, Object second) {
            return ((Comparable<Object>) first).compareTo(second);
        }
        static final Adapter adapter = new Adapter();
    }

    public static void main(String[] args) {
            Integer [] list=
        {21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32
        ,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,21,3,4,5656,76,343,65,32,34,343,21,3,4,5656,76,343,65,32,21,3,4,5656,876,76,343,65,32,21,3,4,5656,76,343,65,32};
        System.out.println("The  List  Length is " + list.length);
     
//        System.out.println("The  SelectionList is " + Arrays.toString(selectionSort(list)));
//  System.out.println("Selection  ICOUNTER IS " + iCounter + "    AND Selection jcounter is  " + jCounter + "  and totalIrterarte is  " + totalIterate);
//
//     System.out.println("QuickSort lIST IS  " + Arrays.toString(quickSort(list)));
//           System.out.println("Quick  ICOUNTER IS " + iCounter + "    AND Selection jcounter is  " + jCounter + "  and totalIrterarte is  " + totalIterate);
////   
//
//        System.out.println("The Bubble List Is " + Arrays.toString(bubbleSort(list)));
//        System.out.println("Bubble  ICOUNTER IS " + iCounter + "    AND jcounter is  " + jCounter + "  and totalIrterarte is  " + totalIterate);
//      
        System.out.println("The MergList is " + Arrays.toString(mergSort(list)));
        System.out.println("Merg  ICOUNTER IS " + iCounter + "    AND Selection jcounter is  " + jCounter + "  and totalIrterarte is  " + totalIterate);
//        Integer[] listBubble
//                = {21, 3, 4, 5656, 76, 343, 65, 32, 21, 3, 4, 5656, 76, 343, 65, 32};
//        System.out.println("QuickSort lIST IS  " + Arrays.toString(quickSort(listBubble)));
//           System.out.println("Quick  ICOUNTER IS " + iCounter + "    AND Selection jcounter is  " + jCounter + "  and totalIrterarte is  " + totalIterate);
////   
//System.out.println("QuickSort lIST IS  " + Arrays.toString(quickSort(listBubble)));
//           System.out.println("Quick  ICOUNTER IS " + iCounter + "    AND Selection jcounter is  " + jCounter + "  and totalIrterarte is  " + totalIterate);
//   
        
    }
}
