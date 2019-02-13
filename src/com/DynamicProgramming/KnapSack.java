package com.DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;

class KnapSack {

    static int knapsack(int W, int n, int wt[], int val[] ){

        int l[][] = new int[n+1][W+1];

        for(int r = 0 ;r <= n; r++){
            for(int c = 0; c <= W; c++){
                if(r == 0 || c == 0)
                    l[r][c] = 0;
                else if( wt[r-1] > c)
                    l[r][c] = l[r-1][c];
                else
                    l[r][c] = Math.max( l[r-1][c-wt[r-1]] + val[r-1], l[r-1][c] );
            }
        }

        return l[n][W];
    }

    public static void main (String[] args) throws IOException {
        BufferedReader input = null;
        input = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input/dummy"))));

        int t = Integer.parseInt(input.readLine());

        for(int i = 0; i < t; i++){
            input.readLine();
            int W = Integer.parseInt(input.readLine());

            int val[];
            int wt[];
            String x = "132";

            int y = Integer.parseInt(x);
            val = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            wt = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int n = wt.length;

            int w = knapsack(W, n, wt, val);

            System.out.println(w);
        }
    }
}
