package com.starv.tbb.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLFileUtil {
	
	public static HashMap<String ,HashMap<String ,String>> toHashMap(String fileName){
		if(fileName!=null) {	
			HashMap<String ,HashMap<String ,String>> map = new HashMap<String ,HashMap<String ,String>>(); 
			Document document = null;			
			SAXReader saxReader = new SAXReader();
			try {
			document = saxReader.read(new File(fileName));					
			}catch (DocumentException e) {
				e.printStackTrace();
			}
			Element scenarios = document.getRootElement();			
			for (Iterator<?> i = scenarios.elementIterator(); i.hasNext();) {
				Element scenario = (Element) i.next();	
				HashMap<String, String> tempMap = new HashMap<String, String>();
				for (Iterator<?> j = scenario.elementIterator(); j.hasNext();) {
					Element parameters = (Element) j.next();				
					for (Iterator<?> k = parameters.elementIterator(); k.hasNext();) {
						Element parameter = (Element) k.next();						
						tempMap.put(parameter.attributeValue("name"), parameter.attributeValue("value"));
					}					
				}
				map.put(scenario.attributeValue("name"), tempMap);
			}
			return map;
		}
		return null;
	}	
	public static Object[][] array2D(String fileName){
		HashMap<String ,HashMap<String ,String>> map = XMLFileUtil.toHashMap(fileName);
		Object[][] result = new Object[map.size()][];
		Iterator<?> iter = map.entrySet().iterator();
		int foot = 0;
		while(iter.hasNext()) {
			Map.Entry entry = (Map.Entry)iter.next();
			result[foot] = new Object[]{entry.getValue()};
			foot ++;
		}
        return result;
				
	}	
		
}
