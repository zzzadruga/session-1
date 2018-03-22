package ru.sbt.jschool.session1;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Property implements PropertyHelper{
    private String[] args;
    private String path;

    public Property(String[] args, String path){
        this.args = args;
        this.path = path;
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
        if ((property = getPropertyFromEnv(name)) != null) {
            return property;
        }
        if ((property = getPropertyFromProperties(name)) != null) {
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

    private String getPropertyFromEnv(String name){
        return System.getenv().get(name);
    }

    private String getPropertyFromProperties(String name){
        Path pathToPropertyFile = Paths.get(path);
        try(FileInputStream fileInputStream = new FileInputStream(pathToPropertyFile.toFile())){
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties.getProperty(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
