package com.DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class KnapSackRevisited
{
    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader input = null;
        input = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input/dummy"))));

        int testCases = Integer.parseInt(input.readLine());

        for(int i = 0; i < testCases; i++){
            int size = Integer.parseInt(input.readLine());
            int W = Integer.parseInt(input.readLine());
            int[] value = new int[size];
            int[] weight = new int[size];

            value = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            weight = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int res;

            res = knapSackO1(value, weight, W);

            System.out.println(res);
        }
    }

    private static int knapSackO1(int[] value, int[] weight, int W){
        int size = weight.length;
        int[][] s = new int[size+1][W+1];

        // Sorting of weight is not necessary.
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= W; j++){
                if(weight[i-1] <= j){
                    s[i][j] = Math.max(value[i-1] + s[i-1][j-weight[i-1]], s[i-1][j]);
                }else{
                    s[i][j] = s[i-1][j];
                }
            }
        }

        return s[size][W];
    }
}