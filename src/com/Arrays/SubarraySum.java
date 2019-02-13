package com.Arrays;

import java.io.*;
import java.util.Arrays;

/*
* Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:

Corresponding to each test case, in a new line, print the starting and ending positions of first such occuring subarray if sum equals to subarray, else print -1.

Note: Position of 1st element of the array should be considered as 1.

Expected Time Complexity: O(n)

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100
1 ≤ an array element ≤ 200

Example:

Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10

Output:
2 4
1 5

Explanation :
In first test case, sum of elements from 2nd position to 4th position is 12
In second test case, sum of elements from 1st position to 5th position is 15
*/
public class SubarraySum {

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
            int[] sizeParse = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int numbers = sizeParse[0];
            int sum = sizeParse[1];

            int[] array;

            array = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            subArrayFind(array, sum);

        }

        // starting time
        long end = System.currentTimeMillis();
        System.out.println("Time takes " +
                (end - start) + "ms");
    }

    private static void subArrayFind(int[] array, int sum) {
        int size = array.length;
        int start = 0;
        int currentSum = array[0];

        for(int i = 1; i <= size; i++){

            while(currentSum > sum && start < i-1){
                currentSum = currentSum - array[start];
                start++;
            }

            if(currentSum == sum){
                System.out.printf("%d %d\r\n", start+1, i);
                return;
            }

            if(i < size)
                currentSum = currentSum + array[i];
        }

        System.out.println("-1");
        return;
    }
}
