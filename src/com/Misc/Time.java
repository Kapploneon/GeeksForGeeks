package com.Misc;

import java.io.*;

public class Time {
    public static void main(String[] args)
    {
        // starting time
        long start = System.currentTimeMillis();

        // start of function

        count_function(10000000);

        // end of function

        // ending time
        long end = System.currentTimeMillis();
        System.out.println("Counting to 10000000 takes " +
                (end - start) + "ms");
    }

    // A dummy function that runs a loop x times
    public static void count_function(long x)
    {
        System.out.println("Loop starts");
        for (long i = 0; i < x; i++)
            ;
        System.out.println("Loop ends");
    }
}
