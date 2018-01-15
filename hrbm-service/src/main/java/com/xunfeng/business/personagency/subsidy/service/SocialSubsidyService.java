package com.xunfeng.business.personagency.subsidy.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.service.PersonBaseInfoService;
import com.xunfeng.business.person.service.PersonExpandService;
import com.xunfeng.business.personagency.subsidy.dao.SocialSubsidyDao;
import com.xunfeng.business.personagency.subsidy.dto.BatchSocialSubsidyDto;
import com.xunfeng.business.personagency.subsidy.dto.SocialSubsidyDto;
import com.xunfeng.business.personagency.subsidy.interf.SocialSubsidyServiceInterf;
import com.xunfeng.business.personagency.subsidy.model.SocialCorpDeclare;
import com.xunfeng.business.personagency.subsidy.model.SocialSubsidy;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.enumeration.SeqType;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 社保补贴 Service类
* @author:wanghan
* @createDate 2016-07-06 11:03:39 
* @version V1.0   
*/
@Service
public class SocialSubsidyService extends BaseService<SocialSubsidy> implements SocialSubsidyServiceInterf
{
	@Resource
	private SocialSubsidyDao dao;
	
	@Resource
	private PersonBaseInfoService baseInfoService;
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	@Resource
	SocialCorpDeclareService socialCorpDeclareService;
	@Resource
	PersonExpandService personExpandService;
	
	public SocialSubsidyService()
	{
	}
	
	@Override
	protected IEntityDao<SocialSubsidy, Long> getEntityDao() 
	{
		return dao;
	}
	public SocialSubsidy getByPersonId(Long personId){
		Map params=new HashMap();
		params.put("personId", personId);
		return dao.getUnique("getAll", params);
		
	}
	public SocialSubsidy getByArchiveCode(String archiveCode){
		Map params=new HashMap();
		params.put("archiveCode", archiveCode);
		return dao.getUnique("getByArchiveCode", params);
		
	}
	
	
	public List<SocialSubsidy> getSubsidyListByDate(Date startDate,Date endDate){
		
		Map params=new HashMap();
		params.put("begincreaterDate", startDate);
		params.put("endcreaterDate", endDate);
		return dao.getBySqlKey("getAll", params);
		
	}
	
	public void saveOrUpdate(SocialSubsidyDto socialSubsidyDto){
		
		
		PersonBaseInfo basePerson=baseInfoService.getById(socialSubsidyDto.getAac001());
		PersonExpand personExpand=personExpandService.getByExpPersonId(socialSubsidyDto.getAac001());
		basePerson.setAae005(socialSubsidyDto.getAae005());//设置手机号
		basePerson.setAcc0m1(socialSubsidyDto.getAcc0m1());
	    //保存个人扩展信息
		if(personExpand==null){
	    	personExpand=  new PersonExpand();
	    	personExpand.setExpRegisgration(socialSubsidyDto.getExpRegisgration());
	    	personExpand.setExpPersonPhone(socialSubsidyDto.getExpPersonPhone());	    	
	    	personExpand.setExpOldCompany(socialSubsidyDto.getExpOldCompany());	    	
	    	personExpand.setExpIsDifficult(socialSubsidyDto.getExpIsDifficult());
	    	personExpand.setExpHardPerson(socialSubsidyDto.getExpHardPerson());
	    	
	    	personExpand.setExpPersonId(socialSubsidyDto.getAac001());
	    	personExpand.setExpandId(uniqueIdUtilService.genId(PersonExpand.class.getName()));
	    	personExpandService.add(personExpand);
	    }else{
	    	personExpand.setExpRegisgration(socialSubsidyDto.getExpRegisgration());
	    	personExpand.setExpPersonPhone(socialSubsidyDto.getExpPersonPhone());
	    	personExpand.setExpOldCompany(socialSubsidyDto.getExpOldCompany());
	    	personExpand.setExpIsDifficult(socialSubsidyDto.getExpIsDifficult());
	    	personExpand.setExpHardPerson(socialSubsidyDto.getExpHardPerson());
	    	personExpandService.update(personExpand);
	    }
	    SocialSubsidy socialSubsidy=this.getById(socialSubsidyDto.getId()==null?0L:socialSubsidyDto.getId());
	    if(socialSubsidy==null){//新增.基本信息肯定是更新
			socialSubsidy=new SocialSubsidy();
		    socialSubsidy= BeanToBean.copyProperties(socialSubsidyDto, socialSubsidy, false);
		    socialSubsidy.setId(uniqueIdUtilService.genId(SocialSubsidy.class.getName()));
		    socialSubsidy.setPersonId(basePerson.getAac001());
		    socialSubsidy.setSubsidyNum(getBusniessSeqCode());
		    this.add(socialSubsidy);
			baseInfoService.update(basePerson);
		    
		}else{//更新，基本信息肯定是更新
			socialSubsidy= BeanToBean.copyProperties(socialSubsidyDto, socialSubsidy, false);
		    this.update(socialSubsidy);
			baseInfoService.update(basePerson);
		}
		
		
	}
	
	private String getBusniessSeqCode(){
		
		String year=DateUtil.getformatterCurrentDate("yyyy");
		
		return "Z"+year+uniqueIdUtilService.getBusniessSeqCode(SeqType.社保补贴, 5);
		
		
	}
	
	
	public List<SocialSubsidy>  getListByBatchId(Long Id){
		Map map=new HashMap();
		map.put("id", Id);
		return dao.getBySqlKey("getListByBatchId", map);
	}

	public ResultData<BatchSocialSubsidyDto>   getBatchSocialListByBatchId(Long batchId,PageBean pageBean ){

		return getBatchSocialListByBatchId(batchId, null, pageBean);
		
	}
	public ResultData<BatchSocialSubsidyDto>   getBatchSocialListByBatchId(Long batchId,String searchValue,PageBean pageBean ){
		
	      return  getBatchSocialListByBatchId(batchId, searchValue, null, pageBean);
					
		}
	public ResultData<BatchSocialSubsidyDto>   getBatchSocialListByBatchId(Long batchId,String searchValue,Long personId,PageBean pageBean ){

		QueryFilter queryFilter=new QueryFilter();

		if(searchValue!=null){
			queryFilter.addFilter("searchValue", "%"+searchValue+"%");
		}	
		if(personId!=null){
			queryFilter.addFilter("aac001", personId);
		}	
		queryFilter.setPageBean(pageBean);
		return  getBatchSocialListByBatchId(batchId, queryFilter) ;
		
	} 
	

	public ResultData<BatchSocialSubsidyDto>   getBatchSocialListByBatchId(Long batchId,QueryFilter queryFilter){
		
		ResultData resultData=new ResultData();
		queryFilter.addFilter("batchId", batchId);	
		List<BatchSocialSubsidyDto> dataList=dao.getListForm("getBatchSocialListByBatchId", queryFilter);
		resultData.setDataList(dataList);
		resultData.setPageBean(queryFilter.getPageBean());
		return  resultData ;
	      
					
	}
	public void review(Long[] ids,String checkState){
		
		Map map=new HashMap();
		
		for(Long id:ids){
			map.put("id", id);
			map.put("checkState", checkState);
			dao.update("updateForReview", map);
		}

	}
	
	public void updateNum(Long id,String subsidyNum,String createrNum){
		List<SocialSubsidy> lst=getListBySubsidyNum(id,subsidyNum);
		if(lst!=null&&lst.size()>0){
			throw new RuntimeException("编号不能重复"); 
		}
		Map map=new HashMap();
		map.put("id", id);
		map.put("subsidyNum", subsidyNum);
		map.put("createrNum", createrNum);
		dao.update("updateForReview", map);


	}
	public List<SocialSubsidy>  getListBySubsidyNum(Long id,String subsidyNum){
		Map map=new HashMap();
		map.put("exactsubsidyNum", subsidyNum);
		map.put("noid", id);
		map.put("exactsubsidyNum", subsidyNum);
		return dao.getBySqlKey("getAll", map);
	}
	public void batchUpdate(Long id,Long batchId,String pensionStandard,String medicalStandard){
		
		List<SocialSubsidy>  socialSubsidyList=getListByBatchId(batchId);
//	     Float medicalSubsidyAmount=0F,pensionSubsidyAmount=0F,totalSubsidyAmount=0F;
		for(SocialSubsidy socialSubsidy : socialSubsidyList){
			
			String pensionMonth=StringUtil.isEmpty(socialSubsidy.getPensionTotalMonths())?"0":socialSubsidy.getPensionTotalMonths();
			socialSubsidy.setPensionStandard(pensionStandard);
			 BigDecimal pensionAmount= new BigDecimal(pensionStandard).multiply(new BigDecimal(pensionMonth));
			socialSubsidy.setPensionAmount(pensionAmount.toString());
			
			String medicalMonth=StringUtils.isEmpty(socialSubsidy.getMedicalTotalMonths())?"0":socialSubsidy.getMedicalTotalMonths();
			socialSubsidy.setMedicalStandard(medicalStandard);
//			Float medicalAmount=Float.valueOf(medicalStandard)*Integer.valueOf(medicalMonth);
			BigDecimal medicalAmount= new BigDecimal(medicalStandard).multiply(new BigDecimal(medicalMonth));
			socialSubsidy.setMedicalAmount(medicalAmount.toString());

//            medicalSubsidyAmount=medicalSubsidyAmount+pensionAmount;
//            pensionSubsidyAmount=pensionSubsidyAmount+medicalAmount;			
		}
		dao.batchUpdate(socialSubsidyList);
//		SocialCorpDeclare socialCorpDeclare=socialCorpDeclareService.getById(id);
//		totalSubsidyAmount=pensionSubsidyAmount+medicalSubsidyAmount;
//		socialCorpDeclare.setPensionSubsidyAmount(pensionSubsidyAmount.toString());
//		socialCorpDeclare.setMedicalSubsidyAmount(medicalSubsidyAmount.toString());
//		socialCorpDeclare.setTotalSubsidyAmount(totalSubsidyAmount.toString());
//		socialCorpDeclareService.update(socialCorpDeclare);
	}
	
	public ResultData<SocialSubsidy> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<SocialSubsidy> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	public ResultData<SocialSubsidyDto> getAllSubsidyPersonByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<SocialSubsidyDto> dataList=dao.getListForm("getAllSubsidyPerson", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
}
