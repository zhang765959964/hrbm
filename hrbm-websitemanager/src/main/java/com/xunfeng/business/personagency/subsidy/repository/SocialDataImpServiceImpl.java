/**   
*  
*/


package com.xunfeng.business.personagency.subsidy.repository;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.subsidy.interf.SocialSubsidyServiceInterf;
import com.xunfeng.business.personagency.subsidy.model.SocialSubsidy;
import com.xunfeng.core.excel.reader.DataEntity;
import com.xunfeng.core.excel.reader.FieldEntity;
import com.xunfeng.core.excel.reader.TableEntity;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.MapBeanCopyUtil;
import com.xunfeng.sys.component.service.DataImpService;
import com.xunfeng.sys.uums.model.SysUser;

/**  
 * @company: 河南讯丰信息技术有限公司 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wanghan 
 * @createDate 2015年6月2日-上午8:46:14 
 * @version V1.0   
 */
@Service
public class SocialDataImpServiceImpl extends DataImpService {

	@Resource
	@Qualifier("socialSubsidy")
	private SocialSubsidyServiceInterf socialSubsidyService;

	

	@Override
	protected void impData(TableEntity tableEntity,Map dataCol) {
		List<DataEntity> rowEntityList= tableEntity.getDataEntityList();
		for(DataEntity dataEntity:  rowEntityList){
			SocialSubsidy SocialSubsidy=socialSubsidyService.getByArchiveCode(dataEntity.getPkVal());
			List<FieldEntity> fieldEntityList=dataEntity.getFieldEntityList();
			  
			for(FieldEntity  fieldEntity:fieldEntityList){
				String name=fieldEntity.getName();
				String value=fieldEntity.getValue();
				String propertyName=(String)dataCol.get(name);
				if("bankCardNo".equalsIgnoreCase(propertyName)||"bankName".equalsIgnoreCase(propertyName)){
					MapBeanCopyUtil.copyProperty(SocialSubsidy, propertyName, value);
				}		
			}
			socialSubsidyService.update(SocialSubsidy);
		}
	}
}
