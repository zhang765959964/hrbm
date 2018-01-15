package com.xunfeng.core.web.query.scan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 实体表类的扫描.
* @author wanghan 
* @createDate 2015年4月23日-上午10:47:58 
* @version V1.0   
*/
public class TableScaner {
	/**
	 * 查找Table的实体类
	 */
	public static List<Class<?>> findTableScan(Resource[] basePackage)
			throws IOException, ClassNotFoundException {
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(
				resourcePatternResolver);
		List<Class<?>> candidates = new ArrayList<Class<?>>();
		if (basePackage == null)
			return candidates;
		for (Resource resource : basePackage) {
			if (!resource.isReadable())
				continue;
			MetadataReader metadataReader = metadataReaderFactory
					.getMetadataReader(resource);
			if (isCandidate(metadataReader))
				candidates.add(Class.forName(metadataReader.getClassMetadata()
						.getClassName()));
		}
		return candidates;
	}

	/**
	 * 是否为需要的实体表类型。
	 * 
	 * @param metadataReader
	 * @return
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean isCandidate(MetadataReader metadataReader)
			throws ClassNotFoundException {
		try {
			Class c = Class.forName(metadataReader.getClassMetadata()
					.getClassName());
			if (c.getAnnotation(com.xunfeng.core.annotion.query.Table.class) != null)
				return true;
		} catch (Throwable e) {
		}
		return false;
	}
}
