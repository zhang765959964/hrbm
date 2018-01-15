package com.xunfeng.business.dissupport.statistics.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.xunfeng.business.jobfair.interf.JobFairInfoServiceInter;
import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.CorpStaEnum;
import com.xunfeng.core.enumeration.PersonStaEnum;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.statistics.interf.SysStatisticsServiceInterf;
import com.xunfeng.sys.uums.model.SysOrg;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 招聘会信息表 控制器类
 * @author:wanghan
 * @createDate 2015-09-12 11:02:45
 * @version V1.0
 */
@Controller
@RequestMapping("/business/dissupport/statistics/statistics/")
public class StatisticsController extends BaseController {
	@Resource
	@Qualifier("sysStatistics")
	private SysStatisticsServiceInterf sysStatistics;

	@Resource
	@Qualifier("jobfair")
	private JobFairInfoServiceInter jobFairInfoService;

	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf personBaseInfoService;

	/**
	 * 个人信息统计
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getPersonBaseInfoStatisticsJson")
	@Action(description = "个人信息统计")
	@ResponseBody
	public Map<Object, Object> getPersonBaseInfoStatistics(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		// 存储过程需要设置时间才能查询
		if (StringUtils.isEmpty(request.getParameter("STARTDATE"))
				|| StringUtils.isEmpty(request.getParameter("ENDDATE"))) {
			return getEmptyTable();
		}
		// 根据输入设置查询参数
		fiter.addFilter("IS_AAE017", "1");
		// 页面未设置则查询当前登录用户及下级
		if (StringUtil.isEmpty(request.getParameter("AAE017"))) {
			fiter.addFilter("AAE017", getSubOrgs());
		}
		// 性别
		if (!StringUtil.isEmpty(request.getParameter("AAD004"))) {
			fiter.addFilter("IS_AAD004", "1");
		} else {
			fiter.addFilter("IS_AAD004", "0");
		}
		// 专业要求
		if (!StringUtil.isEmpty(request.getParameter("ACC01G"))) {
			fiter.addFilter("IS_ACC01G", "1");
		} else {
			fiter.addFilter("IS_ACC01G", "0");
		}
		// 学历
		if (!StringUtil.isEmpty(request.getParameter("AAC011"))) {
			fiter.addFilter("IS_AAC011", "1");
		} else {
			fiter.addFilter("IS_AAC011", "0");
		}
		// 年龄
		if (!StringUtil.isEmpty(request.getParameter("ACB223"))) {
			fiter.addFilter("IS_ACB223", "1");
		} else {
			fiter.addFilter("IS_ACB223", "0");
		}
		// 户口性质
		if (!StringUtil.isEmpty(request.getParameter("AAC009"))) {
			fiter.addFilter("IS_AAC009", "1");
		} else {
			fiter.addFilter("IS_AAC009", "0");
		}
		// 数据来源
		if (!StringUtil.isEmpty(request.getParameter("BCB209"))) {
			fiter.addFilter("IS_BCB209", "1");
		} else {
			fiter.addFilter("IS_BCB209", "0");
		}
		fiter.addFilter("OTHER_DEF", null);
		fiter.addFilter("V_CURSOR", new ArrayList<HashMap<String, Object>>());
		List<Map<String, Object>> list = sysStatistics
				.getPersonBaseInfoStatistics(fiter);
		addSumPersonRow(list);
		return getTableData(2000, list);
	}
    private  void addSumPersonRow(List<Map<String, Object>> list){
    	Map sumMap=new HashMap();
    	BigDecimal total=new BigDecimal(0);
    	
    	for(Map<String, Object> map: list){
    		
    		BigDecimal BQ_GRQZS=(BigDecimal)map.get("BQ_GRQZS");
    		total=total.add(BQ_GRQZS);
    	}
    	
    	sumMap.put("DATA_DATE", "总计");
    	sumMap.put("BQ_GRQZS", total);
    	sumMap.put("AAE017N", "");   	
    	list.add(sumMap);  
    	
    } 
	/**
	 * 取得个人信息统计
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("personStatistics")
	public ModelAndView personStatistics(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView(
				"/business/dissupport/statistics/personBaseInfoStatistics.jsp")
				.addObject("orgs", getOrganSelectList()).addObject("stas",
						PersonStaEnum.values());
	}

	/**
	 * 报表统计数据获取
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listStatisticsChartsJson")
	@Action(description = "个人信息统计列表")
	@ResponseBody
	public Map<Object, Object> listStatisticsChartsJson(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		// 设置分组值
		String groupname = "";
		String columnname = "";
		if ("666".equals(request.getParameter("groupvalue"))) {
			// 根据机构分组统计
			groupname = "AAE020";
			columnname = "AAE020";
		} else if ("888".equals(request.getParameter("groupvalue"))) {
			// 根据平台分组统计
			groupname = "ECZY06";
			columnname = "ECZY06";
		} else {
			PersonStaEnum personStaEnum = PersonStaEnum.getValue(request
					.getParameter("groupvalue"));
			groupname = personStaEnum.getTableColumn();
			columnname = personStaEnum.getTableColumnName();
		}
		fiter.addFilter("groupname", groupname);
		fiter.addFilter("columnname", columnname);
		// 添加用户组织ID
		Map<Object, Object> remap = new HashMap<Object, Object>();
		List<Map<String, Object>> results = personBaseInfoService
				.getPersonStatisticsEcharts(addJurisdiction(fiter));
		List<String> dataName = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		if (results != null && results.size() > 0) {
			for (Map<String, Object> map : results) {
				Map<String, Object> re = new HashMap<String, Object>();
				if (!map.containsKey("COLUMNNAME")
						|| "".equals(String.valueOf(map.get("COLUMNNAME")))) {
					dataName.add("其它");
					re.put("name", "其它");
					values.add(String.valueOf(map.get("PERNUM")));
				} else {
					re.put("name", String.valueOf(map.get("COLUMNNAME")));
					dataName.add(String.valueOf(map.get("COLUMNNAME")));
					values.add(String.valueOf(map.get("PERNUM")));
				}
				re.put("value", String.valueOf(map.get("PERNUM")));
				resultList.add(re);
			}
		}
		remap.put("datanames", dataName);
		remap.put("datanamevalues", JSONArray.toJSON(resultList));
		remap.put("datavalues", values);
		return remap;
	}

	/**
	 * 单位信息统计
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("corpStatistics")
	public ModelAndView corpStatistics(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView(
				"/business/dissupport/statistics/corpStatistics.jsp")
				.addObject("orgs", getOrganSelectList()).addObject("stas",
						CorpStaEnum.values());
	}

	/**
	 * 取得单位信息统计数据列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listStatisticsJson")
	@Action(description = "单位信息统计列表")
	@ResponseBody
	public Map<Object, Object> listStatisticsJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		// 存储过程需要设置时间才能查询
		if (StringUtils.isEmpty(request.getParameter("STARTDATE"))) {
			return getTableData(2000, new ArrayList<HashMap<String, Object>>());
		}
		if (StringUtils.isEmpty(request.getParameter("ENDDATE"))) {
			return getTableData(2000, new ArrayList<HashMap<String, Object>>());
		}
		// 根据输入设置查询参数
		fiter.addFilter("IS_AAE017", "1");
		// 页面未设置则查询当前登录用户及下级
		if (StringUtil.isEmpty(request.getParameter("AAE017"))) {
			fiter.addFilter("AAE017", getSubOrgs());
		}
		// 产业
		if (!StringUtil.isEmpty(request.getParameter("AAB054"))) {
			fiter.addFilter("IS_AAB054", "1");
		}
		// 单位性质
		if (!StringUtil.isEmpty(request.getParameter("AAB019"))) {
			fiter.addFilter("IS_AAB019", "1");
		}
		// 经济类型
		if (!StringUtil.isEmpty(request.getParameter("AAB020"))) {
			fiter.addFilter("IS_AAB020", "1");
		}
		// 行业类别（自定义）
		if (!StringUtil.isEmpty(request.getParameter("CCPR10"))) {
			fiter.addFilter("IS_CCPR10", "1");
		}
		// 行业类别（部级标准）
		if (!StringUtil.isEmpty(request.getParameter("AAB022"))) {
			fiter.addFilter("IS_AAB022", "1");
		}
		// 人员规模
		if (!StringUtil.isEmpty(request.getParameter("AAB056"))) {
			fiter.addFilter("IS_AAB056", "1");
		}
		// 招聘
		if (!StringUtil.isEmpty(request.getParameter("RECRUIT"))) {
			fiter.addFilter("IS_RECRUIT", "1");
		}
		// 数据来源
		if (!StringUtil.isEmpty(request.getParameter("CCZY06"))) {
			fiter.addFilter("IS_CCZY06", "1");
		}
		// 会员
		if (!StringUtil.isEmpty(request.getParameter("MEM"))) {
			fiter.addFilter("IS_MEM", "1");
		}
		fiter.addFilter("OTHER_DEF", null);
		fiter.addFilter("V_CURSOR", new ArrayList<HashMap<String, Object>>());
		List<Map<String, Object>> list = sysStatistics.getCorpStatistics(fiter);
		addSumCorpRow(list);
		return getTableData(1000, list);
	}
    private  void addSumCorpRow(List<Map<String, Object>> list){
    	Map sumMap=new HashMap();
    	BigDecimal total_DWS=new BigDecimal(0);
    	BigDecimal total_BQ_GRQZS=new BigDecimal(0);
    	for(Map<String, Object> map: list){   		
    		BigDecimal DWS=(BigDecimal)map.get("DWS");
    		BigDecimal BQ_NEW_DWS=(BigDecimal)map.get("BQ_NEW_DWS");
    		total_DWS=total_DWS.add(DWS);   		
    		total_BQ_GRQZS=total_BQ_GRQZS.add(BQ_NEW_DWS);
    	}   	
    	sumMap.put("DATA_DATE", "总计");
    	sumMap.put("DWS", total_DWS);
    	sumMap.put("BQ_NEW_DWS", total_BQ_GRQZS);
    	sumMap.put("AAE017N", "");   	
    	list.add(sumMap);  
    	
    } 
	/**
	 * 报表统计数据获取
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listStatisticsCorpChartsJson")
	@Action(description = "个人信息统计列表")
	@ResponseBody
	public Map<Object, Object> listStatisticsCorpChartsJson(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		// 设置分组值
		String groupname = "";
		String columnname = "";
		if ("666".equals(request.getParameter("groupvalue"))) {
			groupname = "AAE020";
			columnname = "AAE020";
			// 根据机构分组统计
		} else if ("888".equals(request.getParameter("groupvalue"))) {
			// 根据平台分组统计
			groupname = "ECZY06";
			columnname = "ECZY06";
		} else {
			CorpStaEnum personStaEnum = CorpStaEnum.getValue(request
					.getParameter("groupvalue"));
			groupname = personStaEnum.getTableColumn();
			columnname = personStaEnum.getTableColumnName();
		}
		fiter.addFilter("groupname", groupname);
		fiter.addFilter("columnname", columnname);
		// 添加用户组织ID
		Map<Object, Object> remap = new HashMap<Object, Object>();
		List<Map<String, Object>> results = sysStatistics
				.getCorpStatisticsEcharts(addJurisdiction(fiter));
		List<String> dataName = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		if (results != null && results.size() > 0) {
			for (Map<String, Object> map : results) {
				Map<String, Object> re = new HashMap<String, Object>();
				if (!map.containsKey("COLUMNNAME")
						|| "".equals(String.valueOf(map.get("COLUMNNAME")))) {
					dataName.add("其它");
					re.put("name", "其它");
					values.add(String.valueOf(map.get("CORPNUM")));
				} else {
					re.put("name", String.valueOf(map.get("COLUMNNAME")));
					dataName.add(String.valueOf(map.get("COLUMNNAME")));
					values.add(String.valueOf(map.get("CORPNUM")));
				}
				re.put("value", String.valueOf(map.get("CORPNUM")));
				resultList.add(re);
			}
		}
		remap.put("datanames", dataName);
		remap.put("datanamevalues", JSONArray.toJSON(resultList));
		remap.put("datavalues", values);
		return remap;
	}

	/**
	 * 个人求职统计
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("personJobregStatistics")
	public ModelAndView personJobregStatistics(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView(
				"/business/dissupport/statistics/personJobregStatistics.jsp")
				.addObject("orgs", getOrganSelectList());
	}

	/**
	 * 取得个人求职统计
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jobregStatisticsJson")
	@Action(description = "查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object, Object> jobregStatisticsJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		// 必须输入时间才能查询
		if (StringUtils.isEmpty(request.getParameter("STARTDATE"))) {
			return getTableData(0, new ArrayList<HashMap<String, Object>>());
		}
		if (StringUtils.isEmpty(request.getParameter("ENDDATE"))) {
			return getTableData(0, new ArrayList<HashMap<String, Object>>());
		}
		// 根据输入设置查询参数
		fiter.addFilter("IS_AAE017", "1");
		// 页面未设置则查询当前登录用户及下级
		if (StringUtil.isEmpty(request.getParameter("AAE017"))) {
			fiter.addFilter("AAE017", getSubOrgs());
		}
		// 性别
		if (!StringUtil.isEmpty(request.getParameter("AAD004"))) {
			fiter.addFilter("IS_AAD004", "1");
		} else {
			fiter.addFilter("IS_AAD004", "0");
		}
		// 专业要求
		if (!StringUtil.isEmpty(request.getParameter("ACC01G"))) {
			fiter.addFilter("IS_ACC01G", "1");
		} else {
			fiter.addFilter("IS_ACC01G", "0");
		}
		// 学历
		if (!StringUtil.isEmpty(request.getParameter("AAC011"))) {
			fiter.addFilter("IS_AAC011", "1");
		} else {
			fiter.addFilter("IS_AAC011", "0");
		}
		// 工作经验
		if (!StringUtil.isEmpty(request.getParameter("ACC217"))) {
			fiter.addFilter("IS_ACC217", "1");
		} else {
			fiter.addFilter("IS_ACC217", "0");
		}
		// 年龄
		if (!StringUtil.isEmpty(request.getParameter("ACB223"))) {
			fiter.addFilter("IS_ACB223", "1");
		} else {
			fiter.addFilter("IS_ACB223", "0");
		}
		// --是否户口性质
		if (!StringUtil.isEmpty(request.getParameter("AAC009"))) {
			fiter.addFilter("IS_AAC009", "1");
		} else {
			fiter.addFilter("IS_AAC009", "0");
		}
		// 技术等级
		if (!StringUtil.isEmpty(request.getParameter("ACC20G"))) {
			fiter.addFilter("IS_ACC20G", "1");
		} else {
			fiter.addFilter("IS_ACC20G", "0");
		}
		// 意向单位性质
		if (!StringUtil.isEmpty(request.getParameter("AAB019"))) {
			fiter.addFilter("IS_AAB019", "1");
		} else {
			fiter.addFilter("IS_AAB019", "0");
		}
		// 月工资
		if (!StringUtil.isEmpty(request.getParameter("ACC034"))) {
			fiter.addFilter("IS_ACC034", "1");
		} else {
			fiter.addFilter("IS_ACC034", "0");
		}
		// 数据来源
		if (!StringUtil.isEmpty(request.getParameter("BCB209"))) {
			fiter.addFilter("IS_BCB209", "1");
		} else {
			fiter.addFilter("IS_BCB209", "0");
		}
		// 登记类别
		if (!StringUtil.isEmpty(request.getParameter("ACC201"))) {
			fiter.addFilter("IS_ACC201", "1");
		} else {
			fiter.addFilter("IS_ACC201", "0");
		}
		// 人员类别
		if (!StringUtil.isEmpty(request.getParameter("ACC20T"))) {
			fiter.addFilter("IS_ACC20T", "1");
		} else {
			fiter.addFilter("IS_ACC20T", "0");
		}
		// 职位名称（自定义标准）
		if (!StringUtil.isEmpty(request.getParameter("BCA111"))) {
			fiter.addFilter("IS_BCA111", "1");
		} else {
			fiter.addFilter("IS_BCA111", "0");
		}
		// 职位名称（部级标准）
		if (!StringUtil.isEmpty(request.getParameter("ACA111"))) {
			fiter.addFilter("IS_ACA111", "1");
		} else {
			fiter.addFilter("IS_ACA111", "0");
		}
		// 福利待遇
		if (!StringUtil.isEmpty(request.getParameter("ACC214"))) {
			fiter.addFilter("IS_ACC214", "1");
		} else {
			fiter.addFilter("IS_ACC214", "0");
		}
		// 是否新增
		if (!StringUtil.isEmpty(request.getParameter("IS_NEW"))) {
			fiter.addFilter("IS_IS_NEW", "1");
		} else {
			fiter.addFilter("IS_IS_NEW", "0");
		}
		// --是否冻结 ADD BY MGT 20160519
		if (!StringUtil.isEmpty(request.getParameter("ACB208"))) {
			fiter.addFilter("IS_ACB208", "1");
		} else {
			fiter.addFilter("IS_ACB208", "0");
		}
		fiter.addFilter("V_CURSOR", new ArrayList<HashMap<String, Object>>());
		List<Map<String, Object>> list = sysStatistics
				.getPersonRegistStatistics(fiter);
		return getTableData(1000, list);
	}

	/**
	 * 单位需求统计
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("corpDemandStatistics")
	public ModelAndView getCorpDemandStatistics(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView(
				"/business/dissupport/statistics/corpDemandStatistics.jsp")
				.addObject("orgs", getOrganSelectList());
	}

	/**
	 * 单位需求统计
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("corpDemandStatisticsJson")
	@Action(description = "单位需求统计")
	@ResponseBody
	public Map<Object, Object> corpDemandStatisticsJson(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		// 存储过程需要设置时间才能查询
		if (StringUtils.isEmpty(request.getParameter("STARTDATE"))
				|| StringUtils.isEmpty(request.getParameter("ENDDATE"))) {
			return getEmptyTable();
		}
		// 根据输入设置查询参数
		fiter.addFilter("IS_AAE017", "1");
		// 页面未设置则查询当前登录用户及下级
		if (StringUtil.isEmpty(request.getParameter("AAE017"))) {
			fiter.addFilter("AAE017", getSubOrgs());
		}
		// 冗余，0否1是
		if (!StringUtil.isEmpty(request.getParameter("REDUNDANCE_DAYS"))) {
			fiter.addFilter("IS_REDUNDANCE", 1);
			fiter.addFilter("REDUNDANCE_DAYS",
					Integer.valueOf(request.getParameter("REDUNDANCE_DAYS")));
		} else {
			fiter.addFilter("IS_REDUNDANCE", 0);
		}
		// 单位性质
		if (!StringUtil.isEmpty(request.getParameter("AAB019"))) {
			fiter.addFilter("IS_AAB019", new Float(1));
		} else {
			fiter.addFilter("IS_AAB019", new Float(0));
		}
		// 产业
		if (!StringUtil.isEmpty(request.getParameter("AAB054"))) {
			fiter.addFilter("IS_AAB054", new Float(1));
		} else {
			fiter.addFilter("IS_AAB054", new Float(0));
		}
		// 经济类型
		if (!StringUtil.isEmpty(request.getParameter("AAB020"))) {
			fiter.addFilter("IS_AAB020", new Float(1));
		} else {
			fiter.addFilter("IS_AAB020", new Float(0));
		}
		// 性别
		if (!StringUtil.isEmpty(request.getParameter("AAD004"))) {
			fiter.addFilter("IS_AAD004", new Float(1));
		} else {
			fiter.addFilter("IS_AAD004", new Float(0));
		}
		// 行业类别（自定义）
		if (!StringUtil.isEmpty(request.getParameter("CCPR10"))) {
			fiter.addFilter("IS_CCPR10", new Float(1));
		} else {
			fiter.addFilter("IS_CCPR10", new Float(0));
		}
		// 行业类别（部级标准）
		if (!StringUtil.isEmpty(request.getParameter("AAB022"))) {
			fiter.addFilter("IS_AAB022", new Float(1));
		} else {
			fiter.addFilter("IS_AAB022", new Float(0));
		}
		// 人员规模
		if (!StringUtil.isEmpty(request.getParameter("AAB056"))) {
			fiter.addFilter("IS_AAB056", new Float(1));
		} else {
			fiter.addFilter("IS_AAB056", new Float(0));
		}
		// 学历
		if (!StringUtil.isEmpty(request.getParameter("AAC011"))) {
			fiter.addFilter("IS_AAC011", new Float(1));
		} else {
			fiter.addFilter("IS_AAC011", new Float(0));
		}
		// 年龄
		if (!StringUtil.isEmpty(request.getParameter("ACB223"))) {
			fiter.addFilter("IS_ACB223", new Float(1));
		} else {
			fiter.addFilter("IS_ACB223", new Float(0));
		}
		// 专业要求
		if (!StringUtil.isEmpty(request.getParameter("ACC01G"))) {
			fiter.addFilter("IS_ACC01G", new Float(1));
		} else {
			fiter.addFilter("IS_ACC01G", new Float(0));
		}
		// 工作经验
		if (!StringUtil.isEmpty(request.getParameter("ACC217"))) {
			fiter.addFilter("IS_ACC217", new Float(1));
		} else {
			fiter.addFilter("IS_ACC217", new Float(0));
		}
		// 数据来源
		if (!StringUtil.isEmpty(request.getParameter("CCZY06"))) {
			fiter.addFilter("IS_CCZY06", new Float(1));
		} else {
			fiter.addFilter("IS_CCZY06", new Float(0));
		}
		// 职位名称（自定义标准）
		if (!StringUtil.isEmpty(request.getParameter("BCA111"))) {
			fiter.addFilter("IS_BCA111", new Float(1));
		} else {
			fiter.addFilter("IS_BCA111", new Float(0));
		}
		// 职位名称（部级标准）
		if (!StringUtil.isEmpty(request.getParameter("ACA111"))) {
			fiter.addFilter("IS_ACA111", new Float(1));
		} else {
			fiter.addFilter("IS_ACA111", new Float(0));
		}
		// 福利待遇
		if (!StringUtil.isEmpty(request.getParameter("ACC214"))) {
			fiter.addFilter("IS_ACC214", new Float(1));
		} else {
			fiter.addFilter("IS_ACC214", new Float(0));
		}
		// 月工资
		if (!StringUtil.isEmpty(request.getParameter("ACC034"))) {
			fiter.addFilter("IS_ACC034", new Float(1));
		} else {
			fiter.addFilter("IS_ACC034", new Float(0));
		}
		// 技术等级
		if (!StringUtil.isEmpty(request.getParameter("AAC015"))) {
			fiter.addFilter("IS_AAC015", new Float(1));
		} else {
			fiter.addFilter("IS_AAC015", new Float(0));
		}
		// 招聘形式
		if (!StringUtil.isEmpty(request.getParameter("RECRUIT_FORM"))) {
			fiter.addFilter("IS_RECRUIT_FORM", new Float(1));
		} else {
			fiter.addFilter("IS_RECRUIT_FORM", new Float(0));
		}
		// 是否新增单位
		if (!StringUtil.isEmpty(request.getParameter("V_NEW"))) {
			fiter.addFilter("IS_NEW", "1");
		} else {
			fiter.addFilter("IS_NEW", "0");
		}
		// --add by mgt 20160519
		if (!StringUtil.isEmpty(request.getParameter("ACB208"))) {
			fiter.addFilter("IS_ACB208", "1");
		} else {
			fiter.addFilter("IS_ACB208", "0");
		}
		fiter.addFilter("P_CURSOR", new ArrayList<HashMap<String, Object>>());
		List<Map<String, Object>> list = sysStatistics
				.getCorpDemandStatistics(fiter);
		return getTableData(1000, list);
	}

	/**
	 * 工种工资统计页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jobSalariesStatistics")
	public ModelAndView jobSalariesStatistics(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView(
				"/business/dissupport/statistics/jobSalariesStatistics.jsp")
				.addObject("orgs", getOrganSelectList());
	}

	/**
	 * 工种工资统计查询
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jobSalariesStatisticsJson")
	@Action(description = "工种工资统计")
	@ResponseBody
	public Map<Object, Object> jobSalariesStatisticsJson(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		// 冗余，0否1是
		if (!StringUtil.isEmpty(request.getParameter("REDUNDANCE_DAYS"))) {
			fiter.addFilter("IS_REDUNDANCE", new Integer(1));
		} else {
			fiter.addFilter("IS_REDUNDANCE", new Integer(0));
		}
		// 存储过程需要设置时间才能查询
		if (StringUtils.isEmpty(request.getParameter("STARTDATE"))
				|| StringUtils.isEmpty(request.getParameter("ENDDATE"))) {
			return getEmptyTable();
		}
		// 根据输入设置查询参数
		fiter.addFilter("IS_AAE017", "1");
		// 页面未设置则查询当前登录用户及下级
		if (StringUtil.isEmpty(request.getParameter("AAE017"))) {
			fiter.addFilter("AAE017", getSubOrgs());
		}
		// 判断产业是否为空
		if (!StringUtil.isEmpty(request.getParameter("AAB054"))) {
			fiter.addFilter("IS_AAB054", "1");
		} else {
			fiter.addFilter("IS_AAB054", "0");
		}
		// 行业类别(自定义)
		if (!StringUtil.isEmpty(request.getParameter("CCPR10"))) {
			fiter.addFilter("IS_CCPR10", "1");
		} else {
			fiter.addFilter("IS_CCPR10", "0");
		}
		// 行业类别(部级标准)
		if (!StringUtil.isEmpty(request.getParameter("AAB022"))) {
			fiter.addFilter("IS_AAB022", "1");
		} else {
			fiter.addFilter("IS_AAB022", "0");
		}
		// 职位名称(部级标准)
		if (!StringUtil.isEmpty(request.getParameter("ACA111"))) {
			fiter.addFilter("IS_ACA111", "1");
		} else {
			fiter.addFilter("IS_ACA111", "0");
		}
		// 职位名称(自定义标准)
		if (!StringUtil.isEmpty(request.getParameter("BCA111"))) {
			fiter.addFilter("IS_BCA111", "1");
		} else {
			fiter.addFilter("IS_BCA111", "0");
		}
		fiter.addFilter("OTHER_DEF", null);
		fiter.addFilter("V_CURSOR", new ArrayList<HashMap<String, Object>>());
		List<Map<String, Object>> list = jobFairInfoService
				.getJobSalariesStatistics(fiter);
		return getTableData(100, list);
	}

	/**
	 * 供求关系统计统计
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jobSuplyDemandList")
	public ModelAndView jobSuplyDemandList(HttpServletRequest request,
			HttpServletResponse response) throws Exception { // v_dwzp_info
		return new ModelAndView(
				"/business/dissupport/statistics/jobSuplyDemand.jsp")
				.addObject("orgs", getOrganSelectList());
	}

	/**
	 * 供求关系统计统计
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jobSuplyDemandListJson")
	@Action(description = "供求关系统计查询")
	@ResponseBody
	public Map<Object, Object> jobSuplyDemandListJson(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		// 冗余，0否1是
		if (!StringUtil.isEmpty(request.getParameter("REDUNDANCE_DAYS"))) {
			fiter.addFilter("IS_REDUNDANCE", new Integer(1));
		} else {
			fiter.addFilter("IS_REDUNDANCE", new Integer(0));
		}
		// 存储过程需要设置时间才能查询
		if (StringUtils.isEmpty(request.getParameter("STARTDATE"))
				|| StringUtils.isEmpty(request.getParameter("ENDDATE"))) {
			return getEmptyTable();
		}
		// 根据输入设置查询参数
		fiter.addFilter("IS_AAE017", "1");
		// 页面未设置则查询当前登录用户及下级
		if (StringUtil.isEmpty(request.getParameter("AAE017"))) {
			fiter.addFilter("AAE017", getSubOrgs());
		}
		// 判断性别是否为空
		if (!StringUtil.isEmpty(request.getParameter("SEX"))) {
			fiter.addFilter("IS_AAD004", "1");
			fiter.addFilter("AAD004", request.getParameter("SEX"));
		} else {
			fiter.addFilter("IS_AAD004", "0");
		}
		// 判断年龄是否为空
		if (!StringUtil.isEmpty(request.getParameter("AGE"))) {
			fiter.addFilter("IS_ACB223", "1");
			fiter.addFilter("ACB223", request.getParameter("AGE"));
		} else {
			fiter.addFilter("IS_ACB223", "0");
		}
		if (!StringUtil.isEmpty(request.getParameter("ACA111"))) {
			fiter.addFilter("IS_ACA111", "1");
		} else {
			fiter.addFilter("IS_ACA111", "0");
		}
		if (!StringUtil.isEmpty(request.getParameter("BCA111"))) {
			fiter.addFilter("IS_BCA111", "1");
		} else {
			fiter.addFilter("IS_BCA111", "0");
		}
		// 是否冻结
		if (!StringUtil.isEmpty(request.getParameter("ACB208"))) {
			fiter.addFilter("IS_ACB208", "1");
		} else {
			fiter.addFilter("IS_ACB208", "0");
		}
		// 专业要求
		if (!StringUtil.isEmpty(request.getParameter("ACC01G"))) {
			fiter.addFilter("IS_ACC01G", "1");
		} else {
			fiter.addFilter("IS_ACC01G", "0");
		}
		// 学历
		if (!StringUtil.isEmpty(request.getParameter("AAC011"))) {
			fiter.addFilter("IS_AAC011", "1");
		} else {
			fiter.addFilter("IS_AAC011", "0");
		}
		fiter.addFilter("V_CURSOR", new ArrayList<HashMap<String, Object>>());
		List<Map<String, Object>> list = jobFairInfoService
				.getjobSuplyDemandList(fiter);
		return getTableData(100, list);
	}

	/**
	 * 单位招聘信息查询(仅查看)
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jobList")
	public ModelAndView jobListView(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("/business/dissupport/statistics/jobList.jsp")
				.addObject("orgs", getOrganSelectList());
	}

	/**
	 * 招聘职位信息查询(编辑)
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jobListEdit")
	public ModelAndView jobListEdit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("/business/dissupport/statistics/jobList.jsp")
				.addObject("orgs", getOrganSelectList()).addObject("isEdit",
						true);
	}

	/**
	 * 招聘信息列表Json
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jobListJson")
	@Action(description = "取得单位招聘信息列表")
	@ResponseBody
	public Map<Object, Object> jobListJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		int limit = RequestUtil.getInt(request, "limit");
		int offset = RequestUtil.getInt(request, "offset");
		PageBean pageBean = WrapPageBean(limit, offset);
		fiter.setPageBean(pageBean);
		ResultData<Map<String, Object>> resultData = jobFairInfoService
				.getJobListPage(addJurisdiction(fiter));
		return getTableData(resultData.getPageBean().getTotalCount(),
				resultData.getDataList());
	}

	/**
	 * 返回空集合
	 * 
	 * @return
	 */
	private Map<Object, Object> getEmptyTable() {
		return getTableData(0, new ArrayList<HashMap<String, Object>>());
	}

	/**
	 * 获取当前机构及其子机构
	 * 
	 * @return
	 */
	private String getSubOrgs() {
		List<SysOrg> orgs = sysOrgService.getSubOrgans(ContextUtil
				.getCurrentUserOrg().getAcd200());
		if (orgs != null && orgs.size() > 0) {
			StringBuilder stringBuilder = new StringBuilder();
			for (SysOrg sysOrg : orgs) {
				stringBuilder.append(sysOrg.getAcd200()).append(",");
			}
			return stringBuilder.substring(0, stringBuilder.length() - 1);
		}
		return String.valueOf(ContextUtil.getCurrentUserOrg().getAcd200());
	}
}
