package com.Arrays;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/*
Given an array of size n-1 and given that there are numbers from 1 to n with one missing, the missing number is to be found.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N.
The second line of each test case contains N-1 input C[i],numbers in array.

Output:

Print the missing number in array.

Constraints:

1 ≤ T ≤ 200
1 ≤ N ≤ 1000
1 ≤ C[i] ≤ 1000

Example:

Input
2
5
1 2 3 5
10
1 2 3 4 5 6 7 8 10

Output
4
9
*/
public class MissingNumberBufferedReader {
    public static void main(String[] args) throws IOException {
        //code
        // Read file.
        BufferedReader input = null;
        try {
            input = new BufferedReader(new InputStreamReader( new FileInputStream("input/dummy")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int testCases = Integer.parseInt(input.readLine());

        // starting time
        long start = System.currentTimeMillis();

        // start of function

        for(int i = 0; i < testCases; i++) {
            int numbers = Integer.parseInt(input.readLine());
            int[] given = new int[numbers-1];


            given = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

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
