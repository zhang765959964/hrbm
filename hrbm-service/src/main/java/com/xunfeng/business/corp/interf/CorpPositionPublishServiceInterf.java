package com.xunfeng.business.corp.interf;


import java.util.Map;

import com.xunfeng.business.corp.model.CorpPositionPublish;
import com.xunfeng.core.service.GenericServiceInterface;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 摊位初始化表 接口类
* @author:wanghan
* @createDate 2016-04-09 14:00:36 
* @version V1.0   
*/
public interface CorpPositionPublishServiceInterf extends GenericServiceInterface<CorpPositionPublish,Long>
{
	
	/**
	 * 冻结招聘信息 acb20e acb20d
	 * @param corpPositionIds 招聘信息ID
	 * @param map
	 */
	public void freezeCorpPublicPosition(Long[] corpPositionIds,Map<String,Object> map);
	
	/**
	 * 解冻招聘信息
	 * @param corpPositionIds 招聘信息ID
	 * @param map
	 */
	public void unfreezeCorpPublicPosition(Long[] corpPositionIds,Map<String,Object> map);
	
}
