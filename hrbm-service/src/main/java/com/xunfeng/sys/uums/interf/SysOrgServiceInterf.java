package com.xunfeng.sys.uums.interf;
import java.util.List;
import java.util.Map;

import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.uums.model.SysOrg;

/**
 *<pre>
 * 对象功能:职介机构表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-29 16:03:27
 *</pre>
 */
public interface SysOrgServiceInterf  extends GenericServiceInterface<SysOrg,Long>
{
	
	@SuppressWarnings("rawtypes")
	public void update(Map dataMap,SysOrg sysOrg);
	
	/**
	 * 分页查询数据获得
	 * @param queryFilter 检索条件
	 * @param pb 分页参数
	 * @return 数据结果
	 */
	public ResultData<SysOrg> getPageList(QueryFilter queryFilter);
	
	/**
	 * 查询子级机构
	 * @param acd200 机构编码
	 * @return 机构列表
	 */
	public List<SysOrg> getSubOrgans(Long acd200);
	/**
	 * 查询服务结构
	 * @return
	 */
	public  ResultData<Map> getSysOrgByExcept(PageBean pageBean,Map<String,String> param);
	
	public List<SysOrg> getSubOrgList(Long acd200) ;
}
