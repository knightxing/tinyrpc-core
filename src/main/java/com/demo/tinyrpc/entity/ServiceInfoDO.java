package com.demo.tinyrpc.entity;

import java.util.HashSet;
import java.util.Set;


/**
 *
 * 服务的描述信息,包括:
 * 服务唯一标识\实现类全限定名\ip地址列表等
 *
 * @author Sean.Chan
 *
 */
public class ServiceInfoDO {

	private String interfaceName;// 服务对应接口名称
	private String version;// 版本号
	private String implClassName;// 实现该接口的类
	private Set<String> ips = new HashSet<>();// 该服务的地址
	private String ip;// 某一次注册服务的地址

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getImplClassName() {
		return implClassName;
	}

	public void setImplClassName(String implClassName) {
		this.implClassName = implClassName;
	}

	public Set<String> getIps() {
		return ips;
	}

	public void setIps(Set<String> ips) {
		this.ips = ips;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
