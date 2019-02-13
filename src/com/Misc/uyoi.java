package com.Misc;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class uyoi {

    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            arr.add(new ArrayList<>());
        }

        int qCount = queries.size();
        int lastAnswer = 0;
        int seq;
        int ysize;

        for(int i = 0; i < qCount; i++){
            List<Integer> q = queries.get(i);
            seq = (q.get(1)^lastAnswer) % n;
            if(q.get(0) == 1){
                arr.get(seq).add(q.get(2));
            }else{
                ysize = arr.get(seq).size();
                lastAnswer = arr.get(seq).get(q.get(2)%ysize);
                res.add(lastAnswer);
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input/dummy"))));


        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> result = dynamicArray(n, queries);

        for (int i = 0; i < result.size(); i++) {

            System.out.println(String.valueOf(result.get(i)));
            if (i != result.size() - 1) {

                System.out.println("\n");
            }
        }

        System.out.println();
        bufferedReader.close();
    }
}

