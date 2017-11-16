package org.cnmd.common.rpc;

import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

	public static void main(String[] args) throws Exception  {
		ServerSocket serverSocket  = null;
		try {
			Socket socket = null;
			serverSocket = new ServerSocket(6098);
			while(true){
				System.out.println("==========等待客户端链入======");
				socket = serverSocket.accept();
				System.out.println("============客户端链入=======");
				new TimeTread(socket).run();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(serverSocket !=null){
				System.out.println("close server");
				serverSocket.close();
			}
		}

	}

}
