package com.xunfeng.business.personagency.storage.web;

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
import com.xunfeng.business.personagency.receive.web.form.ArchivesPersonForm;
import com.xunfeng.business.personagency.storage.model.WageStandard;
import com.xunfeng.business.personagency.storage.web.form.WageStandardForm;
import com.xunfeng.business.personagency.storage.interf.WageStandardServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 工资标准表 控制器类
* @author:jiangxin
* @createDate 2016-08-17 11:06:20 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/storage/wageStandard/")
public class WageStandardController extends BaseController
{
	@Resource
	@Qualifier("wageStandard")
	private WageStandardServiceInterf wageStandardService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	
	
	/**
	 * 添加或更新工资标准表。
	 * @param request
	 * @param response
	 * @param wageStandardForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新工资标准表")
	public void save(HttpServletRequest request, HttpServletResponse response,WageStandardForm wageStandardForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    WageStandard wageStandard = wageStandardService.getById(id);
			wageStandard=wageStandardForm.getModel(wageStandard);
			if(wageStandardForm.isMvcAdd()){
				resultMsg="添加工资标准调整";
				wageStandardService.addWageStandard(wageStandard);
			}else{
				resultMsg="修改工资标准调整";
			    wageStandardService.updateWageStandard(wageStandard);
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "工资标准调整操作失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	/**
	 * 取得工资标准表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/storage/wageStandardList.jsp");
		return mv;
	}
	//工资标准调整查询
	@RequestMapping("search")
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/storage/wageStandardSearch.jsp");
		return mv;
	}
	
	@RequestMapping("resultList")
	@Action(description="编辑社保补贴")
	public ModelAndView resultList(HttpServletRequest request) throws Exception
	{
		
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Map personMap = new HashMap();
		if(personId!=0){
			personMap = archivesService.getArchivesByPersonId(personId);
		}	
		ArchivesPersonForm archivesPersonForm = new ArchivesPersonForm();
		archivesPersonForm = (ArchivesPersonForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/storage/wageStandardResultList.jsp");
			modelAndView.addObject("archivesPersonForm", archivesPersonForm).addObject("personId", personId)
			.addObject("id", archivesPersonForm.getId()==null?"0":archivesPersonForm.getId());
		return modelAndView;					
	}
	
	@RequestMapping("refreshDiv")
	@Action(description="刷新保存后div")
	public ModelAndView refreshDiv(HttpServletRequest request) throws Exception
	{
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Map personMap = new HashMap();
		if(personId!=0){
			personMap = archivesService.getArchivesByPersonId(personId);
		}	
		WageStandardForm  wageStandardForm=new WageStandardForm();
		wageStandardForm.setId(uniqueIdUtil.genId(WageStandard.class.getName()));
		if(!personMap.isEmpty()){
			String str = personMap.get("id")==null?"":personMap.get("id").toString();
			Long archiveId = Long.parseLong(str);
			wageStandardForm.setArchivesId(archiveId);
			wageStandardForm.setAac003(personMap.get("AAC003").toString());
			wageStandardForm.setAac004(personMap.get("aac004")==null?"":personMap.get("aac004").toString());
			wageStandardForm.setAac005(personMap.get("aac005")==null?"":personMap.get("aac005").toString());
			wageStandardForm.setAac011(personMap.get("aac011")==null?"":personMap.get("aac011").toString());
			String straac006 = personMap.get("AAC006")==null?"":personMap.get("AAC006").toString();
			String strexpStartJobDate = personMap.get("expStartJobDate")==null?"":personMap.get("expStartJobDate").toString();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Date aac006 = new Date();
			Date expStartJobDate = new Date();
			if(!"".equals(straac006)){
				try {
					aac006 = sdf.parse(straac006);
				} catch (ParseException e) {
					logger.error(ExceptionUtil.getExceptionMessage(e));
				}
			}
			if(!"".equals(strexpStartJobDate)){
				try {
					expStartJobDate = sdf.parse(strexpStartJobDate);
				} catch (ParseException e) {
					logger.error(ExceptionUtil.getExceptionMessage(e));
				}
			}
			wageStandardForm.setAac006(aac006);
			wageStandardForm.setExpStartJobDate(expStartJobDate);
		}
		initCreater(wageStandardForm);
		wageStandardForm.setCcpr08("0");
		wageStandardForm.setPersonId(personId);
		wageStandardForm.setAdjustDate(new Date());
		ModelAndView modelAndView= new ModelAndView("/business/personagency/storage/wageStandardDiv.jsp");
					 modelAndView.addObject("wageStandardForm",wageStandardForm);
		return modelAndView;					
	}
	
	@RequestMapping("getWageStandard")
	@Action(description="表格中刷新出当前信息")
	public ModelAndView getWageStandard(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		WageStandard wageStandard=wageStandardService.getById(id);
		WageStandardForm  wageStandardForm=new WageStandardForm();
		wageStandardForm.putModel(wageStandard);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/storage/wageStandardDiv.jsp");
					 modelAndView.addObject("wageStandardForm",wageStandardForm);
		return modelAndView;					
	}
	/**
	 * 取得工资标准表分页列表
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
		ResultData<WageStandard> resultData=wageStandardService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除工资标准表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除工资标准表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			wageStandardService.delWageStandardByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除工资标准调整信息成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除工资标准调整信息失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增工资标准表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增工资标准表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		WageStandardForm  wageStandardForm=new WageStandardForm();
		wageStandardForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/storage/wageStandardEdit.jsp");
		
		return modelAndView.addObject("wageStandardForm",wageStandardForm);					
	}
	/**
	 * 	编辑工资标准表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑工资标准表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		WageStandard wageStandard=wageStandardService.getById(id);
		WageStandardForm  wageStandardForm=new WageStandardForm();
		wageStandardForm.putModel(wageStandard);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/storage/wageStandardEdit.jsp");
		return modelAndView.addObject("wageStandardForm",wageStandardForm);					
	}

	/**
	 * 取得工资标准表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看工资标准表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		WageStandard wageStandard = wageStandardService.getById(id);	
		return getAutoView().addObject("wageStandard", wageStandard);
	}
	
}
