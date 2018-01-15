package com.xunfeng.business.jobfair.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.jobfair.interf.JobFairInfoServiceInter;
import com.xunfeng.business.jobfair.interf.JobFairSiteServiceInterf;
import com.xunfeng.business.jobfair.model.JobFairInfo;
import com.xunfeng.business.jobfair.model.JobFairSite;
import com.xunfeng.business.jobfair.web.form.JobFairInfoForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.uums.model.SysDept;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 招聘会信息表 控制器类
* @author:wanghan
* @createDate 2015-09-12 11:02:45 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/jobfair/jobFairInfo/")
public class JobFairInfoController extends BaseController
{
	@Resource
	@Qualifier("jobfair")
	private JobFairInfoServiceInter jobFairInfoService;
	@Resource
	@Qualifier("jobfairSite")
	private JobFairSiteServiceInterf jobFairSiteService;

	/**
	 * 添加或更新招聘会信息表。
	 * @param request
	 * @param response
	 * @param jobFairInfoForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新招聘会信息")
	public void save(HttpServletRequest request, HttpServletResponse response,JobFairInfoForm jobFairInfoForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long acb330=RequestUtil.getLong(request,"acb330");
		    Long acd250=RequestUtil.getLong(request,"acd200");
		    Date acb333=RequestUtil.getDate(request, "acb333","yyyy-MM-dd HH:mm");
		    Date acb334=RequestUtil.getDate(request, "acb334","yyyy-MM-dd HH:mm");
		    JobFairInfo jobFairInfo = jobFairInfoService.getById(acb330);
			jobFairInfo=jobFairInfoForm.getModel(jobFairInfo);
			if(jobFairInfoForm.isMvcAdd()){
				resultMsg="添加招聘会信息";
				SysUser sysUser=ContextUtil.getCurrentUser();
				SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
				JobFairSite jobFairSite=jobFairSiteService.getById(acd250);
				jobFairInfo.setAcb330(uniqueIdUtil.genId(JobFairInfo.class.getName()));
				jobFairInfo.setAae011(String.valueOf(sysUser.getAcd230()));
				jobFairInfo.setAae019(sysUser.getAac003());
				jobFairInfo.setAcb33a((long) 0);
				jobFairInfo.setAce750("0");
				jobFairInfo.setCcpr08("0");
				jobFairInfo.setAae017(String.valueOf(sysOrg.getAcd200()));
				jobFairSite.setCczc007("0");
				jobFairInfo.setAcb333(acb333);
				jobFairInfo.setAcb334(acb334);
				jobFairInfoService.add(jobFairInfo);
				jobFairSiteService.update(jobFairSite);
			}else{
				resultMsg="更新招聘会信息";
				jobFairInfo.setAcb333(acb333);
				jobFairInfo.setAcb334(acb334);
			    jobFairInfoService.update(jobFairInfo);
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
	 * 取得招聘会信息表分页列表
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
	 * 取得招聘会信息表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listView")
	public ModelAndView listView(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView modelAndView= new ModelAndView("/business/jobfair/jobFairInfoViewList.jsp");
		return modelAndView;
	}
	/**
	 * 取得招聘会信息表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJsonView")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listJsonView(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
	    int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
//		List<JobFairInfo> list= 
		ResultData<JobFairInfo> resultData = jobFairInfoService.getJobInfoViewsPageList(fiter);
//		resultData.setPageBean(fiter.getPageBean());
//		resultData.setDataList(list);
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 取得招聘会信息表分页列表
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
		List<JobFairInfo> list=jobFairInfoService.getAll(fiter);
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除招聘会信息表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除招聘会信息表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "acb330");
			long acb330 = RequestUtil.getLong(request,"acb330");
			JobFairInfo jobFairInfo=jobFairInfoService.getById(acb330);
			String acd25 = jobFairInfo.getAcd200();
			if(StringUtils.isNotEmpty(acd25)){
				Long acd250=Long.parseLong(acd25);
				Long acd200=acd250;
				List<JobFairInfo> list=jobFairInfoService.getAcd200(acd200);
				if(list.size()==1){
					JobFairSite jobFairSite=jobFairSiteService.getById(acd250);
					jobFairSite.setCczc007("1");
					jobFairSiteService.update(jobFairSite);
				}
				jobFairInfoService.delByIds(lAryId);
			}else{
				jobFairInfoService.delByIds(lAryId);
				
			}
			message=new ResultMessage(ResultMessage.Success, "删除招聘会信息成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增招聘会信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增招聘会信息")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		JobFairInfoForm  jobFairInfoForm=new JobFairInfoForm();
		jobFairInfoForm.putModel(null);
		SysUser sysUser= ContextUtil.getCurrentUser();
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		SysDept sysDept=ContextUtil.getCurrentUserDept();
		jobFairInfoForm.setAae011(String.valueOf(sysUser.getAcd230()));
		jobFairInfoForm.setAab045(sysOrg==null?"":sysOrg.getAcd202());
		jobFairInfoForm.setAae019(sysUser.getAac003());
		jobFairInfoForm.setAcb338(sysDept==null?"":sysDept.getDep002());
		jobFairInfoForm.setAae020(sysOrg==null?"":sysOrg.getAcd202());
		jobFairInfoForm.setAae036(new Date());
		ModelAndView modelAndView= new ModelAndView("/business/jobfair/jobFairInfoEdit.jsp");
		
		return modelAndView.addObject("jobFairInfoForm",jobFairInfoForm);					
	}
	/**
	 * 	编辑招聘会信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑招聘会信息")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long acb330=RequestUtil.getLong(request,"acb330",0L);
		JobFairInfo jobFairInfo=jobFairInfoService.getById(acb330);
		JobFairInfoForm  jobFairInfoForm=new JobFairInfoForm();
		jobFairInfoForm.putModel(jobFairInfo);
		
		return getAutoView().addObject("jobFairInfoForm",jobFairInfoForm);					
	}

	/**
	 * 取得招聘会信息表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看招聘会信息表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long acb330=RequestUtil.getLong(request,"acb330");
		JobFairInfo jobFairInfo = jobFairInfoService.getById(acb330);	
		return getAutoView().addObject("jobFairInfo", jobFairInfo);
	}
	/**
	 * 招聘职位信息查询
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jobList")
	public ModelAndView jobList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{    //v_dwzp_info
		return new ModelAndView("/business/jobfair/jobList.jsp").addObject("orgs", getOrganSelectList());
	}
	
	/**
	 * 取得单位基本信息表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jobListJson")
	@Action(description="取得单位基本信息表分页列表")
	@ResponseBody
	public Map<Object,Object> jobListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
		ResultData<Map<String, Object>> resultData=jobFairInfoService.getJobListPage(addJurisdiction(fiter));
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	
	/**
	 * 获取当前机构及其子机构
	 * @return
	 */
	private String getSubOrgs(){
		List<SysOrg> orgs = sysOrgService.getSubOrgans(ContextUtil.getCurrentUserOrg().getAcd200());
		if(orgs!=null&&orgs.size()>0){
			StringBuilder stringBuilder = new StringBuilder();
			for (SysOrg sysOrg : orgs) {
				stringBuilder.append(sysOrg.getAcd200()).append(",");
			}
			return stringBuilder.substring(0, stringBuilder.length()-1);
		}
		return String.valueOf(ContextUtil.getCurrentUserOrg().getAcd200());
	}
}
