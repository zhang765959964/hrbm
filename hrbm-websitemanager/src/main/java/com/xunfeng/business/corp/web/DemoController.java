package com.xunfeng.business.corp.web;


import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.xunfeng.business.cation.interf.AuthenticationServiceInterf;
import com.xunfeng.business.corp.interf.CorpServiceInter;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.corp.web.form.CorpForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.interf.SysOrgServiceInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位基本信息表 控制器类
* @author:wanghan
* @createDate 2015-11-03 14:28:56 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/demo/")
public class DemoController extends BaseController
{
	private static final String Corp = null;
	@Resource
	@Qualifier("corp")
	private CorpServiceInter corpService;
	@Resource
	@Qualifier("authentication")
	private AuthenticationServiceInterf authenticationService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf UniqueIdUtil;	
	@Resource
	@Qualifier("sysorg")
	private SysOrgServiceInterf sysOrgService;
	/**
	 * 添加或更新单位基本信息表。
	 * @param request
	 * @param response
	 * @param corp 添加或更新的实体
	 * @param bindResult
	 * @param viewName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新单位基本信息表")
	public void save(HttpServletRequest request, HttpServletResponse response,CorpForm corpForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long aab001=RequestUtil.getLong(request,"aab001");
		    Corp corp = corpService.getById(aab001);
			corp=corpForm.getModel(corp);
			if(corpForm.isMvcAdd()){
				resultMsg="添加单位基本信息表";
				corp.setAab001(UniqueIdUtil.genId(Corp.class.getName()));
				corpService.add(corp);
				
			}else{
				resultMsg="更新单位基本信息表";
			    corpService.update(corp);
				
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");

			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	
	@RequestMapping("tapEdit")
	public ModelAndView demoTab(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=new ModelAndView("/business/demo/tapEdit.jsp");
		return mv;
	}
	
	
	@RequestMapping("tapEdit1")
	public ModelAndView demoTab1(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=new ModelAndView("/business/demo/tapEdit1.jsp");
		return mv;
	}
	
	@RequestMapping("tapEdit2")
	public ModelAndView demoTab2(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=new ModelAndView("/business/demo/tapEdit2.jsp");
		return mv;
	}
	
	@RequestMapping("commonjsp")
	public ModelAndView common(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		String viewJspKey = request.getParameter("viewJspKey");
		ModelAndView mv=new ModelAndView("/business/demo/"+viewJspKey+".jsp");
		return mv;
	}
	
	
	/**
	 * 取得单位基本信息表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("demoList")
	public ModelAndView demolist(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=new ModelAndView("/business/demo/demoList.jsp");
		return mv;
	}
	
	@RequestMapping("demoAdd")
	@Action(description="新增单位协议表")
	public ModelAndView demoAdd(HttpServletRequest request) throws Exception
	{
		ModelAndView modelAndView= new ModelAndView("/business/demo/demoEdit.jsp");
		return modelAndView;			
	}
	
	@RequestMapping("button")
	@Action(description="新增单位协议表")
	public ModelAndView button(HttpServletRequest request) throws Exception
	{
		ModelAndView modelAndView= new ModelAndView("/business/demo/button.jsp");
		return modelAndView;			
	}
	
	/**
	 * 取得单位基本信息表分页列表
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
	 * 取得单位基本信息表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="取得单位基本信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
		ResultData<Corp> resultData=corpService.getAllCorp(fiter);
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	
	
}
