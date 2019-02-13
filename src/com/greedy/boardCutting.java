package com.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class boardCutting {

    // Complete the boardCutting function below.
    static int boardCutting(int[] cost_y, int[] cost_x) {

        Arrays.sort(cost_y);
        Arrays.sort(cost_x);
        int y = cost_y.length;
        int x = cost_x.length;
        long cost = 0;
        long xcuts = 1;
        long ycuts = 1;
//        int xcuts = 1;
//        int ycuts = 1;
        long max = (long)Math.pow(10,9) + 7;

        while(x != 0 || y != 0){
            if((x > 0 && y > 0 && (cost_x[x-1] > cost_y[y-1] || (cost_x[x-1] == cost_y[y-1] && ycuts < xcuts))) || (x > 0 && y == 0)){
                cost = (cost + (cost_x[x-1] * ycuts));
                xcuts++;
                x--;
            }else{
                if(y > 0){
                    cost = (cost + (cost_y[y-1] * xcuts));
                    ycuts++;
                    y--;
                }
            }
        }
        cost %= max;
        return (int)cost;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] mn = scanner.nextLine().split(" ");

            int m = Integer.parseInt(mn[0]);

            int n = Integer.parseInt(mn[1]);

            int[] cost_y = new int[m-1];

            String[] cost_yItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m-1; i++) {
                int cost_yItem = Integer.parseInt(cost_yItems[i]);
                cost_y[i] = cost_yItem;
            }

            int[] cost_x = new int[n-1];

            String[] cost_xItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n-1; i++) {
                int cost_xItem = Integer.parseInt(cost_xItems[i]);
                cost_x[i] = cost_xItem;
            }

            int result = boardCutting(cost_y, cost_x);

            System.out.println(result);
        }

        scanner.close();
    }
}
