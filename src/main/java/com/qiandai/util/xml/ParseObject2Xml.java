package com.qiandai.util.xml;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>Title:ParseObject2Xml</p>
 * <p>Description:将对象转换为xml</p>
 * @author haitao5623@163.com
 * @date 2016年4月15日下午6:01:44
 */
public class ParseObject2Xml {

	private static Logger logger = LoggerFactory.getLogger(ParseObject2Xml.class);

	/**
	 * 
	 * <p>
	 * Description:解析Map获取xml数据
	 * </p>
	 * 
	 * @author haitao5623@163.com
	 * @date 2016�?3�?8日下�?2:39:58
	 * @param data
	 * @return
	 */
	public static String getXml(Map<?, ?> data) {
		Document doc = DocumentHelper.createDocument();
		XMLWriter xmlWriter = null;
		StringWriter writer = new StringWriter();

		try {
			parser(data, doc);
			xmlWriter = new XMLWriter(writer);
			xmlWriter.write(doc);
			xmlWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("ParseObject2Xml class getXml method IOException fail: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			logger.error("ParseObject2Xml class getXml method IllegalArgumentException fail:" + e.getMessage());
		} finally {
			if (xmlWriter != null) {
				try {
					xmlWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("xmlWriter close" + e.getMessage());
				}
			}
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("writer close" + e.getMessage());
				}
			}
		}
		return writer.toString();
	}

	/**
	 * 
	 * <p>
	 * Description:判断Map数据转换为xml数据
	 * </p>
	 * 
	 * @author haitao5623@163.com
	 * @date 2016�?3�?8日下�?2:42:40
	 * @param data
	 * @param doc
	 */
	private static void parser(Map<?, ?> data, Document doc) {
		// 判断data是否可以解析为xml数据
		if (1 < data.size()) {
			logger.info("parser方法解析失败:Object非xml数据格式");
			throw new IllegalArgumentException();
		}

		// 创建xml节点
		Element element = null;
		String rootkey = "";
		// 迭代Map数据
		Iterator<?> it = data.entrySet().iterator();

		// 获取Map中key�?,用于创建xml节点
		while (it.hasNext()) {
			Entry<?, ?> entry = (Entry<?, ?>) it.next();
			rootkey = (String) entry.getKey();
			element = doc.addElement(rootkey);
		}

		// 判断Map的key值是否是String类型
		if (data.get(rootkey) instanceof String) {
			element.setText(data.get(rootkey).toString());
		} else {
			nestParse(element, data, rootkey);
		}

	}

	/**
	 * 
	 * <p>
	 * Description:解析Map数据转换为xml数据
	 * </p>
	 * 
	 * @author haitao5623@163.com
	 * @date 2016�?3�?8日下�?2:45:10
	 * @param root
	 * @param data
	 */
	public static void nestParse(Element root, Map<?, ?> data,String rootkey) {
		Map<?, ?> dataMap = (Map<?, ?>) data;
		String key = "";
		Iterator<?> it = dataMap.entrySet().iterator();

		while (it.hasNext()) {
			Entry<?, ?> entry = (Entry<?, ?>) it.next();
			key = (String) entry.getKey();
			Object value = entry.getValue();

			if (value instanceof Map) {
				if (!key.equals(rootkey)) {
					Element element = root.addElement(key);
					nestParse(element, (Map<?, ?>) value,key);
				}  else {
					nestParse(root, (Map<?, ?>) value,key);
				}
			} else if (value instanceof List) {
				List<?> valList = (List<?>) value;
				for (int i = 0; i < valList.size(); i++) {
					Element element = root.addElement(key);
					if (valList.get(i) instanceof String) {
						element.setText(valList.get(i).toString());
					} else if (valList.get(i) instanceof Map) {
						nestParse(element, (Map<?, ?>) valList.get(i),key);
					}
				}
			} else {
				Element element = root.addElement(key);
				if (null != value && !"".equals(value)) {
					element.setText(value.toString());
				} else {
					element.setText("");
				}
			}
		}
	}

}
