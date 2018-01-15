package com.xunfeng.business.personagency.print.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.print.model.PrintTemplate;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PRINT_MODEL Dao类
* @author:wanghan
* @createDate 2016-10-20 15:19:40 
* @version V1.0   
*/
@Repository
public class PrintTemplateDao extends BaseDao<PrintTemplate>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PrintTemplate.class;
	}

}