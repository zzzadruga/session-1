package ru.sbt.jschool.session1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Task4 {
    public static void main(String[] args) {
        if ((args.length != 0) && (args[0].startsWith("JSCHOOl1_COUNT="))){
            printHelloWorld(Integer.parseInt(parseProperty(args[0]))); return;
        }
        if (System.getenv().containsKey("JSCHOOl1_COUNT")){
            printHelloWorld(Integer.parseInt(System.getenv().get("JSCHOOl1_COUNT"))); return;
        }
        if (System.getProperties().contains("JSCHOOl1_COUNT")){
            printHelloWorld(Integer.parseInt(System.getProperties().getProperty("JSCHOOl1_COUNT"))); return;
        }
        if ((args.length != 0) && (args[0].startsWith("JSCHOOL1_PROPERTIES_FILE="))){
            Path pathToPropertyFile = Paths.get(parseProperty(args[0]));
            Properties properties = new Properties();
            try(FileInputStream fileInputStream = new FileInputStream(pathToPropertyFile.toFile())){
                properties.load(fileInputStream);
                if (properties.contains("JSCHOOl1_COUNT")){
                    printHelloWorld(Integer.parseInt(properties.getProperty("JSCHOOl1_COUNT"))); return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Если передан параметр вида JSCHOOl1_COUNT=XXX, где XXX число раз, то используется оно. \n" +
                " Если передана системная настройка вида JSCHOOl1_COUNT=XXX, где XXX число раз, то используется оно. \n" +
                " Если определена переменная окружения вида JSCHOOl1_COUNT=XXX, где XXX число раз, то используется оно. \n" +
                " Если определена переменная окружения вида JSCHOOL1_PROPERTIES_FILE=XXX, где XXX это путь к существующему файлу, то загружаем настройки оттуда и пытаемся получить настройку оттуда");

    }

    private static String parseProperty(String property){
        return property.substring(property.indexOf('=') + 1);
    }

    private static void printHelloWorld(int count){
        for(int i = 0; i < count; i++){
            System.out.println("Hello, World!");
        }
    }

}
