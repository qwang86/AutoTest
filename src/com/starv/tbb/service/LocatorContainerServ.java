package com.starv.tbb.service;

import org.openqa.selenium.WebElement;

public interface LocatorContainerServ {
	
	public WebElement getElement(String key);
	public void setElementValue(String key, String value);
	public void clickElement(String key);
	public void clearElement(String key);
	public boolean isElementExist(WebElement element);

}
