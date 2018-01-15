package com.xunfeng.business.personagency.receive.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.receive.model.ProxyManual;
import com.xunfeng.business.personagency.receive.dao.ProxyManualDao;
import com.xunfeng.business.personagency.receive.interf.ProxyManualServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 代理手册表 Service类
* @author:jx
* @createDate 2016-07-07 09:37:15 
* @version V1.0   
*/
@Service
public class ProxyManualService extends BaseService<ProxyManual> implements ProxyManualServiceInterf
{
	@Resource
	private ProxyManualDao dao;
	
	
	
	public ProxyManualService()
	{
	}
	
	@Override
	protected IEntityDao<ProxyManual, Long> getEntityDao() 
	{
		return dao;
	}
	/**
	 * @param fiter 查询代理手册
	 * @return
	 */
	public ResultData  getAllProxyManual(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Map> dataList= dao.getAllProxyManual( fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	/**
	 * @param lAryId  删除代理手册合同
	 */
	public void deleteProxyManualByIds(Long[] lAryId){
		if(BeanUtils.isEmpty(lAryId)) return;
		for (Long pmId : lAryId){
			ProxyManual pm = dao.getById(pmId);
			pm.setProxyDelete(1L);
			dao.update(pm);
		}
	}
	
}
