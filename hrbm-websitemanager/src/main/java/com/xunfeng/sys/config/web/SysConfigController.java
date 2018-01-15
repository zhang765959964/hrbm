package com.xunfeng.sys.config.web;

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

import com.alibaba.fastjson.JSON;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.config.interf.SysConfigServiceInter;
import com.xunfeng.sys.config.model.SysConfig;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysUser;
/**
 *<pre>
 * 对象功能:RSDA_SYS_CONFIG 控制器类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-05-23 14:46:39
 *</pre>
 */
@Controller
@RequestMapping("/sys/config/sysConfig")
public class SysConfigController extends BaseController
{
	@Resource
	@Qualifier("config")
	private SysConfigServiceInter sysConfigService;
	
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf UniqueIdUtil;	
	/**
	 * 添加或更新RSDA_SYS_CONFIG。
	 * @param request
	 * @param response
	 * @param sysConfig 添加或更新的实体
	 * @param bindResult
	 * @param viewName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新RSDA_SYS_CONFIG")
	public void save(HttpServletRequest request, HttpServletResponse response,SysConfig sysConfig) throws Exception
	{
		String resultMsg=null;		
		try{
			if(sysConfig.getId()==null||sysConfig.getId()==0){
				sysConfig.setId(UniqueIdUtil.genId(SysConfig.class.getName()));
				sysConfigService.add(sysConfig);
				resultMsg=getText("添加","RSDA_SYS_CONFIG");
			}else{
			    sysConfigService.update(sysConfig);
				resultMsg=getText("更新","RSDA_SYS_CONFIG");
			}
			writeResultMessage(response.getWriter(),resultMsg,ResultMessage.Success);
		}catch(Exception e){
			writeResultMessage(response.getWriter(),resultMsg+","+e.getMessage(),ResultMessage.Fail);
		}
	}
	
	
	/**
	 * 取得RSDA_SYS_CONFIG分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	@Action(description="查看RSDA_SYS_CONFIG分页列表")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		 
		ModelAndView mv=this.getAutoView();
		
		return mv;
	}
	
	/**
	 * 删除RSDA_SYS_CONFIG
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除RSDA_SYS_CONFIG")
	public void del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String preUrl= RequestUtil.getPrePage(request);
		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			sysConfigService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除RSDA_SYS_CONFIG成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
		}
		addMessage(message, request);
		response.sendRedirect(preUrl);
	}
	
	/**
	 * 	编辑RSDA_SYS_CONFIG
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑RSDA_SYS_CONFIG")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		String returnUrl=RequestUtil.getPrePage(request);
		SysConfig sysConfig = new SysConfig();
		SysUser sysUser = ContextUtil.getCurrentUser();
		 
		 
		
		return getAutoView().addObject("sysConfig",sysConfig)
							.addObject("returnUrl",returnUrl);
	}

	/**
	 * 取得RSDA_SYS_CONFIG明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看RSDA_SYS_CONFIG明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		SysConfig sysConfig = sysConfigService.getById(id);	
		return getAutoView().addObject("sysConfig", sysConfig);
	}
	/**
	 * 获取datagrid数据
	 */
	@RequestMapping("listJson")
	@Action(description="获取息的datgrid数据")
	@ResponseBody
	public Object getAllConfig(HttpServletRequest request, HttpServletResponse response){
		try{
			QueryFilter filter=new QueryFilter(request);
			List<SysConfig> results = sysConfigService.getDatagridData(filter);
			Map map = getTableData(filter.getPageBean().getTotalCount(),results); 
			return JSON.toJSON(map);
			
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		
		return null;
	}
	
	@RequestMapping("ajaxDel")
	@Action(description = "删除配置信息")
	public void ajaxDel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultMsg = null;
		try {
			Long[] lAryId = RequestUtil.getLongAryByStr(request, "id");
			sysConfigService.delByIds(lAryId);
			resultMsg = getText("删除配置信息成功", "bsPerson");
			writeResultMessage(response.getWriter(), resultMsg, ResultMessage.Success);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			writeResultMessage(response.getWriter(), resultMsg + "," + e.getMessage(), ResultMessage.Fail);
		}

	}
	
	
	
	@RequestMapping("baseConfig")
	public ModelAndView getBaseConfigs(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView("/sys/config/baseConfig.jsp");
		List<SysConfig> baseConfigs = sysConfigService.getBaseConfigs();
		mv.addObject("baseConfigs", baseConfigs);
		mv.addObject("districtConfig",sysConfigService.getConfigByName("districtCode"));
		return mv;
	}
	
	@RequestMapping("saveBaseConfig")
	@Action(description = "添加或更新个人基本信息表")
	public void saveBaseConfig(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String preUrl = RequestUtil.getPrePage(request);
		String resultMsg = "修改基础配置信息";
		ResultMessage message = null;
		try {
			Long[] ids =  RequestUtil.getLongAry(request, "id");
			String[] values = request.getParameterValues("name");
			sysConfigService.saveBaseConfig(ids, values);
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			 
		} catch (Exception e) {
			logger.debug(e.getMessage());
			writeResultMessage(response.getWriter(), resultMsg + "," + e.getMessage(), ResultMessage.Fail);
		}
		addMessage(message, request);
		response.sendRedirect(preUrl);
	}
	
	
	
	
	
	
	
	
}
