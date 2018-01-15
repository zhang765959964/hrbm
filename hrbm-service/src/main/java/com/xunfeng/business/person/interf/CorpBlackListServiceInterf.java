package com.xunfeng.business.person.interf;

import java.util.List;

import com.xunfeng.business.person.model.CorpBlackList;
import com.xunfeng.core.service.GenericServiceInterface;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 屏蔽单位 Service类
* @author:wanghan
* @createDate 2015-07-23 14:48:15 
* @version V1.0   
*/
public interface CorpBlackListServiceInterf  extends GenericServiceInterface<CorpBlackList,Long>
{
	public List<CorpBlackList> getPersonBackList(Long aac001);
	
}
