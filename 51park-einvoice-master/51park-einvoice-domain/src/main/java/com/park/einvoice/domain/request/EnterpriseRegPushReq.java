package com.park.einvoice.domain.request;

public class EnterpriseRegPushReq {
	private String platformCode, signType, sign, format, timestamp, 
		version, serialNo;
	private EnterpriseRegPushReqContent content;
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
	public EnterpriseRegPushReqContent getContent() {
		return content;
	}
	public void setContent(EnterpriseRegPushReqContent content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "EnterpriseRegPushReq [platformCode=" + platformCode + ", signType=" + signType + ", sign=" + sign
				+ ", format=" + format + ", timestamp=" + timestamp + ", version=" + version + ", serialNo=" + serialNo
				+ ", content=" + content + "]";
	}
}
