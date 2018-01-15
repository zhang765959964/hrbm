package com.xunfeng.business.personagency.archive.web;

import java.util.Date;
import java.util.HashMap;
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
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.archive.model.ArchiveCheckout;
import com.xunfeng.business.personagency.archive.model.ArchiveLend;
import com.xunfeng.business.personagency.archive.web.form.ArchiveLendForm;
import com.xunfeng.business.personagency.archive.web.form.ArchivesLendPersonForm;
import com.xunfeng.business.personagency.archive.interf.ArchiveLendServiceInterf;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案调出表 控制器类
* @author:jx
* @createDate 2016-07-12 10:08:56 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/archive/archiveLend/")
public class ArchiveLendController extends BaseController
{
	@Resource
	@Qualifier("archiveLend")
	private ArchiveLendServiceInterf archiveLendService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	
	
	/**
	 * 添加或更新档案调出表。
	 * @param request
	 * @param response
	 * @param archiveLendForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新档案调出表")
	public void save(HttpServletRequest request, HttpServletResponse response,ArchiveLendForm archiveLendForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long lendId=RequestUtil.getLong(request,"lendId");
		    ArchiveLend archiveLend = archiveLendService.getById(lendId);
			archiveLend=archiveLendForm.getModel(archiveLend);
			if(archiveLendForm.isMvcAdd()){
				resultMsg="档案调出登记";
				archiveLend.setLendId(uniqueIdUtil.genId(ArchiveLend.class.getName()));
				archiveLend.setLendFlowStatus(4l);
				archiveLend.setLendIdNumber(archiveLend.getLendIdNumber().toUpperCase());
				archiveLendService.addLendRegister(archiveLend);
			}else{
				resultMsg="档案调出登记修改";
				archiveLend.setLendIdNumber(archiveLend.getLendIdNumber().toUpperCase());
			    archiveLendService.update(archiveLend);
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	//调出确认
	@RequestMapping("lendComfirm")
	@Action(description="调出确认")
	@ResponseBody
	public ResultMessage lendComfirm(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "lendId");
			ArchiveLend archiveLend = new ArchiveLend();
			SysUser sysUser=ContextUtil.getCurrentUser();
			SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
			archiveLend.setLendConfirmDate(new Date());
			archiveLend.setLendConfirmId(sysUser.getAcd230());
			archiveLend.setLendConfirmName(sysUser.getAac003());
			archiveLend.setLendConfirmOrgId(sysOrg.getAcd200());
			archiveLend.setLendConfirmOrgName(sysOrg.getAcd202());
			archiveLendService.addLendComfirm(archiveLend,lAryId);
			message=new ResultMessage(ResultMessage.Success, "调出确认成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "调出确认失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	
	/**
	 * 取得档案调出表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/archive/archiveLendList.jsp");
		return mv;
	}
	@RequestMapping("search")
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/archive/archiveLendSearch.jsp");
		return mv;
	}
	//调出登记
	@RequestMapping("registerList")
	public ModelAndView registerList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/archive/archiveLendRegister.jsp");
		return mv;
	}
	
	/**
	 * @param request
	 * @return 返回个人档案入库的界面
	 * @throws Exception
	 */
	@RequestMapping("resultList")
	@Action(description="档案调出登记页面")
	public ModelAndView resultList(HttpServletRequest request) throws Exception
	{
		Long personId=RequestUtil.getLong(request,"personId",0L);
		ArchivesLendPersonForm archivesLendPersonForm = new ArchivesLendPersonForm();
		Map archivesMap = new HashMap();
		if(personId!=0){
			archivesMap = archivesService.getStorageArchivesByPersonId(personId);
		}	
		archivesLendPersonForm = (ArchivesLendPersonForm) BeanUtils.populateEntity(archivesMap, archivesLendPersonForm);
		ArchiveLend archiveLend = archiveLendService.getArchiveLendByArchiveId(archivesLendPersonForm.getId()==null?0l:archivesLendPersonForm.getId(), 4l);
		ArchiveLendForm  archiveLendForm = new ArchiveLendForm();
		archiveLendForm.putModel(archiveLend);
		if(archiveLendForm.getLendId()==null){
			SysUser sysUser=ContextUtil.getCurrentUser();
			archiveLendForm.setLendCreaterId(sysUser.getAcd230());
			archiveLendForm.setLendCreaterName(sysUser.getAac003());
			SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
			archiveLendForm.setLendCreaterDate(new Date());
			archiveLendForm.setLendCreaterOrgId(sysOrg.getAcd200());
			archiveLendForm.setLendCreaterOrgName(sysOrg.getAcd202());
			archiveLendForm.setArchivesId(archivesLendPersonForm.getId()==null?0l:archivesLendPersonForm.getId());
			archiveLendForm.setLendName(archivesLendPersonForm.getAac003());
		}
		archiveLendForm.setLendDate(new Date());
		ModelAndView modelAndView= new ModelAndView("/business/personagency/archive/archiveLendRegisterResult.jsp");
		modelAndView.addObject("archivesLendPersonForm", archivesLendPersonForm).addObject("archiveLendForm",archiveLendForm)
					.addObject("personId",personId).addObject("archiveId", archivesLendPersonForm.getId()==null?0l:archivesLendPersonForm.getId())
					.addObject("archiveReceiveStatus",archivesLendPersonForm.getArchiveReceiveStatus()==null?1l:archivesLendPersonForm.getArchiveReceiveStatus())
					.addObject("lendId",archiveLendForm.getLendId()==null?0l:archiveLendForm.getLendId());
		return modelAndView;				
	}
	
	/**
	 * 取得档案调出表分页列表
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
		ResultData  resultData = archiveLendService.getAllArchiveLend(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	//档案调出综合查询
	@RequestMapping("searchListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> searchListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData  resultData = archiveLendService.getAllArchiveLendSearch(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除档案调出表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除档案调出表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long lendId=RequestUtil.getLong(request,"lendId",0L);
			archiveLendService.delArchiveLend(lendId);
			message=new ResultMessage(ResultMessage.Success, "档案调出取消成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "档案调出取消失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增档案调出表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增档案调出表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		ArchiveLendForm  archiveLendForm=new ArchiveLendForm();
		archiveLendForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/archive/archiveLendEdit.jsp");
		return modelAndView.addObject("archiveLendForm",archiveLendForm);					
	}
	/**
	 * 	编辑档案调出表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑档案调出表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long lendId=RequestUtil.getLong(request,"lendId",0L);
		ArchiveLend archiveLend=archiveLendService.getById(lendId);
		ArchiveLendForm  archiveLendForm=new ArchiveLendForm();
		archiveLendForm.putModel(archiveLend);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/archive/archiveLendEdit.jsp");
		return modelAndView.addObject("archiveLendForm",archiveLendForm);					
	}

	/**
	 * 取得档案调出表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看档案调出表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long lendId=RequestUtil.getLong(request,"lendId");
		ArchiveLend archiveLend = archiveLendService.getById(lendId);	
		return getAutoView().addObject("archiveLend", archiveLend);
	}
	
}
