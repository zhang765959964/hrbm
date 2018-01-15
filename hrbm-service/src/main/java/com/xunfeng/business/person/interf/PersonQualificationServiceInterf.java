package com.xunfeng.business.person.interf;

import java.util.List;

import com.xunfeng.business.person.model.PersonQualification;
import com.xunfeng.core.service.GenericServiceInterface;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: hr工具箱模板表 接口类
 * @author:wanghan
 * @createDate 2016-03-25 16:00:45
 * @version V1.0
 */
public interface PersonQualificationServiceInterf extends GenericServiceInterface<PersonQualification, Long> {
	public List<PersonQualification> getPersonQualificationList(Long aac001);
}
