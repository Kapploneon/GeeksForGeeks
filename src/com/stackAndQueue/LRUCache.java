package com.stackAndQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
class LRU_Cache
{
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input/dummy"));
        int t = sc.nextInt();
        while(t>0)
        {
            Set<Integer> s = new HashSet<Integer>() ;
            int n = sc.nextInt();
            LRUCache g = new LRUCache(n);
            int q = sc.nextInt();

            while(q>0)
            {

                String c = sc.next();
                //	System.out.println(c);
                if(c.equals("GET"))
                {
                    int x = sc.nextInt();
                    System.out.print(g.get(x)+" ");
                }
                if(c.equals("SET"))
                {
                    int x = sc.nextInt();
                    int y  = sc.nextInt();
                    g.set(x,y);
                }

                q--;
                //System.out.println();
            }
            t--;
            System.out.println();
        }
    }
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*You are required to complete below class */
class LRUCache {

    int LRUsize;
    Map<Integer, Integer> map = new HashMap<>();
    doublyNode que = new doublyNode();
    doublyNode rear = que;
    doublyNode front = que;

    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
        //Your code here
        LRUsize = N;
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {
        //Your code here
        if(map.containsKey(x)) {
            moveToFront(x);
            return map.get(x);
        }else{
            return -1;
        }
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        //Your code here
        if(!map.containsKey(x)){
            if(LRUsize > 0){
                // There is room in the cache so just add new value.
                // Add the new node to the front of the queue.
                map.put(x, y);
                LRUsize--;
                if(front.data == 0){
                    front.data = x;
                }else{
                    doublyNode temp = new doublyNode();
                    temp.data = x;
                    temp.next = front;
                    front.previous = temp;
                    temp.previous = null;
                    front = temp;

                    // Updating rear pointer.
                    while(temp.next != null){
                        temp = temp.next;
                    }
                    rear = temp;
                }
            }else {
                // Replacement.
                // remove the rear node awa from the map.
                map.remove(rear.data);

                rear.previous.next = null;
                doublyNode detach = rear;
                rear = rear.previous;
                detach.previous = null;

                // add new to the front with key x.
                doublyNode temp = new doublyNode();
                temp.data = x;
                temp.next = front;
                front.previous = temp;
                front = temp;
                map.put(x, y);
            }
        }else{
            // The key k already present in the cache.
            // Update the y value in map.
            map.put(x,y);
            // Move it to the front of the queue.
            moveToFront(x);
        }
    }

    public void moveToFront(int x){
        if(front.data == x){
            return;
        }
        doublyNode temp = front;
        while(temp.data != x){
            temp = temp.next;
        }

        // If temp is last node.
        if(temp.next == null){
            temp.next = front;
            temp.previous.next = null;
            rear = temp.previous;
            temp.previous = null;
            front.previous = temp;
            front = temp;
            return;
        }

        // Moving the temp to front.
        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;
        temp.next = front;
        temp.previous = null;
        front.previous = temp;
        front = temp;
    }
}

class doublyNode{
    int data;
    doublyNode next;
    doublyNode previous;
}