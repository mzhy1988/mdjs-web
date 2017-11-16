package org.cnmd.mall.controler;

import javax.servlet.http.HttpServletRequest;

import org.cnmd.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("indexAction")
public class IndexAction {

	@Autowired
	private ProductService productService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request, String type) throws Exception {
		productService.addProduct();
		System.out.println("===============================");
		request.setAttribute("type", type);
		return "index.ftl";
	}
}
