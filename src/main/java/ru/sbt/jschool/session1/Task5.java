package ru.sbt.jschool.session1;

import java.util.*;

public class Task5 {
    public static void main(String[] args) {}

    public static long binaryToDec(String binary){
        return Long.parseLong(binary, 2);
    }

    public static String sumOfBinary(String b1, String b2){
        return Long.toBinaryString(Long.parseLong(b1, 2) + Long.parseLong(b2, 2));
    }

    public static long[] intersection(long[] arr1, long[] arr2){
        if (arr1.length > arr2.length){
            long[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        HashSet<Long> set = new HashSet<>();
        Arrays.sort(arr1);
        for (long key : arr2) {
            if (Arrays.binarySearch(arr1, key) >= 0){
                set.add(key);
            }
        }
        long[] result = new long[set.size()];
        int i = 0;
        for(long l : set){
            result[i++] = l;
        }
        return result;
    }
}
