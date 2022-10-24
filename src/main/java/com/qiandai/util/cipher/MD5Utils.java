package com.qiandai.util.cipher;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>Title:MD5Utils</p>
 * <p>Description:md5 ���ܹ�����</p>
 * <p>Company:����Ǯ������˾�Ͼ��ֹ�˾</p>
 * @author wanghaitao01@new4g.cn
 * @date 2016��4��29������4:19:36
 */
public class MD5Utils {
	
	private static final Logger logger = LoggerFactory.getLogger(MD5Utils.class);

	/**
	 * ����һ���ַ�����MD5
	 * 
	 * @param sourceStr
	 * @return
	 */
	public static String md5(String sourceStr) {
		String md5str = null;
		try {
			// ����һ���ṩ��ϢժҪ�㷨�Ķ��󣬳�ʼ��Ϊmd5�㷨����
			MessageDigest md = MessageDigest.getInstance("MD5");
			// ��������ֽ�����
			byte[] buff = md.digest(sourceStr.getBytes("utf-8"));
			// ������ÿһ�ֽڻ���16��������md5�ַ���
			md5str = bytesToHex(buff);
		} catch (Exception e) {
			logger.error("md5���ܴ���:" + e.getLocalizedMessage());
		}
		return md5str;
	}

	/**
	 * ��֤md5�Ƿ���ȷ
	 * 
	 * @param source
	 * @param md5
	 * @return
	 */
	public static boolean verifyMd5(String source, String md5) {
		String md5_val = md5(source);
		return md5_val.equalsIgnoreCase(md5);
	}

	/**
	 * ���ֽ�����ת��Ϊ16�����ַ���
	 * 
	 * @param bytes
	 * @return
	 */
	private static String bytesToHex(byte[] bytes) {

		StringBuffer md5str = new StringBuffer();
		// ������ÿһ�ֽڻ���16��������md5�ַ���
		int digital;
		for (int i = 0; i < bytes.length; i++) {
			digital = bytes[i];
			if (digital < 0) {
				digital += 256;
			}
			if (digital < 16) {
				md5str.append("0");
			}
			md5str.append(Integer.toHexString(digital));
		}
		return md5str.toString();
	}
}
