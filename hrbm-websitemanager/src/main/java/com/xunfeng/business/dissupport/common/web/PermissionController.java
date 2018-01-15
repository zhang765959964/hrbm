package com.xunfeng.business.dissupport.common.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xunfeng.business.corp.interf.CorpServiceInter;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.util.RequestUtil;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 设备表 控制器类
* @author:wanghan
* @createDate 2016-07-27 11:46:42 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/dissupport/common/permission")
public class PermissionController extends BaseController
{
	@Resource
	@Qualifier("corp")
	private CorpServiceInter corpService;
	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf personBaseInfoService;

	
	/**
	 * 取得设备表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("hasEditPermi")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		Map map=new HashMap();
		 String acd200=ContextUtil.getCurrentUserOrg().getAcd200().toString();
		 if("1".equals(acd200)){
			 return judgeOrg(acd200, "1");
		 }
		 String type=RequestUtil.getString(request, "type");
		 String judgeId=RequestUtil.getString(request, "judgeId");
		 if("0".equals(type)){//按经办机构Id判断
			 return judgeOrg(acd200,judgeId);
		 }else if("1".equals(type)){//按人员经办机构Id判断
			 return judgePerson( acd200, judgeId);
		 }else if("2".equals(type)){//按单位经办机构Id判断
			 return judgeCorp( acd200, judgeId);
		 }
        
		 return judgeOrg(acd200,"");
	}
	
	private Map judgeOrg(String acd200,String orgId){
		Map map=new HashMap();
		if(StringUtil.isEmpty(orgId)){
			 map.put("hasPermi", true); 
			 return map;
		 }
		 if(acd200.equals(orgId)){
			 map.put("hasPermi", true);
		 }else{
			 map.put("hasPermi", false);
		 }
		 return  map;
	}
	private Map judgeCorp(String acd200,String judgeId){
		Map map=new HashMap();
		Long count=corpService.getNoPermissionCount(judgeId, Long.valueOf(acd200));
		if(count>0){
			map.put("hasPermi", false);
		}else{
			map.put("hasPermi", true);
		}
		 return  map;
	}
	private Map judgePerson(String acd200,String judgeId){

		Map map=new HashMap();
		Long count=personBaseInfoService.getNoPermissionCount(judgeId, Long.valueOf(acd200));
		if(count>0){
			map.put("hasPermi", false);
		}else{
			map.put("hasPermi", true);
		}
		 return  map;
	}
}
