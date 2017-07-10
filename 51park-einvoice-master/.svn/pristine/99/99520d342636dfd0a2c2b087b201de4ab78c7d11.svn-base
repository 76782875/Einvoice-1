package com.park.einvoice.common;

import java.nio.charset.Charset;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;

public class RSATools {
	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	  
	public static String sign(String content, String privateKey){
		try{
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64Tools.decode2Byte(privateKey));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);
			Signature signature = Signature.getInstance("SHA1WithRSA");
			signature.initSign(priKey);
			signature.update(content.getBytes(DEFAULT_CHARSET));
			byte[] signed = signature.sign();
			return Base64Tools.encode2String(signed);
	    }catch (Exception e){
	      e.printStackTrace();
	    }
		return null;
	}
	  
	public static boolean verify(String content, String sign, String publicKey){
		try{
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			byte[] encodedKey = Base64Tools.decode2Byte(publicKey);
			PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
	      
			Signature signature = Signature.getInstance("SHA1WithRSA");
	      
			signature.initVerify(pubKey);
			signature.update(content.getBytes(DEFAULT_CHARSET));
	      
			return signature.verify(Base64Tools.decode2Byte(sign));
		}catch (Exception e){
			e.printStackTrace();
	    }
	    return false;
	  }
	  
	  public static String encrpyt(String content, String publicKeyStr)throws Exception{
		  Cipher cipher = Cipher.getInstance("RSA");
		  cipher.init(1, getPublicKey(publicKeyStr));
		  byte[] enBytes = cipher.doFinal(content.getBytes(DEFAULT_CHARSET));
		  return Base64Tools.encode2String(enBytes);
	  }
	  
	  public static String decrypt(String content, String privateKeyStr)throws Exception{
		  Cipher cipher = Cipher.getInstance("RSA");
		  cipher.init(2, getPrivateKey(privateKeyStr));
		  byte[] deBytes = cipher.doFinal(Base64Tools.decode2Byte(content));
		  return new String(deBytes, DEFAULT_CHARSET);
	  }
	  
	  public static PublicKey getPublicKey(String key)throws Exception{
		  byte[] keyBytes = Base64Tools.decode2Byte(key);
		  X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		  KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		  PublicKey publicKey = keyFactory.generatePublic(keySpec);
		  return publicKey;
	  }
	  
	  public static PrivateKey getPrivateKey(String key)throws Exception{
		  byte[] keyBytes = Base64Tools.decode2Byte(key);
		  PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		  KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		  PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		  return privateKey;
	  }
	  
	  public static String getKeyString(Key key)throws Exception{
		  byte[] keyBytes = key.getEncoded();
		  return Base64Tools.encode2String(keyBytes);
	  }
	  
	  public static <T> String getSignatureContent(Map<String, T> params){
		  if (params == null) {
			  return null;
		  }
		  StringBuffer content = new StringBuffer();
		  @SuppressWarnings({ "rawtypes", "unchecked" })
		  List<String> keys = new ArrayList(params.keySet());
		  Collections.sort(keys);
		  for (int i = 0; i < keys.size(); i++){
			  String key = (String)keys.get(i);
			  if (params.get(key) != null){
				  String value = String.valueOf(params.get(key));
				  content.append((i == 0 ? "" : "&") + key + "=" + value);
			  }
		  }
		  return content.toString();
	  }
	  
	  @SuppressWarnings("unchecked")
	  public static String getListSignatureContent(@SuppressWarnings("rawtypes") List<Map> mapList){
		  if (mapList == null) {
			  return null;
		  }
		  @SuppressWarnings({ "rawtypes"})
		  List<String> listStr = new ArrayList();
		  for (Map<String, Object> map : mapList) {
			  listStr.add(getSignatureContent(map));
		  }
		  Collections.sort(listStr);
		  return listStr.toString();
	  }
}
