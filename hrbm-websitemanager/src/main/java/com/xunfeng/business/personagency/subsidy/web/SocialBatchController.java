package com.xunfeng.business.personagency.subsidy.web;

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

import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.personagency.subsidy.interf.SocialBatchServiceInterf;
import com.xunfeng.business.personagency.subsidy.interf.SocialCorpDeclareServiceInterf;
import com.xunfeng.business.personagency.subsidy.model.SocialBatch;
import com.xunfeng.business.personagency.subsidy.model.SocialCorpDeclare;
import com.xunfeng.business.personagency.subsidy.web.form.SocialBatchForm;
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
* @Description: 补贴批次 控制器类
* @author:wanghan
* @createDate 2016-07-07 09:45:32 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/subsidy/socialBatch/")
public class SocialBatchController extends BaseController
{
	@Resource
	@Qualifier("socialBatch")
	private SocialBatchServiceInterf socialBatchService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	@Resource
	@Qualifier("socialCorpDeclare")
	private SocialCorpDeclareServiceInterf socialCorpDeclareService;
	
	
	/**
	 * 添加或更新补贴批次。
	 * @param request
	 * @param response
	 * @param socialBatchForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新补贴批次")
	public void save(HttpServletRequest request, HttpServletResponse response,SocialBatchForm socialBatchForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    SocialBatch socialBatch = socialBatchService.getById(id);
			socialBatch=socialBatchForm.getModel(socialBatch);
			if(socialBatchForm.isMvcAdd()){
				resultMsg="添加补贴批次";
				socialBatch.setId(uniqueIdUtil.genId(SocialBatch.class.getName()));
				socialBatchService.add(socialBatch);
				
			}else{
				resultMsg="更新补贴批次";
				SocialCorpDeclare socialCorpDeclare=socialCorpDeclareService.getByBatchId(socialBatch.getId());
				
				if(socialCorpDeclare!=null){
					message=new ResultMessage(ResultMessage.Success, "批次已提交，不能修改!");
					writeResultMessage(response.getWriter(),message);
					return;
				}
			    socialBatchService.update(socialBatch);
				
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");

			writeResultMessage(response.getWriter(),message);
		}catch(RuntimeException ex){
			message=new ResultMessage(ResultMessage.Fail, ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
		catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	/**
	 * 取得补贴批次分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/subsidy/socialBatchList.jsp");
		
		return mv;
	}
	/**
	 * 取得补贴批次分页列表
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
		ResultData<SocialBatch> resultData=socialBatchService.getAllByFilter(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除补贴批次
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除补贴批次")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long batchId =RequestUtil.getLong(request, "id");
			
			SocialCorpDeclare socialCorpDeclare=socialCorpDeclareService.getByBatchId(batchId);
			
			if(socialCorpDeclare!=null){
				message=new ResultMessage(ResultMessage.Success, "批次已提交，不能删除!");
				 return message;
			}
			socialBatchService.delById(batchId);
			message=new ResultMessage(ResultMessage.Success, "删除补贴批次成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 删除社保补贴
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("delBatchPerson")
	@Action(description="删除批次人员")
	@ResponseBody
	public ResultMessage delBatchPerson(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long batchId =RequestUtil.getLong(request, "batchId",0);
			Long subsidyId =RequestUtil.getLong(request, "subsidyId",0);
			socialBatchService.delBatchPerson(batchId, subsidyId);
			message=new ResultMessage(ResultMessage.Success, "删除社保补贴批次人员成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除社保补贴批次人员失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	
	/**
	 * 取得社保补贴分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addList")
	public ModelAndView addList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		Long batchId =RequestUtil.getLong(request, "batchId",0);
		Long corpDeclareId =RequestUtil.getLong(request, "corpDeclareId",0);
		ModelAndView mv= new ModelAndView("/business/personagency/subsidy/addSocialSubsidyList.jsp");
		mv.addObject("batchId", batchId);
		mv.addObject("corpDeclareId", corpDeclareId);
		
		return mv;
		
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("addBatchPerson")
	@Action(description="添加批次人员")
	@ResponseBody
	public ResultMessage addBatchPerson(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long batchId =RequestUtil.getLong(request, "batchId",0);
			Long subsidyId =RequestUtil.getLong(request, "subsidyId",0);
			socialBatchService.addBatchPerson(batchId, subsidyId);
			message=new ResultMessage(ResultMessage.Success, "添加社保补贴批次人员成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "添加社保补贴批次人员失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增补贴批次
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增补贴批次")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		SocialBatchForm  socialBatchForm=new SocialBatchForm();
		socialBatchForm.putModel(null);
		initCreater(socialBatchForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/subsidy/socialBatchEdit.jsp");
		
		return modelAndView.addObject("socialBatchForm",socialBatchForm);					
	}
	/**
	 * 	编辑补贴批次
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑补贴批次")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		SocialBatch socialBatch=socialBatchService.getById(id);
		SocialBatchForm  socialBatchForm=new SocialBatchForm();
		socialBatchForm.putModel(socialBatch);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/subsidy/socialBatchEdit.jsp");
		return modelAndView.addObject("socialBatchForm",socialBatchForm);					
	}

	/**
	 * 取得补贴批次明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看补贴批次明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		SocialBatch socialBatch = socialBatchService.getById(id);	
		return getAutoView().addObject("socialBatch", socialBatch);
	}
	
	@RequestMapping("isBatchExist")
	@Action(description = "判断身份证号是否存在")
	@ResponseBody
	public Map isPersonExist(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map map=new HashMap();
		try {
			Long noId=RequestUtil.getLong(request,"id");
			String batchName=RequestUtil.getString(request,"batchName");
			boolean flag=socialBatchService.isBatchNameExist(batchName, noId);
			if (flag) {
				map.put("valid",false);
			} else {
				map.put("valid",true);
			}
		} catch (Exception ex) {
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			
			map.put("valid",false);
		}
		return map;
	}
}
