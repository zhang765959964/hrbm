package com.xunfeng.business.cms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.cms.dao.ArticleColumnDao;
import com.xunfeng.business.cms.interf.ArticleColumnInter;
import com.xunfeng.business.cms.model.ArticleColumn;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;

/**
 * <pre>
 * 对象功能:新闻类别表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-08 10:08:15
 * </pre>
 */
@Service
public class ArticleColumnService extends BaseService<ArticleColumn> implements ArticleColumnInter {
	@Resource
	private ArticleColumnDao dao;

	public ArticleColumnService() {
	}

	@Override
	protected IEntityDao<ArticleColumn, Long> getEntityDao() {
		return dao;
	}

	public List<ArticleColumn> getChildArticleColumn(Long colId) {
		Map param = new HashMap();
		param.put("canc02", colId);
		return dao.getBySqlKey("getAll", param);
	}

	public List<ArticleColumn> getLevelArticleColumn() {

		Map param = new HashMap();
		param.put("canc02", 0L);
		List<ArticleColumn> columnList = dao.getBySqlKey("getAll", param);
		for (ArticleColumn col : columnList) {
			List<ArticleColumn> childColList = getChildArticleColumn(col.getCanc01());
			col.setChildColList(childColList);
		}
		return columnList;
	}

	public void add(ArticleColumn entity) {
		String path = "0";
		ArticleColumn parentArticleColumn = this.getById(entity.getCanc02());
		if (parentArticleColumn != null) {
			path = parentArticleColumn.getCanc12();
		}
		entity.setCanc12(path + "." + entity.getCanc01());
		dao.add(entity);
	}

	/**
	 * 获得分类左边树形结构
	 */
	public List<ArticleColumn> getListLeftCms(String indent) {

		return dao.getBySqlKey("getListLeftCms", indent);

	}
	/**
	 * 通过标示获得分类信息数据
	 * 比如获得快速通道里面的的信息
	 */
	public List<ArticleColumn> getListByIndent(String indent){
		return dao.getBySqlKey("getListByIndent", indent);
	}
	
	
	/**
	 *  微信取得一二级目录新闻菜单
	 *  2016-10-08
	 */
	public List<Map<String,Object>> getAllCategoryList(Long canc02){
		//加载一级菜单
		Map<String,Object> map = new HashMap<String, Object>();
		//map.put("canc02", canc02);
		//父级菜单
		List<Map<String,Object>> articleList =  dao.getListBySqlKey("getCategoryList",map);
		//二级菜单
		List<Map<String,Object>> childrenArticleList = null;
		//循环获得二级菜单
		for(Map<String,Object> mapArticle : articleList){
			Map<String,Object> mapChileren = new HashMap<String, Object>();
			mapChileren.put("canc02", mapArticle.get("CANC01"));
			childrenArticleList = dao.getListBySqlKey("getCategoryList",mapChileren);
			mapArticle.put("children", childrenArticleList);
		}
		return articleList;
	}
}
