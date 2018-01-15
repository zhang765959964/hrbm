package com.xunfeng.sys.component.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.component.dao.ReleaseRangeDao;
import com.xunfeng.sys.component.interf.ReleaseRangeServiceInterf;
import com.xunfeng.sys.component.model.ReleaseRange;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 职位与信息方式对应关系表 Service类
* @author:wanghan
* @createDate 2016-06-12 10:30:25 
* @version V1.0   
*/
@Service
public class ReleaseRangeService extends BaseService<ReleaseRange> implements ReleaseRangeServiceInterf
{
	@Resource
	private ReleaseRangeDao dao;
	@Resource
	private UniqueIdUtilInterf uniqueIdUtil;
	
	public ReleaseRangeService()
	{
	}
	
	@Override
	protected IEntityDao<ReleaseRange, Long> getEntityDao() 
	{
		return dao;
	}
	
	/**
	 * 保存发布范围记录
	 * no:岗位id或者求职意向id
	 * scope 发布范围
	 * lx 类型 1-岗位编号2-个人求职编号
	 */
	public void add(Long no,String[] scope,int lx){
		//删除以前数据
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ACB210", no);
		map.put("LX", lx);
		dao.delBySqlKey("delByAcb210", map);
		//增加信息发布范围记录
		for(String str : scope){
			ReleaseRange releaseRange = new ReleaseRange();
			releaseRange.setId(uniqueIdUtil.genId(ReleaseRange.class.getName()));
			releaseRange.setAcb210(no);
			releaseRange.setAcb20q(str);
			releaseRange.setLx((long)lx);
			dao.add(releaseRange);
		}
	}
}
