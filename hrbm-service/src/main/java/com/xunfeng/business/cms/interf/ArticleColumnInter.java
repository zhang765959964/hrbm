package com.xunfeng.business.cms.interf;

import java.util.List;
import java.util.Map;

import com.xunfeng.business.cms.model.ArticleColumn;
import com.xunfeng.core.service.GenericServiceInterface;

public interface ArticleColumnInter extends GenericServiceInterface<ArticleColumn,Long>{

	public List<ArticleColumn>   getChildArticleColumn(Long colId);

	public List<ArticleColumn>   getLevelArticleColumn();
	
	public List<ArticleColumn>   getListLeftCms(String indent);
	
	/**
	 * 通过标示获得分类信息数据
	 * 比如获得快速通道里面的的信息
	 */
	public List<ArticleColumn> getListByIndent(String indent);
	/**
	 *  微信取得一二级目录新闻菜单
	 *   返回格式 {canc01:''}
	 */
	public List<Map<String,Object>> getAllCategoryList(Long canc02);
}
