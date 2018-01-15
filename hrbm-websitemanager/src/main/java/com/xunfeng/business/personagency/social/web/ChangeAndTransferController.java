package com.xunfeng.business.personagency.social.web;

import java.util.Date;
import java.util.HashMap;
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
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.receive.web.form.ArchivesPersonForm;
import com.xunfeng.business.personagency.social.model.ChangeReporting;
import com.xunfeng.business.personagency.social.interf.ChangeReportingServiceInterf;
import com.xunfeng.business.personagency.storage.web.form.StorageArchivesPersonForm;
import com.xunfeng.business.personagency.storage.web.form.StorageArchivesSaveForm;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人社保变更申报记录表 控制器类
* @author:jiangxin
* @createDate 2016-08-11 09:36:03 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/social/changeAndTransfer/")
public class ChangeAndTransferController extends BaseController
{
	@Resource
	@Qualifier("changeReporting")
	private ChangeReportingServiceInterf changeReportingService;
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	
	
	
	
	/**
	 * 取得个人社保变更申报记录表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/social/searchChangeAndTransfer.jsp");
		return mv;
	}
	/**
	 * 取得个人社保变更申报记录表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("resultList")
	@Action(description="社保关系转接页面")
	public ModelAndView resultList(HttpServletRequest request) throws Exception
	{
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Map personMap = new HashMap();
		if(personId!=0){
			personMap = archivesService.getArchivesByPersonId(personId);
		}	
		ArchivesPersonForm archivesPersonForm = new ArchivesPersonForm();
		archivesPersonForm = (ArchivesPersonForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/social/resultChangeAndTransfer.jsp");
		modelAndView.addObject("archivesPersonForm", archivesPersonForm).addObject("personId", personId)
			.addObject("id", archivesPersonForm.getId()==null?"0":archivesPersonForm.getId())
			.addObject("archiveFlowStatus", archivesPersonForm.getArchiveFlowStatus()==null?"0":archivesPersonForm.getArchiveFlowStatus());				
		return modelAndView;
	}
	//社保关系管理综合查询
	@RequestMapping("search")
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/social/changeAndTransferSearch.jsp");
		return mv;
	}
}
