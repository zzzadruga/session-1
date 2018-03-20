package ru.sbt.jschool.session1;

import java.util.Map;
import java.util.Properties;

public class Task3 {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        for(String property : properties.stringPropertyNames()){
            System.out.println(property + " = " + properties.getProperty(property));
        }
    }
}
