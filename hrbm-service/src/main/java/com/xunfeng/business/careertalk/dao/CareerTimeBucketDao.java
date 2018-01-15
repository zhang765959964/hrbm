package com.xunfeng.business.careertalk.dao;

import com.xunfeng.business.careertalk.model.CareerTimeBucket;
import com.xunfeng.core.db.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 宣讲会教师时间段划分表 Dao类
 * @author:zhouhang
 * @createDate 2015-09-21 09:49:15
 * @version V1.0
 */
@Repository
public class CareerTimeBucketDao extends BaseDao<CareerTimeBucket> {
	@Override
	public Class<?> getEntityClass() {
		return CareerTimeBucket.class;
	}

	public void addList(List<CareerTimeBucket> ctblist) {
		String statement = getIbatisMapperNamespace()+".addList";
		for (int i = 0,len=ctblist.size(); i < len; i++) {
			getSqlSessionTemplate().insert(statement, ctblist.get(i));
		}
	}

	public void delByCrId(Long crId) {
		String statement = getIbatisMapperNamespace()+".delByCrId";
		getSqlSessionTemplate().insert(statement,crId);
	}
}