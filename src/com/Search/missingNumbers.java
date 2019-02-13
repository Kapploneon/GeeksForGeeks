package com.Search;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class missingNumbers {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {

        Arrays.sort(arr);
        Arrays.sort(brr);

        int size = brr.length;
        List<Integer> list = new ArrayList<>();
        int aSize = arr.length;
        int i, j;
        for( i = 0, j = 0; i < size && j < aSize; i++, j++){
            if(brr[i] != arr[j]){
                list.add(brr[i]);
                j--;
                while(i+1 < size && brr[i] == brr[i+1]){
                    i++;
                }
                while(arr[j] <= brr[i] && j+1 < aSize && arr[j] == arr[j+1]){
                    j++;
                }
            }
        }
        i--;
        if( i != size - 1){
            for(; i < size; i++){
                list.add(brr[i]);
                while(i+1 < size && brr[i] == brr[i+1]){
                    i++;
                }
            }
        }

        int[] res = new int[list.size()];
        for(i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
        scanner.close();
    }
}
