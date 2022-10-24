package com.qiandai.util.common;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;


public class ConfigUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigUtil.class);

	private static final String CONF_PATH = "config/db.properties";

	/**
	 * 
	 * <p>
	 * Description:����PropertyKey��ȡ��Ӧ��ֵ
	 * </p>
	 * 
	 * @author wanghaitao@new4g.cn
	 * @date 2016��3��8������5:00:52
	 * @param key
	 * @return
	 */
	public static String getPropertyKey(String key) {
		Properties st = getConxtions();
		return st.getProperty(key);
	}

	/**
	 * 
	 * <p>
	 * Description:����Properties�ļ���ȡProperties
	 * </p>
	 * 
	 * @author wanghaitao@new4g.cn
	 * @date 2016��3��8������4:56:27
	 * @return
	 */
	public static Properties getConxtions() {
		Properties properties = null;
		try {
			properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource(CONF_PATH));
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
		}
		return properties;
	}
}
