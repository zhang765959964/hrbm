package com.xunfeng.sys.uums.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.MapBeanCopyUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.uums.dao.SysDeptDao;
import com.xunfeng.sys.uums.dao.SysUserDao;
import com.xunfeng.sys.uums.interf.SysDeptServiceInterf;
import com.xunfeng.sys.uums.model.SysDept;

/**
 *<pre>
 * 对象功能:科室表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-30 09:51:03
 *</pre>
 */
@Service
public class SysDeptService extends BaseService<SysDept> implements SysDeptServiceInterf 
{
	@Resource
	private SysDeptDao dao;
	
	@Resource
	private SysUserService sysUserService;
	
	@Resource
	private SysUserDao sysUserDao;
	
	public SysDeptService()
	{
	}
	
	@Override
	protected IEntityDao<SysDept, Long> getEntityDao() 
	{
		return dao;
	}
	@SuppressWarnings("unchecked")
	public void update(Map dataMap,SysDept sysDept)
	{
		SysDept old_SysDept=dao.getById(sysDept.getDep001());
		SysDept new_SysDept=MapBeanCopyUtil.MapToBean(dataMap, old_SysDept);
		dao.update(new_SysDept);
	}
	
	@Override
	public ResultData<SysDept> getDepPageList(QueryFilter queryFilter) {
		@SuppressWarnings("unchecked")
		List<SysDept> oaDepartments = dao.getListForm("getAll", queryFilter);
		ResultData<SysDept> resultData = new ResultData<SysDept>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(oaDepartments);
		return resultData;
	}
	
	@Override
	public void delById(Long dep001) {
		Map params=new HashMap();
		params.put("dep001", dep001);
		
		sysUserDao.update("delDeptUser", params);
		super.delById(dep001);
	}
}
