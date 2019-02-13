package com.implementation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class pickingNumbers {

    // Complete the pickingNumbers function below.
    static int pickingNumbers(int[] a) {

        Arrays.sort(a);
        int size = a.length;
        int max = 0;
        int temp = 0;

        for(int i = 0; i < size; i++){
            for(int j = i+1; j < size; j++){
                if(Math.abs(a[j] - a[i]) <= 1){
                    temp++;
                }else{
                    break;
                }
            }
            if(max < temp){
                max = temp;
            }
            temp = 0;
        }
        if(max > 0){
            max++;
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = pickingNumbers(a);

        System.out.println(result);

        scanner.close();
    }
}

