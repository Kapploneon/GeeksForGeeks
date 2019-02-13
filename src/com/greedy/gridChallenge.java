package com.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class gridChallenge {

    // Complete the gridChallenge function below.
    static String gridChallenge(String[] grid) {

        int size = grid.length;
        int columnSize = grid[0].length();

        char[][] cx = new char[size][columnSize];

        for(int i = 0; i < size; i++){
            char[] c = grid[i].toCharArray();
            Arrays.sort(c);
            cx[i] = c;
        }

        for(int i = 0; i < columnSize; i++){
            for(int j = 1; j < size; j++){
                if(cx[j][i] < cx[j-1][i]){
                    return "NO";
                }
            }
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] grid = new String[n];

            for (int i = 0; i < n; i++) {
                String gridItem = scanner.nextLine();
                grid[i] = gridItem;
            }

            String result = gridChallenge(grid);

            System.out.println(result);
        }

        scanner.close();
    }
}
