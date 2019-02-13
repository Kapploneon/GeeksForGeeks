package com.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class jimOrders {

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int size = orders.length;

        for(int i = 0; i < size; i++){
            int t = orders[i][0] + orders[i][1];
            if(map.containsKey(t)){
                map.get(t).add(i);
            }
            else{
                List<Integer> x = new ArrayList<>();
                x.add(i);
                map.put(t, x);
            }
        }

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(map);
        int[] res = new int[size];

        int i = 0;
        for( Map.Entry<Integer,List<Integer>> ele : treeMap.entrySet()){
            List<Integer> x = ele.getValue();
            for(Integer elem : x){
                res[i++] = elem + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        scanner.close();
    }
}
