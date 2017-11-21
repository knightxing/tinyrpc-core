package com.demo.tinyrpc.constant;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessageConst {
	
	public final static Map<String, String> resultMessageMap = new HashMap<String, String>();
	
	/**
	 * 未知服务
	 */
	public final static String E100001 = "E100001";
	
	static{
		resultMessageMap.put(E100001, "未知服务");
	}
	
	public static String get(String key){
		return resultMessageMap.get(key);
	}

}
