package com.stackAndQueue;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class equalStack {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        int h1size = h1.length;
        int h2size = h2.length;
        int h3size = h3.length;

        int total1 = 0;
        int total2 = 0;
        int total3 = 0;

        for(int i = 0; i < h1size; i++){
//                h1[i] = total1 + h1[i];
            total1 += h1[i];
        }

        for(int i = 0; i < h2size; i++){
//                h2[i] = total2 + h2[i];
            total2 += h2[i];
        }

        for(int i = 0; i < h3size; i++){
//                h3[i] = total3 + h3[i];
            total3 += h3[i];
        }


        int min = Math.min(total1, Math.min(total2, total3));
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;

        while(total1 != total2 || total1 != total3) {
            // decrease total2 and total3;
            if (min == total1) {
                if(total2 > min) {
                    total2 -= h2[i2++];
                    if (total2 < min) {
                        min = total2;
                    }
                }

                if(total3 > min){
                    total3 -= h3[i3++];
                    if(total3 < min){
                        min = total3;
                    }
                }
            }

            if (min == total2) {
                if(total1 > min) {
                    total1 -= h1[i1++];
                    if (total1 < min) {
                        min = total1;
                    }
                }

                if(total3 > min){
                    total3 -= h3[i3++];
                    if(total3 < min){
                        min = total3;
                    }
                }
            }

            if (min == total3) {
                if(total1 > min) {
                    total1 -= h1[i1++];
                    if (total1 < min) {
                        min = total1;
                    }
                }

                if(total2 > min){
                    total2 -= h2[i2++];
                    if(total2 < min){
                        min = total2;
                    }
                }
            }

            if(i1 == h1size - 1 || i2 == h2size - 1 || i3 == h3size - 1)
                return 0;
        }
        return total1;

    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        System.out.println(result);
    }
}
