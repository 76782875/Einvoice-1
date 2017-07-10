package com.park.einvoice.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.park.einvoice.domain.response.GetQRCodeRespContent;

@Repository(value="getQRCodeService")
public interface GetQRCodeService {
	
	/**
	 * 获取invoice对象所有信息
	 */
	public void getInvoiceInfo();
	
	/**
	 * 获取开票二维码1.0版本，仅支持子订单号
	 * @param content 请求体，包含了子订单号和停车场id的JSON字符串
	 * @return 返回JSON字符串，内容为开票二维码的信息
	 */
	public String getQRCode(String content);
	
	/**
	 * 获取开票二维码2.0版本，通过主订单号获取
	 * @param content 请求体，包含了主订单号和停车场id的json字符串
	 * @return 返回JSON字符串，内容为开票二维码的信息
	 */
	public String getQRCodeByMain(String content);
	
	/**
	 * 向票通发送获取开票二维码的请求
	 * @param paramMap 存储了所有请求参数的map
	 * @return 返回票通响应回来的报文的content部分的对象 GetQRCodeRespContent
	 */
	public GetQRCodeRespContent sendQRCodeRequest(Map<String, String> paramMap);
	
}
