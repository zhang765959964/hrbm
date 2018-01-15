package com.xunfeng.sys.uums.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.uums.interf.SysUserServiceInterf;
import com.xunfeng.sys.uums.model.SysUser;

/**
 * <pre>
 * 对象功能:从业人员信息表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-27 16:40:20
 * </pre>
 */
@Repository
public class SysUserDao  implements UserDetailsService {
	
	@Resource
    @Qualifier("sysuser")
	private SysUserServiceInterf sysUserService;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		SysUser sysUser = sysUserService.getByUserName(username);
		if (sysUser == null)
			throw new UsernameNotFoundException("用户不存在");
		return sysUser;
	}

}