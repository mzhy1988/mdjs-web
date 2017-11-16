package org.cnmd.common.webservice.client;

import javax.xml.namespace.QName;
import org.cnmd.common.webservice.utils.WebServiceHelper;

public class HelloWordClient {
	public static void main(String[] args) throws Exception {
//		方法一
//		String wsAddress = "http://localhost:8080/mdjs-web/ws/helloService";
//		TestService greetingService = WebServiceHelper.createWebClient(wsAddress, TestService.class);
//		greetingService.sayHello("{}Jack");
		//方法二
		String url =  "http://localhost:8080/mdjs-web/ws/helloService?wsdl";
		QName name=new QName("http://webservice.common.cnmd.org/","sayHello"); 
		Object[] obj = WebServiceHelper.createWebClient(url, name, "sss",18);
		if(obj !=null){
			for (int i = 0; i < obj.length; i++) {
				System.out.println(obj[i]);
			}
		}

//		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  

//		//url为调用webService的wsdl地址  
//		Client client = dcf.createClient("http://localhost:8080/mdjs-web/ws/helloService?wsdl");  
//		//namespace是命名空间，methodName是方法名 
//		QName name=new QName("http://webservice.common.cnmd.org/","sayHello");  
//		Object[] objects = client.invoke(name,"sss","xxxx"); 
//		String res = "";          
//		if(objects != null && objects.length != 0){
//		res = objects[0].toString();
//		System.out.println(res);
//		}



	}
}
