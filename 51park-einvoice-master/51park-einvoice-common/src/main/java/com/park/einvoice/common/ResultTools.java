package com.park.einvoice.common;

import java.util.List;

import com.park.einvoice.common.constants.CodeConstants;
import com.park.einvoice.domain.response.ObjectListResponse;
import com.park.einvoice.domain.response.ObjectResponse;
import com.park.einvoice.domain.response.Response;


public class ResultTools {

	/**
	 * 返回
	 * @return
	 */
	public static String setResponse(String code){
		
		Response response =new Response();
		response.setCode(code);
		response.setMsg(CodeConstants.getName(code));
		return DataChangeTools.bean2gson(response);	
	}
	/**
	 * 
	 * @param code 
	 * @param object
	 * @return
	 */
	public static String setObjectResponse(String code,Object data){
		
		ObjectResponse response =new ObjectResponse();
		response.setCode(code);
		response.setMsg(CodeConstants.getName(code));
		response.setData(data);
		return DataChangeTools.bean2gson(response);	
	}
	/**
	 * 
	 * @param code 
	 * @param object
	 * @return
	 */
	public static String setObjectListResponse(String code,List<Object> data){
		
		ObjectListResponse response =new ObjectListResponse();
		response.setCode(code);
		response.setMsg(CodeConstants.getName(code));
		response.setData(data);;
		return DataChangeTools.bean2gson(response);	
	}
}
