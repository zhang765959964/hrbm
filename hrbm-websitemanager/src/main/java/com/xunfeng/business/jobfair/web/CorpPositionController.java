package com.xunfeng.business.jobfair.web;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.config.interf.BaseConfigServiceInterf;
import com.xunfeng.sys.config.model.BaseConfig;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.dictionary.interf.DictionaryServiceInterf;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.business.corp.interf.CorpPositionPublishServiceInterf;
import com.xunfeng.business.corp.interf.CorpPositionServiceInter;
import com.xunfeng.business.corp.model.CorpPosition;
import com.xunfeng.business.corp.model.CorpPositionPublish;
import com.xunfeng.business.jobfair.web.form.CorpPositionForm;
import com.xunfeng.business.jobfair.web.form.CorpPublicPositionForm;
import com.xunfeng.business.jobfair.web.form.JobReturnMessage;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 招聘空位信息表 控制器类
* @author:wanghan
* @createDate 2015-09-18 15:58:31 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/jobfair/corpPosition/")
public class CorpPositionController extends BaseController
{
	@Resource
	@Qualifier("corpPosition")
	private CorpPositionServiceInter corpPositionService;
	@Resource
	@Qualifier("corpPositionPublish")
	private CorpPositionPublishServiceInterf positionPublishService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;
   	@Resource
   	@Qualifier("baseConfig")
    BaseConfigServiceInterf baseConfig;
	/**
	 * 添加或更新招聘空位信息表。
	 * @param request
	 * @param response
	 * @param corpPositionForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新招聘岗位信息表")
	public void save(HttpServletRequest request, HttpServletResponse response,CorpPositionForm corpPositionForm) throws Exception
	{
		String resultMsg=null;	
		JobReturnMessage message=null;	
		try{
		    Long acb210=RequestUtil.getLong(request,"acb210");
		    CorpPosition corpPosition = corpPositionService.getById(acb210);
			corpPosition=corpPositionForm.getModel(corpPosition);
			String jobId = "";
			BaseConfig jobIsAudit = baseConfig.getConfigByName(SystemConst.KEY_JOB_IS_AUDIT);
			if(SystemConst.STATIC_VALUE_TWO.equals(jobIsAudit.getCaos04())){
//				corpPosition.setAbb561(SystemConst.STATIC_VALUE_ONE);
				corpPosition.setAbb773(SystemConst.STATIC_VALUE_ONE);
				//审核时间
				corpPosition.setAbb771(new Date());
				//审核人
				corpPosition.setAbb769(String.valueOf(ContextUtil.getCurrentUserId()));
				//审核机构
				corpPosition.setAbb770(String.valueOf(ContextUtil.getCurrentUserOrg().getAcd200()));
			}else{
				corpPosition.setAbb773(SystemConst.STATIC_VALUE_ZERO);
			}
			if(corpPositionForm.isMvcAdd()){
				resultMsg="添加招聘信息";
				//设置经办信息
				corpPosition.setUpdatetime(new Date());
				corpPosition.setUpdateBy(ContextUtil.getCurrentUserId());
				corpPosition.setAae011(String.valueOf(ContextUtil.getCurrentUserId()));
				corpPosition.setAae019(ContextUtil.getCurrentUser().getAac003());
				corpPosition.setAae036(new Date());
				corpPosition.setAae020(ContextUtil.getCurrentUserOrg().getAcd202());
				corpPosition.setAae017(String.valueOf(ContextUtil.getCurrentUserOrg().getAcd200()));
				corpPosition.setAcb208(SystemConst.STATIC_VALUE_ZERO);
				corpPosition.setAae036(new Date());
				corpPosition.setAae036(new Date());
				corpPosition.setCcpr05(new Date());
				corpPosition.setCczy06(SystemConst.DATA_SOURCE_BS);
				corpPosition.setAcb210(uniqueIdUtil.genId(CorpPosition.class.getName()));
				//招聘职位开始时间添加
				corpPosition.setAae030(new Date());
				/**
				 * 2016-06-28  增加了招聘职位的结束时间
				 */
				//单位招聘信息有效日期，以天为单位 sys_zp_date
				BaseConfig baseConfigEndDate = baseConfig.getConfigByName("sys_zp_date");
				Date endDate = DateUtil.getDelayDayDateBy(Integer.valueOf(baseConfigEndDate.getCaos04()));
				corpPosition.setAae031(endDate);
				corpPositionService.add(corpPosition);
				jobId = String.valueOf(corpPosition.getAcb210());
			}else{
				resultMsg="更新招聘信息";
			    corpPositionService.update(corpPosition);
			    jobId = String.valueOf(corpPosition.getAcb210());
			}
			message=new JobReturnMessage(ResultMessage.Success, resultMsg+"成功",jobId);
			this.writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new JobReturnMessage(ResultMessage.Fail, resultMsg+"失败","");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	/**
	 * 添加或更新
	 * @param request
	 * @param response
	 * @param corpPositionForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("saveCorpPosition")
	@Action(description="添加或更新招聘信息表")
	public void saveCorpPosition(HttpServletRequest request, HttpServletResponse response,CorpPublicPositionForm corpPublicPositionForm) throws Exception
	{
		String resultMsg=null;	
		JobReturnMessage message=null;	
		
		try{
		    Long acb200=RequestUtil.getLong(request,"acb200");
		    CorpPositionPublish corpPublicPosition = positionPublishService.getById(acb200);
			corpPublicPosition=corpPublicPositionForm.getModel(corpPublicPosition);
			BaseConfig jobIsAudit = baseConfig.getConfigByName(SystemConst.KEY_JOB_IS_AUDIT);
			if(SystemConst.STATIC_VALUE_ONE.equals(jobIsAudit.getCaos04())){
				corpPublicPosition.setAbb561(SystemConst.STATIC_VALUE_ONE);
				//审核时间
				corpPublicPosition.setAbb771(new Date());
				//审核人
				corpPublicPosition.setAbb769(String.valueOf(ContextUtil.getCurrentUserId()));
				//审核机构
				corpPublicPosition.setAbb770(String.valueOf(ContextUtil.getCurrentUserOrg().getAcd200()));
			}else{
				corpPublicPosition.setAbb773(SystemConst.STATIC_VALUE_ZERO);
			}
			String jobId = "";
			if(corpPublicPositionForm.isMvcAdd()){
				//设置经办信息
				corpPublicPosition.setUpdatetime(new Date());
				corpPublicPosition.setUpdateBy(ContextUtil.getCurrentUserId());
				corpPublicPosition.setAae011(String.valueOf(ContextUtil.getCurrentUserId()));
				corpPublicPosition.setAae019(ContextUtil.getCurrentUser().getAac003());
				corpPublicPosition.setAae036(new Date());
				corpPublicPosition.setAae020(ContextUtil.getCurrentUserOrg().getAcd202());
				corpPublicPosition.setAae017(String.valueOf(ContextUtil.getCurrentUserOrg().getAcd200()));
				//暂设置为委托招聘 2 
				corpPublicPosition.setAcb201("2");
				corpPublicPosition.setBcb201("委托招聘");
				corpPublicPosition.setAcb208(SystemConst.STATIC_VALUE_ZERO);
				corpPublicPosition.setAae036(new Date());
				corpPublicPosition.setAae036(new Date());
				corpPublicPosition.setCcpr05(new Date());
				corpPublicPosition.setBcb209(SystemConst.DATA_SOURCE_BS);
				corpPublicPosition.setAcb200(uniqueIdUtil.genId(CorpPositionPublish.class.getName()));
				resultMsg="添加单位招聘信息";
				positionPublishService.add(corpPublicPosition);
				jobId = String.valueOf(corpPublicPosition.getAcb200());
			}else{
				resultMsg="更新单位招聘信息";
				positionPublishService.update(corpPublicPosition);
				jobId = String.valueOf(corpPublicPosition.getAcb200());
			}
			message=new JobReturnMessage(ResultMessage.Success, resultMsg+"成功",jobId);

			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new JobReturnMessage(ResultMessage.Fail, resultMsg+"失败","");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	/**
	 * 取得招聘空位信息表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=this.getAutoView();
		
		return mv;
	}
	/**
	 * 取得招聘空位信息表分页列表
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
		List<CorpPosition> list=corpPositionService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除招聘空位信息表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除招聘空位信息表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "acb210");
			corpPositionService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除招聘空位信息成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 冻结职位信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("freezeCorpPosition")
	@Action(description="冻结职位信息")
	@ResponseBody
	public ResultMessage freezeCorpPosition(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "acb210");
			corpPositionService.freezeCorpPositionCode(lAryId,ContextUtil.getCurrentUser().getCczh01(),request.getParameter("acb20l"));
			message=new ResultMessage(ResultMessage.Success, "职位冻结成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "职位冻结失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 解冻职位信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("delfreezeCorpPosition")
	@Action(description="解结职位信息")
	@ResponseBody
	public ResultMessage delfreezeCorpPosition(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "acb210");
			Accounts loginUser = new Accounts();
			loginUser.setCcmu02(ContextUtil.getCurrentUser().getCczh01());
			corpPositionService.unfreezeCorpPosition(lAryId);
			message=new ResultMessage(ResultMessage.Success, "职位解冻成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "职位解冻失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 	冻结职位页面
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("tofreezeCorpPosition")
	@Action(description="新增招聘空位信息表")
	public ModelAndView tofreezeCorpPosition(HttpServletRequest request) throws Exception
	{
		ModelAndView modelAndView= new ModelAndView("/business/jobfair/freezeCorpPosition.jsp");
		return modelAndView.addObject("cropForm",new CorpPositionForm());					
	}
	
	/**
	 * 	冻结招聘信息
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("tofreezeCorpPublicPosition")
	@Action(description="新增招聘空位信息表")
	public ModelAndView tofreezeCorpPublicPosition(HttpServletRequest request) throws Exception
	{
		ModelAndView modelAndView= new ModelAndView("/business/jobfair/freezeCorpPublicPosition.jsp");
		return modelAndView.addObject("cropForm",new CorpPositionForm());					
	}
	/**
	 * 冻结招聘信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("freezeCorpPublicPosition")
	@Action(description="冻结职位信息")
	@ResponseBody
	public ResultMessage freezeCorpPublicPosition(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "acb200");//
			Map<String,Object> map = new HashMap<String, Object>();
			//冻结原因
			map.put("acb20l", request.getParameter("acb20l"));
			//冻结人员
			map.put("acb20d", ContextUtil.getCurrentUser().getCczh01());
			positionPublishService.freezeCorpPublicPosition(lAryId, map);
			message=new ResultMessage(ResultMessage.Success, "招聘信息冻结成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "招聘信息冻结失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 解冻招聘职位信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("unfreezeCorpPublicPosition")
	@Action(description="冻结职位信息")
	@ResponseBody
	public ResultMessage unfreezeCorpPublicPosition(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "acb200");//
			Map<String,Object> map = new HashMap<String, Object>();
			//冻结人员
			map.put("acb20d", ContextUtil.getCurrentUser().getCczh01());
			positionPublishService.unfreezeCorpPublicPosition(lAryId, map);
			message=new ResultMessage(ResultMessage.Success, "招聘信息解冻成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "招聘信息解冻失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增招聘空位信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增招聘空位信息表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		CorpPositionForm  corpPositionForm=new CorpPositionForm();
		Long acb200=RequestUtil.getLong(request,"acb200");
		CorpPositionPublish corpPublicPosition = positionPublishService.getById(acb200);
		CorpPosition corpPosition = new CorpPosition();
		corpPosition.setAcb200(acb200);
		corpPosition.setAab004(corpPublicPosition.getAab004());
		corpPositionForm.putModel(corpPosition);
		ModelAndView modelAndView= new ModelAndView("/business/jobfair/corpPositionEdit.jsp");
		DictionaryServiceInterf dictionaryService=(DictionaryServiceInterf)AppUtil.getBean("dictionary");
		return modelAndView.addObject("corpPositionForm",corpPositionForm).addObject("acb200", acb200).addObject("acb20qs",dictionaryService.getTabList(SystemConst.TAB_INFOPUBPAT, null));					
	}
	/**
	 * 	新增招聘空位信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("addrecruitment")
	@Action(description="新增招聘信息")
	public ModelAndView addRecruitment(HttpServletRequest request) throws Exception
	{
		CorpPublicPositionForm  corpPublicPositionForm=new CorpPublicPositionForm();
		corpPublicPositionForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/jobfair/corpPublicPositionEdit.jsp");
		/**
		 * 2016-06-28 wyyEdit 增加了招聘信息的开始时间和结束时间
		 */
		corpPublicPositionForm.setAae030(new Date());//开始时间
		//单位招聘信息有效日期，以天为单位 sys_zp_date
		BaseConfig baseConfigEndDate = baseConfig.getConfigByName("sys_zp_date");
		Date endDate = DateUtil.getDelayDayDateBy(Integer.valueOf(baseConfigEndDate.getCaos04()));
		corpPublicPositionForm.setAae031(endDate);//结束时间
		return modelAndView.addObject("corpPublicPositionForm",corpPublicPositionForm);					
	}
	
	/**
	 * 	新增招聘空位信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("editrecruitment")
	@Action(description="新增招聘信息")
	public ModelAndView editRecruitment(HttpServletRequest request) throws Exception
	{
		CorpPublicPositionForm  corpPublicPositionForm=new CorpPublicPositionForm();
	    Long acb200=RequestUtil.getLong(request,"acb200");
	    CorpPositionPublish corpPublicPosition = positionPublishService.getById(acb200);
		corpPublicPositionForm.putModel(corpPublicPosition);
		ModelAndView modelAndView= new ModelAndView("/business/jobfair/corpPublicPositionEdit.jsp");
		return modelAndView.addObject("corpPublicPositionForm",corpPublicPositionForm).addObject("acb210", request.getParameter("acb210"));					
	}

 
	
	/**
	 * 招聘职位信息查询
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("corpPositionList")
	public ModelAndView corpPositionList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{     
		//带操作
		return new ModelAndView("/business/jobfair/corpPositionList.jsp").addObject("orgs", getOrganSelectList()).addObject("isEdit",true);
	}
	
	/**
	 * 招聘职位信息查询
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("corpPositionListView")
	public ModelAndView corpPositionListView(HttpServletRequest request,HttpServletResponse response) throws Exception
	{     
		return new ModelAndView("/business/jobfair/corpPositionList.jsp").addObject("orgs", getOrganSelectList());
	}
	/**
	 * 招聘职位信息查询列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */                                                                                              
	@RequestMapping("corpPositionListJson")
	@Action(description="招聘职位信息分页列表")
	@ResponseBody
	public Map<Object,Object> corpPositionListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
		PageBean pageBean =WrapPageBean(limit, offset);
		fiter.setPageBean(pageBean);
		if(StringUtil.isNotEmpty(request.getParameter("acc214"))){
			fiter.addFilter("acc214", request.getParameter("acc214").split(","));
		}
		ResultData<Map<String,Object>>  resultData =corpPositionService.getCorpPositionViewList(addJurisdiction(fiter));	
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 	编辑招聘空位信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑招聘空位信息表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		CorpPositionForm  corpPositionForm=new CorpPositionForm();
		CorpPosition corpPosition = new CorpPosition();
		if(StringUtil.isEmpty(request.getParameter("acb210"))){
			//新添加发布职位
			Long acb200=RequestUtil.getLong(request,"acb200");
			CorpPositionPublish corpPublicPosition = positionPublishService.getById(acb200);
			corpPosition = new CorpPosition();
			corpPosition.setAcb200(acb200);
			corpPosition.setAab004(corpPublicPosition.getAab004());
			corpPosition.setAab001(corpPublicPosition.getAab001());
			corpPositionForm.putModel(corpPosition);
		}else{
		  //修改发布职位
		  Long acb210=RequestUtil.getLong(request,"acb210",0L);
		  corpPosition=corpPositionService.getById(acb210);
	      corpPositionForm=new CorpPositionForm();
		  corpPositionForm.putModel(corpPosition);
		}
		//ACB20Q 发布范围
		DictionaryServiceInterf dictionaryService=(DictionaryServiceInterf)AppUtil.getBean("dictionary");
		List<Map<String ,Object>> dictionarys =dictionaryService.getTabList(SystemConst.TAB_INFOPUBPAT, null);
		List<String> cos  = StringUtil.isEmpty(corpPosition.getAcb20q())?new ArrayList<String>():Arrays.asList(corpPosition.getAcb20q().split(","));
		for (Map<String, Object> map : dictionarys) {
			if(StringUtil.isEmpty(request.getParameter("acb210"))||cos.contains(map.get("CODE").toString())){
				map.put("CHECKED", true);	
			}
		}
		return getAutoView().addObject("corpPositionForm",corpPositionForm).addObject("acb20qs",dictionarys).addObject("acb200", corpPosition.getAcb200());					
	}
    
	/**
	 * 招聘职位信息查询列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */                                                                                              
	@RequestMapping("editJson")
	@Action(description="招聘职位信息分页列表")
	@ResponseBody
	public CorpPosition editJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		CorpPosition corpPosition = new CorpPosition();
		Long acb210=RequestUtil.getLong(request,"acb210",0L);
		corpPosition=corpPositionService.getById(acb210);
		return corpPosition;
	}
	
	/**
	 * 招聘岗位信息判重
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("isExist")
	@Action(description = "判断该招聘编号是否已发布该工种信息")
	@ResponseBody
	public ResultMessage isExist(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ResultMessage resultMessage = null;
		try {
			Long acb200 = RequestUtil.getLong(request, "acb200");
			Long acb210 = RequestUtil.getLong(request, "acb210");
			Long aab001 = RequestUtil.getLong(request, "aab001");
			Integer count = corpPositionService.getPostionCount(acb200, acb210, aab001, request.getParameter("code"));
			if (count != null && count > 0) {
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
	 * 取得招聘空位信息表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看招聘空位信息表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long acb210=RequestUtil.getLong(request,"acb210");
		CorpPosition corpPosition = corpPositionService.getById(acb210);	
		return getAutoView().addObject("corpPosition", corpPosition);
	}
	
}
