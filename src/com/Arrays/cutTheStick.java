package com.Arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class cutTheStick {

    static int[] toIntArray(List<Integer> list){
        int[] ret = new int[list.size()];
        for(int i = 0;i < ret.length;i++)
            ret[i] = list.get(i);
        return ret;
    }

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {

        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int size = arr.length;

        for(int i = 0; i < size; i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        int newMin = Integer.MAX_VALUE;
        boolean flag = true;
        int sticksCut = 0;

        while(flag){
            flag = false;
            for(int i = 0; i < size; i++){
                if(arr[i] > 0){
                    arr[i] -= min;
                    flag = true;
                    sticksCut++;
                }
                if(newMin > arr[i] && arr[i] != 0)
                    newMin = arr[i];
            }
            min = newMin;
            newMin = Integer.MAX_VALUE;
            if(sticksCut == 0){
                break;
            }
            list.add(sticksCut);
            sticksCut = 0;
        }

        return  toIntArray(list);
    }

    //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int[] cellCompete(int[] cells, int days)
    {
        // INSERT YOUR CODE HERE
        int size = cells.length;
        int[] dummyCells = new int[size];

        for(int i = 0; i < days; i++){
            System.arraycopy(cells, 0, dummyCells, 0, size);

            if(dummyCells[1] == 0){
                cells[0] = 0;
            }else{
                cells[0] = 1;
            }

            if(dummyCells[size - 2] == 0){
                cells[size - 1] = 0;
            }else{
                cells[size - 1] = 1;
            }

            for(int j = 1; j < size - 1; j++){
                if((dummyCells[j - 1] == 0 && dummyCells[j+1] == 0) || (dummyCells[j - 1] == 1 && dummyCells[j+1] == 1)){
                    cells[j] = 0;
                }else{
                    cells[j] = 1;
                }

            }
        }

        return cells;
    }

    public static int generalizedGCD(int arr[])
    {
        // INSERT YOUR CODE HERE
        int size = arr.length;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < size; i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }

        for(int j = min; j > 0; j--){

            boolean flag = true;

            for(int i = 0; i < size; i++){
                if(arr[i] % j != 0){
                    flag = false;
                    break;
                }
            }

            if(flag){
                min = j;
                break;
            }
        }

        return min;
    }

    private static Scanner scanner = null;

    static {
        try {
            scanner = new Scanner( new FileInputStream(new File("input/dummy")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        int[] arr = new int[]{2,3,4,5,6};
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] arr = new int[n];
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }
//
//        int[] result = cutTheSticks(arr);
//
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                System.out.println();
//            }
//        }

        generalizedGCD( arr );

        System.out.println();

        scanner.close();
    }
}

