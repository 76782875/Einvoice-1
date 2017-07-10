package com.park.einvoice.domain.response;

/**
 * 蓝票 票通回应的报文信息
 * @author WangYuefei
 *
 */
public class BlueInvoiceResponse {
	
	private String code,msg,sign,serialNo;
	private BlueInvoiceReponseContent content;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public BlueInvoiceReponseContent getContent() {
		return content;
	}
	public void setContent(BlueInvoiceReponseContent content) {
		this.content = content;
	}
	
}
