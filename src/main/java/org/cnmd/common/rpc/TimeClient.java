package org.cnmd.common.rpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;


public class TimeClient {

	public static void main(String[] args) throws Exception{
		BufferedReader in = null;
		PrintWriter out = null;
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1",6098);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			out.println("QUERY TIME ORDER");
			//out.close();
			System.out.println(" send to server success");
			String resp = in.readLine();
			System.err.println("now is "+resp);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
			if( in !=null){
				in.close();
			}
			if(socket !=null){
				socket.close();
			}
			socket.shutdownOutput();
		}

	}
}
