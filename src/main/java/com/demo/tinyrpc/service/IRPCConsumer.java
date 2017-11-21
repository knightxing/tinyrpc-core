package com.demo.tinyrpc.service;

import java.util.List;

import com.demo.tinyrpc.Exception.RPCRemoteCallException;
import com.demo.tinyrpc.Exception.RPCServiceIDIsIllegal;
import com.demo.tinyrpc.Exception.RPCServiceNotFound;

public interface IRPCConsumer {
	
	Object serviceConsumer(String methodName, List<Object> params) throws RPCServiceIDIsIllegal,RPCServiceNotFound,RPCRemoteCallException;


}
	