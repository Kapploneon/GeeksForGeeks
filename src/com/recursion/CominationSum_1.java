package com.recursion;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class CombinationSum_1
{
    public static void main (String[] args)
    {
        //code
        Scanner input = new Scanner(System.in);

        int test = input.nextInt();
        String[] result = new String[test];


        for(int i = 0; i < test; i++){
            int arraySize = input.nextInt();
            int[] arrayInt = new int[arraySize];

            for(int j = 0; j < arraySize; j++){
                arrayInt[j] = input.nextInt();
            }

            sumToFind = input.nextInt();

            Arrays.sort(arrayInt);

            combinationSum(arrayInt, 0, 0, "" );

            if(answer.isEmpty()){
                result[i] = "Empty";
            }else {
                result[i] = answer;
            }
            answer = "";
        }

        for(int i = 0; i < test; i++){
            System.out.println(result[i]);
        }
    }

    private static String answer = "";
    private static Set<String> set = new HashSet<>();
    private static int sumToFind;

    private static void combinationSum(int[] array, int pointer, int currentSum, String toPrint){
        if(currentSum == sumToFind){
            if(!set.contains(toPrint)){
                answer = answer + "(" + toPrint.trim() + ")";
                set.add(toPrint);
            }
        }
        if(currentSum > sumToFind || pointer == array.length){
            return;
        }

        for(int i = pointer; i < array.length; i++){
            combinationSum(array, i + 1, currentSum + array[i], toPrint+ " "+ array[i]);
        }

    }
}