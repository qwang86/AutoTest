package com.starv.tbb.base;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {

	public static WebDriver driver;
	
	public static WebDriver getDriverInstance() {
		if(null == driver ) {
			driver = getDriverInstance(Config.getProperty("webDriver"));
		}
		return driver;
	}
	
	public static WebDriver getDriverInstance(String driverName) {
		if ("chrome".equals(driverName)) {
			return  getDriverInstance(Browser.CHROME) ;
		}
		if ("firefox".equals(driverName)) {
			return getDriverInstance(Browser.FIREFOX) ;
		}
		if ("ie".equals(driverName)) {
			return getDriverInstance(Browser.IE) ;
		}
		if ("html".equals(driverName)) {
			return getDriverInstance(Browser.HTML) ;
		}
		if ("safari".equals(driverName)) {
			return getDriverInstance(Browser.SAFARI) ;
		}
		return null;
	}
	
	public static WebDriver getDriverInstance(Browser browser) {
		switch(browser) {
		case CHROME:
			return getChromeDriver() ;
		case FIREFOX:
			return null ;
		case IE:
			return null ;
		case HTML:
			return null ;
		case SAFARI:
			return null ;
		}
		return getChromeDriver();	
	}
	
	@SuppressWarnings("deprecation")
	private static WebDriver getChromeDriver() {
        try {  
            if (!System.getProperties().containsKey("webdriver.chrome.driver")) {  
                System.setProperty(Config.getProperty("driver"), Config.getProperty("dirverPath"));  
            }  
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();  
            capabilities.setCapability("chrome.switches",Arrays.asList("--incognito"));           
            ChromeOptions options = new ChromeOptions();  
            options.addArguments("--test-type");  
            capabilities.setCapability("chrom.binary","src/ucBrowserDrivers/chromedriver.exe");  
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);  
            if (System.getProperties().containsKey("webdriver.chrome.profile")) {  
                options.addArguments(new String[] { "user-data-dir="  
                        + System.getProperty("webdriver.chrome.profile") });  
            }  
            options.addArguments(new String[] { "start-maximized" });  
            return new ChromeDriver(capabilities);  
        } catch (Exception e) {  
            e.getStackTrace();  
        }    
        return null; 
	}
	
}
