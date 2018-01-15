package com.xunfeng.business.personagency.party.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.party.dao.PartyPayDao;
import com.xunfeng.business.personagency.party.interf.PartyPayServiceInterf;
import com.xunfeng.business.personagency.party.model.Party;
import com.xunfeng.business.personagency.party.model.PartyPay;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 党费缴纳 Service类
* @author:zhangfan
* @createDate 2016-08-16 17:44:26 
* @version V1.0   
*/
@Service
public class PartyPayService extends BaseService<PartyPay> implements PartyPayServiceInterf
{
	@Resource
	private PartyPayDao dao;
	
	

	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	
	
	@Resource
	private PartyService partyService;	//党员缴费service
	
	
	public PartyPayService()
	{
	}
	
	@Override
	protected IEntityDao<PartyPay, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<PartyPay> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<PartyPay> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}

	@Override
	public ResultData getByPartyId(Long partyId) {
		QueryFilter fiter = new QueryFilter();
		ResultData resultData=new ResultData();
		List dataList = dao.getBySqlKey("getByPartyId", partyId);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public ResultData getPartyPayList(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List<PartyPay> dataList=dao.getBySqlKey("getPartyPayList",fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public Object getPartyPayById(Long payId) {
		List list = dao.getBySqlKey("getPartyPayById", payId);
		return list.get(0);
	}

	@Override
	public List getPartyPayResult(QueryFilter fiter) {
		return dao.getBySqlKey("getPartyPayResult",fiter);
	
	}
	
	
	@Override
	public List getPartyPayCount(QueryFilter fiter) {
	     return dao.getBySqlKey("getPartyPayCount", fiter);
	
	
	}

	@Override
	public ResultData getPartyPayResultList(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List dataList=dao.getBySqlKey("getPartyPayResultList",fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public void saveOrUpdate(PartyPay partyPay) {
		PartyPay partyVo =  dao.getById(partyPay.getId());
	    Party party = partyService.getById(partyPay.getPartyId());
		if(partyVo!=null){
			partyVo = BeanToBean.copyProperties(partyPay, partyVo, false);
			
			if(partyVo.getPartyEndDate()!=null){
				party.setLastPartyDate(partyVo.getPartyEndDate());
				
			}if(partyVo.getPartyBeginDate()!=null){
				party.setFirstPartyDate(partyVo.getPartyBeginDate());
				
			}if(partyVo.getPartyPayMoney()!=null){
				party.setPartyMoney(partyVo.getPartyPayMoney());
			}
				
			
			
			
			
			partyService.update(party);
			
			dao.update(partyVo);
		}else{
			partyVo = new PartyPay();
			BeanToBean.copyProperties(partyPay, partyVo, false);
			partyVo.setId(uniqueIdUtilService.genId(PartyPay.class.getName()));
			dao.add(partyVo);
			if(partyVo.getPartyEndDate()!=null){
				party.setLastPartyDate(partyVo.getPartyEndDate());
				
			}if(partyVo.getPartyBeginDate()!=null){
				party.setFirstPartyDate(partyVo.getPartyBeginDate());
				
			}if(partyVo.getPartyPayMoney()!=null){
				party.setPartyMoney(partyVo.getPartyPayMoney());
			}
			partyService.update(party);
		}
		
	}

	@Override
	public void delByPersonId(Long personId) {
		partyService.updatePay(personId);
		dao.delByPersonId(personId);
	}

	@Override
	public ResultData getByvPersonId(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List dataList=dao.getBySqlKey("getByvPersonId",fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public Long getPartyById(Long partyId) {
		
		return dao.getPartyById(partyId);
	}

	
	
}
