package com.starv.tbb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.ho.yaml.Yaml;

public class YamlFileUtil {
	
	public static  HashMap<String, HashMap<String, String>>  getYamleFile(String yamlFileName) {
		File f = new File("src/locator/" + yamlFileName + ".yaml");
		try {
			return Yaml.loadType(new FileInputStream(f.getAbsolutePath()),HashMap.class);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("*****************");
		return null;
		
	}
}
