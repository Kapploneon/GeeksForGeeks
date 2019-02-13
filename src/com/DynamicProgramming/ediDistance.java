package com.DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class ediDistance
{
    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader input = null;
        input = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input/dummy"))));

        int testCases = Integer.parseInt(input.readLine());

        for(int i = 0; i < testCases; i++){
            int[] array;

            array = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            String[] str = input.readLine().split(" ");

            int[][] dp = new int[str[0].length() + 1][str[1].length() + 1];

            int min = editDistance(str[0], str[1], dp);

            System.out.println(min);
        }
    }

    // You can do it via iterative approach as well. Below is the recursive one.
    private static int editDistance(String s1, String s2, int[][] dp){

        if(s1.length() == 0){
            return s2.length();
        }

        if(s2.length() == 0){
            return s1.length();
        }

        if(s1.equals(s2)){
            return 0;
        }

        if(dp[s1.length()][s2.length()] > 0 ){
            return dp[s1.length()][s2.length()];
        }

        if(s1.substring(s1.length() - 1).equals(s2.substring(s2.length() - 1))){
            return editDistance(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1), dp);
        }

        dp[s1.length()][s2.length()] = 1 + Math.min(
                editDistance(s1, s2.substring(0, s2.length() - 1), dp),
                Math.min(editDistance(s1.substring(0, s1.length() - 1), s2, dp),
                        editDistance(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1), dp))
        );

        return dp[s1.length()][s2.length()];
    }
}