package com.xunfeng.business.jobfair.web;

import java.util.Date;
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

import com.xunfeng.business.jobfair.interf.JobFairSiteServiceInterf;
import com.xunfeng.business.jobfair.model.JobFairSite;
import com.xunfeng.business.jobfair.web.form.JobFairSiteForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 场地表 控制器类
* @author:wanghan
* @createDate 2015-09-12 11:18:57 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/jobfair/jobFairSite/")
public class JobFairSiteController extends BaseController
{
	@Resource
	@Qualifier("jobfairSite")
	private JobFairSiteServiceInterf jobFairSiteService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf UniqueIdUtil;	
	/**
	 * 添加或更新场地表。
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新场地表")
	public void save(HttpServletRequest request, HttpServletResponse response,JobFairSiteForm jobFairSiteForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;
		try{
		    Long acd250=RequestUtil.getLong(request,"acd250");
		    JobFairSite jobFairSite = jobFairSiteService.getById(acd250);
			jobFairSite=jobFairSiteForm.getModel(jobFairSite);
			if(jobFairSiteForm.isMvcAdd()){
				resultMsg="添加场地";
				SysUser sysUser=ContextUtil.getCurrentUser();
				SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
				Long acd200=sysUser.getAcd200();
				jobFairSite.setAcd200(acd200);
				jobFairSite.setAcd250(UniqueIdUtil.genId(JobFairSite.class.getName()));
				jobFairSite.setAae011(String.valueOf(sysUser.getAcd230()));
				jobFairSite.setAae019(sysUser.getAac003());
				jobFairSite.setAae020(sysOrg.getAcd202());
				jobFairSite.setAae017(String.valueOf(sysOrg.getAcd200()));
				jobFairSiteService.add(jobFairSite);
			}else{
				resultMsg="更新场地";
			    jobFairSiteService.update(jobFairSite);
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
	 * 取得场地表分页列表
	 * @param request
	 * @param response
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
	 * 取得场地表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		List<JobFairSite> list=jobFairSiteService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除场地表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除场地")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "acd250");
			jobFairSiteService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除场地成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增场地表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增场地表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		JobFairSiteForm  jobFairSiteForm=new JobFairSiteForm();
		jobFairSiteForm.putModel(null);
		SysUser sysUser=ContextUtil.getCurrentUser();
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		jobFairSiteForm.setAae011(String.valueOf(sysUser.getAcd230()));
		jobFairSiteForm.setAae019(sysUser.getAac003());
		jobFairSiteForm.setAae020(sysOrg.getAcd202());
		jobFairSiteForm.setAae036(new Date());
		ModelAndView modelAndView= new ModelAndView("/business/jobfair/jobFairSiteEdit.jsp");
		
		return modelAndView.addObject("jobFairSiteForm",jobFairSiteForm);					
	}
	/**
	 * 	编辑场地表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑场地表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long acd250=RequestUtil.getLong(request,"acd250",0L);
		JobFairSite jobFairSite=jobFairSiteService.getById(acd250);
		JobFairSiteForm  jobFairSiteForm=new JobFairSiteForm();
		jobFairSiteForm.putModel(jobFairSite);
		
		return getAutoView().addObject("jobFairSiteForm",jobFairSiteForm);					
	}
	/**
	 * 取得场地表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看场地表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long acd250=RequestUtil.getLong(request,"acd250");
		JobFairSite jobFairSite = jobFairSiteService.getById(acd250);	
		return getAutoView().addObject("jobFairSite", jobFairSite);
	}
}
