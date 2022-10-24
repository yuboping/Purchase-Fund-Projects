package com.qiandai.util.excel;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportExcelUtils {

	/**
	 * 
	 * <p>
	 * Description:����Excel�ķ���
	 * </p>
	 * 
	 * @author yuboping@new4g.cn
	 * @date 2016��5��6������5:14:08
	 * @param workbook
	 * @param sheetNum
	 *            (sheet��λ�ã�0��ʾ��һ������еĵ�һ��sheet)
	 * @param sheetTitle
	 *            (sheet������)
	 * @param headers
	 *            (���ı���)
	 * @param result
	 *            (��������)
	 * @param out
	 *            (�����)
	 * @throws Exception
	 */
	public static void exportExcel(HSSFWorkbook workbook, int sheetNum,
			String sheetTitle, String[] headers,
			List<Map<String, Object>> result, OutputStream out)
			throws Exception {
		// ����һ�����
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(sheetNum, sheetTitle);
		// ���ñ��Ĭ���п��Ϊ20���ֽ�
		sheet.setDefaultColumnWidth((short) 20);
		// ����һ����ʽ
		HSSFCellStyle style = workbook.createCellStyle();
		// ������Щ��ʽ
		// style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
		// style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		// style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// ����һ������
		// HSSFFont font = workbook.createFont();
		// font.setColor(HSSFColor.BLACK.index);
		// font.setFontHeightInPoints((short) 12);
		// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// ������Ӧ�õ���ǰ����ʽ
		// style.setFont(font);

		// ָ������Ԫ��������ʾ����ʱ�Զ�����
		style.setWrapText(true);

		// ������������
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text.toString());
		}
		// �����������ݣ�����������
		if (null != result) {
			int index = 1;
			for (Map<String, Object> m : result) {
				row = sheet.createRow(index);
				int cellIndex = 0;
				for (int i = 0; i < headers.length; i++) {
					HSSFCell cell = row.createCell(cellIndex);
					cell.setCellValue(m.get(headers[i]).toString());
					cellIndex++;
				}
				index++;
			}
		}
	}
}