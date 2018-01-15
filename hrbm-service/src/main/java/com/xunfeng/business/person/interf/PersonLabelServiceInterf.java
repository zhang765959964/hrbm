package com.xunfeng.business.person.interf;

import java.util.List;

import com.xunfeng.business.person.model.PersonLabel;
import com.xunfeng.core.service.GenericServiceInterface;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 标签明细表 接口类
 * @author:wanghan
 * @createDate 2016-03-31 14:57:08
 * @version V1.0
 */
public interface PersonLabelServiceInterf extends GenericServiceInterface<PersonLabel, Long> {
	
	public List<PersonLabel> getPersonLabelList(Long userId,String labelType);

	public void savePersonLabelList(Long userId,List<PersonLabel> personLabelList);
	
	public void delPersonLabelList(Long userId) ;
}
