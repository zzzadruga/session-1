package ru.sbt.jschool.session1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property implements PropertyHelper{
    private String[] args;
    private Properties properties;

    public Property(String[] args, String path){
        this.args = args;
        properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream(new File(path))){
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String stringValue(String name) {
        if (name == null || name.isEmpty()){
            return null;
        }
        String property;
        if ((property = getPropertyFromArgs(name)) != null) {
            return property;
        }
        if ((property = System.getenv().get(name)) != null) {
            return property;
        }
        if ((property = properties.getProperty(name)) != null) {
            return property;
        }
        return null;
    }

    @Override
    public Integer integerValue(String name) {
        try {
            return Integer.parseInt(stringValue(name));
        } catch (Exception e){
            System.out.println("Property не относится к типу данных Integer");
        }
        return null;
    }

    @Override
    public Double doubleValue(String name) {
        try {
            return Double.parseDouble(stringValue(name));
        } catch (Exception e){
            System.out.println("Property не относится к типу данных Double");
        }
        return null;
    }

    private String getPropertyFromArgs(String name){
        for(String arg : args){
            if (arg.startsWith(name)){
                return arg.substring(arg.indexOf('=') + 1);
            }
        }
        return null;
    }
}
