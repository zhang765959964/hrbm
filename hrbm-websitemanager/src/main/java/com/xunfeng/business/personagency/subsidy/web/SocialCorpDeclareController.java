package com.xunfeng.business.personagency.subsidy.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.corp.interf.CorpServiceInter;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.personagency.subsidy.dto.SocialBatchSumDto;
import com.xunfeng.business.personagency.subsidy.dto.SocialCorpDeclareDto;
import com.xunfeng.business.personagency.subsidy.interf.SocialBatchServiceInterf;
import com.xunfeng.business.personagency.subsidy.interf.SocialCorpDeclareServiceInterf;
import com.xunfeng.business.personagency.subsidy.interf.SocialSubsidyServiceInterf;
import com.xunfeng.business.personagency.subsidy.model.SocialBatch;
import com.xunfeng.business.personagency.subsidy.model.SocialCorpDeclare;
import com.xunfeng.business.personagency.subsidy.web.form.SocialCorpDeclareForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位补贴申报 控制器类
* @author:wanghan
* @createDate 2016-07-14 15:38:33 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/subsidy/socialCorpDeclare/")
public class SocialCorpDeclareController extends BaseController
{
	@Resource
	@Qualifier("socialCorpDeclare")
	private SocialCorpDeclareServiceInterf socialCorpDeclareService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	@Resource
	@Qualifier("corp")
	private CorpServiceInter corpService;
	
	@Resource
	@Qualifier("socialBatch")
	private SocialBatchServiceInterf socialBatchService;
	
	@Resource
	@Qualifier("socialSubsidy")
	private SocialSubsidyServiceInterf socialSubsidyService;
	
	/**
	 * 添加或更新单位补贴申报。
	 * @param request
	 * @param response
	 * @param socialCorpDeclareForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新单位补贴申报")
	public void save(HttpServletRequest request, HttpServletResponse response,SocialCorpDeclareForm socialCorpDeclareForm) throws Exception
	{
		String resultMsg="保存";	
		ResultMessage message=null;	
		
		try{
			SocialCorpDeclareDto socialCorpDeclareDto=BeanToBean.copyProperties(socialCorpDeclareForm, new SocialCorpDeclareDto(), false);
			socialCorpDeclareService.saveOrUpdate(socialCorpDeclareDto);
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");

			writeResultMessage(response.getWriter(),message);
		}catch(DuplicateKeyException e){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败:该批次已申报");
			logger.error(ExceptionUtil.getExceptionMessage(e));
			writeResultMessage(response.getWriter(),message);
		}
		catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	/**
	 * 取得单位补贴申报分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/subsidy/socialCorpDeclareList.jsp");
		
		return mv;
	}
	@RequestMapping("bankImportList")
	public ModelAndView bankSocialImportList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		Long id=RequestUtil.getLong(request,"id",0L);//申报ID
		SocialCorpDeclareForm  socialCorpDeclareForm=new SocialCorpDeclareForm();
		if(id!=0){	//按单位提交批次查询		
			SocialCorpDeclare socialCorpDeclare=socialCorpDeclareService.getById(id);
			SocialBatch socialBatch=socialBatchService.getById(socialCorpDeclare.getBatchId());
			Corp corp=corpService.getById(socialCorpDeclare.getCorpid());
			BeanToBean.copyProperties(corp, socialCorpDeclareForm, false);
			
			socialCorpDeclareForm.putModel(socialCorpDeclare);
			initBatch(socialCorpDeclareForm, socialBatch);
			Long totalTg = socialCorpDeclareForm.getTotalSubsidyNum()==null?0:socialCorpDeclareForm.getTotalSubsidyNum();	//通过人数
			Long tg = socialCorpDeclareForm.getPassed()==null?0:socialCorpDeclareForm.getPassed();	//未通过人数
			Long wtg = socialCorpDeclareForm.getNoPassed()==null?0:socialCorpDeclareForm.getNoPassed();	//未通过人数
			Long wsh = socialCorpDeclareForm.getNoReview() ==null ? 0:socialCorpDeclareForm.getNoReview();	//未审核的
			String approvalDesc="批次共有"+totalTg+"人次，其中已通过"+tg+"人次，未通过"+wtg+"人次。未审核"+wsh+"人次。";
			socialCorpDeclareForm.setApprovalDesc(approvalDesc);
		}
		ModelAndView mv= new ModelAndView("/business/personagency/subsidy/bankSocialImportList.jsp");
		mv.addObject("socialCorpDeclareForm",socialCorpDeclareForm);	
		return mv;
		
	}
	@RequestMapping("bankImportIndex")
	public ModelAndView bankImportIndex(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		
		ModelAndView mv= new ModelAndView("/business/personagency/subsidy/bankSocialImportIndex.jsp");
		
		return mv;
		
	}
	/**
	 * 取得单位补贴申报分页列表
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
		ResultData<Map> resultData=socialCorpDeclareService.getAllSocialCorpDeclareList(fiter);			
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	@RequestMapping("corpBatchList")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public List corpBatchList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		String searchValue=RequestUtil.getString(request, "searchValue");
		QueryFilter fiter=new QueryFilter(request);
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPagesize(10);
		fiter.setPageBean(pageBean);
		fiter.addFilter("searchValue", "%"+searchValue+"%");
		ResultData<Map> resultData=socialCorpDeclareService.getAllSocialCorpDeclareList(fiter);	
		return resultData.getDataList();
	}
	/**
	 * 删除单位补贴申报
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除单位补贴申报")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			socialCorpDeclareService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除单位补贴申报成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增单位补贴申报
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增单位补贴申报")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		SocialCorpDeclareForm  socialCorpDeclareForm=new SocialCorpDeclareForm();
		socialCorpDeclareForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/subsidy/socialCorpDeclareAdd.jsp");
		
		return modelAndView.addObject("socialCorpDeclareForm",socialCorpDeclareForm);					
	}
	/**
	 * 	编辑单位补贴申报
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑单位补贴申报")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);//申报ID
		SocialCorpDeclareForm  socialCorpDeclareForm=new SocialCorpDeclareForm();
		SocialBatch socialBatch=null;
		SocialCorpDeclare socialCorpDeclare=socialCorpDeclareService.getById(id);
		boolean isOverBatch=false;
		if(socialCorpDeclare!=null){	//按单位提交批次查询，选择了某个已提交的批次时		
			
			Corp corp=corpService.getById(socialCorpDeclare.getCorpid());
			BeanToBean.copyProperties(corp, socialCorpDeclareForm, false);
			socialCorpDeclareForm.putModel(socialCorpDeclare);
			Long batchId=RequestUtil.getLong(request,"batchId",0L);
			
			 socialBatch=socialBatchService.getById(socialCorpDeclare.getBatchId());
			//自动计算批次,针对切换批次的情况
			if(batchId!=0){
			 socialBatch=socialBatchService.getById(batchId);	
			}
			
			initBatch(socialCorpDeclareForm, socialBatch);
			Long totalTg = socialCorpDeclareForm.getTotalSubsidyNum()==null?0:socialCorpDeclareForm.getTotalSubsidyNum();	//通过人数
			Long tg = socialCorpDeclareForm.getPassed()==null?0:socialCorpDeclareForm.getPassed();	//未通过人数
			Long wtg = socialCorpDeclareForm.getNoPassed()==null?0:socialCorpDeclareForm.getNoPassed();	//未通过人数
			Long wsh = socialCorpDeclareForm.getNoReview() ==null ? 0:socialCorpDeclareForm.getNoReview();	//未审核的
			String approvalDesc="批次共有"+totalTg+"人次，其中已通过"+tg+"人次，未通过"+wtg+"人次。未审核"+wsh+"人次。";
			socialCorpDeclareForm.setApprovalDesc(approvalDesc);
			socialCorpDeclareForm.setMvcMethod("edit");
		}else{//按单位查询查询,初次打开页面时，	
			Long corpId=RequestUtil.getLong(request,"corpId",0L);
			Corp corp=null;
			if(corpId!=0){
				 corp=corpService.getById(corpId);
				BeanToBean.copyProperties(corp, socialCorpDeclareForm, false);
			}else{
				 corp=corpService.getById(10000001370000L);
				 if(corp!=null){
					 BeanToBean.copyProperties(corp, socialCorpDeclareForm, false);
				 }
				
			}
			Long batchId=RequestUtil.getLong(request,"batchId",0L);
			initCreater(socialCorpDeclareForm);
			//自动计算批次
			if(batchId!=0){
				 socialBatch=socialBatchService.getById(batchId);
			}else{
				// socialBatch=socialBatchService.getNewestSocialBatch();
			}
			initBatch(socialCorpDeclareForm, socialBatch);
			socialCorpDeclareForm.setMvcMethod("add");
			//初始化银行卡信息,取出最后一次单位申报所填的银行卡信息后自定填入到本次申报信息中
			if(corp!=null){
				SocialCorpDeclare oldsocialCorpDeclare=socialCorpDeclareService.getLastSocialCorpDeclare(corp.getAab001());
				if(oldsocialCorpDeclare!=null){
					socialCorpDeclareForm.setBankCardNo(oldsocialCorpDeclare.getBankCardNo());
					socialCorpDeclareForm.setBankName(oldsocialCorpDeclare.getBankName());
					socialCorpDeclareForm.setBankOwnerName(oldsocialCorpDeclare.getBankOwnerName());		
				
				}
			}
			
			socialCorpDeclareForm.setId(uniqueIdUtil.genId(SocialCorpDeclare.class.getName()));
		}
		
		if(socialBatch!=null){
			SocialCorpDeclare overSocialCorpDeclare =socialCorpDeclareService.getByBatchId(socialBatch.getId());
			if(overSocialCorpDeclare!=null){
				isOverBatch=true;
			}
		}
		
		ModelAndView modelAndView= new ModelAndView("/business/personagency/subsidy/socialCorpDeclareEdit.jsp");
		return modelAndView.addObject("socialCorpDeclareForm",socialCorpDeclareForm).addObject("socialBatch", socialBatch).addObject("isOverBatch", isOverBatch);					
	}
	/**
	 * 	新增单位补贴申报
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("batchUpdateIndex")
	@Action(description="新增单位补贴申报")
	public ModelAndView batchUpdateIndex(HttpServletRequest request) throws Exception
	{
		ModelAndView modelAndView= new ModelAndView("/business/personagency/subsidy/socialCorpDeclareAdd.jsp");
		
		return modelAndView.addObject("batchUpdate",true);					
	}
	/**
	 * 	编辑单位补贴申报
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("batchUpdateEdit")
	@Action(description="编辑单位补贴申报")
	public ModelAndView batchUpdateEdit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);//申报ID
		SocialCorpDeclareForm  socialCorpDeclareForm=new SocialCorpDeclareForm();
		if(id!=0){	//按单位提交批次查询		
			SocialCorpDeclare socialCorpDeclare=socialCorpDeclareService.getById(id);
			SocialBatch socialBatch=socialBatchService.getById(socialCorpDeclare.getBatchId());
			Corp corp=corpService.getById(socialCorpDeclare.getCorpid());
			BeanToBean.copyProperties(corp, socialCorpDeclareForm, false);
			
			socialCorpDeclareForm.putModel(socialCorpDeclare);
			initBatch(socialCorpDeclareForm, socialBatch);
			Long totalTg = socialCorpDeclareForm.getTotalSubsidyNum()==null?0:socialCorpDeclareForm.getTotalSubsidyNum();	//通过人数
			Long tg = socialCorpDeclareForm.getPassed()==null?0:socialCorpDeclareForm.getPassed();	//未通过人数
			Long wtg = socialCorpDeclareForm.getNoPassed()==null?0:socialCorpDeclareForm.getNoPassed();	//未通过人数
			Long wsh = socialCorpDeclareForm.getNoReview() ==null ? 0:socialCorpDeclareForm.getNoReview();	//未审核的
			String approvalDesc="批次共有"+totalTg+"人次，其中已通过"+tg+"人次，未通过"+wtg+"人次。未审核"+wsh+"人次。";
			socialCorpDeclareForm.setApprovalDesc(approvalDesc);
		}
		ModelAndView modelAndView= new ModelAndView("/business/personagency/subsidy/socialCorpDeclareBatchUpdate.jsp");
		return modelAndView.addObject("socialCorpDeclareForm",socialCorpDeclareForm);					
	} 
	
	private void initBatch(SocialCorpDeclareForm socialCorpDeclareForm,SocialBatch socialBatch){
    	 
    	 
    	 if(socialBatch!=null){
    		 
    		 SocialBatchSumDto socialBatchSumDto=socialBatchService.getSocialBatchSum(socialBatch.getId());
    		 if(socialBatchSumDto!=null){
    			 BeanToBean.copyProperties(socialBatchSumDto, socialCorpDeclareForm);
    		 }
    		
    		 
//    		 socialCorpDeclareForm.setBatchId(socialBatch.getId());
//    		 List<SocialSubsidy> socialSubsidyList=socialSubsidyService.getListByBatchId(socialBatch.getId());
//    	     Long pensionSubsidyNum=0L,medicalSubsidyNum=0L,totalSubsidyNum=0L;
//    	     Float medicalSubsidyAmount=0F,pensionSubsidyAmount=0F,totalSubsidyAmount=0F;
//    		 Integer passed =0,noPassed=0,noReview=0;
//    	     for(SocialSubsidy socialSubsidy: socialSubsidyList){
//    			
//    	    	 if(checkStateEnum.passed.getCode().equals(socialSubsidy.getCheckState())){
//    	    		 passed++; 
//    	    	 }else if(checkStateEnum.noPassed.getCode().equals(socialSubsidy.getCheckState())){
//    	    		 noPassed++; 
//    	    	 }else{
//    	    		 noReview++; 
//    	    	 }
//    			 String pensionAmount= socialSubsidy.getPensionAmount();
//    			 
//    			 String medicalAmount=socialSubsidy.getMedicalAmount();
//                 if(StringUtil.isNotEmpty(pensionAmount)){
//                	 pensionSubsidyNum++;
//                	 medicalSubsidyAmount=medicalSubsidyAmount+Float.valueOf(pensionAmount);
//                 }
//                 if(StringUtil.isNotEmpty(medicalAmount)){
//                	 medicalSubsidyNum++;
//                	 pensionSubsidyAmount=pensionSubsidyAmount+Float.valueOf(medicalAmount);
//                 }
//                 totalSubsidyNum++;
//    	     }
//    	     
//    		 totalSubsidyAmount=medicalSubsidyAmount+pensionSubsidyAmount;
//    		 socialCorpDeclareForm.setMedicalSubsidyAmount(medicalSubsidyAmount.toString());
//    		 socialCorpDeclareForm.setMedicalSubsidyNum(medicalSubsidyNum);
//    		 socialCorpDeclareForm.setPensionSubsidyAmount(pensionSubsidyAmount.toString());
//    		 socialCorpDeclareForm.setPensionSubsidyNum(pensionSubsidyNum);
//    		 socialCorpDeclareForm.setTotalSubsidyNum(totalSubsidyNum);
//    		 socialCorpDeclareForm.setTotalSubsidyAmount(totalSubsidyAmount.toString());
//    		 socialCorpDeclareForm.setApprovalDesc("批次共有"+socialSubsidyList.size()+"人次，其中已通过"+passed+"人次，未通过"+noPassed+"人次。");
    		 
    	 } 
     }
	
	
	/**
	 * 取得单位补贴申报明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看单位补贴申报明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		SocialCorpDeclare socialCorpDeclare = socialCorpDeclareService.getById(id);	
		return getAutoView().addObject("socialCorpDeclare", socialCorpDeclare);
	}
	
}
