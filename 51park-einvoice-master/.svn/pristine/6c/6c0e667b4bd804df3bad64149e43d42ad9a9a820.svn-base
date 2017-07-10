package com.park.einvoice.service;

import org.springframework.stereotype.Repository;

@Repository(value="blueInvoiceService")
public interface BlueInvoiceService {
	
	/**
	 * 无忧应用查看蓝票开具情况
	 * @param requestJsonStr
	 * @return
	 */
	public String searchInvoiceResult(String requestJsonStr);
	
	/**
	 * 获取蓝票
	 * @return 返回结果JSON串
	 */
	public String blueInvoice(String requestJsonStr);

	/**
	 * 获取发票properties文件信息的方法
	 */
	void getInvoiceInfo();

	/**
	 * 发送开具蓝票请求后，接收蓝票推送的内容并进行处理
	 * @param requestJsonStr
	 * @return
	 */
	public String dealBlueInvoicePush(String requestJsonStr);

}
