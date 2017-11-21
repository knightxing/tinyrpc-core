package com.demo.tinyrpc.Exception;

/**
 * 找不到服务异常
 * @author Sean.Chan
 *
 */
public class RPCServiceNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RPCServiceNotFound(){}
	
	public RPCServiceNotFound(String msg) {
		super(msg);
	}

}
