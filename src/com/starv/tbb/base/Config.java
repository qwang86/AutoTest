package com.starv.tbb.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {	
	private static Properties props;
	
	public static void loadConfig() {		
        props = new Properties();
        InputStream in = null;
        try {
        	in = new FileInputStream("config/config.properties");
            //in = PropertyUtil.class.getClassLoader().getResourceAsStream("config/setting.properties");
            props.load(in);
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {

            }
        }

	}
	
    public static String getProperty(String key){
        if(null == props) {        	
        	loadConfig();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
        	loadConfig();
        }
        return props.getProperty(key, defaultValue);
    }
}
