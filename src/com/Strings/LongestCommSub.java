package com.Strings;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class LongestCommSub
{
    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader input = null;
        input = new BufferedReader(new InputStreamReader(new FileInputStream( new File("input/dummy") )));

        int testCases = Integer.parseInt(input.readLine());

        for(int i = 0; i < testCases; i++){
            input.readLine();
            char[] str1 = input.readLine().toCharArray();
            char[] str2 = input.readLine().toCharArray();
            int size1 = str1.length;
            int size2 = str2.length;
            int m = size1+1;
            int n = size2+1;
            int[][] mat = new int[m][n];
            int max = 0;
            Queue<Integer> Q = new LinkedList<>();


            for(int im = 0; im < m; im++){
                for(int in = 0; in < n ; in++){
                    if(im == 0 || in == 0){
                        mat[im][in] = 0;
                    }else{
                        if(str1[im-1] == str2[in-1]){
                            mat[im][in] = mat[im - 1][in - 1] + 1;
                            if(mat[im][in] > max){
                                max = mat[im][in];
                            }
                        }
                    }
                }
            }

            System.out.println(max);
        }
    }
}
