package com.park.einvoice.common;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class OpenApiTools {
	private final String platformCode;
	private final String prefix;
	private final String password;
	private final String privateKey;
	  
	  public OpenApiTools(String password, String platformCode, String prefix, String privateKey)
	  {
	    this.password = password;
	    this.platformCode = platformCode;
	    this.prefix = prefix;
	    this.privateKey = privateKey;
	  }
	  
	  public String buildRequest(String content)
	  {
	    return OpenAPIUtil.buildRequestData(this.platformCode, this.prefix, content, this.password, this.privateKey);
	  }
	  
	  public String disposeResponse(String responseStr, String ptKey)
	  {
	    return OpenAPIUtil.disposeResponse(responseStr, ptKey, this.password);
	  }
	  
	  private static class OpenAPIUtil
	  {
	    private static final String VERSION = "1.0";
	    private static final String FORMAT = "JSON";
	    private static final String SIGNTYPE = "RSA";
	    @SuppressWarnings("unused")
		private static final String PLATFORMCODE_FIELD = "platformCode";
	    @SuppressWarnings("unused")
		private static final String SIGNTYPE_FIELD = "signType";
	    private static final String SIGN_FIELD = "sign";
	    @SuppressWarnings("unused")
		private static final String FORMAT_FIELD = "format";
	    @SuppressWarnings("unused")
		private static final String TIMESTAMP_FIELD = "timestamp";
	    @SuppressWarnings("unused")
		private static final String VERSION_FIELD = "version";
	    @SuppressWarnings("unused")
		private static final String SERIALNO_FIELD = "serialNo";
	    private static final String CONTENT_FIELD = "content";
	    
	    public static String buildRequestData(String platformCode, String prefix, String content, String password, String privateKey)
	    {
	      @SuppressWarnings({ "rawtypes", "unchecked" })
		Map<String, String> map = new HashMap();
	      
	      String reqContent = SecurityTools.encrypt3DES(password, content);
	      map.put("platformCode", platformCode);
	      map.put("signType", SIGNTYPE);
	      map.put("format", FORMAT);
	      map.put("version", VERSION);
	      map.put("content", reqContent);
	      map.put("timestamp", DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
	      map.put("serialNo", UUIDTools.getSerialNo(prefix));
	      map.put("sign", RSATools.sign(RSATools.getSignatureContent(map), privateKey));
	      return DataChangeTools.bean2gson(map);
	    }
	    
	    public static String disposeResponse(String jsonStr, String publicKey, String password)
	    {
	      JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();
	      Map<String, String> map = DataChangeTools.json2Map(jsonStr);
	      String sign = (String)map.remove(SIGN_FIELD);
	      if (RSATools.verify(RSATools.getSignatureContent(map), sign, publicKey))
	      {
	        String plainContent = SecurityTools.decrypt3DES(password, (String)map.get(CONTENT_FIELD));
	        jsonObject.add("content", new JsonParser().parse(plainContent));
	      }
	      else
	      {
	        throw new IllegalStateException("验签失败");
	      }
	      return jsonObject.toString();
	    }
	  }
	

}
