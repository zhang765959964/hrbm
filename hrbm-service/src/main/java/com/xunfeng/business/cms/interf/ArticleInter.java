package com.xunfeng.business.cms.interf;

import java.util.List;
import java.util.Map;

import com.xunfeng.business.cms.dto.ArticleDto;
import com.xunfeng.business.cms.model.Article;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;

public interface ArticleInter extends GenericServiceInterface<Article, Long> {

	public List<ArticleDto> getArticleList(QueryFilter queryFilter);

	public ResultData<ArticleDto> getResultDataArticleList(
			QueryFilter queryFilter);

	public List<ArticleDto> getHotArticleList(Long colId,int pageSize);
	/**
	 * 获得热门文章不带有附件的文章
	 */
	public List<ArticleDto> getHotArticleListByExcept(int pageSize);
	public List<ArticleDto> getNewArticleList(int pageSize);
	/**
	 * 最新文章   不带有关于关于网站的内容 
	 * @param pageSize
	 * @return
	 */
	public List<ArticleDto> getNewArticleList(int pageSize,Long flag);
	public void updateReadNum(Long articleId);
	public List<ArticleDto> getAllArticleList(String canc01,
			QueryFilter queryFilter);

	public void stickTop(Long cand01);

	/**
	 * 获取分类下已置顶的文章列表
	 * 
	 * @param canc01
	 * @return
	 */
	public List<Article> getStickTopChildArticle(Long canc01);

	public List<ArticleDto> getAllChildenArticle(Long canc01,
			QueryFilter queryFilter);

	public List<ArticleDto> getAllArticleListByAlias(String canc11,
			QueryFilter queryFilter);

	public void cancelStickTop(Long cand01);
	
	public List<Article>  getByIdArray(String ids);
	
	/**
	 * 微信取得新闻最新新闻列表
	 */
	public ResultData<Map<String,Object>> getNewArticleListWX(Long canc02,PageBean pageBean);
	/**
	 * 微信取得新闻最新新闻列表
	 */
	public Article getArticleDetail(Long cand01);

}
