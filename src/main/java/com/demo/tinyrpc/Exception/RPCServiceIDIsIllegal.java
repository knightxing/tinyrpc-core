package com.demo.tinyrpc.Exception;

/**
 * ServiceId参数异常
 * 
 * @author Sean.Chan
 *
 */
public class RPCServiceIDIsIllegal extends java.lang.Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RPCServiceIDIsIllegal(){
		super("RPC serviceId is illegal ...");
	}
	
	public RPCServiceIDIsIllegal(String msg) {
		super(msg);
	}

}
