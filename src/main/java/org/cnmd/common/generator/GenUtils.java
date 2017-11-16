package org.cnmd.common.generator;

import java.util.ArrayList;
import java.util.List;
    
public class GenUtils {

	/***
	 * 判断字符串是否为大写
	 * @param source
	 * @return
	 */
	public static boolean isUpperCase(String source){
		String upperSouce = source.toUpperCase();
		if(source.equals(upperSouce)){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 判断字符串是否为小写
	 * @param source
	 * @return
	 */

	public static boolean islowerCase(String source){
		String upperSouce = source.toLowerCase();
		if(source.equals(upperSouce)){
			return true;
		}else{
			return false;
		}
	}	

	/**
	 * 根据表生成类的属性名称
	 * @param tableName
	 * @return
	 */
	public static String getFieldName(String cloumnName){
		if (cloumnName == null) {
			return null;
		}
		StringBuffer fieldName = new StringBuffer();
		String[] str = cloumnName.split("_");
		for (int i = 0; i < str.length; i++) {
			String st = str[i].toLowerCase();
			fieldName.append(prefixToUpper(st));
		}
		String field = fieldName.toString();
		field = field.substring(0,1).toLowerCase()+field.substring(1);
		if(field.length()>1){
			String preSecondChar = field.substring(0,2);
			if(!islowerCase(preSecondChar)){
				field = field.substring(0,2).toLowerCase()+field.substring(2);
			}
		}
		return  field;
	}

	/**
	 * 根据表名生成类名称
	 * @param tableName
	 * @return
	 */
	public static String getClassName(String tableName){
		if (tableName == null) {
			return null;
		}
		StringBuffer className = new StringBuffer();
		String[] str = tableName.split("_");
		for (int i = 0; i < str.length; i++) {
			String st = str[i].toLowerCase();
			className.append(prefixToUpper(str[i]));
		}
		return  className.substring(0,1).toUpperCase()+className.substring(1);
	}


	/**
	 * 将首字母大写
	 * @param str
	 * @return
	 */
	public static String prefixToUpper(String  str){
		if(str == null || "".equals(str)){
			return "";
		}
		return str.substring(0,1).toUpperCase() + str.substring(1);
	}

	/**
	 * 将首字母小写
	 * @param str
	 * @return
	 */
	public static String prefixTolowper(String  str){
		if(str == null || "".equals(str)){
			return "";
		}
		return str.substring(0,1).toLowerCase() + str.substring(1);
	}

	/**根据javaBean命名规范
	 * 获取字段对应的类属性名称
	 * @param tableName
	 * @return
	 */
	public static List<String> getColumn2Fields(String tableName){
		List<String> result = new ArrayList<String>();
		List<String> cloumns = OracleDBUtils.getColumnNameByTableNameWithList(tableName);
		for (int i = 0; i < cloumns.size(); i++) {
			String cloumnName = cloumns.get(i);
			String fieldName = getFieldName(cloumnName);
			result.add(fieldName);
		}
		return result;
	}

	/**
	 * 获取表中列类型并转换成java类型
	 * @param tableName 表名
	 * @return list
	 */
	public static List<String> getFeildsType(String tableName) {
		List<String> retTypes = new ArrayList<String>();
		List<String> types = OracleDBUtils.getColumnTyBypeTableNameWithList(tableName);
		for(String type : types){
			retTypes.add(OracleDBUtils.dbTypeToJavaType(type));
		}
		return retTypes;
	}

	/**
	 * 获取表中列名称
	 * @param tableName 表名
	 * @return list
	 */
	public static List<String> getCloumns(String tableName) {
		List<String> types = OracleDBUtils.getColumnNameByTableNameWithList(tableName);
		return types;
	}
	/**
	 * 获取表中列类型
	 * @param tableName 表名
	 * @return list
	 */
	public static List<String> getCloumnsType(String tableName) {
		List<String> types = OracleDBUtils.getColumnTyBypeTableNameWithList(tableName);
		return types;
	}

	public static void main(String[] args) {
		System.out.println(GenUtils.getFieldName("S_product_log"));
	}

}
