package com.LinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Get_Min_From_Stack
{
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner( new File("input/dummy"));
        int T = sc.nextInt();
        while(T>0)
        {
            int q = sc.nextInt();
            minEleClass g = new minEleClass();
            while(q>0)
            {
                int qt = sc.nextInt();

                if(qt == 1)
                {
                    int att = sc.nextInt();
                    g.push(att);
                    //System.out.println(att);
                }
                else if(qt == 2)
                {
                    System.out.print(g.pop()+" ");
                }
                else if(qt == 3)
                {
                    System.out.print(g.getMin()+" ");
                }

                q--;
            }
            System.out.println();
            T--;
        }

    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

class minEleClass
{
    int minEle = -1;
    Stack<Integer> s = new Stack<>();
    /*returns min element from stack*/
    int getMin()
    {
        // Your code here
        return minEle;
    }

    /*returns poped element from stack*/
    int pop()
    {
        // Your code here
        if(s.isEmpty()){
            minEle = -1;
            return -1;
        }else{
            int x = s.pop();
            if(s.isEmpty()){
                minEle = -1;
            }
            if( x == minEle && !s.isEmpty()){
                minEle = s.pop();
                if(s.isEmpty()){
                    minEle = -1;
                }
            }
            return x;
        }

    }
    /*push element x into the stack*/
    void push(int x)
    {
        // Your code here
        if(minEle == -1){
            minEle = x;
        }
        if(minEle >= x){
            s.push(minEle);
            minEle = x;
        }
        s.push(x);
    }
}