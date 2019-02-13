package com.stackAndQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class circularPetrolPump
{
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner( new File("input/dummy"));
        int t =sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            String arr[] = str.split(" ");
            int p[] = new int[n];
            int d[] = new int[n];
            int j=0;
            int k=0;
            for(int i=0; i<2*n; i++)
            {
                if(i%2 == 0)
                {
                    p[j]= Integer.parseInt(arr[i]);
                    j++;
                }
                else
                {
                    d[k] = Integer.parseInt(arr[i]);
                    k++;
                }
            }

            System.out.println(new GfG().tour(p,d));
            t--;
        }
    }
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

// In java function tour() takes two arguments array of petrol
// and array of distance
class GfG
{
    int tour(int petrol[], int distance[])
    {
        // Your code here.
        int start = 0;
        int end = 1;
        int n = petrol.length;
        int curr_petrol = petrol[start] - distance[start];

        // If current amount of petrol in truck becomes less than 0, then
        // remove the starting petrol pump from tour
        while(end != start || curr_petrol < 0)
        {

            // If current amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from tour
            while(curr_petrol < 0 && start != end)
            {
                // Remove starting petrol pump. Change start
                curr_petrol -= petrol[start] - distance[start];
                start = (start + 1) % n;

                // If 0 is being considered as start again, then there is no
                // possible solution
                if(start == 0)
                    return -1;
            }
            // Add a petrol pump to current tour
            curr_petrol += petrol[end] - distance[end];

            end = (end + 1)%n;
        }

        // Return starting point
        return start;
    }
}