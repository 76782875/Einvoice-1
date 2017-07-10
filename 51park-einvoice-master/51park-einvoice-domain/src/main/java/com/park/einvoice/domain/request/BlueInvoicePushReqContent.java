package com.park.einvoice.domain.request;

/**
 * 蓝票票荣推送报文内容对象
 * @author WangYuefei
 *
 */
public class BlueInvoicePushReqContent {
	private String taxpayerNum,invoiceReqSerialNo,code,msg,tradeNo,
		securityCode,qrCode,invoiceCode,invoiceNo,invoiceDate,
		invoiceType,noTaxAmount,taxAmount,invoicePdf,downloadUrl;

	public String getTaxpayerNum() {
		return taxpayerNum;
	}

	public void setTaxpayerNum(String taxpayerNum) {
		this.taxpayerNum = taxpayerNum;
	}

	public String getInvoiceReqSerialNo() {
		return invoiceReqSerialNo;
	}

	public void setInvoiceReqSerialNo(String invoiceReqSerialNo) {
		this.invoiceReqSerialNo = invoiceReqSerialNo;
	}

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

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getNoTaxAmount() {
		return noTaxAmount;
	}

	public void setNoTaxAmount(String noTaxAmount) {
		this.noTaxAmount = noTaxAmount;
	}

	public String getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getInvoicePdf() {
		return invoicePdf;
	}

	public void setInvoicePdf(String invoicePdf) {
		this.invoicePdf = invoicePdf;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	
}
