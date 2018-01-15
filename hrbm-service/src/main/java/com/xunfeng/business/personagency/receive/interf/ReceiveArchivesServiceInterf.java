package com.xunfeng.business.personagency.receive.interf;

import com.xunfeng.business.personagency.receive.dto.ReceiveArchivesPersonDto;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;



/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 接口类
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
public interface ReceiveArchivesServiceInterf 
{
	//正常档案接收保存方法
	public void saveReceiveArchives(ReceiveArchivesPersonDto receiveArchivesPersonDto);
	//档案调出后二次接收档案保存方法
	public void saveLendBackArchives(ReceiveArchivesPersonDto receiveArchivesPersonDto);
}
