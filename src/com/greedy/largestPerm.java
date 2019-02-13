package com.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class largestPerm {

    // Complete the largestPermutation function below.
    static int[] largestPermutation(int k, int[] arr) {

        int size = arr.length;
        int max = size;
        for(int i = 0; i < size && k > 0; i++, k--){
            if(arr[i] == max){
                max--;
                continue;
            }
            int temp = arr[i];
            arr[i] = max;
            for(int j = i+1; j < size; j++){
                if(arr[j] == max){
                    arr[j] = temp;
                    max--;
                    break;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = largestPermutation(k, arr);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        scanner.close();
    }
}
