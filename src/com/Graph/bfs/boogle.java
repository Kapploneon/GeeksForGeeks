package com.Graph.bfs;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class boogle
{
    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader input = null;
        input = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input/dummy"))));

        int testCases = Integer.parseInt(input.readLine());

        for(int ix = 0; ix < testCases; ix++){
            int numbers = Integer.parseInt(input.readLine());
            String[] array = new String[numbers];

            array = input.readLine().split(" ");
            int[] matrix = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            char[][] boogle = new char[matrix[0]][matrix[1]];
            int[][] boogleI = new int[matrix[0]][matrix[1]];

            String[] cha = new String[matrix[0] * matrix[1]];
            cha = input.readLine().split(" ");
            int x = 0;
            for(int i = 0; i < matrix[0]; i++){
                for(int j = 0; j < matrix[1]; j++){
                    boogle[i][j] = cha[x++].charAt(0);
                    boogleI[i][j] = 0;
                }
            }

            // for(int i = 0; i < array.length; i++){
            //     System.out.println(array[i]);
            // }

            // for(int i = 0; i < matrix[0]; i++){
            //     for(int j = 0; j < matrix[1]; j++){
            //         System.out.print(boogle[i][j] + " ");
            //     }
            //     System.out.println();
            // }

            // Call your method here / Code your solution here.
            for(int i = 0; i < numbers; i++){
                boolean res = check(array[i], boogle, boogleI);
                if(res){
                    System.out.print(array[i] + " ");
                }
            }

            System.out.println();
        }

    }

    public static boolean check(String s, char[][] boogle, int[][] boogleI){
        char[] c = s.toCharArray();

        return true;
    }
}
