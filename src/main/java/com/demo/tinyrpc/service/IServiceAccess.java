package com.demo.tinyrpc.service;

import java.util.Set;

import com.demo.tinyrpc.entity.ServiceInfoDO;

public interface IServiceAccess {
	
	 /**
     * 根据用户提供的服务信息,进行服务的注册
     * @param serviceInfo  要注册的服务信息
     * @return
     */
    public boolean serviceRegistry(ServiceInfoDO serviceInfo);

    /**
     * 根据服务的唯一标识ID查询服务的地址列表
     * @param serviceID
     * @return
     */
    public Set<String> queryServiceIPsByID(String serviceID);

    /**
     * 根据服务的唯一标识ID查询服务的信息
     * @param serviceID
     * @return
     */
    public ServiceInfoDO queryServiceInfoByID(String serviceID);

}
