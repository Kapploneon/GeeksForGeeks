package com.Graph;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ConnectedCell {

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {

        int r = matrix.length;
        if(r == 0)
            return 0;
        int c = matrix[0].length;
        int max = 0;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(matrix[i][j] == 1){
                    int temp = DFS(i, j, matrix, r, c);
                    if(temp > max){
                        max = temp;
                    }
                }
            }
        }

        return max;
    }

    static int DFS(int i, int j, int[][] matrix, int r, int c){

        if(i >= r || j >= c || i < 0 || j < 0){
            return 0;
        }

        if(matrix[i][j] == 1){
            matrix[i][j] = 0;
            return 1 + DFS(i+1, j-1, matrix, r, c) + DFS(i+1, j, matrix, r, c) + DFS(i+1, j+1, matrix, r, c) + DFS(i, j+1, matrix, r, c) + DFS(i, j-1, matrix, r, c) + DFS(i-1, j-1, matrix, r, c) + DFS(i-1, j, matrix, r, c) + DFS(i-1, j+1, matrix, r, c);
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}

