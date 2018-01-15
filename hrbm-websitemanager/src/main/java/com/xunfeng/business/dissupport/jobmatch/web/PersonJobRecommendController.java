package com.xunfeng.business.dissupport.jobmatch.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.dissupport.jobmatch.model.PersonJobRecommend;
import com.xunfeng.business.dissupport.jobmatch.web.form.PersonJobRecommendForm;
import com.xunfeng.business.dissupport.jobmatch.web.form.RecommendResultMessage;
import com.xunfeng.business.dissupport.jobmatch.interf.PersonJobRecommendServiceInterf;
import com.xunfeng.business.person.interf.PersonJobRegistServiceInter;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 求职推荐匹配表 控制器类
 * @author:wanghan
 * @createDate 2016-08-15 20:00:42
 * @version V1.0
 */
@Controller
@RequestMapping("/business/dissupport/jobmatch/personJobRecommend/")
public class PersonJobRecommendController extends BaseController {

	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;

	@Resource
	@Qualifier("personJobRecommend")
	private PersonJobRecommendServiceInterf personJobRecommendService;

	@Resource
	@Qualifier("personJobRegist")
	private PersonJobRegistServiceInter personJobRegistService;

	/**
	 * 添加或更新求职推荐匹配表。
	 * 
	 * @param request
	 * @param response
	 * @param personJobRecommendForm
	 *            添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description = "添加或更新求职推荐匹配表")
	public void save(HttpServletRequest request, HttpServletResponse response,
			PersonJobRecommendForm personJobRecommendForm) throws Exception {
		String resultMsg = null;
		RecommendResultMessage message = null;

		try {
			Long acc220 = RequestUtil.getLong(request, "acc220");
			PersonJobRecommend personJobRecommend = personJobRecommendService
					.getById(acc220);
			personJobRecommend = personJobRecommendForm
					.getModel(personJobRecommend);
			if (personJobRecommendForm.isMvcAdd()) {
				personJobRecommend.setIsmessge(request
						.getParameter("ismessage"));
				resultMsg = "保存";
				personJobRecommend.setAcc220(personJobRecommendService
						.getMaxId() + 1);
				personJobRecommend.setAcc221(String.valueOf(personJobRecommend
						.getAcc220()));
				personJobRecommend.setBcc229(SystemConst.DATA_SOURCE_BS);
				personJobRecommend.setCcpr08(SystemConst.STATIC_VALUE_ZERO);
				personJobRecommendService.add(personJobRecommend);

			} else {
				resultMsg = "修改";
				personJobRecommendService.update(personJobRecommend);

			}
			message = new RecommendResultMessage(ResultMessage.Success,
					resultMsg + "成功", DateUtil.getformatterCurrentDate(
							"yyyyMMdd").concat(personJobRecommend.getAcc221()));

			writeResultMessage(response.getWriter(), message);
		} catch (Exception ex) {
			message = new RecommendResultMessage(ResultMessage.Fail, resultMsg
					+ "失败", null);
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(), message);
		}
	}

	//
	// /**
	// * 取得求职推荐匹配表分页列表
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// @RequestMapping("list")
	// public ModelAndView list(HttpServletRequest request,HttpServletResponse
	// response) throws Exception
	// {
	// ModelAndView mv= new
	// ModelAndView("/business/dissupport/jobmatch/personJobRecommendList.jsp");
	//
	// return mv;
	// }
	// /**
	// * 取得求职推荐匹配表分页列表
	// * @param request
	// * @param response
	// * @param page
	// * @return
	// * @throws Exception
	// */
	// @RequestMapping("listJson")
	// @Action(description="查看从业人员信息表分页列表")
	// @ResponseBody
	// public Map<Object,Object> listJson(HttpServletRequest
	// request,HttpServletResponse response) throws Exception
	// {
	// QueryFilter fiter=new QueryFilter(request);
	// List<PersonJobRecommend> list=personJobRecommendService.getAll(fiter);
	// return getTableData(fiter.getPageBean().getTotalCount(), list);
	// }
	// /**
	// * 删除求职推荐匹配表
	// * @param request
	// * @param response
	// * @throws Exception
	// */
	// @RequestMapping("del")
	// @Action(description="删除求职推荐匹配表")
	// @ResponseBody
	// public ResultMessage del(HttpServletRequest request, HttpServletResponse
	// response) throws Exception
	// {
	//
	// ResultMessage message=null;
	// try{
	// Long[] lAryId =RequestUtil.getLongAryByStr(request, "acc220");
	// personJobRecommendService.delByIds(lAryId);
	// message=new ResultMessage(ResultMessage.Success, "删除求职推荐匹配表成功!");
	// }catch(Exception ex){
	// message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
	// logger.error(ExceptionUtil.getExceptionMessage(ex));
	// }
	// return message;
	// }
	/**
	 * 新增求职推荐匹配表
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description = "新增求职推荐匹配表")
	public ModelAndView add(HttpServletRequest request) throws Exception {
		PersonJobRecommendForm personJobRecommendForm = new PersonJobRecommendForm();
		personJobRecommendForm.putModel(null);
		ModelAndView modelAndView = new ModelAndView(
				"/business/dissupport/jobmatch/personJobRecommendEdit.jsp");
		return modelAndView.addObject("personJobRecommendForm",
				personJobRecommendForm);
	}

	/**
	 * 是否已推荐
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("isHasRecommend")
	@Action(description = "是否已推荐")
	@ResponseBody
	public String isHasRecommend(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Long acb210 = RequestUtil.getLong(request, "acb210");
		Long acc200 = RequestUtil.getLong(request, "acc200");
		if (acb210 != null && acc200 != null) {
			Boolean res = personJobRecommendService.isExists(acb210, acc200);
			return res.toString();
		}
		return "true";
	}

	/**
	 * 岗位推荐(暂无编辑功能)
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description = "编辑求职推荐匹配表")
	public ModelAndView edit(HttpServletRequest request) throws Exception {
		Long acc220 = RequestUtil.getLong(request, "acc220", 0L);
		PersonJobRecommend personJobRecommend = personJobRecommendService
				.getById(acc220);

		// 获取个人求职信息
		// 获取招聘信息
		// 修改
		if (personJobRecommend == null) {
			// 设置经办人相关信息
			personJobRecommend = new PersonJobRecommend();
			personJobRecommend.setAae011(String.valueOf(ContextUtil
					.getCurrentUser().getAac001()));
			personJobRecommend.setAae017(String.valueOf(ContextUtil
					.getCurrentUserOrg().getAcd200()));
			personJobRecommend.setAae022(String.valueOf(ContextUtil
					.getCurrentUserOrg().getAab301()));
			personJobRecommend.setAae036(new Date());
			personJobRecommend.setAae019(ContextUtil.getCurrentUser()
					.getAac003());
			personJobRecommend.setAae020(String.valueOf(ContextUtil
					.getCurrentUserOrg().getAcd202()));
			// 推荐机构电话
			personJobRecommend.setAab390(String.valueOf(ContextUtil
					.getCurrentUserOrg().getAcd20a()));
		}
		PersonJobRecommendForm personJobRecommendForm = new PersonJobRecommendForm();
		personJobRecommendForm.putModel(personJobRecommend);
		// 根据个人编号获取求职信息
		Long aac001 = RequestUtil.getLong(request, "aac001", 0);
		Map<String, Object> jobRegist = personJobRegistService.getJobRegistMapByPersonId(aac001);
		setjobRecommendForm(request, personJobRecommendForm,jobRegist);
		ModelAndView modelAndView = new ModelAndView(
				"/business/dissupport/jobmatch/personJobRecommendEdit.jsp");
		// 获取机构信息
		// 乘车路线
		modelAndView.addObject("ccmu04_print", ContextUtil.getCurrentUserOrg()
				.getCcmu04());
		// 所在地
		modelAndView.addObject("aab201_print", ContextUtil.getCurrentUserOrg().getAab201());
		// 联系人
		modelAndView.addObject("aae004_print", ContextUtil.getCurrentUser().getAac003());
		//联系电话 
		modelAndView.addObject("aab390_print", ContextUtil.getCurrentUser().getAae005());
		//职介机构名称
		
		modelAndView.addObject("currDate",DateUtil.getformatterCurrentDate("yyyy年MM月dd日"));
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 10);

		// 打印信息设置
		modelAndView.addObject("otherDate",
				new SimpleDateFormat("yyyy年MM月dd日").format(cal.getTime()));
		modelAndView.addObject("orgName", ContextUtil.getCurrentUserOrg()
				.getAcd202());
		modelAndView.addObject("userName", ContextUtil.getCurrentUser()
				.getAac003());
		//文化程度
		modelAndView.addObject("aac011_print",jobRegist.get("AAC011"));
		//人员类别
		modelAndView.addObject("acc20tname_print",jobRegist.get("ACC20T"));
		
		return modelAndView.addObject("personJobRecommendForm",
				personJobRecommendForm);
	}

	/**
	 * 根据岗位信息和个人求职信息 设置推荐匹配信息
	 * 
	 * @param corpPostion
	 * @param jobRegist
	 * @param personJobRecommendForm
	 */
	private void setjobRecommendForm(HttpServletRequest request,
			PersonJobRecommendForm personJobRecommendForm,Map<String,Object> jobRegist) {
		QueryFilter param = new QueryFilter();
		param.addFilter("acb210", request.getParameter("acb210"));
		// 根据招聘空号获取招聘岗位信息
		Map<String, Object> corpPostion = personJobRecommendService
				.getCorpPostionView(param);
		// 招聘岗位信息设置---------------------------------------------
		// 招聘登记号
		personJobRecommendForm
				.setAcb200(corpPostion.get("ACB200") == null ? null : new Long(
						String.valueOf(corpPostion.get("ACB200"))));
		// 单位名称
		personJobRecommendForm.setAab004(getStringValue(corpPostion, "AAB004"));
		// 单位地址
		personJobRecommendForm.setAae006(getStringValue(corpPostion, "AAE006"));
		// 大会招聘编号
		personJobRecommendForm.setAab001(corpPostion.get("AAB001") == null ? null : new Long(String.valueOf(corpPostion.get("AAB001"))));
		//单位联系人
		personJobRecommendForm.setAae004(getStringValue(corpPostion, "AAE004"));
		//单位联系电话
		personJobRecommendForm.setAae005(getStringValue(corpPostion, "AAE005"));
		//单位联系手机
		personJobRecommendForm.setAae139(getStringValue(corpPostion, "AAE139"));
		// 空位编号
		personJobRecommendForm.setAcb210(corpPostion.get("ACB210") == null ? null : new Long(String.valueOf(corpPostion.get("ACB210"))));
		// 工种名称
		personJobRecommendForm.setAca112(getStringValue(corpPostion, "ACA112"));
		personJobRecommendForm.setAca111(getStringValue(corpPostion, "ACA111"));
		//工作地点
		personJobRecommendForm.setAcb202(getStringValue(corpPostion, "ACB202"));
		//工作地点2
		personJobRecommendForm.setBcb202(getStringValue(corpPostion, "BCB202"));
		personJobRecommendForm.setCca111(corpPostion.get("CCA111") == null ? null : new Long(String.valueOf(corpPostion.get("CCA111"))));
		//工种2名称
		personJobRecommendForm.setBca112(getStringValue(corpPostion, "BCA112"));
		//工种描述
		personJobRecommendForm.setCca112(getStringValue(corpPostion, "CCA112"));
		//岗位描述
		personJobRecommendForm.setCca114(getStringValue(corpPostion, "CCA114"));
		//面试开始日期
		String aae030 = getStringValue(corpPostion, "AAE030");
		if(StringUtil.isNotEmpty(aae030))
		personJobRecommendForm.setAae030(DateUtil.parseDate(aae030));
		//面试结束日期
		String aae031 = getStringValue(corpPostion, "AAE031");
		if(StringUtil.isNotEmpty(aae031))
		personJobRecommendForm.setAae031(DateUtil.parseDate(aae031));
		//面试地点
		personJobRecommendForm.setAcb20c(getStringValue(corpPostion, "ACB20C"));
		//招聘经办人代码
		personJobRecommendForm.setAaeb11(getStringValue(corpPostion, "AAE011"));
		//招聘经办机构代码
		personJobRecommendForm.setAaeb17(getStringValue(corpPostion, "AAE017"));
		// 招聘机构行政区划
		personJobRecommendForm.setAaeb22(getStringValue(corpPostion, "AAE022"));
		personJobRecommendForm.setAaeb19(getStringValue(corpPostion, "AAE019"));
		personJobRecommendForm.setAaeb20(getStringValue(corpPostion, "AAE020"));
		//招聘对象
		personJobRecommendForm.setAcc20t(getStringValue(corpPostion, "ACC20TN"));
		String aaeb36 = getStringValue(corpPostion, "AAE036");
		if(StringUtil.isNotEmpty(aaeb36))
		personJobRecommendForm.setAae036(DateUtil.parseDate(aaeb36));

		//个人求职相关信息查询--------------------------------------------
		//身份证号
		personJobRecommendForm.setAac002(getStringValue(jobRegist, "AAC002"));
		//姓名
		personJobRecommendForm.setAac003(getStringValue(jobRegist, "AAC003"));
		//个人联系手机
		personJobRecommendForm.setAce139(getStringValue(jobRegist, "AAE005"));
		//个人联系地址(取居住所在地)
		personJobRecommendForm.setAce006(getStringValue(jobRegist, "AAB301"));
		//求职信息经办机构行政区划
		personJobRecommendForm.setAaec22(getStringValue(jobRegist, "AAE022"));
		//求职信息经办人代码
		personJobRecommendForm.setAaec11(getStringValue(jobRegist, "AAE011"));
		personJobRecommendForm.setAaec17(getStringValue(jobRegist, "AAE017"));
		String aae036job = getStringValue(jobRegist, "AAE036");
		if(StringUtil.isNotEmpty(aae036job))
		personJobRecommendForm.setAaec36(DateUtil.parseDate(aae036job));
		personJobRecommendForm.setAaec19(getStringValue(jobRegist, "AAE019"));
		personJobRecommendForm.setAaec20(getStringValue(jobRegist, "AAE020"));
		//性别
		personJobRecommendForm.setAac004(getStringValue(jobRegist, "AAC004N"));
		//月工资
		personJobRecommendForm.setAcc034(getStringValue(jobRegist, "ACC034N"));
		//福利要求
		personJobRecommendForm.setAcc214(getStringValue(jobRegist, "ACC214N"));
	    //个人编号
		personJobRecommendForm.setAac001(jobRegist.get("AAC001") == null ? null : new Long(String.valueOf(jobRegist.get("AAC001"))));
		//求职登记编号
		personJobRecommendForm.setAcc200(jobRegist.get("ACC200") == null ? null : new Long(String.valueOf(jobRegist.get("ACC200"))));
		//户口性质
		personJobRecommendForm.setAac009(getStringValue(jobRegist, "AAC009N"));
		//文化程度
		personJobRecommendForm.setAac011(getStringValue(jobRegist, "AAC011N"));
		//招聘对象
	}

	/**
	 * 从map中获取string
	 * 
	 * @param corpPostion
	 * @param key
	 * @return
	 */
	private String getStringValue(Map<String, Object> corpPostion, String key) {
		return corpPostion.get(key) == null ? null : String.valueOf(corpPostion
				.get(key));
	}

	// /**
	// * 取得求职推荐匹配表明细
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// @RequestMapping("get")
	// @Action(description="查看求职推荐匹配表明细")
	// public ModelAndView get(HttpServletRequest request, HttpServletResponse
	// response) throws Exception
	// {
	// Long acc220=RequestUtil.getLong(request,"acc220");
	// PersonJobRecommend personJobRecommend =
	// personJobRecommendService.getById(acc220);
	// return getAutoView().addObject("personJobRecommend", personJobRecommend);
	// }
	//

	/**
	 * 招聘详情查看
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("corpPostionView")
	@Action(description = "招聘详情查看")
	public ModelAndView corpPostionView(HttpServletRequest request)
			throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		Map<String, Object> map = personJobRecommendService
				.getCorpPostionView(fiter);
		ModelAndView modelAndView = new ModelAndView(
				"/business/dissupport/jobmatch/corpPostionView.jsp");
		return modelAndView.addAllObjects(map);
	}
}
