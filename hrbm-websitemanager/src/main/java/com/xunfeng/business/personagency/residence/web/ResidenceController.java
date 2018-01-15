package com.xunfeng.business.personagency.residence.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.residence.model.Residence;
import com.xunfeng.business.personagency.residence.web.form.ResidenceForm;
import com.xunfeng.business.personagency.residence.interf.ResidenceServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口材料表 控制器类
* @author:jiangxin
* @createDate 2016-08-26 11:46:18 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/residence/residence/")
public class ResidenceController extends BaseController
{
	@Resource
	@Qualifier("residence")
	private ResidenceServiceInterf residenceService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	
	
	/**
	 * 添加或更新户口材料表。
	 * @param request
	 * @param response
	 * @param residenceForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新户口材料表")
	public void save(HttpServletRequest request, HttpServletResponse response,ResidenceForm residenceForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    Residence residence = residenceService.getById(id);
			residence=residenceForm.getModel(residence);
			if(residenceForm.isMvcAdd()){
				resultMsg="添加户口材料";
				residence.setId(uniqueIdUtil.genId(Residence.class.getName()));
				residenceService.add(residence);
			}else{
				resultMsg="修改户口材料";
			    residenceService.update(residence);
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
	 * 取得户口材料表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/residence/residenceList.jsp");
		
		return mv;
	}
	/**
	 * 取得户口材料表分页列表
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
		if("9".equals(fiter.getFilters().get("aac004"))){
			fiter.getFilters().remove("aac004");
		}
		fiter.addFilter("ccpr08", 0);
		//ResultData<Residence> resultData=residenceService.getAllByFilter(fiter);
		ResultData resultData=residenceService.getAllResidence(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除户口材料表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除户口材料表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			residenceService.deleteResidenceByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除户口材料信息成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增户口材料表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增户口材料表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		Archives archives =	archivesService.getById(id);
		ResidenceForm  residenceForm = new ResidenceForm();
		SysUser sysUser=ContextUtil.getCurrentUser();
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		residenceForm.setArchivesId(id);
		residenceForm.setPersonId(archives.getPersonId());
		initCreater(residenceForm);
		residenceForm.setApplicationDate(new Date());
		residenceForm.setCczy06("16");
		residenceForm.setCcpr08("0");
		residenceForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/residence/residenceEdit.jsp");
		return modelAndView.addObject("residenceForm",residenceForm);					
	}
	/**
	 * 	编辑户口材料表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑户口材料表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		Residence residence=residenceService.getById(id);
		ResidenceForm  residenceForm=new ResidenceForm();
		residenceForm.putModel(residence);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/residence/residenceEdit.jsp");
		return modelAndView.addObject("residenceForm",residenceForm);					
	}

	/**
	 * 取得户口材料表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看户口材料表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		Residence residence = residenceService.getById(id);	
		return getAutoView().addObject("residence", residence);
	}
	
}
