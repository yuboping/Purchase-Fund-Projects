package com.qiandai.back.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiandai.util.controller.BaseController;

@Controller
public class IndexController extends BaseController {

	@RequestMapping(value = "in")
	public String in(HttpServletRequest request) {
		return "back/page/exc";
	}

	@ResponseBody
	@RequestMapping(value = "downLoad")
	public void downLoad(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println("----------------��ʼ����excel-----------------");
		String st = request.getServletContext().getRealPath("download");
		System.out.println(st);
//		String path = BaseController.downLoad("����.xls");
//		System.out.println(path);
		//����MIME����Ϊexcel
		response.setContentType("application/vnd.ms-excel");
		// ����Content-Disposition
		response.setHeader("Content-Disposition", "attachment;filename=temp.xls");
		// ��ȡ�ļ�
		InputStream in = new FileInputStream("E:/����.xls");
		OutputStream out = response.getOutputStream();
		// д�ļ�
		int b;
		while ((b = in.read()) != -1) {
			out.write(b);
		}
		in.close();
		out.close();
		System.out.println("----------------��������excel-----------------");
	}

}
