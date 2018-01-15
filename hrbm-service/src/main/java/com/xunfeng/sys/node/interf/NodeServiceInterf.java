package com.xunfeng.sys.node.interf;


import com.xunfeng.sys.node.model.Node;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 节点表 接口类
* @author:wanlupeng
* @createDate 2016-08-15 18:10:17 
* @version V1.0   
*/
public interface NodeServiceInterf extends GenericServiceInterface<Node,Long>
{
   public ResultData<Node> getAllByFilter(QueryFilter fiter);
   public Node getByTemplates(Long comm01);
}
