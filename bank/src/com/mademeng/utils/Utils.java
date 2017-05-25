package com.mademeng.utils;

import java.util.Calendar;

public class Utils {
	/**
	 * 获得系统当前时间  格式2017-5-02 20:10:30
	 */
	public static String getTime() {
		Calendar calendar = Calendar.getInstance();
		String nowTime = ""+calendar.get(Calendar.YEAR) +"-"+ (calendar.get(Calendar.MONTH)+1) +"-"+ calendar.get(Calendar.DATE)
		+" "+ calendar.get(Calendar.HOUR_OF_DAY) +":"+ calendar.get(Calendar.MINUTE) +":"+ calendar.get(Calendar.SECOND);
		return nowTime;
	}
}
