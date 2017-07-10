package com.park.einvoice.domain.request;

/**
 * 蓝票票通推送报文对象
 * @author WangYuefei
 *
 */
public class BlueInvoicePushReq {
	private String platformCode,signType,sign,format,timestamp,version,
		serialNo;
	private BlueInvoicePushReqContent content;
	public String getPlatformCode() {
		return platformCode;
	}
	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public BlueInvoicePushReqContent getContent() {
		return content;
	}
	public void setContent(BlueInvoicePushReqContent content) {
		this.content = content;
	}
	
}
