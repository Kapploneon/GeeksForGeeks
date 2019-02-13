package com.stackAndQueue;

import java.io.*;
import java.util.*;

public class QueueUsing2Stack {

    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(new FileInputStream(new File("input/dummy")));

        int testcases = input.nextInt();
        Stack<Integer> firstS = new Stack<>();
        Stack<Integer> secondS = new Stack<>();

        while(testcases-- > 0){
            int what = input.nextInt();

            switch(what){
                case 1:
                    firstS.push(input.nextInt());
                    break;
                case 2:
                    if(!secondS.isEmpty()){
                        secondS.pop();
                    }else{
                        while(!firstS.isEmpty()){
                            secondS.push(firstS.pop());
                        }
                        secondS.pop();
                    }
                    break;
                case 3:
                    if(!secondS.isEmpty()){
                        // System.out.println(secondS.peek());
                    }else{
                        while(!firstS.isEmpty()){
                            secondS.push(firstS.pop());
                        }
                    }
                    System.out.println(secondS.peek());
                    break;
            }
        }
    }
}
