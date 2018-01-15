package com.xunfeng.business.personagency.residence.web;

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

import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.web.form.ArchiveCheckoutForm;
import com.xunfeng.business.personagency.receive.web.form.ArchivesPersonForm;
import com.xunfeng.business.personagency.residence.interf.ResidenceMoveOutServiceInterf;
import com.xunfeng.business.personagency.residence.interf.ResidenceServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口材料表 控制器类
* @author:jiangxin
* @createDate 2016-08-26 11:46:18 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/residence/total/")
public class ResidenceTotalController extends BaseController
{
	@Resource
	@Qualifier("residence")
	private ResidenceServiceInterf residenceService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("residenceMoveOut")
	private ResidenceMoveOutServiceInterf residenceMoveOutService;
	
	
	//户口信息登记
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/residence/searchTotalResidenceList.jsp");
		return mv;
	}
	
	//户口信息登记
	@RequestMapping("resultList")
	@Action(description="户口信息登记")
	public ModelAndView resultList(HttpServletRequest request) throws Exception
	{
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Map personMap = new HashMap();
		if(personId!=0){
			personMap = archivesService.getArchivesByPersonId(personId);
		}	
		ArchivesPersonForm archivesPersonForm = new ArchivesPersonForm();
		archivesPersonForm = (ArchivesPersonForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/residence/resultTotalResidenceList.jsp");
			modelAndView.addObject("archivesPersonForm", archivesPersonForm).addObject("personId", personId)
			.addObject("id", archivesPersonForm.getId()==null?"0":archivesPersonForm.getId());
		return modelAndView;					
	}
	//户口信息查询
	@RequestMapping("search")
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/residence/totalResidenceSearch.jsp");
		Long tatalCount = residenceMoveOutService.getTotalResidenceMoveOut("0");
		Long moveCount = residenceMoveOutService.getTotalResidenceMoveOut("1");
		Long ontCount = residenceMoveOutService.getTotalResidenceMoveOut("2");
		mv.addObject("tatalCount", tatalCount).addObject("moveCount", moveCount).addObject("ontCount", ontCount);
		return mv;
	}
	
	//及时刷新户口迁入和迁移总数条数
	@RequestMapping("searchResidenceCount")
	@Action(description="刷新户口迁入和迁移总数条数")
	public ModelAndView searchResidenceCount(HttpServletRequest request) throws Exception
	{
		ModelAndView mv= new ModelAndView("/business/personagency/residence/searchCount.jsp");
		Long tatalCount = residenceMoveOutService.getTotalResidenceMoveOut("0");
		Long moveCount = residenceMoveOutService.getTotalResidenceMoveOut("1");
		Long ontCount = residenceMoveOutService.getTotalResidenceMoveOut("2");
		mv.addObject("tatalCount", tatalCount).addObject("moveCount", moveCount).addObject("ontCount", ontCount);	
		return 	mv;		
	}
}
