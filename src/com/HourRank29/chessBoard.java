package com.HourRank29;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class chessBoard {

    // Complete the solve function below.
    // static String solve(List<List<Integer>> board) {
    static String solve(int[][] board) {
        int l = board.length;

        for(int i = 0; i < l; i++){
            for(int j = 0; j < l; j++){
                if(i+1 < l){
                    if(board[i+1][j] == board[i][j]){
                        return "No";
                    }
                }
                // if(i-1 > l){
                //     if(board[i-1][j] == board[i][j]){
                //         return "No";
                //     }
                // }
                if(j+1 < l){
                    if(board[i][j+1] == board[i][j]){
                        return "No";
                    }
                }
                // if(j-1 < l){
                //     if(board[i][j-1] == board[i][j]){
                //         return "No";
                //     }
                // }
            }
        }

        return "Yes";

    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for(int loop = 0; loop < t; loop++){

            try {
                int n = scanner.nextInt();

                int[][] board = new int[n][n];

                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        board[i][j] = scanner.nextInt();
                    }
                }

                //List<List<Integer>> board = new ArrayList<>();

                // IntStream.range(0, n).forEach(i -> {
                //     try {
                //         board.add(
                //             Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                //                 .map(Integer::parseInt)
                //                 .collect(toList())
                //         );
                //     } catch (IOException ex) {
                //         throw new RuntimeException(ex);
                //     }
                // });

                String result = solve(board);

                System.out.println(result);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };

    }
}

