package com.DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class minJump
{
    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader input = null;
        input = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input/dummy"))));

        int testCases = Integer.parseInt(input.readLine());

        for(int i = 0; i < testCases; i++){
            int numbers = Integer.parseInt(input.readLine());
            int[] array;


            array = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int res = minJumps(array);

            System.out.println("minimum -> " + res);
        }
    }

    private static int minJumps(int[] array){

        int[] res = new int[array.length];
        int numbers = array.length;

        for(int i = numbers - 1; i >= 0; i--){

            if(array[i] == 0){
                res[i] = 0; // No jump possible
                continue;
            }

            if(array[i]+i >= numbers - 1){
                res[i] = 1;
            }else{
                res[i] = Integer.MAX_VALUE;
                for(int x = i+1; x <= i+array[i]; x++){
                    if(res[x] == 0){
//                        res[i] = 0;
                        continue;       // No jump possible
                    }
                    res[i] = Math.min(res[i], res[x] + 1);
                }
            }
        }

//        for(int i = 0; i < numbers; i++){
//            System.out.print(res[i]+" ");
//        }
//
//        System.out.println();
        return res[0] <= 0 ? -1 : res[0];
    }
}