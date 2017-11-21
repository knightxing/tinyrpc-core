package com.demo.tinyrpc.Exception;

/**
 * 发布服务信息不完整异常
 * @author Sean.Chan
 *
 */
public class RPCServiceInfoNotComplete extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RPCServiceInfoNotComplete(){
		super();
	}
	
	public RPCServiceInfoNotComplete(String msg){
		super(msg);
	}

}
