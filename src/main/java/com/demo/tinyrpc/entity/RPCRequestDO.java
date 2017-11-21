package com.demo.tinyrpc.entity;

import java.io.Serializable;
import java.util.List;

public class RPCRequestDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 接口名
	 */
	public String interfaceName;
	
	/**
	 * 版本号
	 */
	public String version;
	
	/**
	 * 方法名
	 */
	public String methodName;
	
	/**
	 * 请求参数
	 */
	public List<Object> params;

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public List<Object> getParams() {
		return params;
	}

	public void setParams(List<Object> params) {
		this.params = params;
	}
	
	

}
