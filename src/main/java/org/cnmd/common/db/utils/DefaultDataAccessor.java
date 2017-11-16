package org.cnmd.common.db.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 默认数据访问器
 */
public class DefaultDataAccessor implements DataAccessor {

	private static final Logger logger = LoggerFactory.getLogger(DefaultDataAccessor.class);

	private final QueryRunner queryRunner;

	public DefaultDataAccessor() {
		DataSource dataSource = DatabaseHelper.getDataSource();
		queryRunner = new QueryRunner(dataSource);
	}

	public <T> T queryEntity(Class<T> entityClass, String sql, Object... params) {
		T result;
		try {
			result = queryRunner.query(sql, new BeanHandler<T>(entityClass), params);
		} catch (SQLException e) {
			logger.error("查询出错！", e);
			throw new RuntimeException(e);
		}
		printSQL(sql);
		return result;
	}



	public long queryCount(String sql, Object... params) {
		long result;
		try {
			result = queryRunner.query(sql, new ScalarHandler<Long>("count(*)"), params);
		} catch (SQLException e) {
			logger.error("查询出错！", e);
			throw new RuntimeException(e);
		}
		printSQL(sql);
		return result;
	}

	@Override
	public int update(String sql, Object... params) {
		int result;
		try {
			Connection conn = DatabaseHelper.getConnection();
			result = queryRunner.update(conn, sql, params);
		} catch (SQLException e) {
			logger.error("更新出错！", e);
			throw new RuntimeException(e);
		}
		printSQL(sql);
		return result;
	}

	@Override
	public <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {
		List<T> result;
		try {
			result = queryRunner.query(sql, new BeanListHandler<T>(entityClass), params);
		} catch (SQLException e) {
			logger.error("查询出错！", e);
			throw new RuntimeException(e);
		}
		printSQL(sql);
		return result;
	}

	private static void printSQL(String sql) {
		logger.debug(" SQL - {}", sql);
	}
}
