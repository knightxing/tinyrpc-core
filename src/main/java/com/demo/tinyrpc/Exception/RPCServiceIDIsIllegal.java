package com.demo.tinyrpc.Exception;

/**
 * ServiceId参数异常
 * 
 * @author Sean.Chan
 *
 */
public class RPCServiceIDIsIllegal extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RPCServiceIDIsIllegal(){
		super();
	}
	
	public RPCServiceIDIsIllegal(String msg) {
		super(msg);
	}

}
