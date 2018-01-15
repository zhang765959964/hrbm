package com.xunfeng.business.personagency.subsidy.interf;


import java.util.Map;

import com.xunfeng.business.personagency.subsidy.dto.SocialCorpDeclareDto;
import com.xunfeng.business.personagency.subsidy.model.SocialCorpDeclare;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位补贴申报 接口类
* @author:wanghan
* @createDate 2016-07-14 15:38:33 
* @version V1.0   
*/
public interface SocialCorpDeclareServiceInterf extends GenericServiceInterface<SocialCorpDeclare,Long>
{
	 /**保存单位申报批次
	 * @param socialCorpDeclareDto
	 */
	public void saveOrUpdate(SocialCorpDeclareDto socialCorpDeclareDto);
	
	public SocialCorpDeclare getByBatchId(Long batchId);
	
	public ResultData<Map>  getAllSocialCorpDeclareList(QueryFilter queryFilter);
	
	public SocialCorpDeclare  getLastSocialCorpDeclare(Long corpid); 
}
