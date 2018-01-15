package com.xunfeng.business.personagency.archive.web;

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
import com.xunfeng.core.page.PageBean;
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
import com.xunfeng.business.corp.interf.CorpServiceInter;
import com.xunfeng.business.personagency.archive.model.ArchiveLend;
import com.xunfeng.business.personagency.archive.web.form.ArchiveLendForm;
import com.xunfeng.business.personagency.archive.web.form.ArchivesLendPersonForm;
import com.xunfeng.business.personagency.archive.interf.ArchiveLendServiceInterf;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.receive.web.form.CorpUnitAgreementForm;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案调出表 控制器类
* @author:jx
* @createDate 2016-07-12 10:08:56 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/corp/archiveLend/")
public class CorpArchiveLendController extends BaseController
{
	@Resource
	@Qualifier("archiveLend")
	private ArchiveLendServiceInterf archiveLendService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("corp")
	private CorpServiceInter corpService;
	
	
	
	
	/**
	 * 取得档案调出表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/archive/searchCorpArchiveLend.jsp");
		return mv;
	}
	
	
	/**
	 * @param request
	 * @return 返回单位档案批量调出的数据页面
	 * @throws Exception
	 */
	@RequestMapping("resultList")
	@Action(description="企业档案接收结果页面")
	public ModelAndView resultList(HttpServletRequest request) throws Exception
	{
		Long aab001=RequestUtil.getLong(request,"aab001",0L);
		CorpUnitAgreementForm corpUnitAgreementForm = new CorpUnitAgreementForm();
		Map corpMap = new HashMap();
		if(aab001!=0){
			corpMap = corpService.getCorpUnitAgreement(aab001);
		}	
		corpUnitAgreementForm = (CorpUnitAgreementForm) BeanUtils.populateEntity(corpMap, corpUnitAgreementForm);
		SysUser sysUser=ContextUtil.getCurrentUser();
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		ArchiveLendForm  archiveLendForm = new ArchiveLendForm();
		archiveLendForm.setLendCreaterId(sysUser.getAcd230());
		archiveLendForm.setLendCreaterName(sysUser.getAac003());
		archiveLendForm.setLendCreaterDate(new Date());
		archiveLendForm.setLendCreaterOrgId(sysOrg.getAcd200());
		archiveLendForm.setLendCreaterOrgName(sysOrg.getAcd202());
		archiveLendForm.setLendDate(new Date());
		ModelAndView modelAndView= new ModelAndView("/business/personagency/archive/resultCorpArchiveLend.jsp");
		modelAndView.addObject("corpUnitAgreementForm", corpUnitAgreementForm).addObject("aab001", aab001)
								.addObject("uaStatus", corpUnitAgreementForm.getUaStatus()==null?2l:corpUnitAgreementForm.getUaStatus())
								.addObject("archiveLendForm", archiveLendForm);
		return modelAndView;					
	}
	//取得单位下所有可以办理档案调出的数据
	@RequestMapping("listJson")
	@Action(description="取得单位下所有可以办理档案调出的数据")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		PageBean pageBean=new PageBean(request);
		Long aab001=RequestUtil.getLong(request,"aab001"); 
		ResultData<Map> resultData=archivesService.getBatchCorpArchive(pageBean, aab001);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	//单位档案批量调出登记
	@RequestMapping("save")
	@Action(description="单位档案批量调出登记保存")
	public void save(HttpServletRequest request, HttpServletResponse response,ArchiveLendForm archiveLendForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long lendId=RequestUtil.getLong(request,"lendId");
		    ArchiveLend archiveLend = archiveLendService.getById(lendId);
			archiveLend=archiveLendForm.getModel(archiveLend);
			if(archiveLendForm.isMvcAdd()){
				resultMsg="档案调出登记";
				archiveLendService.addBatchLendRegister(archiveLend,archiveLendForm.getArchiveIds());
				message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			}else{
				resultMsg="档案调出登记修改";
			    archiveLendService.update(archiveLend);
			    message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			}
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
}
