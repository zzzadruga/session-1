package ru.sbt.jschool.session1;

import java.util.*;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {}

    public static long binaryToDec(String binary){
        return Long.parseLong(binary, 2);
    }

    public static String sumOfBinary(String b1, String b2){
        return Long.toBinaryString(Long.parseLong(b1, 2) + Long.parseLong(b2, 2));
    }

    public static long[] intersection(long[] arr1, long[] arr2){
        Set<Long> set1 = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.toSet());
        Set<Long> set2 = Arrays.stream(arr2)
                .boxed()
                .collect(Collectors.toSet());
        set1.retainAll(set2);
        return set1.stream()
                .mapToLong(Long::longValue)
                .toArray();
    }
}
