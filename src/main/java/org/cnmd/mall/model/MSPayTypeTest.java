package org.cnmd.mall.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.cnmd.mall.po.SPaytypeTestPO;

public class MSPayTypeTest extends SPaytypeTestPO{

	public MSPayTypeTest() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws Exception {
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
		//System.out.println("Y".);


	}
}
