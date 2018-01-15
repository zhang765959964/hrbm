package com.xunfeng.business.personagency.party.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.party.dto.PartyDto;
import com.xunfeng.business.personagency.party.dto.PartyPersonDto;
import com.xunfeng.business.personagency.party.interf.PartyPayServiceInterf;
import com.xunfeng.business.personagency.party.interf.PartyServiceInterf;
import com.xunfeng.business.personagency.party.model.Party;
import com.xunfeng.business.personagency.party.web.form.PartyForm;
import com.xunfeng.business.personagency.party.web.form.PartyPersonForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
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
* @Description: 党组织关系表 控制器类
* @author:zhangfan
* @createDate 2016-08-16 17:22:15 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/party/")
public class PartyController extends BaseController
{
	@Resource
	@Qualifier("party")
	private PartyServiceInterf partyService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	@Resource
	@Qualifier("partyPay")
	private PartyPayServiceInterf partyPayService;
	
	@Resource
	@Qualifier("archives")
	private  ArchivesServiceInterf archivesService;
	
	
	
	
	/**
	 * 添加或更新党组织关系表。
	 * @param request
	 * @param response
	 * @param partyForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新党组织关系表")
	public void save(HttpServletRequest request, HttpServletResponse response,PartyForm partyForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		Long personId = RequestUtil.getLong(request, "personId");
		String nationId = RequestUtil.getString(request, "nationId");
		String whcdId = RequestUtil.getString(request, "whcdId");
		partyForm.setPersonId(personId);
		initCreater(partyForm);
		try{
			resultMsg="党组织关系";
			PartyDto partyDto 	 = BeanToBean.copyProperties(partyForm, new PartyDto(), false);
			PartyPersonDto partyPersonDto = BeanToBean.copyProperties(partyForm.getPartyPersonForm(), new PartyPersonDto(), false);
			partyPersonDto.setNationId(nationId);
			partyPersonDto.setWhcdId(whcdId);
			partyDto.setPartyPersonDto(partyPersonDto);
			partyService.saveOrUpdate(partyDto);
			if(partyDto.getPartyOutDate()!=null){
				resultMsg="党组织关系转出";
			}else{
				resultMsg="党组织关系转入";
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
	 * 党组织关系转入
	 * @param request
	 * @param response
	 * @param partyForm
	 * @throws Exception
	 */
	@RequestMapping("partyInto")
	@Action(description="添加或更新党组织关系表")
	public void partyInto(HttpServletRequest request, HttpServletResponse response,PartyForm partyForm) throws Exception
	{	String resultMsg=null;	
		ResultMessage message=null;	
		Long personId = RequestUtil.getLong(request, "personId");
		String nationId = RequestUtil.getString(request, "nationId");
		String whcdId = RequestUtil.getString(request, "whcdId");
		partyForm.setPersonId(personId);
		initCreater(partyForm);
		try{
			resultMsg="党组织关系";
			PartyDto partyDto 	 = BeanToBean.copyProperties(partyForm, new PartyDto(), false);
			PartyPersonDto partyPersonDto = BeanToBean.copyProperties(partyForm.getPartyPersonForm(), new PartyPersonDto(), false);
			partyPersonDto.setNationId(nationId);
			partyPersonDto.setWhcdId(whcdId);
			partyDto.setPartyPersonDto(partyPersonDto);
			partyService.partyInto(partyDto);
			resultMsg="党组织关系转入";
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
		
	}
	
	
	/**
	 * 显示终止经办人
	 * @param partyForm
	 * @return
	 */
	@SuppressWarnings("unused")
	private PartyForm initOutCreater(PartyForm partyForm){
		SysUser sysUser=ContextUtil.getCurrentUser();
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		partyForm.setOutCreaterId(sysUser.getAcd230());
		partyForm.setOutCreaterName(sysUser.getAac003());		
		partyForm.setOutCreaterDate(new Date()) ;
		partyForm.setOutCreaterOrgId(sysOrg.getAcd200());
		partyForm.setOutCreaterOrgName(sysOrg.getAcd202());
		return partyForm; 
	}
	
	
	
	
	/**
	 * 党组织关系转入
	 * @param request
	 * @param response
	 * @param partyForm
	 * @throws Exception
	 */
	@RequestMapping("partyOut")
	@Action(description="添加或更新党组织关系表")
	public void partyOut(HttpServletRequest request, HttpServletResponse response,PartyForm partyForm) throws Exception
	{	String resultMsg=null;	
		ResultMessage message=null;	
		Long personId = RequestUtil.getLong(request, "personId");
		String nationId = RequestUtil.getString(request, "nationId");
		String whcdId = RequestUtil.getString(request, "whcdId");
		partyForm.setPersonId(personId);
		initCreater(partyForm);
		try{
			resultMsg="党组织关系";
			initOutCreater(partyForm);
			PartyDto partyDto 	 = BeanToBean.copyProperties(partyForm, new PartyDto(), false);
			PartyPersonDto partyPersonDto = BeanToBean.copyProperties(partyForm.getPartyPersonForm(), new PartyPersonDto(), false);
			partyPersonDto.setNationId(nationId);
			partyPersonDto.setWhcdId(whcdId);
			partyDto.setPartyPersonDto(partyPersonDto);
			partyService.partyOut(partyDto);
			resultMsg="党组织关系转出";
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
		
	}
	
	
	/**
	 * 取得党组织关系表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/party/partyList.jsp");
		
		return mv;
	}
	
	
	/**
	 * 跳转到党组织关系查询页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("partyPersonList")
	public ModelAndView partyPersonList()  throws Exception{
		ModelAndView mv= new ModelAndView("/business/personagency/party/partyPersonList.jsp");
		return mv;
	}
	/**
	 * 取得党组织关系表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping("partylistJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> partylistJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData<Party> resultData=partyService.getPartyList(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	/**
	 * 适用于综合查询代理详细查询 
	 * 取得党组织关系信息列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("partyvListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> getByvPersonId(HttpServletRequest request,HttpServletResponse response) throws Exception{
		QueryFilter fiter=new QueryFilter(request);
		Long personId = RequestUtil.getLong(request, "personId");
		fiter.addFilter("personId", personId);
		ResultData resultData=partyService.getByvPersonId(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	/**
	 * 根据党员id查询党员缴费信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getByPartyListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> getByPartyList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		QueryFilter fiter=new QueryFilter(request);
		Long partyId = RequestUtil.getLong(request, "partyId");
		ResultData<Party> resultData=partyPayService.getByPartyId(partyId);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	
	
	/**
	 * 初始化进入党组织关系管理页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("search")
	public ModelAndView load(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("/business/personagency/party/searchParty.jsp");
		return mv;
	}
	
	
	/**
	 * 条件查询页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchList")
	@Action(description="查询党组织关系管理")
	public ModelAndView searchList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		
 		Long partyStatus = -1L; 	//党员状态  默认-1   是党组织关系 为 1 不是为0   
 		boolean flag = false;
 		Long personId = RequestUtil.getLong(request, "personId",0L);
 		Long partyId =0L;	//党组织关系id
 		Map partyMap = new HashMap<String,Object>();	//退休map
 		PartyPersonForm partyPersonForm = new PartyPersonForm();	//档案form
 		PartyForm partyForm = new PartyForm();
 		initCreater(partyForm);
 		if(personId!=0L){
 			partyMap =  partyService.getPartyByPersonIds(personId);
 			partyPersonForm =(PartyPersonForm)BeanUtils.populateEntity(partyMap, partyPersonForm);
 			Party party = partyService.findByPartyInto(personId);	//求出转入的状态
 			if(party==null){
 				flag = true;
 			}else{
 				partyId = party.getId();
 			}
 			
 		}
		ModelAndView modelAndView= new ModelAndView("/business/personagency/party/searchPartyList.jsp");
		return modelAndView.addObject("partyPersonForm",partyPersonForm).addObject("partyForm", partyForm).addObject("personId", personId).addObject("partyIds", partyId)
				.addObject("partyStatus", partyStatus).addObject("flag", flag);					
	} 
	
	
	/**
	 * 取得党组织关系表分页列表
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
		ResultData<Party> resultData=partyService.getByPersonIdList(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	
	/**
	 * 查出缴费人员的记录
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getPartyById")
	@Action(description="查出缴费人员的记录")
	@ResponseBody
	public ResultMessage getPartyById(Long id,HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ResultMessage message=null;
		
		Long num = partyPayService.getPartyById(id);
		if(num>0){
			message=new ResultMessage(ResultMessage.Success,"");
		}else{
			message=new ResultMessage(ResultMessage.Fail,"");
		}
		return message;
	}
	
	
	/**
	 * 删除党组织关系表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("delByPersonId")
	@Action(description="删除党组织关系表")
	@ResponseBody
	public ResultMessage delByPersonId(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long personId =RequestUtil.getLong(request, "personId");
			partyService.delByPersonId(personId);
			message=new ResultMessage(ResultMessage.Success, "删除党组织关系表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	
	/**
	 * 删除党组织关系表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除党组织关系表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			partyService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除党组织关系表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	/**
	 * 	新增党组织关系转入
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增党组织关系转入")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		Long personId = RequestUtil.getLong(request, "personId", 0);
		Long partyStatus = RequestUtil.getLong(request, "partyStatus");	//是否代管组织关系
		Long partyId = 0L;	//党员id
		ModelAndView modelAndView = null;
		PartyForm partyForm = new PartyForm();
			Map partyMap = new HashMap<String,Object>();	//退休map
	 		PartyPersonForm partyPersonForm = new PartyPersonForm();	//档案form
	 		initCreater(partyForm);
	 		if(personId!=0L){
	 			partyMap =  partyService.getPartyByPersonIds(personId);
	 			partyPersonForm =(PartyPersonForm)BeanUtils.populateEntity(partyMap, partyPersonForm);
	 			partyForm.setPartyPersonForm(partyPersonForm);
	 			if(partyStatus==0){
	 				partyForm.setPartyDate(null);
		 			partyForm.setPartyPositiveDate(null);
		 			partyForm.setPartyIntoDate(null);
		 			partyForm.setPartyNote(null);
	 			}
	 		}
			modelAndView= new ModelAndView("/business/personagency/party/partyEdit.jsp");
		
	
		return modelAndView.addObject("partyForm",partyForm).addObject("personId", personId).addObject("partyStatus", partyStatus);					
	}
	
	/**
	 * 	党组织关系转出
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("addOut")
	@Action(description="新增党组织关系表")
	public ModelAndView addOut(HttpServletRequest request) throws Exception
	{
		Long personId = RequestUtil.getLong(request, "personId", 0);
		Map partyMap = new HashMap<String,Object>();	//退休map
 		PartyPersonForm partyPersonForm = new PartyPersonForm();	//档案form
 		PartyForm partyForm = new PartyForm();
 		//initCreater(partyForm);
 		if(personId!=0L){
 			partyMap =  partyService.getPartyByPersonIds(personId);
 			Party party = partyService.findByPartyInto(personId);
 			if(party!=null){
 				partyForm = BeanToBean.copyProperties(party, partyForm, false);
 			}
 			initOutCreater(partyForm);
 			partyPersonForm =(PartyPersonForm)BeanUtils.populateEntity(partyMap, partyPersonForm);
 			partyForm.setPartyPersonForm(partyPersonForm);
 		}
		ModelAndView modelAndView= new ModelAndView("/business/personagency/party/partyOutEdit.jsp");
		return modelAndView.addObject("partyForm",partyForm).addObject("personId", personId);					
	}
	
	
	
	
	/**
	 * 	编辑党组织关系表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑党组织关系表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		Party party=partyService.getById(id);
		PartyForm  partyForm=new PartyForm();
		partyForm.putModel(party);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/party/partyEdit.jsp");
		return modelAndView.addObject("partyForm",partyForm);					
	}
	
	
	/**
	 * 转出列表操作
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("editOut")
	@Action(description="编辑党组织关系表")
	public ModelAndView editOut(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		Party party=partyService.getById(id);
		PartyForm  partyForm=new PartyForm();
		partyForm.putModel(party);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/party/partyOutEdit.jsp");
		return modelAndView.addObject("partyForm",partyForm);					
	}

	/**
	 * 取得党组织关系表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看党组织关系表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		Party party = partyService.getById(id);	
		return getAutoView().addObject("party", party);
	}
	
}
