package com.xunfeng.sys.identity.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.identity.interf.SSOTokenServiceInterf;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 当前登录用户service
 * @author:wanghan
 * @createDate 2016-04-26 16:58:53
 * @version V1.0
 */
@Service
public class SsoTokenService implements SSOTokenServiceInterf {
	// 存储数据的对象
	private static Map<String, Accounts> dataMap = new HashMap<String, Accounts>();
	private static Map<String, List<Map>> dataSessionMap = new HashMap<String, List<Map>>();

	public void addToken(String token, Accounts user, String sessionid, String contextPath) {
		dataMap.put(token, user);
		List<Map> sessionList = dataSessionMap.get(token);
		if (sessionList != null) {
			Map sessionMap = new HashMap();
			sessionMap.put(contextPath, sessionid);
			sessionList.add(sessionMap);
		} else {
			sessionList = new ArrayList();
			Map sessionMap = new HashMap();
			sessionMap.put(contextPath, sessionid);
			sessionList.add(sessionMap);
			dataSessionMap.put(token, sessionList);
		}

	}

	public Accounts getToken(String token) {
		return dataMap.get(token);
	}

	public List<Map> getTokenSessionList(String token) {

		return dataSessionMap.get(token);
	}
	
	public void addTokenSession(String token,String sessionid, String contextPath) {

		List<Map> sessionList = dataSessionMap.get(token);
		if (sessionList != null) {
			Map sessionMap = new HashMap();
			sessionMap.put(contextPath, sessionid);
			sessionList.add(sessionMap);
		} else {
			sessionList = new ArrayList();
			Map sessionMap = new HashMap();
			sessionMap.put(contextPath, sessionid);
			sessionList.add(sessionMap);
			dataSessionMap.put(token, sessionList);
		}
	}

	public String getSessionId(String token, String contextPath) {

		List<Map> mapList = getTokenSessionList(token);
        if(mapList==null||mapList.size()==0) return null;
		for (Map map : mapList) {
			if (map.get(contextPath) != null) {
				return (String) map.get(contextPath);
			}

		}

		return null;
	}

	public void removeToken(String token) {
		dataMap.remove(token);
		dataSessionMap.remove(token);
	}

}
