package com.xunfeng.business.person.web;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
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

import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.dictionary.interf.DictionaryServiceInterf;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.interf.PersonJobRegistServiceInter;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonJobRegist;
import com.xunfeng.business.person.web.form.PersonJobRegistForm;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人求职登记表 控制器类
* @author:wanlupeng
* @createDate 2016-08-09 16:47:33 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/person/personJobRegist/")
public class PersonJobRegistController extends BaseController
{
	@Resource
	@Qualifier("personJobRegist")
	private PersonJobRegistServiceInter personJobRegistService;
	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf personBaseInfoService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新个人求职登记表。
	 * @param request
	 * @param response
	 * @param personJobRegistForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新个人求职登记表")
	public void save(HttpServletRequest request, HttpServletResponse response,PersonJobRegistForm personJobRegistForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long acc200=RequestUtil.getLong(request,"acc200");
		    long bca111 = RequestUtil.getLong(request, "bca111");
		    long bcaa11 = RequestUtil.getLong(request, "bcaa11");
		    long bcab11 = RequestUtil.getLong(request, "bcab11");
		    PersonJobRegist personJobRegist = personJobRegistService.getById(acc200);
			personJobRegist=personJobRegistForm.getModel(personJobRegist);
			if(bca111==bcaa11){
				message = new ResultMessage(ResultMessage.Fail, "意愿职位重复，请重新选择1");
			}else if(bca111!=0&&bcab11!=0&&bca111==bcab11){
				message = new ResultMessage(ResultMessage.Fail, "意愿职位重复，请重新选择1");
			}else if(bca111!=0&&bcaa11!=0&&bca111==bcaa11){
				message = new ResultMessage(ResultMessage.Fail, "意愿职位重复，请重新选择1");
			}else if(bcab11!=0&&bcaa11!=0&&bcab11==bcaa11){
				message = new ResultMessage(ResultMessage.Fail, "意愿职位重复，请重新选择1");
			}else{
				if(personJobRegistForm.isMvcAdd()){
					resultMsg="添加个人求职登记表";
					Calendar cal = Calendar.getInstance();
		            cal.add(cal.MONTH, 1);
		            SimpleDateFormat dft = new SimpleDateFormat("yyyy/MM/DD");
		            String preMonth = dft.format(cal.getTime());
		            //personJobRegist.setAcc200(uniqueIdUtil.genSeqId(SqeIdName.PersonJobRegist.getSeqName()));
		            personJobRegist.setAcc200(uniqueIdUtil.genId(PersonJobRegist.class.getName()));
					personJobRegist.setAcb208("0");
					personJobRegist.setCcpr08("0");
					personJobRegist.setAac0d0(1L);
					personJobRegist.setAac0b0(1L);
					personJobRegist.setAae043(new Date());
					personJobRegist.setAce014(dft.parse(preMonth));
					personJobRegist.setAcb210(1L);
					personJobRegist.setAbb561("1");
					personJobRegist.setAbb771(new Date());
					personJobRegist.setAbb773("1");
					personJobRegist.setCcpr03(new Date());
					personJobRegist.setCcpr05(new Date());
					personJobRegist.setCcpr06(ContextUtil.getCurrentUser().getAac003());
					personJobRegistService.add(personJobRegist);
				}else{
					resultMsg="更新个人求职登记表";
					PersonJobRegist regist = personJobRegistService.getById(acc200);
					personJobRegist.setCcpr03(new Date());
					personJobRegist.setCcpr05(new Date());
					personJobRegist.setCcpr06(ContextUtil.getCurrentUser().getAac003());
					personJobRegist.setBcb209(regist.getBcb209());
					personJobRegistService.update(personJobRegist);
					
				}
				message=new ResultMessage(ResultMessage.Success, resultMsg+"成功！"+personJobRegist.getAac001());
			}

			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	/**
	 * 取得个人求职登记表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personJobRegist/jobRegist/personJobRegistList.jsp");
		
		return mv;
	}
	/**
	 * 取得个人求职登记表分页列表
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
		ResultData<PersonJobRegist> resultData=personJobRegistService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除个人求职登记表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除个人求职登记表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "acc200");
			personJobRegistService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除个人求职登记表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增个人求职登记表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增个人求职登记表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		Long aac001=RequestUtil.getLong(request,"aac001");
		String sign=RequestUtil.getString(request,"sign","");
		PersonBaseInfo person = personBaseInfoService.getByIds(aac001);
		PersonJobRegistForm  personJobRegistForm=new PersonJobRegistForm();
		personJobRegistForm.putModel(null);
		//ACC20Q 发布范围
		DictionaryServiceInterf dictionaryService=(DictionaryServiceInterf)AppUtil.getBean("dictionary");
		List<Map<String ,Object>> dictionarys =dictionaryService.getTabList(SystemConst.TAB_INFOPUBPAT, null);
		personJobRegistForm.setAae011(String.valueOf(ContextUtil.getCurrentUser().getAcd230()));
		personJobRegistForm.setAae017(ContextUtil.getCurrentUserDept()==null?"":String.valueOf(ContextUtil.getCurrentUserDept().getDep001()));
		personJobRegistForm.setAae019(ContextUtil.getCurrentUser().getAac003());
		personJobRegistForm.setAae020(ContextUtil.getCurrentUserOrg()==null?"":ContextUtil.getCurrentUserOrg().getAcd202());
		personJobRegistForm.setAae036(new Date());
		ModelAndView modelAndView= new ModelAndView("/business/person/jobRegist/personJobRegistEdit.jsp");
		
		return modelAndView.addObject("personJobRegistForm",personJobRegistForm).addObject("personForm",person)
				.addObject("dictionarys",dictionarys).addObject("aac001",aac001).addObject("sign",sign);					
	}
	/**
	 * 	编辑个人求职登记表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑个人求职登记表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long aac001=RequestUtil.getLong(request,"aac001");
		String sign=RequestUtil.getString(request,"sign","");
		String cczy06=RequestUtil.getString(request,"cczy06");
		PersonBaseInfo person = personBaseInfoService.getByIds(aac001);
		PersonJobRegist personJobRegist=personJobRegistService.getByPersonId(aac001);//查询有效的求职登记信息
		PersonJobRegistForm  personJobRegistForm=new PersonJobRegistForm();
		//ACC20Q 发布范围
		DictionaryServiceInterf dictionaryService=(DictionaryServiceInterf)AppUtil.getBean("dictionary");
		List<Map<String ,Object>> dictionarys =dictionaryService.getTabList(SystemConst.TAB_INFOPUBPAT, null);
		personJobRegistForm.putModel(personJobRegist);
		if(personJobRegist==null){
			personJobRegistForm.setAae011(String.valueOf(ContextUtil.getCurrentUser().getAcd230()));
			personJobRegistForm.setAae017(ContextUtil.getCurrentUserDept()==null?"":String.valueOf(ContextUtil.getCurrentUserDept().getDep001()));
			personJobRegistForm.setAae019(ContextUtil.getCurrentUser().getAac003());
			personJobRegistForm.setAae020(ContextUtil.getCurrentUserOrg()==null?"":ContextUtil.getCurrentUserOrg().getAcd202());
			personJobRegistForm.setAae036(new Date());
		}else{
			if(!StringUtil.isEmpty(personJobRegist.getAcc20q())){
				List<String> cos  = Arrays.asList(personJobRegist.getAcc20q().split(","));
				for (Map<String, Object> map : dictionarys) {
					if(cos.contains(map.get("CODE").toString())){
						map.put("CHECKED", true);	
					}
				}
			}
		}
		ModelAndView modelAndView= new ModelAndView("/business/person/jobRegist/personJobRegistEdit.jsp");
		return modelAndView.addObject("personJobRegistForm",personJobRegistForm).addObject("personForm",person)
				.addObject("sign",sign).addObject("cczy06",cczy06).addObject("aac001",aac001).addObject("listForm",dictionarys);					
	}

	/**
	 * 取得个人求职登记表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看个人求职登记表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long acc200=RequestUtil.getLong(request,"acc200");
		PersonJobRegist personJobRegist = personJobRegistService.getById(acc200);	
		return getAutoView().addObject("personJobRegist", personJobRegist);
	}
	/**
	 * 求职信息判重
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("isExist")
	@Action(description = "判断该求职信息是否已发布该工种信息")
	@ResponseBody
	public ResultMessage isExist(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ResultMessage resultMessage = null;
		try {
			long bca111 = RequestUtil.getLong(request, "bca111");
			long bcaa11 = RequestUtil.getLong(request, "bcaa11");
			long bcab11 = RequestUtil.getLong(request, "bcab11");
			if(bca111==bcaa11){
				resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			}else if(bca111!=0&&bcab11!=0&&bca111==bcab11){
				resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			}else if(bca111!=0&&bcaa11!=0&&bca111==bcaa11){
				resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			}else if(bcab11!=0&&bcaa11!=0&&bcab11==bcaa11){
				resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			}else{
				resultMessage = new ResultMessage(ResultMessage.Fail, "不存在");
			}
		} catch (Exception ex) {
			resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return resultMessage;
	}
	/**
	 * 查询有效的求职信息是否已存在
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("inspect")
	@Action(description = "查询有效的求职信息是否已存在")
	@ResponseBody
	public ResultMessage inspect(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ResultMessage resultMessage = null;
		try {
			long aac001 = RequestUtil.getLong(request, "aac001");
			PersonJobRegist personJobRegist=personJobRegistService.getByPersonId(aac001);//查询有效的求职登记信息
			if (personJobRegist != null ) {
				resultMessage = new ResultMessage(ResultMessage.Success, "本人存在有效求职信息，是否修改？");
			} else {
				resultMessage = new ResultMessage(ResultMessage.Fail, "");
			}
		} catch (Exception ex) {
			resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return resultMessage;
	}
	
}
