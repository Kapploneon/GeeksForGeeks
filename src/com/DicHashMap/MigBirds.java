package com.DicHashMap;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MigBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(int[] ar) {

        Map<Integer, Integer> map = new HashMap<>();

        int size = ar.length;

        for( int i = 0; i < size; i++ ){
            if(map.containsKey(ar[i])){
                map.put(ar[i], map.get(ar[i]) + 1);
            }else{
                map.put(ar[i],1);
            }
        }
        int mapSize = map.size();
        int max = Integer.MIN_VALUE;
        int element = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> entry : map.entrySet() ){
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if(value >= max){
                if(value == max && element > key){
                    element = key;
                    continue;
                }else if(value == max){
                    continue;
                }
                max = value;
                element = key;
            }
        }
        return element;
    }

    private static Scanner scanner = null;

    static {
        try {
            scanner = new Scanner( new FileInputStream(new File("input/dummy")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = migratoryBirds(ar);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}

