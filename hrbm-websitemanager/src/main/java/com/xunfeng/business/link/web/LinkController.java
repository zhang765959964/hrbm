package com.xunfeng.business.link.web;

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

import com.xunfeng.business.link.interf.LinkInterfaceService;
import com.xunfeng.business.link.model.Link;
import com.xunfeng.business.link.web.form.LinkForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
/**
 *<pre>
 * 对象功能:网站友情链接表 控制器类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-14 15:51:35
 *</pre>
 */
@Controller
@RequestMapping("/business/link/link/")
public class LinkController extends BaseController
{
	@Resource
	@Qualifier("link")
	private LinkInterfaceService linkService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf UniqueIdUtil;	
	
	
	/**
	 * 添加或更新网站友情链接表。
	 * @param request
	 * @param response
	 * @param link 添加或更新的实体
	 * @param bindResult
	 * @param viewName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新网站友情链接表")
	public void save(HttpServletRequest request, HttpServletResponse response,LinkForm linkForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long ccmw01=RequestUtil.getLong(request,"ccmw01");
		    Link link = linkService.getById(ccmw01);
			link=linkForm.getModel(link);
			if(linkForm.isMvcAdd()){
				resultMsg="添加网站友情链接表";
				link.setCcmw01(UniqueIdUtil.genId(Link.class.getName()));
				linkService.add(link);
				
			}else{
				resultMsg="更新网站友情链接表";
			    linkService.update(link);
				
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
	 * 取得网站友情链接表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=this.getAutoView();
		
		return mv;
	}
	/**
	 * 取得网站友情链接表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		List<Link> list=linkService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除网站友情链接表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除网站友情链接表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "ccmw01");
			linkService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除网站友情链接表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增网站友情链接表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增网站友情链接表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		LinkForm  linkForm=new LinkForm();
		linkForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/link/linkEdit.jsp");
		
		return modelAndView.addObject("linkForm",linkForm);					
	}
	/**
	 * 	编辑网站友情链接表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑网站友情链接表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long ccmw01=RequestUtil.getLong(request,"ccmw01",0L);
		Link link=linkService.getById(ccmw01);
		LinkForm  linkForm=new LinkForm();
		linkForm.putModel(link);
		
		return getAutoView().addObject("linkForm",linkForm);					
	}

	/**
	 * 取得网站友情链接表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看网站友情链接表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long ccmw01=RequestUtil.getLong(request,"ccmw01");
		Link link = linkService.getById(ccmw01);	
		return getAutoView().addObject("link", link);
	}
	
}
