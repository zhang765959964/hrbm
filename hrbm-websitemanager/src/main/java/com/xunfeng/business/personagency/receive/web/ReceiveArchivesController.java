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
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.interf.PersonEducationServiceInterf;
import com.xunfeng.business.person.interf.PersonFamilyServiceInterf;
import com.xunfeng.business.person.interf.PersonWorkExpceServiceInterf;
import com.xunfeng.business.person.model.PersonEducation;
import com.xunfeng.business.person.model.PersonFamily;
import com.xunfeng.business.person.model.PersonWorkExpce;
import com.xunfeng.business.person.web.form.PersonFamilyForm;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.archive.web.form.ArchivesForm;
import com.xunfeng.business.personagency.receive.dto.GongZuoDto;
import com.xunfeng.business.personagency.receive.dto.JiaTingDto;
import com.xunfeng.business.personagency.receive.dto.JiaoYuDto;
import com.xunfeng.business.personagency.receive.dto.PersonBaseDto;
import com.xunfeng.business.personagency.receive.dto.ReceiveArchivesPersonDto;
import com.xunfeng.business.personagency.receive.interf.ReceiveArchivesServiceInterf;
import com.xunfeng.business.personagency.receive.web.form.GongZuoForm;
import com.xunfeng.business.personagency.receive.web.form.JiaTingForm;
import com.xunfeng.business.personagency.receive.web.form.JiaoYuForm;
import com.xunfeng.business.personagency.receive.web.form.PersonBaseForm;
import com.xunfeng.business.personagency.receive.web.form.ReceiveArchivesPersonForm;
import com.xunfeng.business.personagency.subsidy.dto.SocialSubsidyDto;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
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
@RequestMapping("/business/personagency/receive/receive/")
public class ReceiveArchivesController extends BaseController
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
		ModelAndView mv= new ModelAndView("/business/personagency/receive/searchReceiveArchives.jsp");
		return mv;
	}
	
	/**
	 * @param request
	 * @return 返回个人档案接收后的数据页面
	 * @throws Exception
	 */
	@RequestMapping("resultList")
	@Action(description="档案接收页面")
	public ModelAndView resultList(HttpServletRequest request) throws Exception
	{
		Long personId=RequestUtil.getLong(request,"personId",0L);
		Long type=RequestUtil.getLong(request,"type",0L);
		ReceiveArchivesPersonForm receiveArchivesPersonForm = new ReceiveArchivesPersonForm();
		receiveArchivesPersonForm.setType(type);
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
		ModelAndView modelAndView= new ModelAndView("/business/personagency/receive/resultReceiveArchives.jsp");
		modelAndView.addObject("receiveArchivesPersonForm", receiveArchivesPersonForm).addObject("personId", personId)
			.addObject("archiveId", receiveArchivesPersonForm.getId()==null?0l:receiveArchivesPersonForm.getId());
		return modelAndView;					
	}
	
	
	
	/**
	 * 适用于综合查询
	 * @param request
	 * @return 返回个人档案接收后的数据页面
	 * @throws Exception
	 */
	@RequestMapping("resultList1")
	@Action(description="档案接收页面")
	public ModelAndView resultList1(HttpServletRequest request) throws Exception
	{
		Long personId=RequestUtil.getLong(request,"personId",0L);
		ReceiveArchivesPersonForm receiveArchivesPersonForm = new ReceiveArchivesPersonForm();
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
		ModelAndView modelAndView= new ModelAndView("/business/personagency/agent/query/archives.jsp");
		modelAndView.addObject("receiveArchivesPersonForm", receiveArchivesPersonForm).addObject("personId", personId)
			.addObject("archiveId", receiveArchivesPersonForm.getId()==null?0l:receiveArchivesPersonForm.getId());
		return modelAndView;					
	}
	
	
	/**
	 * 适用于综合查询
	 * @param request
	 * @return 返回个人档案接收后的数据页面
	 * @throws Exception
	 */
	@RequestMapping("resultList2")
	@Action(description="档案接收页面")
	public ModelAndView resultList2(HttpServletRequest request) throws Exception
	{
		Long personId=RequestUtil.getLong(request,"personId",0L);
		ReceiveArchivesPersonForm receiveArchivesPersonForm = new ReceiveArchivesPersonForm();
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
		ModelAndView modelAndView= new ModelAndView("/business/personagency/agent/query/searchAgentList.jsp");
		modelAndView.addObject("receiveArchivesPersonForm", receiveArchivesPersonForm).addObject("personId", personId)
			.addObject("archiveId", receiveArchivesPersonForm.getId()==null?0l:receiveArchivesPersonForm.getId());
		return modelAndView;					
	}
	
	
	
	/**
	 * @param request
	 * @param response
	 * @param archivesForm  档案接收保存
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新人员档案表")
	public void save(HttpServletRequest request, HttpServletResponse response,ReceiveArchivesPersonForm receiveArchivesPersonForm) throws Exception
	{
		String resultMsg = "档案接收";
		ResultMessage message=null;	
		try{
			ReceiveArchivesPersonDto receiveArchivesPersonDto = BeanToBean.copyProperties(receiveArchivesPersonForm, new ReceiveArchivesPersonDto(), false);
			//个人基本信息
			PersonBaseDto personBaseDto = BeanToBean.copyProperties(receiveArchivesPersonForm.getPersonBaseForm(), new PersonBaseDto(), false);
			receiveArchivesPersonDto.setPersonBaseDto(personBaseDto);
			//工作经历
			GongZuoDto gongZuoDto = BeanToBean.copyProperties(receiveArchivesPersonForm.getGongZuoForm(), new GongZuoDto(), false);
			receiveArchivesPersonDto.setGongZuoDto(gongZuoDto);
			//家庭背景
			JiaTingDto jiaTingDto = BeanToBean.copyProperties(receiveArchivesPersonForm.getJiaTingForm(), new JiaTingDto(), false);
			receiveArchivesPersonDto.setJiaTingDto(jiaTingDto);
			//教育经历
			JiaoYuDto jiaoYuDto = BeanToBean.copyProperties(receiveArchivesPersonForm.getJiaoYuForm(), new JiaoYuDto(), false);
			receiveArchivesPersonDto.setJiaoYuDto(jiaoYuDto);
			if(receiveArchivesPersonForm.getType()!=null && receiveArchivesPersonForm.getType()==2){
				receiveArchivesService.saveLendBackArchives(receiveArchivesPersonDto);
				resultMsg = "重新接收档案";
			}else{
				receiveArchivesService.saveReceiveArchives(receiveArchivesPersonDto);
				if(receiveArchivesPersonForm.getId()!=null && receiveArchivesPersonForm.getId()>0){
					resultMsg = "修改档案";
				}
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
}
