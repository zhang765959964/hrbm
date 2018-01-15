package com.xunfeng.sys.notice.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.notice.dao.NoticeDao;
import com.xunfeng.sys.notice.interf.NoticeServiceInterf;
import com.xunfeng.sys.notice.model.Notice;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 我的关注表 Service类
* @author:wanghan
* @createDate 2015-12-11 16:10:06 
* @version V1.0   
*/
@Service
public class NoticeService  extends BaseService<Notice> implements NoticeServiceInterf
{
	@Resource
	private NoticeDao dao;
	
	
	
	public NoticeService()
	{
	}
	
	@Override
	protected IEntityDao<Notice, Long> getEntityDao() 
	{
		return dao;
	}

//	public List<Map<String,Object>>  getMyNoticeList(Long ccmu01,PageBean pageBean){
//
//		Map param=new HashMap();//
//		param.put("noticeUserId",ccmu01);
//
//		return dao.getObjectList("getMyNoticeList", param, pageBean);
//	}
//
//	public List<Map<String,Object>>  getMyFansList(Long ccmu01,PageBean pageBean){
//
//		Map param=new HashMap();//
//		param.put("beNoticeUserId",ccmu01);
//
//		return dao.getObjectList("getMyFansList", param, pageBean);
//	}
//
//	public Long  getMyNoticeCount(Long ccmu01){
//
//		Map param=new HashMap();//
//		param.put("noticeUserId",ccmu01);
//
//		return (Long)dao.getOne("getMyNoticeCount", param);
//	}
//	public Long  getMyFansCount(Long ccmu01){
//
//		Map param=new HashMap();//
//		param.put("beNoticeUserId",ccmu01);
//
//		return (Long)dao.getOne("getMyFansCount", param);
//	}
//
//	public Notice getNoticeByBeNoticeId(Long beNoticeUserId,Long noticeUserId){
//		Map param=new HashMap();//
//		param.put("beNoticeUserId",beNoticeUserId);
//		param.put("noticeUserId",noticeUserId);
//		List<Notice> noticeList= dao.getBySqlKey("getAll",param);
//		if(noticeList!=null&&noticeList.size()>0){
//			return noticeList.get(0);
//		}else {
//			return null;
//		}
//
//	}
	//<!--  -->
	/**
	 * 获得关注列表
	 * 2016-04-13
	 */
	public List<Notice> getAllNotice(QueryFilter queryFilter){
		return dao.getAllNotice(queryFilter);
	}
	/**
	 * 个人是否关注公司
	 * 2016-04-13
	 */
	public boolean isNotice(Long noticeUserId,Long beNoticeUserId){
		if (dao.getTotalNoticeCount(noticeUserId,beNoticeUserId)>0l){
			return true;
		}else{
			return false;
		}
	}
	
	
}
