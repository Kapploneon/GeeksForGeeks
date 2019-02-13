package com.Arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class newYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int size = q.length;
        boolean flag = false;
        int ans = 0;
        int i;
//        for(i = 0; (i+2) < size; i++){
//            if(q[i] - (i+1) > 2){
//                System.out.println("Too chaotic");
//                flag = true;
//                return;
//            }
//            if(q[i] > q[i+1]){
//                ans++;
//            }
//            if(q[i] > q[i+2]){
//                ans++;
//            }
//        }
//        if(q[i] > q[i+1]){
//            ans++;
//        }
//        System.out.println(ans);
         for( i = size - 1; i >= 0; i--){

             if(q[i]-(i+1) > 2){
                 System.out.println("Too chaotic");
                 flag = true;
                 break;
             }
             for( int j = Math.max(0, q[i] - 2); j < i; j++){
                 if(q[j] > q[i])
                     ans++;
             }

         }
         if(!flag)
             System.out.println(ans);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
