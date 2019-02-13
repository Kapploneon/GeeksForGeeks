package com.Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MissingNumber {
    public static void main (String[] args) throws FileNotFoundException {
        //code
        Scanner input = new Scanner(new File("input/dummy"));

        int testCases = input.nextInt();

        // starting time
        long start = System.currentTimeMillis();


        for(int i = 0; i < testCases; i++){
            int numbers = input.nextInt();
            int[] given = new int[numbers-1];

            for(int j = 0; j < (numbers-1); j++)
                given[j] = input.nextInt();

            int missing = findMissing(given, numbers);

            System.out.println(missing);
        }

        // starting time
        long end = System.currentTimeMillis();
        System.out.println("Time takes " +
                (end - start) + "ms");
    }

    private static int findMissing(int[] given, int numbers){
        int x1 = given[0];
        int x2 = 1;

        for(int i = 1; i < given.length; i++){
            x1 = x1 ^ given[i];
        }

        for(int i = 2; i <= numbers; i++){
            x2 = x2 ^ i;
        }

        return (x1 ^ x2);
    }
}
