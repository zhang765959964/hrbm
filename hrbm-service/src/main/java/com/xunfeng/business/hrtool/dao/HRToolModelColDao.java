package com.xunfeng.business.hrtool.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.hrtool.model.HRToolModelCol;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 工具箱模板栏目表 Dao类
* @author:wanghan
* @createDate 2016-03-08 14:20:33 
* @version V1.0   
*/
@Repository
public class HRToolModelColDao extends BaseDao<HRToolModelCol>
{
	@Override
	public Class<?> getEntityClass()
	{
		return HRToolModelCol.class;
	}

}