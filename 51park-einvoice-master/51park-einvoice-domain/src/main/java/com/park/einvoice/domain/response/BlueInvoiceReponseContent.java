package com.park.einvoice.domain.response;

/**
 * 蓝票 票通回应的报文的内容对象
 * @author WangYuefei
 *
 */
public class BlueInvoiceReponseContent {

	private String invoiceReqSerialNo,qrCodePath,qrCode;

	public String getInvoiceReqSerialNo() {
		return invoiceReqSerialNo;
	}

	public void setInvoiceReqSerialNo(String invoiceReqSerialNo) {
		this.invoiceReqSerialNo = invoiceReqSerialNo;
	}

	public String getQrCodePath() {
		return qrCodePath;
	}

	public void setQrCodePath(String qrCodePath) {
		this.qrCodePath = qrCodePath;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	@Override
	public String toString() {
		return "BlueInvoiceResponse [invoiceReqSerialNo=" + invoiceReqSerialNo + ", qrCodePath=" + qrCodePath
				+ ", qrCode=" + qrCode + "]";
	}
	
}
