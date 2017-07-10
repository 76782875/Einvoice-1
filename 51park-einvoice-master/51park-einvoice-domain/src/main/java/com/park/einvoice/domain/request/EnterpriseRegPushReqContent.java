package com.park.einvoice.domain.request;

public class EnterpriseRegPushReqContent {
	private String taxpayerNum, enterpriseName, platformCode, 
		registrationCode, authorizationCode;

	public String getTaxpayerNum() {
		return taxpayerNum;
	}

	public void setTaxpayerNum(String taxpayerNum) {
		this.taxpayerNum = taxpayerNum;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getPlatformCode() {
		return platformCode;
	}

	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}

	public String getRegistrationCode() {
		return registrationCode;
	}

	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	@Override
	public String toString() {
		return "EnterpriseRegPushReqContent [taxpayerNum=" + taxpayerNum + ", enterpriseName=" + enterpriseName
				+ ", platfromCode=" + platformCode + ", registrationCode=" + registrationCode + ", authorizationCode="
				+ authorizationCode + "]";
	}
}
