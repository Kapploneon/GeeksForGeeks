package com.implementation;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class inBetween {

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */

        int sizeA = a.length;
        int sizeB = b.length;

        Arrays.sort(a);
        Arrays.sort(b);
        int lcm = a[sizeA - 1];
        int gcd = b[0];
        while( lcm <= gcd ){
            int temp = lcm;
            for(int i = 0; i < sizeA; i++){
                if(lcm % a[i] != 0){
                    lcm++;
                    break;
                }
            }
            if(temp == lcm){
                break;
            }
        }

        while(lcm <= gcd ){
            int temp = gcd;
            for(int i = 0; i < sizeB; i++){
                if(b[i] % gcd != 0){
                    gcd--;
                    break;
                }
            }
            if(temp == gcd){
                break;
            }
        }

        int count = 0;
        int i = 0;
        int temp = lcm;
        while(temp <= gcd){
            i++;
            temp = lcm * i;
            if(gcd % temp == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
            Scanner scan = new Scanner(new FileInputStream(new File("input/dummy")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        System.out.println(total);

    }
}
