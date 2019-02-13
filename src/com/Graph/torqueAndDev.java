package com.Graph;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class torqueAndDev {

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

        List<Set<Integer>> glist = new ArrayList<>();

        int size = cities.length;

        Set<Integer> tlist = new HashSet<>();
        Set<Integer> cset = new HashSet<>();

        for(int i = 1; i <= n; i++){
            cset.add(i);
        }

        if(size > 0){

            tlist.add(cities[0][0]);
            tlist.add(cities[0][1]);
            glist.add(tlist);

//            Set<Integer> toMerge = null;

            for(int i = 0; i < size; i++){
                int a = cities[i][0];
                int b = cities[i][1];
                boolean found = false;
                int gsize = glist.size();
                Set<Integer> toMerge = null;

                for(int j = 0; j < gsize; j++){
                    Set<Integer> dlist = glist.get(j);

                    if(dlist.contains(a) && !found){
                        dlist.add(b);
                        cset.remove(b);
                        found = true;
                        toMerge = dlist;
                        continue;
//                        break;
                    }
                    if(dlist.contains(b) && !found){
                        dlist.add(a);
                        cset.remove(a);
                        found = true;
                        toMerge = dlist;
                        continue;
//                        break;
                    }

                    if((dlist.contains(a) || dlist.contains(b)) && found){
                        // merge all the elements of this list to the previous list.
                        toMerge.addAll(dlist);
                        // remove this list
                        glist.remove(j);
                        break;
                    }

                }

                if(!found){
                    Set<Integer> temp = new HashSet<>();
                    temp.add(a);
                    temp.add(b);
                    cset.remove(a);
                    cset.remove(b);
                    glist.add(temp);
                }
            }

            if(c_lib > c_road){

                int cs = cset.size();
                if(cs == 0)
                    cs = 1;

                long cost = (long)glist.size()*(long)c_lib*(long)cs;

                for(int i = 0; i < glist.size(); i++){
                    Set<Integer> temp = glist.get(i);

                    cost += (long)(temp.size() - 1)*(long)c_road;
                }
                return cost;
            }

            return (long)n*(long)c_lib;
        }

        int cs = cset.size();
        if(cs == 0)
            cs = 1;

        // case with no roads.
        long cost = (long)c_lib*(long)cs;

        for(int i = 0; i < glist.size(); i++){
            Set<Integer> temp = glist.get(i);

            cost += (long)(temp.size() - 1)*(long)c_road;
        }
        return cost;


    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            System.out.println(result);
        }

        scanner.close();
    }
}
