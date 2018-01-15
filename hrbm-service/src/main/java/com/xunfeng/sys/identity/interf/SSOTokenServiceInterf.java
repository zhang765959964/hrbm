package com.xunfeng.sys.identity.interf;

import java.util.List;
import java.util.Map;

import com.xunfeng.sys.accounts.model.Accounts;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 摊位退订表 接口类
 * @author:wanghan
 * @createDate 2016-04-26 16:58:53
 * @version V1.0
 */
public interface SSOTokenServiceInterf {

	public void addToken(String token, Accounts user, String sessionid, String contextPath);

	public Accounts getToken(String token);

	public List<Map> getTokenSessionList(String token);
	
	public void addTokenSession(String token,String sessionid, String contextPath);

	public String getSessionId(String token, String contextPath);

	public void removeToken(String token);
}
