package com.xunfeng.business.person.web;

import java.util.ArrayList;
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

import com.alibaba.fastjson.JSONArray;
import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.interf.PersonExpandServiceInterf;
import com.xunfeng.business.person.interf.PersonFamilyServiceInterf;
import com.xunfeng.business.person.interf.PersonJobRegistServiceInter;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.model.PersonFamily;
import com.xunfeng.business.person.web.form.PersonExpandForm;
import com.xunfeng.business.person.web.form.PersonFamilyForm;
import com.xunfeng.business.person.web.form.PersonBaseInfoForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.PersonStaEnum;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.Pinyin4jUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.accounts.interf.AccountsServiceInter;
import com.xunfeng.sys.accounts.model.Accounts;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人基本信息表 控制器类
* @author:wanlupeng
* @createDate 2016-06-27 17:44:37 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/person/personBaseInfo/")
public class PersonBaseInfoController extends BaseController
{
	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf personBaseInfoService;
	@Resource
	@Qualifier("personExpand")
	private PersonExpandServiceInterf personExpandService;
	@Resource
	@Qualifier("accounts")
	private AccountsServiceInter accountsService;
	@Resource
	@Qualifier("personFamily")
	private PersonFamilyServiceInterf personFamilyService;
	@Resource
	@Qualifier("personJobRegist")
	PersonJobRegistServiceInter personJobRegist;
	/**
	 * 添加或更新个人基本信息表。
	 * @param request
	 * @param response
	 * @param personBaseInfoForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新个人基本信息表")
	public void save(HttpServletRequest request, HttpServletResponse response,PersonBaseInfoForm personBaseInfoForm,
			PersonExpandForm personExpandForm,PersonFamilyForm personFamilyForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
			Long sign=RequestUtil.getLong(request,"sign");
		    Long aac001=RequestUtil.getLong(request,"aac001");
		    String nodelogs=RequestUtil.getString(request,"nodelogs");
		    String aac002=RequestUtil.getString(request,"aac002");
		    String expPersonStatus=RequestUtil.getString(request,"expPersonStatus");
		    String faName=RequestUtil.getString(request, "faName");
		    String faSpouseCard=RequestUtil.getString(request, "faSpouseCard");
		    PersonBaseInfo personBaseInfo = personBaseInfoService.getById(aac001);
		    PersonBaseInfo person = personBaseInfoService.getByAac002(aac002);
		    personBaseInfo=personBaseInfoForm.getModel(personBaseInfo);
		    PersonFamily familyperson = new PersonFamily();
		    PersonExpand personexpand = new PersonExpand();
		    PersonExpand personExpand = new PersonExpand();
		    PersonFamily personFamily = new PersonFamily();
		    Accounts     accounts     = new Accounts();
			if(personBaseInfoForm.isMvcAdd()){
				if(person==null){
					resultMsg="添加个人基本信息表";
					personBaseInfo.setAac001(uniqueIdUtil.genId(PersonBaseInfo.class.getName()));
					personBaseInfo.setAae011(String.valueOf(ContextUtil.getCurrentUser().getAcd230()));
					//LWH修改 2016-08-25 经办机构代码填写
					personBaseInfo.setAae017(ContextUtil.getCurrentUserOrg()==null?"":String.valueOf(ContextUtil.getCurrentUserOrg().getAcd200()));
//					personBaseInfo.setAae017(ContextUtil.getCurrentUserDept()==null?"":String.valueOf(ContextUtil.getCurrentUserDept().getDep001()));
					//个人扩展表信息保存
					if(expPersonStatus.isEmpty()){
					}else{
						//查询扩展表中是否有数据
					    PersonExpand   expand   = personExpandService.getByExpPersonId(aac001);
					    if(expand==null){
							personexpand=personExpandForm.getModel(personexpand);
							personexpand.setExpandId(uniqueIdUtil.genId(PersonExpand.class.getName()));
							personexpand.setExpPersonId(personBaseInfo.getAac001());
							personexpand.setExpOpeartorUserId(ContextUtil.getCurrentUser().getAcd230());
							personexpand.setExpPensionDate(new Date());
					    }else{
					    	personExpand=personExpandForm.getModel(expand);
					    	personExpandForm.setExpPersonId(personBaseInfo.getAac001());
					    }
					}
					//家庭关系保存
					if(faName.isEmpty()){
					}else {
						if(faSpouseCard.isEmpty()){
							message=new ResultMessage(ResultMessage.Success, "请填写配偶身份证号");
							writeResultMessage(response.getWriter(),message);
							return;
						}else{
							PersonFamily family=personFamilyService.getByFaPersonId(personBaseInfo.getAac001());
							personFamily=personFamilyForm.getModel(family);
							if(personFamilyForm.isMvcAdd()){
								personFamily.setId(uniqueIdUtil.genId(PersonFamily.class.getName()));
								personFamily.setFaPersonId(personBaseInfo.getAac001());
								personFamily.setCreaterId(ContextUtil.getCurrentUser().getAcd230());
								personFamily.setCreaterOrgId(ContextUtil.getCurrentUserDept()==null?0L:ContextUtil.getCurrentUserDept().getDep001());
								personFamily.setCreaterOrgName(personBaseInfo.getAae020());
								personFamily.setCreaterDate(personBaseInfo.getAae036());
							}
						}
					} 
					personBaseInfo.setCcmu50(0L);// 简历完成百分比
		            personBaseInfo.setCcmu51("0");// 求职意向是否完整
		            personBaseInfo.setCcmu52("0");// 技能特长是否完整
		            personBaseInfo.setCcmu53("0");// 教育经历是否完整
		            personBaseInfo.setCcmu54("0");// 工作经历是否完整
		            personBaseInfo.setCcmu55("0");// 形象照片是否完整
		            personBaseInfo.setCcmu56("0");// 头像是否显示
		            personBaseInfo.setCcmu57("0");// 培训经理是否完整
		            personBaseInfo.setCcmu58(0L);// 认证标志（0-未认证1-已上传未认证2-网站后台认证3-职介人工认证4-设备认证）
		            personBaseInfo.setCcmu59(0L);// 手机认证标志（0-未认证1-已发送未认证2-手机已认证)
		            personBaseInfo.setCcmu60(0L);// 邮件认证标志（0-未认证1-已发送未认证2-邮件已认证)
		            personBaseInfo.setCcpr05(new Date());// 最后修改时间
		            personBaseInfo.setCcpr08("0");// 是否删除状态（0-否1-是）
		            personBaseInfo.setCcmu63("0");// 是否有资格证书
		            personBaseInfo.setAcb223("9");// 年龄段标记1-（16-24岁）2-（25-34岁）3-（35-44岁）4-（45岁以上）9-无要求
		            personBaseInfo.setDiv001(0L);// 设备编号
		            personBaseInfo.setAac038("2");// 个人工作经验编号,tab_workyears
					//生成账号信息
		            Long   accountId = uniqueIdUtil.genId(Accounts.class.getName());
					String username = Pinyin4jUtil.converterToSpell(personBaseInfo.getAac003().replace("u:", "v"))
			                + personBaseInfo.getAac002().substring(personBaseInfo.getAac002().length() - 6);
					String userpwd = personBaseInfo.getAac002().substring(personBaseInfo.getAac002().length() - 6);
					//ccum17
					accounts.setCcmu01(accountId);
					accounts.setCcmu02(username);
					accounts.setCcmu03(userpwd);
					accounts.setCcmu07(new Date());// 最后登录时间
					accounts.setCcmu11(new Date());// 最后更新简历时间
					accounts.setCcmu12(0L);// 邮箱激活状态(0-未激活1-已激活)
					accounts.setCcmu13(0L);// 手机激活状态(0-未激活1-已激活)
					accounts.setCcmu16(new Date());// 注册日期
					accounts.setCcmu19(0L);// 用户人才币余额
					accounts.setCcmu20(0L);// 企业今天已经的下载简历数
					accounts.setCcmu21(0L);// 用户名修改次数,大于1则不能再次修改用户名
					accounts.setCcmu22(personBaseInfoForm.getCczy06());// 数据来源0未知1网站2窗口3-民营机构
					accounts.setCcpr08("0");// 是否删除状态（0-否1-是）
					accounts.setCcmu17(1L);// 账号类型(1-个人用户2-企业用户3-民营职介机构4-公办职介机构5-财政局查询)
					accounts.setCcmu10(1L);// 账号有效性
		            personBaseInfo.setCcmu01(accountId);// 会员编号
					personBaseInfoService.addAll(faName,faSpouseCard,expPersonStatus,personBaseInfo,personexpand,personExpand,personFamily,accounts,nodelogs);
				}else{
					message=new ResultMessage(ResultMessage.Success, "身份证号已存在，请核实"+"1");
					writeResultMessage(response.getWriter(),message);
					return;
				}
			}else{
				resultMsg="更新个人基本信息表";
				//个人扩展表信息更新
				Long expPersonId = personBaseInfo.getAac001();
				PersonExpand expand=personExpandService.getByExpPersonId(expPersonId);
				if(expand!=null){
					if(sign!=1){
						personExpand=personExpandForm.getModel(expand);
						personExpand.setExpPersonId(aac001);
					}else{
						String expacc0m=RequestUtil.getString(request,"expacc0m");
						expand.setExpacc0m(expacc0m);
						expand.setExpPersonId(aac001);
					}
				}else{
					personexpand=personExpandForm.getModel(personexpand);
					personexpand.setExpandId(uniqueIdUtil.genId(PersonExpand.class.getName()));
					personexpand.setExpPersonId(personBaseInfo.getAac001());
					personexpand.setExpOpeartorUserId(ContextUtil.getCurrentUser().getAcd230());
					personexpand.setExpPensionDate(new Date());
				}
				if(sign!=1){
					PersonFamily family=personFamilyService.getByFaPersonId(personBaseInfo.getAac001());
					if(family==null){
						if(faName.isEmpty()){
						}else {
							if(faSpouseCard.isEmpty()){
								message=new ResultMessage(ResultMessage.Success, "请填写配偶身份证号");
								writeResultMessage(response.getWriter(),message);
								return;
							}else{
								family=personFamilyForm.getModel(family);
								family.setId(uniqueIdUtil.genId(PersonFamily.class.getName()));
								family.setFaPersonId(personBaseInfo.getAac001());
								family.setCreaterId(ContextUtil.getCurrentUser().getAcd230());
								family.setCreaterOrgId(ContextUtil.getCurrentUserDept()==null?0L:ContextUtil.getCurrentUserDept().getDep001());
								family.setCreaterOrgName(personBaseInfo.getAae020());
								family.setCreaterDate(personBaseInfo.getAae036());
							}
						} 
					}else{
						personFamilyForm.setFaPersonId(family.getFaPersonId());
						personFamilyForm.setId(family.getId());
						family=personFamilyForm.getModel(family);
					}
					familyperson=family;
				}
				//查询账号信息
				Accounts account =  accountsService.getById(personBaseInfo.getCcmu01());
				personBaseInfoService.updateAll(faName,faSpouseCard,sign, personBaseInfo,personExpand,expand,personexpand,familyperson,account,nodelogs);
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功"+personBaseInfo.getAac001());
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
//	/**
//	 * 添加或更新个人基本信息表。
//	 * @param request
//	 * @param response
//	 * @param personBaseInfoForm 添加或更新的实体
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("save")
//	@Action(description="添加或更新个人基本信息表")
//	public void save(HttpServletRequest request, HttpServletResponse response,PersonBaseInfoForm personBaseInfoForm,
//			PersonExpandForm personExpandForm,PersonFamilyForm personFamilyForm) throws Exception
//	{
//		String resultMsg=null;	
//		ResultMessage message=null;	
//		try{
//			Long sign=RequestUtil.getLong(request,"sign");
//		    Long aac001=RequestUtil.getLong(request,"aac001");
//		    String nodelogs=RequestUtil.getString(request,"nodelogs");
//		    String aac002=RequestUtil.getString(request,"aac002");
//		    String expPersonStatus=RequestUtil.getString(request,"expPersonStatus");
//		    String faName=RequestUtil.getString(request, "faName");
//		    String faSpouseCard=RequestUtil.getString(request, "faSpouseCard");
//		    PersonBaseInfo personBaseInfo = personBaseInfoService.getById(aac001);
//		    PersonBaseInfo person = personBaseInfoService.getByAac002(aac002);
//		    personBaseInfo=personBaseInfoForm.getModel(personBaseInfo);
//		    PersonFamily familyperson = new PersonFamily();
//		    PersonExpand personexpand = new PersonExpand();
//		    PersonExpand personExpand = new PersonExpand();
//		    PersonFamily personFamily = new PersonFamily();
//		    Accounts     accounts     = new Accounts();
//			if(personBaseInfoForm.isMvcAdd()){
//				if(person==null){
//					resultMsg="添加个人基本信息表";
//					personBaseInfo.setAac001(uniqueIdUtil.genId(PersonBaseInfo.class.getName()));
//					personBaseInfo.setAae011(String.valueOf(ContextUtil.getCurrentUser().getAcd230()));
//					//LWH修改 2016-08-25 经办机构代码填写
//					personBaseInfo.setAae017(ContextUtil.getCurrentUserOrg()==null?"":String.valueOf(ContextUtil.getCurrentUserOrg().getAcd200()));
////					personBaseInfo.setAae017(ContextUtil.getCurrentUserDept()==null?"":String.valueOf(ContextUtil.getCurrentUserDept().getDep001()));
//					//个人扩展表信息保存
//					if(expPersonStatus.isEmpty()){
//					}else{
//						//查询扩展表中是否有数据
//					    PersonExpand   expand   = personExpandService.getByExpPersonId(aac001);
//					    if(expand==null){
//							personexpand=personExpandForm.getModel(personexpand);
//							personexpand.setExpandId(uniqueIdUtil.genId(PersonExpand.class.getName()));
//							personexpand.setExpPersonId(personBaseInfo.getAac001());
//							personexpand.setExpOpeartorUserId(ContextUtil.getCurrentUser().getAcd230());
//							personexpand.setExpPensionDate(new Date());
//					    }else{
//					    	personExpand=personExpandForm.getModel(expand);
//					    	personExpandForm.setExpPersonId(personBaseInfo.getAac001());
//					    }
//					}
//					//家庭关系保存
//					if(faName.isEmpty()){
//					}else {
//						if(faSpouseCard.isEmpty()){
//							message=new ResultMessage(ResultMessage.Success, "请填写配偶身份证号");
//							writeResultMessage(response.getWriter(),message);
//							return;
//						}else{
//							PersonFamily family=personFamilyService.getByFaPersonId(personBaseInfo.getAac001());
//							personFamily=personFamilyForm.getModel(family);
//							if(personFamilyForm.isMvcAdd()){
//								personFamily.setId(uniqueIdUtil.genId(PersonFamily.class.getName()));
//								personFamily.setFaPersonId(personBaseInfo.getAac001());
//								personFamily.setCreaterId(ContextUtil.getCurrentUser().getAcd230());
//								personFamily.setCreaterOrgId(ContextUtil.getCurrentUserDept()==null?0L:ContextUtil.getCurrentUserDept().getDep001());
//								personFamily.setCreaterOrgName(personBaseInfo.getAae020());
//								personFamily.setCreaterDate(personBaseInfo.getAae036());
//							}
//						}
//					} 
//					personBaseInfo.setCcmu50(0L);// 简历完成百分比
//		            personBaseInfo.setCcmu51("0");// 求职意向是否完整
//		            personBaseInfo.setCcmu52("0");// 技能特长是否完整
//		            personBaseInfo.setCcmu53("0");// 教育经历是否完整
//		            personBaseInfo.setCcmu54("0");// 工作经历是否完整
//		            personBaseInfo.setCcmu55("0");// 形象照片是否完整
//		            personBaseInfo.setCcmu56("0");// 头像是否显示
//		            personBaseInfo.setCcmu57("0");// 培训经理是否完整
//		            personBaseInfo.setCcmu58(0L);// 认证标志（0-未认证1-已上传未认证2-网站后台认证3-职介人工认证4-设备认证）
//		            personBaseInfo.setCcmu59(0L);// 手机认证标志（0-未认证1-已发送未认证2-手机已认证)
//		            personBaseInfo.setCcmu60(0L);// 邮件认证标志（0-未认证1-已发送未认证2-邮件已认证)
//		            personBaseInfo.setCcpr05(new Date());// 最后修改时间
//		            personBaseInfo.setCcpr08("0");// 是否删除状态（0-否1-是）
//		            personBaseInfo.setCcmu63("0");// 是否有资格证书
//		            personBaseInfo.setAcb223("9");// 年龄段标记1-（16-24岁）2-（25-34岁）3-（35-44岁）4-（45岁以上）9-无要求
//		            personBaseInfo.setDiv001(0L);// 设备编号
//		            personBaseInfo.setAac038("2");// 个人工作经验编号,tab_workyears
//					//生成账号信息
//		            Long   accountId = uniqueIdUtil.genId(Accounts.class.getName());
//					String username = Pinyin4jUtil.converterToSpell(personBaseInfo.getAac003().replace("u:", "v"))
//			                + personBaseInfo.getAac002().substring(personBaseInfo.getAac002().length() - 6);
//					String userpwd = personBaseInfo.getAac002().substring(personBaseInfo.getAac002().length() - 6);
//					//ccum17
//					accounts.setCcmu01(accountId);
//					accounts.setCcmu02(username);
//					accounts.setCcmu03(userpwd);
//					accounts.setCcmu07(new Date());// 最后登录时间
//					accounts.setCcmu11(new Date());// 最后更新简历时间
//					accounts.setCcmu12(0L);// 邮箱激活状态(0-未激活1-已激活)
//					accounts.setCcmu13(0L);// 手机激活状态(0-未激活1-已激活)
//					accounts.setCcmu16(new Date());// 注册日期
//					accounts.setCcmu19(0L);// 用户人才币余额
//					accounts.setCcmu20(0L);// 企业今天已经的下载简历数
//					accounts.setCcmu21(0L);// 用户名修改次数,大于1则不能再次修改用户名
//					accounts.setCcmu22(personBaseInfoForm.getCczy06());// 数据来源0未知1网站2窗口3-民营机构
//					accounts.setCcpr08("0");// 是否删除状态（0-否1-是）
//					accounts.setCcmu17(1L);// 账号类型(1-个人用户2-企业用户3-民营职介机构4-公办职介机构5-财政局查询)
//					accounts.setCcmu10(1L);// 账号有效性
//		            personBaseInfo.setCcmu01(accountId);// 会员编号
//					personBaseInfoService.addAll(faName,faSpouseCard,expPersonStatus,personBaseInfo,personexpand,personExpand,personFamily,accounts,nodelogs);
//				}else{
//					message=new ResultMessage(ResultMessage.Success, "身份证号已存在，请核实"+"1");
//					writeResultMessage(response.getWriter(),message);
//					return;
//				}
//			}else{
//				resultMsg="更新个人基本信息表";
//				//个人扩展表信息更新
//				Long expPersonId = personBaseInfo.getAac001();
//				PersonExpand expand=personExpandService.getByExpPersonId(expPersonId);
//				if(expand!=null){
//					if(sign!=1){
//						personExpand=personExpandForm.getModel(expand);
//						personExpand.setExpPersonId(aac001);
//					}else{
//						String expacc0m=RequestUtil.getString(request,"expacc0m");
//						expand.setExpacc0m(expacc0m);
//						expand.setExpPersonId(aac001);
//					}
//				}else{
//					personexpand=personExpandForm.getModel(personexpand);
//					personexpand.setExpandId(uniqueIdUtil.genId(PersonExpand.class.getName()));
//					personexpand.setExpPersonId(personBaseInfo.getAac001());
//					personexpand.setExpOpeartorUserId(ContextUtil.getCurrentUser().getAcd230());
//					personexpand.setExpPensionDate(new Date());
//				}
//				if(sign!=1){
//					PersonFamily family=personFamilyService.getByFaPersonId(personBaseInfo.getAac001());
//					if(family==null){
//						if(faName.isEmpty()){
//						}else {
//							if(faSpouseCard.isEmpty()){
//								message=new ResultMessage(ResultMessage.Success, "请填写配偶身份证号");
//								writeResultMessage(response.getWriter(),message);
//								return;
//							}else{
//								family=personFamilyForm.getModel(family);
//								family.setId(uniqueIdUtil.genId(PersonFamily.class.getName()));
//								family.setFaPersonId(personBaseInfo.getAac001());
//								family.setCreaterId(ContextUtil.getCurrentUser().getAcd230());
//								family.setCreaterOrgId(ContextUtil.getCurrentUserDept()==null?0L:ContextUtil.getCurrentUserDept().getDep001());
//								family.setCreaterOrgName(personBaseInfo.getAae020());
//								family.setCreaterDate(personBaseInfo.getAae036());
//							}
//						} 
//					}else{
//						personFamilyForm.setFaPersonId(family.getFaPersonId());
//						personFamilyForm.setId(family.getId());
//						family=personFamilyForm.getModel(family);
//					}
//					familyperson=family;
//				}
//				//查询账号信息
//				Accounts account =  accountsService.getById(personBaseInfo.getCcmu01());
//				personBaseInfoService.updateAll(faName,faSpouseCard,sign, personBaseInfo,personExpand,expand,personexpand,familyperson,account,nodelogs);
//			}
//			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功"+personBaseInfo.getAac001());
//			writeResultMessage(response.getWriter(),message);
//		}catch(Exception ex){
//			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
//			logger.error(ExceptionUtil.getExceptionMessage(ex));
//			writeResultMessage(response.getWriter(),message);
//		}
//	}

	/**
	 * 取得个人基本信息表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		Long cczy06=RequestUtil.getLong(request,"cczy06",0L);
		Long cczy=RequestUtil.getLong(request,"cczy06",0L);
		ModelAndView mv=this.getAutoView();
		return mv.addObject("cczy06","").addObject("cczy",cczy);
	}
	
	/**
	 * 取得个人基本信息表分页列表
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
		ResultData<PersonBaseInfo> resultData=personBaseInfoService.getAllPerson(fiter);
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 取得个人基本信息表分页列表(公办和劳动力)
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("personListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> personListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		
		QueryFilter fiter=new QueryFilter(request);
//		int limit =RequestUtil.getInt(request, "limit");
//		int offset = RequestUtil.getInt(request, "offset");
//		PageBean pageBean =WrapPageBean(limit, offset);
//		fiter.setPageBean(pageBean);
		ResultData<PersonBaseInfo> resultData=personBaseInfoService.getPersonList(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	/**
	 * 取得个人求职信息视图列表查询
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listView")
	public ModelAndView listView(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		return new ModelAndView("/business/person/personJobViewList.jsp").addObject("orgs", getOrganSelectList());
	}
	
	/**
	 * 取得个人求职信息视图列表查询
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJsonView")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listJsonView(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
		PageBean pageBean =WrapPageBean(limit, offset);
		fiter.setPageBean(pageBean);
		//添加用户组织ID
		ResultData<Map<String,Object>> resultData=personJobRegist.getPersonRegistViewList(addJurisdiction(fiter));	
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 删除个人基本信息表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除个人基本信息表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "aac001");
			personBaseInfoService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除个人基本信息表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增个人基本信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增个人基本信息表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		String cczy06=RequestUtil.getString(request,"cczy06","0");
		PersonBaseInfoForm  personBaseInfoForm=new PersonBaseInfoForm();
		personBaseInfoForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/person/personBaseInfoEdit.jsp");
		personBaseInfoForm.setAae019(ContextUtil.getCurrentUser().getAac003());
		personBaseInfoForm.setAae020(ContextUtil.getCurrentUserOrg()==null?"":ContextUtil.getCurrentUserOrg().getAcd202());
		personBaseInfoForm.setAae036(new Date());
		personBaseInfoForm.setCczy06(cczy06);
		return modelAndView.addObject("personBaseInfoForm",personBaseInfoForm);					
	}
	/**
	 * 	编辑个人基本信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑个人基本信息表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long aac001=RequestUtil.getLong(request,"aac001",0L);
		String cczy06=RequestUtil.getString(request,"cczy06");
		PersonBaseInfo personBaseInfo=personBaseInfoService.getById(aac001);
		//家庭关系信息查询
		PersonFamily personFamily=personFamilyService.getByFaPersonId(aac001);
		//个人扩展信息查询
		PersonExpand personExpand=personExpandService.getByExpPersonId(aac001);
		PersonBaseInfoForm  personBaseInfoForm=new PersonBaseInfoForm();
		personBaseInfoForm.putModel(personBaseInfo);
		if(personExpand!=null){
			personBaseInfoForm.setExpandId(personExpand.getExpandId());
			personBaseInfoForm.setExpPersonStatus(personExpand.getExpPersonStatus());
			personBaseInfoForm.setExpStartJobDate(personExpand.getExpStartJobDate());
			personBaseInfoForm.setExpOldCompany(personExpand.getExpOldCompany());
			personBaseInfoForm.setExpHourseDate(personExpand.getExpHourseDate());
			personBaseInfoForm.setExpAddress(personExpand.getExpAddress());
			personBaseInfoForm.setExpPost(personExpand.getExpPost());
			personBaseInfoForm.setExpLevel(personExpand.getExpLevel());
			personBaseInfoForm.setExpLevelDate(personExpand.getExpLevelDate());
			personBaseInfoForm.setExpHardPerson(personExpand.getExpHardPerson());
			personBaseInfoForm.setExpPositionName(personExpand.getExpPositionName());
			personBaseInfoForm.setExpTechnical(personExpand.getExpTechnical());
			personBaseInfoForm.setExpTechnicalDate(personExpand.getExpTechnicalDate());
			personBaseInfoForm.setExpIsFamily(personExpand.getExpIsFamily());
			personBaseInfoForm.setExpIsDifficult(personExpand.getExpIsDifficult());
		}
		if(personFamily!=null){
			personBaseInfoForm.setId(personFamily.getId());
			personBaseInfoForm.setFaName(personFamily.getFaName());
			personBaseInfoForm.setFaMarriage(personFamily.getFaMarriage());
			personBaseInfoForm.setFaMarriageDate(personFamily.getFaMarriageDate());
			personBaseInfoForm.setFaSpouseCard(personFamily.getFaSpouseCard());
			personBaseInfoForm.setFaSpouseBirth(personFamily.getFaSpouseBirth());
			personBaseInfoForm.setFaSpouseNational(personFamily.getFaSpouseNational());
			personBaseInfoForm.setFaSpouseCompany(personFamily.getFaSpouseCompany());
			personBaseInfoForm.setFaSpousePhone(personFamily.getFaSpousePhone());
			personBaseInfoForm.setFaBirthCondition(personFamily.getFaBirthCondition());
			personBaseInfoForm.setFaBirthControl(personFamily.getFaBirthControl());
			personBaseInfoForm.setFaFamilyBark(personFamily.getFaFamilyBark());
		}
		if("".equals(cczy06)){}else{
			personBaseInfoForm.setCczy06(cczy06);
		}
		return getAutoView().addObject("personBaseInfoForm",personBaseInfoForm);					
	}
	/**
	 * 	编辑个人基本信息表(根据身份证号查询)
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("personCard")
	@Action(description="编辑个人基本信息表(根据身份证号查询)")
	public ModelAndView personCard(HttpServletRequest request) throws Exception
	{
//		String aac002=RequestUtil.getString(request,"aac002");
//		PersonBaseInfo personBaseInfo=personBaseInfoService.getByAac002(aac002);
		String cczy06=RequestUtil.getString(request,"cczy06");
		Long aac001=RequestUtil.getLong(request,"aac001",0L);
		PersonBaseInfo personBaseInfo=personBaseInfoService.getById(aac001);
		
		
		PersonBaseInfoForm  personBaseInfoForm=new PersonBaseInfoForm();
		ModelAndView modelAndView= new ModelAndView("/business/person/personBaseInfoEdit.jsp");
//		personBaseInfoForm.setAac002(aac002);
		if(personBaseInfo==null){
			return modelAndView.addObject("personBaseInfoForm",personBaseInfoForm).addObject("cardId",1L);
		}else{
			//家庭关系信息查询
			PersonFamily personFamily=personFamilyService.getByFaPersonId(personBaseInfo.getAac001());
			//个人扩展信息查询
			PersonExpand personExpand=personExpandService.getByExpPersonId(personBaseInfo.getAac001());
			personBaseInfoForm.putModel(personBaseInfo);
			if(personExpand!=null){
				personBaseInfoForm.setExpPersonId(personExpand.getExpPersonId());
				personBaseInfoForm.setExpandId(personExpand.getExpandId());
				personBaseInfoForm.setExpPersonStatus(personExpand.getExpPersonStatus());
				personBaseInfoForm.setExpStartJobDate(personExpand.getExpStartJobDate());
				personBaseInfoForm.setExpOldCompany(personExpand.getExpOldCompany());
				personBaseInfoForm.setExpHourseDate(personExpand.getExpHourseDate());
				personBaseInfoForm.setExpAddress(personExpand.getExpAddress());
				personBaseInfoForm.setExpPost(personExpand.getExpPost());
				personBaseInfoForm.setExpLevel(personExpand.getExpLevel());
				personBaseInfoForm.setExpHardPerson(personExpand.getExpHardPerson());
				personBaseInfoForm.setExpLevelDate(personExpand.getExpLevelDate());
				personBaseInfoForm.setExpPositionName(personExpand.getExpPositionName());
				personBaseInfoForm.setExpTechnical(personExpand.getExpTechnical());
				personBaseInfoForm.setExpTechnicalDate(personExpand.getExpTechnicalDate());
				personBaseInfoForm.setExpIsFamily(personExpand.getExpIsFamily());
				personBaseInfoForm.setExpIsDifficult(personExpand.getExpIsDifficult());
				personBaseInfoForm.setExpacc0m(personExpand.getExpacc0m());
			}
			if(personFamily!=null){
				personBaseInfoForm.setId(personFamily.getId());
				personBaseInfoForm.setFaName(personFamily.getFaName());
				personBaseInfoForm.setFaMarriage(personFamily.getFaMarriage());
				personBaseInfoForm.setFaMarriageDate(personFamily.getFaMarriageDate());
				personBaseInfoForm.setFaSpouseCard(personFamily.getFaSpouseCard());
				personBaseInfoForm.setFaSpouseBirth(personFamily.getFaSpouseBirth());
				personBaseInfoForm.setFaSpouseNational(personFamily.getFaSpouseNational());
				personBaseInfoForm.setFaSpouseCompany(personFamily.getFaSpouseCompany());
				personBaseInfoForm.setFaSpousePhone(personFamily.getFaSpousePhone());
				personBaseInfoForm.setFaBirthCondition(personFamily.getFaBirthCondition());
				personBaseInfoForm.setFaBirthControl(personFamily.getFaBirthControl());
				personBaseInfoForm.setFaFamilyBark(personFamily.getFaFamilyBark());
			}
			personBaseInfoForm.setCczy06(cczy06);
			return modelAndView.addObject("personBaseInfoForm",personBaseInfoForm);
		}
		
							
	}
	
	/**
	 * 	查看个人基本信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("selctPerson")
	@Action(description="查看个人基本信息")
	public ModelAndView selctPerson(HttpServletRequest request) throws Exception
	{
		Long aac001=RequestUtil.getLong(request,"aac001",0L);
		Long cczy06=RequestUtil.getLong(request,"cczy06",0L);
		ModelAndView modelAndView= new ModelAndView("/business/person/personBaseInfoDetails.jsp");
		//通过视图V_AC01查询数据
		PersonBaseInfo personBaseInfo=personBaseInfoService.getByIds(aac001);
		//家庭关系信息查询
		PersonFamily personFamily=personFamilyService.getByPersonId(aac001);
		//个人扩展信息查询
		PersonExpand personExpand=personExpandService.getByExpId(aac001);
		PersonBaseInfoForm  personBaseInfoForm=new PersonBaseInfoForm();
		personBaseInfoForm.putModel(personBaseInfo);
		return modelAndView.addObject("personBaseInfoForm",personBaseInfoForm).addObject("personFamily",personFamily)
				.addObject("personExpand",personExpand).addObject("cczy06",cczy06);					
	}
	/**
	 * 	编辑个人教育背景信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("selectEducation")
	@Action(description="编辑个人教育背景信息表")
	public ModelAndView selectEducation(HttpServletRequest request) throws Exception
	{
		String cczy06=RequestUtil.getString(request,"cczy06");
		ModelAndView modelAndView= new ModelAndView("/business/person/personEducationSelect.jsp");
		Long aac001=RequestUtil.getLong(request,"aac001",0L);
		return modelAndView.addObject("aac001",aac001).addObject("cczy06",cczy06);					
	}
	/**
	 * 	编辑个人工作经历（简历）信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("selectWorkExpce")
	@Action(description="编辑个人教育背景信息表")
	public ModelAndView selectWorkExpce(HttpServletRequest request) throws Exception
	{
		ModelAndView modelAndView= new ModelAndView("/business/person/workExpce/personWorkExpceList.jsp");
		Long aac001=RequestUtil.getLong(request,"aac001",0L);
		String cczy06=RequestUtil.getString(request,"cczy06");
		return modelAndView.addObject("aac001",aac001).addObject("cczy06",cczy06);					
	}

	/**
	 * 取得个人基本信息表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看个人基本信息表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long aac001=RequestUtil.getLong(request,"aac001");
		PersonBaseInfo personBaseInfo = personBaseInfoService.getById(aac001);	
		return getAutoView().addObject("personBaseInfo", personBaseInfo);
	}
	
	/**
	 * 取得个人信息统计
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("personStatistics")
	public ModelAndView personStatistics(HttpServletRequest request,HttpServletResponse response) throws Exception
	{    
		return new ModelAndView("/business/person/personBaseInfoStatistics.jsp").addObject("orgs", getOrganSelectList()).addObject("stas", PersonStaEnum.values());
	}
	
	/**
	 * 取得个人基本信息表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listStatisticsJson")
	@Action(description="个人信息统计列表")
	@ResponseBody
	public Map<Object,Object> listStatisticsJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
		PageBean pageBean =WrapPageBean(limit, offset);
		fiter.setPageBean(pageBean);
		//设置细类信息
		if(StringUtil.isEmpty(request.getParameter("groupvalue"))){
			fiter.addFilter("groupname", "");
			fiter.addFilter("columnname", "");
		}else{
			//设置分组值
			PersonStaEnum personStaEnum = PersonStaEnum.getValue(request.getParameter("groupvalue"));
			fiter.addFilter("groupname",personStaEnum.getTableColumn());
			fiter.addFilter("columnname",personStaEnum.getTableColumnName());
		}
		ResultData<Map<String, Object>> resultdata=personBaseInfoService.getPersonStatistics(addJurisdiction(fiter));
		List<Map<String, Object>> list = resultdata.getDataList();
		if(list!=null&&list.size()>0){
			Map<String, Object> empty = new HashMap<String, Object>();
			empty.put("AAE020", "合计");
			empty.put("LAST", true);
			empty.put("TOTAL_NUM", list.get(0).get("TOTAL_NUM"));
			list.add(empty);
		}
		return getTableData(resultdata.getPageBean().getTotalCount(), resultdata.getDataList());
	}
	
	/**
	 * 报表统计数据获取
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listStatisticsChartsJson")
	@Action(description="个人信息统计列表")
	@ResponseBody
	public Map<Object,Object> listStatisticsChartsJson(HttpServletRequest request,HttpServletResponse response) throws Exception{
		QueryFilter fiter=new QueryFilter(request);
		//设置分组值
		String groupname ="";
		String columnname ="";
		if("666".equals(request.getParameter("groupvalue"))){
			//根据机构分组统计
			groupname = "AAE020";
			columnname = "AAE020";
		}else if("888".equals(request.getParameter("groupvalue"))){
			//根据平台分组统计
			groupname = "ECZY06";
			columnname = "ECZY06";
		}else{
			PersonStaEnum personStaEnum = PersonStaEnum.getValue(request.getParameter("groupvalue"));
			groupname = personStaEnum.getTableColumn();
			columnname = personStaEnum.getTableColumnName();
		}
		fiter.addFilter("groupname",groupname);
		fiter.addFilter("columnname",columnname);
		//添加用户组织ID
		Map<Object,Object> remap = new HashMap<Object, Object>();
		List<Map<String, Object>> results = personBaseInfoService.getPersonStatisticsEcharts(addJurisdiction(fiter));
		List<String> dataName = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		if(results!=null&&results.size()>0){
			 for (Map<String, Object> map : results) {
				Map<String,Object> re = new HashMap<String, Object>();
				if(!map.containsKey("COLUMNNAME")||"".equals(String.valueOf(map.get("COLUMNNAME")))){
					dataName.add("其它");
					re.put("name", "其它");
					values.add(String.valueOf(map.get("PERNUM")));
				}else{
					re.put("name", String.valueOf(map.get("COLUMNNAME")));
					dataName.add(String.valueOf(map.get("COLUMNNAME")));
					values.add(String.valueOf(map.get("PERNUM")));
				}
				re.put("value",String.valueOf(map.get("PERNUM")));
				resultList.add(re);
			 }
		}
		remap.put("datanames", dataName);
		remap.put("datanamevalues", JSONArray.toJSON(resultList));
		remap.put("datavalues", values);
		return remap;
	}
	
	
	
	@RequestMapping("isPersonExist")
	@Action(description = "判断身份证号是否存在")
	@ResponseBody
	public Map isPersonExist(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map map=new HashMap();
		try {
			QueryFilter fiter = new QueryFilter(request);
			List<PersonBaseInfo> personList=personBaseInfoService.getPersonExist(fiter);//验证身份证号是否存在
			if (personList != null&&personList.size() >0) {
				map.put("valid",false);
			} else {
				map.put("valid",true);
			}
		} catch (Exception ex) {
			map.put("valid",false);
		}
		return map;
	}
 
	@RequestMapping("isExist")
	@Action(description = "判断配偶身份证号是否存在")
	@ResponseBody
	public ResultMessage isExist(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ResultMessage resultMessage = null;
		try {
			QueryFilter fiter = new QueryFilter(request);
			List<PersonFamily> list=personFamilyService.getByFaSpouseCard(fiter);
			if (list != null && list.size() > 0) {
				resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			} else {
				resultMessage = new ResultMessage(ResultMessage.Fail, "不存在");
			}
		} catch (Exception ex) {
			resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return resultMessage;
	}
 
	/**
	 * 取得个人求职信息统计
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("personJobregStatistics")
	public ModelAndView jobregStatistics(HttpServletRequest request,HttpServletResponse response) throws Exception
	{    
		return new ModelAndView("/business/person/personJobregStatistics.jsp").addObject("orgs", getOrganSelectList());
	}
	
	/**
	 * 取得个人求职信息视图列表查询
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jobregStatisticsJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> jobregStatisticsJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
		PageBean pageBean =WrapPageBean(limit, offset);
		fiter.setPageBean(pageBean);
		//添加用户组织ID
		ResultData<Map<String,Object>> resultData=personJobRegist.getJobregStatistics(addJurisdiction(fiter));	
		List<Map<String,Object>> list =  resultData.getDataList();
		if(list!=null&&list.size()>0){
			Map<String, Object> empty = new HashMap<String, Object>();
			empty.put("AAE020", "合计");
			empty.put("LAST", true);
			empty.put("TOTAL_NUM", list.get(0).get("TOTAL_NUM"));
			list.add(empty);
		}
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
}
