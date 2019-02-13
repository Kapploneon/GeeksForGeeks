package com.recursion;

/*package whatever //do not write package name here */
import java.util.*;
import java.lang.*;
import java.io.*;

public class FloodFillAlgorithm {

    static int m,n;
    public static void main (String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("input/FloodFillAlgorithm.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int t = sc.nextInt();
        //System.out.print("Test Cases:"+t);
        for(int i=0;i<t;i++)
        {
            n =sc.nextInt();
            m =sc.nextInt();
            //System.out.print("m:"+m);
            int[][] a = new int[n][m];

            for(int j=0;j<n;j++)
            {
                for(int k=0;k<m;k++)
                {
                    a[j][k]=sc.nextInt();
                }
            }
            int x =sc.nextInt();
            int y =sc.nextInt();
            int k =sc.nextInt();


            recur(a,k,x,y,a[x][y]);
            for(int j=0;j<n;j++)
            {
                for( k=0;k<m;k++)
                {
                    System.out.print(a[j][k]+" ");
                }
            }
            System.out.println();
        }

    }

    static void recur(int[][] b,int k,int x,int y,int f)
    {
        if(x<n && y<m  && x>=0 && y>=0 )
        {
            if(b[x][y]==f){
                b[x][y]=k;
            }else{
                return;
            }
            recur(b,k,x+1,y,f);
            recur(b,k,x-1,y,f);
            recur(b,k,x,y+1,f);
            recur(b,k,x,y-1,f);
        }
        return;

    }

}
