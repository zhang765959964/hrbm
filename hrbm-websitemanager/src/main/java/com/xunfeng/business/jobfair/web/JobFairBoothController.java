package com.xunfeng.business.jobfair.web;

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

import com.xunfeng.business.jobfair.interf.JobFairBoothServiceInterf;
import com.xunfeng.business.jobfair.model.JobFairBooth;
import com.xunfeng.business.jobfair.web.form.JobFairBoothForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 摊位初始化表 控制器类
* @author:wanghan
* @createDate 2015-09-12 11:06:53 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/jobfair/jobFairBooth/")
public class JobFairBoothController extends BaseController
{
	@Resource
	@Qualifier("jobfairBooth")
	private JobFairBoothServiceInterf jobFairBoothService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf UniqueIdUtil;	
	
	/**
	 * 添加或更新摊位初始化表。
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新摊位初始化表")
	public void save(HttpServletRequest request, HttpServletResponse response,JobFairBoothForm jobFairBoothForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long ace200=RequestUtil.getLong(request,"ace200");
		    JobFairBooth jobFairBooth = jobFairBoothService.getById(ace200);
			jobFairBooth=jobFairBoothForm.getModel(jobFairBooth);
			if(jobFairBoothForm.isMvcAdd()){
				resultMsg="添加摊位初始化";
				jobFairBooth.setAce200(UniqueIdUtil.genId(JobFairBooth.class.getName()));
				jobFairBoothService.add(jobFairBooth);
				
			}else{
				resultMsg="更新摊位初始化";
			    jobFairBoothService.update(jobFairBooth);
				
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
	 * 取得摊位初始化表分页列表
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
	 * 取得摊位初始化表分页列表
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
		List<JobFairBooth> list=jobFairBoothService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除摊位初始化表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除摊位初始化表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "ace200");
			jobFairBoothService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除摊位初始化成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增摊位初始化表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增摊位初始化表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		JobFairBoothForm  jobFairBoothForm=new JobFairBoothForm();
		jobFairBoothForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/jobfair/jobFairBoothEdit.jsp");
		
		return modelAndView.addObject("jobFairBoothForm",jobFairBoothForm);					
	}
	/**
	 * 	编辑摊位初始化表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑摊位初始化")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long ace200=RequestUtil.getLong(request,"ace200",0L);
		JobFairBooth jobFairBooth=jobFairBoothService.getById(ace200);
		JobFairBoothForm  jobFairBoothForm=new JobFairBoothForm();
		jobFairBoothForm.putModel(jobFairBooth);
		
		return getAutoView().addObject("jobFairBoothForm",jobFairBoothForm);					
	}

	/**
	 * 取得摊位初始化表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看摊位初始化表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long ace200=RequestUtil.getLong(request,"ace200");
		JobFairBooth jobFairBooth = jobFairBoothService.getById(ace200);	
		return getAutoView().addObject("jobFairBooth", jobFairBooth);
	}
	
}
