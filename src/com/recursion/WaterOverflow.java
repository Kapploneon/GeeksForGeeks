package com.recursion;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class WaterOverflow
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

        for(int i = 0; i < testCases; i++){
            float kUnit = input.nextFloat();
            int iRow = input.nextInt();
            int jGlass = input.nextInt();

            float[] glass = new float[iRow*(iRow+1)/2];

            // Put all water in first glass
            int index = 0;
            glass[index] = kUnit;

            // Now let the water flow to the downward glasses 
            // till the row number is less than or/ equal to i (given row) 
            // correction : kUnit can be zero for side glasses as they have lower rate to fill
            for (int row = 1; row <= iRow ; ++row)
            {
                // Fill glasses in a given row. Number of 
                // columns in a row is equal to row number
                for (int col = 1; col <= row; ++col, ++index)
                {
                    // Get the water from current glass
                    kUnit = glass[index];

                    // Keep the amount less than or equal to
                    // capacity in current glass
                    glass[index] = (kUnit >= 1.0f) ? 1.0f : kUnit;

                    // Get the remaining amount
                    kUnit = (kUnit >= 1.0f) ? (kUnit - 1) : 0.0f;

                    // Distribute the remaining amount to 
                    // the down two glasses
                    glass[index + row] += kUnit / 2;
                    glass[index + row + 1] += kUnit / 2;
                }
            }

            System.out.println(glass[iRow*(iRow-1)/2 + jGlass - 1]);
        }

    }

}
