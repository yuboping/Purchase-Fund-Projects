package com.qiandai.util.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * <p>
 * Title:ParseXml2Object
 * </p>
 * <p>
 * Description:将xml格式数据转换成Map对象
 * </p>
 * 
 * @author haitao5623@163.com
 * @date 2016�?3�?7日下�?3:21:50
 */
public class ParseXml2Object {

	private Document doc = null;

	/**
	 * <p>
	 * Description:得到Document对象
	 * </p>
	 * 
	 * @author wanghaitao@new4g.cn
	 * @date 2016�?3�?7日下�?3:26:59
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public Document createDocument(String xmlStr) throws DocumentException {
		doc = DocumentHelper.parseText(xmlStr);
		return doc;
	}

	/**
	 * 
	 * <p>
	 * Description:解析xml数据 ,Document非全�?变量 ,将xml�?有数据保存到Map
	 * </p>
	 * 
	 * @date 2016�?3�?7日下�?3:34:10
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public Map<String, Object> getMsgDataToDoc(String xmlStr) throws DocumentException {
		Map<String, Object> result = new HashMap<String, Object>();
		Document doc = DocumentHelper.parseText(xmlStr);
		// 获得根节�?
		Element root = doc.getRootElement();
		List<?> elements = root.elements();

		if (0 < elements.size()) {
			result.put(root.getName(), getData(root));
		} else {
			result.put(root.getName(), root.getTextTrim());
		}

		return result;
	}

	/**
	 * 
	 * <p>
	 * Description:解析xml数据 ,Document全局变量 ,将xml�?有数据保存到Map
	 * </p>
	 * 
	 * @author haitao5623@163.com
	 * @date 2016�?3�?7日下�?3:38:03
	 * @param xmlStr
	 * @return
	 */
	public Map<String, Object> getMsgData(String xmlStr) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 获得根节�?
		Element root = doc.getRootElement();
		List<?> elements = root.elements();

		if (0 < elements.size()) {
			result.put(root.getName(), getData(root));
		} else {
			result.put(root.getName(), root.getTextTrim());
		}

		return result;
	}

	/**
	 * 
	 * <p>
	 * Description:解析xml数据,将xml�?有的跟节点转换为Map数据
	 * </p>
	 * 
	 * @author haitao5623@163.com
	 * @date 2016�?3�?8日上�?10:32:31
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public Map<String, Object> getMapsData(String xmlStr) throws DocumentException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Document doc = DocumentHelper.parseText(xmlStr);
		// 获得根节�?
		Element root = doc.getRootElement();
		return getMapData(root, resultMap);
	}

	/**
	 * <p>
	 * Description:解析xml数据,将xml数据转换为Map
	 * </p>
	 * 
	 * @author haitao5623@163.com
	 * @date 2016�?3�?7日下�?3:36:37
	 * @param element
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> getData(Element element) {
		List<?> elements = element.elements();
		Map<String, Object> retMap = new HashMap<String, Object>();

		for (int i = 0; i < elements.size(); i++) {
			Element nestElement = (Element) elements.get(i);

			String key = nestElement.getName();

			if (0 < nestElement.elements().size()) {
				// 当前节点有子节点元素
				if (null == retMap.get(key)) {
					retMap.put(key, getData(nestElement));
				} else {
					List<Object> nestList = null;
					if (retMap.get(key) instanceof List) {
						nestList = (List<Object>) retMap.get(key);
					} else {
						nestList = new ArrayList<Object>();
						nestList.add(retMap.get(key));
					}
					nestList.add(getData(nestElement));
					retMap.put(nestElement.getName(), nestList);
				}

			} else {
				// 当前节点无子节点元素
				if (null == retMap.get(key)) {
					retMap.put(key, "".equals(nestElement.getTextTrim()) ? null : nestElement.getTextTrim());
				} else {
					List<Object> nestList = null;
					if (retMap.get(key) instanceof List) {
						nestList = (List<Object>) retMap.get(key);
					} else {
						nestList = new ArrayList<Object>();
						nestList.add(retMap.get(key));
					}
					nestList.add(nestElement.getTextTrim());
					retMap.put(nestElement.getName(), nestList);
				}
			}
		}
		return retMap;
	}

	/**
	 * 
	 * <p>
	 * Description:解析XML文件,将所有的跟节点添加到Map�?
	 * </p>
	 * 
	 * @author haitao5623@163.com
	 * @date 2016�?3�?8日上�?9:33:45
	 * @param element
	 * @return
	 */
	private Map<String, Object> getMapData(Element element, Map<String, Object> resultMap) {
		List<?> elements = element.elements();
		for (int i = 0; i < elements.size(); i++) {
			Element nestElement = (Element) elements.get(i);
			String key = nestElement.getName();
			if (0 < nestElement.elements().size()) {
				getMapData(nestElement, resultMap);
			} else {
				if (null == resultMap.get(key)) {
					resultMap.put(key, "".equals(nestElement.getTextTrim()) ? null : nestElement.getTextTrim());
				}
			}
		}
		return resultMap;
	}

}
