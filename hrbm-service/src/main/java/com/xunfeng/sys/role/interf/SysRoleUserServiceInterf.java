package com.xunfeng.sys.role.interf;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.util.EhcacheUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.role.dao.SysRoleUserDao;
import com.xunfeng.sys.role.model.SysRoleUser;
import com.xunfeng.sys.uums.model.SysUser;

/**
 * <pre>
 * 对象功能:角色人员关系表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-06-09 09:37:41
 * </pre>
 */

public interface SysRoleUserServiceInterf  extends GenericServiceInterface<SysRoleUser,Long> {

	public void delRoleUser(Long roleId, Long userId);

	public boolean isExit(Long roleId, Long userId);

	public void addUser(Long roleId, Long[] userAryId) ;

	public void delRoleUser(Long roleId, Long[] userAryId) ;
}
