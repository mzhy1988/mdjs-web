package org.cnmd.common.db.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.cnmd.common.utils.ObjectUtil;


/**
 * 实例工厂
 */
public class InstanceFactory {

	/**
	 * 用于缓存对应的实例
	 */
	private static final Map<String, Object> cache = new ConcurrentHashMap<String, Object>();

	/**
	 * DataSourceFactory
	 */
	private static final String DS_FACTORY = "framework.custom.ds_factory";
	/**
	 * DataSourceFactory
	 */
	private static final String DATA_ACCESSOR = "framework.custom.ds_accessor";

	/**
	 * 获取 DataSourceFactory
	 */
	public static DataSourceFactory getDataSourceFactory() {
		return getInstance(DS_FACTORY, DefaultDataSourceFactory.class);
	}
    /**
     * 获取 DataAccessor
     */
    public static DataAccessor getDataAccessor() {
        return getInstance(DATA_ACCESSOR, DefaultDataAccessor.class);
    }

	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String cacheKey, Class<T> defaultImplClass) {
		// 若缓存中存在对应的实例，则返回该实例
		if (cache.containsKey(cacheKey)) {
			return (T) cache.get(cacheKey);
		}
		String	implClassName = defaultImplClass.getName();
		// 通过反射创建该实现类对应的实例
		T instance = ObjectUtil.newInstance(implClassName);
		// 若该实例不为空，则将其放入缓存
		if (instance != null) {
			cache.put(cacheKey, instance);
		}
		// 返回该实例
		return instance;
	}
}
