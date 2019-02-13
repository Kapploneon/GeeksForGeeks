package com.Misc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Java 1.4+ Compatible
 * The following example code demonstrates converting an Array of Strings to a LinkedList of Strings
 */
public class Array2LinkedList {

    public static void main(String[] args) {

        // initialize array with some data
        String[] sa = new String[] { "A", "B", "C" };
        int[] s1 = new int[] {1, 2 ,3};

        // convert array to LinkedList
        LinkedList ll = new LinkedList(Arrays.asList(sa));
        LinkedList l2 = new LinkedList(Arrays.asList(s1));

        // iterate over each element in LinkedList and show what is in the list.
        Iterator iterator = ll.iterator();
        while (iterator.hasNext()) {
            // Print element to console
            System.out.println((String) iterator.next());
        }

        Iterator iterator2 = l2.listIterator();
        while (iterator2.hasNext()) {
            // Print element to console
            System.out.println( iterator2.next() );
        }
    }
}