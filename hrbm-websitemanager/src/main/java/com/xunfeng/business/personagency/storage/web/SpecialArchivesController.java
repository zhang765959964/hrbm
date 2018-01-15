package com.xunfeng.business.personagency.storage.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.storage.model.SpecialArchives;
import com.xunfeng.business.personagency.storage.web.form.SpecialArchivesForm;
import com.xunfeng.business.personagency.storage.interf.SpecialArchivesServiceInterf;
import com.xunfeng.business.personagency.unitagreement.model.UnitAgreement;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 特殊档案表 控制器类
* @author:jiangxin
* @createDate 2016-08-15 14:27:06 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/storage/specialArchives/")
public class SpecialArchivesController extends BaseController
{
	@Resource
	@Qualifier("specialArchives")
	private SpecialArchivesServiceInterf specialArchivesService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新特殊档案表。
	 * @param request
	 * @param response
	 * @param specialArchivesForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新特殊档案表")
	public void save(HttpServletRequest request, HttpServletResponse response,SpecialArchivesForm specialArchivesForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    SpecialArchives specialArchives = specialArchivesService.getById(id);
			specialArchives=specialArchivesForm.getModel(specialArchives);
			if(specialArchivesForm.isMvcAdd()){
				resultMsg="特殊类档案入档";
				specialArchives.setId(uniqueIdUtil.genId(SpecialArchives.class.getName()));
				specialArchives.setCczy06("0");
				specialArchives.setCcpr08("0");
				specialArchives.setPrintNumber(0L);
				specialArchivesService.addSpecialArchives(specialArchives);
			}else{
				resultMsg="特殊类档案转出";
				SysUser sysUser=ContextUtil.getCurrentUser();
				specialArchives.setZcCreaterId(sysUser.getAcd230());
				specialArchives.setZcCreaterName(sysUser.getAac003());
				SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
				specialArchives.setZcCreaterOrgId(sysOrg.getAcd200());
				specialArchives.setZcCreaterOrgName(sysOrg.getAcd202());
				specialArchives.setZcCreaterDate(new Date());
				specialArchives.setSpecialStatus("1");
				specialArchives.setAac002(specialArchives.getAac002().toUpperCase());
			    specialArchivesService.update(specialArchives);
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
	 * 取得特殊档案表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/storage/specialArchivesList.jsp");
		return mv;
	}
	//特殊类档案查询
	@RequestMapping("search")
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/storage/specialArchivesSearch.jsp");
		return mv;
	}
	/**
	 * 取得特殊档案表分页列表
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
		ResultData<SpecialArchives> resultData=specialArchivesService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除特殊档案表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除特殊档案表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			specialArchivesService.deleteSpecialArchives(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除特殊类档案成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增特殊档案表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增特殊档案表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		SpecialArchivesForm  specialArchivesForm=new SpecialArchivesForm();
		SysUser sysUser=ContextUtil.getCurrentUser();
		specialArchivesForm.setLrCreaterId(sysUser.getAcd230());
		specialArchivesForm.setLrCreaterName(sysUser.getAac003());
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		specialArchivesForm.setLrCreaterDate(new Date());
		specialArchivesForm.setLrCreaterOrgId(sysOrg.getAcd200());
		specialArchivesForm.setLrCreaterOrgName(sysOrg.getAcd202());
		specialArchivesForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/storage/specialArchivesEdit.jsp");
		return modelAndView.addObject("specialArchivesForm",specialArchivesForm);					
	}
	/**
	 * 	编辑特殊档案表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑特殊档案表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		SpecialArchives specialArchives=specialArchivesService.getById(id);
		SpecialArchivesForm  specialArchivesForm=new SpecialArchivesForm();
		specialArchivesForm.putModel(specialArchives);
		if(specialArchives!=null && StringUtil.isEmpty(specialArchives.getZcName()) ){
			specialArchivesForm.setZcName(specialArchives.getAac003());
		}
		ModelAndView modelAndView= new ModelAndView("/business/personagency/storage/specialArchivesCheckOut.jsp");
		return modelAndView.addObject("specialArchivesForm",specialArchivesForm);					
	}

	/**
	 * 取得特殊档案表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看特殊档案表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		SpecialArchives specialArchives = specialArchivesService.getById(id);	
		return getAutoView().addObject("specialArchives", specialArchives);
	}
	//根据身份证号验证是不是已经存在该
	@RequestMapping("checkUnid")
	@Action(description = "验证身份证号是不是已经存在")
	@ResponseBody
	public Map checkUnid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map map =new HashMap();
		try{
			//验证身份证号
			String aac002 = RequestUtil.getString(request, "aac002");
			Long id = RequestUtil.getLong(request, "id",0l);
			SpecialArchives specialArchives = specialArchivesService.getSpecialArchivesByUnidAndId(id, aac002);
			if(specialArchives!=null){
				map.put("valid",false);
			}else{
				map.put("valid",true);
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("valid",false);
		}
		return map;
	}
}
