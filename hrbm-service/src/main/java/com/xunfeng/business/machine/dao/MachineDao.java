package com.xunfeng.business.machine.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.machine.model.Machine;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 查询机管理表 Dao类
* @author:wanghan
* @createDate 2015-11-23 10:15:36 
* @version V1.0   
*/
@Repository
public class MachineDao extends BaseDao<Machine>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Machine.class;
	}

}