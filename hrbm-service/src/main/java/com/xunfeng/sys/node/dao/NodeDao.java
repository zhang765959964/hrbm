package com.xunfeng.sys.node.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.node.model.Node;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 节点表 Dao类
* @author:wanlupeng
* @createDate 2016-08-15 18:10:17 
* @version V1.0   
*/
@Repository
public class NodeDao extends BaseDao<Node>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Node.class;
	}

}