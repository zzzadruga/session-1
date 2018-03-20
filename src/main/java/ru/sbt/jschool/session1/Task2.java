package ru.sbt.jschool.session1;

import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        for(Map.Entry<String, String> env : System.getenv().entrySet()){
            System.out.println(env.getKey() + " = " + env.getValue());
        }
        System.out.println(System.getenv().containsKey("JSCHOOl1_COUNT"));
    }
}
