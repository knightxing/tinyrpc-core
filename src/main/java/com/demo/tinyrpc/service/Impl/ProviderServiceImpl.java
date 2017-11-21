package com.demo.tinyrpc.service.Impl;

import com.demo.tinyrpc.service.IProviderService;
import com.demo.tinyrpc.thread.ServerThread;

public class ProviderServiceImpl implements IProviderService {
	
	  @Override
	    public boolean startListen() {
	        new Thread(new ServerThread()).start();
	        return true;
	    }

	    @Override
	    public boolean serviceregistry(String interfaceName, String version, String implClassName, String ip) {

	    	/**
	    	 
	        //注册到服务注册查找中心的同时也要缓存到内存services
	        //step1. 注册到服务中心

	        String url = "http://" + Constant.SERVICEACCESSCENTER_IP + ":" + Constant.SERVICEACCESSCENTER_PORT + "/"
	                + Constant.SERVICEREGISTRY;
	        Map<String,String> headers = new HashMap();
	        headers.put("Content-Type","application/json");
	        JSONObject param = new JSONObject();
	        param.put("interfaceName",interfaceName);
	        param.put("version",version);
	        param.put("implClassName",implClassName);
	        param.put("ip",ip);
	        Set status = new HashSet<Integer>();
	        status.add(200);
	        StringBuilder response = new StringBuilder();
	        GetRemoteInfo.getRemoteInfo(url,"POST",headers,param.toString(),response,status);

	        if (response.equals("false")) throw new LCRPCServiceRegistryFailed();

	        //step2. 存入到缓存
	        if (ServicesSingle.getServiceSingle().getServices().containsKey(interfaceName + "_" + version)){
	            ServicesSingle.getServiceSingle().getServices().get(interfaceName + "_" + version).getIps().add(ip);
	        }
	        else {
	            ServiceInfoDO serviceInfoDO = new ServiceInfoDO();
	            serviceInfoDO.setInterfaceName(interfaceName);
	            serviceInfoDO.setVersion(version);
	            serviceInfoDO.setImplClassName(implClassName);
	            serviceInfoDO.getIps().add(ip);
	            ServicesSingle.getServiceSingle().getServices().put(interfaceName + "_" + version,serviceInfoDO);
	        }
	
			**/
	    	System.out.println("成功注册服务:[" + interfaceName  + "]");
	        return true;
	    }

}
