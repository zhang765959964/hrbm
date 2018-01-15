package com.xunfeng.business.dissupport.jobmatch.web;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.dissupport.jobmatch.interf.PersonJobRecommendServiceInterf;
import com.xunfeng.business.jobfair.interf.JobFairInfoServiceInter;
import com.xunfeng.business.person.interf.PersonJobRegistServiceInter;
import com.xunfeng.business.person.model.PersonJobRegist;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.CorpMatchingDetailEnum;
import com.xunfeng.core.enumeration.MatchingDetailEnum;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;

/**
 * 招聘信息匹配控制类
 * @author lwh
 *
 */
@Controller
@RequestMapping("/business/dissupport/jobmatch/")
public class JobRecruitmentMatchController extends BaseController{
	
	@Resource
	@Qualifier("personJobRecommend")
	private PersonJobRecommendServiceInterf personJobRecommendService;
	
	@Resource
	@Qualifier("jobfair")
	private JobFairInfoServiceInter jobFairInfoService;
	
	@Resource
	@Qualifier("personJobRegist")
	private PersonJobRegistServiceInter personJobRegistService;
	/**
	 * 取得个人招聘匹配列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView listView(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/jobmatch/personMatcchPositionList.jsp").addObject("orgs", getOrganSelectList()).addObject("queryobjs", MatchingDetailEnum.values()).addObject("aac001",request.getParameter("aac001"));
		return modelAndView;
	}
	
	/**
	 * 个人招聘信息匹配职位列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */                                                                                              
	@RequestMapping("jobMatchListJson")
	@Action(description="招聘信息匹配职位列表")
	@ResponseBody
	public Map<Object,Object> jobMatchListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		if(StringUtil.isEmpty(request.getParameter("aac001"))){
		  return getTableData(0, new ArrayList<Map<String,Object>>());	
		}
		//获取个人信息
		PersonJobRegist  personJobRegist = personJobRegistService.getByPersonId(RequestUtil.getLong(request, "aac001", 0));
		//意向工种符合
		QueryFilter fiter=new QueryFilter(request);
		String queryobjs = request.getParameter("queryobjs");
		if(StringUtil.isNotEmpty(queryobjs)){
            //根据匹配条件生成检索条件
			fiter.addFilter("queryobjs", MatchingDetailEnum.getMatchSqlWhere(queryobjs, personJobRegist,fiter));
		}
		if(StringUtil.isNotEmpty(request.getParameter("acb228"))&&request.getParameter("acb228").equals("提供工作餐")){
			fiter.addFilter("acb228", "工作餐");
		}
		int limit =RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
		PageBean pageBean =WrapPageBean(limit, offset);
		fiter.setPageBean(pageBean);
		if(StringUtil.isNotEmpty(request.getParameter("acc214"))){
			fiter.addFilter("acc214", request.getParameter("acc214").split(","));
		}
		ResultData<Map<String,Object>>  resultData =jobFairInfoService.getJobMatchListPage(fiter);	
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	
	/**
	 * 取得单位招聘匹配列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listCorpView")
	public ModelAndView listCorpView(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/jobmatch/corpJobMatcchList.jsp").addObject("orgs", getOrganSelectList()).addObject("queryobjs", CorpMatchingDetailEnum.values());
		return modelAndView;
	}
	
	/**
	 * 单位招聘信息匹配职位列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */                                                                                              
	@RequestMapping("jobMatchCorpListJson")
	@Action(description="单位招聘信息匹配职位列表")
	@ResponseBody
	public Map<Object,Object> jobMatchCorpListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		if(StringUtil.isEmpty(request.getParameter("acb210"))){
		  return getTableData(0, new ArrayList<Map<String,Object>>());	
		}
		//获取职位信息
		QueryFilter param = new QueryFilter();
		param.addFilter("acb210", request.getParameter("acb210"));
		Map<String,Object> corpPostion = personJobRecommendService.getCorpPostionView(param);
		QueryFilter fiter=new QueryFilter(request);
		String queryobjs = request.getParameter("queryobjs");
		if(StringUtil.isNotEmpty(queryobjs)){
            //根据匹配条件生成检索条件
			fiter.addFilter("queryobjs", CorpMatchingDetailEnum.getMatchSqlWhere(queryobjs, corpPostion,fiter));
		}
		int limit =RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
		PageBean pageBean =WrapPageBean(limit, offset);
		fiter.setPageBean(pageBean);
		if(StringUtil.isNotEmpty(request.getParameter("acc214"))){
			fiter.addFilter("acc214", request.getParameter("acc214").split(","));
		}
		ResultData<Map<String,Object>>  resultData =jobFairInfoService.getCorpMatchPersonListPage(fiter);	
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
}
