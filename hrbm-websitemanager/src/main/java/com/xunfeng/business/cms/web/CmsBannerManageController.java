package com.xunfeng.business.cms.web;

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

import com.xunfeng.business.cms.interf.CmsBannerManageServiceInterf;
import com.xunfeng.business.cms.model.CmsBannerManage;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 栏目板块管理 比如快速栏目中的前十个信息名称 控制器类
* @author:wanghan
* @createDate 2016-03-22 16:46:24 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/cms/cmsBannerManage/")
public class CmsBannerManageController extends BaseController
{
	@Resource
	@Qualifier("cmsBannerManage")
	private CmsBannerManageServiceInterf cmsBannerManageService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	/**
	 * 添加栏目板块
	 */
	@RequestMapping("save")
	@Action(description="添加栏目板块")
	public void save(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
			String indent = RequestUtil.getString(request, "indent", "fc");
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "cmsid");
			String[] nameArray =RequestUtil.getStringAryByStr(request, "cmsname");
		    for(int i = 0;i<lAryId.length;i++){
		    	CmsBannerManage cbm = new CmsBannerManage();
		    	cbm.setId(uniqueIdUtil.genId(CmsBannerManage.class.getName()));
		    	cbm.setCmsid(lAryId[i]);
		    	cbm.setOrdernum(0l);
		    	cbm.setCmsname(java.net.URLDecoder.decode(nameArray[i],"UTF-8"));
		    	cbm.setIndent(indent);
		    	cmsBannerManageService.add(cbm);
		    	resultMsg="添加成功";
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
	 * 栏目板块列表 (页面)
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=this.getAutoView();
		return mv;
	}
	/**
	 * 取得栏目板块列表数据(数据)
	 */
	@RequestMapping("listJson")
	@Action(description="取得栏目板块列表数据")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		String indent = RequestUtil.getString(request, "indent", "fc");
		List<CmsBannerManage> list=cmsBannerManageService.getList(indent);		
		return getTableData(1l, list);
		
	}
	/**
	 * 删除栏目板块
	 */
	@RequestMapping("del")
	@Action(description="删除栏目板块")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			cmsBannerManageService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除栏目板块管理 比如快速栏目中的前十个信息名称成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	/**
	 * 栏目板块排序
	 */
	@RequestMapping("sortOrderNum")
	@Action(description="栏目板块排序")
	@ResponseBody
	public ResultMessage sortOrderNum(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			for(int i=0;i<lAryId.length;i++){
				cmsBannerManageService.sortOrderNum(lAryId[i], (long)i);
			}
			message=new ResultMessage(ResultMessage.Success, "排序成功");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "排序失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
}
