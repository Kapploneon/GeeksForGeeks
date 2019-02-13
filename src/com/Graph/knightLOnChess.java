package com.Graph;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class knightLOnChess {

    static int[][] res;

    // Complete the knightlOnAChessboard function below.
    static int[][] knightlOnAChessboard(int n) {

        res = new int[n-1][n-1];

        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                if(res[i-1][j-1] != 0){
                    continue;
                }
                // Apply BFS for ij.
                // int s = chess[i][j];
                res[i-1][j-1] = BFS(i, j, n);
            }
        }
        return res;
    }

    static class Node{
        int i;
        int j;
        boolean flag;
        Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    static int BFS(int i, int j, int n){
        int[][] chess = new int[n][n];
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0));
        chess[0][0] = 1;
        Node special = new Node(0,0);
        special.flag = true;
        q.add(special);
        int count = 0;
        boolean flag = false;

        while(!q.isEmpty()){
            Node x = q.remove();

            if(x.i == n-1 && x.j == n-1){
                flag = true;
                break;
            }

            if(x.i + i < n && x.j + j < n && chess[x.i + i][x.j + j] != 1){
                q.add(new Node(x.i + i, x.j + j));

                chess[x.i + i][x.j + j] = 1;
            }
            if(x.i + j < n && x.j + i < n && chess[x.i + j][x.j + i] != 1){
                q.add(new Node(x.i + j, x.j + i));
                chess[x.i + j][x.j + i] = 1;
            }
            if(x.i + i < n && x.j - j >= 0 && chess[x.i + i][x.j - j] != 1){
                q.add(new Node(x.i + i, x.j - j));
                chess[x.i + i][x.j - j] = 1;
            }
            if(x.i + j < n && x.j - i >= 0 && chess[x.i + j][x.j - i] != 1){
                q.add(new Node(x.i + j, x.j - i));
                chess[x.i + j][x.j - i] = 1;
            }
            if(x.i - i >= 0 && x.j - j >= 0 && chess[x.i - i][x.j - j] != 1){
                q.add(new Node(x.i - i, x.j - j));
                chess[x.i - i][x.j - j] = 1;
            }
            if(x.i - j >= 0 && x.j - i >= 0 && chess[x.i - j][x.j - i] != 1){
                q.add(new Node(x.i - j, x.j - i));
                chess[x.i - j][x.j - i] = 1;
            }
            if(x.i - i >= 0 && x.j + j < n && chess[x.i - i][x.j + j] != 1){
                q.add(new Node(x.i - i, x.j + j));
                chess[x.i - i][x.j + j] = 1;
            }
            if(x.i - j >= 0 && x.j + i < n && chess[x.i - j][x.j + i] != 1){
                q.add(new Node(x.i - j, x.j + i));
                chess[x.i - j][x.j + i] = 1;
            }

            if(!q.isEmpty() && q.peek().flag == true){
                count++;
                q.add(q.remove());
            }
        }

        if(flag){
            return count;
        }else{
            return -1;
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] result = knightlOnAChessboard(n);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(String.valueOf(result[i][j]));

                if (j != result[i].length - 1) {
                    System.out.print(" ");
                }
            }

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();

        scanner.close();
    }
}
