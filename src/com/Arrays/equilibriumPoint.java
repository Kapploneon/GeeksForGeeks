package com.Arrays;

import java.io.*;
import java.util.Arrays;

public class equilibriumPoint {
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

            array = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            String x = String.valueOf(array[0]);

            if(array.length == 1){
                System.out.println(1);
                continue;
            }

            if(array.length == 2){
                System.out.println(-1);
                continue;
            }

            if(array.length > 2) {
                int leftSum = array[0];
                int rightSum = 0;
                int size = array.length;

                for (int j = 2; j < size; j++) {
                    rightSum = rightSum + array[j];
                }

                for(int j = 1; j < size; j++){
                    if(leftSum == rightSum){
                        System.out.println(j+1);
                        break;
                    }
                    if(j != (size - 1)){
                        leftSum = leftSum + array[j];
                        rightSum = rightSum - array[j+1];
                    }
                }

                if(leftSum != rightSum)
                    System.out.println(-1);
            }
        }
    }
}