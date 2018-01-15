package com.xunfeng.sys.component.interf;

import com.xunfeng.sys.accounts.model.Accounts;

/**
 * 邮箱接口
 * @author jx
 * 2016.06.29
 */
public interface SenderEmailServiceInterf {
	public boolean sendEamil(Long id,String to,Accounts loginUser,String contextPath);
	public boolean sendEamilForLookPwd(String emailPath,String contextPath);
	public Object decrypt (String message);
}
