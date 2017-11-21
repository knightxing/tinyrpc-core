package com.demo.tinyrpc.service;

public interface IProviderService {

	/**
	 * 启动服务监听
	 * @return
	 */
	boolean startListen();

	/**
	 * 服务注册
	 * @param interfaceName
	 * @param version
	 * @param implClassName
	 * @param ip
	 * @return
	 */
	boolean serviceregistry(String interfaceName, String version, String implClassName, String ip);

}
