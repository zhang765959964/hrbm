package com.xunfeng.business.personagency.social.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.person.dao.PersonBaseInfoDao;
import com.xunfeng.business.person.dao.PersonExpandDao;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.personagency.social.model.ChangeReporting;
import com.xunfeng.business.personagency.social.dao.ChangeReportingDao;
import com.xunfeng.business.personagency.social.interf.ChangeReportingServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人社保变更申报记录表 Service类
* @author:jiangxin
* @createDate 2016-08-11 09:36:03 
* @version V1.0   
*/
@Service
public class ChangeReportingService extends BaseService<ChangeReporting> implements ChangeReportingServiceInterf
{
	@Resource
	private ChangeReportingDao dao;
	@Resource
	private PersonExpandDao personExpandDao;
	@Resource
	private PersonBaseInfoDao personBaseInfoDao;
	
	
	public ChangeReportingService()
	{
	}
	
	@Override
	protected IEntityDao<ChangeReporting, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<ChangeReporting> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ChangeReporting> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//添加变更申报信息，并且处理之前数据为无效状态
	public void addChangeReporting(ChangeReporting changeReporting){
		if(changeReporting!=null){
			Map params=new HashMap();
			params.put("archivesId", changeReporting.getArchivesId());
			List<ChangeReporting> list = dao.getBySqlKey("getByArchiveId", params);
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				ChangeReporting changeReporting2 = (ChangeReporting) iterator.next();
				changeReporting2.setIsEffective("1");
				dao.update(changeReporting2);
			}
			dao.add(changeReporting);
			this.syncPersonBaseinfo(changeReporting);
		}
	}
	//修改变更申报信息，并且处理之前数据为无效状态
	public void updateChangeReporting(ChangeReporting changeReporting){
		 dao.update(changeReporting);
		 this.syncPersonBaseinfo(changeReporting);
	}
	//同步个人基本信息到主表中
	public void syncPersonBaseinfo(ChangeReporting changeReporting){
		if(changeReporting!=null){
			PersonExpand personExpand= (PersonExpand) personExpandDao.getOne("getByExpPersonId", changeReporting.getPersonId());
			if(personExpand!=null){
				personExpand.setExpPersonNumber(changeReporting.getExpPersonNumber());
				personExpand.setExpStartJobDate(changeReporting.getExpStartJobDate());
				personExpand.setExpPensionDate(changeReporting.getExpPensionDate());
				personExpand.setExpMedicalDate(changeReporting.getExpMedicalDate());
				personExpand.setExpPersonPhone(changeReporting.getExpPersonPhone());
				personExpandDao.update(personExpand);
			}
			PersonBaseInfo personBaseInfo = personBaseInfoDao.getById(changeReporting.getPersonId());
			if(personBaseInfo!=null){
				personBaseInfo.setAab301(changeReporting.getAab301());
				personBaseInfo.setAae007(changeReporting.getAae007());
				personBaseInfo.setAae005(changeReporting.getAae005());
				personBaseInfoDao.update(personBaseInfo);
			}
		}
	}
	//获取变更申报打印数据
	public Map getChangeReportingById(Long id){
		Map params=new HashMap();
		params.put("id", id);
		return (Map)dao.getOne("getChangeReportingById", params);
	}
	
}
