package com.LinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class LoopLL{
    static Node head;
    static Node lhead;
    static Node rhead;
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner( new File("input/dummy"));
        int testcase = sc.nextInt();
        
        while( testcase-- > 0 ){

            // Get the size of the array
            int size = sc.nextInt();

            // Build the LinkedList
            if(size != 0){
                LoopLL llist = new LoopLL();
                int a1 = sc.nextInt();
                Node head = new Node(a1);
                lhead = head;
                rhead = head;
                llist.addToTheLast(head);
                for (int i = 1; i<size; i++) {
                    int a = sc.nextInt();
                    llist.addToTheLast(new Node(a));
                }
            }

            // Go the end of the LinkedList.
            Node tt = head;
            while(tt.next!=null)
                tt = tt.next;

            // Looping the LinkedList at the approritate position given by the parameter from input.
            int l = sc.nextInt();
            int p = l;
            if(size >= l){
                while( l > 1 ){
                    lhead = lhead.next;
                    l--;
                }
                //	System.out.println(lhead.data);
                tt.next = lhead;
            }

            // Test if the loop is present, if so remove the loop.
            removeTheLoopClass g = new removeTheLoopClass();
            int z = g.removeTheLoop(head);
            if(z == 1)
                System.out.println("1");
            else
                System.out.println("0");

            // Re-setting the head.
            head = null;
        }
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete The function
Node is as follows:
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/
class removeTheLoopClass{
    int removeTheLoop(Node node)
    {
        //add code here.
        Set<Integer> present = new HashSet<>();

        while(!present.contains(node.hashCode()) && node != null){
            present.add(node.hashCode());
            node = node.next;
        }

        if(node != null)
            return 1;
        return 0;
    }
}