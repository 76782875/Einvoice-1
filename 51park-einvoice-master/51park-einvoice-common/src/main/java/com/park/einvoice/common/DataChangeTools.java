package com.park.einvoice.common;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class DataChangeTools{
	private static Logger logger = LoggerFactory.getLogger(DataChangeTools.class);
	
	/***
	 * gson 转bean
	 * @param params
	 * @param object
	 * @param gson
	 * @return
	 */
	public static <T> T gson2bean(String params,Class<T> clazz){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			 gson =new GsonBuilder().serializeNulls().create();
		try {
			return gson.fromJson(params, clazz);
		} catch (Exception e) {
			logger.error("***  gson2bean 请求参数转换错误");
			logger.error("***  参数为"+params);
			logger.error("** "+e);
			return null;
		}
	}
	
	/***
	 * gson 转list
	 * @param params
	 * @param object
	 * @param gson
	 * @return
	 */
	public static <T> T gson2List(String params,Type type){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		try {
			return gson.fromJson(params, type);
		} catch (Exception e) {
			logger.error("***  gson2List请求参数转换错误");
			logger.error("** "+e);
			return null;
		}
	}
	/**
	 * bean转gson
	 * @param <T>
	 */
	public static <T> String bean2gson(Object object){
		Gson gson =new Gson();
		return gson.toJson(object);
	}
	
	/** 
     * 将json格式封装的字符串数据转换成java中的Map数据 
	 * @param <T>
     * @return 
     */  
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> Map<String, String> json2Map(String params) {
        Gson gson =new Gson();
        return (Map)gson.fromJson(params, new TypeToken<T>() {}.getType());
    } 
    /** 
     * 将json格式封装的字符串数据转换成java中的Map数据 
     * @return 
     */  
    public static Map<String, String> json2Map2(String params) {  
    	HashMap<String, String> data = new HashMap<String, String>();  
        // 将json字符串转换成jsonObject  
        JSONObject jsonObject = JSONObject.parseObject(params); 
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            String key = String.valueOf(entry.getKey());  
            String value =String.valueOf(entry.getValue());  
            data.put(key, value);  
        }
        return data;  
    } 
    /** 
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串  
	 * @param params 需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);
			if (StringUtils.isBlank(value)) {
				continue;
			}else {
				if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
					prestr = prestr + key + "=" + value;
				} else {
					prestr = prestr + key + "=" + value + "&";
				}
			}
		}
		return prestr;
	}
}
