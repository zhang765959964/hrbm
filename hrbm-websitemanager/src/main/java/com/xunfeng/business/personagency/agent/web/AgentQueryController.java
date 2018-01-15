package com.xunfeng.business.personagency.agent.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.personagency.death.interf.DeathDeclareServiceInterf;
import com.xunfeng.business.personagency.party.interf.PartyServiceInterf;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.util.RequestUtil;


/**
 * 代理综合查询
 * @author zf
 * @date 2016-9-13 15:52:11
 *
 */
@Controller
@RequestMapping("/business/personagency/agent/query/")
public class AgentQueryController extends BaseController {
	
	
	
	@Resource
	@Qualifier("party")
	private PartyServiceInterf partyService;
	
	@Resource
	@Qualifier("deathDeclare")
	private DeathDeclareServiceInterf deathDeclareService;
	
	
	/**
	 * 进入代理详情查询页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchAgent")
	public ModelAndView searchAdmin(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		ModelAndView mv = new ModelAndView("/business/personagency/agent/query/searchAgent.jsp");
		return mv;
	}
	
	/**
	 * 进入到代理人员详情页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchAgentList")
	public ModelAndView searchAdminList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Long personId = RequestUtil.getLong(request, "personId",0L);
		ModelAndView mv = new ModelAndView("/business/personagency/agent/query/searchAgentList.jsp");
		return mv.addObject("personId", personId);
	}
	
	
	
	@RequestMapping("archives")
	public ModelAndView archiveList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		ModelAndView mv = new ModelAndView("/business/personagency/agent/query/archives.jsp");
		return mv;
	}
	
	
	/**
	 * 综合查询 页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("zhcxList")
	public ModelAndView zhcxList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		ModelAndView mv = new ModelAndView("/business/personagency/agent/query/zhcxList.jsp");
		return mv;
	}
	
	
	
	
	
	
}
