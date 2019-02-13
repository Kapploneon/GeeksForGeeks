package com.LinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
class NodeIntersect
{
    int data;
    NodeIntersect next;
    NodeIntersect(int d) {data = d; next = null; }
}

class LinkedList_Intersection
{
    NodeIntersect head;
    NodeIntersect tail;
    public void addToTheLast(NodeIntersect NodeIntersect)
    {
        if (head == null) {
            head = NodeIntersect;
            tail = head;
        } else {
            //NodeIntersect temp = head;
            //while (temp.next != null)
            //temp = temp.next;
            //temp.next = NodeIntersect;
            tail.next=NodeIntersect;
            tail = NodeIntersect;
        }
    }
    /* Function to print linked list */
    void printList()
    {
        NodeIntersect temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }



    /* Driver program to test above functions */
    public static void main(String args[]) throws FileNotFoundException {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(new File("input/dummy"));
        int t=sc.nextInt();

        while(t>0)
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            LinkedList_Intersection llist1 = new LinkedList_Intersection();
            LinkedList_Intersection llist2 = new LinkedList_Intersection();
            LinkedList_Intersection llist3 = new LinkedList_Intersection();

            int a1=sc.nextInt();
            NodeIntersect head1= new NodeIntersect(a1);
            NodeIntersect tail1= head1;
            llist1.addToTheLast(head1);
            for (int i = 1; i < n1; i++)
            {
                int a = sc.nextInt();
                llist1.addToTheLast(new NodeIntersect(a));
            }


            int b1=sc.nextInt();
            NodeIntersect head2 = new NodeIntersect(b1);
            NodeIntersect tail2 = head2;
            llist2.addToTheLast(head2);
            for (int i = 1; i < n2; i++)
            {
                int b = sc.nextInt();
                llist2.addToTheLast(new NodeIntersect(b));
            }

            int c1=sc.nextInt();
            NodeIntersect head3= new NodeIntersect(c1);
            NodeIntersect tail3=head3;
            llist3.addToTheLast(head3);
            for (int i = 1; i < n3; i++)
            {
                int c = sc.nextInt();
                llist3.addToTheLast(new NodeIntersect(c));
            }

            if (tail1 != null)
                tail1.next = head3;
            if (tail2 != null)
                tail2.next = head3;

            //llist1.head= new intersectPointClass().Intersection(llist1.head,llist2.head);
            //llist1.printList();		
            //System.out.println();

            intersectPointClass obj = new intersectPointClass();
            System.out.println(obj.intersectPoint(llist1.head, llist2.head));
            t--;
        }




    }
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/* NodeIntersect of a linked list
 class NodeIntersect {
   int data;
    NodeIntersect next;
    NodeIntersect(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    NodeIntersect head;  // head of list
}
This is method only submission.  You only need to complete the method. */
class intersectPointClass
{
    int intersectPoint(NodeIntersect headA, NodeIntersect headB)
    {
        // code here
        //add code here.
        Set<Integer> present = new HashSet<>();

        while(headA != null && !present.contains(headA.hashCode())){
            present.add(headA.hashCode());
            headA = headA.next;
        }

        while(headB != null && !present.contains(headB.hashCode()) ){
            present.add(headB.hashCode());
            headB = headB.next;
        }

        if(headB != null)
            return headB.data;
        return -1;
    }
}