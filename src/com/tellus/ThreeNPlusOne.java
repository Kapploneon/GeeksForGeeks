package com.tellus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ThreeNPlusOne {

    private static Scanner scanner = null;

    static {
        try {
            scanner = new Scanner( new FileInputStream(new File("input/dummy")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int maximumCycleLength(int minN, int maxN) {
        int maxCycleLength = 0;
        for (; minN <= maxN; minN++) {
            maxCycleLength = Math.max(maxCycleLength, cycleLength(minN));
        }
        return maxCycleLength;
    }

    public static int cycleLength(int n) {
        int cycles = 1;
        while (n != 1) {
            n = (n % 2 == 0) ? n / 2 : 3*n + 1;
            cycles += 1;
        }
        return cycles;
    }

    public static void main(String[] args) throws IOException {

        int n =scanner.nextInt();

        for(int i = 0; i < n; i++){
            int min = scanner.nextInt();
            int max = scanner.nextInt();

            int result = maximumCycleLength(min, max);

            System.out.println(min + " " + max + " " + result);
        }
    }
}

