/** 
 * Create on Mar 9, 2017
 * Copyright 2011 VisualProject All Rights Reserved.
 */
package com.park.einvoice.common;

import java.text.Collator;
import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 开发工具类
 * @author fangct
 * @since version1.0
 */
public class Tools {

	/**
	 * 判断是否为数字
	 * @param number 数据
	 * @return 如果是数字类型返回true，否则false
	 */
	public static boolean isNumber(String number){
		if (isNull(number)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[0-9]*$");
		Matcher matcher = pattern.matcher(number);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 对比字符串是否相等 相等返回true
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static Boolean compareStr(String s1, String s2) {
		Collator c = Collator.getInstance();
		return c.compare(s1, s2) == 0;
	}


	/**
	 * 判断网站地址是否正确
	 */
	public static boolean isWebUrl(String url) {
		if (isNull(url)) {
			return false;
		}
		Pattern pattern = Pattern
				.compile("^([a-zA-z]+://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\S*)?$");
		Matcher matcher = pattern.matcher(url);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断邮政编码是否正确
	 */
	public static boolean isZipCode(String zip) {
		if (isNull(zip)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^\\d{6}$");
		Matcher matcher = pattern.matcher(zip);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断手机号是否正确
	 */
	public static boolean isPhone(String phone) {
		if (isNull(phone)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^1[0-9]{10}$");
		Matcher matcher = pattern.matcher(phone);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断邮箱是否正确
	 */
	public static boolean isEmail(String email) {
		if (isNull(email)) {
			return false;
		}
		Pattern pattern = Pattern
				.compile("^\\w+([-.]\\w+)*@\\w+([-]\\w+)*\\.(\\w+([-]\\w+)*\\.)*[a-z]{2,3}$");
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * 将数字解释为财务数字格式显示
	 */
	public static String parseMoneyString(String str) {
		try {
			if (str.startsWith(".")) {
				return "0" + str;
			}
			if (str.startsWith("0")) {
				return str;
			}
			if (!Tools.isNotNull(str) || "0".equals(str)
					|| str.startsWith(".") || str.startsWith("0")) {
				return "0";
			} else {
				return (new DecimalFormat("#,###.00")).format(Double
						.parseDouble(str));
			}
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 把财务格式的数字转成浮点数
	 */
	public static String parseMoneyFloat(Object str) {
		try {
			if (!Tools.isNotNull(str) || "0".equals(str)) {
				return "0";
			} else {
				return str.toString().replaceAll(",", "");
			}
		} catch (Exception e) {
			return "0";
		}
	}


	/**
	 * 转换整数，无需关心是否为空
	 * 
	 * @param a
	 * @return
	 */
	public static int parseInt(Object a) {
		if(isNull(toString(a))){
			return 0;
		}
		return Integer.parseInt(toString(a));
	}

	/**
	 * 转换浮点型，无需关心是否为空
	 * 
	 * @param a
	 * @return
	 */
	public static Float parseFloat(Object a) {
		if(isNull(toString(a))){
			return 0.0f;
		}
		return Float.parseFloat(toString(a));
	}
	
	/**
	 * 转换双精度型，无需关心是否为空
	 * 
	 * @param a
	 * @return
	 */
	public static Double parseDouble(Object a) {
		if(isNull(toString(a))){
			return 0.0;
		}
		return Double.parseDouble(toString(a));
	}
	
	/**
	 * 转换双精度型，无需关心是否为空
	 * 
	 * @param a
	 * @return
	 */
	public static Double parseDouble(Object a,String formater) {
		if(isNull(toString(a))){
			return 0.0;
		}
		DecimalFormat formaterObj = new DecimalFormat(formater);
		return Tools.parseDouble(formaterObj.format(Tools.parseDouble(toString(a))));
	}
	
	/**
	 * 转换浮点型，无需关心是否为空
	 * 
	 * @param a
	 * @return
	 */
	public static Float parseFloat(Object a,String formater) {
		if(isNull(toString(a))){
			return 0.00f;
		}
		DecimalFormat formaterObj = new DecimalFormat(formater);
		return Tools.parseFloat(formaterObj.format(Tools.parseFloat(toString(a))));
	}
	
	/**
	 * 转换字符型，无需关心是否为空
	 * 
	 * @param a
	 * @return
	 */
	public static String parseString(Object a,String formater) {
		if(isNull(toString(a))){
			return "0.00";
		}
		DecimalFormat formaterObj = new DecimalFormat(formater);
		return formaterObj.format(Tools.parseFloat(toString(a)));
	}

	/**
	 * 判断不是空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotNull(Object obj) {
		if (obj == null || obj.toString().equals("")
				|| obj.toString().toLowerCase().equals("null"))
			return false;
		return true;
	}

	/**
	 * 判断是空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNull(Object obj) {
		if (obj == null || obj.toString().trim().length() == 0
				|| obj.toString().toLowerCase().equals("null")){
			return true;
		}
		return false;
	}

	/**
	 * 替换字符串
	 * 
	 * @param source
	 *            源
	 * @param oldString
	 *            需要替换的旧字符
	 * @param newString
	 *            需要替换的新字符
	 * @return
	 */
	public static String replace(String source, String oldString,
			String newString) {
		StringBuffer output = new StringBuffer();

		int lengthOfSource = source.length();
		int lengthOfOld = oldString.length();

		int posStart = 0;
		int pos;

		while ((pos = source.indexOf(oldString, posStart)) >= 0) {
			output.append(source.substring(posStart, pos));

			output.append(newString);
			posStart = pos + lengthOfOld;
		}

		if (posStart < lengthOfSource) {
			output.append(source.substring(posStart));
		}

		return output.toString();
	}
	
	/**
	 * 统计字符串中包含个数
	 * @param source 字符串源
	 * @param str 检查的字符串
	 * @return 个数
	 */
	public static int countStr(String source, char str) {
		int count = 0;
		char c[] = source.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if(c[i]==str){
				count++;
			}
		}
		return count;
	}


	/**
	 * 将转换UTF8格式
	 * 
	 * @param s
	 * @return
	 */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 按照不同类型进行转换防止报NULL
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		
		if (obj != null) {
			return obj.toString();
		} else {
			if (obj instanceof String) {
				return "";
			}
			if (obj instanceof Integer) {
				return "0";
			}
			if (obj instanceof Double) {
				return "0.0";
			}
			if (obj instanceof Float) {
				return "0.0";
			} else {
				return "";
			}
		}
	}

	/**
	 * 计算百分比
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double percent(double a, double b) {
		if (a == 0) {
			return 0;
		}
		return (b / a) * 100;
	}

	/**
	 * 将List转换成String,中间用分隔符分开
	 * @param list
	 * @param separator
	 * @return
	 */
	public static String listToString(List<?> list, char separator) {    
		StringBuilder sb = new StringBuilder();    
		for (int i = 0; i < list.size(); i++) {        
			sb.append(list.get(i)).append(separator);    
		}    
		return sb.toString().substring(0,sb.toString().length()-1);
	}
	
}
