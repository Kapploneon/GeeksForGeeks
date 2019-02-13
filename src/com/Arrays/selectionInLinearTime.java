package com.Arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class selectionInLinearTime
{
    static int[] array;

    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader input = null;
        try {
            input = new BufferedReader(new InputStreamReader( new FileInputStream("input/dummy")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int testCases = Integer.parseInt(input.readLine());

        for(int i = 0; i < testCases; i++){
            int numbers = Integer.parseInt(input.readLine());
            array = new int[numbers];

            array = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int kth = Integer.parseInt(input.readLine());

            int kthsmallest = quickSortkthSmallest(kth, 0, array.length - 1);

            System.out.println(kthsmallest);
        }
    }

    static int quickSortkthSmallest(int kth, int startI, int endI){


        int q = randomPartition(startI, endI);

        // i + 1 is the newly fixed value.
        // i + 1 is the element around which the partion happened.
        int k = q - startI + 1;

        if(kth == k){
            return array[q];
        }else if(kth < k){
            return quickSortkthSmallest( kth, startI, q-1);
        }else{
            return quickSortkthSmallest( kth - k, q + 1, endI);
        }
    }

    static int randomPartition(int startI, int endI){
        // Get random pivot.
        int randomPivot = startI + (int)(Math.random()*( ( endI - startI ) + 1) );

        //Exchange randomPivot with endI.
        int temp = array[randomPivot];
        array[randomPivot] = array[endI];
        array[endI] = temp;

        return partition(startI, endI);
    }

    static int partition(int startI, int endI){
        // partition around endI.
        int end = array[endI];
        int i = startI - 1;
        for(int j = startI; j < endI; j++){
            if(array[j] <= end){

                i = i + 1;
                // Exchange i with j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Exchange i+1 with endI
        int temp = array[i+1];
        array[i+1] = array[endI];
        array[endI] = temp;

        return i+1;
    }

}