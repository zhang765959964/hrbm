package com.xunfeng.business.personagency.receive.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.interf.PersonEducationServiceInterf;
import com.xunfeng.business.person.interf.PersonFamilyServiceInterf;
import com.xunfeng.business.person.interf.PersonWorkExpceServiceInterf;
import com.xunfeng.business.person.model.PersonWorkExpce;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.receive.dto.GongZuoDto;
import com.xunfeng.business.personagency.receive.dto.JiaTingDto;
import com.xunfeng.business.personagency.receive.dto.JiaoYuDto;
import com.xunfeng.business.personagency.receive.dto.PersonBaseDto;
import com.xunfeng.business.personagency.receive.dto.ReceiveArchivesPersonDto;
import com.xunfeng.business.personagency.receive.interf.CorpPersonServiceInterf;
import com.xunfeng.business.personagency.receive.interf.ReceiveArchivesServiceInterf;
import com.xunfeng.business.personagency.receive.web.form.CorpUnitAgreementForm;
import com.xunfeng.business.personagency.receive.web.form.GongZuoForm;
import com.xunfeng.business.personagency.receive.web.form.JiaTingForm;
import com.xunfeng.business.personagency.receive.web.form.JiaoYuForm;
import com.xunfeng.business.personagency.receive.web.form.PersonBaseForm;
import com.xunfeng.business.personagency.receive.web.form.ReceiveArchivesPersonForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author jx
* @createDate 2016年7月14日
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/corp/receive/")
public class CorpReceiveArchivesController extends BaseController
{
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;
	@Resource
	@Qualifier("personWorkExpce")
	private PersonWorkExpceServiceInterf personWorkExpceService;
	@Resource
	@Qualifier("personFamily")
	private PersonFamilyServiceInterf personFamilyService;
	@Resource
	@Qualifier("personEducation")
	private PersonEducationServiceInterf personEducationService;
	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf personBaseInfoService;
	@Resource
	@Qualifier("receiveArchives")
	private ReceiveArchivesServiceInterf receiveArchivesService;
	@Resource
	@Qualifier("corp")
	private CorpServiceInter corpService;
	@Resource
	@Qualifier("corpPerson")
	private CorpPersonServiceInterf CorpPersonService;
	
	/**
	 * 取得人员档案表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/receive/searchCorpReceiveArchives.jsp");
		return mv;
	}
	/**
	 * 取得单位下所有的档案信息
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
		ResultData resultData= archivesService.getCorpAllArchive(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * @param request
	 * @return 返回个人档案接收后的数据页面
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
		String s = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Long archiveCount = CorpPersonService.getArchivesCountByCorpId(Long.toString(aab001));
		ModelAndView modelAndView= new ModelAndView("/business/personagency/receive/resultCorpReceiveArchives.jsp");
		modelAndView.addObject("corpUnitAgreementForm", corpUnitAgreementForm).addObject("aab001", aab001).addObject("uaStatus", corpUnitAgreementForm.getUaStatus()==null?2l:corpUnitAgreementForm.getUaStatus())
								.addObject("archiveReceiveOrgName", sysOrg.getAcd202()).addObject("archiveReceiveDate",s)
								.addObject("archiveReceiveName", sysUser.getAac003()).addObject("archiveCount", archiveCount);
		return modelAndView;					
	}
	
	//单位下个人档案数
	@RequestMapping("refreshArchiveCount")
	@Action(description="刷新单位下个人档案数")
	public ModelAndView refreshArchiveCount(HttpServletRequest request) throws Exception
	{	
		Long aab001=RequestUtil.getLong(request,"aab001",0L);
		Long archiveCount = CorpPersonService.getArchivesCountByCorpId(Long.toString(aab001));
		ModelAndView mv= new ModelAndView("/business/personagency/receive/corpArchiveCount.jsp");
		mv.addObject("archiveCount", archiveCount);
		return mv;
	}
	
	/**
	 * @param request
	 * @return 返回个人档案接收后的数据页面
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="企业下新增档案接收页面")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Long aab001=RequestUtil.getLong(request,"aab001",0L);
		ModelAndView mv= new ModelAndView("/business/personagency/receive/addCorpSearchReceiveArchives.jsp");
		return mv.addObject("personId", personId).addObject("aab001", aab001);				
	}
	/**
	 * @param request
	 * @return 返回个人档案接收后的数据页面
	 * @throws Exception
	 */
	@RequestMapping("corpResultList")
	@Action(description="档案接收页面")
	public ModelAndView corpResultList(HttpServletRequest request) throws Exception
	{
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Long aab001=RequestUtil.getLong(request,"aab001",0L);
		Long type=RequestUtil.getLong(request,"type",0L);
		ReceiveArchivesPersonForm receiveArchivesPersonForm = new ReceiveArchivesPersonForm();
		receiveArchivesPersonForm.setType(type);
		receiveArchivesPersonForm.setAab001(aab001);
		PersonBaseForm personBaseForm = new PersonBaseForm();
		GongZuoForm gongZuoForm = new GongZuoForm();
		JiaTingForm jiaTingForm=new JiaTingForm();
		JiaoYuForm jiaoYuForm = new JiaoYuForm();
		Map personMap = new HashMap();
		Map archivesMap = new HashMap();
		Map gongZuoMap = new HashMap();
		Map jiaTingMap = new HashMap();
		Map jiaoYuMap = new HashMap();
		if(personId!=0){
			personMap = personBaseInfoService.getReceivePersonByPersonId(personId);
			archivesMap = archivesService.getReceiveArchivesByPersonId(personId);
			gongZuoMap = personWorkExpceService.getPersonWorkExpceByPersonId(personId);
			jiaTingMap = personFamilyService.getPersonFamilyPersonId(personId);
			jiaoYuMap = personEducationService.getPersonEducationByPersonId(personId);
			List<PersonWorkExpce> peList = personWorkExpceService.getPersonWorkExpceList(personId);
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
			//得到主要工作经历
			StringBuffer stringBuffer = new StringBuffer("");
			for (Iterator iterator = peList.iterator(); iterator.hasNext();) {
				PersonWorkExpce personWorkExpce = (PersonWorkExpce) iterator.next();
				if(personWorkExpce.getAae030()!=null && personWorkExpce.getAae031()!=null){
					stringBuffer.append(dateFormater.format(personWorkExpce.getAae030())+"至"+dateFormater.format(personWorkExpce.getAae031()));
					if(personWorkExpce.getAac045()==null){
						stringBuffer.append("  没有填写工作单位！");		
					}else{
						stringBuffer.append("  在"+personWorkExpce.getAac045());		
					}
					if(personWorkExpce.getAac0b3()==null){
						stringBuffer.append("  没有填写岗位!  ");		
					}else{
						stringBuffer.append("  职位是"+personWorkExpce.getAac0b3()+"  ");		
					}
				}else{
					String str = "";
					if(StringUtil.isEmpty(personWorkExpce.getAac045()) || "未知".equals(personWorkExpce.getAac045())){
						str = "当前没有填写具体的工作时间,和工作单位  ";
					}else{
						str = "当前没有填写具体的工作时间,在"+personWorkExpce.getAac045();
					}
					if(StringUtil.isEmpty(personWorkExpce.getAac0b3())){
						str += "  没有填写岗位";
					}else{
						str += "  职位是"+personWorkExpce.getAac0b3()+"  ";
					}
					stringBuffer.append(str);
				}
			}
			gongZuoForm.setMainWork(stringBuffer.toString());
		}	
		personBaseForm = (PersonBaseForm) BeanUtils.populateEntity(personMap, personBaseForm);
		gongZuoForm = (GongZuoForm) BeanUtils.populateEntity(gongZuoMap, gongZuoForm);
		if("未知".equals(gongZuoForm.getAac045())){
			gongZuoForm.setAac045("");
    	}
		jiaTingForm = (JiaTingForm) BeanUtils.populateEntity(jiaTingMap, jiaTingForm);
		jiaoYuForm = (JiaoYuForm) BeanUtils.populateEntity(jiaoYuMap, jiaoYuForm);
		if("未知".equals(jiaoYuForm.getAac045())){
			jiaoYuForm.setAac045("");
		}
		receiveArchivesPersonForm.setPersonBaseForm(personBaseForm);
		receiveArchivesPersonForm.setGongZuoForm(gongZuoForm);
		receiveArchivesPersonForm.setJiaTingForm(jiaTingForm);
		receiveArchivesPersonForm.setJiaoYuForm(jiaoYuForm);
		receiveArchivesPersonForm = (ReceiveArchivesPersonForm) BeanUtils.populateEntity(archivesMap, receiveArchivesPersonForm);
		String s = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date());
		SysUser sysUser=ContextUtil.getCurrentUser();
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		if(receiveArchivesPersonForm.getId()==null){
			//赋值经办信息
			receiveArchivesPersonForm.setArchiveReceiveUserid(sysUser.getAcd230());
			receiveArchivesPersonForm.setArchiveReceiveName(sysUser.getAac003());
			receiveArchivesPersonForm.setArchiveReceiveDate(s);
			receiveArchivesPersonForm.setArchiveReceiveOrgId(sysOrg.getAcd200());
			receiveArchivesPersonForm.setArchiveReceiveOrgName(sysOrg.getAcd202());
			receiveArchivesPersonForm.setReceiveDate(s);
		}else{
			if(type==2){
				//档案调出后    -》再次接收档案
				receiveArchivesPersonForm.setArchiveType(null);
				receiveArchivesPersonForm.setArchiveCode(null);
				receiveArchivesPersonForm.setArchiveReceiveUserid(sysUser.getAcd230());
				receiveArchivesPersonForm.setArchiveReceiveName(sysUser.getAac003());
				receiveArchivesPersonForm.setArchiveReceiveDate(s);
				receiveArchivesPersonForm.setArchiveReceiveOrgId(sysOrg.getAcd200());
				receiveArchivesPersonForm.setArchiveReceiveOrgName(sysOrg.getAcd202());
				receiveArchivesPersonForm.setReceiveDate(s);
			}
		}
		ModelAndView modelAndView= new ModelAndView("/business/personagency/receive/addCorpReceiveArchives.jsp");
		modelAndView.addObject("receiveArchivesPersonForm", receiveArchivesPersonForm).addObject("personId", personId)
			.addObject("archiveId", receiveArchivesPersonForm.getId()==null?0l:receiveArchivesPersonForm.getId()).addObject("aab001", aab001);
		return modelAndView;					
	}
	/**
	 * @param request
	 * @return 返回个人档案接收后的数据页面
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="企业下修改档案接收页面")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Long aab001=RequestUtil.getLong(request,"aab001",0L);
		ReceiveArchivesPersonForm receiveArchivesPersonForm = new ReceiveArchivesPersonForm();
		receiveArchivesPersonForm.setAab001(aab001);
		PersonBaseForm personBaseForm = new PersonBaseForm();
		GongZuoForm gongZuoForm = new GongZuoForm();
		JiaTingForm jiaTingForm=new JiaTingForm();
		JiaoYuForm jiaoYuForm = new JiaoYuForm();
		Map personMap = new HashMap();
		Map archivesMap = new HashMap();
		Map gongZuoMap = new HashMap();
		Map jiaTingMap = new HashMap();
		Map jiaoYuMap = new HashMap();
		if(personId!=0){
			personMap = personBaseInfoService.getReceivePersonByPersonId(personId);
			archivesMap = archivesService.getReceiveArchivesByPersonId(personId);
			gongZuoMap = personWorkExpceService.getPersonWorkExpceByPersonId(personId);
			jiaTingMap = personFamilyService.getPersonFamilyPersonId(personId);
			jiaoYuMap = personEducationService.getPersonEducationByPersonId(personId);
			List<PersonWorkExpce> peList = personWorkExpceService.getPersonWorkExpceList(personId);
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
			//得到主要工作经历
			StringBuffer stringBuffer = new StringBuffer("");
			for (Iterator iterator = peList.iterator(); iterator.hasNext();) {
				PersonWorkExpce personWorkExpce = (PersonWorkExpce) iterator.next();
				if(personWorkExpce.getAae030()!=null && personWorkExpce.getAae031()!=null){
					stringBuffer.append(dateFormater.format(personWorkExpce.getAae030())+"至"+dateFormater.format(personWorkExpce.getAae031()));
					if(personWorkExpce.getAac045()==null){
						stringBuffer.append("  没有填写工作单位！");		
					}else{
						stringBuffer.append("  在"+personWorkExpce.getAac045());		
					}
					if(personWorkExpce.getAac0b3()==null){
						stringBuffer.append("  没有填写岗位!  ");		
					}else{
						stringBuffer.append("  职位是"+personWorkExpce.getAac0b3()+"  ");		
					}
				}else{
					String str = "";
					if(StringUtil.isEmpty(personWorkExpce.getAac045()) || "未知".equals(personWorkExpce.getAac045())){
						str = "当前没有填写具体的工作时间,和工作单位  ";
					}else{
						str = "当前没有填写具体的工作时间,在"+personWorkExpce.getAac045();
					}
					if(StringUtil.isEmpty(personWorkExpce.getAac0b3())){
						str += "  没有填写岗位";
					}else{
						str += "  职位是"+personWorkExpce.getAac0b3()+"  ";
					}
					stringBuffer.append(str);
				}
			}
			gongZuoForm.setMainWork(stringBuffer.toString());
		}	
		personBaseForm = (PersonBaseForm) BeanUtils.populateEntity(personMap, personBaseForm);
		gongZuoForm = (GongZuoForm) BeanUtils.populateEntity(gongZuoMap, gongZuoForm);
		if("未知".equals(gongZuoForm.getAac045())){
			gongZuoForm.setAac045("");
    	}
		jiaTingForm = (JiaTingForm) BeanUtils.populateEntity(jiaTingMap, jiaTingForm);
		jiaoYuForm = (JiaoYuForm) BeanUtils.populateEntity(jiaoYuMap, jiaoYuForm);
		if("未知".equals(jiaoYuForm.getAac045())){
			jiaoYuForm.setAac045("");
		}
		receiveArchivesPersonForm.setPersonBaseForm(personBaseForm);
		receiveArchivesPersonForm.setGongZuoForm(gongZuoForm);
		receiveArchivesPersonForm.setJiaTingForm(jiaTingForm);
		receiveArchivesPersonForm.setJiaoYuForm(jiaoYuForm);
		receiveArchivesPersonForm = (ReceiveArchivesPersonForm) BeanUtils.populateEntity(archivesMap, receiveArchivesPersonForm);
		String s = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date());
		if(receiveArchivesPersonForm.getId()==null){
			//赋值经办信息
			SysUser sysUser=ContextUtil.getCurrentUser();
			receiveArchivesPersonForm.setArchiveReceiveUserid(sysUser.getAcd230());
			receiveArchivesPersonForm.setArchiveReceiveName(sysUser.getAac003());
			SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
			receiveArchivesPersonForm.setArchiveReceiveDate(s);
			receiveArchivesPersonForm.setArchiveReceiveOrgId(sysOrg.getAcd200());
			receiveArchivesPersonForm.setArchiveReceiveOrgName(sysOrg.getAcd202());
			receiveArchivesPersonForm.setReceiveDate(s);
		}
		ModelAndView modelAndView= new ModelAndView("/business/personagency/receive/editCorpReceiveArchives.jsp");
		modelAndView.addObject("receiveArchivesPersonForm", receiveArchivesPersonForm).addObject("personId", personId)
			.addObject("archiveId", receiveArchivesPersonForm.getId()==null?0l:receiveArchivesPersonForm.getId());
		return modelAndView;		
	}
	
}
