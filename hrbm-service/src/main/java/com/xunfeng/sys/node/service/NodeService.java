package com.xunfeng.sys.node.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.node.model.Node;
import com.xunfeng.sys.node.dao.NodeDao;
import com.xunfeng.sys.node.interf.NodeServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 节点表 Service类
* @author:wanlupeng
* @createDate 2016-08-15 18:10:17 
* @version V1.0   
*/
@Service
public class NodeService extends BaseService<Node> implements NodeServiceInterf
{
	@Resource
	private NodeDao dao;
	
	
	
	public NodeService()
	{
	}
	
	@Override
	protected IEntityDao<Node, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<Node> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Node> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	public Node getByTemplates(Long comm01){
		return (Node) dao.getOne("getByTemplates", comm01);
	}
	
}
