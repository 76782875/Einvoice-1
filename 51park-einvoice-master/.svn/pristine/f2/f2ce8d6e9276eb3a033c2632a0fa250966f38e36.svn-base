package com.park.einvoice.common;

import java.nio.charset.Charset;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.park.einvoice.common.exception.ExceptionHandler;

public class SecurityTools {
	private static final String ALGORITHM_3DES = "DESede";
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	  
	public static byte[] encrypt3DES(String encryptPassword, byte[] encryptByte){
		try{
			Cipher cipher = init3DES(encryptPassword, 1);
			return cipher.doFinal(encryptByte);
	    }catch (Exception e){
	    	ExceptionHandler.castException(e);
	    }
	    return null;
	}
	  
	public static String encrypt3DES(String encryptPassword, String encryptStr){
	    try{
	    	Cipher cipher = init3DES(encryptPassword, 1);
	    	byte[] enBytes = cipher.doFinal(encryptStr.getBytes(DEFAULT_CHARSET));
	    	return Base64Tools.encode2String(enBytes);
	    }catch (Exception e){
	    	ExceptionHandler.castException(e);
	    }
	    return null;
	}
	  
	public static byte[] decrypt3DES(String decryptPassword, byte[] decryptByte){
		try{
			Cipher cipher = init3DES(decryptPassword, 2);
			return cipher.doFinal(decryptByte);
	    }catch (Exception e){
	    	ExceptionHandler.castException(e);
	    }
	    return null;
	}
	  
	public static String decrypt3DES(String decryptPassword, String decryptString){
		try{
			Cipher cipher = init3DES(decryptPassword, 2);
			byte[] deBytes = cipher.doFinal(Base64Tools.decode2Byte(decryptString));
			return new String(deBytes, DEFAULT_CHARSET);
	    }catch (Exception e){
	      ExceptionHandler.castException(e);
	    }
	    return null;
	  }
	  
	private static Cipher init3DES(String decryptPassword, int cipherMode)throws Exception{
		SecretKey deskey = new SecretKeySpec(decryptPassword.getBytes(), ALGORITHM_3DES);
	    Cipher cipher = Cipher.getInstance(ALGORITHM_3DES);
	    cipher.init(cipherMode, deskey);
	    return cipher;
	}

}
