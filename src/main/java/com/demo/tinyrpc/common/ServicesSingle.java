package com.demo.tinyrpc.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.demo.tinyrpc.entity.ServiceInfoDO;

/**
 * 单例保存服务信息
 * @author Sean.Chan
 *
 */
public class ServicesSingle {
	private static ServicesSingle servicesSingle = null;
    private Map<String,ServiceInfoDO> services = null;

    private ServicesSingle(){
        services = new ConcurrentHashMap<>();
    }

    public static ServicesSingle getServiceSingle(){
        synchronized (ServicesSingle.class){
            if (servicesSingle == null){
                servicesSingle = new ServicesSingle();
            }
        }
        return servicesSingle;
    }

	public Map<String, ServiceInfoDO> getServices() {
		return services;
	}

	public void setServices(Map<String, ServiceInfoDO> services) {
		this.services = services;
	}
    
    

}
