package com.xunfeng.business.personagency.unitagreement.web;

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

import com.xunfeng.business.corp.interf.CorpServiceInter;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.personagency.unitagreement.dto.UnitAgreementDto;
import com.xunfeng.business.personagency.unitagreement.interf.UnitAgreementServiceInterf;
import com.xunfeng.business.personagency.unitagreement.model.UnitAgreement;
import com.xunfeng.business.personagency.unitagreement.web.form.UnitAgreementForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.ZJ_DateUtils;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位协议表 控制器类
* @author:zhangfan
* @createDate 2016-07-06 12:11:01 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/unitagreement/")
public class UnitAgreementController extends BaseController
{
	@Resource
	@Qualifier("unitAgreement")
	private UnitAgreementServiceInterf unitAgreementService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	@Resource
	@Qualifier("corp")
	private CorpServiceInter corpService;

	
	/**
	 * 添加或更新单位协议表
	 * @param request
	 * @param response
	 * @param unitAgreementForm
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新单位协议表")
	public void updates(HttpServletRequest request, HttpServletResponse response,UnitAgreementForm unitAgreementForm) throws Exception{
			String resultMsg="单位协议签订";	
			ResultMessage message=null;	
			try {
				
				UnitAgreementDto unitAgreementDao = BeanToBean.copyProperties(unitAgreementForm, new UnitAgreementDto(), false);
				unitAgreementService.saveOrUpdate(unitAgreementDao);
				if(unitAgreementDao.getUaStatus()!=null){
					 resultMsg="单位协议终止";	
				}
				message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
				writeResultMessage(response.getWriter(),message);
			} catch (Exception e) {
				message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
				logger.error(ExceptionUtil.getExceptionMessage(e));
				writeResultMessage(response.getWriter(),message);
			}
	}
	
	/**
	 * 单位协议修改
	 * @param request
	 * @param response
	 * @param unitAgreementForm
	 * @throws Exception
	 */
	@RequestMapping("update")
	@Action(description="添加或更新单位协议表")
	public void update(HttpServletRequest request, HttpServletResponse response,UnitAgreementForm unitAgreementForm) throws Exception{
			String resultMsg="单位协议更新";	
			ResultMessage message=null;	
			try {
				Long id=RequestUtil.getLong(request,"id");
				UnitAgreement unitAgreement = unitAgreementService.getById(id);	
				unitAgreement=unitAgreementForm.getModel(unitAgreement);
				unitAgreement.setUaUnitId(unitAgreement.getAab001());
				if(unitAgreementForm.getUaStatus()==0){
					unitAgreement.setStopId(null);
					unitAgreement.setStopName(null);
					unitAgreement.setStopOrgId(null);
					unitAgreement.setStopOrgName(null);
					unitAgreement.setStopDatexx(null);
					unitAgreement.setStopDate(null);
					unitAgreement.setUaStopCause(null);
				}
				unitAgreementService.update(unitAgreement);
				message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
				writeResultMessage(response.getWriter(),message);
			} catch (Exception e) {
				message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
				logger.error(ExceptionUtil.getExceptionMessage(e));
				writeResultMessage(response.getWriter(),message);
			}
	}
	
	
	/**
	 * 	编辑单位协议表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑单位协议表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long corpId = RequestUtil.getLong(request,"aab001");
		Long uaStatus = -1l;
		String stopDate = null;
		String stopReason =null;
		
		
		UnitAgreementForm  unitAgreementForm=new UnitAgreementForm();
		Corp corp = corpService.getById(corpId);
		if(corp!=null){
			BeanToBean.copyProperties(corp, unitAgreementForm,false);
		}
		List<UnitAgreement> unitList = unitAgreementService.getByCorpId(corpId);
		if(unitList.size()>0){
			for (UnitAgreement uu : unitList) {
				if(uu!=null){
					if(uu.getAab001()!=null){			//单位id不为null 跳转到协议终止页面
						unitAgreementForm = BeanToBean.copyProperties(uu, unitAgreementForm, false);
						uaStatus = unitAgreementForm.getUaStatus();
						
						if(unitAgreementForm.getStopDate()!=null){
							stopDate = ZJ_DateUtils.date2dateStr(unitAgreementForm.getStopDate());
						}
						stopReason = unitAgreementForm.getUaStopCause();
						ModelAndView modelAndView= new ModelAndView("/business/personagency/unitagreement/unitAgreementEditzz.jsp");
						if(unitAgreementForm.getUaStopCause()==null){
							initDate(unitAgreementForm);
						}
						if(unitAgreementForm.getUaStatus()==1L){
							 initlCreater(unitAgreementForm);
							 modelAndView= new ModelAndView("/business/personagency/unitagreement/unitAgreementEdit.jsp");
						}
						
						return modelAndView.addObject("unitAgreementForm",unitAgreementForm).addObject("uaStatus", uaStatus).
								addObject("stopDate",stopDate).addObject("stopReason", stopReason);	
					}
				}
				ModelAndView modelAndView= new ModelAndView("/business/personagency/unitagreement/unitAgreementEdit.jsp");
				return modelAndView.addObject("unitAgreementForm",unitAgreementForm).addObject("uaStatus", uaStatus);	
			}
		}else{
			initCreater(unitAgreementForm);
		}
		ModelAndView modelAndView= new ModelAndView("/business/personagency/unitagreement/unitAgreementEdit.jsp");
		return modelAndView.addObject("unitAgreementForm",unitAgreementForm).addObject("uaStatus", uaStatus);	
		
	}
	
	
	
	/**
	 * 初始化单位协议终止 经办人 机构  时间
	 * @param unitAgreementForm
	 * @return
	 */
	private  UnitAgreementForm  initDate(UnitAgreementForm  unitAgreementForm){
 		SysUser sysUser=ContextUtil.getCurrentUser();
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		unitAgreementForm.setStopId(sysUser.getAcd230());
		unitAgreementForm.setStopName(sysUser.getAac003());
		unitAgreementForm.setStopOrgId(sysOrg.getAcd200());
		unitAgreementForm.setStopOrgName(sysOrg.getAcd202());
		unitAgreementForm.setStopDatexx(new Date() );
		return unitAgreementForm;
	}
	
	
	/**
	 * 单位协议签订时间 经办人 
	 * @param unitAgreementForm
	 * @return
	 */
	private UnitAgreementForm initlCreater(UnitAgreementForm unitAgreementForm){
		SysUser sysUser=ContextUtil.getCurrentUser();
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		unitAgreementForm.setCreaterId(sysUser.getAcd230());
		unitAgreementForm.setCreaterName(sysUser.getAac003());		
		unitAgreementForm.setCreaterDate(new Date()) ;
		unitAgreementForm.setCreaterOrgId(sysOrg.getAcd200());
		unitAgreementForm.setCreaterOrgName(sysOrg.getAcd202());
		unitAgreementForm.setFdCreaterDate(new Date()) ;
		return unitAgreementForm;
	}
	
	/**
	 * 取得单位协议表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/unitagreement/unitAgreementList.jsp");
		
		return mv;
	}
	/**
	 * 取得单位协议表分页列表
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
		ResultData resultData=unitAgreementService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
		
	}
	
	/**
	 * 查看单位协议列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("unitListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> getUnitAgreementList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData resultData=unitAgreementService.getUnitAgreementList(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
		
	}
	
	
	/**
	 * 取得单位协议表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJsons")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listJsons(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		 QueryFilter fiter=new QueryFilter(request);
		 List<UnitAgreement> list =  unitAgreementService.getAllCorpUnit(fiter);
		 return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	
	
	/**
	 * 删除单位协议表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除单位协议表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			unitAgreementService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除单位协议表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 根据单位协议签状态返回 单位id 单位名称 单位营业号
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getByUnitStatus")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object>  getByUnitStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryFilter fiter=new QueryFilter(request);
		ResultData resultData=unitAgreementService.getByUnitStatus(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
		
	}
	
	/**
	 * 判断单位协议编号 能不能重复
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getByUnitNo")
	@Action(description = "查询单位协议编号")
	@ResponseBody
	public Map getByCardCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map map =new HashMap();
		try{
			//查询退休编号
			String uaNo = RequestUtil.getString(request, "uaNo");
			Long id = RequestUtil.getLong(request, "id",0L);
			Long num =  unitAgreementService.getByUnitNo(uaNo);
			UnitAgreement unitagreement = unitAgreementService.getById(id);
			
			if(id!=0L){
				if((unitagreement.getUaNo().equals(uaNo))){
					if(num>0){
						map.put("valid",true);
					}else{
						map.put("valid",false);
					}
				}else{
					if(num>0){
						map.put("valid",false);
					}else{
						map.put("valid",true);
					}
				}
			}else{
				if(num>0){
					map.put("valid",false);
				}else{
					map.put("valid",true);
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			map.put("valid",false);
		}
		return map;
	}
	
	
	
	
	/**
	 * 	新增单位协议表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增单位协议表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		UnitAgreementForm  unitAgreementForm=new UnitAgreementForm();
		unitAgreementForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/unitagreement/unitAgreementEdit.jsp");
		
		return modelAndView.addObject("unitAgreementForm",unitAgreementForm);					
	}


	@RequestMapping("search")
	@Action(description="查询单位名称页面")
	public ModelAndView search(HttpServletRequest request) throws Exception{
		ModelAndView modelAndView= new ModelAndView("/business/personagency/unitagreement/searchUnit.jsp");
		return modelAndView;
	}
	
	/**
	 * 取得单位协议表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看单位协议表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		UnitAgreement unitAgreement = unitAgreementService.getById(id);	
		return getAutoView().addObject("unitAgreement", unitAgreement);
	}
	
	
	

	
	
	
}
