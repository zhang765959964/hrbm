package com.xunfeng.business.personagency.social.web;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.social.model.SocialsecTransfer;
import com.xunfeng.business.personagency.social.web.form.ArchivesPersonMapForm;
import com.xunfeng.business.personagency.social.web.form.ChangeReportingForm;
import com.xunfeng.business.personagency.social.web.form.SocialsecTransferForm;
import com.xunfeng.business.personagency.social.interf.SocialsecTransferServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人社保统筹范围内转移表 控制器类
* @author:jiangxin
* @createDate 2016-08-12 15:39:20 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/social/socialsecTransfer/")
public class SocialsecTransferController extends BaseController
{
	@Resource
	@Qualifier("socialsecTransfer")
	private SocialsecTransferServiceInterf socialsecTransferService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	
	
	/**
	 * 添加或更新个人社保统筹范围内转移表。
	 * @param request
	 * @param response
	 * @param socialsecTransferForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新个人社保统筹范围内转移表")
	public void save(HttpServletRequest request, HttpServletResponse response,SocialsecTransferForm socialsecTransferForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    SocialsecTransfer socialsecTransfer = socialsecTransferService.getById(id);
			socialsecTransfer=socialsecTransferForm.getModel(socialsecTransfer);
			if(socialsecTransferForm.isMvcAdd()){
				resultMsg="添加个人社保统筹范围内转移";
				socialsecTransfer.setId(uniqueIdUtil.genId(SocialsecTransfer.class.getName()));
				socialsecTransferService.addSocialsecTransfer(socialsecTransfer);
			}else{
				resultMsg="更新个人社保统筹范围内转移";
			    socialsecTransferService.updateSocialsecTransfer(socialsecTransfer);
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
	 * 取得个人社保统筹范围内转移表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/social/socialsecTransferList.jsp");
		
		return mv;
	}
	/**
	 * 取得个人社保统筹范围内转移表分页列表
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
		ResultData<SocialsecTransfer> resultData=socialsecTransferService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除个人社保统筹范围内转移表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除个人社保统筹范围内转移表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			socialsecTransferService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除个人社保统筹范围内转移表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增个人社保统筹范围内转移表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增个人社保统筹范围内转移表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		Long archivesId=RequestUtil.getLong(request,"archivesId",0L);
		Map personMap = new HashMap();
		if(archivesId!=0){
			personMap = archivesService.getArchivesPersonByArchivesId(archivesId);
		}	
		ArchivesPersonMapForm apmf = new ArchivesPersonMapForm();
		apmf = (ArchivesPersonMapForm) BeanUtils.populateEntity(personMap, apmf);
		SocialsecTransferForm  socialsecTransferForm = BeanToBean.copyProperties(apmf, new SocialsecTransferForm(), false);
        if(personMap.get("aac006")!=null){
        	socialsecTransferForm.setAac006(this.timestampConversionDate(personMap, "aac006"));
        }
        //赋值经办信息
		SysUser sysUser=ContextUtil.getCurrentUser();
		socialsecTransferForm.setCreaterId(sysUser.getAcd230());
		socialsecTransferForm.setCreaterName(sysUser.getAac003());
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		String s = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date());
		socialsecTransferForm.setCreaterDate(new Date());
		socialsecTransferForm.setCreaterOrgId(sysOrg.getAcd200());
		socialsecTransferForm.setCreaterOrgName(sysOrg.getAcd202());
		socialsecTransferForm.setIsEffective("0");
		socialsecTransferForm.setCcpr08("0");
		socialsecTransferForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/social/socialsecTransferEdit.jsp");
		return modelAndView.addObject("socialsecTransferForm",socialsecTransferForm);					
	}
	/**
	 * 	编辑个人社保统筹范围内转移表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑个人社保统筹范围内转移表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		SocialsecTransfer socialsecTransfer=socialsecTransferService.getById(id);
		SocialsecTransferForm  socialsecTransferForm=new SocialsecTransferForm();
		socialsecTransferForm.putModel(socialsecTransfer);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/social/socialsecTransferEdit.jsp");
		return modelAndView.addObject("socialsecTransferForm",socialsecTransferForm);					
	}
	//查看
	@RequestMapping("look")
	@Action(description="编辑个人社保统筹范围内转移表")
	public ModelAndView look(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		SocialsecTransfer socialsecTransfer=socialsecTransferService.getById(id);
		SocialsecTransferForm  socialsecTransferForm=new SocialsecTransferForm();
		socialsecTransferForm.putModel(socialsecTransfer);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/social/socialsecTransferLook.jsp");
		return modelAndView.addObject("socialsecTransferForm",socialsecTransferForm);					
	}

	/**
	 * 取得个人社保统筹范围内转移表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看个人社保统筹范围内转移表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		SocialsecTransfer socialsecTransfer = socialsecTransferService.getById(id);	
		return getAutoView().addObject("socialsecTransfer", socialsecTransfer);
	}
	public Date timestampConversionDate(Map map,String strName){
		Date date = new Date();
		Class clz =map.get(strName).getClass();  
        Method method;
		try {
			method = clz.getMethod("timestampValue", null);
			try {
				date = (Date) method.invoke(map.get(strName));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return date;
	}
	
}
