package org.cnmd.common.db;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.cnmd.common.db.utils.DatabaseHelper;

public class BasicDB {

	public static Timestamp getTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}	/**
	 * 生成 insert 语句
	 */
	public  String generateInsertSql(String tableName, Collection<String> fieldNames) {
		StringBuilder sql = new StringBuilder("insert into ").append(tableName);
		if (CollectionUtils.isNotEmpty(fieldNames)) {
			int i = 0;
			StringBuilder columns = new StringBuilder(" ");
			StringBuilder values = new StringBuilder(" values ");
			for (String fieldName : fieldNames) {
				String columnName = fieldName;
				if (i == 0) {
					columns.append("(").append(columnName);
					values.append("(?");
				} else {
					columns.append(", ").append(columnName);
					values.append(", ?");
				}
				if (i == fieldNames.size() - 1) {
					columns.append(")");
					values.append(")");
				}
				i++;
			}
			sql.append(columns).append(values);
		}
		return sql.toString();
	}

	/**
	 * 生成 update 语句
	 */
	public static String generateUpdateSql(String tableName, Map<String, Object> fieldMap, String condition) {
		StringBuilder sql = new StringBuilder("update ").append(tableName);
		if (1==1) {
			sql.append(" set ");
			int i = 0;
			for (Map.Entry<String, Object> fieldEntry : fieldMap.entrySet()) {
				String columnName = fieldEntry.getKey();
				if (i == 0) {
					sql.append(columnName).append(" = ?");
				} else {
					sql.append(", ").append(columnName).append(" = ?");
				}
				i++;
			}
		}
		sql.append(generateWhere(condition));
		return sql.toString();
	}

	/**
	 * 获取主键
	 * @return 主键
	 */
	public BigDecimal getTablePrimaryKey(String tableName)throws SQLException{ 
		tableName = tableName.toUpperCase();
		String sql = "select * from DB_SEQUENCE t where t.tablename =  '" +tableName +"'";
		QueryRunner qr = new QueryRunner();
		Object obj = qr.query(DatabaseHelper.getConnection(),sql,new BeanHandler(Sequence.class));
		if(obj!=null){
			Sequence sequence = (Sequence)obj;
			BigDecimal pkValue = sequence.getCurrentnext();
			sql= "update  DB_SEQUENCE t  set t.currentnext = t.currentnext +1 where t.tablename = ?";
			DatabaseHelper.update( sql, tableName);
			return  sequence.getCurrentnext();
		}else{
			sql = "insert into DB_SEQUENCE(TABLENAME,INCREMENTNO,STARTNO,CURRENTNEXT) values(?,?,?,?)";
			DatabaseHelper.update(sql, tableName,1,1000000,1000001);
			return new BigDecimal(1000000);
		}
	}

	/**
	 * 生成 delete 语句
	 */
	public static String generateDeleteSql(String tableName, String condition) {
		StringBuilder sql = new StringBuilder("delete from ").append(tableName);
		sql.append(generateWhere(condition));
		return sql.toString();
	}

	private static String generateWhere(String condition) {
		String where = "";
		if ( condition !=null) {
			where += " where " + condition;
		}
		return where;
	}
}
