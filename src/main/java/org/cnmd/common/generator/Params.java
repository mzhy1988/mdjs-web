package org.cnmd.common.generator;

import java.util.Properties;

public class Params {

	static {
		Properties prop = new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("generator.properties"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
