package com.xunfeng.business.personagency.params.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.personagency.params.interf.ParamsInsuredFileServiceInterf;
import com.xunfeng.business.personagency.params.model.ParamsInsuredFile;
import com.xunfeng.business.personagency.params.web.form.ParamsInsuredFileForm;
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
* @Description: 参保文件 控制器类
* @author:wanghan
* @createDate 2016-09-07 10:23:40 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/params/paramsInsuredFile/")
public class ParamsInsuredFileController extends BaseController
{
	@Resource
	@Qualifier("paramsInsuredFile")
	private ParamsInsuredFileServiceInterf paramsInsuredFileService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新参保文件。
	 * @param request
	 * @param response
	 * @param paramsInsuredFileForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新参保文件")
	public void save(HttpServletRequest request, HttpServletResponse response,ParamsInsuredFileForm paramsInsuredFileForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long pkId=RequestUtil.getLong(request,"pkId");
		    ParamsInsuredFile paramsInsuredFile = paramsInsuredFileService.getById(pkId);
			paramsInsuredFile=paramsInsuredFileForm.getModel(paramsInsuredFile);
			if(paramsInsuredFileForm.isMvcAdd()){
				resultMsg="添加参保文件";
				paramsInsuredFile.setPkId(uniqueIdUtil.genId(ParamsInsuredFile.class.getName()));
				paramsInsuredFileService.add(paramsInsuredFile);
				
			}else{
				resultMsg="更新参保文件";
			    paramsInsuredFileService.update(paramsInsuredFile);
				
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
	 * 取得参保文件分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/params/paramsInsuredFileList.jsp");
		
		return mv;
	}
	/**
	 * 取得参保文件分页列表
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
		ResultData<ParamsInsuredFile> resultData=paramsInsuredFileService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除参保文件
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除参保文件")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pkId");
			paramsInsuredFileService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除参保文件成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增参保文件
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增参保文件")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		ParamsInsuredFileForm  paramsInsuredFileForm=new ParamsInsuredFileForm();
		paramsInsuredFileForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/params/paramsInsuredFileEdit.jsp");
		
		return modelAndView.addObject("paramsInsuredFileForm",paramsInsuredFileForm);					
	}
	/**
	 * 	编辑参保文件
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑参保文件")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long pkId=RequestUtil.getLong(request,"pkId",0L);
		ParamsInsuredFile paramsInsuredFile=paramsInsuredFileService.getById(pkId);
		ParamsInsuredFileForm  paramsInsuredFileForm=new ParamsInsuredFileForm();
		paramsInsuredFileForm.putModel(paramsInsuredFile);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/params/paramsInsuredFileEdit.jsp");
		return modelAndView.addObject("paramsInsuredFileForm",paramsInsuredFileForm);					
	}

	/**
	 * 取得参保文件明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看参保文件明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long pkId=RequestUtil.getLong(request,"pkId");
		ParamsInsuredFile paramsInsuredFile = paramsInsuredFileService.getById(pkId);	
		return getAutoView().addObject("paramsInsuredFile", paramsInsuredFile);
	}
	
}
