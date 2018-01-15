
package com.xunfeng.core.util;

import java.net.URL;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**  
 * @company: 河南讯丰信息技术有限公司 
 * @Description: EhcacheUtil操作工具类
 * @author wanghan 
 * @createDate 2015年6月11日-上午9:45:46 
 * @version V1.0   
 */
public class EhcacheUtil {  
	  
    private static final String path = "/conf/ehcache.xml";  
  
    private URL url;  
  
    private CacheManager manager;  
  
    private static EhcacheUtil ehCache;  
  
    private EhcacheUtil(String path) {  
        url = getClass().getResource(path);  
        manager = CacheManager.create(url);  
    }  
  
    public static EhcacheUtil getInstance() {  
        if (ehCache== null) {  
            ehCache= new EhcacheUtil(path);  
        }  
        return ehCache;  
    }  
  
    public void put(String cacheName, Object key, Object value) {  
        Cache cache = manager.getCache(cacheName);  
        Element element = new Element(key, value);  
        cache.put(element);  
    }  
  
    public Object get(String cacheName, Object key) {  
        Cache cache = manager.getCache(cacheName);  
        Element element = cache.get(key);  
        return element == null ? null : element.getObjectValue();  
    }  
  
    public Cache get(String cacheName) {  
        return manager.getCache(cacheName);  
    }  
  
    public void remove(String cacheName, Object key) {  
        Cache cache = manager.getCache(cacheName);  
        cache.remove(key);  
    }  
  
}  