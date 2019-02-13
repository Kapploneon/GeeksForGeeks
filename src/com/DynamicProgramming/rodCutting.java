package com.DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class rodCutting
{
    public static void main (String[] args) throws IOException
    {
        // code
        Scanner input = new Scanner(new FileInputStream(new File("input/dummy")));

        int testCases = Integer.parseInt(input.nextLine());

        for(int i = 0; i < testCases; i++){
            int rod = Integer.parseInt(input.nextLine().trim() );
            int[] array = new int[3];

            array = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] r = new int[++rod];
            int count = maxCount(array, rod, r);

            System.out.println(count);
        }
    }

    private static int maxCount(int[] a, int rod, int[] r){

        Arrays.sort(a);
        for(int i = 0; i < 3; i++){
            for(int j = 1; j < rod; j++){
                if(j % a[i] == 0){
                    r[j] = Math.max(Math.max(r[j], j / a[i]), r[j - a[i]] + r[a[i]]);
                }else{
                    if(j > a[i] && r[j - a[i]] > 0){
                        r[j] = Math.max(r[j], r[j - a[i]] + r[a[i]]);
                    }
                }
            }
        }

        return r[rod - 1];
    }
}