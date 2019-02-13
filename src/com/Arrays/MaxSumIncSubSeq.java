package com.Arrays;

/*
* Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array
* such that the intgers in the subsequence are sorted in increasing order.
* For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100),
* if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and if the input array is
* {10, 5, 4, 3}, then output should be 10
* */

/*
* Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such that the integers in the subsequence are sorted in increasing order.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the size of array.
The second line of each test case contains N input A[].

Output:

Print the sum of maximum sum sequence of the given array.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 100
1 ≤ A[] ≤ 1000

Example:

Input:
2
7
1 101 2 3 100 4 5
4
10 5 4 3

Output:
106
10

Explanation:
For input:
7
1 101 2 3 100 4 5
All the increasing subsequences : (1,101); (1,2,3,100); (1,2,3,4,5), out of this (1,2,3,100) has maximum sum,i.e.,
*/

import java.io.*;
import java.util.Arrays;

public class MaxSumIncSubSeq {
    public static void main (String[] args) throws IOException {
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
            int[] array = new int[numbers];
            int[] lisSum = new int[numbers];
            int[] lis = new int[numbers];
            int size = array.length;

            array = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.arraycopy(array, 0, lisSum, 0, size);
            Arrays.fill(lis, 1);

            for(int ix = 1; ix < size; ix++){
                for(int jx = 0; jx < ix; jx++){
                    if(array[jx] < array[ix]){
                        if(array[ix] + lisSum[jx] > lisSum[ix]) {
                            lisSum[ix] = array[ix] + lisSum[jx];
                            lis[ix] += lis[jx];
                        }
                    }
                }
            }

            int max = 0;
            for(int ix = 0; ix < size; ix++){
                if(lisSum[ix] > max)
                    max = lisSum[ix];
            }

//            System.out.println(" The lis is as follows:");
//            System.out.println(Arrays.toString(lis));
//            System.out.println(" The lisSum is as follows:");
//            System.out.println(Arrays.toString(lisSum));
            System.out.println(max);
        }
    }
}
