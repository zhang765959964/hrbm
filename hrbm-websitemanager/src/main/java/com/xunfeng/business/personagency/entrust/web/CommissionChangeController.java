package com.xunfeng.business.personagency.entrust.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.entrust.model.CommissionChange;
import com.xunfeng.business.personagency.entrust.web.form.CommissionChangeForm;
import com.xunfeng.business.personagency.entrust.dto.CommissionChangeDto;
import com.xunfeng.business.personagency.entrust.interf.CommissionChangeServiceInterf;
import com.xunfeng.business.personagency.receive.web.form.ArchivesPersonForm;
import com.xunfeng.business.personagency.storage.model.WageStandard;
import com.xunfeng.business.personagency.storage.web.form.WageStandardForm;
import com.xunfeng.business.personagency.unitagreement.interf.UnitAgreementServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 委托类型变更 控制器类
* @author:jiangxin
* @createDate 2016-08-22 14:48:20 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/entrust/commissionChange/")
public class CommissionChangeController extends BaseController
{
	@Resource
	@Qualifier("commissionChange")
	private CommissionChangeServiceInterf commissionChangeService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("unitAgreement")
	private UnitAgreementServiceInterf unitAgreementService;
	
	/**
	 * 添加或更新委托类型变更。
	 * @param request
	 * @param response
	 * @param commissionChangeForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新委托类型变更")
	public void save(HttpServletRequest request, HttpServletResponse response,CommissionChangeForm commissionChangeForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    CommissionChange commissionChange = commissionChangeService.getById(id);
			commissionChange=commissionChangeForm.getModel(commissionChange);
			CommissionChangeDto commissionChangeDto = new CommissionChangeDto();
			if(commissionChangeForm.isMvcAdd()){
				resultMsg="委托类型变更";
				commissionChange.setId(uniqueIdUtil.genId(CommissionChange.class.getName()));
				commissionChange.setCczy06("16");
				commissionChange.setCcpr08("0");
				commissionChange.setPrintNumber(0l);
				commissionChangeDto= BeanToBean.copyProperties(commissionChange, commissionChangeDto, false);
				if(commissionChangeForm.getAab001not()!=null){//StringUtil.isNotEmpty(commissionChangeForm.getAab001not().toString())
					commissionChangeDto.setAab001not(commissionChangeForm.getAab001not());
				}
				commissionChangeService.addCommissionChange(commissionChangeDto);
			}else{
				resultMsg="修改委托类型变更";
			    commissionChangeService.update(commissionChange);
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "操作失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	/**
	 * 取得委托类型变更分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/entrust/commissionChangeList.jsp");
		return mv;
	}
	//
	@RequestMapping("search")
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/entrust/searchCommissionChangeList.jsp");
		return mv;
	}
	//
	@RequestMapping("resultList")
	@Action(description="类型变更操作界面")
	public ModelAndView resultList(HttpServletRequest request) throws Exception
	{
		Long personId = RequestUtil.getLong(request,"personId",0L);
		Map personMap = new HashMap();
		if(personId!=0){
			personMap = archivesService.getArchivesByPersonId(personId);
		}	
		ArchivesPersonForm archivesPersonForm = new ArchivesPersonForm();
		archivesPersonForm = (ArchivesPersonForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/entrust/commissionChangeResultList.jsp");
		modelAndView.addObject("archivesPersonForm", archivesPersonForm).addObject("personId", personId)
			.addObject("id", archivesPersonForm.getId()==null?"0":archivesPersonForm.getId())
			.addObject("archiveFlowStatus", archivesPersonForm.getArchiveFlowStatus()==null?"0":archivesPersonForm.getArchiveFlowStatus());				
		return modelAndView;
	}
	/**
	 * 取得委托类型变更分页列表
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
		ResultData<CommissionChange> resultData=commissionChangeService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	//查询所有的类型变更的数据
	@RequestMapping("searchListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> searchListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		if("9".equals(fiter.getFilters().get("aac004"))){
			fiter.getFilters().remove("aac004");
		}
		ResultData resultData=commissionChangeService.getAllCommissionChange(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	@RequestMapping("addjqGrid")
	@Action(description = "新增jqGrid")
	@ResponseBody
	public Map<Object,Object> getPrimaryKey(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<Object,Object> commissionmMap = new HashMap<Object, Object>();
		try {
			SysUser sysUser=ContextUtil.getCurrentUser();
			SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
			String archivesId = RequestUtil.getString(request, "id");
			Archives archives =	archivesService.getById(Long.parseLong(archivesId));
			String commissionDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String createrDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date());
			commissionmMap.put("commissionTypeName", "");
			commissionmMap.put("archiveCodeBefore", archives.getArchiveCode());
			commissionmMap.put("commissionDate", commissionDate);
			commissionmMap.put("createrName", sysUser.getAac003());
			commissionmMap.put("createrOrgName", sysOrg.getAcd202());
			commissionmMap.put("createrDate", createrDate);
			
		} catch (Exception ex) {
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return commissionmMap;
	}
	/**
	 * 删除委托类型变更
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除委托类型变更")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			commissionChangeService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除委托类型变更成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增委托类型变更
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增委托类型变更")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		CommissionChangeForm  commissionChangeForm=new CommissionChangeForm();
		commissionChangeForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/entrust/commissionChangeEdit.jsp");
		
		return modelAndView.addObject("commissionChangeForm",commissionChangeForm);					
	}
	/**
	 * 	编辑委托类型变更
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑委托类型变更")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		CommissionChange commissionChange=commissionChangeService.getById(id);
		CommissionChangeForm  commissionChangeForm=new CommissionChangeForm();
		commissionChangeForm.putModel(commissionChange);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/entrust/commissionChangeEdit.jsp");
		return modelAndView.addObject("commissionChangeForm",commissionChangeForm);					
	}

	/**
	 * 取得委托类型变更明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看委托类型变更明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		CommissionChange commissionChange = commissionChangeService.getById(id);	
		return getAutoView().addObject("commissionChange", commissionChange);
	}
	
	
	@RequestMapping("commissionDiv")
	@Action(description="刷新保存后div")
	public ModelAndView commissionDiv(HttpServletRequest request) throws Exception
	{
		Long id = RequestUtil.getLong(request,"id",0L);
		Long archiveFlowStatus = RequestUtil.getLong(request,"archiveFlowStatus",0L);
		CommissionChangeForm  commissionChangeForm = new CommissionChangeForm();
		Archives archives =	archivesService.getById(id);
		commissionChangeForm.setCommissionDate(new Date());
		commissionChangeForm.setArchivesId(id);
		initCreater(commissionChangeForm);
		commissionChangeForm.setArchiveCodeBefore(archives.getArchiveCode());
		commissionChangeForm.setPersonId(archives.getPersonId());
		commissionChangeForm.setArchiveType(archives.getArchiveType());
		ModelAndView modelAndView = new ModelAndView("/business/personagency/entrust/commissionChangeDiv.jsp");
		modelAndView.addObject("archiveType", archives.getArchiveType());
		modelAndView.addObject("commissionChangeForm",commissionChangeForm)
		.addObject("id", id).addObject("archiveFlowStatus", archiveFlowStatus);		
		return modelAndView;					
	}
	
	@RequestMapping("commissionDivSearch")
	@Action(description="刷新保存后div")
	public ModelAndView commissionDivSearch(HttpServletRequest request) throws Exception
	{
		Long id = RequestUtil.getLong(request,"id",0L);
		Long archiveFlowStatus = RequestUtil.getLong(request,"archiveFlowStatus",0L);
		Long bgID = RequestUtil.getLong(request,"bgID",0L);
		CommissionChangeForm  commissionChangeForm = new CommissionChangeForm();
		if(bgID>0){
			CommissionChange commissionChange=commissionChangeService.getById(bgID);
			commissionChangeForm.putModel(commissionChange);
		}
		ModelAndView modelAndView = new ModelAndView("/business/personagency/entrust/commissionChangeDivSearch.jsp");
		modelAndView.addObject("commissionChangeForm2",commissionChangeForm)
		.addObject("id", id).addObject("archiveFlowStatus", archiveFlowStatus)
		.addObject("commissionType", commissionChangeForm.getCommissionType()==null?0l:commissionChangeForm.getCommissionType());		
		return modelAndView;					
	}
	//
	@RequestMapping("searchUnitCorp")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public List searchUnitCorp(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter = new QueryFilter(request);
		if(!"".equals(fiter.getFilters().get("aab004"))){
			fiter.addFilter("aab004", "%"+fiter.getFilters().get("aab004")+"%");
		}
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPagesize(6);
		fiter.setPageBean(pageBean);
		ResultData resultData = unitAgreementService.getByUnitStatus(fiter);
		return resultData.getDataList();
	}
	
}
