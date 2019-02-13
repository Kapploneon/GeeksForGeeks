package com.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class beautifulPairs {

    // Complete the beautifulPairs function below.
    static int beautifulPairs(int[] A, int[] B) {

        int sizeA = A.length;
        int sizeB = B.length;
        int count = 0;

//        Arrays.sort(A);
//        Arrays.sort(B);
//
//        System.out.println(Arrays.toString(A));
//        System.out.println(Arrays.toString(B));
//        for(int i = 0; i < sizeA; i++){
//
//        }

        for(int i = 0; i < sizeA; i++){

            for(int j = 0; j < sizeB; j++){
                if(A[i] == B[j]){
                    A[i] = -1;
                    B[j] = -1;
                    count++;
                    break;
                }
            }

        }

        for(int i = 0; i < sizeA; i++){
            if(A[i] != -1){
                for(int j = 0; j < sizeB; j++){
                    if(B[j] != -1){
                        return ++count;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(AItems[i]);
            A[i] = AItem;
        }

        int[] B = new int[n];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = beautifulPairs(A, B);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
