package com.xunfeng.business.corp.interf;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.dto.CorpPositionDto;
import com.xunfeng.business.corp.dto.CorpSavePositionDto;
import com.xunfeng.business.corp.model.CorpPosition;
import com.xunfeng.business.corp.model.CorpPositionPublish;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.setMeal.exception.SetMealException;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 招聘空位信息表 Service类
* @author:wxl
* @createDate 2015-07-24 11:31:13 
* @version V1.0   
*/
@Service
public interface CorpPositionServiceInter extends GenericServiceInterface<CorpPosition,Long>
{
	
	/**
	 * 暂停职位（就是冻结职位）
	 * 	冻结标记 String acb208   (1为冻结 ) 冻结人员 String  acb20d freezeName
	 	冻结日期 Date  acb20e   冻结原因 String  acb20l  (对应tab_UFREASONS 中的code) 202 单位主动
	 */
	public void freezeCorpPosition(Long[] corpPositionIds,Accounts accounts);
	/**
	 * 暂停职位(冻结职位)
	 * 冻结标记 String acb208   (1为冻结 ) 冻结人员 String  acb20d freezeName  冻结日期 Date  acb20e   
	 * 冻结原因 String  acb20l  (对应tab_UFREASONS 中的code) 
	 * @param corpPositionIds 职位ID
	 * @param accounts 登录人员信息
	 */
	public void freezeCorpPositionCode(Long[] corpPositionIds,String userName,String code);
	/**
	 * 删除职位   ccpr08   是否删除状态（0-否1-是） 最后修改人、最后修改时间、修改来源
	 * @param corpPositionIds
	 */
	public void deleteCorpPosition(Long[] corpPositionIds,Accounts loginUser);
	/**
	 * 刷新职位
	 * @param corpPositionIds
	 * @param accounts
	 */
	public void refreshCorpPosition(Long[] corpPositionIds);
	
	/**
	 * 解冻职位
	 */
	public void unfreezeCorpPosition(Long[] corpPositionIds);

	/**
	 * 查询发布的职位，查询根据冻结标识进行筛选
	 * ccb208: 0发布中 1 暂停中 -1 已过期
	 */
	public ResultData<CorpPositionDto> getAllCorpPosition(QueryFilter filter);
	
	public ResultData<CorpPositionDto> getAllCorpPositionFaBu(Long aab001,PageBean pageBean);
	//根据职位acb210 和aab001 
	public ResultData<CorpPositionDto> getAllCorpPositionFaBuByCorpIdAndPositionId(Long aab001,Long acb210,PageBean pageBean);
	
	//职位管理 新增职位  （委托）验证是不是已经发布了职位
	public Long checkPosition(Long aab001,String cca113);
	//职位管理 修改职位（委托）验证是不是已经发布了职位
	public Long checkMofifyPosition(Long aab001,Long acb210,String cca113);
	//企业预订招聘会下  修改职位（现场）验证是不是已经发布了职位
	public Long checkXCMofifyPosition(Long acb200,Long acb210,String cca113);
	//职位管理下保存职位
	public Long savePositionAndPublish( CorpSavePositionDto cspd,boolean flag) throws SetMealException;
	//职位管理下修改职位信息
	public void updatePositionAndPublish( CorpPosition corpPosition,CorpPositionPublish  corpPositionPublish,boolean flag);
	
	//企业获取最新职位信息
	public List<CorpPositionDto> getAllNewCorpPosition(QueryFilter filter);
	/**
	 * 查询发布的职位，查询根据冻结标识进行筛选
	 * ccb208: 0发布中 1 暂停中 -1 已过期
	 */
	public CorpPositionDto getAllCorpPositionDtoById(Long acb210);
	
	//学生应聘记录查看职位详情
	public CorpPositionDto getStudentCorpPositionDto(Long acb210);
	
	/**
	 * 查询发布的职位，查询根据公司id和ccb208
	 * ccb208: 0发布中 1 暂停中 -1 已过期
	 */
	public Long getGuoCorpPositionDtoCount(Long aab001,String ccb208);
	//根据公司id查询总数
	public Long getTotalCount(Long aab001);

	/**新增一条职位信息
	 * @param corpPosition，职位信息对象
	 */
	public void savePosition( CorpPosition corpPosition);
	
	//修改现成职位信息
	public void updateWHPosition(CorpPosition corpPosition);
	
	//企业预订招聘会以后验证是不是已经发布了职位
	public Long getBoothBookPositionCount(Long acb200,String cca113);
//	/**
//	 * 发布职位调用存储过程 cb21_insert_bs
//	 */
//	public void postPosition(final CorpPositionForm corpPositionForm){
//		Long result = (Long) jdbcTemplate.execute(
//				new CallableStatementCreator() {
//					public CallableStatement createCallableStatement(Connection con) throws SQLException {
//						String storedProc = "{call pkg_dw_init.cb21_insert_bs(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 调用的sql
//						CallableStatement cs = con.prepareCall(storedProc);
//						cs.setLong(1, corpPositionForm.getAab001());// 设置输入参数的值
//						cs.setString(2,corpPositionForm.getBab004());
//						cs.setString(3,corpPositionForm.getAae004());
//						cs.setString(4,corpPositionForm.getAae139());
//						cs.setString(5,corpPositionForm.getAae005());
//						cs.setString(6,corpPositionForm.getAab040());
//						cs.setString(7,corpPositionForm.getAcb205());
//						cs.setString(8,corpPositionForm.getBca111());
//						cs.setString(9,corpPositionForm.getCca113());
//						cs.setInt(10,corpPositionForm.getAcb21r());
//						//String sds=TimeUtil.getDateTimeString(corpPositionForm.getAae031());
//						cs.setString(11, TimeUtil.getDateTimeString(corpPositionForm.getAae031()));
//						cs.setString(12, corpPositionForm.getAac011());
//						cs.setString(13, corpPositionForm.getAcc034());
//						cs.setString(14, corpPositionForm.getAad004());
//						cs.setString(15, corpPositionForm.getAcc217());
//						cs.setString(16, corpPositionForm.getAcc20t());
//						cs.setString(17, corpPositionForm.getAcc214());
//						cs.setString(18, "410100");
//						cs.setString(19, corpPositionForm.getAcb21i());
//						cs.setString(20, corpPositionForm.getAcb228());
//						cs.setString(21, corpPositionForm.getCca114());
//						cs.setString(22, corpPositionForm.getAcb20q());
//						cs.setString(23, corpPositionForm.getAae013());
//						cs.registerOutParameter(24, OracleTypes.NUMBER);//注册输出参数的类型
//						return cs;
//					}
//				}, new CallableStatementCallback() {
//					public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
//						try {
//							cs.execute();
//						}catch (Exception e){
//							logger.error(ExceptionUtil.getExceptionMessage(e));
//						}
//						Long sdsds=cs.getLong(24);
//						return sdsds;// 获取输出参数的值
//					}
//				});
//	}


	//根据公司ID获取公司发布的职位
	public List<CorpPositionDto> getCorpPositionByCorpId(Long aab001);
	//根据公司ID获取公司发布的有效委托职位（）
	public List<CorpPositionDto> getEffectivePositionByCorpId(Long aab001);
	//根据公司ID获取公司发布的职位总数
	public Long getCorpPositionCount(Long aab001);
	
	public List<Map> getBookPosition(QueryFilter queryFilter);
	public ResultData<Map> getCorpBookPositionList(QueryFilter filter);
	/**
	 * 获得公司预定摊位下发布的职位
	 * @param aab001
	 * @param cczy01 摊位id
	 * @return
	 */
	public List<Map> getBoothSiteCorpBookPositionList(Long aab001,Long cczy01);
	public List<Map> getPositionList(QueryFilter queryFilter);

	public ResultData<Map> getPositionResultDataList(PageBean pageBean,Map param);
	/**
    * 通过企业id获得在招职位并获得职位下的工作福利
    * @param ccmu01 
    * @param acc001 
    * @param isFairJob 0:网上招聘 1:招聘会职位 
    * 2016-04-15
    */
	public ResultData getCurrentJob(QueryFilter queryFilter,Long ccmu01,Long acc001,String isFariJob);
	
	/**
	 * 获得职位详情
	 */
	public Map<String,Object> getJobDetail(Long acb210);
	/**
	 * 获得职位下的工作福利
	 * @return
	 */
	public List<Map<String,Object>> getWelfareByCode(String acc214);
	
	
	/**根据职位Id获取职位详情并封装为Map格式返回
	 * @param acb210
	 * @return
	 */
	public Map getPositionMap(Long acb210) ;
	//获取发送信息cb20职位信息
	public Map<String,Object> getCorpBase(Long acb210);
	//提取公司历史职位信息
	public ResultData<Map> getExtractHistoryPosition(QueryFilter queryFilter);
 
	/**
	 * 判断该招聘岗位是否已经发布过
	 * @param acb200 招聘编号
	 * @param acb210 招聘岗位编号
	 * @param acb201 招聘企业编号
	 * @param code 工种编号
	 * @return 总数返回
	 */
	public int getPostionCount(Long acb200,Long acb210,Long aab001,String code);
	/**
	 * 视图查询岗位统计列表
	 * @param queryFilter 检索条件
	 * @return 返回数据
	 */
	public ResultData<Map<String,Object>> getCorpPositionViewList(QueryFilter queryFilter);
	
	/**
	 * 招聘职位检索视图(招聘信息自动匹配单位检索使用)
	 * @param queryFilter 检索条件
	 * @return 返回数据
	 */
	public ResultData<Map<String,Object>> getCorpPositionComponentViewList(QueryFilter queryFilter);
	
	/**
	 * 刷新职位
	 * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
	 * @param aab001 企业编号
	 * @param aab004 企业名称
	 * 
	 *@param  Long[] corpResumeIds,
	 *@return MealResultConst
	 */
	public void refreshCorpPositionPayOper(Map<String,Object> map) throws SetMealException;
}
