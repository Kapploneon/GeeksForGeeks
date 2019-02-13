package com.stackAndQueue;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class waiter  {

    /*
     * Complete the waiter function below.
     */
    static int[] waiter(int[] number, int q) {
        /*
         * Write your code here.
         */
        int size = number.length;
        int[] result = new int[size];
        List<Integer> list = new ArrayList<>();
        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();


        for(int i = 0; i < size; i++){
            A.push(number[i]);
        }

        int i = 0;
        int p = 2;
        int j = 0;

        while(i++ < q){
            Stack<Integer> temp = new Stack<>();

            while(!A.isEmpty()){
                int ele = A.pop();
                if(ele % p == 0){
                    B.push(ele);
                }else{
                    temp.push(ele);
                }
            }

            while(!B.isEmpty()){
                result[j++] = B.pop();
            }

            A = (Stack<Integer>)temp.clone();

            p = Integer.parseInt(new BigInteger(String.valueOf(p)).nextProbablePrime().toString());
        }

        while(!A.isEmpty()){
            result[j++] = A.pop();
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[] number = new int[n];

        String[] numberItems = scanner.nextLine().split(" ");

        for (int numberItr = 0; numberItr < n; numberItr++) {
            int numberItem = Integer.parseInt(numberItems[numberItr].trim());
            number[numberItr] = numberItem;
        }

        int[] result = waiter(number, q);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.println(result[resultItr]);

            if (resultItr != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();
    }
}
