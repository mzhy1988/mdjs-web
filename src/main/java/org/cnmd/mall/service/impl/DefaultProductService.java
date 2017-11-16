package org.cnmd.mall.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.cnmd.mall.model.MSPayTypeTest;
import org.cnmd.mall.model.MSProduct;
import org.cnmd.mall.service.ProductService;
import org.springframework.stereotype.Service;

@Service("productService")
public class DefaultProductService implements ProductService {

	@Override
	public void addProduct() throws Exception {
		MSPayTypeTest po = new MSPayTypeTest();
		po.setAccountno("11rr460");
		po.setAdClientId(new BigDecimal(0));
		po.setAdOrgId(new BigDecimal(0));
		po.setIsactive("Y");
		po.setCreated(new Timestamp(System.currentTimeMillis()));
		po.setUpdated(new Timestamp(System.currentTimeMillis()));
		po.setCreatedby(new BigDecimal(0));
		po.setUpdatedby(new BigDecimal(0));
		po.setName("test");
		//po.setPrimaryKeyValue(new BigDecimal(1000046));
		po.save();
	}

}
