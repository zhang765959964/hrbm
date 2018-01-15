package com.xunfeng.business.personagency.receive.web;

import java.util.ArrayList;
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
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.receive.model.ProxyManual;
import com.xunfeng.business.personagency.receive.web.form.ArchivesPersonForm;
import com.xunfeng.business.personagency.receive.web.form.ProxyManualForm;
import com.xunfeng.business.personagency.receive.interf.ProxyManualServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 代理手册表 控制器类
* @author:jx
* @createDate 2016-07-07 09:37:15 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/receive/proxyManual/")
public class ProxyManualController extends BaseController
{
	@Resource
	@Qualifier("proxyManual")
	private ProxyManualServiceInterf proxyManualService;
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新代理手册表。
	 * @param request
	 * @param response
	 * @param proxyManualForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新代理手册表")
	public void save(HttpServletRequest request, HttpServletResponse response,ProxyManualForm proxyManualForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long pmId=RequestUtil.getLong(request,"pmId");
		    ProxyManual proxyManual = proxyManualService.getById(pmId);
			proxyManual=proxyManualForm.getModel(proxyManual);
			proxyManual.setProxyDelete(0L);
			if(proxyManualForm.isMvcAdd()){
				resultMsg="代理手册合同书发放";
				proxyManual.setPmId(uniqueIdUtil.genId(ProxyManual.class.getName()));
				proxyManualService.add(proxyManual);
			}else{
				resultMsg="更新代理手册";
			    proxyManualService.update(proxyManual);
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
	 * 取得代理手册表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/receive/proxyManualList.jsp");
		return mv;
	}
	/**
	 * 取得代理手册表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("search")
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/receive/proxyManualSearch.jsp");
		return mv;
	}
	/**
	 * 取得代理手册表分页列表
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
		ResultData resultData= proxyManualService.getAllProxyManual(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	@RequestMapping("searchListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> searchListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		if("9".equals(fiter.getFilters().get("aac004"))){
			fiter.getFilters().remove("aac004");
		}
		ResultData  resultData = proxyManualService.getAllProxyManual(fiter);	
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	@RequestMapping("resultList")
	@Action(description="代理手册合同书页面")
	public ModelAndView resultList(HttpServletRequest request) throws Exception
	{
		
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Map personMap = new HashMap();
		if(personId!=0){
			personMap = archivesService.getArchivesByPersonId(personId);
		}	
		ArchivesPersonForm archivesPersonForm = new ArchivesPersonForm();
		archivesPersonForm = (ArchivesPersonForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/receive/proxyManualResultList.jsp");
		return modelAndView.addObject("archivesPersonForm", archivesPersonForm).addObject("personId", personId).addObject("id", archivesPersonForm.getId()==null?"0":archivesPersonForm.getId());					
	}
	/**
	 * 删除代理手册表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除代理手册表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pmId");
			proxyManualService.deleteProxyManualByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除代理手册合同书成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除代理手册合同书失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增代理手册表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增代理手册表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Map personMap = archivesService.getArchivesByPersonId(personId);
		ProxyManualForm  proxyManualForm=new ProxyManualForm();
		proxyManualForm.putModel(null);
		proxyManualForm.setPersonId(personId);
		if(!personMap.isEmpty()){
			proxyManualForm.setAAC002(personMap.get("AAC002").toString());
			proxyManualForm.setAAC003(personMap.get("AAC003").toString());
			proxyManualForm.setArchiveCode(personMap.get("archiveCode").toString());
			proxyManualForm.setArchiveStatusName(personMap.get("archiveStatusName").toString());
			proxyManualForm.setArchiveTypeName(personMap.get("archiveTypeName")==null?"":personMap.get("archiveTypeName").toString());
			proxyManualForm.setGenderName(personMap.get("genderName").toString());
		}
		SysUser sysUser=ContextUtil.getCurrentUser();
		proxyManualForm.setProxyIssuer(sysUser.getAac003());
		proxyManualForm.setLssuingDate(new Date());
		initCreater(proxyManualForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/receive/proxyManualEdit.jsp");
		return modelAndView.addObject("proxyManualForm",proxyManualForm);					
	}
	/**
	 * 	编辑代理手册表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑代理手册表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long pmId=RequestUtil.getLong(request,"pmId",0L);
		ProxyManual proxyManual=proxyManualService.getById(pmId);
		ProxyManualForm  proxyManualForm=new ProxyManualForm();
		proxyManualForm.putModel(proxyManual);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/receive/proxyManualEdit.jsp");
		return modelAndView.addObject("proxyManualForm",proxyManualForm);					
	}

	/**
	 * 取得代理手册表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看代理手册表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long pmId=RequestUtil.getLong(request,"pmId");
		ProxyManual proxyManual = proxyManualService.getById(pmId);	
		return getAutoView().addObject("proxyManual", proxyManual);
	}
	
}
