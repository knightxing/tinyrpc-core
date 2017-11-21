package com.demo.tinyrpc.service;

import java.util.List;
import java.util.Set;

import com.demo.tinyrpc.entity.RPCRequestDO;

public interface IConsumerService {

	/**
	 * 根据服务的唯一标识获取该服务的ip地址列表
	 * @param serviceID
	 * @return
	 */
	Set<String> getServiceIPsByID(String serviceID);

	/**
	 * 获取该服务的地址,路由的结果会返回至少一个地址
	 * @param serviceID
	 * @param methodName
	 * @param params
	 * @param ips
	 * @return
	 */
	String getIP(String serviceID, String methodName, List<Object> params, Set<String> ips);

	/**
	 * 根据传入的参数,拼装Request对象,这里一定会返回一个合法的request对象
	 * @param interfaceName
	 * @param version
	 * @param methodName
	 * @param params
	 * @return
	 */
	RPCRequestDO getRequestDO(String interfaceName, String version, String methodName, List<Object> params);

	/**
	 * 传入Request对象,序列化并传入服务端,返回相应内容
	 * @param serviceAddress
	 * @param requestDO
	 * @return
	 * @throws Exception 
	 */
	Object sendData(String serviceAddress, RPCRequestDO requestDO) throws Exception;


}
