package com.xunfeng.business.hrtool.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import com.xunfeng.business.hrtool.interf.HRToolModelColServiceInterf;
import com.xunfeng.business.hrtool.model.HRToolModelCol;
import com.xunfeng.business.hrtool.web.form.HRToolModelColForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 工具箱模板栏目 控制器类
* @author:wanghan
* @createDate 2016-03-08 14:20:33 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/hrtool/hRToolModelCol/")
public class HRToolModelColController extends BaseController
{
	@Resource
	@Qualifier("hRToolModelCol")
	private HRToolModelColServiceInterf hRToolModelColService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新工具箱模板栏目。
	 * @param request
	 * @param response
	 * @param hRToolModelColForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新工具箱模板栏目")
	public void save(HttpServletRequest request, HttpServletResponse response,HRToolModelColForm hRToolModelColForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    HRToolModelCol hRToolModelCol = hRToolModelColService.getById(id);
			hRToolModelCol=hRToolModelColForm.getModel(hRToolModelCol);
			if(hRToolModelColForm.isMvcAdd()){
				resultMsg="添加工具箱模板栏目";
				hRToolModelCol.setId(uniqueIdUtil.genId(HRToolModelCol.class.getName()));
				hRToolModelCol.setCreateDate(new Date());
				hRToolModelCol.setCreateUserId(ContextUtil.getCurrentUserId());
				hRToolModelColService.add(hRToolModelCol);
				
			}else{
				resultMsg="更新工具箱模板栏目";
				
				hRToolModelCol.setUpdateDate(new Date());
				hRToolModelCol.setUpdateUserId(ContextUtil.getCurrentUserId());
			    hRToolModelColService.update(hRToolModelCol);
				
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
	 * 取得工具箱模板栏目分页列表
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
	 * 取得工具箱模板栏目分页列表
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
		List<HRToolModelCol> list=hRToolModelColService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除工具箱模板栏目
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除工具箱模板栏目")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			hRToolModelColService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除工具箱模板栏目成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增工具箱模板栏目
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增工具箱模板栏目")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		Long parentId=RequestUtil.getLong(request,"parentId",0L);
		HRToolModelCol hRToolModelCol=hRToolModelColService.getById(parentId);
		HRToolModelColForm  hRToolModelColForm=new HRToolModelColForm();
		hRToolModelColForm.putModel(null);
		if(hRToolModelCol!=null){
			hRToolModelColForm.setParentColName(hRToolModelCol.getName());
			hRToolModelColForm.setParentColId(hRToolModelCol.getId());
		}else{
			hRToolModelColForm.setParentColId(0L);
			hRToolModelColForm.setParentColName("根栏目");
		}
		
		ModelAndView modelAndView= new ModelAndView("/business/hrtool/hRToolModelColEdit.jsp");
		
		return modelAndView.addObject("hRToolModelColForm",hRToolModelColForm);					
	}
	/**
	 * 	编辑工具箱模板栏目
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑工具箱模板栏目")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		HRToolModelCol hRToolModelCol=hRToolModelColService.getById(id);
		HRToolModelCol hRToolModelCol_parent=hRToolModelColService.getById(hRToolModelCol.getParentColId());
		HRToolModelColForm  hRToolModelColForm=new HRToolModelColForm();
		hRToolModelColForm.putModel(hRToolModelCol);
		if(hRToolModelCol_parent!=null){
			hRToolModelColForm.setParentColName(hRToolModelCol_parent.getName());			
		}else{
			hRToolModelColForm.setParentColName("根栏目");
		}
		
		return getAutoView().addObject("hRToolModelColForm",hRToolModelColForm);					
	}

	/**
	 * 取得工具箱模板栏目明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看工具箱模板栏目明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		HRToolModelCol hRToolModelCol = hRToolModelColService.getById(id);	
		return getAutoView().addObject("hRToolModelCol", hRToolModelCol);
	}
	
	/** 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("treeJson")
	@Action(description = "显示栏目树")
	@ResponseBody
	public List treeJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List list = new ArrayList();
		
		Map<Object, Object> rootmap = new HashMap();
		rootmap.put("id", "0");
		rootmap.put("pId", "");
		rootmap.put("name", "栏目");
		rootmap.put("open", true);
		rootmap.put("nodeType", "root");
		list.add(rootmap);
		List<HRToolModelCol> hRToolModelColList = hRToolModelColService.getAll();
		for(HRToolModelCol hRToolModelCol:hRToolModelColList){
			Map<Object, Object> map = new HashMap();
			map.put("id", hRToolModelCol.getId());
			map.put("pId", hRToolModelCol.getParentColId());
			map.put("name", hRToolModelCol.getName());
			map.put("open", false);
			list.add(map);
		}
		return list;

	}
}
