package com.DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class coinChangingRevisited
{
    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader input = null;
        input = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input/dummy"))));

        int testCases = Integer.parseInt(input.readLine());

        for(int i = 0; i < testCases; i++){
            int numbers = Integer.parseInt(input.readLine());
            int[] array = new int[numbers];

            array = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int cent = Integer.parseInt(input.readLine());

            int max = coinChanging(array, cent);

            System.out.println(max);
        }
    }

    private static int coinChanging(int[] array, int cent){
        int[] changes = new int[cent+1];
        changes[0] = 1;
        int size = array.length;

        for(int i = 0; i < size; i++){
            for(int j = 1; j < cent+1; j++){
                if(j >= array[i]){
                    changes[j] += changes[j - array[i]];
                }
            }
        }

        return changes[cent];
    }
}