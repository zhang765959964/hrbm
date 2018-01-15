package com.xunfeng.business.hrtool.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.hrtool.dao.HRToolModelDao;
import com.xunfeng.business.hrtool.interf.HRToolModelServiceInterf;
import com.xunfeng.business.hrtool.model.HRToolModel;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: hr工具箱模板表 Service类
* @author:wanghan
* @createDate 2016-03-08 17:26:01 
* @version V1.0   
*/
@Service
public class HRToolModelService extends BaseService<HRToolModel> implements HRToolModelServiceInterf
{
	@Resource
	private HRToolModelDao dao;
	
	
	
	public HRToolModelService()
	{
	}
	
	@Override
	protected IEntityDao<HRToolModel, Long> getEntityDao() 
	{
		return dao;
	}
	
	public  List<HRToolModel> getHRToolModelListByColId(Long colId){
		Map params=new HashMap();
		params.put("colId", colId);
		return dao.getBySqlKey("getAll", params);
		
	}
	
	public void updateDownNum(Long id) {
		Map params=new HashMap();
		params.put("id", id);
		dao.update("updateDownNum", params);

	}
	public  List<HRToolModel> getHrModelHotList(int page,int pageSize){
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(page);
		pageBean.setPagesize(pageSize);
		return dao.getBySqlKey("getHotList",null,pageBean);
		
	}
	public ResultData<HRToolModel> getAllHRToolModel(QueryFilter fiter){
		
		ResultData<HRToolModel> resultData=new ResultData<HRToolModel>();
		List<HRToolModel> dataList =dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
}
