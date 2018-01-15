package com.xunfeng.core.cache.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.xunfeng.core.cache.ICache;
import com.xunfeng.core.util.MapUtil;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 内存缓存实现，缓存放到本地的一个hashMap中
* @author wanghan 
* @createDate 2015年4月23日-下午2:31:38 
* @version V1.0   
*/
public class MemoryCache implements ICache {
	
	private Map<String, Object > cache=(Map<String, Object>) Collections.synchronizedMap(new  HashMap<String, Object >());

	@Override
	public synchronized  void add(String key, Object obj, int timeout) {
		cache.put(key, obj);
		
	}
	
	@Override
	public synchronized  void add(String key, Object obj) {
		cache.put(key, obj);
	}


	@Override
	public synchronized  void delByKey(String key) {
		cache.remove(key);
		
	}

	@Override
	public  void clearAll() {
		cache.clear();
		
	}

	@Override
	public synchronized  Object getByKey(String key) {
		return cache.get(key);
	}

	@Override
	public boolean containKey(String key) {
		return cache.containsKey(key);
	}

	
}
