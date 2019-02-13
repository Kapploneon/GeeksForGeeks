package com.recursion;

import java.util.*;
import java.lang.*;
import java.io.*;

    /* By Kapple */

class SpecialKeyboard
{
    public static void main (String[] args)
    {
        //code
        // Read file.
        Scanner input = null;
        try {
            input = new Scanner(new File("input/dummy"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int testCases = input.nextInt();
        int key;
        long result;

        for(int i = 0; i < testCases; i++){
            key = input.nextInt();
//            result = findoptimal_recursive(key);
            result = findoptimal_dynamic(key);
            System.out.println(result);
        }

    }

    // A recursive function that returns
    // the optimal length string  for N keystrokes
    static int findoptimal_recursive(int key){
        // The optimal string length is N
        // when N is smaller than 7
        if (key <= 6)
            return key;

        // Initialize result
        int max = 0;

        // TRY ALL POSSIBLE BREAK-POINTS
        // For any keystroke N, we need to
        // loop from N-3 keystrokes back to
        // 1 keystroke to find a breakpoint
        // 'b' after which we will have Ctrl-A,
        //  Ctrl-C and then only Ctrl-V all the way.
        int b;
        for (b = key - 3; b >= 1; b--)
        {
            // If the breakpoint is s at b'th
            // keystroke then the optimal string
            // would have length
            // (n-b-1)*screen[b-1];
            int curr = (key - b - 1) * findoptimal_recursive(b);
            if (curr > max)
                max = curr;
        }
        return max;
    }

    // this function returns the optimal
    // length string for N keystrokes
    static int findoptimal_dynamic(int N)
    {
        // The optimal string length is N
        // when N is smaller than 7
        if (N <= 6)
            return N;

        // An array to store result
        // of subproblems
        int screen[] = new int[N];

        int b; // To pick a breakpoint

        // Initializing the optimal lengths
        // array for uptil 6 input strokes
        int n;
        for (n = 1; n <= 6; n++)
            screen[n - 1] = n;

        // Solve all subproblems in bottom manner
        for (n = 7; n <= N; n++)
        {
            // Initialize length of optimal
            // string for n keystrokes
            screen[n - 1] = 0;

            // For any keystroke n, we need
            // to loop from n-3 keystrokes
            // back to 1 keystroke to find
            // a breakpoint 'b' after which we
            // will have ctrl-a, ctrl-c and
            // then only ctrl-v all the way.
            for (b = n - 3; b >= 1; b--)
            {
                // if the breakpoint is
                // at b'th keystroke then
                // the optimal string would
                // have length
                // (n-b-1)*screen[b-1];
                int curr = (n - b - 1) * screen[b - 1];
                if (curr > screen[n - 1])
                    screen[n - 1] = curr;
            }
        }

        return screen[N - 1];
    }

}