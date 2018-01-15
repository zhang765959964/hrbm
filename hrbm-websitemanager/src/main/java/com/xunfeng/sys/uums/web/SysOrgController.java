package com.xunfeng.sys.uums.web;

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

import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.interf.SysDeptServiceInterf;
import com.xunfeng.sys.uums.interf.SysOrgServiceInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.web.form.SysOrgForm;
/**
 *<pre>
 * 对象功能:职介机构表 控制器类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-29 16:03:27
 *</pre>
 */
@Controller
@RequestMapping("/sys/uums/sysOrg/")
public class SysOrgController extends BaseController
{
	@Resource
	@Qualifier("sysdept")
	private SysDeptServiceInterf sysDeptService;
	
	@Resource
	@Qualifier("sysorg")
	private SysOrgServiceInterf sysOrgService;
	
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf UniqueIdUtil;	
	
	
	/**
	 * 添加或更新职介机构表。
	 * @param request
	 * @param response
	 * @param sysOrg 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新机构信息")
	public void save(HttpServletRequest request, HttpServletResponse response,SysOrgForm sysOrgForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long acd200=RequestUtil.getLong(request,"acd200");
		    SysOrg sysOrg = sysOrgService.getById(acd200);
		    sysOrg=sysOrgForm.getModel(sysOrg);
		    //判断是不是一级机构
		    if("".equals(sysOrg.getAab034())){
		    	sysOrg.setCcmu05(new Long(1));
		    }else{
		    	sysOrg.setCcmu05(new Long(2));
		    }
		    //地图坐标设置
		    if(StringUtil.isNotEmpty(request.getParameter("cabq02"))){
		    	sysOrg.setCabq01(new Long(1));
		    	sysOrg.setCabq02(RequestUtil.getFloat(request, "cabq02"));
		    	sysOrg.setCabq03(RequestUtil.getFloat(request, "cabq03"));
		    }else{
		    	sysOrg.setCabq01(new Long(0));
		    }
		    //判断是否是二级机构
			if(sysOrgForm.isMvcAdd()){
				resultMsg="添加机构信息";
				sysOrg.setAcd200(UniqueIdUtil.genId(SysOrg.class.getName()));
			    //设置经办机构信息
			    sysOrg.setAae011(String.valueOf(ContextUtil.getCurrentUserId()));
			    sysOrg.setAae017(String.valueOf(ContextUtil.getCurrentUserOrg().getAab003()));
			    sysOrg.setAae019(ContextUtil.getCurrentUser().getAac003());
			    sysOrg.setAae020(ContextUtil.getCurrentUserOrg().getAcd202());
			    sysOrg.setAae036(new Date());
			    sysOrg.setAae022(ContextUtil.getCurrentUserOrg().getAab301());
			    sysOrg.setAczy06(SystemConst.DATA_SOURCE_BS);
				sysOrgService.add(sysOrg);
			}else{
				resultMsg="更新机构信息";
				sysOrgService.update(sysOrg);
				
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
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("isExist")
	@Action(description = "判断机构名称或者许可证编号是否存在")
	@ResponseBody
	public ResultMessage isExist(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ResultMessage resultMessage = null;
		try {
			QueryFilter fiter = new QueryFilter(request);
			List<SysOrg> list = sysOrgService.getAll(fiter);
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
	 * 取得职介机构表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	@Action(description="查看职介机构表分页列表")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		
		ModelAndView mv=this.getAutoView();
		
		return mv;
	}
	/**
	 * 取得职介机构表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="查看职介机构表分页列表")
	@ResponseBody
	public Map<Object,Object> listJosn(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		String aab034 = request.getParameter("aab034");
		if(StringUtil.isEmpty(aab034)){
			if(!SystemConst.KEY_MANAGER.equals(ContextUtil.getCurrentUser().getCczh01())){
			fiter.addFilter("aab034", ContextUtil.getCurrentUserOrg().getAcd200());
			}
		}
	    int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
	    ResultData<SysOrg> resultData = sysOrgService.getPageList(fiter);	
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 删除职介机构表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除职介机构表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//String preUrl= RequestUtil.getPrePage(request);
		ResultMessage message=null;
		try{
			Long acd200 =RequestUtil.getLong(request, "acd200");
			List<SysOrg> orgLst=sysOrgService.getSubOrgList(acd200);
			if(orgLst!=null&&orgLst.size()>0){
				message=new ResultMessage(ResultMessage.Fail, "机构下有子机构，不允许删除!");	
				return message;
			}
			@SuppressWarnings("rawtypes")
			List deptList=sysDeptService.getAll(new QueryFilter(request) );
			if(deptList!=null&&deptList.size()>0){
				message=new ResultMessage(ResultMessage.Fail, "机构下有部门，不允许删除!");	
			}else{
				sysOrgService.delById(acd200);
				message=new ResultMessage(ResultMessage.Success, "删除职介机构表成功!");
			}
			
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return message;
		//addMessage(message, request);
		//response.sendRedirect(preUrl);
	}
	
	/**
	 * 	新增职介机构表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增职介机构表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		String acd200 = request.getParameter("acd200");
		SysOrgForm  sysOrgForm=new SysOrgForm();
		SysOrg sysOrg = new SysOrg();
		//为新添加机构默认父级机构
		sysOrg.setAab034(StringUtil.isEmpty(acd200)?String.valueOf(ContextUtil.getCurrentUserOrg().getAcd200()):acd200);
		//默认机构分类
		sysOrg.setAcd20s("2");
		//默认机构性质
		sysOrg.setAcd204("10");
		sysOrgForm.putModel(sysOrg);
		ModelAndView modelAndView= new ModelAndView("/sys/uums/sysOrgEdit.jsp");
		//默认当前登录用户机构
		return modelAndView.addObject("sysOrgForm",sysOrgForm).addObject("sysOrgs",getOrganSelectList());					
	}

	/**
	 *  获取机构下拉选择框数据
	 * @return list
	 */
	public  List<SysOrg> getOrganSelectList(){
		List<SysOrg> organizations = new ArrayList<SysOrg>();
		SysOrg emptyObj = new SysOrg();
		emptyObj.setAcd202("根目录");
		if(SystemConst.KEY_MANAGER.equals(ContextUtil.getCurrentUser().getCczh01())){
			organizations.add(emptyObj);	
		}
		List<SysOrg> list = super.getOrganSelectList();
		organizations.addAll(list);
		return organizations;
	}
    
	/**
	 * 	编辑机构信息
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑机构信息")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long acd200=RequestUtil.getLong(request,"acd200",0L);
		SysOrg sysOrg =sysOrgService.getById(acd200);
		SysOrgForm  sysOrgForm=new SysOrgForm();
		sysOrgForm.putModel(sysOrg);
		sysOrgForm.setCabq02(sysOrg.getCabq02()==null?"":sysOrg.getCabq02().toString());
		sysOrgForm.setCabq03(sysOrg.getCabq03()==null?"":sysOrg.getCabq03().toString());
		//机构列表
		List<SysOrg> orgs = getOrganSelectList();
		List<SysOrg> resultorgs = new ArrayList<SysOrg>();
		for (SysOrg sysOrg2 : orgs) {
			if(!acd200.equals(sysOrg2.getAcd200())){
				resultorgs.add(sysOrg2);
			}
		}
		return getAutoView().addObject("sysOrgForm",sysOrgForm).addObject("sysOrgs",resultorgs).addObject("isEdit", true);					
	}
    
	/**
	 * 取得职介机构表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看职介机构表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long acd200=RequestUtil.getLong(request,"acd200");
		SysOrg sysOrg = sysOrgService.getById(acd200);	
		return getAutoView().addObject("sysOrg", sysOrg);
	}
	
	
	/**
	 * 取得科室表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("treeJson")
	@Action(description="显示组织机构树")
	@ResponseBody
	public List<Object> treeJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		List<Object> list = new ArrayList<Object>();
		if (SystemConst.KEY_MANAGER.equals(ContextUtil.getCurrentUser().getCczh01())) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("id", "0");
		map.put("acd200", "0");
		map.put("pId", "");
		map.put("name", "根目录");
		map.put("open", true);
		map.put("nodeType", "root");
		// map.put("isParent","true" );
		list.add(map);
		//为Organization 添加get id pid name 方法
		List<SysOrg> articleColumnList = sysOrgService.getAll();
		list.addAll(articleColumnList);
		}else{
			list.addAll(sysOrgService.getSubOrgans(ContextUtil.getCurrentUserOrg().getAcd200()));
		}
		return list;

	}
}
