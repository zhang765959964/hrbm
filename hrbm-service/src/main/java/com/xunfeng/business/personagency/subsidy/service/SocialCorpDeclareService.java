package com.xunfeng.business.personagency.subsidy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.corp.service.CorpService;
import com.xunfeng.business.personagency.subsidy.dao.SocialCorpDeclareDao;
import com.xunfeng.business.personagency.subsidy.dto.SocialCorpDeclareDto;
import com.xunfeng.business.personagency.subsidy.interf.SocialCorpDeclareServiceInterf;
import com.xunfeng.business.personagency.subsidy.model.SocialCorpDeclare;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位补贴申报 Service类
* @author:wanghan
* @createDate 2016-07-14 15:38:33 
* @version V1.0   
*/
@Service
public class SocialCorpDeclareService extends BaseService<SocialCorpDeclare> implements SocialCorpDeclareServiceInterf
{
	@Resource
	private SocialCorpDeclareDao dao;
	@Resource
	CorpService corpService;
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	public SocialCorpDeclareService()
	{
	}
	
	@Override
	protected IEntityDao<SocialCorpDeclare, Long> getEntityDao() 
	{
		return dao;
	}
	
   public void saveOrUpdate(SocialCorpDeclareDto socialCorpDeclareDto){
		
		
		Corp corp=corpService.getById(socialCorpDeclareDto.getAab001());
		corp= BeanToBean.copyProperties(socialCorpDeclareDto, corp, false);	
//		SocialCorpDeclare socialCorpDeclare=this.getById(socialCorpDeclareDto.getId()==null?0L:socialCorpDeclareDto.getId());
		SocialCorpDeclare socialCorpDeclare=this.getByBatchId(socialCorpDeclareDto.getBatchId());
	    if(socialCorpDeclare==null){//新增.基本信息肯定是更新
	    	socialCorpDeclare=new SocialCorpDeclare();
	    	socialCorpDeclare= BeanToBean.copyProperties(socialCorpDeclareDto, socialCorpDeclare, false);
	    	socialCorpDeclare.setId(uniqueIdUtilService.genId(SocialCorpDeclare.class.getName()));
	    	socialCorpDeclare.setCorpid(corp.getAab001());
		    this.add(socialCorpDeclare);
		    corpService.update(corp);
		    
		}else{//更新，基本信息肯定是更新
			Long oldId=socialCorpDeclare.getId();
			socialCorpDeclare= BeanToBean.copyProperties(socialCorpDeclareDto, socialCorpDeclare, false);
			socialCorpDeclare.setId(oldId);
		    this.update(socialCorpDeclare);
		    corpService.update(corp);
		}
		
		
	}
   
   public ResultData<Map>  getAllSocialCorpDeclareList(QueryFilter queryFilter){
	    ResultData resultData=new ResultData();
		List<Map> dataList=dao.getListForm("getAllSocialCorpDeclareList", queryFilter);
		resultData.setDataList(dataList);
		resultData.setPageBean(queryFilter.getPageBean());
		return resultData;
   } 
   public SocialCorpDeclare getByBatchId(Long batchId){
	   
	   Map params =new HashMap();
	   params.put("batchId", batchId);
	   return dao.getUnique("getAll", params);
	   
   }
   
   public SocialCorpDeclare  getLastSocialCorpDeclare(Long corpid){
	   
	   Map params =new HashMap();
	   params.put("corpid", corpid);
	   params.put("orderField", "CREATER_DATE");
	   params.put("orderSeq", "desc");
	   PageBean pageBean=new PageBean();
	   pageBean.setCurrentPage(1);
	   pageBean.setPagesize(1);
	   List<SocialCorpDeclare> list=dao.getBySqlKey("getAll", params, pageBean);
	   
	   if(list!=null&&list.size()>0){
		   return list.get(0);
	   }else{
		   return null;
	   }
	   
   }
}
