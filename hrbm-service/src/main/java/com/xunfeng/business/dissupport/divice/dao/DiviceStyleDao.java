package com.xunfeng.business.dissupport.divice.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.dissupport.divice.model.DiviceStyle;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 样式表 Dao类
* @author:wanghan
* @createDate 2016-07-27 17:06:34 
* @version V1.0   
*/
@Repository
public class DiviceStyleDao extends BaseDao<DiviceStyle>
{
	@Override
	public Class<?> getEntityClass()
	{
		return DiviceStyle.class;
	}

}