package com.xunfeng.business.train.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.train.dao.TrainOrgDao;
import com.xunfeng.business.train.dto.TrainOrgDto;
import com.xunfeng.business.train.interf.TrainOrgServiceInterf;
import com.xunfeng.business.train.model.TrainOrg;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.sendmessage.model.MessageTemplates;
import com.xunfeng.sys.sendmessage.service.MessageTemplatesService;
import com.xunfeng.sys.sendmessage.service.SenderService;
import com.xunfeng.sys.sendmessage.util.ContentConversion;
import com.xunfeng.sys.sendmessage.util.ContentModel;
import com.xunfeng.sys.sendmessage.util.MsgTypeEmun;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训机构表 Service类
* @author:Wang.CS
* @createDate 2016-05-23 09:30:42 
* @version V1.0   
*/
@Service
public class TrainOrgService extends BaseService<TrainOrg> implements TrainOrgServiceInterf
{
	@Resource
	private TrainOrgDao dao;
	@Resource
	private MessageTemplatesService messageTemplatesService;
	@Resource
	private SenderService senderService;
	
	public TrainOrgService()
	{
	}
	
	@Override
	protected IEntityDao<TrainOrg, Long> getEntityDao() 
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


	public TrainOrgDto getTrainOrgById(Long id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("orgId", id);
		map.put("needContent", 0);
		List<TrainOrgDto> dataList = (List<TrainOrgDto>)dao.getListBySqlKey("getTrainCorpById",map);
		if(dataList!=null &&dataList.size()>0){
			return dataList.get(0);
		}else{
			return null;
		}
	}
	public TrainOrgDto getTrainOrgNoContentById(Long id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("orgId", id);
		List<TrainOrgDto> dataList = (List<TrainOrgDto>)dao.getListBySqlKey("getTrainCorpById",map);
		if(dataList!=null &&dataList.size()>0){
			return dataList.get(0);
		}else{
			return null;
		}
	}

	public TrainOrg getTrainOrgByOrgId(Long id) {
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

	public ResultData<TrainOrg> getTrainOrgData(QueryFilter fiter) {
		ResultData<TrainOrg> resultData=new ResultData<TrainOrg>();
		List<TrainOrg> dataList =dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	public TrainOrg getOrgByAccount(String orgAccount) {
		
		return dao.getUnique("getOrgByAccount", orgAccount);
	}

	public TrainOrg getOrgByName(String orgName) {
		
		return dao.getUnique("getOrgByName", orgName);
	}

	public TrainOrg getOrgByPubName(String orgPublishName) {
		
		return dao.getUnique("getOrgByPubName", orgPublishName);
	}
	public TrainOrg getOrgByCertificate(String certificateId) {
		Map <String,Object> map = new HashMap<String, Object>();
		map.put("certificateId", certificateId);
	    List<TrainOrg> TrainOrgList = dao.getBySqlKey("getOrgByCertificate",map);
	    if(TrainOrgList!=null && TrainOrgList.size()>0){
	    	return TrainOrgList.get(0);
	    }else{
	    	return null;
	    }
	}
	public TrainOrg getOrgByCertificate(String certificateId,Long orgId) {
		Map <String,Object> map = new HashMap<String, Object>();
		map.put("certificateId", certificateId);
		map.put("orgId", orgId);
	    List<TrainOrg> TrainOrgList = dao.getBySqlKey("getOrgByCertificate",map);
	    if(TrainOrgList!=null && TrainOrgList.size()>0){
	    	return TrainOrgList.get(0);
	    }else{
	    	return null;
	    }
	}
	public void saveRegistTrainOrg(TrainOrg trainOrg){
	    dao.add(trainOrg);
	    //发送短息
	    MessageTemplates  messageTemplates = messageTemplatesService.getById(MsgTypeEmun.trainReg.getCode());//messageTemplatesService.getById(11l);
		ContentModel cm = new ContentModel();
		cm.setTrainAccount(trainOrg.getOrgAccount());
		cm.setTrainPwd(trainOrg.getOrgPwd());
		String content = ContentConversion.modelConversionContent(cm, messageTemplates.getComm04());
		senderService.sendVerificationCode(trainOrg.getContactsTel(), content);
	}
	
}
