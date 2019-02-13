package com.Arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class stockBuySell {
    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader input = null;
        try {
            input = new BufferedReader(new InputStreamReader( new FileInputStream("input/dummy")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int testCases = Integer.parseInt(input.readLine());
        for(int i = 0; i < testCases; i++){
            int numbers = Integer.parseInt(input.readLine());
            int[] array = new int[numbers];

            array = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            maxInterval(array);

            System.out.println();
        }
}

    static void maxInterval(int[] array){
        int size = array.length;
        int buy = 0;
        int i;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        Iterator<Integer> iti = list.listIterator(list.size());

        ((ListIterator<Integer>) iti).hasPrevious();
        ((ListIterator<Integer>) iti).previous();

        for(i = 0; i < size - 1; i++){
            if(array[i] < array[i + 1]){
                continue;
            }
            if((i - buy) > 0){
                System.out.print("("+buy+ " "+i+") ");
            }
            buy = i+1;
        }

        if((i - buy) > 0){
            System.out.print("("+buy+ " "+i+") ");
        }
    }
}