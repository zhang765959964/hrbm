package com.xunfeng.business.advert.interf;


import java.util.List;
import java.util.Map;

import com.xunfeng.business.advert.model.AdCompany;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.setMeal.exception.SetMealException;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告位放置表 接口类
* @author:wangyanyan
* @createDate 2016-03-25 11:33:37 
* @version V1.0   
*/
public interface AdCompanyServiceInterf extends GenericServiceInterface<AdCompany,Long>
{   
	/**
	 *根据标示取得做推广的公司 (不分页)
 	**/
	public List<Map<String,Object>> getadCompanyByIndent(String indent);
	
	/**
	 *根据标示取得做推广的公司 (分页)
	 *@param indent 分类标示
	**/
	public ResultData<Map> getadCompanyPageByIndent(QueryFilter queryFilter,String indent);
	
	/**
	 *取得未做推广的公司
 	**/
	public ResultData getNoAdCompanyByExcept(QueryFilter queryFilter,String aab004);
	
	/**
	 *为推广的公司或者职位排序
 	**/
	public void sortOrderNum(Long id,Long orderNum);
	 /**
     * 批量保存栏目中列表的排序
     */
    public void sortOrderNumBatch(Long[] lAryId);
	/**
	 * 通过企业id和分类标识获得所有数据
	 */
	public List<Map<String,Object>> getAdByCorpidAndIndent(Long aab001,String indent);
	/**
	 * 通过记录id修改图片路径
	 * @param id
	 * @param imgPath
	 */
	public void updateImgPathById(Long id,String imgPath);
	
	/***********************************job**************************************/
	
	/**
	 *根据标示取得未做推广的职位(分页)
 	**/
    public ResultData<Map> getJobByExcept(QueryFilter queryFilter);
    
	/**
	 * 根据标示取得做推广的职位
 	**/
	public List<Map<String,Object>> getadJobByExcept(QueryFilter queryFilter);
	
   /**
	 * 做广告的职位列表 (分页)
	 * 包括有工资 学历 经验 公司详情 
	 * 2016-04-13
	 */
	public ResultData<Map> getadJobPageByIndent(QueryFilter queryFilter,String indent);
	
   /**
	 * 做广告的职位列表 (分页)
	 * 包括有工资 学历 经验 公司详情 
	 * 2016-04-13
	 */
    public ResultData<Map> getadJobList(QueryFilter queryFilter);
    
    /**
     * 把职位设为广告
     * @param jobid 职位id
     * @param indent 分类标示
     */
    public void addJobAdvert(Long jobid,String indent);
    /**
     * 把职位设为广告批量  jobIdStr 以逗号分开的字符 但是要保证 分开后的数据必须可以转化成Long类型
     * @param jobIdStr 职位id
     * @param indent 分类标示
     */
    public void addJobAdvertBatch(Long[] corpPositionIds,String indent);
    /**
     * 增加广告点击次数
     * @param caae01 广告主键
     */
    public void updateHitNum(Long caae01);
    /**
     * 删除广告增加删除广告记录表
     * @param lAryId 广告id
     * @param currentUserName  操作人
     * 2016-08-03
     */
    
    public void delBathAdByIds(Long[] lAryId,String currentUserName);
    /**
     * 删除广告增加删除广告记录表
     * @param id 广告id
     * @param currentUserName  操作人
     * 2016-08-03
     */
    public void delAdById(Long id,String currentUserName);
    
    /*************************************会员收费项目************************************/
    /**
     * 把职位设为广告
	 * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
	 * @param aab001 企业编号
	 * @param aab004 企业名称
	 * 
	 * @param jobid 职位id
	 * @param indent 设置的标示
	 * @return String
	 */
    public String addJobPayOper(Map<String,Object> map);
    /**
     * 把职位设为广告批量 
     * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
     * @param aab001 企业编号
	 * @param aab004 企业名称
	 * @param indent 设置的标示
     *   corpPositionIds 以逗号分开的字符 但是要保证 分开后的数据必须可以转化成Long类型
     * @param jobIdStr 职位id
     * @throws SetMealException 套餐不足整个事物回滚 
     */
    public void addJobAdvertBatchPayOper(Map<String,Object> map) throws SetMealException;
    /**
     * 增加广告
     * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
     * @param aab001 企业编号
	 * @param aab004 企业名称
     * @param adCompany 要保存的实体类 一般在map中的key为实体类的名称第一个字母小写
     */
    public String addPayOper(Map<String,Object> map);
    
    
}
