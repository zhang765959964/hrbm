package com.xunfeng.business.machine.web;

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

import com.xunfeng.business.machine.interf.MachineServiceInterf;
import com.xunfeng.business.machine.model.Machine;
import com.xunfeng.business.machine.web.form.MachineForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 查询机管理表 控制器类
* @author:wanghan
* @createDate 2015-11-23 10:15:36 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/machine/machine/")
public class MachineController extends BaseController
{
	@Resource
	@Qualifier("machine")
	private MachineServiceInterf machineService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf UniqueIdUtil;	
	
	/**
	 * 添加或更新查询机管理表。
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新查询机管理表")
	public void save(HttpServletRequest request, HttpServletResponse response,MachineForm machineForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    Machine machine = machineService.getById(id);
			machine=machineForm.getModel(machine);
			if(machineForm.isMvcAdd()){
				resultMsg="添加查询机管理表";
				machine.setId(UniqueIdUtil.genId(Machine.class.getName()));
				machineService.add(machine);
				message=new ResultMessage(ResultMessage.Success, machine.getId().toString());
			}else{
				resultMsg="更新查询机管理表";
			    machineService.update(machine);
				message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			}
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}

	/**
	 * 开通电子地图
	 * @throws Exception
	 */
	@RequestMapping("open-map")
	@ResponseBody
	public ResultMessage openMap(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ResultMessage message=null;
		try{
			Float x = RequestUtil.getFloat(request, "x");
			Float y = RequestUtil.getFloat(request, "y");
			Long zoom = RequestUtil.getLong(request, "zoom");
			Long id = RequestUtil.getLong(request, "id");
			machineService.openMap(x,y,zoom,id);
			message=new ResultMessage(ResultMessage.Success, "电子地图设置成功！");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "点在地图设置失败！<br>" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return message;
	}
	/**
	 * 取得查询机管理表分页列表
	 * @param request
	 * @param response
	 * @param page
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
	 * 取得查询机管理表分页列表
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
		List<Machine> list=machineService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除查询机管理表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除查询机管理表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			machineService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除查询机管理表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增查询机管理表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增查询机管理表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		MachineForm  machineForm=new MachineForm();
		machineForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/machine/machineAdd.jsp");
		
		return modelAndView.addObject("machineForm",machineForm);					
	}
	/**
	 * 	编辑查询机管理表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑查询机管理表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		Machine machine=machineService.getById(id);
		MachineForm  machineForm=new MachineForm();
		machineForm.putModel(machine);
		return getAutoView().addObject("machineForm",machineForm).addObject("machine",machine);
	}

	/**
	 * 取得查询机管理表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看查询机管理表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		Machine machine = machineService.getById(id);	
		return getAutoView().addObject("machine", machine);
	}
	
}
