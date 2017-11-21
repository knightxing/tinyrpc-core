package com.demo.tinyrpc.service;

import com.demo.tinyrpc.Exception.RPCServiceInfoNotComplete;
import com.demo.tinyrpc.Exception.RPCServiceListenFailed;

/**
 * 
 * @author Sean.Chan
 *
 */
public interface IRPCProvider {

	/**
	 * 发布服务
	 * @return
	 * @throws RPCServiceListenFailed 
	 * @throws RPCServiceInfoNotComplete 
	 */
	boolean servicePublish() throws RPCServiceListenFailed, RPCServiceInfoNotComplete;

}
