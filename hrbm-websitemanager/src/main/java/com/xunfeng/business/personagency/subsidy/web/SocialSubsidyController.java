package com.xunfeng.business.personagency.subsidy.web;

import java.net.URLDecoder;
import java.util.Calendar;
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

import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.interf.PersonExpandServiceInterf;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.subsidy.dto.BatchSocialSubsidyDto;
import com.xunfeng.business.personagency.subsidy.dto.SocialSubsidyDto;
import com.xunfeng.business.personagency.subsidy.interf.SocialParamsServiceInterf;
import com.xunfeng.business.personagency.subsidy.interf.SocialSubsidyServiceInterf;
import com.xunfeng.business.personagency.subsidy.model.SocialParams;
import com.xunfeng.business.personagency.subsidy.model.SocialSubsidy;
import com.xunfeng.business.personagency.subsidy.web.form.SocialSubsidyForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 社保补贴 控制器类
* @author:wanghan
* @createDate 2016-07-06 11:03:39 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/subsidy/socialSubsidy")
public class SocialSubsidyController extends BaseController
{
	@Resource
	@Qualifier("socialSubsidy")
	private SocialSubsidyServiceInterf socialSubsidyService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	@Resource
	@Qualifier("socialParams")
	private SocialParamsServiceInterf socialParamsService;
	
	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf personService;
	
	@Resource
	@Qualifier("personExpand")
	private PersonExpandServiceInterf personExpandService;
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	/**
	 * 添加或更新社保补贴。
	 * @param request
	 * @param response
	 * @param socialSubsidyForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新社保补贴")
	public void save(HttpServletRequest request, HttpServletResponse response,SocialSubsidyForm socialSubsidyForm) throws Exception
	{
		String resultMsg="保存";	
		ResultMessage message=null;	
		
		try{

		    SocialSubsidyDto socialSubsidyDto=BeanToBean.copyProperties(socialSubsidyForm, new SocialSubsidyDto(), false);
		    socialSubsidyService.saveOrUpdate(socialSubsidyDto);

			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");

			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	
	@RequestMapping("review")
	@Action(description="审核社保补贴人员")
	public void review(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String resultMsg="审核";	
		ResultMessage message=null;	
		try{
		    
			
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			String checkState=RequestUtil.getString(request,"checkState");
		    socialSubsidyService.review(lAryId, checkState);

			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");

			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
		
	}
	
	@RequestMapping("batchUpdate")
	@Action(description="批量参数变更")
	public void batchUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String resultMsg="参数批量更新";	
		ResultMessage message=null;	
		try{
		    
			Long id =RequestUtil.getLong(request, "id",0);
			Long batchId =RequestUtil.getLong(request, "batchId",0);
			String pensionStandard=RequestUtil.getString(request,"pensionStand");
			String medicalStandard=RequestUtil.getString(request,"medicalStand");
		    socialSubsidyService.batchUpdate(id,batchId, pensionStandard, medicalStandard);

			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");

			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
		
	}
	
	/**
	 * 取得社保补贴分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		
		ModelAndView mv= new ModelAndView("/business/personagency/subsidy/socialSubsidyList.jsp");
		
		return mv;
		
	}

	
	/**
	 * 社保补贴编号手动修改
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("numUpdate")
	public ModelAndView numUpdate(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		
		ModelAndView mv= new ModelAndView("/business/personagency/subsidy/socialSubsidyNumUpdate.jsp");
		
		return mv;
		
	}
	
	/**
	 * 社保补贴编号手动修改
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("numUpdateSave")
	@ResponseBody
	public ResultMessage numUpdateSave(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	

		ResultMessage message=null;
		try{
			Long id =RequestUtil.getLong(request, "id",0);
			String subsidyNum =RequestUtil.getString(request, "subsidyNum");
			String createrNum =RequestUtil.getString(request, "createrNum");
			socialSubsidyService.updateNum(id, subsidyNum,createrNum);
			message=new ResultMessage(ResultMessage.Success, "社保补贴编号修改成功!");
		}catch(RuntimeException ex){
			message=new ResultMessage(ResultMessage.Fail,  ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "社保补贴编号修改失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
		
	}

	@RequestMapping("isCodeExist")
	@Action(description="批量参数变更")
	@ResponseBody
	public ResultMessage isCodeExist(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String resultMsg="编号重复";	
		ResultMessage message=null;	
		try{
		    
			Long id =RequestUtil.getLong(request, "id",0);
			String subsidyNum =RequestUtil.getString(request, "subsidyNum");
			List<SocialSubsidy> lst=socialSubsidyService.getListBySubsidyNum(id,subsidyNum);
			if(lst!=null&&lst.size()>0){
				message=new ResultMessage(ResultMessage.Fail, resultMsg);
			}else{
				message=new ResultMessage(ResultMessage.Success, "");
			}

		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "编号重复判断出错" );
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		 return message;
	}
	/**
	 * 取得社保补贴分页列表
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
		ResultData<SocialSubsidyDto> resultData=socialSubsidyService.getAllSubsidyPersonByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}

	
	
	/**
	 * 取得社保补贴分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("batchListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> batchListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{		    
		QueryFilter fiter=new QueryFilter(request);
	    Long batchId = RequestUtil.getLong(request, "batchId");
	    Long aac001 = RequestUtil.getLong(request, "aac001");
		ResultData<BatchSocialSubsidyDto> resultData=socialSubsidyService.getBatchSocialListByBatchId(batchId,null,aac001==0L?null:aac001, fiter.getPageBean());
		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	/**
	 * 取得社保补贴分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("batchAppListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> batchAppListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{		    
		QueryFilter fiter=new QueryFilter(request);
	    Long batchId = RequestUtil.getLong(request, "batchId");
		ResultData<BatchSocialSubsidyDto> resultData=socialSubsidyService.getBatchSocialListByBatchId(batchId, fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 取得社保补贴分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("batchUserListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public List<BatchSocialSubsidyDto> batchUserListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{		    
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPagesize(10);
	    Long batchId = RequestUtil.getLong(request, "batchId");
	    String searchValue = RequestUtil.getString(request, "searchValue");
	    
		ResultData<BatchSocialSubsidyDto> resultData=socialSubsidyService.getBatchSocialListByBatchId(batchId, searchValue,pageBean);	
		return resultData.getDataList();
	}
	
	/**
	 * 删除社保补贴
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除社保补贴")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			socialSubsidyService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除社保补贴成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	
	/**
	 * 	新增社保补贴
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增社保补贴")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
	
		ModelAndView modelAndView= new ModelAndView("/business/personagency/subsidy/socialSubsidyAdd.jsp");
		
		return modelAndView;				
	}
	/**
	 * 	编辑社保补贴
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑社保补贴")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{	
		Long personId=RequestUtil.getLong(request,"personId",0L);
	
		
		SocialSubsidyForm  socialSubsidyForm=new SocialSubsidyForm();
        Calendar now = Calendar.getInstance();  
        int endYear=now.get(Calendar.YEAR);
        int startYear=endYear-1;
        String annualYear=startYear+"-"+endYear;
        socialSubsidyForm.setAnnualYear(annualYear);
		initCreater(socialSubsidyForm);
		socialSubsidyForm.setCheckState("0");
		if(personId!=0){//查到当前人员
			PersonBaseInfo personBaseInfo=personService.getById(personId);
			PersonExpand personExpand=personExpandService.getByExpPersonId(personId);
			Archives archives=archivesService.getArchivesByPId(personId);
			BeanToBean.copyProperties(personBaseInfo, socialSubsidyForm, false);
			
			if(personExpand!=null){
				BeanToBean.copyProperties(personExpand, socialSubsidyForm);
			}
			if(archives!=null){
				BeanToBean.copyProperties(archives, socialSubsidyForm);
			}
			
			SocialSubsidy socialSubsidy=socialSubsidyService.getByPersonId(personId);
			if(socialSubsidy==null){//查到当前人员，当前人员已办理补贴
				now.set(Calendar.YEAR, startYear);
				SocialParams medicalSocial=socialParamsService.getMedicalSocialParams(now.getTime());
				SocialParams pensionSocial=socialParamsService.getPensionSocialParams(now.getTime());
				socialSubsidyForm.setPensionStandard(pensionSocial.getParamsValue());
				socialSubsidyForm.setMedicalStandard(medicalSocial.getParamsValue());
			}else{//查到当前人员，当前人员未办理补贴
				socialSubsidyForm.putModel(socialSubsidy);
			}
			
		}	
		ModelAndView modelAndView= new ModelAndView("/business/personagency/subsidy/socialSubsidyEdit.jsp");
		return modelAndView.addObject("socialSubsidyForm",socialSubsidyForm).addObject("currentPersonId", personId);					
	}
	
	
	/**
	 * 	编辑社保补贴
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("view")
	@Action(description="编辑社保补贴")
	public ModelAndView view(HttpServletRequest request) throws Exception
	{	
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Long lzStatus	= 0l;	//流转状态
 		Long jsStatus = 0L;		//接收状态
 		Long daStatus = 0l;	//档案状态
		
		SocialSubsidyForm  socialSubsidyForm=new SocialSubsidyForm();
        Calendar now = Calendar.getInstance();  
        int endYear=now.get(Calendar.YEAR);
        int startYear=endYear-1;
        String annualYear=startYear+"-"+endYear;
        socialSubsidyForm.setAnnualYear(annualYear);
		initCreater(socialSubsidyForm);
		socialSubsidyForm.setCheckState("0");
		if(personId!=0){//查到当前人员
			PersonBaseInfo personBaseInfo=personService.getById(personId);
			PersonExpand personExpand=personExpandService.getByExpPersonId(personId);
			Archives archives=archivesService.getArchivesByPId(personId);
			if(archives!=null){	//档案编号不为空
 				lzStatus = archives.getArchiveFlowStatus();	//流转状态
 				jsStatus = archives.getArchiveReceiveStatus();	//档案接收状态
 				daStatus = archives.getArchiveStatus();	//档案状态
 			}
			
			BeanToBean.copyProperties(personBaseInfo, socialSubsidyForm, false);
			BeanToBean.copyProperties(personExpand, socialSubsidyForm);
			BeanToBean.copyProperties(archives, socialSubsidyForm);
			SocialSubsidy socialSubsidy=socialSubsidyService.getByPersonId(personId);
			if(socialSubsidy==null){//查到当前人员，当前人员已办理补贴
				now.set(Calendar.YEAR, startYear);
				SocialParams medicalSocial=socialParamsService.getMedicalSocialParams(now.getTime());
				SocialParams pensionSocial=socialParamsService.getPensionSocialParams(now.getTime());
				socialSubsidyForm.setPensionStandard(pensionSocial.getParamsValue());
				socialSubsidyForm.setMedicalStandard(medicalSocial.getParamsValue());
			}else{//查到当前人员，当前人员未办理补贴
				socialSubsidyForm.putModel(socialSubsidy);
			}
			
		}	
		ModelAndView modelAndView= new ModelAndView("/business/personagency/subsidy/socialSubsidyView.jsp");
		return modelAndView.addObject("socialSubsidyForm",socialSubsidyForm)
				.addObject("lzStatus", lzStatus).addObject("jsStatus", jsStatus).addObject("daStatus", daStatus);					
	}

	/**
	 * 取得社保补贴明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看社保补贴明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		SocialSubsidy socialSubsidy = socialSubsidyService.getById(id);	
		return getAutoView().addObject("socialSubsidy", socialSubsidy);
	}

}
