package com.xunfeng.business.advert.web;

import java.net.URLDecoder;
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

import com.xunfeng.business.advert.interf.AdCategoryServiceInterf;
import com.xunfeng.business.advert.model.AdCategory;
import com.xunfeng.business.advert.web.form.AdCategoryForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告类别表 控制器类
* @author:wangyanyan
* @createDate 2016-03-25 11:33:37 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/advert/adCategory/")
public class AdCategoryController extends BaseController
{
	@Resource
	@Qualifier("adCategory")
	private AdCategoryServiceInterf adCategoryService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新广告类别表。
	 * @param request
	 * @param response
	 * @param adCategoryForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新广告类别表")
	public void save(HttpServletRequest request, HttpServletResponse response,AdCategoryForm adCategoryForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
			
		    Long caac01=RequestUtil.getLong(request,"caac01");
		    AdCategory adCategory = adCategoryService.getById(caac01);
			adCategory=adCategoryForm.getModel(adCategory);
			if(adCategoryForm.isMvcAdd()){
				resultMsg="添加广告类别表";
				adCategory.setCaac01(uniqueIdUtil.genId(AdCategory.class.getName()));
				adCategoryService.add(adCategory);
			}else{
				resultMsg="更新广告类别表";
			    adCategoryService.update(adCategory);
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
	 * 取得广告类别表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=this.getAutoView();
		
		return mv;
	}
	/**
	 * 取得广告类别表分页列表
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
		String caac02 = RequestUtil.getString(request, "caac02");
		if(StringUtil.isNotEmpty(caac02)){
			
			fiter.addFilter("caac02", "%"+URLDecoder.decode(caac02, "UTF-8")+"%");
		}
	    int limit = RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
		ResultData  resultData = adCategoryService.getAllByExcept(fiter);
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	

	/**
	 * 删除广告类别表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除广告类别表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "caac01");
			adCategoryService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除广告类别表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增广告类别表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增广告类别表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		AdCategoryForm  adCategoryForm=new AdCategoryForm();
		adCategoryForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/advert/adCategoryEdit.jsp");
		return modelAndView.addObject("adCategoryForm",adCategoryForm);					
	}
	/**
	 * 	编辑广告类别表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑广告类别表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long caac01=RequestUtil.getLong(request,"caac01",0L);
		AdCategory adCategory=adCategoryService.getById(caac01);
		AdCategoryForm  adCategoryForm=new AdCategoryForm();
		adCategoryForm.putModel(adCategory);
		
		return getAutoView().addObject("adCategoryForm",adCategoryForm);					
	}

	/**
	 * 取得广告类别表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看广告类别表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long caac01=RequestUtil.getLong(request,"caac01");
		AdCategory adCategory = adCategoryService.getById(caac01);	
		return getAutoView().addObject("adCategory", adCategory);
	}
	
	/**
	 * 取得广告分类中名字和标示字段
	 */
	@RequestMapping("nameList")
	@Action(description="查看广告类别表明细")
	@ResponseBody
	public List<Map<String, Object>> nameList(HttpServletRequest request, HttpServletResponse response){
		long flag=RequestUtil.getLong(request, "flag",1l);
		return adCategoryService.getNameListByExcept(flag);
	}
}
