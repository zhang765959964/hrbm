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
import com.xunfeng.business.personagency.social.model.SocialsecTransfer;
import com.xunfeng.business.personagency.social.dao.SocialsecTransferDao;
import com.xunfeng.business.personagency.social.interf.SocialsecTransferServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人社保统筹范围内转移表 Service类
* @author:jiangxin
* @createDate 2016-08-12 15:39:20 
* @version V1.0   
*/
@Service
public class SocialsecTransferService extends BaseService<SocialsecTransfer> implements SocialsecTransferServiceInterf
{
	@Resource
	private SocialsecTransferDao dao;
	@Resource
	private PersonExpandDao personExpandDao;
	@Resource
	private PersonBaseInfoDao personBaseInfoDao;
	
	
	public SocialsecTransferService()
	{
	}
	
	@Override
	protected IEntityDao<SocialsecTransfer, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<SocialsecTransfer> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<SocialsecTransfer> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//添加统筹范围内转移信息，并且处理之前数据为无效状态
	public void addSocialsecTransfer(SocialsecTransfer socialsecTransfer){
		if(socialsecTransfer!=null){
			Map params=new HashMap();
			params.put("archivesId", socialsecTransfer.getArchivesId());
			List<SocialsecTransfer> list = dao.getBySqlKey("getByArchiveId", params);
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				SocialsecTransfer socialsecTransfer2 = (SocialsecTransfer) iterator.next();
				socialsecTransfer2.setIsEffective("1");
				dao.update(socialsecTransfer2);
			}
			dao.add(socialsecTransfer);
			this.syncPersonBaseinfo(socialsecTransfer);
		}
	}
	//修改统筹范围内转移信息，并且处理之前数据为无效状态
	public void updateSocialsecTransfer(SocialsecTransfer socialsecTransfer){
		 dao.update(socialsecTransfer);
		 this.syncPersonBaseinfo(socialsecTransfer);
	}
	
	//同步个人基本信息到主表中
	public void syncPersonBaseinfo(SocialsecTransfer socialsecTransfer ){
		if(socialsecTransfer!=null){
			PersonExpand personExpand= (PersonExpand) personExpandDao.getOne("getByExpPersonId", socialsecTransfer.getPersonId());
			if(personExpand!=null){
				personExpand.setExpPersonNumber(socialsecTransfer.getExpPersonNumber());
				personExpand.setExpStartJobDate(socialsecTransfer.getExpStartJobDate());
				personExpand.setExpPensionDate(socialsecTransfer.getExpPensionDate());
				personExpand.setExpMedicalDate(socialsecTransfer.getExpMedicalDate());
				personExpand.setExpPersonPhone(socialsecTransfer.getExpPersonPhone());
				personExpandDao.update(personExpand);
			}
			PersonBaseInfo personBaseInfo = personBaseInfoDao.getById(socialsecTransfer.getPersonId());
			if(personBaseInfo!=null){
				personBaseInfo.setAab301(socialsecTransfer.getAab301());
				personBaseInfo.setAae007(socialsecTransfer.getAae007());
				personBaseInfo.setAae005(socialsecTransfer.getAae005());
				personBaseInfoDao.update(personBaseInfo);
			}
		}
	}
	
}
