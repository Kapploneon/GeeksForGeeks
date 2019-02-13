package com.Misc;

import java.util.LinkedList;
import java.util.ListIterator;

public class listTesting {
    public static void main(String[] arg){
        LinkedList<Integer> linkedList = new LinkedList<>();

        for(int i = 0; i < 10; i++){
            linkedList.add(i);
        }

        ListIterator<Integer> listIterator = linkedList.listIterator();

        System.out.print("Before remove list: ");
        printList(linkedList);
        System.out.println();
        if(listIterator.hasNext()){
            System.out.print("next: " + listIterator.next());
            System.out.println();
        }
        System.out.println("linkedList.size() before remove: "+linkedList.size());
        listIterator.remove();
        System.out.println("linkedList.size() after remove: "+linkedList.size());
        System.out.print("After remove list: ");
        printList(linkedList);
    }

    static <T> void printList(LinkedList<T> list){
        for(T element : list){
            System.out.print(element);
        }
    }
}
