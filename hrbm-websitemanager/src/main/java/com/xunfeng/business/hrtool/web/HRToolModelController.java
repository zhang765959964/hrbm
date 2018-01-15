package com.xunfeng.business.hrtool.web;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
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
import com.xunfeng.business.hrtool.interf.HRToolModelServiceInterf;
import com.xunfeng.business.hrtool.model.HRToolModel;
import com.xunfeng.business.hrtool.model.HRToolModelCol;
import com.xunfeng.business.hrtool.web.form.HRToolModelForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.FileWebDavUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.file.web.FileUploadController;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: hr工具箱模板 控制器类
* @author:wanghan
* @createDate 2016-03-08 17:26:01 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/hrtool/hRToolModel/")
public class HRToolModelController extends FileUploadController
{
	@Resource
	@Qualifier("hRToolModel")
	private HRToolModelServiceInterf hRToolModelService;
	@Resource
	@Qualifier("hRToolModelCol")
	private HRToolModelColServiceInterf hRToolModelColService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新hr工具箱模板。
	 * @param request
	 * @param response
	 * @param hRToolModelForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新hr工具箱模板")
	public void save(HttpServletRequest request, HttpServletResponse response,HRToolModelForm hRToolModelForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    HRToolModel hRToolModel = hRToolModelService.getById(id);
			hRToolModel=hRToolModelForm.getModel(hRToolModel);
			if(hRToolModelForm.isMvcAdd()){
				resultMsg="添加hr工具箱模板";
				hRToolModel.setId(uniqueIdUtil.genId(HRToolModel.class.getName()));
				hRToolModel.setCreateDate(new Date());
				hRToolModel.setCreateUserId(ContextUtil.getCurrentUserId());
				hRToolModelService.add(hRToolModel);
				
			}else{
				resultMsg="更新hr工具箱模板";
				hRToolModel.setUpdateDate(new Date());
				hRToolModel.setUpdateUserId(ContextUtil.getCurrentUserId());
			    hRToolModelService.update(hRToolModel);
				
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
	 * 取得hr工具箱模板分页列表
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
	 * 取得hr工具箱模板分页列表
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
	    int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
		ResultData<HRToolModel> resultData=hRToolModelService.getAllHRToolModel(fiter);
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 删除hr工具箱模板
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除hr工具箱模板")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			hRToolModelService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除hr工具箱模板成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增hr工具箱模板
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增hr工具箱模板")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		Long colId=RequestUtil.getLong(request,"colId",0L);
		HRToolModelCol hRToolModelCol=hRToolModelColService.getById(colId);
		HRToolModelForm  hRToolModelForm=new HRToolModelForm();
		hRToolModelForm.putModel(null);
		if(hRToolModelCol!=null){
			hRToolModelForm.setColName(hRToolModelCol.getName());
			hRToolModelForm.setColId(hRToolModelCol.getId());
		}
		ModelAndView modelAndView= new ModelAndView("/business/hrtool/hRToolModelEdit.jsp");
		
		return modelAndView.addObject("hRToolModelForm",hRToolModelForm);					
	}
	/**
	 * 	编辑hr工具箱模板
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑hr工具箱模板")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		HRToolModel hRToolModel=hRToolModelService.getById(id);
		HRToolModelCol hRToolModelCol=hRToolModelColService.getById(hRToolModel.getColId());
		HRToolModelForm  hRToolModelForm=new HRToolModelForm();
		hRToolModelForm.putModel(hRToolModel);
		if(hRToolModelCol!=null){
			hRToolModelForm.setColName(hRToolModelCol.getName());
			hRToolModelForm.setColId(hRToolModelCol.getId());
		}
		return getAutoView().addObject("hRToolModelForm",hRToolModelForm);					
	}

	/**
	 * 取得hr工具箱模板明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看hr工具箱模板明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		HRToolModel hRToolModel = hRToolModelService.getById(id);	
		return getAutoView().addObject("hRToolModel", hRToolModel);
	}
	@Override
	protected String getPrefixFilePath() {
		long userId = ContextUtil.getCurrentUserId(); // 获取当前用户的id
		return "hr"+File.separator+userId;
	}
	
	@Override
	protected  String uploadFile(String fileName, InputStream fis){
		
		  String filePath=FileWebDavUtil.uploadFile(14L, fileName, fis);
          return filePath;
	}
	
}
