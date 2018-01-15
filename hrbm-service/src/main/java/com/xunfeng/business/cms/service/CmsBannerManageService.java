package com.xunfeng.business.cms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.cms.dao.CmsBannerManageDao;
import com.xunfeng.business.cms.interf.CmsBannerManageServiceInterf;
import com.xunfeng.business.cms.model.CmsBannerManage;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 栏目板块管理 比如快速栏目中的前十个信息名称 Service类
* @author:wanghan
* @createDate 2016-03-22 16:46:24 
* @version V1.0   
*/
@Service
public class CmsBannerManageService extends BaseService<CmsBannerManage> implements CmsBannerManageServiceInterf
{
	@Resource
	private CmsBannerManageDao dao;
	
	public CmsBannerManageService()	{}
	
	@Override
	protected IEntityDao<CmsBannerManage, Long> getEntityDao() 
	{
		return dao;
	}
	
	/**
	 * 获得标示下面的新闻标题
	 */
	@Override
	public List<CmsBannerManage> getList(String indent) {
		return  dao.getBySqlKey("getByIndent", indent);
	}
	
	/**
	 * 根据ID删除
	 */
	public void delById(Long id) {
		dao.delById(id);
	}
	
	/**
	 * 保存
	 */
	@Override
	public void add(CmsBannerManage entity) {
		dao.add(entity);
	}
	
	/**
	 * 栏目版块中列表的排序
	 */
    public void sortOrderNum(Long id,Long orderNum){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("id", id);
    	map.put("ordernum", orderNum);
    	dao.update("updateOrderNum", map);
    }

	
}
