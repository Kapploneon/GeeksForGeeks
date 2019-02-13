package com.bitManipulation;

public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        char[] c=Integer.toString(x^y).toCharArray();
        int n=0;
        for(char d:c){
            if(d=='1') n++;
        }
        return n;
    }

    public static void main(String arg[]){

        for( int i = 10; i > 0; i--)
            System.out.println(i+ " -> "+(i & 1));
    }
}