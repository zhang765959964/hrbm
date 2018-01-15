package com.xunfeng.business.personagency.party.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.service.PersonBaseInfoService;
import com.xunfeng.business.person.service.PersonExpandService;
import com.xunfeng.business.personagency.party.dao.PartyDao;
import com.xunfeng.business.personagency.party.dto.PartyDto;
import com.xunfeng.business.personagency.party.interf.PartyServiceInterf;
import com.xunfeng.business.personagency.party.model.Party;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 党组织关系表 Service类
* @author:zhangfan
* @createDate 2016-08-17 11:32:11 
* @version V1.0   
*/
@Service
public class PartyService extends BaseService<Party> implements PartyServiceInterf
{
	@Resource
	private PartyDao dao;
	
	
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	
	
	@Resource
	private PersonBaseInfoService personService;	//个人service
	
	@Resource
	private PersonExpandService personExpandService;	//个人信息扩展表Service
	
	@Resource
	private PartyPayService partyPayService;	//党员缴费servicce
	
	
	public PartyService()
	{
	}
	
	@Override
	protected IEntityDao<Party, Long> getEntityDao() 
	{
		return dao;
	}
	
	
	@Override
	public void saveOrUpdate(PartyDto partyDto) {
		
		try {
		
			Map map = dao.getPartyByPersonId(partyDto.getPersonId());
			PersonBaseInfo personBaseInfo = personService.getById(partyDto.getPersonId()); 	//获得人员id
			if(personBaseInfo!=null){	//更新个人信息
				personBaseInfo.setAac180(partyDto.getPartyPersonDto().getPartySchoolName());	//毕业学校	
				personBaseInfo.setAac025(partyDto.getPartyPersonDto().getPlaceName());	//祖籍
				personBaseInfo.setAac011(partyDto.getPartyPersonDto().getWhcdId()); 	//文化程度
				personBaseInfo.setAac005(partyDto.getPartyPersonDto().getNationId());   //民族
				personBaseInfo.setAae005(partyDto.getPartyPersonDto().getMobilePhone()); 	//手机号
		    }
			PersonExpand personExpand =	personExpandService.getByExpPersonId(partyDto.getPersonId());
			if(personExpand!=null){	//更新个人扩展表信息
				 personExpand.setExpPersonPhone(partyDto.getPartyPersonDto().getPhone());	//联系电话
				 personExpand.setExpUserName(partyDto.getPartyPersonDto().getPersonOldName());	//曾用名
				 personExpand.setExpAddress(partyDto.getPartyPersonDto().getExpAddress()); 	//现居住地址
				 personExpandService.update(personExpand);
			}
			Party party =this.findByPersonId(partyDto.getPersonId());
			if(party!=null){
				Long id;
				id = party.getId();
				Long partyStatus  = party.getPartyStatus();
				party = BeanToBean.copyProperties(partyDto, party, false);
				party.setId(id);
				party.setPartyPersonId(partyDto.getPersonId());
				if(partyStatus==0){
					if(party.getPartyDate()!=null){
						party.setPartyStatus(1L);		
					}
				}else{
					if(party.getPartyOutDate()!=null){	//转出不等于null，状态为0
						party.setPartyStatus(0L);
					}
				}
				dao.update(party);
				personBaseInfo.setAac024("01");		//变成党员
		    	personService.update(personBaseInfo);   
			}else{
				party =  new Party();
				party = BeanToBean.copyProperties(partyDto, party, false);
				party.setId(uniqueIdUtilService.genId(Party.class.getName()));
				party.setPartyPersonId(partyDto.getPersonId());
				party.setIsParty(0L);
				party.setIsPay(0L);
				if(party.getPartyIntoDate()!=null){	//转入时间有值，状态为1
					party.setPartyStatus(1L);
				}
				if(party.getPartyOutDate()!=null){	//转出不等于null，状态为0
					party.setPartyStatus(0L);
				}
				dao.add(party);
				personBaseInfo.setAac024("01");		//变成党员
		    	personService.update(personBaseInfo);  
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	@Override
	public void partyInto(PartyDto partyDto) {
		try {
			
			Map map = dao.getPartyByPersonId(partyDto.getPersonId());
			PersonBaseInfo personBaseInfo = personService.getById(partyDto.getPersonId()); 	//获得人员id
			if(personBaseInfo!=null){	//更新个人信息
				personBaseInfo.setAac180(partyDto.getPartyPersonDto().getPartySchoolName());	//毕业学校	
				personBaseInfo.setAac025(partyDto.getPartyPersonDto().getPlaceName());	//祖籍
				personBaseInfo.setAac011(partyDto.getPartyPersonDto().getWhcdId()); 	//文化程度
				personBaseInfo.setAac005(partyDto.getPartyPersonDto().getNationId());   //民族
				personBaseInfo.setAae005(partyDto.getPartyPersonDto().getMobilePhone()); 	//手机号
		    }
			PersonExpand personExpand =	personExpandService.getByExpPersonId(partyDto.getPersonId());
			if(personExpand!=null){	//更新个人扩展表信息
				 personExpand.setExpPersonPhone(partyDto.getPartyPersonDto().getPhone());	//联系电话
				 personExpand.setExpUserName(partyDto.getPartyPersonDto().getPersonOldName());	//曾用名
				 personExpand.setExpAddress(partyDto.getPartyPersonDto().getExpAddress()); 	//现居住地址
				 personExpandService.update(personExpand);
			}
			Party party = dao.findByPartyInto(partyDto.getPersonId());
			party =  new Party();
			party = BeanToBean.copyProperties(partyDto, party, false);
			party.setId(uniqueIdUtilService.genId(Party.class.getName()));
			party.setPartyPersonId(partyDto.getPersonId());
			party.setIsParty(0L);
			party.setIsPay(0L);
			if(party.getPartyIntoDate()!=null){	//转入时间有值，状态为1
				party.setPartyStatus(1L);
			}
			dao.add(party);
			personBaseInfo.setAac024("01");		//变成党员
	    	personService.update(personBaseInfo);  
			
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	

	@Override
	public void partyOut(PartyDto partyDto) {
		try {
		
			Map map = dao.getPartyByPersonId(partyDto.getPersonId());
			PersonBaseInfo personBaseInfo = personService.getById(partyDto.getPersonId()); 	//获得人员id
			if(personBaseInfo!=null){	//更新个人信息
				personBaseInfo.setAac180(partyDto.getPartyPersonDto().getPartySchoolName());	//毕业学校	
				personBaseInfo.setAac025(partyDto.getPartyPersonDto().getPlaceName());	//祖籍
				personBaseInfo.setAac011(partyDto.getPartyPersonDto().getWhcdId()); 	//文化程度
				personBaseInfo.setAac005(partyDto.getPartyPersonDto().getNationId());   //民族
				personBaseInfo.setAae005(partyDto.getPartyPersonDto().getMobilePhone()); 	//手机号
		    }
			PersonExpand personExpand =	personExpandService.getByExpPersonId(partyDto.getPersonId());
			if(personExpand!=null){	//更新个人扩展表信息
				 personExpand.setExpPersonPhone(partyDto.getPartyPersonDto().getPhone());	//联系电话
				 personExpand.setExpUserName(partyDto.getPartyPersonDto().getPersonOldName());	//曾用名
				 personExpand.setExpAddress(partyDto.getPartyPersonDto().getExpAddress()); 	//现居住地址
				 personExpandService.update(personExpand);
			}
			Party party = dao.findByPartyInto(partyDto.getPersonId());
			if(party!=null){
				Long id;
				id = party.getId();
				Long partyStatus  = party.getPartyStatus();
				party = BeanToBean.copyProperties(partyDto, party, false);
				party.setId(id);
				party.setPartyPersonId(partyDto.getPersonId());
				if(partyStatus==0){
					if(party.getPartyDate()!=null){
						party.setPartyStatus(1L);		
					}
				}else{
					if(party.getPartyOutDate()!=null){	//转出不等于null，状态为0
						party.setPartyStatus(0L);
					}
				}
				dao.update(party);
				personBaseInfo.setAac024("01");		//变成党员
		    	personService.update(personBaseInfo);   
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	
	public ResultData<Party> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Party> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}

	@Override
	public ResultData getPartyByPersonId(Long personId) {
		QueryFilter fiter = new QueryFilter();
		ResultData resultData=new ResultData();
		List<Party> dataList=dao.getBySqlKey("getPartyByPersonId", personId);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public Map getPartyByPersonIds(Long personId) {
		
		return dao.getPartyByPersonId(personId);
	}

	@Override
	public ResultData getByPersonIdList(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List dataList=dao.getBySqlKey("getByPeronIdList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public ResultData getPartyList(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List dataList=dao.getBySqlKey("getPartyList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public Long getSumPerson() {
		return dao.getSumPerson();
	}

	@Override
	public Long getJfPerson() {
		return dao.getJfPerson();
	}

	@Override
	public void delByPersonId(Long personId) {
		
		if(personId!=null){
			dao.delByPersonId(personId);	
			partyPayService.delByPersonId(personId);
		}
	}

	@Override
	public void delPartyByIds(Long[] ids) {
		if(BeanUtils.isEmpty(ids)){
			return;
		}
		for (Long id : ids) {
			
			delById(id);
		}
		
	}

	@Override
	public void updatePay(Long personId) {
		dao.updatePay(personId);
	}

	@Override
	public ResultData getByvPersonId(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List dataList  = dao.getBySqlKey("getByvPersonId", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public Party findByPersonId(Long personId) {
		
		return dao.getUnique("findByPersonId", personId);
		
	}

	@Override
	public Long getPartyOweSum() {
		
		return dao.getPartyOweSum();
	}

	@Override
	public Long getPartyStatus() {
		
		return dao.getPartyStatus();
	}

	@Override
	public Party findByPartyInto(Long personId) {
		
		return dao.findByPartyInto(personId);
	}

	

	
	
	
	
}
