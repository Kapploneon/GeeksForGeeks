package com.LinkedList;

// Java program to detect loop in a linked list
import java.io.*;
import java.util.*;

class LinkedList
{
    Node head;  // head of list
    /* Linked list Node*/
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node & Put in the data*/
        Node new_node = new Node(new_data);
        /* 3. Make next of new Node as head */
        new_node.next = head;
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
    /* Drier program to test above functions */
    public static void main(String args[]) throws IOException {
        int t,d,n,i,x,c;

        BufferedReader sc = null;
        try {
            sc = new BufferedReader(new InputStreamReader( new FileInputStream("input/dummy")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        t = Integer.parseInt(sc.readLine());

        for(d=0;d<t;d++){

            n = Integer.parseInt(sc.readLine());
            int[] a1 = new int[n];
            a1 = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//            LinkedList llist = new LinkedList(Arrays.asList(a1));
//            Node q;
//            for(i=0;i<n;i++){
//                x=sc.nextInt();
//                llist.push(x);}
//            Node p;
//            p=llist.head;
//            q=llist.head;
//            while(q.next!=null)
//                q=q.next;
//            c=sc.nextInt();
//            if(c>0){
//                c=c-1;
//                for(i=0;i<c;i++){
//                    p = p.next;}
//                q.next=p;
//            }
//            if(new loopDetection().detectLoop(llist.head)==1)
//                System.out.print("True");
//            else
//                System.out.print("False");
//                        System.gc();
        }
    }
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/* Node is defined as
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/
class loopDetection
{
    int detectLoop(Node head)
    {
        // Add code here
        Node slow_p = head, fast_p = head;
        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                System.out.println("Found loop");
                return 1;
            }
        }
        return 0;
    }

    int detectLoop1(Node head){
        Set<Integer> present = new HashSet<>();

        while(!present.contains(head.hashCode()) || present != null){
            present.add(head.hashCode());
            head = head.next;
        }

        if(present == null){
            return 0;
        }else{
            return 1;
        }
    }

}