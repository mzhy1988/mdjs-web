package org.cnmd.common.webservice;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

@WebService
@Component
public interface HelloService {
	 String say(String name);
}
