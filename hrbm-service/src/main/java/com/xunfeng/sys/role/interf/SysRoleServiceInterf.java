package com.xunfeng.sys.role.interf;
import java.util.List;
import java.util.Map;

import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.role.model.SysRole;

/**
 *<pre>
 * 对象功能:系统角色表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-06-08 16:08:57
 *</pre>
 */

public interface SysRoleServiceInterf  extends GenericServiceInterface<SysRole,Long>
{
	
	/**获取某个用户下所拥有的角色列表，并将结果放入缓存
	 * @param userId
	 * @return
	 */
	public List<SysRole> getUserRole(Long userId);
	
	
	/**获取某个资源对应的角色集合,判断某个路径是不是系统资源，如果是返回给路径的角色集合
	 * @param url  资源url
	 * @return  角色列表
	 */
	public Map getRightResRole(String url);
	
	/**获取某个资源对应的角色集合
	 * @param url  资源url
	 * @return  角色列表
	 */
	public List<SysRole> getResRole(Long resId);
	
	/**
	 * 分页查询数据获得
	 * @param queryFilter 检索条件
	 * @param pb 分页参数
	 * @return 数据结果
	 */
	public ResultData<SysRole> getPageList(QueryFilter queryFilter);
}
