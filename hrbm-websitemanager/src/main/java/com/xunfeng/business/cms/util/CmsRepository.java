package com.xunfeng.business.cms.util;

import java.util.List;

import com.xunfeng.business.cms.dto.ArticleDto;
import com.xunfeng.business.cms.interf.ArticleColumnInter;
import com.xunfeng.business.cms.interf.ArticleInter;
import com.xunfeng.business.cms.model.Article;
import com.xunfeng.business.cms.model.ArticleColumn;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.EhcacheUtil;
import com.xunfeng.core.web.query.QueryFilter;

public class CmsRepository { 
	
	public static List<ArticleDto> getAllArticleListByAlias(String alias,int page,int pageSize){
		List<ArticleDto> articlelst=(List<ArticleDto>)EhcacheUtil.getInstance().get("cms", alias+"#"+page+"#"+pageSize);
		if(articlelst!=null){
			return articlelst;
		}
		QueryFilter queryFilter=new QueryFilter();
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(page);
		pageBean.setPagesize(pageSize);
		queryFilter.setPageBean(pageBean);
		ArticleInter articleInter=(ArticleInter) AppUtil.getBean("article");
		articlelst=articleInter.getAllArticleListByAlias(alias,queryFilter);
		EhcacheUtil.getInstance().put("cms",  alias+"#"+page+"#"+pageSize, articlelst);
		return articlelst;
		
	}
	public static ResultData<ArticleDto> getResultDataArticleList(QueryFilter queryFilter){
		ArticleInter articleInter=(ArticleInter) AppUtil.getBean("article");
		ResultData<ArticleDto> resultData=articleInter.getResultDataArticleList(queryFilter);

		return resultData;
		
	}
	public static Article getById(Long id){
//		Article article=(Article)EhcacheUtil.getInstance().get("cms",id);
//		if(article!=null){
//			return article;
//		}
		ArticleInter articleInter=(ArticleInter) AppUtil.getBean("article");

		Article article=articleInter.getById(id);
//		EhcacheUtil.getInstance().put("cms", id,article);
		return article;
		
	}
	public static List<Article> getByIdArray(String ids){
//		Article article=(Article)EhcacheUtil.getInstance().get("cms",id);
//		if(article!=null){
//			return article;
//		}
		ArticleInter articleInter=(ArticleInter) AppUtil.getBean("article");

		List<Article> articleList=articleInter.getByIdArray(ids);
//		EhcacheUtil.getInstance().put("cms", id,article);
		return articleList;
		
	}
	public static List<ArticleDto> getNewArticle(int pageSize){	
		ArticleInter articleInter=(ArticleInter) AppUtil.getBean("article");
		List<ArticleDto> articlelst=articleInter.getHotArticleList(null,pageSize);
		return articlelst;		
	}
	
	public static List<ArticleDto> getHotArticle(int pageSize){
		
		ArticleInter articleInter=(ArticleInter) AppUtil.getBean("article");
		List<ArticleDto> articlelst=articleInter.getNewArticleList(pageSize);
		return articlelst;
		
	}
	
	public static void updateReadNum(Long articleId){
		
		ArticleInter articleInter=(ArticleInter) AppUtil.getBean("article");
		articleInter.updateReadNum(articleId);
		
	}
	
    public static ArticleColumn getArticleColumn(Long colId){
		
    	ArticleColumnInter articleColumnInter=(ArticleColumnInter) AppUtil.getBean("articlecol");
		
    	return articleColumnInter.getById(colId);
    	
    	
	}
	
}
