package com.HourRank29;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class gcdCount{

    // Complete the solve function below.
    static int solve(int[] a) {

        int size = a.length;
        long leftProduct = 1;

        for(int i = 0; i < size - 1; i++){
            leftProduct *= a[i];
        }

        long rightProduct = a[size - 1];
        int count = 0;

        if(gcd(leftProduct, rightProduct) == 1){
            count++;
        }

        for(int i = size - 3; i >= 0; i--){
            leftProduct = leftProduct / a[i+1];
            rightProduct *= a[i+1];

            if(gcd(leftProduct, rightProduct) == 1){
                count++;
            }
            //count %= 1000000007;
        }

        count = count*2;

        count %= 1000000007;

        return count;
    }

    static long gcd(long a, long b){
        long gcd = 2;

        if(a < b){
            gcd = a;
        }else{
            gcd = b;
        }

        while(gcd > 1 && (a % gcd != 0 || b % gcd != 0)){
            gcd--;
        }

        return gcd;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = scanner.nextInt();

                int[] a = new int[n];

                for(int i = 0; i < n; i++){
                    a[i] = scanner.nextInt();
                }

                int result = solve(a);

                System.out.println(result);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

    }
}
