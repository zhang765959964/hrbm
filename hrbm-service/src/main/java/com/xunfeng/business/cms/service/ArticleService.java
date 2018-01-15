package com.xunfeng.business.cms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.cms.dao.ArticleDao;
import com.xunfeng.business.cms.dto.ArticleDto;
import com.xunfeng.business.cms.interf.ArticleInter;
import com.xunfeng.business.cms.model.Article;
import com.xunfeng.business.cms.model.ArticleColumn;
import com.xunfeng.business.cms.util.CmsConst;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;

/**
 * <pre>
 * 对象功能:新闻内容表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-08 10:08:39
 * </pre>
 */
@Service
public class ArticleService extends BaseService<Article> implements ArticleInter {
	@Resource
	private ArticleDao dao;

	@Resource
	private ArticleColumnService articleColumnService;

	@Resource
	UniqueIdUtilService UniqueIdUtil;

	public ArticleService() {
	}

	@Override
	public void add(Article entity) {

		ArticleColumn articleColumn = articleColumnService.getById(entity.getCanc01());
		entity.setCand20(articleColumn.getCanc12());
		dao.add(entity);

	}

	@Override
	protected IEntityDao<Article, Long> getEntityDao() {
		return dao;
	}

	public List<ArticleDto> getArticleList(QueryFilter queryFilter) {
		queryFilter.addFilter("cand09", "1");
		return dao.getListForm("getArticleList", queryFilter);

	}

	public List<ArticleDto> getHotArticleList(Long colId,int pageSize) {
		QueryFilter queryFilter = new QueryFilter();
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPagesize(pageSize);
		queryFilter.addFilter("orderField", "cand13");
		queryFilter.addFilter("orderSeq", "desc");
		queryFilter.addFilter("cand09", "1");
		if(colId!=null){
			queryFilter.addFilter("canc01", colId);
		}
		queryFilter.setPageBean(pageBean);
		return dao.getListForm("getArticleList", queryFilter);

	}
	/**
	 * 获得热门文章不带有附件的文章
	 */
	public List<ArticleDto> getHotArticleListByExcept(int pageSize) {
		QueryFilter queryFilter = new QueryFilter();
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPagesize(pageSize);
		queryFilter.addFilter("orderField", "cand13");
		queryFilter.addFilter("orderSeq", "desc");
		queryFilter.addFilter("cand09", "1");
		queryFilter.addFilter("flag", "1");
		queryFilter.addFilter("colidId", CmsConst.XZZQ+","+CmsConst.GYWZ);//下载专区和关于网站的文章筛选掉
		//queryFilter.addFilter("indent", "'MSJQ','ZCGC','ZCFG','XZXQ','QZDY','QZPX','XYDT','QZZX','JLZN','BZWD','ZXGG','GRZCCJWTJD','QYZPCJWTJD'");
		queryFilter.setPageBean(pageBean);
		return dao.getListForm("getArticleList", queryFilter);
		
	}

	public void updateReadNum(Long articleId) {
		Map params = new HashMap();
		params.put("cand01", articleId);
		dao.update("updateReadNum", params);
	}

	public List<ArticleDto> getNewArticleList(int pageSize) {
		QueryFilter queryFilter = new QueryFilter();
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPagesize(pageSize);
		queryFilter.addFilter("orderField", "cand07");
		queryFilter.addFilter("orderSeq", "desc");
		queryFilter.addFilter("cand09", "1");
		queryFilter.setPageBean(pageBean);
		return dao.getListForm("getArticleList", queryFilter);

	}
	/**
	 * 最新文章   不带有关于关于网站的内容 
	 * @param pageSize
	 * @return
	 */
	public List<ArticleDto> getNewArticleList(int pageSize,Long flag) {
		QueryFilter queryFilter = new QueryFilter();
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPagesize(pageSize);
		queryFilter.addFilter("orderField", "cand07");
		queryFilter.addFilter("orderSeq", "desc");
		queryFilter.addFilter("cand09", "1");
		queryFilter.addFilter("flag", flag);
		queryFilter.addFilter("colidId", CmsConst.XZZQ+","+CmsConst.GYWZ);//下载专区和关于网站的文章筛选掉
		//queryFilter.addFilter("", params);//新闻中关于我们的文章
		queryFilter.setPageBean(pageBean);
		return dao.getListForm("getArticleList", queryFilter);
		
	}
	

	public ResultData<ArticleDto> getResultDataArticleList(QueryFilter queryFilter) {
		queryFilter.addFilter("cand09", "1");
		List dataList = dao.getListForm("getArticleList", queryFilter);
		ResultData<ArticleDto> resultData = new ResultData<ArticleDto>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;

	}

	public List<ArticleDto> getAllArticleList(String canc01, QueryFilter queryFilter) {

		queryFilter.addFilter("canc01", canc01);
		queryFilter.addFilter("cand09", "1");
		return dao.getListForm("getAllArticleList", queryFilter);

	}

	public List<ArticleDto> getAllArticleListByAlias(String canc11, QueryFilter queryFilter) {

		queryFilter.addFilter("canc11", canc11);
		queryFilter.addFilter("cand09", "1");
		return dao.getListForm("getAllArticleList", queryFilter);

	}

	public void stickTop(Long cand01) {

		Article article = this.getById(cand01);
		// List<Article>
		// articleList=getStickTopChildArticle(article.getCanc01());
		//
		// for(Article siblingArticle:articleList){
		// siblingArticle.setCand17(0L);
		// dao.update(siblingArticle);
		// }
		article.setCand17(1L);
		dao.update(article);

	}

	public void cancelStickTop(Long cand01) {

		Article article = this.getById(cand01);
		// List<Article>
		// articleList=getStickTopChildArticle(article.getCanc01());
		//
		// for(Article siblingArticle:articleList){
		// siblingArticle.setCand17(0L);
		// dao.update(siblingArticle);
		// }
		article.setCand17(0L);
		dao.update(article);

	}

	/**
	 * 获取分类下已置顶的文章列表
	 * 
	 * @param canc01
	 * @return
	 */
	public List<Article> getStickTopChildArticle(Long canc01) {

		Map params = new HashMap();
		params.put("canc01", canc01);
		params.put("and17", 1);
		return dao.getBySqlKey("getAll", params);
	}

	public List<ArticleDto> getAllChildenArticle(Long canc01, QueryFilter queryFilter) {
		ArticleColumn articleColumn = articleColumnService.getById(canc01);
		if (articleColumn == null) {
			return null;
		}
		String canc12 = articleColumn.getCanc12();
		queryFilter.addFilter("cand20", "%" + canc12 + "%");
		queryFilter.addFilter("cand09", "1");
		return dao.getListForm("getArticleList", queryFilter);

	}

	public List<Article> getByIdArray(String ids) {

		Map params = new HashMap();
		params.put("cand01", ids);
		return dao.getBySqlKey("getListByIds", params);

	}
	/**
	 * 移动端取得新闻最新新闻列表
	 * 2016-10-08
	 */
	public ResultData<Map<String,Object>> getNewArticleListWX(Long canc02,PageBean pageBean){
		QueryFilter queryFilter = new QueryFilter();
		queryFilter.setPageBean(pageBean);
		queryFilter.addFilter("canc02", canc02);
		List<Map<String,Object>> dataList= dao.getListForm("getNewArticleList", queryFilter);
		ResultData<Map<String,Object>> resultData = new ResultData<Map<String,Object>>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	/**
	 * 移动端取得新闻最新新闻列表
	 * 2016-10-08
	 */
	public Article getArticleDetail(Long cand01){
		Map <String,Object> map = new HashMap<String, Object>();
		map.put("cand01", cand01);
		List<Article> articleDtoList= dao.getBySqlKey("getArticleDetail", map);
		if(articleDtoList !=null && articleDtoList.size()>0){
			return articleDtoList.get(0);
		}else{
			return null;
		}
	}
}
