package org.cnmd.common.rpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeTread implements Runnable {

	private Socket socket = null;
	BufferedReader in = null;
	PrintWriter out = null;
	public TimeTread(Socket socket) {
		try {
			this.socket = socket;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream());
			String currentTime = null;
			String body = null;
			while(true){
				body = in.readLine();
				if(body == null){
					break;
				}
				System.out.println("我是接收到的客户端数据 " + body);
				out.println("我是服务端发出的数据");
				out.close();    
				in.close(); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
