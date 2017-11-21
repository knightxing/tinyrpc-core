package com.demo.tinyrpc.Exception;

/**
 * 远程调用服务异常
 * @author Sean.Chan
 *
 */
public class RPCRemoteCallException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RPCRemoteCallException(){
		super();
	}

	public RPCRemoteCallException(String msg) {
		super(msg);
	}

}
