package com.Arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class rotate {

    private static Scanner scanner = null;

    static {
        try {
            scanner = new Scanner(new FileInputStream(new File("input/dummy")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] b = new int[n];

        for(int i = 0,j = d; i < n; i++,j++){
            if(j>=n){
                j = j % n;
            }
            b[i] = a[j];

        }
        for(int i = 0; i < n; i++)
            System.out.print(b[i]+" ");

        scanner.close();
    }
}

