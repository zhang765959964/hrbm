package com.xunfeng.business.personagency.erecord.interf;

import java.util.List;

import com.xunfeng.business.personagency.erecord.model.EArchives;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 社保补贴参数 接口类
 * @author:wanghan
 * @createDate 2016-08-06 10:00:38
 * @version V1.0
 */
public interface EArchivesServiceInterf extends GenericServiceInterface<EArchives, Long> {
	public List<EArchives> getEArchivesList(Long personId, Long catalogId, Long imgStatus);

	public void useEArch(Long[] lAryId);

	public void sortEArchives(Long targetId, Long sourceId, Long personId);

	public Long getNextNum(Long personId);

	public ResultData<EArchives> getAllByFilter(QueryFilter fiter);
}
