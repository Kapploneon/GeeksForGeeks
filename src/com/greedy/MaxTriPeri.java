package com.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxTriPeri {

    // Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(int[] sticks) {

        Arrays.sort(sticks);
        int size = sticks.length;
        int[] res = new int[3];
        for(int i = size - 1; i >= 0; i--){
            for(int j = i - 1; j >= 0; j--){
                for(int l = j - 1; l >= 0; l--){
                    if(sticks[i] + sticks[j] <= sticks[l]){
                        break;
                    }
                    if(sticks[i] + sticks[l] <= sticks[j]){
                        break;
                    }
                    if(sticks[l] + sticks[j] <= sticks[i]){
                        break;
                    }
                    res[0] = sticks[l];
                    res[1] = sticks[j];
                    res[2] = sticks[i];
                    return res;
                }
            }
        }
        res[0] = -1;
        return res;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] sticks = new int[n];

        String[] sticksItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sticksItem = Integer.parseInt(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        int[] result = maximumPerimeterTriangle(sticks);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        scanner.close();
    }
}
