package com.xunfeng.business.personagency.erecord.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.personagency.erecord.interf.ErecordCatalogServiceInterf;
import com.xunfeng.business.personagency.erecord.model.ErecordCatalog;
import com.xunfeng.business.personagency.erecord.web.form.ErecordCatalogForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 电子档案目录 控制器类
* @author:wanghan
* @createDate 2016-08-06 11:55:54 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/erecord/erecordCatalog/")
public class ErecordCatalogController extends BaseController
{
	@Resource
	@Qualifier("erecordCatalog")
	private ErecordCatalogServiceInterf erecordCatalogService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新电子档案目录。
	 * @param request
	 * @param response
	 * @param erecordCatalogForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新电子档案目录")
	public void save(HttpServletRequest request, HttpServletResponse response,ErecordCatalogForm erecordCatalogForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    ErecordCatalog erecordCatalog = erecordCatalogService.getById(id);
			erecordCatalog=erecordCatalogForm.getModel(erecordCatalog);
			if(erecordCatalogForm.isMvcAdd()){
				resultMsg="添加电子档案目录";
				erecordCatalog.setId(uniqueIdUtil.genId(ErecordCatalog.class.getName()));
				erecordCatalogService.add(erecordCatalog);
				
			}else{
				resultMsg="更新电子档案目录";
			    erecordCatalogService.update(erecordCatalog);
				
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
	 * 取得电子档案目录分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/erecord/erecordCatalogList.jsp");
		
		return mv;
	}
	/**
	 * 取得电子档案目录分页列表
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
		ResultData<ErecordCatalog> resultData=erecordCatalogService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除电子档案目录
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除电子档案目录")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			erecordCatalogService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除电子档案目录成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增电子档案目录
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增电子档案目录")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		ErecordCatalogForm  erecordCatalogForm=new ErecordCatalogForm();
		erecordCatalogForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/erecord/erecordCatalogEdit.jsp");
		
		return modelAndView.addObject("erecordCatalogForm",erecordCatalogForm);					
	}
	/**
	 * 	编辑电子档案目录
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑电子档案目录")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		ErecordCatalog erecordCatalog=erecordCatalogService.getById(id);
		ErecordCatalogForm  erecordCatalogForm=new ErecordCatalogForm();
		erecordCatalogForm.putModel(erecordCatalog);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/erecord/erecordCatalogEdit.jsp");
		return modelAndView.addObject("erecordCatalogForm",erecordCatalogForm);					
	}

	/**
	 * 取得电子档案目录明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看电子档案目录明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		ErecordCatalog erecordCatalog = erecordCatalogService.getById(id);	
		return getAutoView().addObject("erecordCatalog", erecordCatalog);
	}
	
}
