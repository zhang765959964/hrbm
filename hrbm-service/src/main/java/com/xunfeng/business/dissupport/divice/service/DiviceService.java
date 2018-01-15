package com.xunfeng.business.dissupport.divice.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.uums.dao.SysOrgDao;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.business.dissupport.divice.model.DevType;
import com.xunfeng.business.dissupport.divice.model.Divice;
import com.xunfeng.business.dissupport.divice.model.DiviceModel;
import com.xunfeng.business.dissupport.divice.dao.DevTypeDao;
import com.xunfeng.business.dissupport.divice.dao.DiviceDao;
import com.xunfeng.business.dissupport.divice.dao.DiviceModelDao;
import com.xunfeng.business.dissupport.divice.interf.DiviceServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 设备表 Service类
* @author:wanghan
* @createDate 2016-07-27 17:06:00 
* @version V1.0   
*/
@Service
public class DiviceService extends BaseService<Divice> implements DiviceServiceInterf
{
	@Resource
	private DiviceDao dao;
	
	@Resource
	private SysOrgDao orgDao;
	
	@Resource
	private DevTypeDao devDao;
	@Resource
	private DiviceModelDao modelDao;
	public DiviceService()
	{
	}
	
	@Override
	protected IEntityDao<Divice, Long> getEntityDao() 
	{
		return dao;
	}
	
	@Override
	public void add(Divice entity) {
		SysOrg sysorg = orgDao.getById(entity.getAcd200());
		DevType diviceModel =devDao.getById(entity.getDiv014());
		//设备型号获取
		entity.setAcd201(sysorg.getAcd201());
		entity.setTypeSpl(diviceModel.getTypeSpl());
		super.add(entity);
	}
	
	@Override
	public ResultData<Map<String, Object>> getViewList(
			QueryFilter queryFilter) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> dataList=(List<Map<String, Object>>)dao.getListForm("getViewList",queryFilter);
		ResultData<Map<String, Object>> resultData = new ResultData<Map<String, Object>>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
}
