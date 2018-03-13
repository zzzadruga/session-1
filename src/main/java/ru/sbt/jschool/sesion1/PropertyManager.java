package ru.sbt.jschool.sesion1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 */
public class PropertyManager {
    private String[] args;

    public PropertyManager(String[] args) {
        this.args = args;
    }

    public String value(String name) {
        String val = fromArgs(name);

        if (val != null)
            return val;

        val = fromSys(name);

        if (val != null)
            return val;

        val = fromEnv(name);

        if (val != null)
            return val;

        return fromPropFile(name);
    }

    private String fromArgs(String name) {
        for (String arg : args) {
            if (arg.startsWith(name + "="))
                return arg.replace(name + "=", "");
        }

        return null;
    }

    private String fromSys(String name) {
        return System.getProperty(name);
    }

    private String fromEnv(String name) {
        return System.getenv(name);
    }

    private String fromPropFile(String name) {
        String path = System.getenv("JSCHOOL1_PROPERTIES_FILE");

        if (path == null)
            return null;

        try {
            Properties props = new Properties();

            props.load(new FileInputStream(path));

            return props.getProperty(name);
        }
        catch (IOException e) {
            e.printStackTrace();

            return null;
        }

    }
}
