package com.park.einvoice.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpTools {
	
	private static Logger logger = LoggerFactory.getLogger(HttpTools.class);	
    /**
     * HttpClient的post请求
     * @param sendurl
     * @param data
     * @return
     */
    public static String HttpClientPost(String sendurl, String data,Map<String, String> map){
    	 // 创建默认的httpClient实例.    
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        //POST的URL  
        HttpPost httppost = new HttpPost(sendurl);  
        if (null !=map) {
    		for (Map.Entry<String, String> entry : map.entrySet()) {  
    			httppost.setHeader(entry.getKey(), entry.getValue()); 
        	}  
         }
        //建立一个NameValuePair数组，用于存储欲传送的参数  
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("params", data));  
        UrlEncodedFormEntity uefEntity;  
        HttpEntity entity;
        String result="";
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            httppost.setEntity(uefEntity);  
//          RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();//设置请求和传输超时时间
//          httppost.setConfig(requestConfig);
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                entity = response.getEntity();  
                if (entity != null) {  
                	result=EntityUtils.toString(entity, "UTF-8");                  
                } 
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        } 
        return result;
    }
    /**
     * HttpClient的get请求
     * @param sendurl
     * @param data
     * @return
     */
    public static String HttpClientGet(String sendurl, String data,Map<String, String> map){
    	CloseableHttpClient httpclient = HttpClients.createDefault();  
    	String result="";
        try {  
        	// 创建httpget.
        	HttpGet httpget=null;  
        	if (null==data || "".equals(data)) {
        		httpget = new HttpGet(sendurl); 
			}else {
				httpget = new HttpGet(sendurl+"?"+data); 
			}
        	if (null !=map) {
        		for (Map.Entry<String, String> entry : map.entrySet()) {  
        			httpget.setHeader(entry.getKey(), entry.getValue()); 
        			// logger.info("header 内容："+entry.getKey()+"----"+entry.getValue());
            	}  
             }
        	 logger.info("HttpClientGet请求链接 ：" + httpget.getURI());
             //System.out.println("executing request ：" + httpget.getURI());  
//             RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(200).setConnectTimeout(200).build();//设置请求和传输超时时间
//             httpget.setConfig(requestConfig);
             // 执行get请求.    
             CloseableHttpResponse response = httpclient.execute(httpget);  
             try {  
                 // 获取响应实体    
                 HttpEntity entity = response.getEntity();  
                 // 打印响应状态    
                 System.out.println(response.getStatusLine());  
                 if (entity != null) {  
                     result=EntityUtils.toString(entity,"UTF-8");
                 }  
             } finally {  
                 response.close();  
             }  
         } catch (ClientProtocolException e) {  
             e.printStackTrace();  
         } catch (ParseException e) {  
             e.printStackTrace();  
         } catch (IOException e) {  
             e.printStackTrace();  
         } finally {  
             // 关闭连接,释放资源    
             try {  
                 httpclient.close();  
             } catch (IOException e) {  
                 e.printStackTrace();  
             }  
         } 
         return result;
    }
    public static final int timeout = 10;
    
    public static String decodeParm(String param)throws UnsupportedEncodingException{
    	param = URLDecoder.decode(param, "UTF-8");
    	return param;
    }
    
    public static String post(String url){
    	return post(url, "");
    }
    
    public static String post(String url, String data){
    	return httpPost(url, data);
    }
    
    public static String post(String url, InputStream instream){
    	try{
    		HttpEntity entity = Request.Post(url).bodyStream(instream, ContentType.create("text/html", Consts.UTF_8)).execute().returnResponse().getEntity();
    		return entity != null ? EntityUtils.toString(entity) : null;
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public static String get(String url){
    	return httpGet(url);
    }
    
    private static String httpPost(String url, String data){
    	try{
    		HttpEntity entity = Request.Post(url).bodyString(data, ContentType.create("text/html", Consts.UTF_8)).execute().returnResponse().getEntity();
    		return entity != null ? EntityUtils.toString(entity) : null;
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public static String postFile(String url, File file){
    	return postFile(url, null, file);
    }
    
    public static String postFile(String url, String name, File file){
    	try{
    		HttpEntity reqEntity = MultipartEntityBuilder.create().addBinaryBody(name, file).build();
    		Request request = Request.Post(url);
    		request.body(reqEntity);
    		HttpEntity resEntity = request.execute().returnResponse().getEntity();
    		return resEntity != null ? EntityUtils.toString(resEntity) : null;
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public static String postJson(String url, String json){
    	try{
    		HttpEntity entity = Request.Post(url).bodyString(json, ContentType.create("application/json", Consts.UTF_8)).execute().returnResponse().getEntity();
    		return entity != null ? EntityUtils.toString(entity) : null;
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public static byte[] getFile(String url){
    	try{
    		Request request = Request.Get(url);
    		HttpEntity resEntity = request.execute().returnResponse().getEntity();
    		return EntityUtils.toByteArray(resEntity);
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
    
    private static String httpGet(String url){
      try{
        HttpEntity entity = Request.Get(url).execute().returnResponse().getEntity();
        return entity != null ? EntityUtils.toString(entity, "UTF-8") : null;
      }catch (Exception e){
        e.printStackTrace();
      }
      return null;
    }
}
