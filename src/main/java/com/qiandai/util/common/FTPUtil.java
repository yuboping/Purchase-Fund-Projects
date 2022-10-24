package com.qiandai.util.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * <p>Title:FTPUtil</p>
 * <p>Description:FTP服务器工具类</p>
 * @author haitao5623@163.com
 * @date 2016�?3�?21日上�?10:21:54
 */
public class FTPUtil {
	
	private final static Logger logger = LoggerFactory.getLogger(FTPUtil.class);
	
	// FTP 请求地址
	private static final String FTPURL = ConfigUtil.getPropertyKey("ftp.url");
	
	// FTP 用户名
	private static final String FTPUSER = ConfigUtil.getPropertyKey("ftp.user");
	
	// FTP 密码
	private static final String FTPPASSWORD = ConfigUtil.getPropertyKey("ftp.password");
	
	// FTP 目录
	private static final String FTPPATH = ConfigUtil.getPropertyKey("ftp.path");
	
	// FTP 端口
	private static final int FTPPORT = Integer.valueOf(ConfigUtil.getPropertyKey("ftp.port"));
	
	
	/**
	 * 
	 * <p>Description:字符串上传到FTP</p>
	 * @author haitao5623@163.com
	 * @date 2016�?3�?30日下�?12:11:40
	 * @param fileName 上传文件名称
	 * @param ftpPath ftp存放目录
	 * @param content 文件内容
	 * @return
	 */
	public static boolean ftpUploadToStr(String fileName,String ftpPath,String content) {
		FTPClient client = new FTPClient();
		boolean falg = true;
		InputStream is = null;
		try {
			client.connect(FTPURL,FTPPORT);
			
			client.login(FTPUSER, FTPPASSWORD);
			
			decodeDir(client,FTPPATH+ftpPath);	
			
			is = new ByteArrayInputStream(content.getBytes("UTF-8"));
			
			client.setBufferSize(1024);
			
			client.setControlEncoding("GBK"); 
			
			// 设置文件类型为二进制
	 		client.setFileType(FTPClient.BINARY_FILE_TYPE);
			
	 		falg = client.storeFile(fileName, is);
	 		
	 		client.logout();
		} catch (Exception e) {	
			e.printStackTrace();
			logger.error("File upload failed:"+e.getMessage());
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("File upload failed:"+e.getMessage());
				}
			}
			try {
				client.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("File upload failed:"+e.getMessage());
			}
		}
		return falg;
	}
	
	/**
	 * 
	 * <p>Description:ftp文件上传</p>
	 * @author haitao5623@163.com
	 * @date 2016�?3�?21日下�?2:20:26
	 * @param path 上传文件的目�?
	 * @param fileName 上传文件名称
	 * @param ftpPath ftp存放目录
	 * @return true 上传成功,false 上传失败
	 */
	public static boolean ftpUpload(String path,String fileName,String ftpPath) {
		FTPClient client = new FTPClient();
		File file = null;
		FileInputStream fis = null; 
		boolean falg = true;
		
		try {
			file = new File(path); 
			
			fis = new FileInputStream(file);
			client.connect(FTPURL,FTPPORT);
			
			client.login(FTPUSER, FTPPASSWORD);
			
			decodeDir(client,FTPPATH+ftpPath);
			
			client.setBufferSize(1024);
			client.setControlEncoding("GBK"); 
			// 设置文件类型为二进制
	 		client.setFileType(FTPClient.BINARY_FILE_TYPE);
	 		falg = client.storeFile(fileName, fis);
	 		client.logout();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("File upload failed:"+e.getMessage());
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("File upload failed:"+e.getMessage());
				}
			}
			try {
				client.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("File upload failed:"+e.getMessage());
			}
		}
		return falg;
	}
	
	/**
	 * 
	 * <p>Description:ftp文件下载</p>
	 * @author haitao5623@163.com
	 * @date 2016�?3�?21日下�?2:46:37
	 * @param outPath 下载路径
	 * @param fileName 下载的文件名�?
	 * @return true 下载成功,false 下载失败
	 */
	public static boolean ftpDownload(String outPath,String fileName) {
		FTPClient client = new FTPClient(); 
        FileOutputStream fos = null; 
        boolean falg = true;
        
        try {
			client.connect(FTPURL, FTPPORT);
			client.login(FTPUSER, FTPPASSWORD);
			fos = new FileOutputStream(outPath);
			client.setBufferSize(1024);
			// 设置文件类型为二进制
	 		client.setFileType(FTPClient.BINARY_FILE_TYPE);
	 		falg = client.retrieveFile(FTPPATH+fileName, fos);
	 		client.logout();
		}  catch (Exception e) {
			e.printStackTrace();
			logger.error("File download failed:"+e.getMessage());
		} finally {
			if (null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("File download failed:"+e.getMessage());
				}
			}
			try {
				client.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("File download failed:"+e.getMessage());
			}
		}
      
        return falg;
	}
	
	/**
	 * 
	 * <p>Description:</p>
	 * @author haitao5623@163.com
	 * @date 2016�?4�?6日下�?2:28:54
	 * @param outPath 下载路径
	 * @param code 文件编码
	 * @return
	 */
	public static String ftpDownloadToStr(String outPath,String code) {
		FTPClient client = new FTPClient(); 
		InputStream is = null;
		BufferedReader br = null;
		StringBuffer result = new StringBuffer();
        try {
        	
			client.connect(FTPURL, FTPPORT);
			client.login(FTPUSER, FTPPASSWORD);
	 		is = client.retrieveFileStream(outPath);
	 		br = new BufferedReader(new InputStreamReader(is,code));
	 		
	 		String line = "";
			while ((line = br.readLine()) != null) {
				result.append(line+"\r\n");
			}
	 		
	 		client.logout();
		}  catch (Exception e) {
			e.printStackTrace();
			logger.error("File downloadToStr failed:"+e.getMessage());
		} finally {
			if (null != is) {
				try {
					is.close();
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("File downloadToStr failed:"+e.getMessage());
				}
			}
			
			try {
				client.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("File downloadToStr failed:"+e.getMessage());
			}
		}
      
        return result.toString();
	}
	
	
	/**
	 * 该方法只能创建一层目�?
	 * <p>Description:判断服务器的文件目前是否存在</p>
	 * @author haitao5623@163.com
	 * @date 2016�?3�?21日下�?1:45:26
	 * @param client FTP客户�?
	 * @param path 服务器目�?
	 * @return
	 */
	private static boolean decodeDir(FTPClient client,String path) {
		boolean result = true;
		try {
			boolean dir = client.changeWorkingDirectory(path);
			System.out.println(dir);
			if (!dir) {
				// 创建目录
				boolean falg = client.makeDirectory(path);
				if (!falg) {
					result = false;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Failed to create directory�?" + e.getMessage());
		}
		return result;
	}
	
}
