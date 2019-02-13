package com.Graph;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class countLuck {

    static int r;
    static int c;
    static char[][] M;

    // Complete the countLuck function below.
    static String countLuck(String[] matrix, int k) {

        r = matrix.length;
        c = matrix[0].length();
        M = new char[r][c];
        int luck = 0;

        for(int i = 0; i < r; i++){
            M[i] = matrix[i].toCharArray();
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(M[i][j] == 'M'){
                    luck = DFS(i, j, 0);
                }
            }
        }

        if(luck == k){
            return "Impressed";
        }else
            return "Oops!";
    }

    static int DFS(int i, int j, int luck){

        if(i < 0 || j < 0 || i >= r || j >= c){
            return 0;
        }

        if(M[i][j] == 'X' || M[i][j] == '1'){
            return 0;
        }

        if(M[i][j] == '*'){
            return luck;
        }

        M[i][j] = '1';

        int dir = 0;

        if(i - 1 >= 0 && (M[i-1][j] == '.' || M[i-1][j] == '*')){
            dir++;
        }
        if(j - 1 >= 0 && (M[i][j-1] == '.' || M[i][j-1] == '*')){
            dir++;
        }
        if(j + 1 < c && (M[i][j+1] == '.' || M[i][j+1] == '*')){
            dir++;
        }
        if(i + 1 < r && (M[i+1][j] == '.' || M[i+1][j] == '*')){
            dir++;
        }

        if(dir > 1){
            luck++;
        }

        if(dir == 0){
            return 0;
        }

        int temp = 0;

        temp = DFS(i-1,j, luck);
        if(temp > 0){
            return temp;
        }
        temp = DFS(i,j-1, luck);
        if(temp > 0){
            return temp;
        }
        temp = DFS(i,j+1, luck);
        if(temp > 0){
            return temp;
        }
        temp = DFS(i+1,j, luck);
        if(temp > 0){
            return temp;
        }

        return temp;
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            String[] matrix = new String[n];

            for (int i = 0; i < n; i++) {
                String matrixItem = scanner.nextLine();
                matrix[i] = matrixItem;
            }

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = countLuck(matrix, k);

            System.out.println(result);
        }

        scanner.close();
    }
}
