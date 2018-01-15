package  com.xunfeng.core.db.datasource;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年4月25日-上午11:17:14 
* @version V1.0   
*/
public class DynamicDataSource extends AbstractRoutingDataSource {

	/**
	 * 取得当前使用那个数据源。
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return DbContextHolder.getDataSource();  
	}
	
	@Override  
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {  
        super.setTargetDataSources(targetDataSources);  
        //重点  
        super.afterPropertiesSet();  
    }  
	
	private static Object getValue(Object instance, String fieldName) throws IllegalAccessException, NoSuchFieldException {  
		Field field =AbstractRoutingDataSource.class.getDeclaredField(fieldName);  
		// 参数值为true，禁用访问控制检查  
		field.setAccessible(true);  
		return field.get(instance);  
	}  
	
	/**
	 * 添加数据源。
	 * @param key
	 * @param dataSource
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException 
	 * void
	 */
	public void addDataSource(String key,Object dataSource) throws IllegalAccessException, NoSuchFieldException{  
		 Map<Object, Object> targetDataSources =(Map<Object, Object>) getValue(this, DataSourceUtil.TARGET_DATASOURCES);
		 boolean rtn=isDataSourceExist(key);
		 if(rtn){
			 throw new DataSourceException("datasource name :" + key +"is exists!");
		 }else{
			 logger.info("datasource name :" + key +" 成功加入数据源");
		 }
	     targetDataSources.put(key, dataSource);  
	     setTargetDataSources(targetDataSources);  
	}  
	
	/**
	 * 指定数据源是否存在。 
	 * @param key
	 * @return
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException 
	 * boolean
	 */
	public boolean isDataSourceExist(String key) throws IllegalAccessException, NoSuchFieldException{  
		 Map<Object, Object> targetDataSources =(Map<Object, Object>) getValue(this, DataSourceUtil.TARGET_DATASOURCES);
	     
		 return targetDataSources.containsKey(key);
	}  
	
	/**
	 * 根据别名删除数据源。
	 * @param key
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException 
	 * void
	 */
	public void removeDataSource(String key) throws IllegalAccessException, NoSuchFieldException{  
		 Map<Object, Object> targetDataSources =(Map<Object, Object>) getValue(this,DataSourceUtil.TARGET_DATASOURCES);
		 
		 if(key.equals(DataSourceUtil.GLOBAL_DATASOURCE) || key.equals(DataSourceUtil.DEFAULT_DATASOURCE)) {
				throw new DataSourceException("datasource name :" + key +" can't be removed!");
		 }
		 targetDataSources.remove(key);
		 setTargetDataSources(targetDataSources);  
	} 
	
	/**
	 * 返回当前有哪些数据源。
	 * @return
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException 
	 * Map<Object,Object>
	 */
	public Map<Object, Object> getDataSource() throws IllegalAccessException, NoSuchFieldException{  
		 Map<Object, Object> targetDataSources =(Map<Object, Object>) getValue(this,DataSourceUtil.TARGET_DATASOURCES);
		 return targetDataSources;
		   
	}  

	
	public Logger getParentLogger() {
		return null;
	}

	
}
