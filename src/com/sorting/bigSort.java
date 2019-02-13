package com.sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class bigSort {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {

        Arrays.sort(unsorted, (x, y) -> {
            int xl = x.length();
            int yl = y.length();
            if (xl == yl) {
                return x.compareTo(y);
            }
            return xl - yl;
        });

        return unsorted;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.nextLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            s.append(result[i]).append("\n");
        }
        System.out.println(s.toString());
        System.out.println();
        scanner.close();
    }
}

