package org.cnmd.common.generator;

import java.util.HashMap;
import java.util.Map;

public class GenDBUtils {
	/**
	 * 获取dataModel
	 * @param tableName 表名
	 * @return Map
	 */
	public static Map<Object, Object> getTableInfo(String tableName){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put(Constants.TABLENAME,      tableName);
		map.put(Constants.PRIMARYKEY,     OracleDBUtils.getPrimaryKey(tableName));
		map.put(Constants.FIELDPRIMARYKEY,GenUtils.getFieldName(OracleDBUtils.getPrimaryKey(tableName)));
		map.put(Constants.TITLE,          GenUtils.getClassName(tableName));
		map.put(Constants.CLOUMNS,        GenUtils.getCloumns(tableName));
		map.put(Constants.FEILDS,         GenUtils.getColumn2Fields(tableName));
		//map.put("mybatisColumns", getColumnNameForMybatis(tableName));
		//map.put("remarks",        getRemarks(tableName));
		map.put(Constants.FEILDTYPES,     GenUtils.getFeildsType(tableName));
		map.put(Constants.CLOUMSTYPES,    GenUtils.getCloumnsType(tableName));
		//map.put("mybatisTypes",   getMybatisType(tableName));
		//map.put("maxColumnLength", getMaxColumnLength(tableName));
		//map.put("maxJavaPropertyLength", getMaxJavaPropertyLength(tableName));
		return map;
	}
}
