package com.xunfeng.sys.login.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.sys.uums.service.SysUserService;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.accounts.service.AccountsService;
import com.xunfeng.util.Json;

 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 用户信息表 控制器类
* @author:jx
* @createDate 2016-11-05 09:39:33 
* @version V1.0   
*/
@Controller
@RequestMapping("/sys/login/")
public class LoginController extends BaseController
{
	@Resource
	private SysUserService sysUserService;
	
	
	
	//app登录接口   蒋鑫  2016.11.05
	@RequestMapping("appLogin")
	@ResponseBody
	public Json appLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Json json = new Json();
		QueryFilter queryFilter=new  QueryFilter(request);
		Map<String,Object> map = queryFilter.getFilters();
		String userName = (String)map.get("username");
		String password = (String)map.get("password");
		String encrptPassword=password;
		try{
			SysUser sysUser = sysUserService.getByUserName(userName);
			if(sysUser==null){
				json.setMsg("用户名不存在！");
			}else{
				if(!encrptPassword.equals(sysUser.getCczh02())){
					json.setMsg("密码输入错误！");
				}else{
					json.setSuccess(true);
					json.setMsg("登录成功！");
					Map mapUser = new HashMap();
					mapUser.put("userid", sysUser.getAcd230());
					mapUser.put("username",sysUser.getAac003());
					json.setObj(mapUser);
				}
			}
		}catch(Exception e){
			json.setMsg("登录失败！");
		}
		return json;
	}
}
