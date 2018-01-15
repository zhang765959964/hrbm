package com.xunfeng.business.personagency.residence.web;

import java.util.Date;
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
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.residence.model.ResidenceMoveOut;
import com.xunfeng.business.personagency.residence.web.form.ResidenceMoveOutForm;
import com.xunfeng.business.personagency.residence.interf.ResidenceMoveOutServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口迁入迁出表 控制器类
* @author:jiangxin
* @createDate 2016-08-27 15:36:07 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/residence/residenceMoveOut/")
public class ResidenceMoveOutController extends BaseController
{
	@Resource
	@Qualifier("residenceMoveOut")
	private ResidenceMoveOutServiceInterf residenceMoveOutService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	
	
	/**
	 * 添加或更新户口迁入迁出表。
	 * @param request
	 * @param response
	 * @param residenceMoveOutForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新户口迁入迁出表")
	public void save(HttpServletRequest request, HttpServletResponse response,ResidenceMoveOutForm residenceMoveOutForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    ResidenceMoveOut residenceMoveOut = residenceMoveOutService.getById(id);
			residenceMoveOut=residenceMoveOutForm.getModel(residenceMoveOut);
			if(residenceMoveOutForm.isMvcAdd()){
				resultMsg="添加户口迁入信息";
				residenceMoveOut.setId(uniqueIdUtil.genId(ResidenceMoveOut.class.getName()));
				residenceMoveOutService.add(residenceMoveOut);
			}else{
				resultMsg="办理户口迁移信息";
			    residenceMoveOutService.update(residenceMoveOut);
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
	 * 取得户口迁入迁出表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/residence/residenceMoveOutList.jsp");
		
		return mv;
	}
	/**
	 * 取得户口迁入迁出表分页列表
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
		//ResultData<ResidenceMoveOut> resultData=residenceMoveOutService.getAllByFilter(fiter);	
		if("9".equals(fiter.getFilters().get("aac004"))){
			fiter.getFilters().remove("aac004");
		}
		fiter.addFilter("ccpr08", 0);
		ResultData resultData=residenceMoveOutService.getAllResidenceMoveOut(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除户口迁入迁出表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除户口迁入迁出表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			residenceMoveOutService.deleteResidenceMoveOutByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除户口迁入迁移信息成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增户口迁入迁出表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增户口迁入迁出表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		Archives archives =	archivesService.getById(id);
		SysUser sysUser=ContextUtil.getCurrentUser();
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		ResidenceMoveOutForm  residenceMoveOutForm=new ResidenceMoveOutForm();
		residenceMoveOutForm.setArchivesId(id);
		residenceMoveOutForm.setPersonId(archives.getPersonId());
		residenceMoveOutForm.setCreaterId(sysUser.getAcd230());
		residenceMoveOutForm.setCreaterName(sysUser.getAac003());
		residenceMoveOutForm.setCreaterOrgId(sysOrg.getAcd200());
		residenceMoveOutForm.setCreaterOrgName(sysOrg.getAcd202());
		residenceMoveOutForm.setCreaterDate(new Date());
		residenceMoveOutForm.setCczy06("16");
		residenceMoveOutForm.setCcpr08("0");
		residenceMoveOutForm.setMoveDate(new Date());
		residenceMoveOutForm.setOpenDate(new Date());
		residenceMoveOutForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/residence/residenceMoveOutAdd.jsp");
		return modelAndView.addObject("residenceMoveOutForm",residenceMoveOutForm);					
	}
	/**
	 * 	编辑户口迁入迁出表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑户口迁入迁出表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		ResidenceMoveOut residenceMoveOut=residenceMoveOutService.getById(id);
		ResidenceMoveOutForm  residenceMoveOutForm = new ResidenceMoveOutForm();
		residenceMoveOutForm.putModel(residenceMoveOut);
		residenceMoveOutForm.setOutDate(new Date());
		ModelAndView modelAndView= new ModelAndView("/business/personagency/residence/residenceMoveOutEdit.jsp");
		return modelAndView.addObject("residenceMoveOutForm",residenceMoveOutForm);					
	}

	/**
	 * 取得户口迁入迁出表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看户口迁入迁出表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		ResidenceMoveOut residenceMoveOut = residenceMoveOutService.getById(id);	
		return getAutoView().addObject("residenceMoveOut", residenceMoveOut);
	}
	
}
