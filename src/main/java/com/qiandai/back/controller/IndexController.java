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
		System.out.println("----------------开始下载excel-----------------");
		String st = request.getServletContext().getRealPath("download");
		System.out.println(st);
//		String path = BaseController.downLoad("测试.xls");
//		System.out.println(path);
		//设置MIME类型为excel
		response.setContentType("application/vnd.ms-excel");
		// 设置Content-Disposition
		response.setHeader("Content-Disposition", "attachment;filename=temp.xls");
		// 读取文件
		InputStream in = new FileInputStream("E:/测试.xls");
		OutputStream out = response.getOutputStream();
		// 写文件
		int b;
		while ((b = in.read()) != -1) {
			out.write(b);
		}
		in.close();
		out.close();
		System.out.println("----------------结束下载excel-----------------");
	}

}
