package com.xunfeng.core.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: XML与POJO相互转换 
* @author wanghan 
* @createDate 2015年4月23日-上午11:20:32 
* @version V1.0   
*/
public class XmlBeanUtil {
	/**
	 * XML转换为POJO类型
	 * @param xml
	 * @param clsToUnbound
	 * @return
	 * @throws JAXBException
	 */
	@SuppressWarnings("rawtypes")
	public static Object unmarshall(String xml, Class clsToUnbound) throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(clsToUnbound);
		return unmarshall(jc,xml);
	}
	/**
	 * POJO类型转换为XML
	 * @param serObj
	 * @param clsToBound
	 * @return
	 * @throws JAXBException
	 */
	@SuppressWarnings("rawtypes")
	public static String marshall(Object serObj,Class clsToBound) throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(clsToBound);
		return marshall(jc,serObj);
	}
	
	/**
	 * InputStream转换为POJO类型
	 * @param xml
	 * @param clsToUnbound
	 * @return
	 * @throws JAXBException
	 */
	public static Object unmarshall(InputStream is, Class<?> clsToUnbound) throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(clsToUnbound);
		return unmarshall(jc,is);
	}
	
	/**
	 * InputStream转换为POJO类型
	 * @param jc
	 * @param xml
	 * @return
	 * @throws JAXBException
	 */
	private static Object unmarshall(JAXBContext jc, InputStream is)
			throws JAXBException {
		Unmarshaller u = jc.createUnmarshaller();
		return (Object) u.unmarshal(is);
	}
	
	/**
	 * XML转换为POJO类型
	 * @param jc
	 * @param xml
	 * @return
	 * @throws JAXBException
	 */
	private static Object unmarshall(JAXBContext jc, String xml)
			throws JAXBException {
		Unmarshaller u = jc.createUnmarshaller();
		return (Object) u.unmarshal(new StringReader(xml));
	}
	/**
	 * POJO类型转换为XML
	 * @param jc
	 * @param serObj
	 * @return
	 * @throws JAXBException
	 * @throws PropertyException
	 */
	private static String marshall(JAXBContext jc, Object serObj)
			throws JAXBException, PropertyException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_ENCODING, System.getProperty("file.encoding"));
		m.marshal(serObj, out);
		return out.toString();
	}
}
