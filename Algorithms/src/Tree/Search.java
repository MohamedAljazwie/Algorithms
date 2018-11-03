/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author M_Aljazwiee
 * @param <T>
 */
public class Search {

    public Search() {
        
    }

    public static <T> int search(T[] list, T value) {
        if (!found(list, value)) {
            return -1;
        }

        return binarySearch(list, 0, list.length, value);
    }

    private static <T> int binarySearch(T[] list, int first, int last, T value) {
        int middle = (last - first) / 2 + first;
        if (comareTo(list[middle], value) == 0) {
            return middle;
        } else if (first >= last) {
            return -1;
        } else {
            int i = comareTo(list[middle], value);
            switch (i) {
                case -1:
                    first = middle + 1;
                    return binarySearch(list, first, last, value);
                case 1:
                    last = middle - 1;
                    return binarySearch(list, first, last, value);
            }
        }
        return -1;
    }

    private static <T> int comareTo(T value1, T value2) {
        return Adapter.adapter.compare(value1, value2);
    }

    private static <T> boolean found(T[] list, T value) {
        return ((list.length != 0 && comareTo(list[0], value) <= 0 && comareTo(value, list[list.length - 1]) <= 0));
    }

    static final class Adapter implements Comparator<Object> {

        @SuppressWarnings("unchecked")
        @Override
        public int compare(Object first, Object second) {
            return ((Comparable<Object>) first).compareTo(second);
        }
        static final Adapter adapter = new Adapter();
    }

}
