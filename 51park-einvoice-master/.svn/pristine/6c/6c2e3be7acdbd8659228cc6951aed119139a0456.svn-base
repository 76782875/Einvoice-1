package com.park.einvoice.dao;

import org.springframework.stereotype.Repository;

import com.park.einvoice.dao.mybatis.MyBatisRepository;
import com.park.einvoice.domain.request.BlueInvoicePushReqContent;
import com.park.einvoice.domain.response.BlueInvoiceResultResponse;

@MyBatisRepository
@Repository(value="blueInvoicePushDao")
public interface BlueInvoicePushDao {

	/**
	 * 将票通推送回来的蓝票信息插入蓝票推送表
	 * @param invoicePushContent 推送的报文内容
	 */
	void insertInvoicePush(BlueInvoicePushReqContent invoicePushContent);

	/**
	 * 通过交易单号查询蓝票开具信息
	 * @param tradeNo
	 * @return
	 */
	BlueInvoiceResultResponse selectPushByIRSN(String invoiceReqSerialNo);

	/**
	 * 查询发票推送是否已经存在
	 * @param invoiceReqSerialNo 传入发票请求流水号
	 * @return 返回查询到的个数
	 */
	int selectInvoicePush(String invoiceReqSerialNo);
	
}
