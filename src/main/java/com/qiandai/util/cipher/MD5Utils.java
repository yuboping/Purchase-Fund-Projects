package com.qiandai.util.cipher;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>Title:MD5Utils</p>
 * <p>Description:md5 加密工具类</p>
 * <p>Company:北京钱袋宝公司南京分公司</p>
 * @author wanghaitao01@new4g.cn
 * @date 2016年4月29日下午4:19:36
 */
public class MD5Utils {
	
	private static final Logger logger = LoggerFactory.getLogger(MD5Utils.class);

	/**
	 * 计算一个字符串的MD5
	 * 
	 * @param sourceStr
	 * @return
	 */
	public static String md5(String sourceStr) {
		String md5str = null;
		try {
			// 创建一个提供信息摘要算法的对象，初始化为md5算法对象
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算后获得字节数组
			byte[] buff = md.digest(sourceStr.getBytes("utf-8"));
			// 把数组每一字节换成16进制连成md5字符串
			md5str = bytesToHex(buff);
		} catch (Exception e) {
			logger.error("md5加密错误:" + e.getLocalizedMessage());
		}
		return md5str;
	}

	/**
	 * 验证md5是否正确
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
	 * 把字节数组转换为16进制字符串
	 * 
	 * @param bytes
	 * @return
	 */
	private static String bytesToHex(byte[] bytes) {

		StringBuffer md5str = new StringBuffer();
		// 把数组每一字节换成16进制连成md5字符串
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
