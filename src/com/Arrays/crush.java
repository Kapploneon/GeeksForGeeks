package com.Arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class crush {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] res = new long[n];
        int qCount = queries.length;

        for(int i = 0; i < qCount; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];

            res[a - 1] += k;
            if(b < n){
                res[b] -= k;
            }
        }

        long max = Long.MIN_VALUE;
        long temp = 0;

        for(int i = 0; i < n; i++){
            temp += res[i];
            if(temp > max){
                max = temp;
            }
        }

        return max;
    }

    private static Scanner scanner = null;

    static {
        try {
            scanner = new Scanner( new FileInputStream(new File("input/dummy")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}

