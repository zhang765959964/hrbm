package com.xunfeng.business.jobfair.interf;


import java.util.List;
import java.util.Map;

import com.xunfeng.business.jobfair.dto.BookCorp;
import com.xunfeng.business.jobfair.dto.JobFairBoothBookDto;
import com.xunfeng.business.jobfair.exception.BoothOccupiedException;
import com.xunfeng.business.jobfair.model.BoothBook;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 摊位初始化表 接口类
* @author:wanghan
* @createDate 2016-04-07 09:55:00 
* @version V1.0   
*/
public interface BoothBookServiceInterf extends GenericServiceInterface<BoothBook,Long>
{
	public ResultData<BookCorp> getBookCorpList(QueryFilter queryFilter);
	
	/**摊位预定接口
	 * @param jobFairBoothBookDto
	 * @return
	 */
	public Long  addBoothBook(JobFairBoothBookDto jobFairBoothBookDto)throws BoothOccupiedException;
	/**修改预定摊位信息
	 * @param jobFairBoothBookDto
	 * @return
	 */
	public void  editBoothBook(JobFairBoothBookDto jobFairBoothBookDto);		
	/**获取我的摊位登记信息列表
	 * @param aab001，单位Id
	 * @return
	 */
	public ResultData<Map> getMyBoothBookList(QueryFilter filter);
	/**获取我预定的招聘会列表
	 * @param aab001，单位Id
	 * @return
	 */
	public List<Map> getMyJobFairBookList(Long aab001);
	
	/**根据场地编号和举行日期获取预定摊位信息列表
	 * @param holdDate
	 * @param siteId
	 * @return
	 */
	public List<BoothBook>  getJobFairBoothList(String holdDate,Long siteId);
	
	/**摊位退订功能
	 * @param cczy01
	 */
	public void boothUnsubscribe(Long cczy01);
}
