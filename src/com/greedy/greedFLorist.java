package com.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class greedFLorist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {

        int size = c.length;
        int temp = k;
        int inc = 0;
        int cost = 0;

        Arrays.sort(c);

        for(int i = 0; i < size; i++){
            if(temp == 0){
                inc++;
                temp = k;
            }
            cost += c[size - i - 1]*(inc + 1);
            temp--;
        }

        return cost;

    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        System.out.println(String.valueOf(minimumCost));

        scanner.close();
    }
}
