package com.qiandai.util.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class PoiTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		excelReadeTest();
		exportExcel();
	}

	/**
	 * 
	 * <p>Description:读出excel测试</p>
	 * @author yuboping@new4g.cn
	 * @date 2016年5月12日下午2:24:17
	 */
	public static void excelReadeTest() {
		ExcelReader er = new ExcelReader();
		InputStream is = null;
		try {
			is = new FileInputStream("E:\\用户购买详情反馈清单.xls");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] s = { "ft_orderNo", "ft_insu_name", "ft_user", "ft_amount",
				"ft_date", "ft_code" };
		List<Map<String, Object>> map = er.readExcelContent(is, s);
		for (Map<String, Object> m : map) {
			for (String k : m.keySet()) {
				System.out.println(k + " : " + m.get(k));
			}
		}
	}

	/**
	 * 
	 * <p>Description:写入excel测试</p>
	 * @author yuboping@new4g.cn
	 * @date 2016年5月12日下午2:24:39
	 */
	public static void exportExcel() {
		try {
			OutputStream out = new FileOutputStream("E:\\测试.xls");
			List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
			String[] headers = { "name", "age", "mN" };
			for (int i = 0; i < 4; i++) {
				PersonBean person = new PersonBean();
				person.setAge(25);
				person.setmN("male");
				person.setName("Mike");
				data.add(BeanUtilTest.transBean2Map(person));
			}
			HSSFWorkbook workbook = new HSSFWorkbook();
			ExportExcelUtils
					.exportExcel(workbook, 0, "钱生钱", headers, data, out);
			ExportExcelUtils
					.exportExcel(workbook, 1, "流水贷", headers, data, out);
			ExportExcelUtils.exportExcel(workbook, 2, "代扣代付", headers, data,
					out);
			// 原理就是将所有的数据一起写入，然后再关闭输入流。
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}