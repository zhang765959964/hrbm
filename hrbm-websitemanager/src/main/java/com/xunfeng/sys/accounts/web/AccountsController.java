package com.xunfeng.sys.accounts.web;

import java.util.List;
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
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.PersonStaEnum;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.interf.SysUserServiceInterf;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.accounts.interf.AccountsServiceInter;
import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.accounts.web.form.AccountsForm;

 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 用户信息表 控制器类
* @author:wanlupeng
* @createDate 2016-08-18 14:32:33 
* @version V1.0   
*/
@Controller
@RequestMapping("/sys/accounts/accounts/")
public class AccountsController extends BaseController
{
	@Resource
	@Qualifier("accounts")
	private AccountsServiceInter accountsService;
	@Resource
	@Qualifier("sysuser")
	private SysUserServiceInterf sysUserService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新用户信息表。
	 * @param request
	 * @param response
	 * @param accountsForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新用户信息表")
	public void save(HttpServletRequest request, HttpServletResponse response,AccountsForm accountsForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long ccmu01=RequestUtil.getLong(request,"ccmu01");
		    Accounts accounts = accountsService.getById(ccmu01);
			accounts=accountsForm.getModel(accounts);
			if(accountsForm.isMvcAdd()){
				resultMsg="添加用户信息表";
				//accounts.setCcmu01(uniqueIdUtil.genSeqId(SqeIdName.Accounts.getSeqName()));
				accounts.setCcmu01(uniqueIdUtil.genId(Accounts.class.getName()));
				accountsService.add(accounts);
			}else{
				resultMsg="更新用户信息表";
			    accountsService.update(accounts);
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
	 * 取得用户信息表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/sys/accounts/accountsList.jsp");
		List<SysUser> list=sysUserService.getAll();
		return mv.addObject("userList",list).addObject("orgs", getOrganSelectList()).addObject("stas", PersonStaEnum.values());
	}
	
	
	/**
	 * 取得用户信息表分页列表
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
		ResultData<Map> resultData=accountsService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	/**
	 * 取得用户信息表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("corpList")
	public ModelAndView corpList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/sys/accounts/accountsCorpList.jsp");
		List<SysUser> list=sysUserService.getAll();
		return mv.addObject("userList",list).addObject("orgs", getOrganSelectList()).addObject("stas", PersonStaEnum.values());
	}
	/**
	 * 取得用户信息表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJsonCorp")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listJsonCorp(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData<Map> resultData=accountsService.getAllByCorp(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除用户信息表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除用户信息表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "ccmu01");
			accountsService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除用户信息表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增用户信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增用户信息表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		AccountsForm  accountsForm=new AccountsForm();
		accountsForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/sys/accounts/accountsEdit.jsp");
		
		return modelAndView.addObject("accountsForm",accountsForm);					
	}
	/**
	 * 	编辑用户信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑用户信息表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long ccmu01=RequestUtil.getLong(request,"ccmu01",0L);
		Accounts accounts=accountsService.getById(ccmu01);
		AccountsForm  accountsForm=new AccountsForm();
		accountsForm.putModel(accounts);
		ModelAndView modelAndView= new ModelAndView("/sys/accounts/accountsEdit.jsp");
		return modelAndView.addObject("accountsForm",accountsForm);					
	}

	/**
	 * 取得用户信息表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看用户信息表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long ccmu01=RequestUtil.getLong(request,"ccmu01");
		Accounts accounts = accountsService.getById(ccmu01);	
		return getAutoView().addObject("accounts", accounts);
	}
	
	@RequestMapping("isExist")
	@Action(description = "修改账号密码")
	@ResponseBody
	public void isExist(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ResultMessage resultMessage = null;
		try {
			Long ccmu01=RequestUtil.getLong(request,"ccmu01");
			String ccmu03=RequestUtil.getString(request,"ccmu03");
			int len = ccmu03.length();
			if(len>=50){
				resultMessage = new ResultMessage(ResultMessage.Fail, "密码长度过长，密码最多输入20个字符");
				writeResultMessage(response.getWriter(),resultMessage);
			}else{
				Accounts account=accountsService.getById(ccmu01);
				if (account==null) {
					resultMessage = new ResultMessage(ResultMessage.Fail, "请选择记录");
					writeResultMessage(response.getWriter(),resultMessage);
				} else {
					account.setCcmu03(ccmu03);
					accountsService.update(account);
					resultMessage = new ResultMessage(ResultMessage.Success, "密码修改成功");
					writeResultMessage(response.getWriter(),resultMessage);
				}
			}
		} catch (Exception ex) {
			resultMessage = new ResultMessage(ResultMessage.Fail, "未知错误");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),resultMessage);
		}
	}
	
}
