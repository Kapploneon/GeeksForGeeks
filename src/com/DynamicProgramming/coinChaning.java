package com.DynamicProgramming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class coinChaning {

    // Complete the getWays function below.
    static long getWays(long n, long[] c) {

        int x = (int)n+1;
        long[] N = new long[x];

        N[0] = 1;

        for( long coin : c ){
            for(int i = 1; i < n+1; i++){
                if(i >= coin){
                    N[i] += N[i - (int)coin];
                }
            }
        }
        return N[(int)n];
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] c = new long[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cItems[i]);
            c[i] = cItem;
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);

        System.out.println(ways);

        scanner.close();
    }
}
