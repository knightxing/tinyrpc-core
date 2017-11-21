package com.demo.tinyrpc.service.Impl;

import java.util.List;
import java.util.Set;

import com.demo.tinyrpc.Exception.RPCRemoteCallException;
import com.demo.tinyrpc.Exception.RPCServiceIDIsIllegal;
import com.demo.tinyrpc.Exception.RPCServiceNotFound;
import com.demo.tinyrpc.constant.ErrorMessageConst;
import com.demo.tinyrpc.entity.RPCRequestDO;
import com.demo.tinyrpc.service.IConsumerService;
import com.demo.tinyrpc.service.IRPCConsumer;

public class RPCConsumerImpl implements IRPCConsumer {

	/**
	 * 以下两个变量共同组成服务的唯一标识
	 */
	private String interfaceName;// 服务对应接口的全限定名
	private String version;// 服务版本号
	private IConsumerService consumerService;// 初始化客户端辅助类

	public RPCConsumerImpl() {
		consumerService = new ConsumerServiceImpl();
	}

	@Override
	public Object serviceConsumer(String methodName, List<Object> params)
			throws RPCServiceIDIsIllegal, RPCServiceNotFound, RPCRemoteCallException {
		// 若服务唯一标识没有提供,则抛出异常
		if (interfaceName == null || interfaceName.length() == 0 || version == null || version.length() == 0)
			throw new RPCServiceIDIsIllegal();
		// step1. 根据服务的唯一标识获取该服务的ip地址列表
		String serviceID = interfaceName + "_" + version;
		Set<String> ips = consumerService.getServiceIPsByID(serviceID);
		if (ips == null || ips.size() == 0)
			throw new RPCServiceNotFound();

		// step2. 路由,获取该服务的地址,路由的结果会返回至少一个地址,所以这里不需要抛出异常
		String serviceAddress = consumerService.getIP(serviceID, methodName, params, ips);

		// step3. 根据传入的参数,拼装Request对象,这里一定会返回一个合法的request对象,所以不需要抛出异常
		RPCRequestDO requestDO = consumerService.getRequestDO(interfaceName, version, methodName, params);

		// step3. 传入Request对象,序列化并传入服务端,拿到响应后,反序列化为object对象
		Object result = null;
		try {
			result = consumerService.sendData(serviceAddress, requestDO);
		} catch (Exception e) {
			// 在服务调用的过程种出现问题
			throw new RPCRemoteCallException(e.getMessage());
		}
		if (result == null)
			throw new RPCRemoteCallException(ErrorMessageConst.get(ErrorMessageConst.E100001));
		// step4. 返回object对象
		return result;
	}

}
