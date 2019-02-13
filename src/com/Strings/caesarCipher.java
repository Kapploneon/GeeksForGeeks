package com.Strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class caesarCipher {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {

        char[] c = s.toCharArray();
        int size = s.length();
        for(int i = 0; i < size; i++){
            if((c[i] >= 65 && c[i] <=90)){
                c[i] += k;
                if(c[i] > 90){
                    c[i] = (char) (c[i] - 26);
                }
            }
            if((c[i] >= 97 && c[i] <= 122)){
                c[i] += k;
                if(c[i] > 122){
                    c[i] = (char) (c[i] - 26);
                }
            }
        }

        return Arrays.toString(c);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
