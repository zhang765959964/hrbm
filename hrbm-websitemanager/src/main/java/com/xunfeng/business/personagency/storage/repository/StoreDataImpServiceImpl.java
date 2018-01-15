/**   
*  
*/


package com.xunfeng.business.personagency.storage.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.storage.interf.SpecialArchivesServiceInterf;
import com.xunfeng.business.personagency.storage.model.SpecialArchives;
import com.xunfeng.business.personagency.subsidy.interf.SocialSubsidyServiceInterf;
import com.xunfeng.business.personagency.subsidy.model.SocialSubsidy;
import com.xunfeng.core.excel.reader.DataEntity;
import com.xunfeng.core.excel.reader.FieldEntity;
import com.xunfeng.core.excel.reader.TableEntity;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.MapBeanCopyUtil;
import com.xunfeng.sys.component.service.DataImpService;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;

/**  
 * @company: 河南讯丰信息技术有限公司 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wanghan 
 * @createDate 2015年6月2日-上午8:46:14 
 * @version V1.0   
 */
@Service
public class StoreDataImpServiceImpl extends DataImpService {

	@Resource
	@Qualifier("specialArchives")
	private SpecialArchivesServiceInterf specialArchivesService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;
	

	@Override
	protected void impData(TableEntity tableEntity,Map dataCol) {
		List<DataEntity> rowEntityList= tableEntity.getDataEntityList();
		if(rowEntityList.size()>1){
			List list = new ArrayList();
			for (int i = 1; i < rowEntityList.size(); i++) {
				SpecialArchives specialArchives = new SpecialArchives();
				specialArchives.setId(uniqueIdUtil.genId(SpecialArchives.class.getName()));
				specialArchives.setCczy06("0");
				specialArchives.setCcpr08("0");
				specialArchives.setPrintNumber(0L);
				SysUser sysUser=ContextUtil.getCurrentUser();
				SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
				specialArchives.setLrCreaterId(sysUser.getAcd230());
				specialArchives.setLrCreaterName(sysUser.getAac003());
				specialArchives.setLrCreaterDate(new Date());
				specialArchives.setLrCreaterOrgId(sysOrg.getAcd200());
				specialArchives.setLrCreaterOrgName(sysOrg.getAcd202());
				specialArchives.setSpecialStatus("0");//0.入档  1.已转出
				DataEntity dataEntity = rowEntityList.get(i);
				List<FieldEntity> fieldEntityList=dataEntity.getFieldEntityList();
				for(FieldEntity  fieldEntity:fieldEntityList){
					String name=fieldEntity.getName();
					String value=fieldEntity.getValue();
					String propertyName=(String)dataCol.get(name);
					if("genderName".equalsIgnoreCase(propertyName)){
						MapBeanCopyUtil.copyProperty(specialArchives, "aac004", value);
					}else if("specialTypeName".equalsIgnoreCase(propertyName)){
						MapBeanCopyUtil.copyProperty(specialArchives, "specialType",value);
					}else{
						MapBeanCopyUtil.copyProperty(specialArchives, propertyName, value);
					}
				}
				list.add(specialArchives);
			}
			specialArchivesService.addBatchSpecialArchives(list);
		}
		
	}
}
