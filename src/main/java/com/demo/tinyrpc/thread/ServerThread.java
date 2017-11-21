package com.demo.tinyrpc.thread;

import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.demo.tinyrpc.constant.Constant;

/**
 * 服务线程
 * @author Sean.Chan
 *
 */
public class ServerThread implements Runnable{

	Logger log = Logger.getLogger(ServerThread.class);
	
	@Override
	public void run() {
		try {
			 ServerSocket serverSocket = new ServerSocket(Constant.PORT);
	            System.out.println("已经开始监听,可以注册服务了");
	            while (true){
	                Socket socket = serverSocket.accept();
	                new Thread(new ServerProcessThread(socket)).start();//开启新的线程进行连接请求的处理
	            }
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}

}
