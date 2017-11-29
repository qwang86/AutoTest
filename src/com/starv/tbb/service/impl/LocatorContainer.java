package com.starv.tbb.service.impl;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.starv.tbb.base.WebDriverFactory;
import com.starv.tbb.service.LocatorContainerServ;
import com.starv.tbb.util.WebDriverUtil;
import com.starv.tbb.util.YamlFileUtil;

public class LocatorContainer implements LocatorContainerServ {
	
	private String fileName;
	private HashMap<String, HashMap<String, String>> locatorMap;
	public static WebDriver driver  = WebDriverFactory.getDriverInstance();
	
	public LocatorContainer(String fileName) {
		setFileName(fileName) ;
		this.locatorMap = YamlFileUtil.getYamleFile(fileName);
	}
	
	public WebElement getElement(String key) {
		if (key !=null) {
			String type = locatorMap.get(key).get("type");
			String value = locatorMap.get(key).get("value");
			return driver.findElement(WebDriverUtil.getBy(type,value));
		}
		return null;				
	}
	
	public void setElementValue(String key, String value) {
		this.getElement(key).sendKeys(value);
	}
	public void clickElement(String key) {
		this.getElement(key).click();
	}
	public void clearElement(String key) {
		this.getElement(key).clear();
	}

	public String getFileName() {
		return fileName;
	}

	private void setFileName(String fileName) {
		this.fileName = fileName;
	}


	@Override
	public boolean isElementExist(WebElement element) {
		// TODO Auto-generated method stub
		return false;
	}
}
