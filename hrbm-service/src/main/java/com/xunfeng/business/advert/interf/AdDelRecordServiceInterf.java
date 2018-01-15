package com.xunfeng.business.advert.interf;


import com.xunfeng.business.advert.model.AdDelRecord;
import com.xunfeng.core.service.GenericServiceInterface;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告删除记录表 接口类
* @author:
* @createDate 2016-08-03 10:36:56 
* @version V1.0   
*/
public interface AdDelRecordServiceInterf extends GenericServiceInterface<AdDelRecord,Long>
{
	/**
	    * 增加企业或者职位删除广告记录表
	    * @param id 广告id 或者职位id
	    * @param currentUserName 当前操作人
	    * 2016-08-03
	    */
	   public void addRecordCompanyAdById(Long id,String currentUserName);
	   /**
	    * 增加网站删除广告记录表
	    * @param id 网站广告id
	    * @param currentUserName 当前操作人
	    * 2016-08-03
	    */
	   public void addRecordWebAdById(Long id,String currentUserName);
}
