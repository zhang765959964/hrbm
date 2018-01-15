package com.xunfeng.business.cms.interf;


import java.util.List;

import com.xunfeng.business.cms.model.CmsBannerManage;
import com.xunfeng.core.service.GenericServiceInterface;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 栏目板块管理 比如快速栏目中的前十个信息名称 接口类
* @author:wanghan
* @createDate 2016-03-22 16:46:24 
* @version V1.0   
*/
public interface CmsBannerManageServiceInterf extends GenericServiceInterface<CmsBannerManage,Long>
{   
	
	public List<CmsBannerManage> getList(String indent);
	
	public void delById(Long id);
	public void add(CmsBannerManage entity);
	/**
	 * 栏目版块列表排序
	 */
	public void sortOrderNum(Long id,Long orderNum);
		
}
