package com.Search;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class minLoss {

    // Complete the minimumLoss function below.
    static int minimumLoss(long[] price) {

        int size = price.length;
        long min = Long.MAX_VALUE;

        HashMap<Long, Integer> map = new HashMap<>();

        for(int i = 0; i < size; i++){
            map.put(price[i], i);
        }

        TreeMap<Long, Integer> treeMap = new TreeMap<>(map);

        long prev = -1;
        int prevIndex = 0;
        long temp;
        for(Map.Entry<Long,Integer> ele : treeMap.entrySet()){
            if(prev != -1){
                if(prevIndex > ele.getValue()){
                    temp = ele.getKey() - prev;
                    if(temp > 0 && temp < min){
                        min = temp;
                    }
                }
            }
            prev = ele.getKey();
            prevIndex = ele.getValue();
        }

        return (int)min;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] price = new long[n];

        String[] priceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceItems[i]);
            price[i] = priceItem;
        }

        int result = minimumLoss(price);

        System.out.println(result);

        scanner.close();
    }
}
