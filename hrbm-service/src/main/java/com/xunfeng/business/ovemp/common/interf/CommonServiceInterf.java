package com.xunfeng.business.ovemp.common.interf;

import java.util.Map;

import com.xunfeng.business.ovemp.common.model.CommonModel;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.CommonQueryEnum;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;

public interface CommonServiceInterf extends GenericServiceInterface<CommonModel,Long>{
	/**
	 * 分页共同检索列表获取
	 * @param commonQueryEnum 获取类型
	 * @param queryFilter 检索条件
	 * @return 返回结果
	 */
	public ResultData<Map<String, Object>> getCommonViewList(CommonQueryEnum commonQueryEnum,QueryFilter queryFilter);
}
