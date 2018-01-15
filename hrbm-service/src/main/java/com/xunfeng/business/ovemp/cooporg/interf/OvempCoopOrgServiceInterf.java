package com.xunfeng.business.ovemp.cooporg.interf;
import java.util.List;
import java.util.Map;

import com.xunfeng.business.ovemp.cooporg.model.OvempCoopOrg;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;

/**
 *<pre>
 * 对象功能:职介机构表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-29 16:03:27
 *</pre>
 */
public interface OvempCoopOrgServiceInterf  extends GenericServiceInterface<OvempCoopOrg,Long>
{
	
	@SuppressWarnings("rawtypes")
	public void update(Map dataMap,OvempCoopOrg sysOrg);
	
	/**
	 * 分页查询数据获得
	 * @param queryFilter 检索条件
	 * @param pb 分页参数
	 * @return 数据结果
	 */
	public ResultData<OvempCoopOrg> getPageList(QueryFilter queryFilter);
	
	/**
	 * 禁用解禁修改
	 * @param params 合作机构编号 禁用状态 
	 */
	public void updateStauts(Map<String, Object> params);
	
	/**
	 * 查询子级机构
	 * @param acd200 机构编码
	 * @return 机构列表
	 */
	public List<OvempCoopOrg> getSubOrgans(Long acd200);
	/**
	 * 查询服务结构
	 * @return
	 */
	public  ResultData<Map> getSysOrgByExcept(PageBean pageBean,Map<String,String> param);
}
