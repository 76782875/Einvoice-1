package com.park.einvoice.domain.request;

public class BlueInvoiceRequest {
	private String tradeNo,parkId,invoiceAmount,buyerName,buyerTaxpayerNum,buyerAddress,
		buyerTel,buyerBankName,buyerBankAccount,casherName,reviewerName,
		takerName,takerTel,takerEmail;

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getParkId() {
		return parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}
	

	public String getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerTaxpayerNum() {
		return buyerTaxpayerNum;
	}

	public void setBuyerTaxpayerNum(String buyerTaxpayerNum) {
		this.buyerTaxpayerNum = buyerTaxpayerNum;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public String getBuyerTel() {
		return buyerTel;
	}

	public void setBuyerTel(String buyerTel) {
		this.buyerTel = buyerTel;
	}

	public String getBuyerBankName() {
		return buyerBankName;
	}

	public void setBuyerBankName(String buyerBankName) {
		this.buyerBankName = buyerBankName;
	}

	public String getBuyerBankAccount() {
		return buyerBankAccount;
	}

	public void setBuyerBankAccount(String buyerBankAccount) {
		this.buyerBankAccount = buyerBankAccount;
	}

	public String getCasherName() {
		return casherName;
	}

	public void setCasherName(String casherName) {
		this.casherName = casherName;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public String getTakerName() {
		return takerName;
	}

	public void setTakerName(String takerName) {
		this.takerName = takerName;
	}

	public String getTakerTel() {
		return takerTel;
	}

	public void setTakerTel(String takerTel) {
		this.takerTel = takerTel;
	}

	public String getTakerEmail() {
		return takerEmail;
	}

	public void setTakerEmail(String takerEmail) {
		this.takerEmail = takerEmail;
	}
	
}
