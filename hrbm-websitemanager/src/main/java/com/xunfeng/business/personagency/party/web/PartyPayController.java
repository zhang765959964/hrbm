package com.xunfeng.business.personagency.party.web;

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

import com.xunfeng.business.personagency.party.interf.PartyPayServiceInterf;
import com.xunfeng.business.personagency.party.interf.PartyServiceInterf;
import com.xunfeng.business.personagency.party.model.PartyPay;
import com.xunfeng.business.personagency.party.web.form.PartyPayForm;
import com.xunfeng.business.personagency.party.web.form.PayResultForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 党费缴纳 控制器类
* @author:zhangfan
* @createDate 2016-08-16 17:44:26 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/party/pay/")
public class PartyPayController extends BaseController
{
	@Resource
	@Qualifier("partyPay")
	private PartyPayServiceInterf partyPayService;
	
	@Resource
	@Qualifier("party")
	private PartyServiceInterf partyService;
	
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新党费缴纳。
	 * @param request
	 * @param response
	 * @param partyPayForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新党费缴纳")
	public void save(HttpServletRequest request, HttpServletResponse response,PartyPayForm partyPayForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		initCreater(partyPayForm);
		try{
			
			PartyPay partyPay = BeanToBean.copyProperties(partyPayForm, new PartyPay(), false);
			partyPayService.saveOrUpdate(partyPay);
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");

			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	/**
	 * 取得党费缴纳分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/party/partyPayList.jsp");
		
		return mv;
	}

	
	/**
	 * 党费交纳统计页面
	 **/
	@RequestMapping("partyPayResultList")
	public ModelAndView getPartyPayResultList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		
		Long partyStatus = partyService.getPartyStatus();	//代管组织人数
		
		Long partyOweSum =  partyService.getPartyOweSum();	//欠费人数
		
		Long sumParty = partyService.getSumPerson();
		Long jfParty = partyService.getJfPerson();
		Long dontJfParty=0L;
		if(sumParty!=null&&jfParty!=null){
			dontJfParty = sumParty-jfParty;
		}
		
		ModelAndView mv= new ModelAndView("/business/personagency/party/partyPayResultList.jsp");
		return mv.addObject("sumParty", sumParty).addObject("jfParty", jfParty)
				.addObject("dontJfParty", dontJfParty).addObject("partyStatus", partyStatus).addObject("partyOweSum", partyOweSum);
	}

	
	/**
	 * 适用于综合查询代理详细查询 
	 * 取得党组织关系缴费信息列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("partyPayvListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> getByvPersonId(HttpServletRequest request,HttpServletResponse response) throws Exception{
		QueryFilter fiter=new QueryFilter(request);
		Long personId = RequestUtil.getLong(request, "personId");
		fiter.addFilter("personId", personId);
		ResultData resultData=partyPayService.getByvPersonId(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	/**
	 * 党费交纳json列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("partyPayResultJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> partyPayResultJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		QueryFilter fiter1=new QueryFilter(request,false);
		ResultData resultData=partyPayService.getPartyPayResultList(fiter);
		PayResultForm rs = new PayResultForm();
		List list = partyPayService.getPartyPayResult(fiter1);	//求出总金额
		Map<String,Long> ma=(Map<String, Long>) list.get(0);
		BeanUtils.populateEntity(ma, rs);
		Map<Object,Object> map =  getJqGridData(resultData.getPageBean(), resultData.getDataList());
		map.put("payMoney", rs.getPayMoney()==null ?0:rs.getPayMoney());
		return map;
	}
	
	
	
	/**
	 * 取得党费缴纳分页列表
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
		QueryFilter fiter1=new QueryFilter(request,false);
		ResultData<PartyPay> resultData=partyPayService.getPartyPayList(fiter);
		PayResultForm rs = new PayResultForm();
		List list = partyPayService.getPartyPayResult(fiter1);	//求出总金额
		List sumList = partyPayService.getPartyPayCount(fiter1);	//求出缴费人数
		Map<String,Long> sum=(Map<String, Long>) sumList.get(0);
		Map<String,Long> ma=(Map<String, Long>) list.get(0);
		BeanUtils.populateEntity(ma, rs);
		BeanUtils.populateEntity(sum, rs);
		Map<Object,Object> map= getJqGridData(resultData.getPageBean(), resultData.getDataList());
		map.put("sumCount", rs.getSumCount()==null?0:rs.getSumCount());
		map.put("payMoney", rs.getPayMoney()==null ?0:rs.getPayMoney());
		return map;
	}
	
	
	
	/**
	 * 缴费记录json列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getAllListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> getAllListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData<PartyPay> resultData=partyPayService.getAllByFilter(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	


	
	/**
	 * 删除党费缴纳
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除党费缴纳")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			partyPayService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除党费缴纳成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增党费缴纳
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增党费缴纳")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		PartyPayForm  partyPayForm=new PartyPayForm();
		partyPayForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/party/partyPayEdit.jsp");
		
		return modelAndView.addObject("partyPayForm",partyPayForm);					
	}
	/**
	 * 	编辑党费缴纳
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑党费缴纳")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		PartyPay partyPay=partyPayService.getById(id);
		PartyPayForm  partyPayForm=new PartyPayForm();
		partyPayForm.putModel(partyPay);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/party/partyPayEdit.jsp");
		return modelAndView.addObject("partyPayForm",partyPayForm);					
	}

	
	/**
	 * 查看党员缴费详情
	 * @throws Exception
	 */
	@RequestMapping("getPartyPayById")
	@Action(description="编辑党费缴纳")
	public ModelAndView getPartyPayById(HttpServletRequest request) throws Exception{
		Long payId=RequestUtil.getLong(request,"payId",0L);
		Object object = partyPayService.getPartyPayById(payId);
		ModelAndView mv= new ModelAndView("/business/personagency/party/partyPayEdit.jsp");
		return mv.addObject("object", object);
	}
	
	
	
	
	/**
	 * 取得党费缴纳明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看党费缴纳明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		PartyPay partyPay = partyPayService.getById(id);	
		return getAutoView().addObject("partyPay", partyPay);
	}
	
}
