import java.util.HashMap;
import java.util.Map;

import com.park.einvoice.common.DataChangeTools;
import com.park.einvoice.common.HttpTools;
import com.park.einvoice.common.SignTools;

public class testQRCode {
	public static void main(String[] args){
		testQRCode testqrcode = new testQRCode();
		testqrcode.testGetQRCodeTest();
	}
    public void testGetQRCodeTest(){
    	String loginUrl = "http://localhost:8080/einvoice/getQRCode/getQRCode";
//    	String loginUrl ="http://alphaeinvoice.51park.cn/Einvoice/getQRCode/getQRCode";
		String loginparams = "{'tradeNo':'16011911353322653','parkId':'4443'}";
		Map<String,String> headers = getHeaders(loginparams,loginUrl);
		String result=HttpTools.HttpClientPost(loginUrl, loginparams, headers);
		System.out.println(result);
    }
    
    private Map<String, String> getHeaders(String loginparams, String loginUrl) {
    	String time = String.valueOf(System.currentTimeMillis()/1000);
        //String projectId = "saas";
        String projectId = "test";
    	Map<String, String> headers = new HashMap<String, String>(); 
    	Map<String, String> map = DataChangeTools.json2Map(loginparams);
    	System.out.println(map);
    	String linkparams=DataChangeTools.createLinkString(map);
    	System.out.println("加密之前："+time+loginUrl+"?"+linkparams);
    	String authorization = SignTools.encrypt(time+loginUrl+"?"+linkparams, "8257f71fc72d9e63911a052871fc4bed");
    	System.out.println("加密之后：" + authorization);
    	headers.put("Timestamp",time);  
    	headers.put("Authorization",authorization);  
    	headers.put("Projectid",projectId);  
    	return headers;
	}
}
