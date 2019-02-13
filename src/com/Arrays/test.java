package com.Arrays;

// You can print the values to stdout for debugging
public class test {

    public static void main(String[] args){

        int[] input = new int[]{101,100};

        int x = getDigitSumParity(input);
    }

    public static int getDigitSumParity(int[] arr) {
        int min = getMin(arr);
        int result = getSum(min);

        if (result == 0) {
            return 1;
        }
        if (result % 2 == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int getMin(int[] arr) {
        if (arr == null || arr.length <= 0) {
            throw new IllegalArgumentException(
                    "Input array should contain at least 1 element.");
        }
        int min = arr[0];
        for (int i = 1, len = arr.length; i < len; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            num = num / 10;
            int temp = num % 10;
            sum = sum + temp;
        }
        return sum;
    }
}