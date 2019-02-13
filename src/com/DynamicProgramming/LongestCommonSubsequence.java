package com.DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class LongestCommonSubsequence
{
    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader input = null;
        input = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input/dummy"))));

        int testCases = Integer.parseInt(input.readLine());

        for(int i = 0; i < testCases; i++){
            String dummy;
            dummy = input.readLine();
            char[] str1 = input.readLine().toCharArray();
            char[] str2 = input.readLine().toCharArray();

            int x = lcs_length(str1, str2);

            System.out.println(x);
        }
    }

    static int lcs_length(char[] str1, char[] str2){
        int r = str1.length;
        int c = str2.length;

        int[][] ct = new int[r + 1][c + 1];

//        for(int i = 0; i < r; i++){
//            ct[i][0] = 0;
//        }
//
//        for(int j = 0; j < c; j++){
//            ct[0][j] = 0;
//        }

        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                if(str1[i - 1] == str2[j-1]){
                    ct[i][j] = ct[i - 1][j - 1] + 1;
                }else{
                    ct[i][j] = Math.max(ct[i - 1][j], ct[i][j - 1]);
                }
            }
        }

//        System.out.println(Arrays.toString(str2));
//        for(int i = 1; i <= r; i++){
//            System.out.print(str1[i - 1] + " ");
//            for(int j = 1; j <= c; j++){
//                System.out.print(ct[i][j] + " ");
//            }
//            System.out.println();
//        }

        return ct[r][c];
    }
}