package com.demo.tinyrpc.Exception;

/**
 * 服务监听失败异常
 * @author Sean.Chan
 *
 */
public class RPCServiceListenFailed extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RPCServiceListenFailed(){
		super();
	}

	public RPCServiceListenFailed(String msg){
		super(msg);
	}
}
