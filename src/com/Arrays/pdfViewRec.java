package com.Arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class pdfViewRec {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {

        int l = word.length();
        char[] c = word.toCharArray();
        if(l == 0){
            return 0;
        }
        int b = h[c[0] - 97];

        for(int i = 1; i < l; i++){
            if(b < h[c[i] - 97]){
                b = h[c[i] - 97];
            }
        }

        return l*b;
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

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
