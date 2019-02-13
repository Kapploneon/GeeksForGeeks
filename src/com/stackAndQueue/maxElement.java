package com.stackAndQueue;

import java.io.*;
import java.util.*;

public class maxElement {

    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(new FileInputStream(new File("input/dummy")));

        int testcases = input.nextInt();
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;

        while(testcases-- > 0){
            int what = input.nextInt();

            switch(what){
                case 1:
                    int with = input.nextInt();
                    if(max <= with){
                        // push old max
                        stack.push(max);
                        // new max
                        max = with;
                    }
                    stack.push(with);
                    break;
                case 2:
                    int poped = stack.pop();
                    // if old max poped out
                    if(max == poped){
                        // new max
                        max = stack.pop();
                    }
                    break;
                case 3:
                    System.out.println(max);
                    break;
            }
        }
    }
}
