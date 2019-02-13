package com.greedy;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class twoArraysPermut {

    // Complete the twoArrays function below.
    static String twoArrays(int k, int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int sizeA = A.length;
        int i;
        for(i = 0; i < sizeA; i++){
            boolean flag = false;
            for(int j = 0; j < sizeA; j++){
                if(B[j] == -1)
                    continue;
                if(A[i] + B[j] >= k){
                    B[j] = -1;
                    flag = true;
                    break;
                }
            }
            if(!flag)
                return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] A = new int[n];

            String[] AItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(AItems[i]);
                A[i] = AItem;
            }

            int[] B = new int[n];

            String[] BItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            String result = twoArrays(k, A, B);

            System.out.println(result);
        }

        scanner.close();
    }
}
