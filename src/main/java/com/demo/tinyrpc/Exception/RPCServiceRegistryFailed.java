package com.demo.tinyrpc.Exception;

/**
 * 服务注册失败异常
 * @author Sean.Chan
 *
 */
public class RPCServiceRegistryFailed extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RPCServiceRegistryFailed(){
		super();
	}
	
	public RPCServiceRegistryFailed(String msg){
		super(msg);
	}

}
