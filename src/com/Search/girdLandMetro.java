package com.Search;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class girdLandMetro {

    // Complete the gridlandMetro function below.
    static long gridlandMetro(long n, long m, int k, int[][] track) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        long totalcells = n*m;

        for(int i = 0; i < k; i++){
            int r = track[i][0];
            int lstart = track[i][1];
            int lend = track[i][2];

            if(map.containsKey(r)){
                List<Integer> list = map.get(r);
                boolean flag = false;

                for(int li = 0; li < list.size(); li += 2){
                    int dstart = list.get(li);
                    int dend = list.get(li + 1);
                    if(lstart <= dstart && lend > dstart && lend <= dend){
                        list.set(li, lstart);
                        flag = true;
                        break;
                    }
                    if(lstart <= dstart && lend >= dend){
                        list.set(li, lstart);
                        list.set(li + 1, lend);
                        flag = true;
                        break;
                    }
                    if(lstart >= dstart && lend <= dend){
                        // Do nothing.
                        flag = true;
                        break;
                    }
                    if(lstart >= dstart && lstart <= dend && lend >= dend){
                        list.set(li + 1, lend);
                        flag = true;
                        break;
                    }
                }

                // If no overlapping found then just add the new track.
                if(!flag){
                    list.add(lstart);
                    list.add(lend);
                }

                // put the updated list back;
//                map.put(r, list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(lstart);
                list.add(lend);
                map.put(r,list);
            }

        }

        for(Map.Entry<Integer, List<Integer>> ele : map.entrySet()){
            List<Integer> list = ele.getValue();
            Iterator<Integer> iterator = list.iterator();

            while(iterator.hasNext()){
                long cstart = iterator.next();
                long cend = iterator.next();
                long temp = ((cend - cstart) + 1);
                totalcells -= temp;
            }
        }

        return totalcells;

    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        String[] nmk = scanner.nextLine().split(" ");

        long n = Long.parseLong(nmk[0]);

        long m = Long.parseLong(nmk[1]);

        int k = Integer.parseInt(nmk[2]);

        int[][] track = new int[k][3];

        for (int i = 0; i < k; i++) {
            String[] trackRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int trackItem = Integer.parseInt(trackRowItems[j]);
                track[i][j] = trackItem;
            }
        }

        long result = gridlandMetro(n, m, k, track);

        System.out.println(result);

        scanner.close();
    }
}

