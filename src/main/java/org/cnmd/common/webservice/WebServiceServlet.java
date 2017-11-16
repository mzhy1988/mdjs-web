package org.cnmd.common.webservice;

import javax.servlet.ServletConfig;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.cnmd.common.webservice.utils.WebServiceHelper;

public class WebServiceServlet extends CXFNonSpringServlet {

//	@Override
//	protected void loadBus(ServletConfig sc) {
//		// TODO Auto-generated method stub
//		setBus(sc);
//		publishWebService();
//	}
//	private void setBus(ServletConfig sc) {
//		super.loadBus(sc);
//		Bus bus = getBus();
//		BusFactory.setDefaultBus(bus);
//	}
//
//	private void publishWebService() {
//		// 遍历所有标注了 @WebService 注解的接口
//		String wsAddress = "http://localhost:8080/mdjs-web/ws/helloService";
//		TestService greetingService = WebServiceHelper.createWebClient(wsAddress, TestService.class);
//		WebServiceHelper.publishWebService(wsAddress, IHelloService.class, DHelloService.class);
//	}

}
