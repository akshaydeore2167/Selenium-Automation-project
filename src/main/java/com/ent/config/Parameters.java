package com.ent.config;

import java.util.ResourceBundle;

public class Parameters {
    public static final ResourceBundle config = ResourceBundle.getBundle("testconfig");
    public static String get(String key){
        return config.getString(key);
    }

}

