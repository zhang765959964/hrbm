package com.xunfeng.business.personagency.affair.web;

import java.util.ArrayList;
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
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.dictionary.interf.DictionaryServiceInterf;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.personagency.affair.model.ExaminationRegister;
import com.xunfeng.business.personagency.affair.web.form.ExaminationRegisterForm;
import com.xunfeng.business.personagency.affair.interf.ExaminationRegisterServiceInterf;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.model.Archives;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 考试报名登记表 控制器类
* @author:jiangxin
* @createDate 2016-09-20 10:13:34 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/affair/examinationRegister/")
public class ExaminationRegisterController extends BaseController
{
	@Resource
	@Qualifier("examinationRegister")
	private ExaminationRegisterServiceInterf examinationRegisterService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("dictionary")
	private DictionaryServiceInterf dictionaryService;
	
	/**
	 * 添加或更新考试报名登记表。
	 * @param request
	 * @param response
	 * @param examinationRegisterForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新考试报名登记表")
	public void save(HttpServletRequest request, HttpServletResponse response,ExaminationRegisterForm examinationRegisterForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    ExaminationRegister examinationRegister = examinationRegisterService.getById(id);
			examinationRegister=examinationRegisterForm.getModel(examinationRegister);
			if(examinationRegisterForm.isMvcAdd()){
				resultMsg="添加考试报名登记信息";
				examinationRegister.setId(uniqueIdUtil.genId(ExaminationRegister.class.getName()));
				examinationRegisterService.add(examinationRegister);
			}else{
				resultMsg="修改考试报名登记信息";
			    examinationRegisterService.update(examinationRegister);
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
	 * 取得考试报名登记表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/affair/examinationRegisterList.jsp");
		return mv;
	}
	//考试报名查询
	@RequestMapping("search")
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/affair/examinationRegisterSearch.jsp");
		return mv;
	}
	/**
	 * 取得考试报名登记表分页列表
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
		if("9".equals(fiter.getFilters().get("aac004"))){
			fiter.getFilters().remove("aac004");
		}
		ResultData resultData=examinationRegisterService.getAllExaminationRegister(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除考试报名登记表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除考试报名登记表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			examinationRegisterService.deleteExaminationRegisterByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除考试报名登记信息成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增考试报名登记表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增考试报名登记表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		ExaminationRegisterForm  examinationRegisterForm=new ExaminationRegisterForm();
		examinationRegisterForm.putModel(null);
		Long archivesId=RequestUtil.getLong(request,"archivesId",0L);
		Archives archives = archivesService.getById(archivesId);
		if(archives!=null){
			examinationRegisterForm.setPersonId(archives.getPersonId());
		}
		examinationRegisterForm.setCczy06("16");
		examinationRegisterForm.setCcpr08("0");
		examinationRegisterForm.setArchivesId(archivesId);
		initCreater(examinationRegisterForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/affair/examinationRegisterEdit.jsp");
		return modelAndView.addObject("examinationRegisterForm",examinationRegisterForm);					
	}
	/**
	 * 	编辑考试报名登记表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑考试报名登记表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		ExaminationRegister examinationRegister=examinationRegisterService.getById(id);
		ExaminationRegisterForm  examinationRegisterForm=new ExaminationRegisterForm();
		examinationRegisterForm.putModel(examinationRegister);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/affair/examinationRegisterEdit.jsp");
		return modelAndView.addObject("examinationRegisterForm",examinationRegisterForm);					
	}

	/**
	 * 取得考试报名登记表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看考试报名登记表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		ExaminationRegister examinationRegister = examinationRegisterService.getById(id);	
		return getAutoView().addObject("examinationRegister", examinationRegister);
	}
	//查询考试类别（明细）表  rsda_tab_Examination_type
	@RequestMapping("getExamByPid")
	@Action(description="查询考试类别明细表")
	@ResponseBody
	public List<Map<String,Object>> getExamByPid(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		try{
			Long pid = RequestUtil.getLong(request, "pid", 0L);
			String sqlCondi = "";
			if(pid==0L){
				sqlCondi = "pid in(1,2,3,4)";
			}else{
				sqlCondi = "pid in( "+pid+")";
			}
			listMap = dictionaryService.getTabList("RSDA_TAB_EXAMINATION_TYPE", sqlCondi);
		}catch(Exception ex){
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return listMap;
	}
	
	//职称级别表  RSDA_TAB_LEVEL
	@RequestMapping("getLevelByPid")
	@Action(description="查询考试类别明细表")
	@ResponseBody
	public List<Map<String,Object>> getLevelByPid(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		try{
			Long pid = RequestUtil.getLong(request, "pid", 0L);
			String sqlCondi = "";
			if(pid==0L){
				sqlCondi = "pid in(1,2,4)";
			}else{
				if(pid==3L){
					pid = 2l;
				}
				sqlCondi = "pid in( "+pid+")";
			}
			listMap = dictionaryService.getTabList("RSDA_TAB_LEVEL", sqlCondi);
		}catch(Exception ex){
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return listMap;
	}
	
	
}
