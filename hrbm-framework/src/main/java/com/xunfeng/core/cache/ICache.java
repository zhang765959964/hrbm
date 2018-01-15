package com.xunfeng.core.cache;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description:   缓存操作接口。
* 定义了增加缓存，删除缓存，清除缓存，读取缓存接口。
* @author wanghan 
* @createDate 2015年4月23日-下午2:30:52 
* @version V1.0   
*/
public interface ICache {
	/**
	 * 添加缓存
	 * @param key
	 * @param obj
	 * @param timeout
	 */
	void add(String key,Object obj,int timeout);
	
	void add(String key,Object obj);
	
	/**
	 * 根据键删除缓存
	 * @param key
	 */
	void delByKey(String key);
	
	/**
	 * 清除所有的缓存
	 */
	void clearAll();
	
	/**
	 * 读取缓存
	 * @param key
	 * @return
	 */
	Object getByKey(String key);
	
	/**
	 * 包含key。
	 * @param key
	 * @return
	 */
	boolean containKey(String key);
}
