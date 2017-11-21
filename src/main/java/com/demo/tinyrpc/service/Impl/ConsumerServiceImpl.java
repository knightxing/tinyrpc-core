package com.demo.tinyrpc.service.Impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.demo.tinyrpc.constant.Constant;
import com.demo.tinyrpc.entity.RPCRequestDO;
import com.demo.tinyrpc.service.IConsumerService;

public class ConsumerServiceImpl implements IConsumerService {

	@Override
	public Set<String> getServiceIPsByID(String serviceID) {
		// 调用服务注册查找中心的服务,获取ip列表
		// Set<String> ips = new HashSet<>();
		/**
		String url = "http://" + Constant.SERVICEACCESSCENTER_IP + ":" + Constant.SERVICEACCESSCENTER_PORT + "/"
				+ Constant.QUERYSERVICEIPSBYID + "?serviceID=" + serviceID;

		// Set status = new HashSet<Integer>();

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		Set<String> ips = null;
		if (result == null) {
			return ips = new HashSet<String>();
		}
		ips = JsonUtils.jsonToBean(result, Set.class);
		*/
		//当前设置了本机做注册中心
		Set<String> ips = new HashSet<String>();
		ips.add(Constant.IP);
		return ips;
	}

	@Override
	public String getIP(String serviceID, String methodName, List<Object> params, Set<String> ips) {
		// 可以根据接口\方法\参数进行路由,这里我们先简单实现,选出列表的第一个,模拟路由的过程
		String[] temparr = new String[ips.size()];
		ips.toArray(temparr);
		return temparr[0];
	}

	@Override
	public RPCRequestDO getRequestDO(String interfaceName, String version, String methodName, List<Object> params) {
		RPCRequestDO requestDO = new RPCRequestDO();
		requestDO.setInterfaceName(interfaceName);
		requestDO.setMethodName(methodName);
		requestDO.setParams(params);
		requestDO.setVersion(version);
		return requestDO;
	}

	@Override
	public Object sendData(String serviceAddress, RPCRequestDO requestDO) throws Exception {
		ObjectOutputStream objectOutputStream = null;
        Socket socket = null;
        ObjectInputStream objectInputStream = null;
        try {
            socket = new Socket(Constant.IP, Constant.PORT);//向远程服务端建立连接
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());//获得输出流
            objectOutputStream.writeObject(requestDO);//发送序列化结果
            objectOutputStream.flush();
            socket.shutdownOutput();
            //等待响应
            objectInputStream = new ObjectInputStream(socket.getInputStream());//获得输入流
            Object result = objectInputStream.readObject();//序列化为Object对象
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
            return result;
        }catch (Exception e){
            throw e;
        }finally {
            try {
                if(objectInputStream != null)objectInputStream.close();
                if (objectOutputStream != null)objectOutputStream.close();
                if (socket !=null )socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }

        }
	}

}
