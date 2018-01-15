package com.xunfeng.business.ovemp.corp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.ovemp.corp.dao.OvempCorpOrgDao;
import com.xunfeng.business.ovemp.corp.dto.OvempCorpDto;
import com.xunfeng.business.ovemp.corp.interf.OvempCorpServiceInterf;
import com.xunfeng.business.ovemp.corp.model.OvempCorp;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训机构表 Service类
* @author:Wang.CS
* @createDate 2016-05-23 09:30:42 
* @version V1.0   
*/
@Service
public class OvempCorpService extends BaseService<OvempCorp> implements OvempCorpServiceInterf
{
	@Resource
	private OvempCorpOrgDao dao;
	
	
	
	public OvempCorpService()
	{
	}
	
	@Override
	protected IEntityDao<OvempCorp, Long> getEntityDao() 
	{
		return dao;
	}


	public ResultData<Map> getResultDataTrainCorpResume(PageBean pageBean,
			Map param) {
		QueryFilter fiter=new QueryFilter();
		fiter.setPageBean(pageBean);
		String orgType = (String)param.get("orgType");
		String orgName = (String)param.get("orgName");
		if (orgType != null && !orgType.equals("")){
            fiter.addFilter("orgType",orgType);
        }
		if(orgName != null && !orgName.equals("")){
            fiter.addFilter("orgName","%"+orgName+"%");
        }
		List<Map> dataList = (List<Map>)dao.getListForm("getOrgByCondition",fiter);
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(fiter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	
	/**
	 * 首页找培训
	 * @param pageBean
	 * @param param
	 * @return
	 */
	public ResultData<Map> getResultDataTrainCorp(PageBean pageBean,
			Map<String,String> param) {
		QueryFilter fiter=new QueryFilter();
		fiter.setPageBean(pageBean);
		String orgkey = param.get("orgkey");
		String coursekey = param.get("coursekey");
		String localCity = param.get("localCity");
		if (StringUtil.isNotEmpty(orgkey) && !orgkey.equals("0")){
			fiter.addFilter("orgkey","%"+orgkey+"%");
		}
		if(StringUtil.isNotEmpty(coursekey) && !coursekey.equals("0")){
			fiter.addFilter("coursekey","%"+coursekey+"%");
		}
		if(StringUtil.isNotEmpty(localCity) && !localCity.equals("0")){
			fiter.addFilter("localCity",localCity);
		}
		List<Map> dataList = (List<Map>)dao.getListForm("getOrgMapByCondition",fiter);
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(fiter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}

	public ResultData<Map> getResultDataHotTrainCorpResume(PageBean pageBean) {
		QueryFilter fiter=new QueryFilter();
		fiter.setPageBean(pageBean);
		List<Map> dataList = (List<Map>)dao.getListForm("getHotTrainCorp",fiter);
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(fiter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	
    /**
     * 为企业创建登录用户
     * @param ovempCorp
     */
    public void createrLoginUser(OvempCorp ovempCorp){
    	dao.insert("insertOrgUser", ovempCorp); 
    }

	public OvempCorpDto getTrainOrgById(Long id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("orgId", id);
		map.put("needContent", 0);
		List<OvempCorpDto> dataList = (List<OvempCorpDto>)dao.getListBySqlKey("getTrainCorpById",map);
		if(dataList!=null &&dataList.size()>0){
			return dataList.get(0);
		}else{
			return null;
		}
	}
	public OvempCorpDto getTrainOrgNoContentById(Long id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("orgId", id);
		List<OvempCorpDto> dataList = (List<OvempCorpDto>)dao.getListBySqlKey("getTrainCorpById",map);
		if(dataList!=null &&dataList.size()>0){
			return dataList.get(0);
		}else{
			return null;
		}
	}

	public OvempCorp getTrainOrgByOrgId(Long id) {
		return dao.getById(id);
	}

	public int updateDisableStatus(Map<String, Object> paramMap) {
		
		return dao.update("updateBatchDisable", paramMap);
	}

	public int updateDelStatus(Map<String, Object> paramMap) {
		
		return dao.update("updateBatchDel", paramMap);
	}

	public int updateAuditStatus(Map<String, Object> paramMap) {
		
		return dao.update("updateBatchAudit", paramMap);
	}

	public ResultData<OvempCorp> getTrainOrgData(QueryFilter fiter) {
		ResultData<OvempCorp> resultData=new ResultData<OvempCorp>();
		List<OvempCorp> dataList =dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	public OvempCorp getOrgByAccount(String orgAccount) {
		
		return dao.getUnique("getOrgByAccount", orgAccount);
	}

	public OvempCorp getOrgByName(String orgName) {
		
		return dao.getUnique("getOrgByName", orgName);
	}

	public OvempCorp getOrgByPubName(String orgPublishName) {
		
		return dao.getUnique("getOrgByPubName", orgPublishName);
	}
	
	
}
