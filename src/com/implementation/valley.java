package com.implementation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class valley {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        char[] c = s.toCharArray();

        int count = 0;
        boolean flag = true;
        int level = 0;

        for(int i = 0; i < n; i++){
            if(c[i] == 'D'){
                level--;
            }else{
                level++;
            }
            if(level < 0 && flag){
                count++;
                flag = false;
            }
            if(level >= 0 && !flag){
                flag = true;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(result);

        scanner.close();
    }
}

