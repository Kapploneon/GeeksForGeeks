package com.LinkedList;

import java.io.*;
import java.util.*;

class NodeDD{
    int data;
    NodeDD next;
    NodeDD(int d){
        data=d;
        next=null;
    }
}

class Solution
{

    public static NodeDD removeDuplicates(NodeDD head) {
        if (head == null || head.next == null){
            return head;
        }
        if (head.data == head.next.data){
            head.next = head.next.next;
            removeDuplicates(head);
        }else{
            removeDuplicates(head.next);
        }
        return head;
    }


//    private static NodeDD removeDuplicates(NodeDD head) {
//
//    //Write your code here
//    if(head == null){
//        return head;
//    }
//
//    NodeDD curr = head;
//
//    while(curr != null && curr.next != null){
//        NodeDD prev = curr;
//        NodeDD next = curr.next;
//
//        int cd = curr.data;
//
//        while(next != null){
//            if(cd == next.data){
//                if(next.next != null){
//                    prev.next = next.next;
//                    next = next.next;
//
//                }else{
//                    prev.next = null;
//                    next = null;
//                }
//            }else{
//                next = next.next;
//                prev = prev.next;
//            }
//        }
//        curr = curr.next;
////        cd = curr.data;
//    }
//
//    return head;
//
//}

    private static  NodeDD insert(NodeDD head,int data)
    {
        NodeDD p=new NodeDD(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            NodeDD start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }

    private static void display(NodeDD head)
    {
        NodeDD start=head;
        while(start!=null)
        {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner( new File("input/dummy"));
        NodeDD head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=insert(head,ele);
        }
        head=removeDuplicates(head);
        display(head);

    }
}