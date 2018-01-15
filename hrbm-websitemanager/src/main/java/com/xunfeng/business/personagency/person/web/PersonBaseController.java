package com.xunfeng.business.personagency.person.web;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.interf.PersonExpandServiceInterf;
import com.xunfeng.business.person.interf.PersonFamilyServiceInterf;
import com.xunfeng.business.person.interf.PersonJobRegistServiceInter;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.personagency.person.dto.AgencyPersonExpandDto;
import com.xunfeng.business.personagency.person.interf.AgencyPersonExpandServiceInterf;
import com.xunfeng.business.personagency.person.web.form.AgencyPersonExpandForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.FileWebDavUtil;
import com.xunfeng.core.util.ImgHelper;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.accounts.interf.AccountsServiceInter;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人基本信息表 控制器类
* @author:wanlupeng
* @createDate 2016-06-27 17:44:37 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/person/personBaseInfo/")
public class PersonBaseController extends BaseController
{

	@Resource
	@Qualifier("agencyPersonExpand")
	private AgencyPersonExpandServiceInterf agencyPersonExpandService;
	
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
	public void save(HttpServletRequest request, HttpServletResponse response,
			AgencyPersonExpandForm personExpandForm) throws Exception
	{
		String resultMsg="保存";	
		ResultMessage message=null;	
		try{
			Long aac001=RequestUtil.getLong(request,"aac001");
			PersonBaseInfo personBaseInfo=personBaseInfoService.getById(aac001);
			AgencyPersonExpandDto expandDto=new  AgencyPersonExpandDto();
			expandDto=BeanToBean.copyProperties(personExpandForm, expandDto);
			String ccmu61 = this.fileUpload(personExpandForm.getCcmu61());
			if(personBaseInfo==null){
				resultMsg="新增";	
				expandDto.setCcmu61(ccmu61);
				agencyPersonExpandService.addPersonExpand(expandDto);
			}else{
			    resultMsg="修改";	
			    agencyPersonExpandService.updatePersonExpand(expandDto);
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"个人基本信息成功!");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"个人基本信息失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}

@RequestMapping("index")
@Action(description="新增个人基本信息表") 
public ModelAndView index(HttpServletRequest request) throws Exception
{
	ModelAndView modelAndView= new ModelAndView("/business/personagency/person/personBaseInfoIndex.jsp");

	return modelAndView	;			
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
		AgencyPersonExpandForm  agencyPersonExpandForm=new AgencyPersonExpandForm();
		agencyPersonExpandForm.setMvcMethod("add");
		agencyPersonExpandForm.setAac001(uniqueIdUtil.genId(PersonBaseInfo.class.getName()));
		ModelAndView modelAndView= new ModelAndView("/business/personagency/person/personBaseInfoEdit.jsp");
		agencyPersonExpandForm.setAae019(ContextUtil.getCurrentUser().getAac003());
		agencyPersonExpandForm.setAae020(ContextUtil.getCurrentUserOrg()==null?"":ContextUtil.getCurrentUserOrg().getAcd202());
		agencyPersonExpandForm.setAae036(new Date());
		agencyPersonExpandForm.setCczy06(cczy06);
		return modelAndView.addObject("personBaseInfoForm",agencyPersonExpandForm);					
	}

	/**
	 * 	编辑个人基本信息表(根据身份证号查询)
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑个人基本信息表(根据身份证号查询)")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
//		String aac002=RequestUtil.getString(request,"aac002");
//		PersonBaseInfo personBaseInfo=personBaseInfoService.getByAac002(aac002);
		String cczy06=RequestUtil.getString(request,"cczy06");
		Long aac001=RequestUtil.getLong(request,"aac001",0L);
		AgencyPersonExpandDto agencyPersonExpandDto=agencyPersonExpandService.getPersonExpandById(aac001);
		AgencyPersonExpandForm  agencyPersonExpandForm=new AgencyPersonExpandForm();
		agencyPersonExpandForm=BeanToBean.copyProperties(agencyPersonExpandDto, agencyPersonExpandForm);
		agencyPersonExpandForm.setMvcMethod("edit");
		ModelAndView modelAndView= new ModelAndView("/business/personagency/person/personBaseInfoEdit.jsp");
		return modelAndView.addObject("personBaseInfoForm",agencyPersonExpandForm);
	}
	
	
	//传入Base64方式编码的字符串上传文件到服务器并且返回路径
	public String fileUpload(String encodeStr) throws Exception {
		String filePath = null;
		if(StringUtils.isNotEmpty(encodeStr)){
			InputStream fis = ImgHelper.decodeIo(encodeStr);
			filePath = FileWebDavUtil.uploadFile(1l, String.valueOf(uniqueIdUtil.genId(""))+".png", fis);
		}
		return filePath;
	}
}
