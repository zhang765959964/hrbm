package com.xunfeng.sys.file.dao;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.file.model.FileManageLog;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 文件管理日志Dao
* @author wanghan 
* @createDate 2015年4月23日-上午10:10:13 
* @version V1.0   
*/
@Repository
public class FileManageLogDao extends BaseDao<FileManageLog> {

	@Override
	public Class getEntityClass() {
		return FileManageLog.class;
	}

}
