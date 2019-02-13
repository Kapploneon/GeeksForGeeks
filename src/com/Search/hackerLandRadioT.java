package com.Search;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class hackerLandRadioT {

    // Complete the hackerlandRadioTransmitters function below.
    static int hackerlandRadioTransmitters(int[] x, int k) {

        Arrays.sort(x);
//         int size = x.length;
//         int count = 1;
//         int point = x[0] + k;

//         for(int i = 0; i < size; i++){
//             if(Math.abs(point - x[i]) <= k){
//                 continue;
//             }else{
//                 point = x[i] + k;
//                 count++;
//             }
//         }

        int numOfTransmitters = 0;
        int i = 0;
        int n = x.length;

        while (i < n) {
            numOfTransmitters++;
            int loc = x[i] + k;
            while (i < n && x[i] <= loc) i++;
            loc = x[--i] + k;
            while (i < n && x[i] <= loc) i++;
        }
        // System.out.println(numOfTransmitters);

        return numOfTransmitters;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] x = new int[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x[i] = xItem;
        }

        int result = hackerlandRadioTransmitters(x, k);

        System.out.println(result);
        scanner.close();
    }
}

