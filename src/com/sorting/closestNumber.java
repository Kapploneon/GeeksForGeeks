package com.sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class closestNumber {

    // Complete the closestNumbers function below.
    private static int[] closestNumbers(int[] arr) {

        Arrays.sort(arr);
        int size = arr.length;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < size; i++){
            if(min > (arr[i] - arr[i-1])){
                min = Math.abs(arr[i] - arr[i-1]);
            }
        }

        List<Integer> a = new ArrayList<>();

        for(int i = 1; i < size; i++){
            if(Math.abs(arr[i-1] - arr[i]) == min){
                a.add(arr[i-1]);
                a.add(arr[i]);
            }
        }

        int[] ret = new int[a.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = a.get(i).intValue();
        }

        return ret;
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

        int[] result = closestNumbers(arr);

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
