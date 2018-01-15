package com.xunfeng.business.personagency.archive.web;

import java.net.URLDecoder;
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
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.archive.web.form.ArchivesForm;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 控制器类
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/archive/archives/")
public class ArchivesController extends BaseController
{
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新人员档案表。
	 * @param request
	 * @param response
	 * @param archivesForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新人员档案表")
	public void save(HttpServletRequest request, HttpServletResponse response,ArchivesForm archivesForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    Archives archives = archivesService.getById(id);
			archives=archivesForm.getModel(archives);
			if(archivesForm.isMvcAdd()){
				resultMsg="添加人员档案表";
				archives.setId(uniqueIdUtil.genId(Archives.class.getName()));
				archivesService.add(archives);
				
			}else{
				resultMsg="更新人员档案表";
			    archivesService.update(archives);
				
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
	 * 取得人员档案表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/archive/archivesList.jsp");
		
		return mv;
	}
	/**
	 * 取得人员档案表分页列表
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
		ResultData  resultData = archivesService.getAllArchives(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());

	}
	//自定义查询  以档案表为主表
	@RequestMapping("searchArchives")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public List searchArchives(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter = new QueryFilter(request);
		if(!"".equals(fiter.getFilters().get("searchValue"))){
			fiter.addFilter("searchValue", "%"+fiter.getFilters().get("searchValue")+"%");
		}
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPagesize(10);
		fiter.setPageBean(pageBean);
		ResultData resultData = archivesService.getAllArchives(fiter);
		return resultData.getDataList();
	}
	//自定义查询  以人员信息表为主表
	@RequestMapping("searchPersonAndArchives")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public List searchPersonAndArchives(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter = new QueryFilter(request);
		if(!"".equals(fiter.getFilters().get("searchValue"))){
			fiter.addFilter("searchValue", "%"+fiter.getFilters().get("searchValue")+"%");
		}
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPagesize(10);
		fiter.setPageBean(pageBean);
		ResultData resultData = archivesService.getAllPersonArchives(fiter);
		return resultData.getDataList();
	}
	
	/**
	 * 删除人员档案表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除人员档案表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			archivesService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除人员档案表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增人员档案表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增人员档案表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		ArchivesForm  archivesForm=new ArchivesForm();
		archivesForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/archive/archivesEdit.jsp");
		
		return modelAndView.addObject("archivesForm",archivesForm);					
	}
	/**
	 * 	编辑人员档案表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑人员档案表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		Archives archives=archivesService.getById(id);
		ArchivesForm  archivesForm=new ArchivesForm();
		archivesForm.putModel(archives);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/archive/archivesEdit.jsp");
		return modelAndView.addObject("archivesForm",archivesForm);					
	}

	/**
	 * 取得人员档案表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看人员档案表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		Archives archives = archivesService.getById(id);	
		return getAutoView().addObject("archives", archives);
	}
	
}
