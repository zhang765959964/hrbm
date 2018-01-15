package com.xunfeng.business.corp.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.dao.DownloadResumeDao;
import com.xunfeng.business.corp.dto.CorpResumeDownDto;
import com.xunfeng.business.corp.interf.DownloadResumeServiceInterf;
import com.xunfeng.business.corp.model.DownloadResume;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.config.model.BaseConfig;
import com.xunfeng.sys.config.service.BaseConfigService;
import com.xunfeng.sys.setMeal.service.FeeOrderDetailService;
import com.xunfeng.sys.setMeal.util.MealResultConst;
import com.xunfeng.sys.setMeal.util.MealTypeEmun;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 企业下载简历日志表 Service类
* @author:wangyanyan
* @createDate 2016-04-07 10:59:12 
* @version V1.0   
*/
@Service
public class DownloadResumeService extends BaseService<DownloadResume> implements DownloadResumeServiceInterf
{
	@Resource
	private DownloadResumeDao dao;
	@Resource
	private FeeOrderDetailService feeOrderDetailService;
	@Resource
	private BaseConfigService baseConfigService;
	
	public DownloadResumeService()
	{
	}
	
	@Override
	protected IEntityDao<DownloadResume, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<Map> getAllComDownloadResume(QueryFilter filter){
		return dao.getAllComDownloadResume(filter);
	}
	
	/**
	 * 通过账户id获得简历下载次数
	 * @param ccmu01 账户id
	 * @return
	 */
	public Long getTotalInvit(Long aac001){
		return dao.getTotalInvit(aac001);
	}
	
	/**
	 * 获得企业查看简历的简历数量
	 * @return
	 */
	public Long getCorpReadResume(Long aab001){
		return dao.getCorpReadResume(aab001);
	}
	/**
	 * 根据企业id和个人id查询出下载简历
	 * @return
	 */
	public DownloadResume getReadResume(Long aab001,Long aac001){
		return dao.getReadResume(aab001, aac001);
	}
	// 企业中心 简历列表   获取企业下载简历列表
	public ResultData<CorpResumeDownDto> getCorpResumeDownDto(QueryFilter filter){
		return dao.getCorpResumeDownDto(filter);
	}
	/**
     * 增加下载简历
     * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
     * @param aab001 企业编号
	 * @param aab004 企业名称
	 * 
     * @param downloadResume 要保存的实体类 一般在map中的key为实体类的名称第一个字母小写
     */
    public String addPayOper(Map<String,Object> map){
		DownloadResume downloadResume = (DownloadResume)map.get("downloadResume");
		String flag = MealResultConst.SUC;
		if(isNeedFee()){
			Long aab001 = Long.valueOf(map.get("aab001").toString());
			String aab004 = String.valueOf(map.get("aab004"));
			flag =  feeOrderDetailService.updateFeeOrderCount(aab001,aab004,MealTypeEmun.RESUME.getCode(),1);
			if(MealResultConst.SUC.equals(flag)){//成功
				dao.add(downloadResume);
			}
		}else{
			dao.add(downloadResume);
		}
		return flag;
    }
    /**
     * 节点是否收费
     * @param categoryIndent 广告的分类Id
     * @return boolean true :扣费 false:免费
     */
    private boolean isNeedFee(){
    	BaseConfig baseConfig = baseConfigService.getConfigByName("member_IsPay");
    	String caos04 = baseConfig.getCaos04();
    	if(caos04.equals("1")){//收费
    		baseConfig = baseConfigService.getConfigByName("member_IsPay_resume");
    		caos04 = baseConfig.getCaos04();
    	}
    	return caos04.equals("1")?true:false;
    }
}
