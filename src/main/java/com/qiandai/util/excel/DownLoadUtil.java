package com.qiandai.util.excel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;

public class DownLoadUtil {
	
	public static boolean downLoadFile(String filePath,
			HttpServletResponse response, String fileName, String fileType)
			throws Exception {
		File file = new File(filePath); // �����ļ�·�����File�ļ�
		// �����ļ�����(�������þͲ�ֹ����Excel�ļ��ˣ�һ�ٶ��)
		if ("pdf".equals(fileType)) {
			response.setContentType("application/pdf;charset=GBK");
		} else if ("xls".equals(fileType)) {
			response.setContentType("application/msexcel;charset=GBK");
		} else if ("doc".equals(fileType)) {
			response.setContentType("application/msword;charset=GBK");
		}
		// �ļ���
		response.setHeader("Content-Disposition", "attachment;filename=\""
				+ new String(fileName.getBytes(), "ISO8859-1") + "\"");
		response.setContentLength((int) file.length());
		byte[] buffer = new byte[4096];// ������
		BufferedOutputStream output = null;
		BufferedInputStream input = null;
		try {
			output = new BufferedOutputStream(response.getOutputStream());
			input = new BufferedInputStream(new FileInputStream(file));
			int n = -1;
			// ��������ʼ����
			while ((n = input.read(buffer, 0, 4096)) > -1) {
				output.write(buffer, 0, n);
			}
			output.flush(); // ������
			response.flushBuffer();// ������
		} catch (Exception e) {
			// �쳣�Լ���׽
		} finally {
			// �ر�����������
			if (input != null)
				input.close();
			if (output != null)
				output.close();
		}
		return false;
	}
}
