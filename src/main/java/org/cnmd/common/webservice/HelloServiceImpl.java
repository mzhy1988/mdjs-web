package org.cnmd.common.webservice;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

@Component
@WebService
public class HelloServiceImpl implements HelloService {
	@Override
	public String say(String name) {
		return "hello " + name;
	}
}
