package com.xunfeng.sys.setMeal.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.weaver.ast.HasAnnotation;
import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.setMeal.model.FeeServCfg;
import com.xunfeng.sys.setMeal.dao.FeeServCfgDao;
import com.xunfeng.sys.setMeal.interf.FeeServCfgServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 服务细项表 Service类
* @author:wangyanyan
* @createDate 2016-07-19 09:11:01 
* @version V1.0   
*/
@Service
public class FeeServCfgService extends BaseService<FeeServCfg> implements FeeServCfgServiceInterf
{
	@Resource
	private FeeServCfgDao dao;
	
	
	
	public FeeServCfgService()
	{
	}
	
	@Override
	protected IEntityDao<FeeServCfg, Long> getEntityDao() 
	{
		return dao;
	}
  public FeeServCfg getByservCode(String code){
	  Map<String,Object> map = new HashMap<String,Object>();
	  map.put("servCode", code);
	  return dao.getUnique("getByServCode", map);
	  
  }
	
}
