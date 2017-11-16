package org.cnmd.common.db.utils;


import javax.sql.DataSource;

/**
 * 抽象数据源工厂
 */
public abstract class AbstractDataSourceFactory<T extends DataSource> implements DataSourceFactory {

	protected final String driver = "oracle.jdbc.OracleDriver";
	protected final String url = "jdbc:oracle:thin:@192.168.20.240:1521:CHCINFODB";
	protected final String username = "scm_b2b_dev";
	protected final String password = "scm_b2b_dev";

	@Override
	public final T getDataSource() {
		// 创建数据源对象
		T ds = createDataSource();
		// 设置基础属性
		setDriver(ds, driver);
		setUrl(ds, url);
		setUsername(ds, username);
		setPassword(ds, password);
		// 设置高级属性
		setAdvancedConfig(ds);
		return ds;
	}

	public abstract T createDataSource();

	public abstract void setDriver(T ds, String driver);

	public abstract void setUrl(T ds, String url);

	public abstract void setUsername(T ds, String username);

	public abstract void setPassword(T ds, String password);

	public abstract void setAdvancedConfig(T ds);
}
