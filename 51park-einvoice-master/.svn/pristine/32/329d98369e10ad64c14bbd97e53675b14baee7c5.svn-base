package com.park.einvoice.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base64Tools {
	
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	
	public static Logger logger =LoggerFactory.getLogger(Base64Tools.class);
	  
	public static byte[] encode(byte[] bytes){
		return Base64.encodeBase64(bytes);
	}
	  
	public static String encode2String(byte[] bytes){
		return Base64.encodeBase64String(bytes);
	}
	  
	public static String encode2String(String targetString){
	    byte[] bytes = targetString.getBytes(DEFAULT_CHARSET);
	    return Base64.encodeBase64String(bytes);
	}
	
	public static String encode2FileUrl(String url){
		InputStream in =null;
		try {
			url ="/Users/wupanjun/Desktop/个人/图片/4DF22469-BF16-4CE7-B3B2-FB8402894FC3.png";
			
			in = new FileInputStream(url);
			byte[] bytes = new byte[in.available()];
			in.read(bytes);
			String base64String= Base64.encodeBase64String(bytes);
			logger.info("** 读取图片获取的base64字符串"+base64String);
			return base64String;
		} catch (FileNotFoundException e) {
			logger.error("** 读取税务登记证图片错误："+e);
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			logger.error("** 读取税务登记证图片错误："+e);
			e.printStackTrace();
			return null;
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String encode2FileUrl(InputStream inputStream){
		try {
			byte[] bytes = new byte[inputStream.available()];
			inputStream.read(bytes);
			String base64String= Base64.encodeBase64String(bytes);
			logger.info("** 读取图片获取的base64字符串"+base64String);
			return base64String;
		} catch (FileNotFoundException e) {
			logger.error("** 读取税务登记证图片错误："+e);
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			logger.error("** 读取税务登记证图片错误："+e);
			e.printStackTrace();
			return null;
		}finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static byte[] encode2Byte(String targetString){
	    byte[] bytes = targetString.getBytes(DEFAULT_CHARSET);
	    return Base64.encodeBase64(bytes);
	}
	  
	public static byte[] decode(byte[] bytes){
	    return Base64.decodeBase64(bytes);
	}
	  
	public static String decode(String targetString){
	    return new String(Base64.decodeBase64(targetString));
	}
	  
	public static byte[] decode2Byte(String targetString){
	    byte[] bytes = targetString.getBytes(DEFAULT_CHARSET);
	    return Base64.decodeBase64(bytes);
	}
	
	public static String decode2String(String targetString){
	    byte[] bytes = targetString.getBytes(DEFAULT_CHARSET);
	    return new String(decode(bytes));
	}

}
