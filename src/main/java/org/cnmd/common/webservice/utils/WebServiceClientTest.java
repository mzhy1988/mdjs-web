package org.cnmd.common.webservice.utils;

import javax.xml.namespace.QName;

import org.cnmd.common.webservice.HelloService;
import org.cnmd.common.webservice.client.HelloWordClient;

public class WebServiceClientTest {

	public static void main(String[] args) throws Exception {
		//HelloService service = 	WebServiceHelper.createWebClient("http://localhost:8080/mdjs-web/ws/soap/hello?wsdl", HelloService.class);
		//service.say("jack");
		String url = "http://localhost:8080/mdjs-web/ws/soap/hello?wsdl";
		url ="http://58.213.29.222:18081/elink_scm/services/SCMService?wsdl";
		QName qname = new QName("http://service.std.ws.scm.chcit.com","PUT_Storage");


		String xml = "<xml> <sys></sys> <items> <item> <head> <SiteCode>JSRM</SiteCode> <OrgCode>JSRM</OrgCode> <WarehouseID>总药库</WarehouseID>"+
		"<ProductID>test001</ProductID> <Lot>111</Lot> <GuaranteeDate>2012-12-01</GuaranteeDate> <ProductionDate></ProductionDate>"+
		"</head> </item> </items> </xml>";

		Object[] o = WebServiceHelper.createWebClient(url, qname, xml,"YSFW","");
		for (int i = 0; i < o.length; i++) {
			System.out.println(o[i]);
		}
	}
}
