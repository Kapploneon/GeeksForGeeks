package com.Arrays;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class socks {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        Arrays.sort(ar);
        int count = 0;
        int temp = ar[0];
        int glo = 0;

        for(int i = 0; i < n; i++){
            if(temp == ar[i]){
                count++;
            }else{
                glo = glo + count/2;
                count = 1;
                temp = ar[i];
            }
        }

        glo = glo + count/2;

        return glo;
    }


    private static Scanner scanner = null;

    static {
        try {
            scanner = new Scanner( new FileInputStream(new File("input/dummy")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
