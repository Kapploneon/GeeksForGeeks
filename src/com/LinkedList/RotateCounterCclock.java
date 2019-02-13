package com.LinkedList;

import java.io.*;
import java.util.*;

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

class Main{
    static Node head;
    public static void main(String[] args) throws IOException {

        BufferedReader sc = null;
        try {
            sc = new BufferedReader(new InputStreamReader( new FileInputStream("input/dummy")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int t = Integer.parseInt(sc.readLine());

        while(t-->0){
            int n = Integer.parseInt(sc.readLine());
            int[] a1 = new int[n];
            a1 = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            head = null;
            Node head = new Node(a1[0]);
            addToTheLast(head);
            for (int i=1;i<n;i++) {
                addToTheLast(new Node(a1[i]));
            }

            int k = Integer.parseInt(sc.readLine());
            GfG g = new GfG();

//            g.rotate(head,k);
            Node rotatedGroup = g.rotateGroup(head,k);

            while(rotatedGroup != null){
                System.out.print(rotatedGroup.data + " ");
                rotatedGroup = rotatedGroup.next;
            }
        }
    }

    public static void addToTheLast(Node node) {
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
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}
*/
class GfG
{
    public void rotate(Node head,int k)
    {
        Node curr = head;

        //add code here.
        while(k > 1){
            curr = curr.next;
            k--;
        }

        if(curr.next == null){
            while(head != null){
                System.out.print(head.data + " ");
                head = head.next;
            }
        }
        else{

            Node newHead = curr.next;
            curr.next = null;
            Node newcurr = newHead;


            while(newcurr.next != null){
                newcurr = newcurr.next;
            }

            newcurr.next = head;

            while(newHead != null){
                System.out.print(newHead.data + " ");
                newHead = newHead.next;
            }

        }
    }

    public Node rotateGroup(Node head,int k){

        Node prev = null;
        Node curr = head;
        Node next = null;
        int count = 0;

        while(count < k && curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
            count++;
        }

        if(next != null)
            head.next = rotateGroup(next, k);

        return prev;
    }
}
