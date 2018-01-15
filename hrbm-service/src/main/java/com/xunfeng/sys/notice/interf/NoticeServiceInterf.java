package com.xunfeng.sys.notice.interf;

import com.xunfeng.business.advert.model.AdCategory;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.notice.dao.NoticeDao;
import com.xunfeng.sys.notice.model.Notice;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 我的关注表 Service类
* @author:wanghan
* @createDate 2015-12-11 16:10:06 
* @version V1.0   
*/
@Service
public interface NoticeServiceInterf extends GenericServiceInterface<Notice,Long>
{
	
		public List<Notice> getAllNotice(QueryFilter queryFilter);
		public boolean isNotice(Long noticeUserId,Long beNoticeUserId);
}
