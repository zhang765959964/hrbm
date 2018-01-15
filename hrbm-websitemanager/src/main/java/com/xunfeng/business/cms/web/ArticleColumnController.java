package com.xunfeng.business.cms.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.cms.interf.ArticleColumnInter;
import com.xunfeng.business.cms.model.ArticleColumn;
import com.xunfeng.business.cms.web.form.ArticleColumnForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;

/**
 * <pre>
 * 对象功能:新闻类别表 控制器类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-08 10:08:15
 * </pre>
 */
@Controller
@RequestMapping("/business/cms/articleColumn/")
public class ArticleColumnController extends BaseController {

	@Resource
	@Qualifier("articlecol")
	private ArticleColumnInter articleColumnService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf UniqueIdUtil;	

	/**
	 * 添加或更新新闻类别表。
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description = "添加或更新新闻栏目表")
	public void save(HttpServletRequest request, HttpServletResponse response, ArticleColumnForm articleColumnForm) throws Exception {
		String resultMsg = null;
		ResultMessage message=null;
		try {
			Long canc01 = RequestUtil.getLong(request, "canc01", 0L);
			ArticleColumn articleColumn=articleColumnService.getById(canc01);
			articleColumn=articleColumnForm.getModel(articleColumn);
			if (articleColumnForm.isMvcAdd()) {
				resultMsg = "添加新闻栏目";
				articleColumn.setCanc01(UniqueIdUtil.genId(ArticleColumn.class.getName()));
				articleColumnService.add(articleColumn);
				
			} else {
				resultMsg = "更新新闻栏目";
				articleColumnService.update(articleColumn);
				
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");

			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}

	/**
	 * 取得新闻类别表分页列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	@Action(description = "查看新闻类别表分页列表")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mv = this.getAutoView();

		return mv;
	}

	/**
	 * 删除新闻类别表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description = "删除新闻类别表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String preUrl = RequestUtil.getPrePage(request);
		ResultMessage message = null;
		try {
			Long[] lAryId = RequestUtil.getLongAryByStr(request, "canc01");
			articleColumnService.delByIds(lAryId);
			message = new ResultMessage(ResultMessage.Success, "删除新闻类别表成功!");
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
		}
			return  message;
	}

	/**
	 * 编辑新闻类别表
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description = "编辑新闻类别表")
	public ModelAndView edit(HttpServletRequest request) throws Exception {
		Long canc01 = RequestUtil.getLong(request, "canc01", 0L);
		String opType = RequestUtil.getString(request, "opType");
		ArticleColumn articleColumn = null, parentArticleColumn = null;

		ArticleColumnForm articleColumnForm = new ArticleColumnForm();

		if ("add".equals(opType)) {
			articleColumn = new ArticleColumn();
			parentArticleColumn = articleColumnService.getById(canc01);
			articleColumn.setCanc02(canc01);

		} else {
			articleColumn = articleColumnService.getById(canc01);
			parentArticleColumn = articleColumnService.getById(articleColumn.getCanc02());
		}
		articleColumnForm.putModel(articleColumn);
		if (parentArticleColumn != null) {
			articleColumnForm.setParentColName(parentArticleColumn.getCanc03());
		}

		return getAutoView().addObject("articleColumnForm", articleColumnForm);
	}

	/**
	 * 取得新闻类别表明细
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description = "查看新闻类别表明细") 
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long canc01 = RequestUtil.getLong(request, "canc01");
		ArticleColumn articleColumn = articleColumnService.getById(canc01);
		return getAutoView().addObject("articleColumn", articleColumn);
	}
	/**
	 * 取得新闻类别表列表
	 */
	@RequestMapping("listLeftJson")
	@Action(description="左边树形结构")
	@ResponseBody
	public List listLeftJson(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String indent = RequestUtil.getString(request,"indent");
		List<ArticleColumn> listArticle = articleColumnService.getListLeftCms(indent);
		//List<ArticleColumn> listArticle = articleColumnService.getAll();
		List list = new ArrayList(); 
		Map<Object, Object> map = new HashMap();
		map.put("id", "0");
		map.put("canc01", "0");
		map.put("pId", "");
		map.put("name", "栏目");
		map.put("open", true);
		map.put("nodeType", "root");
		list.add(map);
		list.addAll(listArticle);
		return list;
	}
	/** 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("treeJson")
	@Action(description = "显示栏目树")
	@ResponseBody
	public List treeJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List list = new ArrayList();
		String index = request.getParameter("index");
		ArticleColumn articleColumn=new ArticleColumn();
		Map<Object, Object> map = new HashMap();
		map.put("id", "0");
		map.put("canc01", "0");
		map.put("pId", "");
		map.put("name", "栏目");
		map.put("open", true);
		map.put("nodeType", "root");
		// map.put("isParent","true" );
		list.add(map);
		List<ArticleColumn> articleColumnList = articleColumnService.getAll();
		list.addAll(articleColumnList);
		return list;
	}
	
}
