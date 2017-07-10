package com.park.einvoice.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author liuyang
 * 时间：2015年8月15日
 * 功能：处理XML的相关方法
 * 备注：
 */

public class XMLTool {
	/**
	 * 把xml字符串转成map
	 * @param xml
	 * @return
	 */
	public static Map<String, Object>xmlToMap(String xml){
		Document document;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();// 获取根节点
			for (@SuppressWarnings("unchecked")
			Iterator<Element> iterator = root.elementIterator(); iterator.hasNext();) {
				Element element = iterator.next();
				if(!element.getText().equals("")){
					map.put(element.getName(), element.getText());
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
	}
	 /**
     * 将xml字符串转换为JSON字符串
     * @param xmlString xml字符串
     * @return JSON字符串对象
     */
    public static String xml2json(String xmlString) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        net.sf.json.JSON json = xmlSerializer.read(xmlString);
        //使用xmlSerializer转换json字符串时，会将空值转化成了[]，为了取值时方便，需将[]替换成''
        String jsonStr = json.toString().replaceAll("\"", "\'")
        		.replaceAll("\\[\\[\\]\\]", "{}")
        		.replaceAll("\\[\\]", "''");
        return jsonStr;
    }
    /**
     * JSON字符串转换成XML字符串
     * @param jsonString
     * @return
     */
    public static String json2xml(String jsonString) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        return xmlSerializer.write(JSONSerializer.toJSON(jsonString));
        // return xmlSerializer.write(JSONArray.fromObject(jsonString));//这种方式只支持JSON数组
    }
}
