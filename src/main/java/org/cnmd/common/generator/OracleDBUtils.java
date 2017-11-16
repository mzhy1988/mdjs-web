package org.cnmd.common.generator;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class OracleDBUtils {
	private static Connection conn      = null;
	private static Statement st         = null;
	private static ResultSet rs         = null;
	private static DatabaseMetaData dmd = null;
	/**
	 * 链接数据库
	 * @return
	 */
	public static Connection connection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.20.240:1521:CHCINFODB", "scm_b2b_dev", "scm_b2b_dev");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭链接
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void release(ResultSet rs, Statement st, Connection conn) {
		try {
			try {
				if (null != rs) {
					rs.close();
				}
			} catch (Exception e) {
				rs = null;
			}
			try {
				if (null != st) {
					st.close();
				}
			} catch (Exception e) {
				st = null;
			}
			try {
				if (null != conn) {
					conn.close();
				}
			} catch (Exception e) {
				conn = null;
			}
		} finally {
			rs = null;
			st = null;
			conn = null;
		}
	}
	/**
	 * 根据表名查询表中列注释
	 * @param tableName 表名
	 * @return List<String>
	 */
	public static List<String> getColumnRemarksByTableNameWithList(String tableName) {
		List<String> columnComments = new LinkedList<String>();
		connection();
		try {
			dmd = conn.getMetaData();
			rs = dmd.getColumns(null, dmd.getUserName(), tableName.toUpperCase(), null);
			while (rs.next()) {
				columnComments.add(rs.getString("REMARKS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		release(rs, st, conn);
		return columnComments;
	}
	/**
	 * 根据表名查询表中列名
	 * @param tableName 表名
	 * @return List<String>
	 */
	public static List<String> getColumnNameByTableNameWithList(String tableName) {
		List<String> columnComments = new LinkedList<String>();
		connection();
		try {
			dmd = conn.getMetaData();
			rs = dmd.getColumns(conn.getCatalog(), dmd.getUserName(), tableName.toUpperCase(), null);
			while (rs.next()) {
				columnComments.add(rs.getString("COLUMN_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		release(rs, st, conn);
		return columnComments;
	}

	/**
	 * 根据表名查询主键列名
	 * @param tableName 表名
	 * @return List<String>
	 */
	public static String getPrimaryKey(String tableName) {
		String primaryKey = "tableName"+"_ID";
		connection();
		try {
			dmd = conn.getMetaData();
			rs = dmd.getPrimaryKeys(conn.getCatalog(), dmd.getUserName(), tableName.toUpperCase());
			while (rs.next()) {
				primaryKey = rs.getString("COLUMN_NAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		release(rs, st, conn);
		return primaryKey;
	}

	/**
	 * 根据表名查询表中列类型
	 * @param tableName 表名
	 * @return List<String>
	 */
	public static List<String> getColumnTyBypeTableNameWithList(String tableName) {
		List<String> columTypes = new LinkedList<String>();
		connection();
		try {
			dmd = conn.getMetaData();
			rs = dmd.getColumns(null, dmd.getUserName(), tableName.toUpperCase(), null);
			while (rs.next()) {
				String collumnType = rs.getString("TYPE_NAME"); //类型
				int datasize  = rs.getInt("COLUMN_SIZE"); 
				int digits =rs.getInt("DECIMAL_DIGITS");
				columTypes.add(collumnType+","+datasize+","+digits);
//				columTypes.add(rs.getString("TYPE_NAME"));
//				String cname = rs.getString("COLUMN_NAME"); 
//				String cType = rs.getString("TYPE_NAME"); 
//				System.out.println("==="+cname+"===="+cType+datasize+"==="+digits);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		release(rs, st, conn);
		return columTypes;
	}
	/**
	 * 得到数据库中所有表名
	 * @return List<String>
	 */
	public static List<String> getTableNames() {
		List<String> tableNames = new LinkedList<String>();
		connection();
		try {
			dmd = conn.getMetaData();
			rs = dmd.getTables(null, dmd.getUserName(), null, null);
			while (rs.next()) {
				tableNames.add(rs.getString("TABLE_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		release(rs, st, conn);
		return tableNames;
	}
	/**
	 * 得到数据库表注释
	 * @param tableName 表名
	 * @return 表注释
	 */
	public static String getTableRemarksByTableName(String tableName) {
		String name  = "";
		connection();
		try {
			String sql = "SHOW TABLE STATUS WHERE NAME = '" + tableName + "'";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			boolean have = rs.next();
			if(have){
				name = rs.getString("Comment");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		release(rs, st, conn);
		return name;
	}
	/**
	 * 将数据库类型转换成java类型
	 * @param columnType 数据库类型
	 * @return java类型
	 */
	public static String dbTypeToJavaType(String columnType) {
		String[] column = columnType.split(",");
		columnType = column[0];
		Integer precision = 0;
		Integer scale = 0;
		int length = column.length;
		if(length>=2){
			precision = Integer.valueOf(column[1]);
		}
		if(length>=3){
			scale = Integer.valueOf(column[2]);
		}
		String type = "";
		if (columnType == null || columnType.trim().equals("")) {
			return null;
		}
		System.out.println(columnType+"==="+precision+"===="+scale);
		if(columnType.contains("INT")|| columnType.equals("INT UNSIGNED")||columnType.equals("NUMBER")){
			if (scale > 0 || precision > 9) {
				type = "BigDecimal";
			} else if (precision > 10) {
				type = "Long";
			} else if (precision > 4) {
				type = "Integer";
			} else if (precision == 1) {
				type = "Integer";
			} else {
				type = "Integer";
			}
		}else if (columnType.equals("VARCHAR") || columnType.equals("CHAR") || columnType.equals("TEXT")) {
			type = "String";
		} else if (columnType.equals("DATE") || columnType.equals("DATETIME")) {
			type = "Timestamp";
		} else if (columnType.equals("MEDIUMBLOB")|| columnType.equals("VARBINARY")||columnType.equals("CLOB")) {
			type = "byte[]";
		} else if (columnType.equals("DECIMAL")) {
			type = "java.math.BigDecimal";
		} else {
			System.out.println("columnType[" + columnType + "]");
			type = "String";
		}
		return type;
	}
	public static void main(String[] args) {
		String list = getTableRemarksByTableName("w");
		System.out.println(list);
	}
}
