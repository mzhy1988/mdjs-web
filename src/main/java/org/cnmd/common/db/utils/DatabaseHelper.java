package org.cnmd.common.db.utils;

import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseHelper {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseHelper.class);

	/**
	 * 定义一个局部线程变量（使每个线程都拥有自己的连接）
	 */
	private static final ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();

	/**
	 * 获取数据源工厂
	 */
	private static final DataSourceFactory dataSourceFactory = InstanceFactory.getDataSourceFactory();

	/**
	 * 获取数据访问器
	 */
	private static final DataAccessor dataAccessor = InstanceFactory.getDataAccessor();

	/**
	 * 数据库类型
	 */
	private static final String databaseType = "ORACLE";

	/**
	 * 获取数据库类型
	 */
	public static String getDatabaseType() {
		return databaseType;
	}

	/**
	 * 获取数据源
	 */
	public static DataSource getDataSource() {
		return dataSourceFactory.getDataSource();
	}

	/**
	 * 获取数据库连接
	 */
	public static Connection getConnection() {
		Connection conn;
		try {
			// 先从 ThreadLocal 中获取 Connection
			conn = connContainer.get();
			if (conn == null) {
				// 若不存在，则从 DataSource 中获取 Connection
				conn = getDataSource().getConnection();
				// 将 Connection 放入 ThreadLocal 中
				if (conn != null) {
					connContainer.set(conn);
				}
			}
		} catch (SQLException e) {
			logger.error("获取数据库连接出错！", e);
			throw new RuntimeException(e);
		}
		return conn;
	}

	/**
	 * 开启事务
	 */
	public static void beginTransaction() {
		Connection conn = getConnection();
		if (conn != null) {
			try {
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				logger.error("开启事务出错！", e);
				throw new RuntimeException(e);
			} finally {
				connContainer.set(conn);
			}
		}
	}

	/**
	 * 提交事务
	 */
	public static void commitTransaction() {
		Connection conn = getConnection();
		if (conn != null) {
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				logger.error("提交事务出错！", e);
				throw new RuntimeException(e);
			} finally {
				connContainer.remove();
			}
		}
	}

	/**
	 * 回滚事务
	 */
	public static void rollbackTransaction() {
		Connection conn = getConnection();
		if (conn != null) {
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e) {
				logger.error("回滚事务出错！", e);
				throw new RuntimeException(e);
			} finally {
				connContainer.remove();
			}
		}
	}
	/**
	 * 执行更新语句（包括：update、insert、delete）
	 */
	public static int update(String sql, Object... params) {
		return dataAccessor.update(sql, params);
	}
	public static Object exeQuery(Class<?> clazz,String sql, Object ... params){
		return dataAccessor.queryEntity(clazz,sql, params);
	}
    /**
     * 根据 SQL 语句查询 Entity
     */
    public static <T> T queryEntity(Class<T> entityClass, String sql, Object... params) {
        return dataAccessor.queryEntity(entityClass, sql, params);
    }

    /**
     * 根据 SQL 语句查询 Entity 列表
     */
    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {
        return dataAccessor.queryEntityList(entityClass, sql, params);
    }

}
