package com.starv.tbb.testcase;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.starv.tbb.service.LocatorContainerServ;

public class LoginTest extends TestCase{
	private static Logger logger = Logger.getLogger(LoginTest.class) ;
	private LocatorContainerServ locator = loadLocator("loginPage") ;

	
	@Test(dataProvider = "dataProvider")
	public void loginData(HashMap<String,String> params) {	
		logger.info("start auto test :" + LoginTest.class.getSimpleName());
		driver.get(params.get("url"));		
		locator.setElementValue("userN_input", params.get("userName"));
		locator.setElementValue("passwd_input", params.get("passwd"));
		locator.setElementValue("validcode_input", "15taobobo");
		locator.clickElement("login_button");
  }

}
