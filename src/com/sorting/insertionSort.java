package com.sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class insertionSort {

    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {

        int temp = arr[n-1];
        for(int i = n - 2; i >=0; i--){
            if(temp < arr[i]){
                arr[i+1] = arr[i];
                for(int j = 0; j < n; j++){
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }else{
                arr[i+1] = temp;
                for(int j = 0; j < n; j++){
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
                break;
            }
        }
    }

    // Complete the insertionSort2 function below.
    static void insertionSort2(int n, int[] arr) {

        for(int i = 1; i < n; i++){
            int temp = arr[i];
            for(int j = i-1; j >= 0; j--){
                if(arr[j] > temp){
                    arr[j+1] = arr[j];
                }else{
                    arr[j+1] = temp;
                    break;
                }
                if(j == 0)
                    arr[j] = temp;
            }
            for(int j = 0; j < n; j++){
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }

    }

    // Complete the quickSort function below.
    static int[] quickSort(int[] arr) {

        int p = arr[0];
        int size = arr.length;
        int i, j;
        for(i = 1, j = size - 1; i < j; i++){
            if(arr[i] > p){
                while(arr[j] > p && i < j){
                    j--;
                }
                if(i < j){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j--;
                }
            }
        }
        while(p < arr[i] && i >= 0){
            i--;
        }
        if(i > 0){
            int temp = arr[i];
            arr[i] = p;
            arr[0] = temp;
        }
        return arr;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        arr = quickSort(arr);

        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        scanner.close();
    }
}

