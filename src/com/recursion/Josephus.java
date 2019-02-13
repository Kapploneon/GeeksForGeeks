package com.recursion;

/*
Given the total number of persons n and a number k which indicates that k-1 persons
are skipped and kth person is killed in circle in a fixed direction.​
The task is to choose the safe place in the circle so that when you perform
these operations starting from 1st place in the circle, you are the last one
remaining and survive. You are required to complete the function josephus which
returns an integer denoting such position .

Input:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains 2 integers n and k .

Output:
For each test case in a new line output will be the safe position which satisfies the above condition.

Constraints:
1<=T<=100
1<=k,n<=20

Example(To be used only for expected output) :
Input:
2
3 2
5 3

Output
3
4
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Josephus {
    public static void main(String[] arg){
        //code
        // Read file.
        Scanner input = null;
        try {
            input = new Scanner(new File("input/dummy"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int testCases = input.nextInt();

        // starting time
        long start = System.currentTimeMillis();

        // start of function

        for(int i = 0; i < testCases; i++) {
            int cSize = input.nextInt();
            int nextToDie = input.nextInt();

//            int survive = circleOfDeath(cSize, nextToDie);    // 7-10 ms for 80 testcases
            int survive = josephus(cSize, nextToDie);       // 6-7 ms for 80 testcases

            System.out.println(survive);
        }

        // end of function

        // ending time
        long end = System.currentTimeMillis();
        System.out.println("Time takes " +
                (end - start) + "ms");

    }

    static int circleOfDeath(int n, int k){

        LinkedList<Integer> circle = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            circle.add(i);
        }

        int dummyDie = k;

        while(circle.size() != 1){

            ListIterator<Integer> linkedListIterator = circle.listIterator();

            do{
                if( linkedListIterator.hasNext() ){
                    linkedListIterator.next();
                }

                dummyDie--;
                if(dummyDie == 0){
                    linkedListIterator.remove();
                    dummyDie = k;
                }
            }while(linkedListIterator.hasNext() && circle.size() != 1);

        }

        return circle.getFirst();
    }

    static int josephus(int n, int k)
    {
        if (n == 0)
            return 1;
        else
            /* The position returned by josephus(n - 1, k)
            is adjusted because the recursive call
            josephus(n - 1, k) considers the original
            position k%n + 1 as position 1 */
            return (josephus(n - 1, k) + k-1) % n + 1;
//            return (josephus(n - 1, k) + k) % n;      // Seems like this gives incorrect result.

    }
}

/*
For Input:
    10
    8 2
    17 16
    3 2
    5 3
    10 11
    5 15
    19 20
    13 16
    17 15
    5 6

Output of Online Judge is:
    1
    10
    3
    4
    7
    1
    2
    8
    1
    4
*/