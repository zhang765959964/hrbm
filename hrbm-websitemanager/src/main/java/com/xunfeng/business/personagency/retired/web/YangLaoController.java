package com.xunfeng.business.personagency.retired.web;


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

import com.xunfeng.business.personagency.retired.dto.RetiredYlDto;
import com.xunfeng.business.personagency.retired.interf.RetiredDeclareServiceInterf;
import com.xunfeng.business.personagency.retired.interf.YangLaoServiceInterf;
import com.xunfeng.business.personagency.retired.model.RetiredDeclare;
import com.xunfeng.business.personagency.retired.model.YangLao;
import com.xunfeng.business.personagency.retired.web.form.YangLaoForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 养老待遇申请 控制器类
* @author:zhangfan
* @createDate 2016-07-25 16:20:07 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/yanglao/")
public class YangLaoController extends BaseController
{
	@Resource
	@Qualifier("yangLao")
	private YangLaoServiceInterf yangLaoService;
	
	@Resource
	@Qualifier("retiredDeclare")
	private RetiredDeclareServiceInterf retiredDeclareService;
	
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	@RequestMapping("save")
	@Action(description="添加或更新养老待遇申请")
	public void save(HttpServletRequest request, HttpServletResponse response,YangLaoForm yangLaoForm) throws Exception
	{
		
		String resultMsg=null;	
		ResultMessage message=null;	
		try {
			resultMsg = "养老待遇申请";
			RetiredYlDto retiredYlDto  = BeanToBean.copyProperties(yangLaoForm, new RetiredYlDto(), false);
			if(yangLaoForm.getYlForm().getStatusName().equals("申报完毕")){
				resultMsg = "已申报完毕，不能更改";
				message=new ResultMessage(ResultMessage.Success, resultMsg);
				writeResultMessage(response.getWriter(),message);
				return;
			}else{
				resultMsg = "养老待遇申请"; 
				yangLaoService.saveOrUpdate(retiredYlDto);
				if(retiredYlDto.getId()!=null&&retiredYlDto.getId()>0){
					resultMsg = "养老待遇申请修改"; 
				}
				message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
				writeResultMessage(response.getWriter(),message);
				return;
			}
		} catch (Exception ex) {
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	@RequestMapping("saveRetiredPl")
	@Action(description="添加或更新养老待遇申请")
	public void saveRetiredPl(HttpServletRequest request, HttpServletResponse response,YangLaoForm yangLaoForm1) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try {
			resultMsg = "养老待遇申请";
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pk_id");
			RetiredYlDto retiredYlDto  = BeanToBean.copyProperties(yangLaoForm1, new RetiredYlDto(), false);
			for (Long retiredId : lAryId) {
				RetiredDeclare retiredDeclare = retiredDeclareService.getByPersonId(retiredId);
				
					if(retiredDeclare.getRetiredDeclareStatus().equals("2")||retiredDeclare.getRetiredDeclareStatus().equals("3")){
						resultMsg = "你选择的数据不合法，请选择待申报数据！";
						message=new ResultMessage(ResultMessage.Success, resultMsg);
						writeResultMessage(response.getWriter(),message);
						return;
					}else{
						yangLaoService.saveOrRetiredPl(lAryId, retiredYlDto);
						message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
						writeResultMessage(response.getWriter(),message);
						return;
					}
			}
		} catch (Exception ex) {
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	/**
	 * 取得养老待遇申请分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/retired/yangLaoList.jsp");
		
		return mv;
	}
	/**
	 * 取得养老待遇申请分页列表
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
		List<YangLao> list=yangLaoService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除养老待遇申请
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除养老待遇申请")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			yangLaoService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除养老待遇申请成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增养老待遇申请
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增养老待遇申请")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		YangLaoForm  yangLaoForm=new YangLaoForm();
		yangLaoForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/yangLaoEdit.jsp");
		
		return modelAndView.addObject("yangLaoForm",yangLaoForm);					
	}
	/**
	 * 	编辑养老待遇申请
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑养老待遇申请")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		YangLao yangLao=yangLaoService.getById(id);
		YangLaoForm  yangLaoForm=new YangLaoForm();
		yangLaoForm.putModel(yangLao);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/yangLaoEdit.jsp");
		return modelAndView.addObject("yangLaoForm",yangLaoForm);					
	}

	/**
	 * 取得养老待遇申请明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看养老待遇申请明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		YangLao yangLao = yangLaoService.getById(id);	
		return getAutoView().addObject("yangLao", yangLao);
	}
	
}
