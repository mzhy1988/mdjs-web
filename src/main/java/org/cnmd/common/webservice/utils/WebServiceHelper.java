package org.cnmd.common.webservice.utils;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class WebServiceHelper {
	// 发布 Web 服务
	public static void publishWebService(String wsAddress, Class<?> wsInterfaceClass, Object wsImplementInstance) {
		ServerFactoryBean factory = new ServerFactoryBean();
		factory.setAddress(wsAddress);               // 地址
		factory.setServiceClass(wsInterfaceClass);   // 接口
		factory.setServiceBean(wsImplementInstance); // 实现
		factory.create();
	}

	// 创建 Web 服务客户端
	/**
	 * simple方式调用，只可以调用以simple方式发布的webservice
	 */
	public static <T> T createWebClient(String wsAddress, Class<? extends T> interfaceClass) {
		ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
		factory.setAddress(wsAddress);           // 地址
		factory.setServiceClass(interfaceClass); // 接口
		return factory.create(interfaceClass);
	}

	// 创建 Web 服务客户端
	public static Object[] createWebClient(String url ,QName qname,Object ... obj) throws Exception {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
		//url为调用webService的wsdl地址  http://localhost:8080/mdjs-web/ws/helloService?wsdl
		Client client = dcf.createClient(url);  
		//namespace是命名空间，methodName是方法名 
		//QName name=new QName("http://webservice.common.cnmd.org/","sayHello");  
		Object[] objects = client.invoke(qname,obj); 
		return objects;
	}
}
