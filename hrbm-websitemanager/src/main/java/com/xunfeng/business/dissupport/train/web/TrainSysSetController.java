package com.xunfeng.business.dissupport.train.web;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.dissupport.train.web.form.TrainSysSetForm;
import com.xunfeng.business.train.interf.TrainSysSetServiceInterf;
import com.xunfeng.business.train.model.TrainSysSet;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训系统设置表 控制器类
* @author:Wang.CS
* @createDate 2016-05-23 09:31:57 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/dissupport/train/trainSysSet/")
public class TrainSysSetController extends BaseController
{
	@Resource
	@Qualifier("trainSysSet")
	private TrainSysSetServiceInterf trainSysSetService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新培训系统设置表。
	 * @param request
	 * @param response
	 * @param trainSysSetForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新培训系统设置表")
	public void save(HttpServletRequest request, HttpServletResponse response,TrainSysSetForm trainSysSetForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long caos01=RequestUtil.getLong(request,"caos01");
		    TrainSysSet trainSysSet = trainSysSetService.getById(caos01);
			trainSysSet=trainSysSetForm.getModel(trainSysSet);
			if(trainSysSetForm.isMvcAdd()){
				resultMsg="添加培训系统设置";
				trainSysSet.setCaos01(uniqueIdUtil.genSeqId(SqeIdName.TrainSysSet.getSeqName()));
				trainSysSet.setCaos05(3l);//参数分类 默认3-通用
				trainSysSet.setAae019(ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAac003());// 经办人
				trainSysSet.setAae020(ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd202());// 经办机构
				trainSysSet.setAae011(ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAcd230()+"");// 经办人代码
				trainSysSet.setAae017(ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd200()+"");// 经办机构代码
				trainSysSet.setAae036(new Date());//经办时间
				trainSysSet.setCczy06(SystemConst.DATA_SOURCE_BS); //数据来源, 18:BS大平台
				trainSysSetService.add(trainSysSet);
			}else{
				resultMsg="更新培训系统设置表";
			    trainSysSetService.update(trainSysSet);
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
	 * 取得培训系统设置表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/dissupport/train/trainSysSetList.jsp");
		return mv;
	}
	/**
	 * 取得培训系统设置表分页列表
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
	    ResultData<TrainSysSet> resultData=trainSysSetService.getAllTrainSysSet(fiter);
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 删除培训系统设置表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除培训系统设置表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "caos01");
			trainSysSetService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除培训系统设置表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增培训系统设置表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增培训系统设置表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		TrainSysSetForm  trainSysSetForm=new TrainSysSetForm();
		trainSysSetForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/train/trainSysSetEdit.jsp");
		
		return modelAndView.addObject("trainSysSetForm",trainSysSetForm);					
	}
	/**
	 * 	编辑培训系统设置表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑培训系统设置表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		ModelAndView mv= new ModelAndView("/business/dissupport/train/trainSysSetEdit.jsp");
		Long caos01=RequestUtil.getLong(request,"caos01",0L);
		TrainSysSet trainSysSet=trainSysSetService.getById(caos01);
		TrainSysSetForm  trainSysSetForm=new TrainSysSetForm();
		trainSysSetForm.putModel(trainSysSet);
		
		return mv.addObject("trainSysSetForm",trainSysSetForm);					
	}

	/**
	 * 取得培训系统设置表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看培训系统设置表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long caos01=RequestUtil.getLong(request,"caos01");
		TrainSysSet trainSysSet = trainSysSetService.getById(caos01);	
		return getAutoView().addObject("trainSysSet", trainSysSet);
	}
	
}
