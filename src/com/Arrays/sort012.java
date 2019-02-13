package com.Arrays;
/*
Write a program to sort an array of 0's,1's and 2's in ascending order.

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, First line is number of elements in array 'N' and second its values.

Output:
Print the sorted array of 0's, 1's and 2's.

Constraints:

1 <= T <= 100
1 <= N <= 100
0 <= arr[i] <= 2

Example:

Input :

2
5
0 2 1 2 0
3
0 1 0


Output:

0 0 1 2 2
0 0 1
*/
import java.io.*;
import java.util.Arrays;

public class sort012
{
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
            int[] array = new int[numbers];

            array = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int zero = 0;
            int one = 0;
            int two = 0;

            for(int x = 0; x < array.length; x++){
                if(array[x] == 0){
                    zero++;
                }
                if(array[x] == 1){
                    one++;
                }
                if(array[x] == 2){
                    two++;
                }
            }

            for(int x = 0; x < array.length; x++){
                if(zero > 0){
                    array[x] = 0;
                    zero--;
                }else {
                    if (one > 0) {
                        array[x] = 1;
                        one--;
                    } else {
                        if (two > 0) {
                            array[x] = 2;
                            two--;
                        }
                    }
                }
            }

            System.out.println(Arrays.toString(array));
        }
    }
}