package com.xunfeng.sys.notice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.notice.model.Notice;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 我的关注表 Dao类
* @author:wanghan
* @createDate 2015-12-11 16:10:06 
* @version V1.0   
*/
@Repository
public class NoticeDao extends BaseDao<Notice>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Notice.class;
	}
	
	public List<Notice> getAllNotice(QueryFilter queryFilter){
        return  this.getAll(queryFilter);
	}
	public Long getTotalNoticeCount(Long noticeUserid,Long beNoticeUserid){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("noticeUserId", noticeUserid);
		map.put("beNoticeUserId", beNoticeUserid);
		return  (Long) this.getOne("getMyNoticeCorpCount", map);
	}
    
}