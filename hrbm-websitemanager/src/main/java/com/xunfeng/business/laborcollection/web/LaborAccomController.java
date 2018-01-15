package com.xunfeng.business.laborcollection.web;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
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

import com.xunfeng.business.laborcollection.interf.LaborAccomServiceInterf;
import com.xunfeng.business.laborcollection.interf.LaborAcemployedServiceInterf;
import com.xunfeng.business.laborcollection.interf.LaborAcpostServiceInterf;
import com.xunfeng.business.laborcollection.model.LaborAccom;
import com.xunfeng.business.laborcollection.model.LaborAcemployed;
import com.xunfeng.business.laborcollection.model.LaborAcpost;
import com.xunfeng.business.laborcollection.web.form.LaborAccomForm;
import com.xunfeng.business.laborcollection.web.form.LaborAcemployedForm;
import com.xunfeng.business.laborcollection.web.form.LaborAcpostForm;
import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.interf.PersonExpandServiceInterf;
import com.xunfeng.business.person.interf.PersonFamilyServiceInterf;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.model.PersonFamily;
import com.xunfeng.business.person.web.form.PersonBaseInfoForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 就业情况信息表 控制器类
* @author:wanghan
* @createDate 2016-07-18 11:22:57 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/laborcollection/laborAccom/")
public class LaborAccomController extends BaseController
{
	@Resource
	@Qualifier("laborAccom")
	private LaborAccomServiceInterf laborAccomService;
	@Resource
	@Qualifier("laborAcpost")
	private LaborAcpostServiceInterf laborAcpostService;
	@Resource
	@Qualifier("laborAcemployed")
	private LaborAcemployedServiceInterf laborAcemployedService;
	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf personBaseInfoService;
	@Resource
	@Qualifier("personFamily")
	private PersonFamilyServiceInterf personFamilyService;
	@Resource
	@Qualifier("personExpand")
	private PersonExpandServiceInterf personExpandService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;
	
	/**
	 * 添加或更新就业情况信息表。
	 * @param request
	 * @param response
	 * @param laborAccomForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新就业情况信息表")
	public void save(HttpServletRequest request, HttpServletResponse response,LaborAccomForm laborAccomForm,
			LaborAcpostForm laborAcpostForm,LaborAcemployedForm laborAcemployedForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
			Long aac001=RequestUtil.getLong(request,"aac001");
			Long acc0m=RequestUtil.getLong(request,"acc0m");
		    PersonBaseInfo personBaseInfo = personBaseInfoService.getById(aac001);
		    personBaseInfoService.update(personBaseInfo);
		    PersonExpand personExpand = personExpandService.getByExpPersonId(aac001);
		    if(personExpand==null){
		    	PersonExpand person = new PersonExpand();
		    	person.setExpandId(uniqueIdUtil.genId(SqeIdName.PersonExpand.getSeqName()));
		    	person.setExpPersonId(personBaseInfo.getAac001());
		    	person.setExpacc0m(String.valueOf(acc0m));
		    	personExpandService.add(person);
		    }else{
		    	personExpand.setExpacc0m(String.valueOf(acc0m));
		    	personExpandService.update(personExpand);
		    }
			if(acc0m==1){
				LaborAccom laborAccom = laborAccomService.getByAccom(aac001);
				if(laborAccom==null){
					resultMsg="添加就业情况信息";
					LaborAccom accom=new LaborAccom();
					accom=laborAccomForm.getModel(accom);
					accom.setAcc0m01(uniqueIdUtil.genId(SqeIdName.LaborAccom.getSeqName()));
					accom.setAac001(aac001);
					laborAccomService.add(accom);
				}else{
					resultMsg="更新就业情况信息";
					Long acc0m01=laborAccom.getAcc0m01();
					laborAccom=laborAccomForm.getModel(laborAccom);
					laborAccom.setAcc0m01(acc0m01);
					laborAccomService.update(laborAccom);
					
				}
			}else if(acc0m==2){
				LaborAcpost laborAcpost = laborAcpostService.getByAcpost(aac001);
				if(laborAcpost==null){
					resultMsg="添加不在岗信息";
					LaborAcpost acpost=new LaborAcpost();
					acpost=laborAcpostForm.getModel(acpost);
					acpost.setAcpost01(uniqueIdUtil.genId(SqeIdName.LaborAcpost.getSeqName()));
					acpost.setAac001(aac001);
					laborAcpostService.add(acpost);
				}else{
					resultMsg="更新不在岗信息";
					Long acpost01=laborAcpost.getAcpost01();
					laborAcpost=laborAcpostForm.getModel(laborAcpost);
					laborAcpost.setAcpost01(acpost01);
					laborAcpostService.update(laborAcpost);
					
				}
				
			}else if(acc0m==3){
				LaborAcemployed laborAcemployed = laborAcemployedService.getByAcemployed(aac001);
				
				if(laborAcemployed==null){
					resultMsg="添加未就业及失业信息";
					LaborAcemployed  acemployed = new LaborAcemployed();
					acemployed=laborAcemployedForm.getModel(acemployed);
					acemployed.setAcemp01(uniqueIdUtil.genId(SqeIdName.LaborAcemployed.getSeqName()));
					acemployed.setAac001(aac001);
					laborAcemployedService.add(acemployed);
				}else{
					resultMsg="更新未就业及失业信息";
					Long acemp01 = laborAcemployed.getAcemp01();
					laborAcemployed=laborAcemployedForm.getModel(laborAcemployed);
					laborAcemployed.setAcemp01(acemp01);
					laborAcemployedService.update(laborAcemployed);
					
				}
				
			}else{
				resultMsg="添加";
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
	 * 取得就业情况信息表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		Long cczy06=RequestUtil.getLong(request,"cczy06",0L);
		ModelAndView mv= new ModelAndView("/business/person/personBaseInfoList.jsp");
		Long sign=1L;
		return mv.addObject("sign", sign).addObject("cczy06",cczy06);
	}
	/**
	 * 取得就业情况信息表分页列表
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
		List<LaborAccom> list=laborAccomService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除就业情况信息表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除就业情况信息表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "acc0m01");
			laborAccomService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除就业情况信息表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	/**
	 * 	新增就业情况信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增就业情况信息表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		Long sign=1L;
		String cczy06=RequestUtil.getString(request,"cczy06","0");
		PersonBaseInfoForm  personBaseInfoForm=new PersonBaseInfoForm();
		
		personBaseInfoForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/person/personBaseInfoEdit.jsp");
		personBaseInfoForm.setAae019(ContextUtil.getCurrentUser().getAac003());
		personBaseInfoForm.setAae020(ContextUtil.getCurrentUserOrg()==null?"":ContextUtil.getCurrentUserOrg().getAcd202());
		personBaseInfoForm.setAae036(new Date());
		personBaseInfoForm.setCczy06(cczy06);
		return modelAndView.addObject("personBaseInfoForm",personBaseInfoForm).addObject("sign",sign);					
	}
	/**
	 * 	编辑就业情况信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑就业情况信息表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long aac001=RequestUtil.getLong(request,"aac001",0L);
		PersonBaseInfo personBaseInfo = personBaseInfoService.getById(aac001);
		LaborAccomForm  laborAccomForm=new LaborAccomForm();
		if(personBaseInfo!=null){
			PersonExpand   personExpand   = personExpandService.getByExpPersonId(aac001);
			if(personExpand!=null){
				String acc = personExpand.getExpacc0m();
				if(acc!=null){
					Long acc0m=Long.valueOf(acc);
					if(acc0m==1){
						LaborAccom laborAccom = laborAccomService.getByAccom(aac001);
						laborAccomForm.putModel(laborAccom);
					}else if(acc0m==2){
						LaborAcpost laborAcpost = laborAcpostService.getByAcpost(aac001);
						laborAccomForm.setAcpost01(laborAcpost.getAcpost01());
						laborAccomForm.setAccm14(laborAcpost.getAccm14());
						laborAccomForm.setAccm16(laborAcpost.getAccm16());
						laborAccomForm.setAccm17(laborAcpost.getAccm17());
						laborAccomForm.setAccm18(laborAcpost.getAccm18());
						laborAccomForm.setAab004t(laborAcpost.getAab004t());
						laborAccomForm.setAab019t(laborAcpost.getAab019t());
						laborAccomForm.setAab020t(laborAcpost.getAab020t());
					}else if(acc0m==3){
						LaborAcemployed laborAcemployed = laborAcemployedService.getByAcemployed(aac001);
						laborAccomForm.setAcemp01(laborAcemployed.getAcemp01());
						laborAccomForm.setAcc20m(laborAcemployed.getAcc20m());
						laborAccomForm.setAccm20(laborAcemployed.getAccm20());
						laborAccomForm.setAccm21(laborAcemployed.getAccm21());
						laborAccomForm.setAccm19(laborAcemployed.getAccm19());
						laborAccomForm.setAccm22(laborAcemployed.getAccm22());
						laborAccomForm.setAccm23(laborAcemployed.getAccm23());
						laborAccomForm.setAab004m(laborAcemployed.getAab004m());
						laborAccomForm.setAab019m(laborAcemployed.getAab019m());
						laborAccomForm.setAab020m(laborAcemployed.getAab020m());
					}
				}
				laborAccomForm.setAcc0m(personExpand.getExpacc0m());
			}else{
				laborAccomForm.setAcc0m("0");
			}
		}
		ModelAndView modelAndView= new ModelAndView("/business/laborCollection/laborCollectionEdit.jsp");
		return modelAndView.addObject("laborAccomForm",laborAccomForm).addObject("aac001",aac001);					
	}
	/**
	 * 	返回基本信息页面
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("returnList")
	@Action(description="返回基本信息页面")
	public ModelAndView returnList(HttpServletRequest request) throws Exception
	{
		Long sign=1L;
		Long aac001=RequestUtil.getLong(request,"aac001",0L);
		PersonBaseInfo personBaseInfo=personBaseInfoService.getById(aac001);
		PersonExpand personExpand = personExpandService.getByExpPersonId(aac001);
		PersonBaseInfoForm  personBaseInfoForm=new PersonBaseInfoForm();
		personBaseInfoForm.putModel(personBaseInfo);
		if(personExpand!=null){
			personBaseInfoForm.setExpandId(personExpand.getExpandId());
			personBaseInfoForm.setExpacc0m(personExpand.getExpacc0m());
		}
		ModelAndView modelAndView= new ModelAndView("/business/person/personBaseInfoEdit.jsp");
		return modelAndView.addObject("personBaseInfoForm",personBaseInfoForm).addObject("aac001",aac001).addObject("sign",sign);					
	}
	/**
	 * 取得就业情况信息表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看就业情况信息表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long acc0m01=RequestUtil.getLong(request,"acc0m01");
		LaborAccom laborAccom = laborAccomService.getById(acc0m01);	
		return getAutoView().addObject("laborAccom", laborAccom);
	}
	
	/**
	 * 	通过身份证号查看个人基本信息
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("personCard")
	@Action(description="通过身份证号查看个人基本信息")
	public ModelAndView personCard(HttpServletRequest request) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");  
		Long sign=RequestUtil.getLong(request,"sign");
		String params=RequestUtil.getString(request,"params");
		String[] list=params.split(",");
		String aac002 = list[0];
		PersonBaseInfo personBaseInfo = personBaseInfoService.getByAac002(aac002);
		PersonBaseInfoForm  personBaseInfoForm=new PersonBaseInfoForm();
		personBaseInfoForm.setAac002(aac002);
		personBaseInfoForm.putModel(personBaseInfo);
		ModelAndView modelAndView= new ModelAndView("/business/person/personBaseInfoEdit.jsp");
		if(sign==1){ //劳动力系统模块
			if(personBaseInfo==null){
				String aac004 = list[1];
				String aac005 = list[2];
				String aac006 = list[3];
				String aac003 = list[4];
				String bab305 = list[5];
				Date date=sdf.parse(aac006);
				aac003=URLDecoder.decode(aac003, "UTF-8"); 
				bab305=URLDecoder.decode(bab305, "UTF-8"); 
				personBaseInfoForm.setAac003(aac003);
				personBaseInfoForm.setAac004(aac004);
				personBaseInfoForm.setAac005(aac005);
				personBaseInfoForm.setAac006(date);
				personBaseInfoForm.setBab305(bab305);
				Long aac001=RequestUtil.getLong(request,"aac001",0L);
				return modelAndView.addObject("personBaseInfoForm",personBaseInfoForm).addObject("aac001",aac001)
						.addObject("sign",sign).addObject("cardId",1L);					
			}else{
				Long aac001=personBaseInfo.getAac001();
				return modelAndView.addObject("personBaseInfoForm",personBaseInfoForm).addObject("aac001",aac001)
						.addObject("sign",sign).addObject("cardId",0L);					
			}
		}else{ //公办系统模块
			if(personBaseInfo==null){
				String aac004 = list[1];
				String aac005 = list[2];
				String aac006 = list[3];
				String aac003 = list[4];
				String bab305 = list[5];
				Date date=sdf.parse(aac006);
				aac003=URLDecoder.decode(aac003, "UTF-8"); 
				bab305=URLDecoder.decode(bab305, "UTF-8"); 
				personBaseInfoForm.setAac003(aac003);
				personBaseInfoForm.setAac004(aac004);
				personBaseInfoForm.setAac005(aac005);
				personBaseInfoForm.setAac006(date);
				personBaseInfoForm.setBab305(bab305);
				return modelAndView.addObject("personBaseInfoForm",personBaseInfoForm).addObject("cardId",1L);
			}else{
				Long aac001=personBaseInfo.getAac001();
				//家庭关系信息查询
				PersonFamily personFamily=personFamilyService.getByFaPersonId(aac001);
				//个人扩展信息查询
				PersonExpand personExpand=personExpandService.getByExpPersonId(aac001);
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
				return modelAndView.addObject("personBaseInfoForm",personBaseInfoForm).addObject("cardId",0L);					
			}
		}
		
	}
	/**
	 * 	查看个人基本信息
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("selctPerson")
	@Action(description="查看个人基本信息")
	public ModelAndView selctPerson(HttpServletRequest request) throws Exception
	{
		Long aac001=RequestUtil.getLong(request,"aac001",0L);
		PersonBaseInfo personBaseInfo=personBaseInfoService.getByIds(aac001);
		PersonBaseInfoForm  personBaseInfoForm=new PersonBaseInfoForm();
		personBaseInfoForm.putModel(personBaseInfo);
		LaborAccomForm  laborAccomForm=new LaborAccomForm();
		LaborAcpostForm  laborAcpostForm=new LaborAcpostForm();
		LaborAcemployedForm  laborAcemployedForm=new LaborAcemployedForm();
		if(personBaseInfo!=null){
			PersonExpand   personExpand   = personExpandService.getByExpPersonId(aac001);
			if(personExpand!=null){
				String acc = personExpand.getExpacc0m();
				if(acc!=null){
					Long acc0m=Long.valueOf(acc);
					if(acc0m==1){
						LaborAccom laborAccom = laborAccomService.getByAac001(aac001);
						laborAccomForm.putModel(laborAccom);
					}else if(acc0m==2){
						LaborAcpost laborAcpost = laborAcpostService.getByAac001(aac001);
						laborAcpostForm.putModel(laborAcpost);
					}else if(acc0m==3){
						LaborAcemployed laborAcemployed = laborAcemployedService.getByAac001(aac001);
						laborAcemployedForm.putModel(laborAcemployed);
					}
				}
				laborAccomForm.setAcc0m(personExpand.getExpacc0m());
			}else{
				laborAccomForm.setAcc0m("0");
			}
		}
		ModelAndView modelAndView= new ModelAndView("/business/laborCollection/laborCollectionDetails.jsp");
		return modelAndView.addObject("personBaseInfoForm",personBaseInfoForm).addObject("laborAccomForm",laborAccomForm)
				.addObject("laborAcemployedForm",laborAcemployedForm).addObject("laborAcpostForm",laborAcpostForm);					
	}
	/**
	 * 	通过身份证号查看个人基本信息
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("cardOne")
	@Action(description="通过身份证号查看个人基本信息")
	public ModelAndView cardOne(HttpServletRequest request) throws Exception
	{
		Long sign=RequestUtil.getLong(request,"sign");
		String aac002=RequestUtil.getString(request,"aac002");
		String cczy06=RequestUtil.getString(request,"cczy06");
		PersonBaseInfo personBaseInfo = personBaseInfoService.getByAac002(aac002);
		PersonBaseInfoForm  personBaseInfoForm=new PersonBaseInfoForm();
		personBaseInfoForm.setAac002(aac002);
		personBaseInfoForm.putModel(personBaseInfo);
		ModelAndView modelAndView= new ModelAndView("/business/person/personBaseInfoEdit.jsp");
			if(personBaseInfo==null){
				Long aac001=RequestUtil.getLong(request,"aac001",0L);
				return modelAndView.addObject("personBaseInfoForm",personBaseInfoForm).addObject("aac001",aac001)
						.addObject("sign",sign).addObject("cardId",1L);					
			}else{
				Long aac001=personBaseInfo.getAac001();
				//家庭关系信息查询
				PersonFamily personFamily=personFamilyService.getByFaPersonId(aac001);
				//个人扩展信息查询
				PersonExpand personExpand=personExpandService.getByExpPersonId(aac001);
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
				personBaseInfoForm.setCczy06(cczy06);
				return modelAndView.addObject("personBaseInfoForm",personBaseInfoForm).addObject("aac001",aac001)
						.addObject("sign",sign).addObject("cardId",0L);					
			}
		
	}
	
	
	
}
