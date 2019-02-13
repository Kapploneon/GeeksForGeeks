package com.Days30OfProgramming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Day10 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int max = 0;
        int temp = 0;
        int res;
        System.out.println(Integer.toBinaryString(n));
        while(n > 1){
            res = n%2;
            if(res == 1)
                temp++;
            else{
                if(max < temp) {
                    max = temp;

                }
                temp = 0;
            }
            n = n/2;
        }

        if(n == 1)
            temp++;
            if(max < temp){
                max = temp;
                temp = 0;
            }

        System.out.println(max);

        scanner.close();
    }
}

