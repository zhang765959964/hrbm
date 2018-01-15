package com.xunfeng.business.advert.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.advert.dao.AdDelRecordDao;
import com.xunfeng.business.advert.interf.AdCompanyServiceInterf;
import com.xunfeng.business.advert.interf.AdDelRecordServiceInterf;
import com.xunfeng.business.advert.interf.AdWebServiceInterf;
import com.xunfeng.business.advert.model.AdCompany;
import com.xunfeng.business.advert.model.AdDelRecord;
import com.xunfeng.business.advert.model.AdWeb;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告删除记录表 Service类
* @author:
* @createDate 2016-08-03 10:35:28 
* @version V1.0   
*/
@Service
public class AdDelRecordService extends BaseService<AdDelRecord> implements AdDelRecordServiceInterf
{
	@Resource
	private AdDelRecordDao dao;
	@Resource
	@Qualifier("adCompany")
	private AdCompanyServiceInterf adCompanyService;
	@Resource
	@Qualifier("adWeb")
	private AdWebServiceInterf adWebService;
	@Resource
	UniqueIdUtilService  uniqueIdUtil;
	
	public AdDelRecordService()
	{
	}
	
	@Override
	protected IEntityDao<AdDelRecord, Long> getEntityDao() 
	{
		return dao;
	}
	   /**
	    * 增加企业或者职位删除广告记录表
	    * @param id 广告id 或者职位id
	    * @param currentUserName 当前操作人
	    * 2016-08-03
	    */
	   public void addRecordCompanyAdById(Long id,String currentUserName){
		   AdCompany adCompany = adCompanyService.getById(id);
		   AdDelRecord adDelRecord = new AdDelRecord();
		   // 记录id
		   adDelRecord.setId(uniqueIdUtil.genId(AdDelRecord.class.getName()));
			// 广告类编号
		   adDelRecord.setCaac01(adCompany.getCaac01());
			// 广告主键
		   adDelRecord.setAdid(adCompany.getCaae01());
		   if(adCompany.getAab001()!=null){
			   adDelRecord.setAab001(adCompany.getAab001()) ;
		   }
		   if(StringUtil.isNotEmpty(adCompany.getCaae03())){
			   adDelRecord.setCaae03(adCompany.getCaae03());
		   }
		   if(StringUtil.isNotEmpty(adCompany.getCaae04())){
			   adDelRecord.setCaae04(adCompany.getCaae04());
		   }
		   if(adCompany.getJobid()!=null){
			   adDelRecord.setJobid(adCompany.getJobid());
		   }
		   if(adCompany.getCaad14()!=null){
			   adDelRecord.setCaad14(adCompany.getCaad14()) ;
		   }
		   if(adCompany.getAae036()!=null){
			   adDelRecord.setAae036(adCompany.getAae036());
		   }
		   if(StringUtil.isNotEmpty(adCompany.getAae019())){
			   adDelRecord.setAae019(adCompany.getAae019());
		   }
		   adDelRecord.setDeltime(new Date());
		   adDelRecord.setDeluser(currentUserName);
		   this.add(adDelRecord);
	   }
	   /**
	    * 增加网站删除广告记录表
	    * @param id 网站广告id
	    * @param currentUserName 当前操作人
	    * 2016-08-03
	    */
	   public void addRecordWebAdById(Long id,String currentUserName){
		   AdWeb adWeb = adWebService.getById(id);
		   AdDelRecord adDelRecord = new AdDelRecord();
		   // 记录id
		   adDelRecord.setId(uniqueIdUtil.genId(AdDelRecord.class.getName()));
		   // 广告类编号
		   adDelRecord.setCaac01(adWeb.getCaac01());
		   // 广告主键
		   adDelRecord.setAdid(adWeb.getCaad01());
		   //上传图片或Flash地址
		   if(StringUtil.isNotEmpty(adWeb.getCaad03())){
			   adDelRecord.setCaae03(adWeb.getCaad03());
		   }
		   //指向地址
		   if(StringUtil.isNotEmpty(adWeb.getCaad12())){
			   adDelRecord.setCaae04(adWeb.getCaad12());
		   }
		  
		   if(adWeb.getCaad14()!=null){
			   adDelRecord.setCaad14(adWeb.getCaad14()) ;
		   }
		   adDelRecord.setDeltime(new Date());
		   adDelRecord.setDeluser(currentUserName);
		   this.add(adDelRecord);
	   }
}
