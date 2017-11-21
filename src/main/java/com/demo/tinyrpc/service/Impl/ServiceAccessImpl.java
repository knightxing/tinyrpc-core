package com.demo.tinyrpc.service.Impl;

import java.util.Set;

import org.springframework.util.StringUtils;

import com.demo.tinyrpc.common.ServicesSingle;
import com.demo.tinyrpc.entity.ServiceInfoDO;
import com.demo.tinyrpc.service.IServiceAccess;

public class ServiceAccessImpl implements IServiceAccess {

	@Override
	public boolean serviceRegistry(ServiceInfoDO serviceInfo) {

		if (serviceInfo == null || StringUtils.isEmpty(serviceInfo.getInterfaceName())
				|| StringUtils.isEmpty(serviceInfo.getImplClassName()) || StringUtils.isEmpty(serviceInfo.getIp())
				|| StringUtils.isEmpty(serviceInfo.getVersion()) || serviceInfo.getIps().size() != 0) {
			return false;
		}
		// 接口名+版本号 作为唯一标识
		String serviceID = serviceInfo.getInterfaceName() + "_" + serviceInfo.getVersion();
		if (ServicesSingle.getServiceSingle().getServices().containsKey(serviceID)) {
			// 增加多一个ip地址
			ServicesSingle.getServiceSingle().getServices().get(serviceID).getIps().add(serviceInfo.getIp());
		} else {
			// 本来不存在服务接口,在缓存中新加
			serviceInfo.getIps().add(serviceInfo.getIp());
			ServicesSingle.getServiceSingle().getServices().put(serviceID, serviceInfo);
		}

		return true;
	}

	@Override
	public Set<String> queryServiceIPsByID(String serviceID) {
		if (!ServicesSingle.getServiceSingle().getServices().containsKey(serviceID)) {
			return null;
		}

		return ServicesSingle.getServiceSingle().getServices().get(serviceID).getIps();
	}

	@Override
	public ServiceInfoDO queryServiceInfoByID(String serviceID) {
		if (!ServicesSingle.getServiceSingle().getServices().containsKey(serviceID))
			return null;

		return ServicesSingle.getServiceSingle().getServices().get(serviceID);
	}

}
