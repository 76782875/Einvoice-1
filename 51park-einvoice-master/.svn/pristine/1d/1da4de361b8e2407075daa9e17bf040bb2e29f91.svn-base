package com.park.einvoice.common;

import java.security.MessageDigest;

/**
 * 功能：MD5加密
 * 备注：
 */

public class MD5encryptTool {
	
	/**
	 * 生成MD5指纹
	 * @param string
	 * @return
	 * @throws Exception
	 */
	public static String getMD5(String string) throws Exception{
		StringBuilder stringBuilder = new StringBuilder();
		byte[] buf = string.getBytes("UTF-8");
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(buf);
		byte[] tmp = md5.digest();
		for (byte b : tmp) {
			int val = ((int) b) & 0xff;
			if (val < 16) {
				stringBuilder.append("0");
			}
			stringBuilder.append(Integer.toHexString(b & 0xff));
		}
		return stringBuilder.toString().toUpperCase();
	}
}
