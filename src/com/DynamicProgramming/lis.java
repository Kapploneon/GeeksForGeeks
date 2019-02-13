package com.DynamicProgramming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class lis {

    // Complete the longestIncreasingSubsequence function below.
    static int longestIncreasingSubsequence(int[] array) {

        int numbers = array.length;
        int[] dummy = new int[numbers];

        /* CODE FOR DP O(NlogN) time and O(N) space. */
        dummy[0] = array[0];
        int len = 1;

        for(int i = 1; i < numbers; i++){
            if(array[i] < dummy[0]){
                dummy[0] = array[i];
            }else if (array[i] > dummy[len - 1]){
                dummy[len++] = array[i];
            }else{
                dummy[CeilingIndex(dummy, -1, len - 1, array[i])] = array[i];
            }
        }

        return len;
        /* CODE FOR DP O(N^2) time and O(N) space*/
        // dummy[0] = 1;
        // int max = 0;
        // for(int ii = 1; ii < numbers; ii++){
        //     for(int j = ii - 1; j >= 0; j--){
        //         if(array[ii] > array[j]){
        //             if(dummy[j] + 1 > dummy[ii]){
        //                 dummy[ii] = dummy[j]+1;
        //                 if(max < dummy[ii]){
        //                     max = dummy[ii];
        //                 }
        //             }
        //         }
        //     }
        //     if(dummy[ii] == 0){
        //         dummy[ii] = 1;
        //     }
        // }
        //
        // return max;
    }

    static int CeilingIndex(int[] dummy, int l, int r, int key){
        while(r - l > 1){
            int m = l + (r-l)/2;
            if(dummy[m]>= key){
                // So key falls on the left of dummy[m].
                // Hence search from l to m now. Decrease r.
                r = m;
            }else{
                // So key falls on the right of dummy[m].
                // Hence search from m to r now. Increase l.
                l = m;
            }
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = longestIncreasingSubsequence(arr);

        System.out.println(result);

        scanner.close();
    }
}
