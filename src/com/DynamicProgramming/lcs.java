package com.DynamicProgramming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class lcs {

    // Complete the longestCommonSubsequence function below.
    static int[] longestCommonSubsequence(int[] a, int[] b) {

        int[][] s = new int[a.length + 1][b.length + 1];
        int max = 0;
        for(int i = 1; i <= a.length; i++){
            for(int j = 1; j <= b.length; j++){
                if(a[i-1] == b[j-1]){
                    s[i][j] = s[i-1][j-1] + 1;
                    if(s[i][j] > max){
                        max = s[i][j];
                    }
                }else{
                    s[i][j] = Math.max(s[i-1][j],s[i][j-1]);
                }
            }
        }

        boolean flag = false;
        int[] seq = new int[max];
        int temp = max;
        for(int i = 1; i <= a.length; i++){
            for(int j = 1; j <= b.length; j++){
                if(s[i][j] == max){
                    // Found the end character of the sequence.
                    // Now trace back the complete sequence.
                    while(s[i][j] != 0){
                        if(s[i][j-1] == temp){
                            j--;
                        }else if(s[i-1][j] == temp){
                            i--;
                        }else{
                            seq[temp - 1] = a[i - 1];
                            i--;
                            j--;
                            temp--;
                        }
                    }
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }

        return seq;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b[i] = bItem;
        }

        int[] result = longestCommonSubsequence(a, b);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        scanner.close();
    }
}
