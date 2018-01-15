package com.xunfeng.business.personagency.receive.web;

import java.util.Date;
import java.util.Iterator;
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
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.dictionary.interf.DictionaryServiceInterf;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.person.interf.PersonWorkExpceServiceInterf;
import com.xunfeng.business.person.model.PersonWorkExpce;
import com.xunfeng.business.personagency.receive.web.form.RsdaPersonWorkExpceForm;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人工作经历表 控制器类
* @author:wanghan
* @createDate 2016-07-26 17:28:38 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/receive/rsdaPersonWorkExpce/")
public class RsdaPersonWorkExpceController extends BaseController
{
	@Resource
	@Qualifier("personWorkExpce")
	private PersonWorkExpceServiceInterf personWorkExpceService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新个人工作经历表。
	 * @param request
	 * @param response
	 * @param rsdaPersonWorkExpceForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新个人工作经历表")
	public void save(HttpServletRequest request, HttpServletResponse response,RsdaPersonWorkExpceForm rsdaPersonWorkExpceForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		SysUser sysUser=ContextUtil.getCurrentUser();
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		try{
		    Long aac0b0=RequestUtil.getLong(request,"aac0b0");
		    PersonWorkExpce rsdaPersonWorkExpce = personWorkExpceService.getById(aac0b0);
			rsdaPersonWorkExpce=rsdaPersonWorkExpceForm.getModel(rsdaPersonWorkExpce);
			if(!StringUtil.isEmpty(rsdaPersonWorkExpceForm.getAac014name())){
				rsdaPersonWorkExpce.setAac014(rsdaPersonWorkExpceForm.getAac014name());
			}
			if(!StringUtil.isEmpty(rsdaPersonWorkExpceForm.getAac0b1name())){
				rsdaPersonWorkExpce.setAac0b1(rsdaPersonWorkExpceForm.getAac0b1name());
			}
			if(!StringUtil.isEmpty(rsdaPersonWorkExpceForm.getAac015name())){
				rsdaPersonWorkExpce.setAac015(rsdaPersonWorkExpceForm.getAac015name());
			}
			if(!StringUtil.isEmpty(rsdaPersonWorkExpceForm.getAac0b8name())){
				rsdaPersonWorkExpce.setAac0b8(rsdaPersonWorkExpceForm.getAac0b8name());
			}
			if(rsdaPersonWorkExpceForm.isMvcAdd()){
				resultMsg="添加个人工作经历";
				rsdaPersonWorkExpce.setAae011(sysUser.getAcd230().toString());
				rsdaPersonWorkExpce.setAae019(sysUser.getAac003());
				rsdaPersonWorkExpce.setAae017(sysOrg.getAcd200().toString());
				rsdaPersonWorkExpce.setAae020(sysOrg.getAcd202());
				rsdaPersonWorkExpce.setAae036(new Date());
				rsdaPersonWorkExpce.setCcpr08("0");
				rsdaPersonWorkExpce.setCczy06("16");
				personWorkExpceService.add(rsdaPersonWorkExpce);
			}else{
				resultMsg="更新个人工作经历";
				rsdaPersonWorkExpce.setCcpr05(new Date());            //更新时间
				rsdaPersonWorkExpce.setCcpr06(sysUser.getAac003());   //修改人
				rsdaPersonWorkExpce.setCcpr07("16");                  //修改来源
				personWorkExpceService.update(rsdaPersonWorkExpce);
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
	 * 取得个人工作经历表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		Long AAC001 = RequestUtil.getLong(request, "AAC001", 0);
		ModelAndView mv= new ModelAndView("/business/personagency/receive/rsdaPersonWorkExpceList.jsp");
		DictionaryServiceInterf dictionaryService=(DictionaryServiceInterf)AppUtil.getBean("dictionary");
		//专业技术职务
		List<Map<String ,Object>> dictionarys1 =dictionaryService.getTabList("TAB_TITLE", null);
		String aac014Value = "";
		for (Iterator iterator = dictionarys1.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			aac014Value += map.get("CODE").toString()+":"+map.get("NAME")+";";
		}
		aac014Value = aac014Value.substring(0, aac014Value.length()-1);
		//职称 
		List<Map<String ,Object>> dictionarys2 =dictionaryService.getTabList("TAB_JOBTITLE", null);
		String aac0b1Value = "";
		for (Iterator iterator = dictionarys2.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			aac0b1Value += map.get("CODE").toString()+":"+map.get("NAME")+";";
		}
		aac0b1Value = aac0b1Value.substring(0, aac0b1Value.length()-1);
		//职业资格等级
		List<Map<String ,Object>> dictionarys3 =dictionaryService.getTabList("TAB_COQ", null);
		String aac015Value = "";
		for (Iterator iterator = dictionarys3.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			aac015Value += map.get("CODE").toString()+":"+map.get("NAME")+";";
		}
		aac015Value = aac015Value.substring(0, aac015Value.length()-1);
		// 离职原因    
		List<Map<String ,Object>> dictionarys4 =dictionaryService.getTabList("TAB_LEAVEREASONS", null);
		String aac0b8Value = "";
		for (Iterator iterator = dictionarys4.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			aac0b8Value += map.get("CODE").toString()+":"+map.get("NAME")+";";
		}
		aac0b8Value = aac0b8Value.substring(0, aac0b8Value.length()-1);
		
		mv.addObject("AAC001", AAC001).addObject("aac014Value", aac014Value).addObject("aac0b1Value", aac0b1Value)
			.addObject("aac015Value", aac015Value).addObject("aac0b8Value", aac0b8Value);
		return mv;
	}
	/**
	 * 取得个人工作经历表分页列表
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
		ResultData<PersonWorkExpce> resultData=personWorkExpceService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除个人工作经历表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除个人工作经历表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "aac0b0");
			personWorkExpceService.deletePersonWorkExpceByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除个人工作经历成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增个人工作经历表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增个人工作经历表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		RsdaPersonWorkExpceForm  rsdaPersonWorkExpceForm=new RsdaPersonWorkExpceForm();
		rsdaPersonWorkExpceForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/receive/rsdaPersonWorkExpceEdit.jsp");
		
		return modelAndView.addObject("rsdaPersonWorkExpceForm",rsdaPersonWorkExpceForm);					
	}
	/**
	 * 	编辑个人工作经历表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑个人工作经历表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long aac0b0=RequestUtil.getLong(request,"aac0b0",0L);
		PersonWorkExpce rsdaPersonWorkExpce=personWorkExpceService.getById(aac0b0);
		RsdaPersonWorkExpceForm  rsdaPersonWorkExpceForm=new RsdaPersonWorkExpceForm();
		rsdaPersonWorkExpceForm.putModel(rsdaPersonWorkExpce);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/receive/rsdaPersonWorkExpceEdit.jsp");
		return modelAndView.addObject("rsdaPersonWorkExpceForm",rsdaPersonWorkExpceForm);					
	}

	/**
	 * 取得个人工作经历表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看个人工作经历表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long aac0b0=RequestUtil.getLong(request,"aac0b0");
		PersonWorkExpce rsdaPersonWorkExpce = personWorkExpceService.getById(aac0b0);	
		return getAutoView().addObject("rsdaPersonWorkExpce", rsdaPersonWorkExpce);
	}
	
}
