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
	 * <p>Description:����excel����</p>
	 * @author yuboping@new4g.cn
	 * @date 2016��5��12������2:24:17
	 */
	public static void excelReadeTest() {
		ExcelReader er = new ExcelReader();
		InputStream is = null;
		try {
			is = new FileInputStream("E:\\�û��������鷴���嵥.xls");
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
	 * <p>Description:д��excel����</p>
	 * @author yuboping@new4g.cn
	 * @date 2016��5��12������2:24:39
	 */
	public static void exportExcel() {
		try {
			OutputStream out = new FileOutputStream("E:\\����.xls");
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
					.exportExcel(workbook, 0, "Ǯ��Ǯ", headers, data, out);
			ExportExcelUtils
					.exportExcel(workbook, 1, "��ˮ��", headers, data, out);
			ExportExcelUtils.exportExcel(workbook, 2, "���۴���", headers, data,
					out);
			// ԭ����ǽ����е�����һ��д�룬Ȼ���ٹر���������
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}