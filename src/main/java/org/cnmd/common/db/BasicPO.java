package org.cnmd.common.db;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.cnmd.common.db.utils.DatabaseHelper;
import org.cnmd.common.utils.ObjectUtil;

public class BasicPO extends BasicDB {
	public String      getTableName(){return null;};
	public String[]    getColumns(){return null;};
	public String[]    getFields(){return null;};
	public BigDecimal  getPrimaryKeyValue(){return null;}
	public String      getPrimaryKeyName(){return null;}
	public void        setPrimaryKeyValue(BigDecimal pk){}

	public void save() throws Exception{
		BigDecimal primaryKey = this.getPrimaryKeyValue();
		if(primaryKey == null){
			//map 存放字段名和值
			this.setPrimaryKeyValue(getTablePrimaryKey(this.getTableName()));
			Map<String, Object> fieldMap = ObjectUtil.getFieldMap(this);
			String sql = generateInsertSql(getTableName(),fieldMap.keySet());
			System.out.println(sql);
			System.err.println(fieldMap.values().toArray());
//           / Integer.valueOf("ss");
			DatabaseHelper.update( sql, fieldMap.values().toArray());
		}else{
			//map 存放字段名和值
			Map<String, Object> fieldMap = ObjectUtil.getFieldMap(this);
			String sql = generateUpdateSql(getTableName(), fieldMap, getPrimaryKeyName()+"="+getPrimaryKeyValue());
			DatabaseHelper.update( sql, fieldMap.values().toArray());
		}
	}

	public void delete() throws Exception{
		BigDecimal primaryKey = this.getPrimaryKeyValue();
		if(primaryKey != null){
			//map 存放字段名和值
			String sql = generateDeleteSql(getTableName(), getPrimaryKeyName()+"="+getPrimaryKeyValue());
			DatabaseHelper.update(sql);
		}else{
			throw new RuntimeException("不合法的删除");
		}
	}

	public static <T> T getPo(Class<T> entityClass,Integer primaryKeyValue) throws Exception{
		try {
			BasicPO po = (BasicPO)Class.forName(entityClass.getName()).newInstance();
			String[] fields = po.getFields();
			String[] columns = po.getColumns();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < fields.length; i++) {
				if(i<fields.length-1){
					sb.append(columns[i]).append(" ").append(fields[i]).append(",");
				}else{
					sb.append(columns[i]).append(" ").append(fields[i]).append(" ");
				}
			}
			String sql = " select "+sb.toString()+" from " + po.getTableName() +" where " + po.getPrimaryKeyName() +"="+primaryKeyValue;
			T o = DatabaseHelper.queryEntity(entityClass,sql, new BeanHandler<T>(entityClass));
			return o;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args)throws Exception{
//		MPaytypeTest c = new MPaytypeTest();
//		c.setAccountno("111");
//		c.setIsactive("Y");
//		c.setName("支付宝");
//		c.setAdClientId(new BigDecimal(0));
//		c.setAdOrgId(new BigDecimal(0));
//		c.setCreated(getTimestamp());
//		c.setCreatedby(new BigDecimal(0));
//		c.setUpdated(getTimestamp());
//		c.setUpdatedby(new BigDecimal(0));
//		c.save();
//		MPaytypeTest p = MPaytypeTest.get(1000017);
//		p.setName("支付宝2");
//		p.save();
//		SProduct po = SProduct.getPo(SProduct.class, 1131715);
//		System.out.println(po.getName());
//		po.save();


//		r = SProduct.getPo(SProduct.class, 1131715);
//		r.setName("三九胃泰颗粒3");
//		System.out.println(r.getSproductId());
//		r.save();
//		System.out.println(r.getName());
		//c.setProductId("1131715");
		//c.save();
	}
//	public static void main(String[] args) {  
//	try {  
//	String s = decapitalize("qDcccc");
//	System.out.println(s);
//	} catch (Exception e) {  
//	e.printStackTrace();  
//	}  
//	}

//	public static String decapitalize(String s) 
//	{ 
//	if(s == null || s.length() == 0) 
//	//空处理 
//	return s; 
//	if(s.length() > 1 && Character.isUpperCase(s.charAt(1)) && Character.isUpperCase(s.charAt(0))){ 
//	//长度大于1，并且前两个字符大写时，返回原字符串 
//	return s; 
//	} else{ 
//	//其他情况下，把原字符串的首个字符小写处理后返回 
//	char ac[] = s.toCharArray(); 
//	ac[0] = Character.toLowerCase(ac[0]); 
//	ac[1] = Character.toLowerCase(ac[1]); 
//	return new String(ac); 
//	} 
//	} 

}
