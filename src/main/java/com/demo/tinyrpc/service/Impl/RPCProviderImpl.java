package com.demo.tinyrpc.service.Impl;

import com.demo.tinyrpc.Exception.RPCServiceInfoNotComplete;
import com.demo.tinyrpc.Exception.RPCServiceListenFailed;
import com.demo.tinyrpc.service.IProviderService;
import com.demo.tinyrpc.service.IRPCProvider;

public class RPCProviderImpl implements IRPCProvider {
	/**
	 * 以下变量为发布一个服务的必要变量
	 */
	private String interfaceName;// 服务对应接口的全限定名
	private String version;// 服务版本号
	private String implClassName;// 实现该服务接口的类
	private String ip;// 发布该服务的地址

	private static boolean isListened = false;// 是否已经开启监听

	private IProviderService providerService;

	public RPCProviderImpl() throws RPCServiceListenFailed{
        providerService = new ProviderServiceImpl();


        //开启服务监听端口
        if (!isListened ){
            if (providerService.startListen())
            isListened = true;
            else throw new RPCServiceListenFailed();
        }
    }

	private void checkInfo() throws RPCServiceInfoNotComplete {
		// 先判断服务参数信息是否完整
		if (interfaceName == null || interfaceName.length() == 0 || version == null || version.length() == 0
				|| implClassName == null || implClassName.length() == 0 || ip == null || ip.length() == 0)
			throw new RPCServiceInfoNotComplete();
	}

	@Override
	public boolean servicePublish() throws RPCServiceListenFailed, RPCServiceInfoNotComplete {
		checkInfo();
		// step1. 注册服务.注册服务之前先判断服务是否开启,若没有开启,则首先开启服务
		synchronized (RPCProviderImpl.class) {
			if (!isListened) {
				if (providerService.startListen())
					isListened = true;
				else
					throw new RPCServiceListenFailed();
			}
			providerService.serviceregistry(interfaceName, version, implClassName, ip);
		}
		return true;
	}
}
