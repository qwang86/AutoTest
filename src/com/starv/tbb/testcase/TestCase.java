package com.starv.tbb.testcase;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.starv.tbb.base.Config;
import com.starv.tbb.base.WebDriverFactory;
import com.starv.tbb.service.LocatorContainerServ;
import com.starv.tbb.service.TestDataServ;
import com.starv.tbb.service.impl.LocatorContainer;
import com.starv.tbb.service.impl.TestDataProvider;

public abstract class TestCase{

	public static WebDriver driver ;
	private static Logger logger = Logger.getLogger(TestCase.class) ;
	private TestDataServ testdata = new TestDataProvider();
	{
		//System.setProperty("log4j.configuration", "config/log4j.properties");
		PropertyConfigurator.configure(new File("config/log4j.properties").getAbsolutePath());
	}
	
	private void loadDriver() {	
		if (null == driver) {
		driver = WebDriverFactory.getDriverInstance();
		driver.manage().window().maximize();
		logger.info("加载driver完成");
		}
	}
//	@BeforeTest(alwaysRun = true)
	public LocatorContainerServ loadLocator(String FileName) {
		return  new LocatorContainer(FileName);
	}
	
//	public void setLocatorName(String locatorName){
//		this.locatorName = locatorName;
//	}
	
	@BeforeSuite(alwaysRun = true)
	public void setUp() {
		loadDriver();
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
	
	@DataProvider
	public  Object[][] dataProvider(Method method){		
		String fileName = method.getName();
		String filePath = Config.getProperty("dataFilePath") + fileName +
							Config.getProperty("dataFileFormat");
		return testdata.getDatas(filePath);
	}
}
