package com.xunfeng.sys.component.web;

import java.net.URLDecoder;
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

import com.xunfeng.business.corp.interf.CorpServiceInter;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.unitagreement.interf.UnitAgreementServiceInterf;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年4月27日-上午10:57:33 
* @version V1.0   
*/
@Controller
@RequestMapping("/sys/component/uums/")
public class UUMSController extends BaseController
{

	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf personService;
	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	
	@Resource
	@Qualifier("corp")
	private CorpServiceInter corpService;
	@Resource
	@Qualifier("unitAgreement")
	private UnitAgreementServiceInterf unitAgreementService;
	
	@RequestMapping("selDeptUser")
	@Action(description = "导入业务数据模板数据",detail="导入业务数据模板数据")
	public ModelAndView importData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView=new ModelAndView("/sys/component/uums/sysDeptUserList.jsp");
		return modelAndView;		
	
	}
	
	@RequestMapping("selUser")
	@ResponseBody
	@Action(description = "导入业务数据模板数据",detail="导入业务数据模板数据")
	public List<Map> selUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPagesize(10);
		String searchValue=request.getParameter("searchValue");
		searchValue=URLDecoder.decode(searchValue, "UTF-8");		
		
		String hasArch = request.getParameter("hasArch");
		ResultData<Map> resultData;
		if (StringUtil.isEmpty(hasArch)){
			resultData =personService.getMapPersonList(searchValue, pageBean);
		}else{
			resultData= archivesService.getArchivesPersonList(searchValue, pageBean,Boolean.parseBoolean(hasArch));
		}

		return resultData.getDataList();		
	
	}
	
	@RequestMapping("selCorp")
	@ResponseBody
	@Action(description = "导入业务数据模板数据",detail="导入业务数据模板数据")
	public List selCorp(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String searchValue=request.getParameter("searchValue");
		QueryFilter fiter=new QueryFilter();
		if(StringUtil.isNotEmpty(searchValue)){
			fiter.addFilter("searchValue", "%"+searchValue+"%");
		}
		String hasUnit = request.getParameter("hasUnit");
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPagesize(10);
		fiter.setPageBean(pageBean);
		
		ResultData resultData = unitAgreementService.getAllCorp(fiter);

		return resultData.getDataList();			
	
	}
	
	@RequestMapping("selComCorp")
	@ResponseBody
	@Action(description = "导入业务数据模板数据",detail="导入业务数据模板数据")
	public List selComCorp(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String searchValue=request.getParameter("searchValue");
		QueryFilter fiter=new QueryFilter();
		if(StringUtil.isNotEmpty(searchValue)){
			fiter.addFilter("searchValue", "%"+searchValue+"%");
		}
		String hasUnit = request.getParameter("hasUnit");
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPagesize(10);
		fiter.setPageBean(pageBean);
		
		ResultData resultData = corpService.getAllCorp(fiter);

		return resultData.getDataList();		
	
	}
	
}
