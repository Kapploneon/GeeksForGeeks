package com.DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class kadanes
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


            int result = kadanes(numbers, array);
//            int result = kadanes(array);

            System.out.println(result);
        }
    }

    public static int kadanes(int size, int[] array){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
//        int size = a.length;

        for(int i = 0; i < size; i++){

            if ( sum + array[i] <= 0 ){
                if(maxSum < sum){
                    maxSum = sum;
                }
                sum = 0;
            }else{
                sum += array[i];
            }

        }

        if(maxSum < sum){
            maxSum = sum;
        }

        return maxSum;
    }

//    static int kadanes(int a[])
//    {
//        int size = a.length;
//        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
//
//        for (int i = 0; i < size; i++)
//        {
//            max_ending_here = max_ending_here + a[i];
//            if (max_so_far < max_ending_here)
//                max_so_far = max_ending_here;
//            if (max_ending_here < 0)
//                max_ending_here = 0;
//        }
//        return max_so_far;
//    }

}