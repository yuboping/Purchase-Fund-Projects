package com.qiandai.util.common;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * <p>
 * Title:DateUtil
 * </p>
 * <p>
 * Description:日期转换工具类
 * </p>
 * 
 * @author wanghaitao01@new4g.cn
 * @date 2016�?3�?15日下�?5:22:09
 */
public class DateUtil {

	public static final String C_TIME_PATTON_DEFAULT = "yyyy-MM-dd HH:mm:ss";
	public static final String C_DATE_PATTON_DEFAULT = "yyyy-MM-dd";

	public static final String C_TIMES_PATTON_DEFAULT = "yyyyMMddHHmmss";
	public static final String C_DATES_PATTON_DEFAULT = "yyyyMMdd";
	public static final String T_TIMES_PATTON_DEFAULT = "HHmmss";

	public static final long C_ONE_SECOND = 1000; // �?
	public static final long C_ONE_MINUTE = 60 * C_ONE_SECOND; // 分钟
	public static final long C_ONE_HOUR = 60 * C_ONE_MINUTE; // 小时
	public static final long C_ONE_DAY = 24 * C_ONE_HOUR; // �?

	/**
	 * 
	 * <p>
	 * Description:SimpleDateFormat公共私有�?
	 * </p>
	 * 
	 * @author wanghaitao01@new4g.cn
	 * @date 2016�?3�?15日下�?5:59:44
	 * @param format
	 *            转换的日期格�?,比如:yyyy-MM-dd
	 * @return
	 */
	private static SimpleDateFormat getSimpleDateFormat(String format) {
		SimpleDateFormat sdf;
		// 默认时间格式
		if ("".equals(format) || null == format) {
			sdf = new SimpleDateFormat(C_TIME_PATTON_DEFAULT);
		} else {
			sdf = new SimpleDateFormat(format);
		}
		return sdf;
	}

	/**
	 * 
	 * <p>
	 * Description:将字符串日期转换为Date日期
	 * </p>
	 * 
	 * @author wanghaitao01@new4g.cn
	 * @date 2016�?3�?15日下�?6:23:46
	 * @param dateStr
	 *            �?要转换的日期字符�?
	 * @param format
	 *            转换的日期格�?,比如:yyyy-MM-dd
	 * @return
	 */
	public static Date parseDate(String dateStr, String format) {
		if (dateStr == null) {
			return null;
		}
		SimpleDateFormat sdf = getSimpleDateFormat(format);
		return sdf.parse(dateStr, new ParsePosition(0));
	}

	/**
	 * 
	 * <p>
	 * Description:将Date类型转换为String类型
	 * </p>
	 * 
	 * @author wanghaitao01@new4g.cn
	 * @date 2016�?3�?15日下�?6:10:16
	 * @param date
	 *            �?要转换的日期
	 * @param format
	 *            转换的日期格�?,比如:yyyy-MM-dd
	 * @return
	 */
	public static String parseStr(Date date, String format) {
		if (null == date) {
			return null;
		}
		SimpleDateFormat sdf = getSimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 
	 * <p>
	 * Description:日期加N�?
	 * </p>
	 * 
	 * @author wanghaitao01@new4g.cn
	 * @date 2016�?3�?16日上�?10:00:28
	 * @param date
	 *            �?要加N天的日期
	 * @param day
	 *            �?要添加的天数
	 * @return 返回加N天之后的日期
	 */
	public static Date getPlusDay(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}
	
	/**
	 * 
	 * <p>Description:比较两个日期的大�?</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016�?3�?31日下�?2:37:52
	 * @param fdate
	 * @param sdate
	 * @return
	 */
	public static int compareDate(String fdate,String sdate) {
		Date datef = parseDate(fdate,"yyyy-MM-dd");
		Date dates = parseDate(sdate,"yyyy-MM-dd");
		return datef.compareTo(dates);
	}

}
