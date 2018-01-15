package com.xunfeng.business.personagency.retired.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.retired.dao.RetiredCardDao;
import com.xunfeng.business.personagency.retired.dto.RetiredCardDto;
import com.xunfeng.business.personagency.retired.interf.RetiredCardServiceInterf;
import com.xunfeng.business.personagency.retired.model.RetiredCard;
import com.xunfeng.business.personagency.retired.model.RetiredDeclare;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员领取退休证 Service类
* @author:zhangfan
* @createDate 2016-08-05 11:14:07 
* @version V1.0   
*/
@Service
public class RetiredCardService extends BaseService<RetiredCard> implements RetiredCardServiceInterf
{
	@Resource
	private RetiredCardDao dao;
	
	@Resource
	private RetiredDeclareService retiredDeclareService;	//退休申诉service
	
	
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	
	public RetiredCardService()
	{
	}
	
	@Override
	protected IEntityDao<RetiredCard, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<RetiredCard> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<RetiredCard> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}

	@Override
	public ResultData getRetiredPersonList(QueryFilter fiter) {
		ResultData resultData=new ResultData<RetiredDeclare>();
		List dataList =dao.getBySqlKey("getRetiredPersonList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	
	@Override
	public ResultData getRetiredReportList(QueryFilter fiter) {
		ResultData resultData=new ResultData<RetiredDeclare>();
		List dataList =dao.getBySqlKey("getRetiredReport", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	
	
	@Override
	public void saveOrUpdate(RetiredCardDto retiredCardDto) {
		 RetiredDeclare retiredDeclare = retiredDeclareService.getById(retiredCardDto.getRetiredDeclareId());	//退休申诉信息
		 if(retiredDeclare!=null){
			 RetiredCard retiredCard =  dao.getByPersonId(retiredDeclare.getPeopleId());
			 
			 if(retiredCard!=null){
				 retiredCardDto.setId(retiredCard.getId());
				 retiredCard = BeanToBean.copyProperties(retiredCardDto,retiredCard ,false);
				 retiredCard.setIsRetiredCard(1L);
				 retiredCard.setPersonId(retiredDeclare.getPeopleId());
				 this.update(retiredCard);
			 }else{
				 retiredCard =  new RetiredCard();
				 retiredCard = BeanToBean.copyProperties(retiredCardDto, retiredCard,false);
				 retiredCard.setId(uniqueIdUtilService.genId(RetiredCard.class.getName()));
				 retiredCard.setIsRetiredCard(1l);
				 retiredCard.setPersonId(retiredDeclare.getPeopleId());
				 this.add(retiredCard);
			 }
		 }
	}

	@Override
	public RetiredCard getByRetiredId(Long retiredDeclareId) {
		return dao.getByRetiredId(retiredDeclareId);
	}

	@Override
	public void delByPersonId(Long personId) {
		dao.delByPersonId(personId);
	}

	@Override
	public RetiredCard getByPersonId(Long personId) {
		return dao.getByPersonId(personId);
	}


	

	@Override
	public List<RetiredCard> getByExitCode(QueryFilter fiter) {
		
		return this.dao.getBySqlKey("getAll", fiter);
	}

	
	
}
