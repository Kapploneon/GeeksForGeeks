package com.sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class countingSort  {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        HashMap<Integer, StringBuilder> map = new HashMap<>();

        for (int nItr = 0; nItr < n; nItr++) {
            String[] xs = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xs[0]);

            if(nItr+1 <= n/2){
                if(map.containsKey(x)){
                    map.put(x, map.get(x).append(" ").append("-"));
                }else{
                    map.put(x,new StringBuilder("-"));
                }
            }else{
                if(map.containsKey(x)){
                    map.put(x, map.get(x).append(" ").append(xs[1]));
                }else{
                    map.put(x,new StringBuilder(xs[1]));
                }
            }

        }

        TreeMap<Integer, StringBuilder> treeMap = new TreeMap<>(map);

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, StringBuilder> ele : treeMap.entrySet()){
            sb.append(ele.getValue()).append(" ");
        }

        System.out.println(sb.toString());

        scanner.close();
    }
}

