package com.starv.tbb.testcase;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.starv.tbb.service.LocatorContainerServ;

public class BaiduTest extends TestCase{
	private static Logger logger = Logger.getLogger(BaiduTest.class) ;
	private LocatorContainerServ locator = loadLocator("BaiduPage") ;

	
	@Test(dataProvider = "dataProvider")
	public void testBaidu(HashMap<String,String> params) {	
		logger.info("start auto test :" + BaiduTest.class.getSimpleName());		
		logger.info(params.toString());
		driver.get(params.get("url"));		
		locator.setElementValue("kW_input", params.get("kw"));
		locator.clickElement("search_button");
		logger.info("完成测试");
		
  }
}
