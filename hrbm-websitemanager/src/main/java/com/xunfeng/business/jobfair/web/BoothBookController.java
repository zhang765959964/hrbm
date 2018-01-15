//package com.xunfeng.business.jobfair.web;
//
//import com.xunfeng.business.corp.interf.CorpPositionServiceInter;
//import com.xunfeng.business.corp.interf.CorpServiceInter;
//import com.xunfeng.business.corp.model.Corp;
//import com.xunfeng.business.corp.service.CorpService;
//import com.xunfeng.business.jobfair.interf.JobFairInfoServiceInter;
//import com.xunfeng.business.jobfair.model.BoothBook;
//import com.xunfeng.business.jobfair.model.CorpPosition;
//import com.xunfeng.business.jobfair.model.CorpPositionPublish;
//import com.xunfeng.business.jobfair.model.JobFairInfo;
//import com.xunfeng.business.jobfair.model.Tabnw;
//import com.xunfeng.business.jobfair.service.BoothBookService;
//import com.xunfeng.business.jobfair.service.CorpPositionPublishService;
//import com.xunfeng.business.jobfair.service.CorpPositionService;
//import com.xunfeng.business.jobfair.service.JobFairInfoService;
//import com.xunfeng.business.jobfair.web.form.BoothBookForm;
//import com.xunfeng.business.jobfair.web.form.CorpPositionForm;
//import com.xunfeng.core.annotion.Action;
//import com.xunfeng.core.util.ExceptionUtil;
//import com.xunfeng.core.util.UniqueIdUtil;
//import com.xunfeng.core.web.ResultMessage;
//import com.xunfeng.core.web.controller.BaseController;
//import com.xunfeng.core.web.query.QueryFilter;
//import com.xunfeng.core.web.util.RequestUtil;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
// /** 
//* @company:河南讯丰信息技术有限公司
//* @Description: 摊位预定表 控制器类
//* @author:wanghan
//* @createDate 2015-09-12 15:43:12 
//* @version V1.0   
//*/
//@Controller
//@RequestMapping("/business/jobfair/boothBook/")
//public class BoothBookController extends BaseController
//{
//	@Resource
//	@Qualifier("corp")
//	private BoothBookServiceIn boothBookService;
//
//	@Resource
//	@Qualifier("corp")
//	private JobFairInfoServiceInter jobFairInfoService;
//
//	@Resource
//	@Qualifier("corp")
//	private CorpPositionPublishService   corpPositionPublishService;
//
//	@Resource
//	@Qualifier("corp")
//	private CorpPositionServiceInter corpPositionService;
//	
//	@Resource
//	@Qualifier("corp")
//	private CorpServiceInter corpService;
//	
//	
//	/**
//	 * 添加或更新摊位预定表。
//	 * @param request
//	 * @param response
//	 * @param boothBookForm 添加或更新的实体
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("save")
//	@Action(description="添加或更新摊位预定表")
//	public void save(HttpServletRequest request, HttpServletResponse response,BoothBookForm boothBookForm) throws Exception
//	{
//		String resultMsg=null;	
//		ResultMessage message=null;	
//		
//		try{
//		    Long cczy01=RequestUtil.getLong(request,"cczy01");
//		    BoothBook boothBook = boothBookService.getById(cczy01);
//			boothBook=boothBookForm.getModel(boothBook);
//			if(boothBookForm.isMvcAdd()){
//				resultMsg="添加摊位预定";
//				boothBook.setCczy01(UniqueIdUtil.genId());
//				boothBookService.add(boothBook);
//				
//			}else{
//				resultMsg="更新摊位预定";
//			    boothBookService.update(boothBook);
//				
//			}
//			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
//
//			writeResultMessage(response.getWriter(),message);
//		}catch(Exception ex){
//			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
//			logger.error(ExceptionUtil.getExceptionMessage(ex));
//			writeResultMessage(response.getWriter(),message);
//		}
//	}
//	
//	
//	/**
//	 * 取得摊位预定表分页列表
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("list")
//	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
//	{	
//		ModelAndView mv=this.getAutoView();
//		
//		return mv;
//	}
//	/**
//	 * 岗位信息分页列表
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("listJson1")
//	@Action(description="查看岗位信息表分页列表")
//	@ResponseBody
//	public Map<Object,Object> listJson1(HttpServletRequest request,HttpServletResponse response) throws Exception
//	{	
//		QueryFilter fiter=new QueryFilter(request);
//		List<CorpPosition> list= corpPositionService.getAllBy_ccpr(fiter);
//		return getTableData(fiter.getPageBean().getTotalCount(), list);
//	}
//	/**
//	 * 岗位信息分页列表
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("listJson2")
//	@Action(description="查看岗位信息表分页列表")
//	@ResponseBody
//	public Map<Object,Object> listJson2(HttpServletRequest request,HttpServletResponse response) throws Exception
//	{	
//		QueryFilter fiter=new QueryFilter(request);
//		List<CorpPosition> list= corpPositionService.getAllBy_cb21(fiter);
//		return getTableData(fiter.getPageBean().getTotalCount(), list);
//	}
//	/**
//	 * 岗位信息分页列表
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("listJsonweituo")
//	@Action(description="查看岗位信息表分页列表")
//	@ResponseBody
//	public Map<Object,Object> listJsonweituo(HttpServletRequest request,HttpServletResponse response) throws Exception
//	{	
//		QueryFilter fiter=new QueryFilter(request);
//		List<CorpPosition> list= corpPositionService.getAllBy_weituo(fiter);
//		return getTableData(fiter.getPageBean().getTotalCount(), list);
//	}
//	/**
//	 * 取得摊位预定表分页列表
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("listJson")
//	@Action(description="查看从业人员信息表分页列表")
//	@ResponseBody
//	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
//	{	
//		QueryFilter fiter=new QueryFilter(request);
//		List<CorpPosition> list= corpPositionService.getAllBycb20(fiter);
//		return getTableData(fiter.getPageBean().getTotalCount(), list);
//	}
//	/**
//	 * 删除摊位预定表
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping("del")
//	@Action(description="删除摊位预定表")
//	@ResponseBody
//	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
//	{
//
//		ResultMessage message=null;
//		try{
//			Long[] lAryId =RequestUtil.getLongAryByStr(request, "cczy01");
//			boothBookService.delByIds(lAryId);
//			message=new ResultMessage(ResultMessage.Success, "删除摊位预定成功!");
//		}catch(Exception ex){
//			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
//			logger.error(ExceptionUtil.getExceptionMessage(ex));
//		}
//        return message;
//	}
//	/**
//	 * 岗位审核
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping("approve")
//	@Action(description="审核岗位信息")
//	@ResponseBody
//	public ResultMessage approve(HttpServletRequest request,HttpServletResponse response) throws Exception {ResultMessage message = null;
//	
//			try {
//				Long cczy01 = RequestUtil.getLong(request, "cczy01");
//				Long acb210 = RequestUtil.getLong(request, "acb210");
//				Long approveFlag = RequestUtil.getLong(request, "approveFlag");
//				if (cczy01 == 0) {
//					boothBookService.approve1(acb210, approveFlag);
//				} else {
//					boothBookService.approve(cczy01, acb210, approveFlag);
//				}
//				message = new ResultMessage(ResultMessage.Success, "已审核!");
//
//			} catch (Exception ex) {
//				message = new ResultMessage(ResultMessage.Fail, "审核失败"
//						+ ex.getMessage());
//				logger.error(ExceptionUtil.getExceptionMessage(ex));
//			}
//		
//		return message;
//	}
//	/**
//	 * 场地招聘中招聘会信息审核
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping("approvecb20")
//	@Action(description="审核招聘会信息")
//	@ResponseBody
//	public ResultMessage approvecb20(HttpServletRequest request,HttpServletResponse response) throws Exception {ResultMessage message = null;
//	
//	try {
//		Long cczy01 = RequestUtil.getLong(request, "cczy01");
//		Long acb200 = RequestUtil.getLong(request, "acb200");
//		Long approveFlag = RequestUtil.getLong(request, "approveFlag");
//		if (cczy01 == 0) {
//			boothBookService.approve1(acb200, approveFlag);
//		} else {
//			boothBookService.approvecb20(cczy01, acb200, approveFlag);
//		}
//		message = new ResultMessage(ResultMessage.Success, "已审核!");
//		
//	} catch (Exception ex) {
//		message = new ResultMessage(ResultMessage.Fail, "审核失败"
//				+ ex.getMessage());
//		logger.error(ExceptionUtil.getExceptionMessage(ex));
//	}
//		return message;
//	}
//	/**
//	 * 委托招聘信息审核
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping("approveweituo")
//	@Action(description="委托招聘信息审核")
//	@ResponseBody
//	public ResultMessage approveweituo(HttpServletRequest request,HttpServletResponse response) throws Exception {ResultMessage message = null;
//	
//	try {
//		Long cczy01 = RequestUtil.getLong(request, "cczy01");
//		Long acb210 = RequestUtil.getLong(request, "acb210");
//		Long acb200 = RequestUtil.getLong(request, "acb200");
//		Long approveFlag = RequestUtil.getLong(request, "approveFlag");
//		if (cczy01 == 0) {
//			boothBookService.approveweituo1(acb210,acb200, approveFlag);
//		} else {
//			if(acb200==0){
//				boothBookService.approveweituo(cczy01, acb210, approveFlag);
//			}else{
//				boothBookService.approveweituo(cczy01,acb210, approveFlag);
//			}
//		}
//		message = new ResultMessage(ResultMessage.Success, "已审核!");
//		
//	} catch (Exception ex) {
//		message = new ResultMessage(ResultMessage.Fail, "审核失败"
//				+ ex.getMessage());
//		logger.error(ExceptionUtil.getExceptionMessage(ex));
//	}
//	
//	return message;
//	}
////		/**
////	 * 	新增摊位预定表
////	 * @param request
////	 * @throws Exception
////	 */
////	@RequestMapping("add")
////	@Action(description="新增摊位预定表")
////	public ModelAndView add(HttpServletRequest request) throws Exception
////	{
////		BoothBookForm  boothBookForm=new BoothBookForm();
////		boothBookForm.putModel(null);
////		ModelAndView modelAndView= new ModelAndView("/business/jobfair/boothBookEdit.jsp");
////
////		return modelAndView.addObject("boothBookForm",boothBookForm);
////	}
//	/**
//	 * 	现场招聘中招聘会审核审核页面（cb20）
//	 * @param request
//	 * @throws Exception
//	 */
//	@RequestMapping("edit")
//	@Action(description="招聘会审核")
//	public ModelAndView edit(HttpServletRequest request) throws Exception {
//		Long acb210 = RequestUtil.getLong(request, "acb210", 0L);
//		CorpPosition corpPosition = corpPositionService.getById(acb210);
//		Corp corplist=corpService.getById(corpPosition.getAab001());
//		List<Tabnw> lsts = new ArrayList<Tabnw>();
//		List<Tabnw> lsts1 = new ArrayList<Tabnw>();
//		CorpPositionForm corpPositionForm = new CorpPositionForm();
//		corpPosition.setAab040(corplist.getAab040());
//		corpPositionForm.putModel(corpPosition);
//		String fuLi = corpPositionForm.getAcc214();
//		if(StringUtils.isNotEmpty(fuLi)){
//			String[] list = fuLi.toString().split(","); 
//			for(String acc214:list){
//				Tabnw tab = new Tabnw();
//				List<CorpPosition> wf=corpPositionService.getAllWelfare(acc214);
//				String name=wf.get(0).getName();
//				tab.setWelfare(name);
//				lsts.add(tab);
//			}
//		}else{
//			Tabnw tab = new Tabnw();
//			tab.setWelfare("");
//			lsts.add(tab);
//		}
//		//薪资页面显示
//		String salary=corpPositionForm.getAcc034();
//		if(StringUtils.isNotEmpty(salary)){
//			String[] list1 = salary.toString().split(","); 
//			for(String acc034:list1){
//				List<CorpPosition> sl=corpPositionService.getAllSalary(acc034);
//				Tabnw tab = new Tabnw();
//				String names=sl.get(0).getName();
//				tab.setSalary(names);
//				lsts1.add(tab);
//			}
//		}else{
//			Tabnw tab = new Tabnw();
//			tab.setSalary("");
//			lsts1.add(tab);
//		}
//		BoothBook boothBook = boothBookService.getBoothBookByRecruitCode(corpPosition.getAcb200());
//		List<CorpPositionPublish> corpPositionPublish = corpPositionPublishService.getBy_Corp(corpPosition.getAcb200());
//		CorpPositionPublish corp=corpPositionPublish.get(0);
//		corp.setAcb206(corplist.getAcb206());
//		JobFairInfo jobFairInfo = null;
//		if (boothBook != null) { 
//			jobFairInfo = jobFairInfoService.getById(boothBook.getAcb330());
//		}
//		return getAutoView().addObject("jobFairInfo", jobFairInfo).addObject("boothBook", boothBook)
//				.addObject("corpPositionPublish", corp).addObject("welfare", lsts).addObject("salary", lsts1);
//	}
//	/**
//	 * 	现场招聘中岗位审核审核页面（cb21）
//	 * @param request
//	 * @throws Exception
//	 */
//	@RequestMapping("edit1")
//	@Action(description="岗位审核")
//	public String edit1(HttpServletRequest request, Model model) throws Exception {
//		Long acb210 = RequestUtil.getLong(request, "acb210", 0L);
//		CorpPosition corpPosition = corpPositionService.getById(acb210);
//		Corp corplist=corpService.getById(corpPosition.getAab001());
//		List<Tabnw> lsts = new ArrayList<Tabnw>();
//		List<Tabnw> lsts1 = new ArrayList<Tabnw>();
//		List<Tabnw> lsts2 = new ArrayList<Tabnw>();
//		List<Tabnw> lsts3 = new ArrayList<Tabnw>();
//		List<Tabnw> lsts4 = new ArrayList<Tabnw>();
//		CorpPositionForm corpPositionForm = new CorpPositionForm();
//		corpPosition.setAab040(corplist.getAab040());
//		corpPositionForm.putModel(corpPosition);
//		String fuLi = corpPositionForm.getAcc214();
//		if(StringUtils.isNotEmpty(fuLi)){
//			String[] list = fuLi.toString().split(","); 
//			for(String acc214:list){
//				Tabnw tab = new Tabnw();
//				List<CorpPosition> wf=corpPositionService.getAllWelfare(acc214);
//				String name=wf.get(0).getName();
//				tab.setWelfare(name);
//				lsts.add(tab);
//			}
//		}else{
//			Tabnw tab = new Tabnw();
//			tab.setWelfare("");
//			lsts.add(tab);
//		}
//		//薪资页面显示
//		String salary=corpPositionForm.getAcc034();
//		if(StringUtils.isNotEmpty(salary)){
//			String[] list1 = salary.toString().split(","); 
//			for(String acc034:list1){
//				List<CorpPosition> sl=corpPositionService.getAllSalary(acc034);
//				Tabnw tab = new Tabnw();
//				String names=sl.get(0).getName();
//				tab.setSalary(names);
//				lsts1.add(tab);
//			}
//		}else{
//			Tabnw tab = new Tabnw();
//			tab.setSalary("");
//			lsts1.add(tab);
//		}
//		//学历页面显示
//		String Education=corpPositionForm.getAac011();
//		if(StringUtils.isNotEmpty(Education)){
//			String[] le = Education.toString().split(","); 
//			for(String aac011:le){
//				List<CorpPosition> sl=corpPositionService.getAllEducation(aac011);
//				Tabnw tab = new Tabnw();
//				String names=sl.get(0).getName();
//				tab.setEducation(names);
//				lsts2.add(tab);
//			}
//		}else{
//			Tabnw tab = new Tabnw();
//			tab.setSalary("");
//			lsts2.add(tab);
//		}
//		//工作性质页面显示
//		String nature=corpPositionForm.getAcb21i();
//		if(StringUtils.isNotEmpty(nature)){
//			String[] list = nature.toString().split(","); 
//			for(String acb21i:list){
//				List<CorpPosition> sl=corpPositionService.getAllNature(acb21i);
//				Tabnw tab = new Tabnw();
//				String names=sl.get(0).getName();
//				tab.setNature(names);
//				lsts3.add(tab);
//			}
//		}else{
//			Tabnw tab = new Tabnw();
//			tab.setSalary("");
//			lsts3.add(tab);
//		}
//		//工作经验页面显示
//		String workyears=corpPositionForm.getAcc217();
//		if(StringUtils.isNotEmpty(workyears)){
//			String[] list = workyears.toString().split(","); 
//			for(String acc217:list){
//				List<CorpPosition> sl=corpPositionService.getAllWorkyears(acc217);
//				Tabnw tab = new Tabnw();
//				String names=sl.get(0).getName();
//				tab.setWorkyears(names);
//				lsts4.add(tab);
//			}
//		}else{
//			Tabnw tab = new Tabnw();
//			tab.setSalary("");
//			lsts4.add(tab);
//		}
//		BoothBook boothBook = boothBookService.getBoothBookByRecruitCode(corpPosition.getAcb200());
//		JobFairInfo jobFairInfo = null;
//		if (boothBook != null) { 
//			jobFairInfo = jobFairInfoService.getById(boothBook.getAcb330());
//		}
//		List<CorpPositionPublish> corpPositionPublish = corpPositionPublishService.getBy_Corp(corpPosition.getAcb200());
//		if(corpPositionPublish.size()==1){
//			CorpPositionPublish corp=corpPositionPublish.get(0);
//			corp.setAcb206(corplist.getAcb206());
//			model.addAttribute("corpPositionPublish",corp);
//		}else{
//			new RuntimeException("无法获取数据");
//		}
//		
//		model.addAttribute("jobFairInfo", jobFairInfo);
//		model.addAttribute("boothBook", boothBook);
//		model.addAttribute("corpPositionForm",corpPositionForm);
//		model.addAttribute("welfare",lsts);
//		model.addAttribute("salary",lsts1);
//		model.addAttribute("education",lsts2);
//		model.addAttribute("nature",lsts3);
//		model.addAttribute("workyear",lsts4);
//		return "/business/jobfair/boothBookselect.jsp";
//	}
//	/**
//	 * 	委托招聘审核页面（cb21）
//	 * @param request
//	 * @throws Exception
//	 */
//	@RequestMapping("editweituo")
//	@Action(description="委托招聘审核页面")
//	public String editweituo(HttpServletRequest request, Model model) throws Exception {
//		Long acb210 = RequestUtil.getLong(request, "acb210", 0L);
//		CorpPosition corpPosition = corpPositionService.getById(acb210);
//		Corp corplist=corpService.getById(corpPosition.getAab001());
//		List<Tabnw> lsts = new ArrayList<Tabnw>();
//		List<Tabnw> lsts1 = new ArrayList<Tabnw>();
//		List<Tabnw> lsts2 = new ArrayList<Tabnw>();
//		List<Tabnw> lsts3 = new ArrayList<Tabnw>();
//		List<Tabnw> lsts4 = new ArrayList<Tabnw>();
//		CorpPositionForm corpPositionForm = new CorpPositionForm();
//		corpPosition.setAab040(corplist.getAab040());
//		corpPositionForm.putModel(corpPosition);
//		String fuLi = corpPositionForm.getAcc214();
//		if(StringUtils.isNotEmpty(fuLi)){
//			String[] list = fuLi.toString().split(","); 
//			for(String acc214:list){
//				Tabnw tab = new Tabnw();
//				List<CorpPosition> wf=corpPositionService.getAllWelfare(acc214);
//				String name=wf.get(0).getName();
//				tab.setWelfare(name);
//				lsts.add(tab);
//			}
//		}else{
//			Tabnw tab = new Tabnw();
//			tab.setWelfare("");
//			lsts.add(tab);
//		}
//		//薪资页面显示
//		String salary=corpPositionForm.getAcc034();
//		if(StringUtils.isNotEmpty(salary)){
//			String[] list1 = salary.toString().split(","); 
//			for(String acc034:list1){
//				List<CorpPosition> sl=corpPositionService.getAllSalary(acc034);
//				Tabnw tab = new Tabnw();
//				String names=sl.get(0).getName();
//				tab.setSalary(names);
//				lsts1.add(tab);
//			}
//		}else{
//			Tabnw tab = new Tabnw();
//			tab.setSalary("");
//			lsts1.add(tab);
//		}
//		//学历页面显示
//		String Education=corpPositionForm.getAac011();
//		if(StringUtils.isNotEmpty(Education)){
//				String[] le = Education.toString().split(","); 
//				for(String aac011:le){
//						List<CorpPosition> sl=corpPositionService.getAllEducation(aac011);
//						Tabnw tab = new Tabnw();
//						String names=sl.get(0).getName();
//						tab.setEducation(names);
//						lsts2.add(tab);
//					}
//			}else{
//					Tabnw tab = new Tabnw();
//					tab.setSalary("");
//					lsts2.add(tab);
//			}
//		//工作性质页面显示
//		String nature=corpPositionForm.getAcb21i();
//			if(StringUtils.isNotEmpty(nature)){
//				String[] list = nature.toString().split(","); 
//					for(String acb21i:list){
//						List<CorpPosition> sl=corpPositionService.getAllNature(acb21i);
//						Tabnw tab = new Tabnw();
//						String names=sl.get(0).getName();
//						tab.setNature(names);
//						lsts3.add(tab);
//					}
//			}else{
//					Tabnw tab = new Tabnw();
//					tab.setSalary("");
//					lsts3.add(tab);
//			}
//		//工作经验页面显示
//		String workyears=corpPositionForm.getAcc217();
//		if(StringUtils.isNotEmpty(workyears)){
//					String[] list = workyears.toString().split(","); 
//					for(String acc217:list){
//						List<CorpPosition> sl=corpPositionService.getAllWorkyears(acc217);
//						Tabnw tab = new Tabnw();
//						String names=sl.get(0).getName();
//						tab.setWorkyears(names);
//						lsts4.add(tab);
//					}
//			}else{
//					Tabnw tab = new Tabnw();
//					tab.setSalary("");
//					lsts4.add(tab);
//			}		
//		BoothBook boothBook = boothBookService.getBoothBookByRecruitCode(corpPosition.getAcb200());
//		List<CorpPositionPublish> corpPositionPublish = corpPositionPublishService.getBy_Corp(corpPosition.getAcb200());
//		if(corpPositionPublish.size()==1){
//			CorpPositionPublish corp=corpPositionPublish.get(0);
//			corp.setAcb206(corplist.getAcb206());
//			model.addAttribute("corpPositionPublish",corp);
//		}else{
//			new RuntimeException("无法获取数据");
//		}
//		JobFairInfo jobFairInfo = null;
//		if (boothBook != null) { 
//			jobFairInfo = jobFairInfoService.getById(boothBook.getAcb330());
//			model.addAttribute("jobFairInfo", jobFairInfo);
//		}
//		model.addAttribute("boothBook", boothBook);
//		model.addAttribute("corpPositionForm",corpPositionForm);
//		model.addAttribute("welfare",lsts);
//		model.addAttribute("salary",lsts1);
//		model.addAttribute("education",lsts2);
//		model.addAttribute("nature",lsts3);
//		model.addAttribute("workyear",lsts4);
//		return "/business/weituo/boothBookEdit.jsp";
//	}
//	/**
//	 * 	批量审核招聘信息
//	 * @param request
//	 * @return 
//	 * @throws Exception
//	 */
//	@RequestMapping("approveall")
//	@Action(description="批量审核")
//	@ResponseBody
//	public ResultMessage approveall(HttpServletRequest request, HttpServletResponse response) throws Exception
//	{
//		ResultMessage message=null;
//		try{
//			Long[] acb210 =RequestUtil.getLongAryByStr(request, "acb");
//			for(int i = 0; i < acb210.length; i++){
//				Long acb2 = Long.parseLong(acb210[i].toString());
//				CorpPosition corpPosition = corpPositionService.getById(acb2);
//				Long acb200= corpPosition.getAcb200();
//				List<BoothBook> boothBook = boothBookService.getByAcb(corpPosition.getAcb200());
//				Long cczy01 = boothBook.get(0).getCczy01();
//				Long approveFlag = RequestUtil.getLong(request, "approveFlag");		
//				if(cczy01==0){
//					boothBookService.approveacb200(acb200, approveFlag);
//				}else{
//					boothBookService.approvecb20(cczy01, acb200, approveFlag);
//				}
//			}		
//			message=new ResultMessage(ResultMessage.Success, "已审核!");
//		}catch(Exception ex){
//			message=new ResultMessage(ResultMessage.Fail, "审核失败" + ex.getMessage());
//			logger.error(ExceptionUtil.getExceptionMessage(ex));
//		}
//		return  message;
//	}
//	/**
//	 * 	批量审核岗位信息
//	 * @param request
//	 * @return 
//	 * @throws Exception
//	 */
//	@RequestMapping("approveallcb21")
//	@Action(description="批量审核")
//	@ResponseBody
//	public ResultMessage approveallcb21(HttpServletRequest request, HttpServletResponse response) throws Exception
//	{
//		ResultMessage message=null;
//		
//		try{
//			Long[] acb21 =RequestUtil.getLongAryByStr(request, "acb");
//			for(int i = 0; i < acb21.length; i++){
//				Long acb210 = Long.parseLong(acb21[i].toString());
//				CorpPosition corpPosition = corpPositionService.getById(acb210);
//				long acb200 = corpPosition.getAcb200();
//				List<BoothBook> boothBook = boothBookService.getByAcb(acb200);
//				if(boothBook.size()==0){
//					Long approveFlag = RequestUtil.getLong(request, "approveFlag");		
//					boothBookService.approve1(acb210, approveFlag);
//				}else{
//					Long cczy01 = boothBook.get(0).getCczy01();
//					Long approveFlag = RequestUtil.getLong(request, "approveFlag");		
//					if(cczy01==0){
//						boothBookService.approve1(acb210, approveFlag);
//					}else{
//						boothBookService.approveweituo2(cczy01, acb210, acb200,approveFlag);
//					}
//				}
//				
//			}		
//			message=new ResultMessage(ResultMessage.Success, "已审核!");
//		}catch(Exception ex){
//			message=new ResultMessage(ResultMessage.Fail, "审核失败" + ex.getMessage());
//			logger.error(ExceptionUtil.getExceptionMessage(ex));
//		}
//		return  message;
//	}
//
//	
//	/**
//	 * 取得摊位预定表明细
//	 * @param request   
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("get")
//	@Action(description="查看摊位预定表明细")
//	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
//	{
//		Long cczy01=RequestUtil.getLong(request,"cczy01");
//		BoothBook boothBook = boothBookService.getById(cczy01);	
//		return getAutoView().addObject("boothBook", boothBook);
//	}
//	
//}
