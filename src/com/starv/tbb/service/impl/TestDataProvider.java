package com.starv.tbb.service.impl;

import com.starv.tbb.service.TestDataServ;
import com.starv.tbb.util.XMLFileUtil;

public class TestDataProvider implements TestDataServ {

	
	public  Object[][] getDatas(String dataFile){
		return XMLFileUtil.array2D(dataFile);
	}		

}
