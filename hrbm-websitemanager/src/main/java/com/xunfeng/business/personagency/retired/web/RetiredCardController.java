package com.xunfeng.business.personagency.retired.web;

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
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.personagency.retired.model.RetiredCard;
import com.xunfeng.business.personagency.retired.model.RetiredDeclare;
import com.xunfeng.business.personagency.retired.web.form.RetiredCardForm;
import com.xunfeng.business.personagency.retired.dto.RetiredCardDto;
import com.xunfeng.business.personagency.retired.interf.RetiredCardServiceInterf;
import com.xunfeng.business.personagency.retired.interf.RetiredDeclareServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员领取退休证 控制器类
* @author:zhangfan
* @createDate 2016-08-05 11:14:07 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/retired/card/")
public class RetiredCardController extends BaseController
{
	@Resource
	@Qualifier("retiredCard")
	private RetiredCardServiceInterf retiredCardService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	@Resource
	@Qualifier("retiredDeclare")
	private RetiredDeclareServiceInterf retiredDeclareService;
	
	@Resource
	private PersonBaseInfoServiceInterf personService;	//个人service
	
	
	/**
	 * 添加或更新退休人员领取退休证。
	 * @param request
	 * @param response
	 * @param retiredCardForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新退休人员领取退休证")
	public void save(HttpServletRequest request, HttpServletResponse response,RetiredCardForm retiredCardForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		RetiredCardDto retiredCardDto = BeanToBean.copyProperties(retiredCardForm,new RetiredCardDto(), false);
		try{
			
			if(retiredCardForm.getRetiredDeclareStatus()!=""){
				if(!retiredCardForm.getRetiredDeclareStatus().equals("3")){
					resultMsg = "未申报完毕,不能领取退休证！";
					message=new ResultMessage(ResultMessage.Success, resultMsg);
					writeResultMessage(response.getWriter(),message);
				}else if(retiredCardForm.getRetiredStatus()!=1){
					resultMsg = "未退休，不能领取退休证！";
					message=new ResultMessage(ResultMessage.Success, resultMsg);
					writeResultMessage(response.getWriter(),message);
				}else{
					resultMsg = "领取退休证";
					retiredCardService.saveOrUpdate(retiredCardDto);
					message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
					writeResultMessage(response.getWriter(),message);
				}
			}else{
				resultMsg = "请先选择记录";
				retiredCardService.saveOrUpdate(retiredCardDto);
				message=new ResultMessage(ResultMessage.Success, resultMsg);
				writeResultMessage(response.getWriter(),message);
			}
			
			
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
		

	
	/**
	 * 验证退休编号是否重复
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("isExitCode")
	@Action(description = "查询退休编号")
	@ResponseBody
	public Map getByExitCode(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map map = new HashMap<String, String>();
		try {
			QueryFilter fiter = new QueryFilter(request);
			List<RetiredCard> retiredCard= retiredCardService.getByExitCode(fiter);
			if (retiredCard != null&&retiredCard.size() >0) {
				map.put("valid",false);
			} else {
				map.put("valid",true);
			}
		} catch (Exception ex) {
			map.put("valid",false);
		}		
				
		return map;
	}
	
	
	
	/**
	 * 根据退休申诉id获得养老待遇申请信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getRetiredById")
	@Action(description="领取退休证")
	public ModelAndView getRetiredById(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		Long retiredDeclareId =RequestUtil.getLong(request,"id",0L);
		RetiredCardForm retiredCardForm = new RetiredCardForm();
		
		if(retiredDeclareId!=0L){
			RetiredDeclare  retiredDeclare = retiredDeclareService.getById(retiredDeclareId);
			RetiredCard retiredCard = retiredCardService.getByPersonId(retiredDeclare.getPeopleId());
			PersonBaseInfo personBaseInfo =personService.getById(retiredDeclare.getPeopleId());
			if(retiredCard!=null){
				BeanToBean.copyProperties(retiredCard, retiredCardForm, false);
			}
			retiredCardForm.setRetiredCardDate(new Date());
			retiredCardForm.setRetiredCardName(personBaseInfo.getAac003());
			retiredCardForm.setRetiredDeclareId(retiredDeclareId);
			retiredCardForm.setRetiredDeclareStatus(retiredDeclare.getRetiredDeclareStatus());
			if(retiredDeclare.getRetiredStatus()==null){
				retiredCardForm.setRetiredStatus(0L);
			}else{
				retiredCardForm.setRetiredStatus(retiredDeclare.getRetiredStatus());
			}
		}
		initCreater(retiredCardForm);
		ModelAndView mv = new ModelAndView("/business/personagency/retired/searchRetiredCardList.jsp");
		return mv.addObject("retiredCardForm", retiredCardForm).addObject("retiredDeclareId",retiredDeclareId);
		
	}
	
	
	
	
	/**
	 * 取得退休人员领取退休证分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/retired/retiredCardList.jsp");
		
		return mv;
	}
	
	/**
	 * 退休审批表打印页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("retiredReport")
	public ModelAndView retiredReport(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/retired/retiredReportList.jsp");
		return mv;
	}
	
	
	/**
	 * 取得退休人员领取退休证分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="退休人员领取退休证分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData<RetiredCard> resultData=retiredCardService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	/**
	 * 退休人员查询Json 数据
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("retiredPersonJson")
	@Action(description="退休人员领取退休证分页列表")
	@ResponseBody
	public Map<Object,Object> RetiredPersonList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData resultData=retiredCardService.getRetiredPersonList(fiter);	
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	/**
	 * 退休审批表打印信息 Json 信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("retiredReportJson")
	@Action(description="查看退休审批表打印信息")
	@ResponseBody
	public Map<Object,Object> RetiredReportList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData resultData=retiredCardService.getRetiredReportList(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	
	/**
	 * 删除退休人员领取退休证
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除退休人员领取退休证")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			retiredCardService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除退休人员领取退休证成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	
	
	
	
	/**
	 * 	新增退休人员领取退休证
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增退休人员领取退休证")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		RetiredCardForm  retiredCardForm=new RetiredCardForm();
		retiredCardForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/retiredCardEdit.jsp");
		return modelAndView.addObject("retiredCardForm",retiredCardForm);					
	}
	/**
	 * 	编辑退休人员领取退休证
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑退休人员领取退休证")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		RetiredCard retiredCard=retiredCardService.getById(id);
		RetiredCardForm  retiredCardForm=new RetiredCardForm();
		retiredCardForm.putModel(retiredCard);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/retiredCardEdit.jsp");
		return modelAndView.addObject("retiredCardForm",retiredCardForm);					
	}

	/**
	 * 取得退休人员领取退休证明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看退休人员领取退休证明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		RetiredCard retiredCard = retiredCardService.getById(id);	
		return getAutoView().addObject("retiredCard", retiredCard);
	}
	
}
